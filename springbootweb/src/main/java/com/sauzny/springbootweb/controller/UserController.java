package com.sauzny.springbootweb.controller;

import static com.sauzny.springbootweb.SbwConstant.Controller.USER_CONTROLLER_MAPPING;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sauzny.springbootweb.controller.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.controller.vo.RePassword;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.service.UserService;
import com.sauzny.springbootweb.utils.CodecUtils;
import com.sauzny.springbootweb.utils.TestDataUtils;
import com.sauzny.springbootweb.utils.vo.UserUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value=USER_CONTROLLER_MAPPING)
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/page")
    public RestFulResult page(
            HttpServletRequest request,
            @RequestParam(required=true) Integer pageCurrent,
            @RequestParam(required=true) Integer pageSize,
            @RequestParam(required=false) String phone,
            @RequestParam(required=false) Integer roleId,
            @RequestParam(required=false) String account,
            @RequestParam(required=false) String userName
            ){
        
        //Page<User> page = userService.findByPage(bjuiPageCurrent, bjuiPageSize);
        Page<User> page = userService.findByExamplePage(pageCurrent, pageSize, phone, roleId, account, userName);
        
        //return BjuiPageContentUtils.user4ManagerPageContent(UserUtils.user4ManagerPage(page));
        return RestFulResult.success(UserUtils.user4ManagerPage(page));
        
    }

    @GetMapping("/info")
    public RestFulResult userInfo(){
        User user = userService.selectByPrimaryKey(1L);
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user.getUserName());
        userInfo.setRoles(Lists.newArrayList(1));
        return RestFulResult.success(userInfo);
    }
    
    @PutMapping("/updatePassword")
    public RestFulResult updatePassword(@RequestBody RePassword rePassword){

        RestFulResult result = RestFulResult.failure();
        
        long userId = rePassword.getUserId();
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
    
    @PostMapping("/del/{id}")
    public RestFulResult del(@PathVariable("id") long id){
        int result = userService.deleteByPrimaryKey(id);
        return RestFulResult.success(result);
    }
    
    @GetMapping("/saveTest")
    public RestFulResult saveTest(){
        
        List<User> userList = Lists.newArrayList();
        
        for(int i=0;i<100;i++){
            userList.add(TestDataUtils.user());
        }
        
        userService.batchInsert(userList);
        return RestFulResult.success();
    }
    
    @PostMapping("")
    public RestFulResult save(@RequestBody User user){
        log.debug("user : {}", user);
        //Integer.parseInt("aaaa");
        return RestFulResult.success();
    }

    @PutMapping("/updateInfo")
    public RestFulResult updateInfo(@RequestBody User user){
        log.debug("user : {}", user);
        return RestFulResult.success();
    }
}
