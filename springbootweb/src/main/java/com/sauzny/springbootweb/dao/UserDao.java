package com.sauzny.springbootweb.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.entity.pojo.User;

public interface UserDao extends UserMapper{
    
    // 获取所有数据
    List<User> findAll();

    // 分页查询
    Page<User> findByPage();
}
