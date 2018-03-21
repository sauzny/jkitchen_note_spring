package com.sauzny.springbootweb.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component // 将这个类引入spring容器中去
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.jfs.purchase.controller.*Controller.*(..))") // 要处理的方法，包名+类名+方法名
    public void point() {}
    
    @Around("point()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String ip = request.getRemoteAddr();
        String url = request.getRequestURI();
        String methodType = request.getMethod();
        String classMethod = pjp.getSignature().getDeclaringTypeName() + '.' + pjp.getSignature().getName();
        List<Object> args = Lists.newArrayList(pjp.getArgs());
        
        // 执行该方法
        Long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        Long end = System.currentTimeMillis();
        
        long timing = end - start;
        
        LogRecord logRecord = new LogRecord(ip, url, methodType, classMethod, args, result, timing);
        
        log.info(logRecord.toJson());
        
        return result;
    }
    
}
