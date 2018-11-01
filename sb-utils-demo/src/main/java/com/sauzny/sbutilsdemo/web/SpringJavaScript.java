package com.sauzny.sbutilsdemo.web;

import org.springframework.stereotype.Component;
import org.springframework.web.util.JavaScriptUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringJavaScript {

	public void demo() {
		
		String sourceJavaScript = "jQuery19103771260344952636_1541035648961({\"succ\":0,\"info\":0,\"msg\":\"failed\"})";
		
		String result = JavaScriptUtils.javaScriptEscape(sourceJavaScript);
		
		log.info("原值 {}", sourceJavaScript);
		log.info("转义 {}", result);
	}
}
