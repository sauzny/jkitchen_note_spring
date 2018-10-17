package com.sauzny.sbdatasourcedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sauzny.sbdatasourcedemo.statementcancel.StatementCancelTester;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest{

	@Autowired
    private StatementCancelTester statementCancelTester;

    @Test
    public void test() throws Exception {

    	statementCancelTester.executeQuery();
    	Thread.sleep(5000);
    	statementCancelTester.cancelQuery();
    	
    	// 不结束进程
        Thread.currentThread().join();
    }
}
