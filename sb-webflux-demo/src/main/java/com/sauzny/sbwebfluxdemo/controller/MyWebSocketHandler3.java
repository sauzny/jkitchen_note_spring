package com.sauzny.sbwebfluxdemo.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class MyWebSocketHandler3 implements WebSocketHandler{
	
	@Override
    public Mono<Void> handle(WebSocketSession session) {
		
		Mono<Void> input = session.receive()            
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
		
		Flux<String> source = Flux.create(cityFluxSink -> {
			List<String> list = Lists.newArrayList();
			list.forEach(str -> {
                cityFluxSink.next(str);
            });
            cityFluxSink.complete();
        });
		
        Mono<Void> output = session.send(source.map(session::textMessage)); 

        return Mono.zip(input, output).then();     
    }
}
