package com.sauzny.sb_mybatis_mds.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import com.sauzny.sb_mybatis_mds.entity.pojo.Income;
import com.sauzny.sb_mybatis_mds.entity.pojo.User;


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
    
    public static Income income(){
        Income income = new Income();
        income.setCreateTime(Date.from(LocalDateTime.now().atZone(ZoneOffset.systemDefault()).toInstant()));
        return income;
    }
    
    public static void main(String[] args) {
        System.out.println(JacksonUtils.nonNull().toJson(TestDataUtils.user()));
    }
}
