package com.sauzny.springbootweb.config;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.sauzny.springbootweb.utils.JacksonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogRecord {

    private String ip;
    private String url;
    private String methodType;
    private String classMethod;
    private List<Object> args = Lists.newArrayList();
    private Object result;
    private Long timing;
    

    public String toJson(){

        List<Object> args = this.getArgs();
        
        for(Iterator<Object> iterator = args.iterator(); iterator.hasNext(); ){
            Object object = iterator.next();
            if (object instanceof HttpServletRequest) {
                iterator.remove();
            }
            if (object instanceof HttpServletResponse) {
                iterator.remove();
            }
        }
        
        return JacksonUtils.nonNull().toJson(this);
    }
}
