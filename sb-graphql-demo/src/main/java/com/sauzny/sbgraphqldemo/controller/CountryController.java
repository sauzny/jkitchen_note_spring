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
    
    @Autowired
    private GraphQLContext graphQLContext;
    
    public List<Country> country(Pagination pagination){

        
        System.out.println(graphQLContext.getFiles().get());

        Page<TbCountry> page = countryService.findByPage(pagination.getPageNum(), pagination.getPageSize());
        List<Country> list = CountryConvert.countryList(page.getResult());
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
