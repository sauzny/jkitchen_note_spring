package com.sauzny.springbootweb.system;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Lists;
import com.sauzny.springbootweb.SbwConstant;
import com.sauzny.springbootweb.controller.vo.RestFulResult;
import com.sauzny.springbootweb.system.log.LogRecord;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private RestFulResult runtimeExceptionHandler(
            HttpServletRequest request, Exception e) {
        
        String ip = request.getRemoteAddr();
        String url = request.getRequestURI();
        String methodType = request.getMethod();
        
        // 组织参数
        List<Object> args = Lists.newArrayList("runtime error");
        args.add(request.getParameterMap());
        
        try {
            String requestStr = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
            args.add(requestStr);
        } catch (IOException e1) {
        }
        
        LogRecord logRecord = new LogRecord(ip, url, methodType, null, args, e.getMessage(), null);
        
        log.error(logRecord.toJson(), e);
        //e.printStackTrace();
        return RestFulResult.failure();
    }

    
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private RestFulResult dataIntegrityViolationExceptionHandler(
            HttpServletRequest request, DataIntegrityViolationException e) {

        String ip = request.getRemoteAddr();
        String url = request.getRequestURI();
        String methodType = request.getMethod();
        
        // 组织参数
        List<Object> args = Lists.newArrayList("DataIntegrityViolationException wtite db error");
        args.add(request.getParameterMap());
        
        try {
            String requestStr = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
            args.add(requestStr);
        } catch (IOException e1) {
        }
        
        LogRecord logRecord = new LogRecord(ip, url, methodType, null, args, e.getMessage(), null);
        
        log.error(logRecord.toJson(), e);
        
        return RestFulResult.failure(SbwConstant.FailureEnum.DB_DATA_ILLEGAL);
    }

}

