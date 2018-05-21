package com.sauzny.sb_neo4j_demo.mymovies;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.sb_neo4j_demo.mymovies.domain.User;
import com.sauzny.sb_neo4j_demo.mymovies.service.UserService;

@Component
public class MyMovieTest {

    @Autowired
    private UserService userService;
    
    @PostConstruct
    public void foo01(){
        this.testInitData();
    }
    
    /**
     * 因为是通过http连接到Neo4j数据库的，所以要预先启动Neo4j：neo4j console
     */
    public void testInitData(){
        userService.initData();
    }
    public void testGetUserByName(){
        User user = userService.getUserByName("John Johnson");
        System.out.println(user);
    }
}
