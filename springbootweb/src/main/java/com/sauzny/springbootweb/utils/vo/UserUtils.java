package com.sauzny.springbootweb.utils.vo;

import java.util.List;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.sauzny.springbootweb.controller.vo.PageContent;
import com.sauzny.springbootweb.controller.vo.User4Manager;
import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.utils.TimeUtils;

public final class UserUtils {

    private UserUtils(){}
    
    
    public static User4Manager user4Manager(User user){
        User4Manager user4Manager = new User4Manager();
        user4Manager.setId(String.valueOf(user.getId()));
        user4Manager.setCreateTime(TimeUtils.UDateToLocalDateTime(user.getCreateTime()).toString().replace("T", " "));
        user4Manager.setAccount(user.getAccount());
        user4Manager.setUserName(user.getUserName());
        user4Manager.setCompany(user.getCompany());
        user4Manager.setPhone(user.getPhone());
        return user4Manager;
    }
    

    public static List<User4Manager> user4ManagerList(List<User> userList){
        List<User4Manager> user4ManagerList = Lists.newArrayList();
        userList.forEach(user -> user4ManagerList.add(user4Manager(user)));
        return user4ManagerList;
    }

    public static PageContent<User4Manager> user4ManagerList(Page<User> page){
        PageContent<User4Manager> pageContent = PageContentUtils.pageContent(page);
        page.getResult().forEach(user -> pageContent.getContent().add(user4Manager(user)));
        return pageContent;
    }
    
}
