package com.sauzny.sb_neo4j_demo.job.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@NodeEntity(label="CONSUMERS")
public class Consumer {

    public Consumer(String name, int level){
        this.name = name;
        this.level = level;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private Integer level;
    
    private LocalDateTime createTime = LocalDateTime.now();

    @Relationship(type = "IS_WORK_FOR")
    private List<Product> products;
    
    @Relationship(type = "LEAD")
    private List<Consumer> consumers;
}
