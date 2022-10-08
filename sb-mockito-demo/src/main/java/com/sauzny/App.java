package com.sauzny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        // 启动时，写PID文件，文件path可在 application.properties 中配置
        app.addListeners(new ApplicationPidFileWriter("PID"));
        app.run(args);
    }
}
