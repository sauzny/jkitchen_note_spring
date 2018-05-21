package com.sauzny.sb_neo4j_demo.mymovies.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.sauzny.sb_neo4j_demo.mymovies.domain.Seen;

@Repository
public interface SeenRepository extends Neo4jRepository<Seen, Long> {
}
