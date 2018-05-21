package com.sauzny.sb_neo4j_demo.mymovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMovieApp {

    public static void main(String[] args) {
        
        SpringApplication app = new SpringApplication(MyMovieApp.class);
        app.run(args);
    }
}
