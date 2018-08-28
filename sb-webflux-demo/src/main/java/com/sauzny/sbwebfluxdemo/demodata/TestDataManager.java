package com.sauzny.sbwebfluxdemo.demodata;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestDataManager {

	@PostConstruct
	public void init() {
		log.info("CityData size : {}", CityData.data.size());
	}
}
