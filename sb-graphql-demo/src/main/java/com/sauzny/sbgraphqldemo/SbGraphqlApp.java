package com.sauzny.sbgraphqldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//扫描interface mapper
@MapperScan("com.sauzny.sbgraphqldemo.dao")
//支持跨域
@CrossOrigin
public class SbGraphqlApp {
    public static void main(String[] args) {
        //GraphQLWebAutoConfiguration
        //AbstractGraphQLHttpServlet
        //SimpleGraphQLHttpServlet
        SpringApplication app = new SpringApplication(SbGraphqlApp.class);
        app.run(args);
    }
}
