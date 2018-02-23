package com.sauzny.springboot01.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.sauzny.springboot01.webSocket.MyWebSocketPool;

@Service
public class MessagePushService {
    
    @Autowired
    private MyWebSocketPool myWebSocketPool;

    @Autowired
    private CompleteMessageService completeMessageService;
    
    /**
     * @描述: 这里使用了 @Async， 这是 spring boot的异步调用任务
     * @param sessionId
     * @param content
     * @返回 void
     * @创建人  ljx 创建时间 2017年8月31日 下午2:56:39
     */
    @Async
    public void push(String userName, String message){
        
        TextMessage textMessage = new TextMessage(message);
        
        try {
            
            WebSocketSession session = myWebSocketPool.get(userName);
            
            if(session != null){
                
                System.out.println("MessagePushService：" + userName + " -- " + textMessage.getPayload());
                
                // 这里加了锁，这个锁是必须的
                /*
                                                如果不加锁，有可能出现[TEXT_PARTIAL_WRITING]错误。                                
                                                出现这个错的原因就是websocket中的session争抢
                                                所以加个锁
                                                这个问题的bug反馈地址 https://bz.apache.org/bugzilla/show_bug.cgi?id=56026
                                                但是tomcat开发者认为，这个问题应该业务研发人员自己解决，将这个bug定为无效bug
                */
                synchronized (session) {
                    
                    session.sendMessage(textMessage);
                }
                completeMessageService.insertPushedMessage(userName, message);
            }else{
                completeMessageService.insertUnPushedMessage(userName, message);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
