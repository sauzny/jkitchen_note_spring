package com.sauzny.sbwebfluxdemo.system.log;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.sauzny.sbwebfluxdemo.utils.ServerWebExchangeUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Order(2)
@Slf4j
public class WebFluxLogFilter implements WebFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		
		Long startTime = System.currentTimeMillis();
		
		ServerHttpRequest request = exchange.getRequest();
		ServerHttpResponse response = exchange.getResponse();
		
		// from request get something
	    InetSocketAddress remoteAddress = request.getRemoteAddress();
	    URI uri = request.getURI();
	    String methodValue = request.getMethodValue();
	    List<String> args = ServerWebExchangeUtils.body2String(request.getBody());
	    
	    Object result = new Object();
	    
	    response.beforeCommit(() -> {
	    	
		    Long timing = System.currentTimeMillis() - startTime;
		    
		    Object ex = exchange.getAttribute("WebFluxExceptionHandler");
		    if(ex != null) {
		    	log.error("WebFluxExceptionHandler", ex);
		    }
		    
			WebFluxLogRecord logRecord = new WebFluxLogRecord(remoteAddress, uri, methodValue, args, result, timing);
	        
	        log.info(logRecord.toJson());
	        
	    	return Mono.empty();
	    });
	    
        
		return chain.filter(exchange);
	}

}
