package com.sauzny.sbshirodemo.dao;

import com.sauzny.sbshirodemo.entity.pojo.Permission;
import java.util.List;
import java.util.Map;

public interface PermissionDao extends PermissionMapper{

    List<Permission> selectByUserId(Map<String, Object> param);
}
