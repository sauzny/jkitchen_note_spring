package com.sauzny.sbgraphqldemo.controller.connections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sauzny.sbgraphqldemo.controller.vo.City;
import com.sauzny.sbgraphqldemo.controller.vo.Country;
import com.sauzny.sbgraphqldemo.controller.vo.convert.CityConvert;
import com.sauzny.sbgraphqldemo.service.CityService;

// 实现Country实体类中的Connections查询

@Component
public class CountryConnections implements GraphQLResolver<Country>{

    @Autowired
    private CityService cityService;
    
    public List<City> cities(Country country){
        return CityConvert.cityList(cityService.findByCountryId(country.getCountryId()));
    }
}
