package com.sauzny.sbgraphqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.controller.vo.City;
import com.sauzny.sbgraphqldemo.controller.vo.Pagination;
import com.sauzny.sbgraphqldemo.controller.vo.convert.CityConvert;
import com.sauzny.sbgraphqldemo.controller.vo.input.NewCityInput;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCity;
import com.sauzny.sbgraphqldemo.service.CityService;

@Component
public class CityController implements GraphQLQueryResolver, GraphQLMutationResolver{
    
    @Autowired
    private CityService cityService;
    
    public List<City> city(Pagination pagination){
        
        Page<TbCity> page = cityService.findByPage(pagination.getPageNum(), pagination.getPageSize());
        List<City> list = CityConvert.cityList(page.getResult());
        return list;
    }
    
    public Boolean newCity(NewCityInput input){
        int result = cityService.addCity(CityConvert.tbCity(input));
        return result > 0;
    }
}
