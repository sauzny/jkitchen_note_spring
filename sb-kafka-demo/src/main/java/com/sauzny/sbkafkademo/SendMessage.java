package com.sauzny.sbkafkademo;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class SendMessage<K, V> {

    @SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "SpringJavaAutowiredFieldsWarningInspection"})
    @Autowired
    // 这个代码封装的非常棒
    // K 是 key      用来计算数据落在哪个partition上
    // V 是 value    发送的数据
    private KafkaTemplate<K, V> template;

    // 异步发送
    public void asyncSend(String topic, K key, V data){

        // 这个发送记录封装的也很好
        // 按照实际需求构造实例
        final ProducerRecord<K, V> record = new ProducerRecord<>(topic, key,data);

        // sendh函数有几种实现
        template.send(record).addCallback(
                sendResult -> handleSuccess(sendResult, data),
                ex -> handleFailure(data, record, ex)
        );
    }

    // 同步发送
    public void syncSend(String topic, K key,V data){

        final ProducerRecord<K, V> record = new ProducerRecord<>(topic, key, data);

        try {
            SendResult<K, V> sendResult = template.send(record).get(10, TimeUnit.SECONDS);
            handleSuccess(sendResult, data);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            //e.printStackTrace();
            handleFailure(data, record, e);
        }

    }


    private void handleSuccess(SendResult sendResult, V data){

    }

    private void handleFailure(V data, ProducerRecord<K, V> record, Throwable ex){

    }
}
