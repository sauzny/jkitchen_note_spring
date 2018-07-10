package com.sauzny.sbcdemoprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties({MyConfigurationDemo01.class})
public class ProviderApp {
    
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }
}
