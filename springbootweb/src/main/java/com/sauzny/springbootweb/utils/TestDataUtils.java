package com.sauzny.springbootweb.utils;

import org.apache.commons.lang3.RandomStringUtils;

import com.sauzny.springbootweb.entity.pojo.User;

public final class TestDataUtils {

    private TestDataUtils(){}
    
    public static User user(){
        User user = new User();

        user.setCreaterId(1L);
        user.setRoleId(2);
        
        user.setAccount(RandomStringUtils.randomAlphanumeric(6, 8));
        user.setPassword(RandomStringUtils.randomAlphanumeric(6, 12));
        user.setPhone(RandomStringUtils.randomNumeric(11));
        user.setSalt(RandomStringUtils.randomAlphanumeric(6, 8));
        user.setUserName(RandomStringUtils.randomAlphanumeric(4, 8));
        
        return user;
    }
    
    public static void main(String[] args) {
        System.out.println(JacksonUtils.nonNull().toJson(TestDataUtils.user()));
    }
}
