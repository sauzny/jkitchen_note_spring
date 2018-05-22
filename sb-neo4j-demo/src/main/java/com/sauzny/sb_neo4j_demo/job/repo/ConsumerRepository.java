package com.sauzny.sb_neo4j_demo.job.repo;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sauzny.sb_neo4j_demo.job.domain.Consumer;

@Repository
public interface ConsumerRepository extends Neo4jRepository<Consumer, Long>{

    // 1.找到m点和n点
    // 2.使用shortestPath函数
    // 3.关系[]部分说明 LEAD关系并且不限制步数
    
    @Query("MATCH (m:`CONSUMERS` { name:{mName} }),(n:`CONSUMERS` { name:{nName} }), p = shortestPath((m)-[r:LEAD*]-(n)) RETURN p;")
    List<Consumer> leadShortestPath(@Param("mName") String mName, @Param("nName") String nName);
    
    // LEAD关系并，并且5步之内
    // @Query("MATCH (m:`CONSUMERS` { name:{mName} }),(n:`CONSUMERS` { name:{nName} }), p = shortestPath((m)-[r:LEAD*..5]-(n)) RETURN p;")
    
    // 任意关系，5步之内
    // @Query("MATCH (m:`CONSUMERS` { name:{mName} }),(n:`CONSUMERS` { name:{nName} }), p = shortestPath((m)-[*..5]-(n)) RETURN p;")
    
    // 任意关系，任意步数
    // @Query("MATCH (m:`CONSUMERS` { name:{mName} }),(n:`CONSUMERS` { name:{nName} }), p = allShortestPaths((m)-[*]-(n)) RETURN p;")
    
    
    @Query("MATCH (:CONSUMERS {name:{name}}) <- [r:LEAD*..2] - (entity) RETURN entity")
    List<Consumer> leadShortestPath(@Param("name") String name);
}
