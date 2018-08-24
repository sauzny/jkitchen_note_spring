package com.sauzny.sbwebfluxdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.entity.City;

@Service
public class CityService {

	public City findCityById(long id) {
		City city = new City();
		city.setId(1001);
		city.setName("Auckland");
		return city;
	}
	
	public List<City> findAllCity(){
		
		City city1 = new City();
		city1.setId(1001);
		city1.setName("Auckland");
		
		City city2 = new City();
		city2.setId(1002);
		city2.setName("Waikato");
		
		return Lists.newArrayList(city1, city2);
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
