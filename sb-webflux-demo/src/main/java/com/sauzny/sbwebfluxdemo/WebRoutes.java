package com.sauzny.sbwebfluxdemo;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.controller.EchoController;

@Configuration
public class WebRoutes {

	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction1(EchoController echoController) {
		return route(POST("/echo1"), echoController::echo1);
	}
	
	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction2(EchoController echoController) {
		return route(POST("/echo2").and(accept(MediaType.APPLICATION_JSON)), echoController::echo2);
	}
	
	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction3(EchoController echoController) {
		return route(POST("/echo3").and(accept(MediaType.APPLICATION_JSON)), echoController::echo3);
	}
	
	// 路由器的定义应该有更简单的语法
	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction4(EchoController echoController) {
		
		List<RouterFunction<ServerResponse>> routeList = Lists.newArrayList(
				route(POST("/echo41").and(accept(MediaType.APPLICATION_JSON)), echoController::echo41),
				route(POST("/echo42").and(accept(MediaType.APPLICATION_JSON)), echoController::echo42),
				route(POST("/echo43").and(accept(MediaType.APPLICATION_JSON)), echoController::echo43)
				);
		
		RouterFunction<ServerResponse> route = routeList.get(0);
		
		for(int i=1; i<routeList.size(); i++) {
			route = route.and(routeList.get(i));
		}
		
		//route.filter(filterFunction);
		
		return route;
		
	}
}
