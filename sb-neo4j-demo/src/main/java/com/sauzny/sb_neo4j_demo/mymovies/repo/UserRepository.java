package com.sauzny.sb_neo4j_demo.mymovies.repo;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sauzny.sb_neo4j_demo.mymovies.domain.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long>{
    
    @Query("MATCH (user:USERS {name:{name}}) RETURN user")
    User getUserByName(@Param("name") String name);

}
