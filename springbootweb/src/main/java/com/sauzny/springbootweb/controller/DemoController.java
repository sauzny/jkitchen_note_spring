package com.sauzny.springbootweb.controller;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.service.UserService;
import com.sauzny.springbootweb.utils.vo.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.sauzny.springbootweb.SbwConstant.Controller.USER_CONTROLLER_MAPPING;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/11/20 - 14:37
 *
 * @描述: 旧的user接口
 *
 ***************************************************************************/

@RestController
@RequestMapping(value=USER_CONTROLLER_MAPPING)
@Slf4j
public class DemoController {

    @Autowired
    private UserService userService;

    @PostMapping("/del/{id}")
    public RestFulResult del(@PathVariable("id") int id){
        int result = userService.deleteByPrimaryKey(id);
        return RestFulResult.success(result);
    }

    @GetMapping("/saveTest")
    public RestFulResult saveTest(){

        List<User> userList = Lists.newArrayList();

        for(int i=0;i<100;i++){
            //userList.add(TestDataUtils.user());
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
