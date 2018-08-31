package com.sauzny.sbwebfluxdemo.config;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component // 将这个类引入spring容器中去
@Slf4j
public class WebFluxLogAspect {
	
	@Pointcut("execution(public *  com.sauzny.sbwebfluxdemo.controller.*Controller.*(..))") // 要处理的方法，包名+类名+方法名
    public void point() {}
    
    @Around("point()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    	
        String classMethod = pjp.getSignature().getDeclaringTypeName() + '.' + pjp.getSignature().getName();
        List<Object> args = Lists.newArrayList(pjp.getArgs());
        
        // 执行该方法
        Long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        Long end = System.currentTimeMillis();
        
        long timing = end - start;
        
        WebFluxLogRecord logRecord = new WebFluxLogRecord(classMethod, args, result, timing);
        
        log.info(logRecord.toJson());
        
        return result;
    }
}
