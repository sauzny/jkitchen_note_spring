package com.sauzny.springboot01;
    
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration  
@ComponentScan  
@EnableAutoConfiguration 
@EnableScheduling  
@EnableAsync 

public class App /*implements EmbeddedServletContainerCustomizer*/ {
    
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        // 启东时，写PID文件，文件path可在 application.properties 中配置
        app.addListeners(new ApplicationPidFileWriter("PID"));
        app.run(args);
    }
    
    /*
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(52001);
    }   
    */
    /**
     * 备注是的代码，可以用来修改启动时server的端口，现在修改为在配置文件中设置
     */
}