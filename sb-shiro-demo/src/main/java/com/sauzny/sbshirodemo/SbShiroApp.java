package com.sauzny.sbshirodemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 扫描interface mapper
@MapperScan("com.sauzny.sbshirodemo.dao")
// 使webfilter注解生效
@ServletComponentScan
public class SbShiroApp {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SbShiroApp.class);
        // 打印PID
        // 配置文件中可以设置文件打印路径，文件默认位置是项目当前目录application.pid
        // 执行测试用例的话，是不执行此处代码的
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }
}
