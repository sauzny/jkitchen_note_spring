package com.sauzny.sbwebfluxdemo.system.bodyreader;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

public class BodyReaderServerWebExchangeDecoratorWrapper extends ServerWebExchangeDecorator{

	private final ServerHttpRequestDecorator requestDecorator;
	
	protected BodyReaderServerWebExchangeDecoratorWrapper(ServerWebExchange serverWebExchange) {
		super(serverWebExchange); 
		this.requestDecorator = new BodyReaderServerHttpRequestDecoratorWrapper(serverWebExchange);
	}
	
	@Override
    public ServerHttpRequest getRequest() {
        return requestDecorator;
    }
}
