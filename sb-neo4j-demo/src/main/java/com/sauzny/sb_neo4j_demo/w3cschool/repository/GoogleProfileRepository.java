package com.sauzny.sb_neo4j_demo.w3cschool.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.sauzny.sb_neo4j_demo.w3cschool.node.GoogleProfile;

public interface GoogleProfileRepository extends Neo4jRepository<GoogleProfile, Long>{ 
}
