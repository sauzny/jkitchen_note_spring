package com.sauzny.b1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: liujinxin
 * @time: 2021/11/5 12:11
 */
@Service
@Slf4j
public class B1Service {

    public String deal1(){
        log.info("deal1");
        return "deal1";
    }
}
