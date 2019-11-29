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

    @Pointcut("execution(public * com.sauzny.sbutilsdemo.annotation.AnnotationService.test*())") // 要处理的方法，包名+类名+方法名
    public void point() {}

    // 此处只能写 &&  不能写 ||
    // 1真 2真
    @Around(value = "point() && (@annotation(redis) && @annotation(h2))", argNames = "pjp,redis,h2")
    //@Around(value = "(point() && @annotation(redis)) || (point() && @annotation(h2)))", argNames = "pjp,redis,h2")
    public Object doBasicProfiling1(ProceedingJoinPoint pjp, CacheRedis redis, CacheH2 h2) throws Throwable {
        log.info("{} , {}", pjp.getSignature().getName(), redis.key());
        log.info("{} , {}", pjp.getSignature().getName(), h2.key());
        return pjp.proceed();
    }


    // 此处只能写 &&  不能写 ||
    // 1真 2假
    @Around(value = "point() && (@annotation(redis) && !@annotation(CacheH2))", argNames = "pjp,redis")
    public Object doBasicProfiling2(ProceedingJoinPoint pjp, CacheRedis redis) throws Throwable {
        log.info("{} , {}", pjp.getSignature().getName(), redis.key());
        //log.info("{} , {}", pjp.getSignature().getName(), h2.key());
        return pjp.proceed();
    }


    // 此处只能写 &&  不能写 ||
    // 1假 2真
    @Around(value = "point() && (!@annotation(CacheRedis) && @annotation(h2))", argNames = "pjp,h2")
    public Object doBasicProfiling3(ProceedingJoinPoint pjp, CacheH2 h2) throws Throwable {
        //log.info("{} , {}", pjp.getSignature().getName(), redis.key());
        log.info("{} , {}", pjp.getSignature().getName(), h2.key());
        return pjp.proceed();
    }
}
