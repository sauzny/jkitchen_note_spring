package com.sauzny.sbwebfluxdemo.system;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

import com.sauzny.sbwebfluxdemo.controller.vo.WebFluxResult;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
@Slf4j
public class WebFluxExceptionHandler implements WebExceptionHandler{

	@Override
	public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
		
		exchange.getAttributes().put("WebFluxExceptionHandler", ex);
		
        // 处理返回结果
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
        return WebFluxResult.failure().toMonoWithResponse(response);
	}
	
}
