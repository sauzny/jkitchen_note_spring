package com.sauzny.sbutilsdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {
	@Test
	public void test001() throws InterruptedException {
		
		log.info("hello, {}", "测试类");
		
    	// 不结束进程
        Thread.currentThread().join();
	}
}
