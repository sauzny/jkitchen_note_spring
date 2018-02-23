package com.sauzny.springboot01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.springboot01.db.rabbitmq.Producer;
import com.sauzny.springboot01.db.redis.JedisFactory;
import redis.clients.jedis.Jedis;

@Service
public class MessageService {

    public static final String SPLIT = "@@@";
    
    @Autowired
    private Producer producer;

    @Autowired
    private JedisFactory jedisFactory;
    
    
    public void pull(String userName, String message){
        
        String content = userName+MessageService.SPLIT+message;
        
        //System.out.println(message);
        
        // 插入 rabbitmq
        producer.sendMsg(content + " -- to rabbitmq");
        
        // 插入 redis
        try(Jedis jedis = jedisFactory.openJedis()) {
            
            jedis.rpush("testList01", content + " -- to redis");
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
