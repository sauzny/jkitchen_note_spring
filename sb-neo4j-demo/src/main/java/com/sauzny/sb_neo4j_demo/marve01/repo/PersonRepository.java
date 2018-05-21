package com.sauzny.sb_neo4j_demo.marve01.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.sauzny.sb_neo4j_demo.marve01.domain.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long>{
    
}
