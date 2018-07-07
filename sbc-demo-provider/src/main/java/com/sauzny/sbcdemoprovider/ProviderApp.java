package com.sauzny.sbcdemoprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ProviderApp {
    
    @GetMapping("/ling")
    public String ling() {
        return "sleep 0";
    }

    @GetMapping("/yi")
    public String yi() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "sleep 1";
    }
    
    @GetMapping("/er")
    public String er() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "sleep 2";
    }
    
    @GetMapping("/san")
    public String san() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "sleep 3";
    }
    
    @GetMapping("/ba")
    public String ba() {
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "sleep 8";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }
}
