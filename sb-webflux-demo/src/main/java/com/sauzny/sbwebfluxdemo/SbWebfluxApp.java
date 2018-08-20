package com.sauzny.sbwebfluxdemo;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sauzny.sbwebfluxdemo.handler.EchoHandler;

@SpringBootApplication
public class SbWebfluxApp {

	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(EchoHandler echoHandler) {
		return route(POST("/echo"), echoHandler::echo);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SbWebfluxApp.class);
	}
}
