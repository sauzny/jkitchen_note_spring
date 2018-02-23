package com.sauzny.springboot01.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisConsumer {
    
    @Autowired
    private RedisConsumerWorker redisConsumerWorker;
    
    @PostConstruct
    public void init(){
        /**
         * 这个初始化，写在这的原因是  随便写的。我只是需要初始化一下doTask中的内容
         * 
         * 这里用了  redis blpop 作为队列的 consumer
         * 
         * 问题就是，blpop线程是阻塞的，如果我在RedisConsumerWorker类中直接初始化blpop的线程，会导致spring在初始化的工程中阻塞住（卡主），spring一直停住
         * 
         * 所以我使用了spring boot 中的  @Async ，实现异步的初始化
         * 
         * 然后需要找个位置执行 doTask ，因为是demo就随便找了个位置，写在这了
         * 
         */
        redisConsumerWorker.doTask();
    }
}
