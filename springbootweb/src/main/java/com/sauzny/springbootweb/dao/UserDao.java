package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.User;

import java.util.List;

public interface UserDao extends UserMapper{

    int batchInsert(List<User> userList);
}
