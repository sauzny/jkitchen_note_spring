package com.sauzny.sbcdemoprovider;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties
@Data
public class MyConfigurationDemo01 {

    private String name;
    
    private String address;
    
    public static int phone;
    
}
