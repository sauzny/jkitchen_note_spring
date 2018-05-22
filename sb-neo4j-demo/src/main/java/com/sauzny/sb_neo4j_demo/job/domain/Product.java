package com.sauzny.sb_neo4j_demo.job.domain;

import java.sql.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity(label="PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private Date createTime;

    @Relationship(type = "IS_BELONG_TO")
    private Consumer consumer;
}
