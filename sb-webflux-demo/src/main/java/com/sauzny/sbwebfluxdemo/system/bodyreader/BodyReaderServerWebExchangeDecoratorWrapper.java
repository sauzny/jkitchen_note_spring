package com.sauzny.sbwebfluxdemo.system.bodyreader;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

public class BodyReaderServerWebExchangeDecoratorWrapper extends ServerWebExchangeDecorator{

	private final ServerHttpRequestDecorator requestDecorator;
	private final ServerHttpResponseDecorator responseDecorator;
	
	protected BodyReaderServerWebExchangeDecoratorWrapper(ServerWebExchange serverWebExchange) {
		super(serverWebExchange); 
		this.requestDecorator = new BodyReaderServerHttpRequestDecoratorWrapper(serverWebExchange);
		this.responseDecorator = new BodyReaderServerHttpResponseDecoratorWrapper(serverWebExchange);
	}
	
	@Override
    public ServerHttpRequest getRequest() {
        return this.requestDecorator;
    }
	
	@Override
    public ServerHttpResponse getResponse() {
        return this.responseDecorator;
    }
}
