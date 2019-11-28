package com.sauzny.sbutilsdemo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TestAop {

    @Pointcut("execution(public * com.sauzny.sbutilsdemo.annotation.AnnotationService.test())") // 要处理的方法，包名+类名+方法名
    public void point() {}

    // 此处只能写 &&  不能写 ||
    @Around(value = "point() && (@annotation(redis) && @annotation(h2))", argNames = "pjp,redis,h2")
    //@Around(value = "(point() && @annotation(redis)) || (point() && @annotation(h2)))", argNames = "pjp,redis,h2")
    public Object doBasicProfiling(ProceedingJoinPoint pjp, CacheRedis redis, CacheH2 h2) throws Throwable {
        log.info(redis.key());
        log.info(h2.key());
        return pjp.proceed();
    }
}
