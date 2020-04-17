package com.sauzny.sbkafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

/***************************************************************************
 *
 * @时间: 2019/9/30 - 14:33
 *
 * @描述: TODO
 *
 ***************************************************************************/
@SpringBootApplication
public class KafkaDemoApp {

    //org.springframework.boot.autoconfigure.kafka.KafkaProperties

    public static void main(String[] args) {
        //org.apache.kafka.common.serialization.
        //org.springframework.kafka.support.serializer.JsonSerializer
        SpringApplication app = new SpringApplication(KafkaDemoApp.class);
        // 打印PID
        // 配置文件中可以设置文件打印路径，文件默认位置是项目当前目录application.pid
        // 执行测试用例的话，是不执行此处代码的
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("test_topic1")
                .compact()
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("test_topic2")
                .compact()
                .build();
    }

    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name("test_topic3")
                .compact()
                .build();
    }

}
