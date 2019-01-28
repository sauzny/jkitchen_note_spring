package com.sauzny.sbshirodemo.system.shiro.jwt;

import com.sauzny.sbshirodemo.utils.JacksonUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@ConfigurationProperties(prefix = "audience")
@Component
@Slf4j
public class Audience {
    
    private String base64Secret;
    private int expiresSecond;

    @PostConstruct
    public void init(){
        log.info("初始化Audience {}", JacksonUtils.nonNull().toJson(this));
    }

}