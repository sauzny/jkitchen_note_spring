package com.sauzny.sbwebfluxdemo.system.bodyreader;

import java.util.List;

import org.assertj.core.util.Lists;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.ServerWebExchange;

import com.sauzny.sbwebfluxdemo.utils.ServerWebExchangeUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BodyReaderServerHttpResponseDecoratorWrapper extends ServerHttpResponseDecorator{

	private List<String> bodyString = Lists.newArrayList();
	
	public BodyReaderServerHttpResponseDecoratorWrapper(final ServerWebExchange serverWebExchange) {
		super(serverWebExchange.getResponse());
	}

	@Override
	public final Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
		
		this.bodyString = ServerWebExchangeUtils.body2String(Flux.from(body));
		
		return super.writeWith(body);
	}

	@Override
	public String toString() {
		return this.bodyString.toString();
	}
}
