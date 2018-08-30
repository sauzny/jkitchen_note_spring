package com.sauzny.sbwebfluxdemo.demodata;

import java.util.Locale;
import java.util.Map;

import com.github.javafaker.Faker;
import com.google.common.collect.Maps;
import com.sauzny.sbwebfluxdemo.entity.City;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CityData {
	
	private CityData() {}
	
	public static Map<Long, City> data = Maps.newHashMap();
	
	public static Faker faker = new Faker(new Locale("zh","CN"));
	
	static {
		
		for(int i=0; i<20; i++) {
			long id = faker.number().numberBetween(1000, 99999);
			data.put(id, new City(id, faker.address().city()));
		}
		
		log.info("city测试数据加载完毕");
	}

}
