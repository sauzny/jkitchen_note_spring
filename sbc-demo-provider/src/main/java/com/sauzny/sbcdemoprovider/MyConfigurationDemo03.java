package com.sauzny.sbcdemoprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@RefreshScope // 刷新@Value中的属性值
@Data
public class MyConfigurationDemo03 {

    @Value("${author}")
    private String author;
    
    @Value("${name}")
    private String name;
    
    @Value("${mysql1.url}")
    private String mysql1url;
    
    @Value("${mysql.url}")
    private String mysqlurl;
}
