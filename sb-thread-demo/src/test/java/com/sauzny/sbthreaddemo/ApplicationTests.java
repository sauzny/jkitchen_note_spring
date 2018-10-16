package com.sauzny.sbthreaddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	@Autowired
    private TaskTester taskTester;

    @Test
    public void test() throws Exception {

    	for(int i=0;i<60;i++) {
        	String result = taskTester.accept("hello"+i);

        	log.info("result = " + result);
    	}
    	
    	
    	// 不结束进程
        Thread.currentThread().join();
    }
}
