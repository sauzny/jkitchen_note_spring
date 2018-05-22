package com.sauzny.sb_neo4j_demo.job.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.sauzny.sb_neo4j_demo.job.domain.Product;

@Repository
public interface ProductRepository extends Neo4jRepository<Product, Long>{

}
