package com.sauzny.springboot.aop;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component  
@Slf4j
public class AopTarget {

	// 这个方法是被 aop 代理了的
	public void say(){
		log.info("hello world");
		// say1 虽然也被AOP了，但是此处的调用不会执行
		say1();
		log.info("hello world");
	}


	// 这个方法是被 aop 代理了的
	public void say1(){
		log.info("hello world1");
	}
}
