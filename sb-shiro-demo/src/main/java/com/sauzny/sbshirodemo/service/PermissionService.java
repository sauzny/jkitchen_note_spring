package com.sauzny.sbshirodemo.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sauzny.sbshirodemo.dao.PermissionDao;
import com.sauzny.sbshirodemo.dao.PermissionMapper;
import com.sauzny.sbshirodemo.entity.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***************************************************************************
 *
 * @时间: 2018/12/28 - 10:05
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public List<String> selectPermissionByUserId(long userId){
        List<String> result = Lists.newArrayList();
        Map<String, Object> param = Maps.newHashMap();
        param.put("userId", userId);
        List<Permission> permissionList = permissionDao.selectByUserId(param);
        result.addAll(permissionList.stream().map(Permission::getPermission).collect(Collectors.toList()));
        return result;
    }
}
