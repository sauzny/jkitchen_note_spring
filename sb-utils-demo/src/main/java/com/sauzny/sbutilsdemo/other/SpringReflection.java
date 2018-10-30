package com.sauzny.sbutilsdemo.other;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.sauzny.sbutilsdemo.entity.User;
import com.sauzny.sbutilsdemo.utils.MyUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringReflection {
	
	public void demo() {
		User user = new User();
		user.setName(MyUtils.faker.name().name());
		String name = this.invokeMethod(user, "getName").toString();
		log.info("user getName = {}", name);
	}
	
	public Method getMethod(User user, String methodName) {
		return ReflectionUtils.findMethod(User.class, methodName);
	}
	
	public Object invokeMethod(User user, String methodName) {
		Method method = this.getMethod(user, methodName);
		return ReflectionUtils.invokeMethod(method, user);
	}
}
