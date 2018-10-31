package com.sauzny.sbutilsdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sauzny.sbutilsdemo.other.SpringAssert;
import com.sauzny.sbutilsdemo.resouce.SpringAnnotation1;
import com.sauzny.sbutilsdemo.resouce.SpringAnnotation2;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {
	
	@Autowired
	private SpringAnnotation1 springAnnotation1;

	@Autowired
	private SpringAnnotation2 springAnnotation2;

	@Autowired
	private SpringAssert springAssert;
	
	@Test
	public void test001() throws InterruptedException {
		
		log.info("hello, {}", "测试类");
		
    	// 不结束进程
        Thread.currentThread().join();
	}
	
	@Test
	public void resource() {
		springAnnotation1.demo();
		springAnnotation2.demo();
	}
	
	@Test
	public void other() throws InterruptedException {

	}
}
