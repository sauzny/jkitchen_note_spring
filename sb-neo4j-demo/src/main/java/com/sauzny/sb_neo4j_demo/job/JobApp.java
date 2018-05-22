package com.sauzny.sb_neo4j_demo.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApp {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(JobApp.class);
        app.run(args);
    }
}
