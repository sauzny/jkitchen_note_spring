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
	
	public Long saveCity(City city) {
		CityData.data.put(city.getId(), city);
		return city.getId();
	}

	public Long updateCity(City city) {
		CityData.data.put(city.getId(), city);
		return city.getId();
	}
	
	public Long deleteCity(long id) {
		CityData.data.remove(id);
		return id;
	}
}
