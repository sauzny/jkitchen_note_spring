package com.sauzny.springbootweb.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.entity.pojo.UserExample;

public interface UserDao extends UserMapper{

    // 获取所有数据
    List<User> findAll();

    // 分页查询
    Page<User> findByPage();
    
    // 分页查询带参数
    Page<User> findByExamplePage(UserExample example);
    
    int batchInsert(List<User> userList);
}
