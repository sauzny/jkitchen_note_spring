package com.sauzny.sb_mybatis_mds.junit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sauzny.sb_mybatis_mds.service.MdsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JunitMds {

    @Autowired
    private MdsService mdsService;
    
    @PostConstruct
    public void testTransactional(){
        log.info("{}", mdsService.ds1());
        log.info("{}", mdsService.ds2());
        log.info("{}", mdsService.ds1());
        log.info("{}", mdsService.ds2());
        log.info("{}", mdsService.ds1());
        log.info("{}", mdsService.ds2());
    }
    
}
