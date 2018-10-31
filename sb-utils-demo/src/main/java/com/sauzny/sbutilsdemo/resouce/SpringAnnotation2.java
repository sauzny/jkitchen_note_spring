package com.sauzny.sbutilsdemo.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Component
@Slf4j
// 可以指定引入的文件
// @PropertySource({"classpath:configinject/advance.properties"})
public class SpringAnnotation2 {

	///////////////////////////////////////////

	// 不常用
	
    // SpEL：调用字符串Hello World的concat方法
    @Value("#{'Hello World'.concat('!')}")
    private String helloWorld;

    // SpEL: 调用字符串的getBytes方法，然后调用length属性
    @Value("#{'Hello World'.bytes.length}")
    private String helloWorldbytes;
    
	///////////////////////////////////////////

    // 常用方式如下
	
	@Value("${springAnnotation2.value:127.0.0.1}")
	private String value;
	
	// 必须#{}外面，${}在里面，可以执行成功
	// 因为spring执行${}是时机要早于#{}
	@Value("#{'${springAnnotation2.names}'.split(',')}")
    private List<String> names;
    
    public void demo() {
    	log.info("helloWorld = {}, helloWorldbytes = {}", helloWorld, helloWorldbytes);
    	log.info("value = {}, names = {}", value, names);
    }
}
