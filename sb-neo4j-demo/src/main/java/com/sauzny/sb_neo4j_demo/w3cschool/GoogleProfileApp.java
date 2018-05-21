package com.sauzny.sb_neo4j_demo.w3cschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GoogleProfileApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GoogleProfileApp.class);
        // 启东时，写PID文件，文件path可在 application.properties 中配置
        //app.addListeners(new ApplicationPidFileWriter("PID"));
        app.run(args);
    }
}
