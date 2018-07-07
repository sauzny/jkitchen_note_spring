package com.sauzny.sbcdemoconsumer;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class MyController {

    @Autowired
    private MyFeignClient myFeignClient;
    
    @GetMapping("/ling")
    public String ling() { return myFeignClient.ling(); }
    
    @GetMapping("/yi")
    public String yi() { return myFeignClient.yi(); }
    
    // 测试ribbon的参数
    @GetMapping("/er")
    public String er() {  System.out.println(LocalDateTime.now()); return myFeignClient.er(); }
    
    @GetMapping("/san")
    public String san() { return myFeignClient.san(); }
    
    @GetMapping("/ba")
    public String ba() { return myFeignClient.ba(); }
}
