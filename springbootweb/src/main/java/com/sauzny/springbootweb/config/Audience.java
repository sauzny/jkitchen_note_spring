package com.sauzny.springbootweb.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
    
    private String base64Secret;
    private int expiresSecond;
    
    //@Value("${aaa: null}")
	private String aaa;
	
	@PostConstruct
	public void init() {
		System.out.println(this.aaa);
	}

}