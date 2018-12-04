package com.sauzny.springbootweb.controller;

import static com.sauzny.springbootweb.SbwConstant.Controller.USER_CONTROLLER_MAPPING;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.Page;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.sauzny.springbootweb.controller.vo.PageContent;
import com.sauzny.springbootweb.controller.vo.UserVO;
import com.sauzny.springbootweb.entity.dto.UserDTO;
import com.sauzny.springbootweb.entity.pojo.Role;
import com.sauzny.springbootweb.service.RoleService;
import com.sauzny.springbootweb.service.UserRoleService;
import com.sauzny.springbootweb.utils.ControllerUtils;
import com.sauzny.springbootweb.utils.JacksonUtils;
import com.sauzny.springbootweb.utils.vo.RoleUtils;
import com.sauzny.springbootweb.utils.vo.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.controller.vo.RePassword;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.service.UserService;
import com.sauzny.springbootweb.utils.CodecUtils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Api(description = "用户服务")
@RestController
@RequestMapping(value=USER_CONTROLLER_MAPPING)
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation(value="添加用户")
    @PostMapping("")
    public RestFulResult save(@RequestBody UserVO userVO){
        userVO.setId(null);
        userRoleService.insertUserWithRoleList(userVO);
        return RestFulResult.success();
    }

    @ApiOperation(value="修改用户")
    @PutMapping("/updateInfo")
    public RestFulResult updateInfo(@RequestBody UserVO userVO){
        User user = UserUtils.user(userVO);
        userService.updateByPrimaryKeySelective(user);
        return RestFulResult.success();
    }

    @ApiOperation(value="用户信息", response = UserVO.class)
    @GetMapping("/info")
    public RestFulResult userInfo(HttpServletRequest request){

        int userId = ControllerUtils.getLoginUserId(request);

        UserDTO user = userService.findUserInfoByUserId(userId);
        log.debug("{}", JacksonUtils.nonNull().toJson(user));

        return RestFulResult.success(UserUtils.userDTO2VO(user));
    }

    @ApiOperation(value="修改用户密码")
    @PutMapping("/updatePassword")
    public RestFulResult updatePassword(@RequestBody RePassword rePassword){

        RestFulResult result = RestFulResult.failure();
        
        int userId = rePassword.getUserId();
        String oldPassword = rePassword.getOldPassword();
        String newPassword = rePassword.getNewPassword();
        
        User targetUser = userService.selectByPrimaryKey(userId);
        
        if(targetUser.getPassword().equals(CodecUtils.sha512(oldPassword+targetUser.getSalt()))){
            
            User record = new User();
            record.setId(userId);
            record.setPassword(CodecUtils.sha512(newPassword+targetUser.getSalt()));
            userService.updateByPrimaryKeySelective(record);
            
            result = RestFulResult.success();
        }else{
            result = RestFulResult.failure(SbwConstant.FailureEnum.USER_RESET_PASSWORD_NOT_MATCH);
        }

        return result;
    }

    @ApiOperation(value="用户分页列表", response = UserVO.class)
    @GetMapping("/page")
    public RestFulResult page(
            HttpServletRequest request,
            @ApiParam(name = "页码，从1开始", required = true, example="1")
            @RequestParam(required=true) Integer pageNum,
            @ApiParam(name = "每页数据条数", required = true, example="20")
            @RequestParam(required=true) Integer pageSize,
            @ApiParam(name = "手机号")
            @RequestParam(required=false) String phone,
            @ApiParam(name = "状态")
            @RequestParam(required=false) Integer status,
            @ApiParam(name = "用户名")
            @RequestParam(required=false) String username
    ){

        Page<User> page = userService.findByExamplePage(pageNum, pageSize, phone, status, username);

        PageContent<UserVO> userVOPage = UserUtils.userVOPage(page);

        if(!CollectionUtils.isEmpty(userVOPage.getContent())){

            List<Integer> userIdList = userVOPage.getContent().stream().mapToInt(UserVO::getId).boxed().collect(Collectors.toList());

            ListMultimap<Integer, Role> listMultimap = userRoleService.userId2rolesMap(userIdList);

            for (UserVO userVO : userVOPage.getContent()) {
                for (Role role : listMultimap.get(userVO.getId())) {
                    userVO.getRoles().add(role.getName());
                }
            }
        }

        return RestFulResult.success(userVOPage);
    }

}
