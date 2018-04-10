package com.sauzny.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.sauzny.springbootweb.SbwConstant.Controller.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value=HEALTH_CONTROLLER_MAPPING)
@Slf4j
public class HealthController {

    // 健康检查
    @RequestMapping(value = "", method = { RequestMethod.HEAD })
    public void check() {
        log.debug("health check");
    }
}
