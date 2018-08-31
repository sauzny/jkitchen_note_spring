package com.sauzny.sbwebfluxdemo.config;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.controller.vo.WebFluxResult;

import lombok.extern.slf4j.Slf4j;

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
        WebFluxLogRecord logRecord = new WebFluxLogRecord(remoteAddress, uri, methodValue, null, args, e.getMessage(), null);
        
        log.error(logRecord.toJson(), e);
        //e.printStackTrace();
        return WebFluxResult.failure();
    }
}
