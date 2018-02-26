package com.sauzny.springboot.annotation;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class CacheAspect {

    public CacheAspect() {}


    @Pointcut(value = "execution(@Cacheable * *.*(..))")
    public void setCacheRedis() {}

    /**
     * aop实现自定缓存注解
     *
     * @param joinPoint
     * @return
     * @throws Throwable 
     */

    // @Around("@annotation(com.manage.annotations.Cacheable)") 不知道为什么这么写不行 //这个里面的值要上面的方法名一致
    @Around("setCacheRedis()")

    public Object setCache(ProceedingJoinPoint pjp) throws Throwable {
        
        log.info("进入环绕通知中：CacheAspect setCache");
        
        Object result = null;
        Method method = getMethod(pjp);
        // 自定义注解类
        Cacheable cacheable = method.getAnnotation(Cacheable.class);
        // 获取key值
        String key = cacheable.key();
        String fieldKey = cacheable.fieldKey();
        
        log.info("key : {}", key);
        log.info("fieldKey : {}", fieldKey);
        
        // 获取方法的返回类型,让缓存可以返回正确的类型
        Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
        
        // 修改第一个参数
        Object[] args = pjp.getArgs();
        args[0] = "1415926";
        
        // 下面就是根据业务来自行操作
        // 执行该方法
        result = pjp.proceed(args);
        return result;
    }

    public Method getMethod(ProceedingJoinPoint pjp) {
        // 获取参数的类型
        Object[] args = pjp.getArgs();
        Class[] argTypes = new Class[pjp.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException e) {
            log.error("annotation no sucheMehtod", e);
        } catch (SecurityException e) {
            log.error("annotation SecurityException", e);
        }
        return method;

    }
}
