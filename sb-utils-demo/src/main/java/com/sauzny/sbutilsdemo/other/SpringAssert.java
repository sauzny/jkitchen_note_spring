package com.sauzny.sbutilsdemo.other;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.sauzny.sbutilsdemo.entity.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringAssert {

	public void demo() {
		
		// 断言，一般使用在参数校验上
		
		/*
		Assert.notNull(Object object, "object is required")    -    对象非空 
		Assert.isTrue(Object object, "object must be true")   -    对象必须为true   
		Assert.notEmpty(Collection collection, "collection must not be empty")    -    集合非空  
		Assert.hasLength(String text, "text must be specified")   -    字符不为null且字符长度不为0   
		Assert.hasText(String text, "text must not be empty")    -     text 不为null且必须至少包含一个非空格的字符  
		Assert.isInstanceOf(Class clazz, Object obj, "clazz must be of type [clazz]")    -    obj必须能被正确造型成为clazz 指定的类
		Assert.isAssignable(Class superType, Class subType, String message)  subType 必须可以按类型匹配于 superType，否则将抛出异常； 
		*/
		
		// 除了state之外，都会抛出 IllegalArgumentException
		
		Assert.notNull(null, "object is required");
		Assert.isTrue(false, "object must be true");
		Assert.notEmpty(Lists.emptyList(), "collection must not be empty");
		Assert.hasLength("", "text must be specified");
		Assert.hasText(" ", "text must not be empty");
		Assert.isInstanceOf(User.class, new User(), "clazz must be of type [clazz]");
		Assert.isAssignable(Object.class, User.class, "subType must be extents superType");
		
		log.info("Spring Assert Demo");
	}
}
