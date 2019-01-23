package com.sauzny.sbshirodemo.system.jwt;

import com.sauzny.sbshirodemo.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

import javax.annotation.PostConstruct;

@Data
@ConfigurationProperties(prefix = "audience")
@Component
@Slf4j
public class Audience {
    
    private String base64Secret;
    private int expiresSecond;

	private Boolean needCaptcha;

    private Boolean needjump;
    private String jumppassword;

    @PostConstruct
    public void init(){
        log.info("初始化Audience {}", JacksonUtils.nonNull().toJson(this));
    }

}