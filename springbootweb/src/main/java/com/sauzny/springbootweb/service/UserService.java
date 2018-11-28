package com.sauzny.springbootweb.service;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.sauzny.springbootweb.entity.dto.UserExt;
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

    public List<User> findAll() {
        //return null;
        return userDao.selectByExample(null);
    }

    public Page<User> findByPage(int pageNo, int pageSize) {

        //return null;
        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> userDao.selectByExample(null));
    }

    public Page<User> findByExamplePage(int pageNum, int pageSize, String phone, String account, String username) {

        //return null;
        //PageHelper.startPage(pageNo, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        
        if(StringUtils.isNotBlank(phone)) criteria.andPhoneLike("%" + phone + "%");
        //if(roleId != null) criteria.andRoleIdEqualTo(roleId);
        if(StringUtils.isNotBlank(account)) criteria.andAccountEqualTo(account);
        if(StringUtils.isNotBlank(username))criteria.andUsernameEqualTo(username);
        //criteria.getAllCriteria().add(UserExt.andMutilStatusExist(2));

        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userDao.selectByExample(example));
    }

    public int deleteByPrimaryKey(int id){
        return userDao.deleteByPrimaryKey(id);
    }
    
    public List<User> selectByExample(){
        return userDao.selectByExample(null);
    }

    @Transactional
    public void insert(User user) {
        userDao.insert(user);
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

    public UserExt findUserInfoByUserId(int userId){
        Map<Object, Object> map = Maps.newHashMap();
        map.put("userId", userId);
        return userDao.findUserInfo(map);
    }

    public User selectByPrimaryKey(int id){
        return userDao.selectByPrimaryKey(id);
    }
    
    public int updateByPrimaryKeySelective(User record){
        return userDao.updateByPrimaryKeySelective(record);
    }
    
    public int batchInsert(List<User> userList){
        return userDao.batchInsert(userList);
    }
    
}
