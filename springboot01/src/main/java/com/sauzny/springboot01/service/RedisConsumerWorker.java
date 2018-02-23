package com.sauzny.springboot01.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sauzny.springboot01.db.redis.JedisFactory;
import redis.clients.jedis.Jedis;

@Service
public class RedisConsumerWorker {

    @Autowired
    private JedisFactory jedisFactory;
    
    @Autowired
    private MessagePushService messagePushService; 
    
    @Value("${redis.sleeptime}")  
    private String sleeptime;

    @Async
    public void doTask(){
        
        /**
         * 使用这种写法实现，4个线程blpop着redis
         * 
         * 尝试过其他写法，手动 new Worker等其他方式，无法实现
         */
        
        ExecutorService service = Executors.newFixedThreadPool(4);
        for(int i=0;i<4;i++){
            service.execute(new Worker(jedisFactory, messagePushService, sleeptime));
        }
    }
}

class Worker implements Runnable{

    private JedisFactory jedisFactory;
    
    private MessagePushService messagePushService; 
    
    private String sleeptime;

    public Worker(JedisFactory jedisFactory, MessagePushService messagePushService, String sleeptime) {
        this.jedisFactory = jedisFactory;
        this.messagePushService = messagePushService;
        this.sleeptime = sleeptime;
    }
    
    @Override
    public void run() {
        
        try(Jedis jedis = this.jedisFactory.openJedis()){
            while(true){
    
                List<String> list = jedis.blpop(1000, "testList01");
                
                for(String str : list){
                    if(str.equalsIgnoreCase("testList01")){
                        continue;
                    }
                    String[] key_value = str.split(MessageService.SPLIT);
                    
                    // 模拟处理时间
                    Random random = new Random();
                    int sleepTime = random.nextInt(Integer.parseInt(sleeptime));
                    Thread.sleep(sleepTime);
                    
                    messagePushService.push(key_value[0], key_value[1]+" -- "+Thread.currentThread().getId() + " -- 数据从redis队列获取，处理使用时间 " + sleepTime + "毫秒");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
