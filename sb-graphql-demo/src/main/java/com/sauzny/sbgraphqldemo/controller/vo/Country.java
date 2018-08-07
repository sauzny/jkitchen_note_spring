package com.sauzny.sbgraphqldemo.controller.vo;

import java.util.List;

import com.sauzny.sbgraphqldemo.config.SpringContextUtils;
import com.sauzny.sbgraphqldemo.controller.vo.convert.CityConvert;
import com.sauzny.sbgraphqldemo.service.CityService;

import lombok.Data;

@Data
public class Country {

    private int countryId;
    
    private String country;
    
    private String lastUpdate;

    private List<City> cities;
    
    public List<City> getCities(){
        // 此处计划使用类似lazy的方式加载数据
        // 但是实际情况并不行，即使参数中不包含cities，也会执行getCities()
        /*
        if(this.cities == null){
            CityService cityService = SpringContextUtils.getBean(CityService.class);
            this.cities = CityConvert.cityList(cityService.findByCountryId(this.getCountryId()));
            System.out.println("========================");
        }
        */
        return this.cities;
    }
    
}
