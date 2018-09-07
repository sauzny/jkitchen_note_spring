package com.sauzny.sbwebfluxdemo.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;

import com.google.common.collect.Lists;
import com.google.common.primitives.Bytes;

import reactor.core.publisher.Flux;

public final class ServerWebExchangeUtils {

	private ServerWebExchangeUtils() {}
	
	public static List<String> body2String(Flux<DataBuffer> body) {
		
		List<String> result = Lists.newArrayList();
        
		body.subscribe(buffer -> {
			
			try {
				result.add(new String(IOUtils.toByteArray(buffer.asInputStream()), StandardCharsets.UTF_8));
			} catch (IOException igone) {
				
			} finally {
				DataBufferUtils.release(buffer);	
			}
		});
        
        return result;
	}
	
	public static List<List<Byte>> body2byteList(Flux<DataBuffer> body) {
		
		List<List<Byte>> result = Lists.newArrayList();
		
		body.subscribe(buffer -> {
			try {
				result.add(Bytes.asList(IOUtils.toByteArray(buffer.asInputStream())));
			} catch (IOException igone) {
				
			}finally {
				DataBufferUtils.release(buffer);
			}
		});
		
		return result;
	}
}
