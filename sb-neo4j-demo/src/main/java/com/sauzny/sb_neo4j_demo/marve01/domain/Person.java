package com.sauzny.sb_neo4j_demo.marve01.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity(label="PERSONS")
public class Person {

    public Person(){}

    public Person(String name){
        this.name = name;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @Relationship(type = "IS_LIKE_OF", direction=Relationship.UNDIRECTED)
    private List<Person> friends;
    
    @Relationship(type = "IS_MATE_OF", direction=Relationship.UNDIRECTED)
    private List<Person> teammates;
    
    @Relationship(type = "IS_BROTHER_OF", direction=Relationship.UNDIRECTED)
    private List<Person> brothers;
}
