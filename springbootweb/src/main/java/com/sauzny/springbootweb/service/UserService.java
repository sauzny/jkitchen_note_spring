package com.sauzny.springbootweb.service;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.sauzny.springbootweb.dao.RoleDao;
import com.sauzny.springbootweb.entity.dto.UserDTO;
import com.sauzny.springbootweb.entity.pojo.Role;
import com.sauzny.springbootweb.utils.vo.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sauzny.springbootweb.dao.UserDao;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.entity.pojo.UserExample;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserDao userDao;


    public Page<User> findByExamplePage(int pageNum, int pageSize, String phone, Integer status, String username) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        
        if(StringUtils.isNotBlank(phone)) criteria.andPhoneLike(phone + "%");
        if(status != null && status > 0) criteria.andStatusEqualTo(status);
        if(StringUtils.isNotBlank(username)) criteria.andUsernameEqualTo(username);

        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userDao.selectByExample(example));
    }

    
    public User findByUsername(String username){

        User user = null;
        
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        
        List<User> userList = userDao.selectByExample(example);
        
        if(!userList.isEmpty()){
            user = userList.get(0);
        }
        
        return user;
    }

    public UserDTO findUserInfoByUserId(int userId){
        Map<Object, Object> map = Maps.newHashMap();
        map.put("userId", userId);
        return userDao.findUserInfo(map);
    }

    public User selectByPrimaryKey(int id){
        return userDao.selectByPrimaryKey(id);
    }

    @Transactional
    public int insertSelective(User user) {
        return userDao.insertSelective(user);
    }

    public int updateByPrimaryKeySelective(User user){
        return userDao.updateByPrimaryKeySelective(user);
    }

    public int deleteByPrimaryKey(int id){
        return userDao.deleteByPrimaryKey(id);
    }

    public int batchInsert(List<User> userList){
        return userDao.batchInsert(userList);
    }
    
}
