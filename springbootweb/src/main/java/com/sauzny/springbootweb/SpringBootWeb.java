package com.sauzny.springbootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动函数
 *
 */
@SpringBootApplication
@MapperScan("com.sauzny.springbootweb.dao")
public class SpringBootWeb {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootWeb.class);
        app.run(args);
    }
}
