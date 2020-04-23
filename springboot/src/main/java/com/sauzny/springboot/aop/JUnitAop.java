package com.sauzny.springboot.aop;

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

public class JUnitAop extends BaseJUnit4Test{

	// 这里实际使用的是 cglib 生成的子类实例
	@Autowired
	private AopTarget aopTarget;
	
	@Test
	public void testint(){
		// cglib 生成的子类实例 也就是说执行了 aop 中的内容
		// 但是其内部的say1().则是其父类 aopTarget 实例执行，所以不会执行被AOP的代码
		aopTarget.say();
	}

	@Test
	public void testint1(){
		aopTarget.say1();
	}
}
