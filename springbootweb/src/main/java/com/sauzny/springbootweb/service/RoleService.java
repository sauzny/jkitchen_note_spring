package com.sauzny.springbootweb.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.sauzny.springbootweb.dao.RoleDao;
import com.sauzny.springbootweb.dao.UserDao;
import com.sauzny.springbootweb.entity.pojo.Role;
import com.sauzny.springbootweb.entity.pojo.RoleExample;
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
 * @时间: 2018/11/28 - 14:20
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Service
@Slf4j
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> roleListWithoutUser(){
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(0);
        return roleDao.selectByExample(example);
    }

    public List<Role> roleListByUserIdList(List<Integer> userIdList){
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIn(userIdList);
        return roleDao.selectByExample(example);
    }

    public ListMultimap<Integer, Role> userId2rolesMap(List<Integer> userIdList){
        List<Role> roleList = this.roleListByUserIdList(userIdList);
        ListMultimap<Integer, Role> listMultimap = ArrayListMultimap.create();
        roleList.forEach(role -> listMultimap.put(role.getUserId(), role));
        return listMultimap;
    }

    public void insertSelective(Role role){
        roleDao.insertSelective(role);
    }

    @Transactional
    public void batchInsert(List<Role> roleList){
        roleDao.batchInsert(roleList);
    }
}
