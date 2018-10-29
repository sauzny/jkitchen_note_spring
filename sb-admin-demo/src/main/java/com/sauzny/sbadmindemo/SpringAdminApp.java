package com.sauzny.sbadmindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringAdminApp {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAdminApp.class, args);
	}
	
}
