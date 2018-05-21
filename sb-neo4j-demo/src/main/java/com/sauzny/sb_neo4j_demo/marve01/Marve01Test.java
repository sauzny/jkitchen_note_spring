package com.sauzny.sb_neo4j_demo.marve01;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.sb_neo4j_demo.marve01.service.PersonService;

@Component
public class Marve01Test {

    @Autowired
    private PersonService personService;
    
    @PostConstruct
    public void foo01(){
        this.testInitData();
    }
    
    /**
     * 因为是通过http连接到Neo4j数据库的，所以要预先启动Neo4j：neo4j console
     */
    public void testInitData(){
        personService.initData();
    }
}
