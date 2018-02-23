package com.sauzny.springboot01.webSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.google.common.collect.Maps;

import com.sauzny.springboot01.utils.MemoryUtils;

@Component
public class MyWebSocketPool {
    
    private Map<String, WebSocketSession> currentHashMap = new ConcurrentHashMap<String, WebSocketSession>();

    public WebSocketSession put(String key, WebSocketSession value){
        
        WebSocketSession webSocketSession = currentHashMap.put(key, value);
        
        System.out.println("session数量：" + currentHashMap.size() + "  内存占用：" + MemoryUtils.memory());
        
        return webSocketSession;
    }
    
    public WebSocketSession get(String key){
        return currentHashMap.get(key);
    }
    
    public WebSocketSession remove(String key){
        return currentHashMap.remove(key);
    }
    
    public void remove(WebSocketSession value){
        
        Map<String, String> map = Maps.newHashMap();
        
        for(Map.Entry<String, WebSocketSession>entry : currentHashMap.entrySet()){
            
            map.put(entry.getValue().getId(), entry.getKey());
            
        }
        
        currentHashMap.remove(map.get(value.getId()));
    }
}
