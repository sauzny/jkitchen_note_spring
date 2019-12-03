package com.sauzny.sbmybatisdemo.web;

import com.sauzny.sbmybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {

    private final UserService userService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/write")
    public void write() {
        userService.writeTest();
    }

    @GetMapping("/select")
    public void select() {
        userService.selectTest();
    }
}
