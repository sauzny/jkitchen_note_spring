package com.sauzny.sbutilsdemo.resouce;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
// 这个前缀似乎不能含有大写字母
@ConfigurationProperties(prefix = "springannotation1")
@Component
@Slf4j
public class SpringAnnotation1 {

	private String aaa;
    private int bbb;
    
    public void demo() {
    	log.info("aaa = {}, bbb = {}", aaa, bbb);
    }
}
