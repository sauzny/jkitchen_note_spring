package com.sauzny.sbshirodemo.controller;

import com.sauzny.sbshirodemo.SbwConstant;
import com.sauzny.sbshirodemo.controller.vo.RestFulResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***************************************************************************
 *
 * @时间: 2019/1/21 - 16:14
 *
 * @描述: TODO
 *
 ***************************************************************************/

@RestController
@RequestMapping(SbwConstant.Controller.USER_CONTROLLER_MAPPING)
public class UserController {

    @GetMapping("/userList")
    public RestFulResult userList() {
        return RestFulResult.success();
    }

    @GetMapping("/userOne")
    @RequiresPermissions("systemRole")
    public RestFulResult userOne() {
        return RestFulResult.success();
    }

    @GetMapping("/help")
    public RestFulResult userHelp() {
        return RestFulResult.success();
    }
}
