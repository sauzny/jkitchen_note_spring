package com.sauzny.sb_neo4j_demo.marve01.repo;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sauzny.sb_neo4j_demo.marve01.domain.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long>{

    @Query("MATCH (person:PERSONS {name:{name}}) RETURN person")
    Person getPersonByName(@Param("name") String name);
    
    @Query("MATCH (:PERSONS {name:{name}}) - [r:IS_MATE_OF] -> (person) RETURN person")
    List<Person> getPersonMateByName(@Param("name") String name);
}
