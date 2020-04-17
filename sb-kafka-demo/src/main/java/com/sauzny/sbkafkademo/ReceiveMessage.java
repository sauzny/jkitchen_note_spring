package com.sauzny.sbkafkademo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.Map;

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


    @Bean("customKafkaListenerContainerFactory0")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> customKafkaListenerContainerFactory0(KafkaProperties properties) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();

        Map<String, Object> map =  properties.buildConsumerProperties();
        // 写不写都不影响启动
        //map.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, "org.apache.kafka.clients.consumer.RoundRobinAssignor");
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "ljx_group0");
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(map));
        return factory;
    }

    @KafkaListener(topics = "test_topic1", containerFactory = "customKafkaListenerContainerFactory0")
    public void listen(String data) {
        log.info("从卡夫卡中获取数据：{}", data);
    }

    @Bean("customKafkaListenerContainerFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> customKafkaListenerContainerFactory(KafkaProperties properties) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();

        Map<String, Object> map =  properties.buildConsumerProperties();
        map.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, "org.apache.kafka.clients.consumer.RoundRobinAssignor");

        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(map));
        factory.setConcurrency(2);
        factory.setBatchListener(true);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }


    @KafkaListener(topics = {"test_topic2", "test_topic3"}, containerFactory = "customKafkaListenerContainerFactory")
    public void jsonListener(String data) {
        log.info("从卡夫卡中获取数据：{}", data);
    }

}
