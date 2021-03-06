package com.sauzny.sbutilsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class SpringUtilsApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringUtilsApp.class);
        // 打印PID
        // 配置文件中可以设置文件打印路径，文件默认位置是项目当前目录application.pid
        // 执行测试用例的话，是不执行此处代码的
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.err.println("启动另一个进程，5秒之后把我再启动起来")));
    }
}
