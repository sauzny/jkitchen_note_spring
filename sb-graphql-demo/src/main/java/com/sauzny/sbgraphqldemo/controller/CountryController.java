package com.sauzny.sbgraphqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.controller.vo.Country;
import com.sauzny.sbgraphqldemo.controller.vo.Pagination;
import com.sauzny.sbgraphqldemo.controller.vo.convert.CountryConvert;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCountry;
import com.sauzny.sbgraphqldemo.service.CountryService;

@Component
public class CountryController implements GraphQLQueryResolver, GraphQLMutationResolver{
    
    // 这个需要修改
    public static final String version = "1.0.0";
    
    @Autowired
    private CountryService countryService;
    
    public List<Country> country(Pagination pagination){
        
        Page<TbCountry> page = countryService.findByPage(pagination.getPageNum(), pagination.getPageSize());
        List<Country> list = CountryConvert.countryList(page.getResult());
        
        return list;
    }
    
    public Boolean newCountry(String country){
        return true;
    }
}
