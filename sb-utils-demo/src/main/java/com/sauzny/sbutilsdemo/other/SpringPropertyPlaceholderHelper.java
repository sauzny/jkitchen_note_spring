package com.sauzny.sbutilsdemo.other;

import org.springframework.stereotype.Component;
import org.springframework.util.PropertyPlaceholderHelper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringPropertyPlaceholderHelper {

	public void demo() {
		
		// 占位符处理
		String PLACEHOLDER_PREFIX = "${";

		String PLACEHOLDER_SUFFIX = "}";
		
		PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper(PLACEHOLDER_PREFIX, PLACEHOLDER_SUFFIX);
	
		String result1 = propertyPlaceholderHelper.replacePlaceholders("aaa${java.specification.version}bbbb", System.getProperties());
	
		String result2 = propertyPlaceholderHelper.replacePlaceholders("aaa${hahahahah}bbbb", placeholderName -> {
			return placeholderName + "_as";
		});
		
		log.info(result1);
		log.info(result2);
	}
}
