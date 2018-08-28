package com.sauzny.sbwebfluxdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sauzny.sbwebfluxdemo.demodata.CityData;
import com.sauzny.sbwebfluxdemo.entity.City;

@Service
public class CityService {
	
	public City findCityById(long id) {
		return CityData.data.get(id);
	}

	public List<City> findAllCity(){
		return Lists.newArrayList(CityData.data.values());
	}
	
	public City saveCity(City city) {
		return CityData.data.put(city.getId(), city);
	}

	public City updateCity(City city) {
		return CityData.data.put(city.getId(), city);
	}
	
	public City deleteCity(long id) {
		return CityData.data.remove(id);
	}
}
