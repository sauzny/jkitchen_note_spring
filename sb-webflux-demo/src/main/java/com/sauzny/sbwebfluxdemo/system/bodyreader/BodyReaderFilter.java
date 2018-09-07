package com.sauzny.sbwebfluxdemo.system.bodyreader;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
@Order(1)
public class BodyReaderFilter implements WebFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		BodyReaderServerWebExchangeDecoratorWrapper exchangeDecorator = new BodyReaderServerWebExchangeDecoratorWrapper(exchange);
		return chain.filter(exchangeDecorator);
	}

}
