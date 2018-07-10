package com.sauzny.sbcdemoprovider;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyController {

    @Autowired
    private MyConfigurationDemo01 myConfigurationDemo01;
    
    @Autowired
    private MyConfigurationDemo03 myConfigurationDemo03;
    
    
    @GetMapping("/peizhi")
    public Map<String, Object> peizhi() {
        log.info("我想从配置中心获取配置");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("myConfigurationDemo01.getName()", myConfigurationDemo01.getName());
        map.put("myConfigurationDemo01.getAddress()", myConfigurationDemo01.getAddress());
        //map.put("myConfigurationDemo01.getUrl()", myConfigurationDemo01.getUrl());
        map.put("MyConfigurationDemo02.number", MyConfigurationDemo02.number);
        map.put("MyConfigurationDemo02.address", MyConfigurationDemo02.address);
        map.put("myConfigurationDemo03.getAuthor()", myConfigurationDemo03.getAuthor());
        map.put("myConfigurationDemo03.getName()", myConfigurationDemo03.getName());
        return map;
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
