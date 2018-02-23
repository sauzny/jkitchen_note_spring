package com.sauzny.springboot01.webSocket;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//import com.sauzny.springboot01.service.MessagePushService;
import com.sauzny.springboot01.service.MessageService;

@Component
public class MyWebSocket extends TextWebSocketHandler {
  
    @Autowired  
    private MyWebSocketPool myWebSocketPool;  
  
    @Autowired
    private MessageService messageService;
    
    //@Autowired
    //private MessagePushService messagePushService;

    private final static String CONFIRMUSER_SPLIT = "~~~";
    private final static String SEND_SPLIT = "@@@";
    
    @Override  
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) { 
        
        // 从页面获取的数据
        String source = textMessage.getPayload();
        
        if(source.contains(CONFIRMUSER_SPLIT)){
            _confirmuser(source, session);
        }
        
        if(source.contains(SEND_SPLIT)){
            _send(source);
        }


        /*
        try {  
            TextMessage msg = new TextMessage("此内容 " + message.getPayload() + " 将放入队列中，等待处理...");  
            session.sendMessage(msg);  
        }catch (Exception e){  
            e.printStackTrace();
        }  
        */
    }  
    
    private void _confirmuser(String source, WebSocketSession session) {

        // 用户名
        String userName = source.split(CONFIRMUSER_SPLIT)[0];
        
        // 删除当前用户的旧session
        WebSocketSession oldSession = myWebSocketPool.get(userName);
        
        if(oldSession != null && !oldSession.getId().equals(session.getId())){
            // 注意 code 码的数值， 是有合法范围的
            CloseStatus status = new CloseStatus(2222, "当前用户的旧session，删除");
            try {
                // 删除当前用户的旧session
                //messagePushService.push(userName, "此用户在新的页面登录了");
                oldSession.close(status);
                myWebSocketPool.remove(userName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        // 放入池子
        if(oldSession == null){
            myWebSocketPool.put(userName, session);
        }
    }
    
    private void _send(String source){

        // 用户名
        String userName = source.split(SEND_SPLIT)[0];
        
        // 消息
        String message = source.split(SEND_SPLIT)[1];
        

        if(StringUtils.isBlank(userName) || StringUtils.isBlank(message)){
            return;
        }
        
        // 放入队列
        messageService.pull(userName, message);
    }
    
    // websocket 建立连接之后
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        
        /*
        Map<String, Object> map = session.getAttributes();
        
        for(Map.Entry<String, Object> entry: map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        */
        
    } 
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        
        // 关闭ws的时候  触发的方法
        myWebSocketPool.remove(session);
    }
    
    

}