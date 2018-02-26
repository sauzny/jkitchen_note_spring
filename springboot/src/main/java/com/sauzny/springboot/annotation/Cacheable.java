package com.sauzny.springboot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// ElementType.METHOD 在方法上使用
@Target(ElementType.METHOD)
// 范围
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cacheable {

    String key();

    String fieldKey();

    int expireTime() default 1800000;
}
