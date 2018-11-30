package com.sauzny.springbootweb.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import com.sauzny.springbootweb.controller.vo.User4Passport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.SbwConstant.FailureEnum;
import com.sauzny.springbootweb.SbwConstant.UserRole;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.service.UserService;
import com.sauzny.springbootweb.system.jwt.Audience;
import com.sauzny.springbootweb.utils.CodecUtils;
import com.sauzny.springbootweb.utils.ControllerUtils;
import com.sauzny.springbootweb.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Api(description = "账户服务")
@RestController(value = SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING)
@Slf4j
public class PassportController {

    @Autowired
    private Audience audience;
    
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value="登录")
    @PostMapping("/login")
    public RestFulResult login(@RequestBody User4Passport user, HttpServletRequest request) {
        
        String username = user.getUsername();
        String password = user.getPassword();
        String captcha = user.getCaptcha();
        
        // 参数合法性校验
        if(StringUtils.isBlank(username)) return RestFulResult.failure(FailureEnum.LOGIN_ACCOUNT_EMPTY);
        if(StringUtils.isBlank(password)) return RestFulResult.failure(FailureEnum.LOGIN_PASSWORD_EMPTY);
        if(audience.getNeedCaptcha() && StringUtils.isBlank(captcha)) return RestFulResult.failure(FailureEnum.CAPTCHA_EMPTY);

        // 校验验证码
        if(audience.getNeedCaptcha() && !ControllerUtils.checkCaptcha(captcha, request.getSession())){
            return RestFulResult.failure(FailureEnum.CAPTCHA_ILLEGAL);
        }
        
        User targetUser = userService.findByUsername(username);
        
        // 账号为空
        if(targetUser == null){
            return RestFulResult.failure(FailureEnum.LOGIN_NOT_MATCH);
        }
        
        // 密码不匹配
        log.debug("{}", CodecUtils.sha512(password+targetUser.getSalt()));
        if(!targetUser.getPassword().equals(CodecUtils.sha512(password+targetUser.getSalt()))){
            return RestFulResult.failure(FailureEnum.LOGIN_NOT_MATCH);
        }
        
        // 生成JWT
        String jwtId = CodecUtils.uuid();
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(audience.getExpiresSecond());
        Map<String, String> payloadClaims = Maps.newHashMap();
        payloadClaims.put(SbwConstant.Jwt.USER_ID, String.valueOf(targetUser.getId()));
        payloadClaims.put(SbwConstant.Jwt.USER_NAME, targetUser.getUsername());
        
        String token = JwtUtils.create(
                jwtId,
                Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()), 
                payloadClaims,
                audience.getBase64Secret()
                );
        
        // 退出的时候会删除redis中的数据
        stringRedisTemplate.opsForValue().set(jwtId, token, audience.getExpiresSecond(), TimeUnit.SECONDS);

        return RestFulResult.success(token);
    }

    @PostMapping("/logout")
    public RestFulResult logout(HttpServletRequest request){
        log.debug("JTI,{}", ControllerUtils.getJti(request));
        stringRedisTemplate.delete(ControllerUtils.getJti(request));
        return RestFulResult.success();
    }
    
    @GetMapping("/isLogin")
    public RestFulResult isLogin(HttpServletRequest request){
        // 逻辑在JwtFilter实现
        return RestFulResult.success();
    }
}
