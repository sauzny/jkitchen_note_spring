package com.sauzny.springbootweb.service;

import java.util.List;

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
        return userDao.findAll();
    }

    public Page<User> findByPage(int pageNo, int pageSize) {

        //return null;
        PageHelper.startPage(pageNo, pageSize);
        return userDao.findByPage();
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
}
