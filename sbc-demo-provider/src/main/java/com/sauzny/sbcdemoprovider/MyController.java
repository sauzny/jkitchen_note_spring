package com.sauzny.sbcdemoprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyController {

    @Autowired
    private MyConfiguration myConfiguration;
    
    @GetMapping("/peizhi")
    public String peizhi() {
        log.info("我想从配置中心获取配置");
        return myConfiguration.getPeizhi();
    }
    
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
}
