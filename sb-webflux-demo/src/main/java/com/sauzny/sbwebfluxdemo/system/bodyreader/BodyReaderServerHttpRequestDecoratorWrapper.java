package com.sauzny.sbwebfluxdemo.system.bodyreader;

import java.util.List;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.web.server.ServerWebExchange;

import com.google.common.primitives.Bytes;
import com.sauzny.sbwebfluxdemo.utils.ServerWebExchangeUtils;

import reactor.core.publisher.Flux;

public class BodyReaderServerHttpRequestDecoratorWrapper extends ServerHttpRequestDecorator{
	
	// 将 http body 的内容缓存在此 byte 数组中
	// 此处不能缓存 Flux<DataBuffer> 实例
	private final List<List<Byte>> bodyByteListList;
	
	// getBody()时使用的变量
	private final DataBufferFactory dataBufferFactory;
	
	public BodyReaderServerHttpRequestDecoratorWrapper(final ServerWebExchange serverWebExchange) {	
		
		super(serverWebExchange.getRequest());
		
		bodyByteListList = ServerWebExchangeUtils.body2byteList(super.getBody());
		
		dataBufferFactory = serverWebExchange.getResponse().bufferFactory();
		
	}
	
	@Override
    public Flux<DataBuffer> getBody(){

		return Flux.create(sink -> {
			bodyByteListList.forEach(bodyByteList -> {
				byte[] bytes = Bytes.toArray(bodyByteList);
				sink.next(this.dataBufferFactory.wrap(bytes));
            });
			sink.complete();
        });
		
	}
}
