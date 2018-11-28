package com.sauzny.springbootweb.controller;

import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.controller.vo.UserInfo;
import com.sauzny.springbootweb.entity.pojo.Role;
import com.sauzny.springbootweb.service.RoleService;
import com.sauzny.springbootweb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RoleInfo;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.sauzny.springbootweb.SbwConstant.Controller.ROLE_CONTROLLER_MAPPING;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/11/28 - 14:17
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Api(description = "角色服务")
@RestController
@RequestMapping(value = ROLE_CONTROLLER_MAPPING)
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "所有角色", response = RoleInfo.class)
    @GetMapping("/all")
    public RestFulResult userInfo(HttpServletRequest request) {

        List<Role> roleList = roleService.roleListWithoutUser();

        return RestFulResult.success(roleList);
    }
}
