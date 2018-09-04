package com.sauzny.springbootweb.system.log;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

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
        List<Object> argsTemp = Lists.newArrayList();
        
        for(Iterator<Object> iterator = args.iterator(); iterator.hasNext(); ){
            Object object = iterator.next();
            if(object instanceof MultipartFile){
                iterator.remove();
                argsTemp.add(((MultipartFile) object).getOriginalFilename());
                argsTemp.add(((MultipartFile) object).getSize());
                argsTemp.add(((MultipartFile) object).getContentType());
            }
            if (object instanceof HttpServletRequest) {
                iterator.remove();
            }
            if (object instanceof HttpServletResponse) {
                iterator.remove();
            }
        }
        args.addAll(argsTemp);
        return JacksonUtils.nonNull().toJson(this);
    }
}
