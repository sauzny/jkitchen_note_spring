package com.sauzny.springbootweb.controller;

import static com.sauzny.springbootweb.SbwConstant.Controller.USER_CONTROLLER_MAPPING;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.service.UserService;
import com.sauzny.springbootweb.utils.JacksonUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value=USER_CONTROLLER_MAPPING)
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("")
    public RestFulResult page(
            HttpServletRequest request,
            @RequestParam(required=true) Integer pageNo,
            @RequestParam(required=true) Integer pageSize
            ){
        
        List<User> list = userService.selectByExample();

        log.info("list, {}", JacksonUtils.nonNull().toJson(list) );
        
        Page<User> page = userService.findByPage(pageNo, pageSize);

        log.info("page, {}",JacksonUtils.nonNull().toJson(page) );
        log.info("page, {}",page );
        
        
        
        return RestFulResult.success();
    }
}
