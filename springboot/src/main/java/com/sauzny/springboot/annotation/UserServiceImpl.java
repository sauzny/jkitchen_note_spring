package com.sauzny.springboot.annotation;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl {
    
    @Cacheable(key = "getUser", fieldKey = "#user.getUserId()")
    public void getUser(String userId) {
        log.info("UserServiceImpl getUser userId : {}", userId);
    }
    
}
