package com.sauzny.sb_neo4j_demo.mymovies.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import lombok.Data;

@Data
@NodeEntity(label = "MOVIES")
public class Movie {
    
    public Movie(String name){
        this.name = name;
    }
    
    @Id
    @GeneratedValue
    private Long nodeId;
    
    @Property(name="name")
    private String name;
}