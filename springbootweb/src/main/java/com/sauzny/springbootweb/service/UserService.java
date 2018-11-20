package com.sauzny.springbootweb.service;

import java.util.List;

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

    public Page<User> findByExamplePage(int pageNo, int pageSize, String phone, Integer roleId, String account, String username) {

        //return null;
        //PageHelper.startPage(pageNo, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        
        if(StringUtils.isNotBlank(phone)) criteria.andPhoneLike("%" + phone + "%");
        //if(roleId != null) criteria.andRoleIdEqualTo(roleId);
        if(StringUtils.isNotBlank(account)) criteria.andAccountEqualTo(account);
        if(StringUtils.isNotBlank(username))criteria.andUsernameEqualTo(username);
        //criteria.getAllCriteria().add(UserExt.andMutilStatusExist(2));
        

        return PageHelper.startPage(pageNo, pageSize).doSelectPage(() -> userDao.selectByExample(example));
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
    
    public User findByAccount(String account){
        
        User user = null;
        
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        
        List<User> userList = userDao.selectByExample(example);
        
        if(!userList.isEmpty()){
            user = userList.get(0);
        }
        
        return user;
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
