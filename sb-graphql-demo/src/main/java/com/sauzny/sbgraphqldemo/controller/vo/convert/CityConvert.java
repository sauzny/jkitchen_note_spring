package com.sauzny.sbgraphqldemo.controller.vo.convert;

import java.util.List;

import com.google.common.collect.Lists;
import com.sauzny.sbgraphqldemo.controller.vo.City;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCity;

public final class CityConvert {

    private CityConvert(){}
    
    public static City city(TbCity tbCity){
        City country = new City();
        country.setCityId(tbCity.getCityId());
        country.setCity(tbCity.getCity());
        return country;
    }
    
    public static List<City> cityList(List<TbCity> tbCityList){
        List<City> countryList = Lists.newArrayList();
        tbCityList.forEach(tbCity -> countryList.add(city(tbCity)));
        return countryList;
    }
}
