package com.sauzny.springbootweb.utils.vo;

import com.google.common.collect.Lists;
import com.sauzny.springbootweb.controller.vo.UserVO;
import com.sauzny.springbootweb.entity.pojo.Role;

import java.util.List;
import java.util.stream.Collectors;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/11/29 - 16:07
 *
 * @描述: TODO
 *
 ***************************************************************************/
public final class RoleUtils {

    private RoleUtils(){}

    public static List<Role> roleList(UserVO userVO){

        return userVO.getRoles().stream().map(roleName ->{
            Role role = new Role();
            role.setName(roleName);
            role.setUserId(userVO.getId());
            return role;
        }).collect(Collectors.toList());
    }
}
