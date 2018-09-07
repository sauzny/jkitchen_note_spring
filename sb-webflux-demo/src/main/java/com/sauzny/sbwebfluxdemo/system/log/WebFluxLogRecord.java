package com.sauzny.sbwebfluxdemo.system.log;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.utils.JacksonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebFluxLogRecord {
	
    private InetSocketAddress remoteAddress;
    private URI uri;
    private String methodValue;
    //private String classMethod;
    private List<String> args = Lists.newArrayList();
    private Object result;
    private Long timing;
    
    public String toJson(){
/*
        List<String> args = this.getArgs();
        List<String> argsTemp = Lists.newArrayList();
        
        for(Iterator<String> iterator = args.iterator(); iterator.hasNext(); ){
        	
            Object object = iterator.next();
            
            
            if(object instanceof MultipartFile){
                iterator.remove();
                argsTemp.add(((MultipartFile) object).getOriginalFilename());
                argsTemp.add(((MultipartFile) object).getSize());
                argsTemp.add(((MultipartFile) object).getContentType());
            }
            
            
        }
        args.addAll(argsTemp);
*/        
        return JacksonUtils.nonNull().toJson(this);
    }
}
