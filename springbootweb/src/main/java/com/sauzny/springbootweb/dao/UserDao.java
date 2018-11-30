package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.dto.UserDTO;
import com.sauzny.springbootweb.entity.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao extends UserMapper{

    UserDTO findUserInfo(Map<Object, Object> map);

    int batchInsert(List<User> userList);
}
