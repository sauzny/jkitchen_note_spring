package com.sauzny.springbootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 启动函数
 *
 */
@SpringBootApplication
// 扫描interface mapper
@MapperScan("com.sauzny.springbootweb.dao")
// 支持跨域
@CrossOrigin
public class SpringBootWeb {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootWeb.class);
        app.run(args);
    }
}
