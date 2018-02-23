package com.sauzny.springmvc.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sauzny.springmvc.entity.pojo.TbUser;
import com.sauzny.springmvc.service.UserService;
import com.sauzny.springmvc.Constants;

/**
 * *************************************************************************
 * @文件名称: LoginAction.java
 *
 * @包路径  : com.sauzny.springmvc.web 
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   TODO
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年9月18日 - 下午3:55:00 
 *	
 **************************************************************************
 */
@Controller
@RequestMapping("/login")
public class LoginAction extends BaseAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(
            HttpSession session,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "passwordhash", required = true) String passwordhash,
            @RequestParam(value = "captcha", required = true) String captcha
            ){
        
        String result = "";
        
        // 验证码校验
        String randomCode = (String) session.getAttribute(Constants.LOGIN_CAPTCHA);// 验证码session
        
        // 用户admin跳过验证码校验
        if(!username.equalsIgnoreCase("admin") && !captcha.equalsIgnoreCase(randomCode)){
            // 验证码错误
            result = "error";
        }
        
        List<TbUser> tbUserList = userService.selectByAccount(username);
        
        if(tbUserList.size() == 0){
            // 账号不存在
            result = "error";
        } else {
            TbUser tbUser = tbUserList.get(0);
            if(tbUser.getPasswd().equals(passwordhash)){
                // 验证通过
                result = "main";
                session.setAttribute("showName", tbUser.getShowName());
            }else{
                // 账号密码不匹配
                result = "error";
            }
        }
        
        return result;
    }
}
