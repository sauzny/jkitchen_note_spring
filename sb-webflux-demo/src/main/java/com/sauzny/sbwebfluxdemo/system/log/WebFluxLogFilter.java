package com.sauzny.sbwebfluxdemo.system.log;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
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
	    MediaType requestMediaType = request.getHeaders().getContentType();
	    
	    //exchange.getFormData();
	    
	    // query params
	    MultiValueMap<String, String> queryParams = request.getQueryParams();
	    
	    // body
	    List<String> requestBody = ServerWebExchangeUtils.body2String(request.getBody());
	    
	    
	    response.beforeCommit(() -> {
	    	
	    	MediaType responseMediaType = response.getHeaders().getContentType();
	    	
		    String result = response.toString();
	    	
		    Object exMessage = exchange.getAttribute("WebFluxExceptionMessage");
		    Object exResult = exchange.getAttribute("WebFluxExceptionResult");
		    if(exMessage != null) {
		    	result = exMessage + " | " + exResult;
		    }
		    
			WebFluxLogRecord logRecord = new WebFluxLogRecord(remoteAddress, uri, methodValue, requestMediaType, queryParams, requestBody, responseMediaType, result, System.currentTimeMillis() - startTime);
	        
	        log.info(logRecord.toJson());
	        
	    	return Mono.empty();
	    });
	    
        
		return chain.filter(exchange);
	}

}
