package com.sauzny.sbgraphqldemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.sbgraphqldemo.dao.TbCityDao;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCity;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCityExample;

@Service
public class CityService {

    @Autowired
    private TbCityDao tbCityDao;
    
    public List<TbCity> findByCountryId(int countryId){
        
        TbCityExample example = new TbCityExample();
        TbCityExample.Criteria criteria = example.createCriteria();
        criteria.andCountryIdEqualTo((short) countryId);
        
        return tbCityDao.selectByExample(example);
    }
}
