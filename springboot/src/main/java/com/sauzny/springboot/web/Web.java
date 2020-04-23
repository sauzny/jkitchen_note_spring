package com.sauzny.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Web {

    @GetMapping("/write")
    public void write() {
        System.out.println("a");
    }
}
