package com.sauzny.sbgraphqldemo.controller.vo.convert;

import java.util.List;

import com.google.common.collect.Lists;
import com.sauzny.sbgraphqldemo.controller.vo.City;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCity;

public final class CityConvert {

    private CityConvert(){}
    
    public static City city(TbCity tbCity){
        City city = new City();
        city.setCityId(tbCity.getCityId());
        city.setCity(tbCity.getCity());
        return city;
    }
    
    public static List<City> cityList(List<TbCity> tbCityList){
        List<City> cityList = Lists.newArrayList();
        tbCityList.forEach(tbCity -> cityList.add(city(tbCity)));
        return cityList;
    }
}
