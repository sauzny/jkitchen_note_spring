package com.sauzny.springboot01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import com.sauzny.springboot01.db.redis.JedisFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

@Service
public class CompleteMessageService {

    @Autowired
    private JedisFactory jedisFactory;
    
    /**
     * @描述: 记录session断掉，而未被push的消息
     * @返回 void
     * @创建人  ljx 创建时间 2017年9月5日 下午3:45:03
     */
    public void insertUnPushedMessage(String userName, String message){
        
        // 插入 redis
        try(Jedis jedis = jedisFactory.openJedis()) {
            
            jedis.rpush(userName+":UnPushedMessage", message);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    /**
     * @描述: 获取未被push的消息
     * @return
     * @返回 List<String>
     * @创建人  ljx 创建时间 2017年9月5日 下午3:40:33
     */
    @SuppressWarnings("unchecked")
    public List<String> getUnPushedMessage(String userName){
        
        List<String> list = Lists.newArrayList();
        
        // 插入 redis
        try(Jedis jedis = jedisFactory.openJedis()) {
            
            // 获取list中的所有数据
            
            // 这里使用了redis中的事务
            
            Transaction multi = jedis.multi();
            multi.lrange(userName+":UnPushedMessage", 0, -1);
            multi.del(userName+":UnPushedMessage");
            List<Object> exec = multi.exec();
            
            list = (List<String>) exec.get(0);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        return list;
    }
    
    /**
     * @描述: 记录被push的消息
     * @返回 void
     * @创建人  ljx 创建时间 2017年9月5日 下午3:44:40
     */
    public void insertPushedMessage(String userName, String message){
        
        // 插入 redis
        try(Jedis jedis = jedisFactory.openJedis()) {
            
            jedis.rpush(userName+":PushedMessage", message);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
    /**
     * @描述: 获取被push过的消息
     * @return
     * @返回 List<String>
     * @创建人  ljx 创建时间 2017年9月5日 下午3:40:48
     */
    public List<String> getPushedMessage(String userName){
        
        List<String> list = Lists.newArrayList();
        
        // 插入 redis
        try(Jedis jedis = jedisFactory.openJedis()) {
            
            // 获取list中的所有数据
            list = jedis.lrange(userName+":PushedMessage", 0, -1);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        return list;
        
    }

}
