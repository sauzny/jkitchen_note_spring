package com.sauzny.sbwebfluxdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.entity.City;

@Service
public class CityService {

	public City findCityById(long id) {
		return null;
	}
	
	public List<City> findAllCity(){
		return Lists.newArrayList();
	}
	
	public long saveCity(City city) {
		return 1L;
	}
	
	public long updateCity(City city) {
		return 1L;
	}
	
	public long deleteCity(long id) {
		return 1L;
	}
}
