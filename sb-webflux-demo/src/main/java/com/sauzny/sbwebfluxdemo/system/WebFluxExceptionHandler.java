package com.sauzny.sbwebfluxdemo.system;

import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.controller.vo.WebFluxResult;
import com.sauzny.sbwebfluxdemo.system.log.WebFluxLogRecord;
import com.sauzny.sbwebfluxdemo.utils.ServerWebExchangeUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
@Slf4j
public class WebFluxExceptionHandler implements WebExceptionHandler{

	@Override
	public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
		
        if(ex instanceof ResponseStatusException) {
        	return responseStatusException(exchange, (ResponseStatusException) ex);
        }else {
        	return Mono.empty();
        }

	}
	
	private static Mono<Void> responseStatusException (ServerWebExchange exchange, ResponseStatusException ex){

		ServerHttpRequest request = exchange.getRequest();
		
		InetSocketAddress remoteAddress = request.getRemoteAddress();
		URI uri = request.getURI();
        String methodValue = request.getMethodValue();
        
        // 组织参数
        List<Object> args = Lists.newArrayList("runtime error");
        args.add(request.getHeaders());
        
        String body = ServerWebExchangeUtils.body2String(request.getBody());
        args.add(body);

        // 打印error日志
        WebFluxLogRecord logRecord = new WebFluxLogRecord(remoteAddress, uri, methodValue, null, args, ex.getMessage(), null);
        log.error(logRecord.toJson());
        //ServerWebInputException
        
        // 处理返回结果
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        return response.writeWith(Flux.just(response.bufferFactory().wrap(WebFluxResult.failure().toJson().getBytes(StandardCharsets.UTF_8))));
        
        //return response.setComplete();
	}
}
