package com.sauzny.sbutilsdemo.web;

import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringWeb {

	public void demo() {
		log.info("基本是处理servlet request response {}", WebUtils.class.getName());
	}
}
