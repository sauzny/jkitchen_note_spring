package com.sauzny.springbootweb.system.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
    
    private String base64Secret;
    private int expiresSecond;

	private boolean needCaptcha;

}