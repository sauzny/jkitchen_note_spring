package com.sauzny.sbwebfluxdemo.config;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.server.reactive.ServerHttpRequest;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.utils.JacksonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
public class WebFluxLogRecord {
	
    private InetSocketAddress remoteAddress;
    private URI uri;
    private String methodValue;
    private String classMethod;
    private List<Object> args = Lists.newArrayList();
    private Object result;
    private Long timing;
    
    public WebFluxLogRecord(String classMethod, List<Object> args, Object result, Long timing) {
    	this.classMethod = classMethod;
    	this.args = args;
    	this.result = result;
    	this.timing = timing;
    }
    
    public String toJson(){

        List<Object> args = this.getArgs();
        List<Object> argsTemp = Lists.newArrayList();
        
        for(Iterator<Object> iterator = args.iterator(); iterator.hasNext(); ){
            Object object = iterator.next();
            /*
            if(object instanceof MultipartFile){
                iterator.remove();
                argsTemp.add(((MultipartFile) object).getOriginalFilename());
                argsTemp.add(((MultipartFile) object).getSize());
                argsTemp.add(((MultipartFile) object).getContentType());
            }
            */
            if (object instanceof ServerHttpRequest) {
                iterator.remove();
            }
            /*
            if (object instanceof HttpServletResponse) {
                iterator.remove();
            }
            */
        }
        args.addAll(argsTemp);
        
        return JacksonUtils.nonNull().toJson(this);
    }
}
