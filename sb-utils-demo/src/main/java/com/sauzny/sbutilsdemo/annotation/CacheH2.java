package com.sauzny.sbutilsdemo.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheH2 {
    String key();

    int expireTime() default 600;
}
