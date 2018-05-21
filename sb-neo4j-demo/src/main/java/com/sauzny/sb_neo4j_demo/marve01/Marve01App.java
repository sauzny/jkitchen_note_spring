package com.sauzny.sb_neo4j_demo.marve01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Marve01App {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Marve01App.class);
        app.run(args);
    }
}
