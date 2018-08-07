package com.sauzny.sbgraphqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.controller.vo.Country;
import com.sauzny.sbgraphqldemo.controller.vo.Pagination;
import com.sauzny.sbgraphqldemo.controller.vo.convert.CityConvert;
import com.sauzny.sbgraphqldemo.controller.vo.convert.CountryConvert;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCountry;
import com.sauzny.sbgraphqldemo.service.AddressService;
import com.sauzny.sbgraphqldemo.service.CityService;
import com.sauzny.sbgraphqldemo.service.CountryService;

import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLQueryInvoker;

@Component
public class CountryController implements GraphQLQueryResolver, GraphQLMutationResolver{
    
    public static final String version = "1.0.0";
    
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private CityService cityService;
    
    @Autowired
    private AddressService addressService;
    
    public List<Country> country(Pagination pagination){
        
        Page<TbCountry> page = countryService.findByPage(pagination.getPageNum(), pagination.getPageSize());
        List<Country> list = CountryConvert.countryList(page.getResult());
        
        // 每次都要获取所有的cities，这样明显有问题
        // 理论上应该根据参数情趣判断是否要执行数据库的查询
        // 但是现在我使用graphql-spring-boot-starter，并不能获取到http访问时的参数
        list.forEach(country -> {
            country.setCities(CityConvert.cityList(cityService.findByCountryId(country.getCountryId())));
        });
        
        return list;
    }
    /*
    public List<City> cities(){
        return CityConvert.countryList(cityService.findByCountryId(countryId));
    }
    
    public List<Address> addresses(){
        return AddressConvert.countryList(addressService.findByCountryId(cityId));
    }
    */
    public Boolean newCountry(String country){
        return true;
    }
}
