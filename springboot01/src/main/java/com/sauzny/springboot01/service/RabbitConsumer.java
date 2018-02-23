package com.sauzny.springboot01.service;

import java.util.Random;

import org.springframework.amqp.core.AcknowledgeMode;  
import org.springframework.amqp.core.Message;  
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;  
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;

import com.sauzny.springboot01.db.rabbitmq.AmqpConfig;

@Configuration 
public class RabbitConsumer extends AmqpConfig {  
  
    @Autowired
    private MessagePushService messagePushService; 
    
    @Value("${rabbitmq.sleeptime}")  
    private String sleeptime;
  
    @Bean  
    public SimpleMessageListenerContainer messageContainer() {  
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());  
        container.setQueues(queue());  
        container.setExposeListenerChannel(true);  
        container.setMaxConcurrentConsumers(4);  
        container.setConcurrentConsumers(4);  
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认  
        container.setMessageListener(new ChannelAwareMessageListener() {  
  
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();  
                String messageBody = new String(body);
                //System.out.println("receive msg : " + new String(body));  
                String[] key_value = messageBody.split(MessageService.SPLIT);
                
                // 模拟处理时间，
                Random random = new Random();
                int sleepTime = random.nextInt(Integer.parseInt(sleeptime));
                
                Thread.sleep(sleepTime);
                
                messagePushService.push(key_value[0], key_value[1]+" -- "+Thread.currentThread().getId() + " -- 数据从rabbit队列获取，处理使用时间 " + sleepTime + "毫秒");
                
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费  
                // TODO Auto-generated method stub
                
            }  
        });  
        return container;  
    }  

}
