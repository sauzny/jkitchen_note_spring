package com.sauzny.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.trace("======trace");  
        logger.debug("======debug");  
        logger.info("======info");  
        logger.warn("======warn");  
        logger.error("======error");  
        logger.info("如果配置了拦截器，那么只有我能通过，因为我带有关键词：sample");  
    }
}
