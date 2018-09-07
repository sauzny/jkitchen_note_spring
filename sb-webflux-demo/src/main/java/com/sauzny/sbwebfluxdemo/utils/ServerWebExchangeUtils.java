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
	
	public static List<String> body2String(Flux<DataBuffer> flux) {
		
		List<String> result = Lists.newArrayList();
        
		flux.subscribe(buffer -> {
			
			try {
				byte[] resultBytes = IOUtils.toByteArray(buffer.asInputStream());
				result.add(new String(resultBytes, StandardCharsets.UTF_8));
			} catch (IOException ignore) {
				
			} finally {
				DataBufferUtils.release(buffer);	
			}
		});
        
        return result;
	}
	
	public static List<List<Byte>> body2byteList(Flux<DataBuffer> flux) {
		
		List<List<Byte>> result = Lists.newArrayList();
		
		flux.subscribe(buffer -> {
			try {
				result.add(Bytes.asList(IOUtils.toByteArray(buffer.asInputStream())));
			} catch (IOException ignore) {
				
			}finally {
				DataBufferUtils.release(buffer);
			}
		});
		
		return result;
	}
}
