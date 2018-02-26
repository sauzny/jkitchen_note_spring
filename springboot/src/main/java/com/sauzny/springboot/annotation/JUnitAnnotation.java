package com.sauzny.springboot.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sauzny.springboot.BaseJUnit4Test;
import com.sauzny.springboot.aop.AopTarget;


/*
AOP

配置文件中设置开关

如果需要CGLIB代理的话，还需要自己增加CGLIB的jar包

*/

public class JUnitAnnotation extends BaseJUnit4Test{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void testint(){
	    userServiceImpl.getUser("");
	}
}
