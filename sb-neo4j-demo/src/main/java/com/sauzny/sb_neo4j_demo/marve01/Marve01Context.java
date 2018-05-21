package com.sauzny.sb_neo4j_demo.marve01;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ComponentScan("org.neo4j.cineasts")
@EnableNeo4jRepositories("com.sauzny.sb_neo4j_demo.marve01.repo")
public class Marve01Context {
    
    @Bean
    public SessionFactory getSessionFactory() {
      return new SessionFactory(configuration(), "com.sauzny.sb_neo4j_demo.marve01.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() throws Exception {
      return new Neo4jTransactionManager(getSessionFactory());
    }
    
    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        // 使用http方式远程连接数据库
      return new org.neo4j.ogm.config.Configuration.Builder()
              .uri("http://neo4j:Database02@localhost:7474")
              .build();
    }
}
