package com.sauzny.sbshirodemo.controller;

import com.google.common.collect.Maps;
import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.controller.vo.RestFulResult;
import com.sauzny.sbshirodemo.controller.vo.User4Passport;
import com.sauzny.sbshirodemo.entity.pojo.User;
import com.sauzny.sbshirodemo.service.UserService;
import com.sauzny.sbshirodemo.system.jwt.Audience;
import com.sauzny.sbshirodemo.utils.CodecUtils;
import com.sauzny.sbshirodemo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

/***************************************************************************
 *
 * @时间: 2019/1/21 - 10:38
 *
 * @描述: TODO
 *
 ***************************************************************************/

@RestController
@RequestMapping(SbwConstant.Controller.PASSPORT_CONTROLLER_MAPPING)
@Slf4j
public class PassportController {

    @Autowired
    private Audience audience;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RestFulResult login(@RequestBody User4Passport user){

        User targetUser = userService.findByUserName(user.getUserName());

        // 生成JWT
        String jwtId = CodecUtils.uuid();
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(audience.getExpiresSecond());
        Map<String, String> payloadClaims = Maps.newHashMap();
        payloadClaims.put(SbwConstant.Jwt.USER_ID, String.valueOf(targetUser.getUserId()));
        payloadClaims.put(SbwConstant.Jwt.USER_NAME, targetUser.getUserName());

        String token = JwtUtils.create(
                jwtId,
                Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()),
                payloadClaims,
                audience.getBase64Secret()
        );

        return RestFulResult.success(token);
    }

    @PostMapping("/logout")
    public RestFulResult logout(String username, String password){
        return RestFulResult.success();
    }

    @GetMapping("/unauth")
    public RestFulResult unauth(){
        return RestFulResult.failure(SbwConstant.FailureEnum.ACCESS_ILLEGAL);
    }
}
