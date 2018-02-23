package com.sauzny.springboot01.db.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration  
public class AmqpConfig {  
  
    public static final String EXCHANGE   = "spring-boot-exchange";  
    public static final String ROUTINGKEY = "spring-boot-queueKey";  
  
    @Value("${mq.host}")  
    private String host;
    @Value("${mq.port}")  
    private String port;
    @Value("${mq.username}")  
    private String username;
    @Value("${mq.password}")  
    private String password;
    @Value("${mq.vhost}")  
    private String vhost;
    
    @Bean  
    public ConnectionFactory connectionFactory() {  
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();  
        connectionFactory.setAddresses(this.host+":"+this.port);  
        connectionFactory.setUsername(this.username);  
        connectionFactory.setPassword(this.password);  
        connectionFactory.setVirtualHost(this.vhost);  
        connectionFactory.setPublisherConfirms(true); //必须要设置  
        return connectionFactory;  
    }  
    
    /**  
     * 针对消费者配置  
     * 1. 设置交换机类型  
     * 2. 将队列绑定到交换机  
     *   
     *   
        FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念  
        HeadersExchange ：通过添加属性key-value匹配  
        DirectExchange:按照routingkey分发到指定队列  
        TopicExchange:多关键字匹配  
     */  
    @Bean  
    public DirectExchange defaultExchange() {  
        return new DirectExchange(EXCHANGE);  
    }  
  
    @Bean  
    public Queue queue() {  
        return new Queue("spring-boot-queue", true); //队列持久  
  
    }  
  
    @Bean  
    public Binding binding() {  
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(AmqpConfig.ROUTINGKEY);  
    } 
    
    @Bean  
    @Scope("prototype")  
    //必须是prototype类型  
    public RabbitTemplate rabbitTemplate() {  
        RabbitTemplate template = new RabbitTemplate(connectionFactory());  
        return template;  
    }  
}  