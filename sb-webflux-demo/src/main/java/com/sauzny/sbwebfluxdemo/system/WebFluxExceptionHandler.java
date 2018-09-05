package com.sauzny.sbwebfluxdemo.system;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.controller.vo.WebFluxResult;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@ControllerAdvice
@Slf4j
public class WebFluxExceptionHandler {
	
	@ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private WebFluxResult runtimeExceptionHandler(
    		ServerHttpRequest request, Exception e) {
		
		InetSocketAddress remoteAddress = request.getRemoteAddress();
		URI uri = request.getURI();
        String methodValue = request.getMethodValue();
        
        // 组织参数
        List<Object> args = Lists.newArrayList("runtime error");
        args.add(request.getHeaders());
        /*
        try {
            String requestStr = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
            args.add(request.getBody().);
        } catch (IOException e1) {
        }
        */
        Flux<DataBuffer> flux = request.getBody();
        String body = "";
        try(ByteArrayOutputStream  swos = new ByteArrayOutputStream()){
            DataBufferUtils.write(flux, swos);
            byte[] byteArray = swos.toByteArray();
            body = new String(byteArray, StandardCharsets.UTF_8);
            System.out.println(body);
        } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        args.add(body);
        
        
        WebFluxLogRecord logRecord = new WebFluxLogRecord(remoteAddress, uri, methodValue, null, args, e.getMessage(), null);
        
        
        
        log.error(logRecord.toJson(), e);
        //e.printStackTrace();
        return WebFluxResult.failure();
    }
}
