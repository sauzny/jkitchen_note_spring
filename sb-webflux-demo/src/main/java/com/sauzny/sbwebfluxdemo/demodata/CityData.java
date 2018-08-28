package com.sauzny.sbwebfluxdemo.demodata;

import java.util.Map;

import com.google.common.collect.Maps;
import com.sauzny.sbwebfluxdemo.entity.City;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class CityData {
	
	private CityData() {}
	
	public static  Map<Long, City> data = Maps.newHashMap();
	
	static {
		data.put(1001L, new City(1001L, "北京市"));
		data.put(1002L, new City(1002L, "天津市"));
		data.put(1003L, new City(1003L, "辽宁省沈阳市"));
		data.put(1004L, new City(1004L, "吉林省长春市"));
		data.put(1005L, new City(1005L, "黑龙江省哈尔滨市"));
		data.put(1006L, new City(1006L, "上海市"));
		data.put(1007L, new City(1007L, "江苏省南京市"));
		data.put(1008L, new City(1008L, "湖北省武汉市"));
		data.put(1009L, new City(1009L, "广东省广州市"));
		data.put(1010L, new City(1010L, "重庆市"));
		data.put(1011L, new City(1011L, "四川省成都市"));
		data.put(1012L, new City(1012L, "陕西省西安市"));
		
		log.info("city测试数据加载完毕");
	}

}
