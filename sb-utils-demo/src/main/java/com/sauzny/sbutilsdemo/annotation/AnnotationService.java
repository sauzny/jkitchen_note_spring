package com.sauzny.sbutilsdemo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnnotationService {

    @CacheRedis(key = "redis",expireTime = 10)
    @CacheH2(key = "h2",expireTime = 10)
    public int test1() {
        log.info("test aop test");
        return 0;
    }

    @CacheRedis(key = "redis",expireTime = 10)
    public int test2() {
        log.info("test aop test");
        return 0;
    }

    @CacheH2(key = "h2",expireTime = 10)
    public int test3() {
        log.info("test aop test");
        return 0;
    }
}
