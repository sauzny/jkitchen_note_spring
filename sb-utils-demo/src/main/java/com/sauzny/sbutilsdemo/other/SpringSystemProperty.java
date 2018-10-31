package com.sauzny.sbutilsdemo.other;

import org.springframework.stereotype.Component;
import org.springframework.util.SystemPropertyUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringSystemProperty {

	public void demo() {
		
		// 替换字符串中的系统属性值
		
		log.info(SystemPropertyUtils.PLACEHOLDER_PREFIX);
		log.info(SystemPropertyUtils.PLACEHOLDER_SUFFIX);
		log.info(SystemPropertyUtils.VALUE_SEPARATOR);
		
		log.info(SystemPropertyUtils.resolvePlaceholders("${file.encoding}/bbbb"));
	}
}
