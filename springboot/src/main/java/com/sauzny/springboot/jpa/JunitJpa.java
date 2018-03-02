package com.sauzny.springboot.jpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sauzny.springboot.BaseJUnit4Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JunitJpa extends BaseJUnit4Test{

    @Autowired
    private UserService userService;
    
    @Test
    public void testTransactional(){
        userService.testTransactional();
    }
    
    @Test
    public void batchInsert(){
        userService.batchInsert();
    }
    
    @Test
    public void batchUpdate(){
        userService.batchUpdate();
    }
    
    @Test
    public void save(){
        userService.save();
    }
}
