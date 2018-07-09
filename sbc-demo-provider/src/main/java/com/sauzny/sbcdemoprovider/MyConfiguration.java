package com.sauzny.sbcdemoprovider;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties
@Data
public class MyConfiguration {

    private String peizhi;
    
    private static String staticpeizhi;
    
    // 这种方式获取的值不能刷新，需要重启项目才能获取新的值
    //@Value
    //private String name;
}
