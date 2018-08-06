package com.sauzny.springbootweb.dao;

import java.util.List;

import com.sauzny.springbootweb.entity.pojo.User;

public interface UserDao extends UserMapper{

    int batchInsert(List<User> userList);
}
