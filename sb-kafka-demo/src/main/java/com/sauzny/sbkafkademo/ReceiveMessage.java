package com.sauzny.sbkafkademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveMessage {

    /**
     接下来在看看@KafkaListener的注解都提供了什么属性。

     id：消费者的id，当GroupId没有被配置的时候，默认id为GroupId
     containerFactory：上面提到了@KafkaListener区分单数据还是多数据消费只需要配置一下注解的containerFactory属性就可以了，这里面配置的是监听容器工厂，也就是ConcurrentKafkaListenerContainerFactory，配置BeanName
     topics：需要监听的Topic，可监听多个
     topicPartitions：可配置更加详细的监听信息，必须监听某个Topic中的指定分区，或者从offset为200的偏移量开始监听
     errorHandler：监听异常处理器，配置BeanName
     groupId：消费组ID
     idIsGroup：id是否为GroupId
     clientIdPrefix：消费者Id前缀
     beanRef：真实监听容器的BeanName，需要在 BeanName前加 "__"
     */

    @KafkaListener(topics = "ljx_topic1")
    public void listen(String data) {
        log.info("从卡夫卡中获取数据：{}", data);
    }

/*
    @Bean
    public KafkaListenerContainerFactory<Integer, String> kafkaJsonListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setMessageConverter(new JsonMessageConverter());
        return factory;
    }
*/

    @KafkaListener(topics = {"ljx_topic2", "ljx_topic3"}, containerFactory = "kafkaJsonListenerContainerFactory")
    public void jsonListener(String data) {

    }

}
