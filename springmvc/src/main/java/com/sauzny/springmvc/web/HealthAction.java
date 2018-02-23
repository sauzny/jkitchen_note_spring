package com.sauzny.springmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sauzny.springmvc.entity.pojo.TbUser;
import com.sauzny.springmvc.service.UserService;

/**
 * *************************************************************************
 * @文件名称: HealthAction.java
 *
 * @包路径  : com.sauzny.springmvc.web 
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   健康检查使用
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年9月1日 - 下午4:44:50 
 *	
 **************************************************************************
 */

@Controller
public class HealthAction extends BaseAction{

    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping(value = "/test01", method = {RequestMethod.POST, RequestMethod.GET})
    public TbUser test01(){
        
        logger.info("test01 被访问");
        
        TbUser tbUser = userService.selectOneById(1);
        
        logger.info(tbUser.getAccount());
        
        return tbUser;
    }
    

}
