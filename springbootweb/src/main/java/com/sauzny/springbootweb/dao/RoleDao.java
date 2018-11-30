package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.Role;

import java.util.List;

public interface RoleDao extends RoleMapper{

    int batchInsert(List<Role> roleList);
}
