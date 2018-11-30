package com.sauzny.springbootweb.service;

import com.github.pagehelper.Page;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.sauzny.springbootweb.entity.dto.UserDTO;
import com.sauzny.springbootweb.entity.pojo.Role;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.utils.vo.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
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
 * @时间: 2018/11/29 - 17:54
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Service
@Slf4j
public class UserRoleService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Transactional
    public void insertUserWithRoleList(User user, List<Role> roleList){
        userService.insertSelective(user);
        roleService.batchInsert(roleList);
    }

    public ListMultimap<Integer, Role> userId2rolesMap(List<Integer> userIdList){
        return roleService.userId2rolesMap(userIdList);
    }

}
