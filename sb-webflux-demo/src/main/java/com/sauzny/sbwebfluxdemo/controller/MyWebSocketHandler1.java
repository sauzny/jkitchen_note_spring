package com.sauzny.sbwebfluxdemo.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class MyWebSocketHandler1 implements WebSocketHandler{
	
	@Override
    public Mono<Void> handle(WebSocketSession session) {
		return session.receive()            
                .doOnNext(message -> {
                	String wssid = session.getId();
                	String payload = message.getPayloadAsText(StandardCharsets.UTF_8);
                	log.info("current session id  = {} payload = {}", wssid, payload);
                })
                .concatMap(message -> {
                	log.info("Perform nested async operation using message content.");
                	return null;
                })
                .then();        
    }
}
