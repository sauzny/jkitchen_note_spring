package com.sauzny.sbwebfluxdemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import com.sauzny.sbwebfluxdemo.controller.MyWebSocketHandler1;
import com.sauzny.sbwebfluxdemo.controller.MyWebSocketHandler2;
import com.sauzny.sbwebfluxdemo.controller.MyWebSocketHandler3;

@Configuration
public class WebConfig {
	
    @Bean
    public HandlerMapping handlerMapping() {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/path1", new MyWebSocketHandler1());
        map.put("/path2", new MyWebSocketHandler2());
        map.put("/path3", new MyWebSocketHandler3());

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(map);
        mapping.setOrder(-1); // before annotated controllers
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
    
    // 对websocket服务的基本配置
    /*
    @Bean
    public WebSocketService webSocketService() {
    	ReactorNettyRequestUpgradeStrategy strategy = new ReactorNettyRequestUpgradeStrategy();
        strategy.upgrade(exchange, handler, subProtocol)
        return new HandshakeWebSocketService(strategy);
    }
    */
}
