package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.dto.UserExt;
import com.sauzny.springbootweb.entity.pojo.User;

import java.util.List;

public interface UserDao extends UserMapper{

    UserExt findUserInfo(int userId);

    int batchInsert(List<User> userList);
}
