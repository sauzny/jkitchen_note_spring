package com.sauzny.sbgraphqldemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sauzny.sbgraphqldemo.dao.TbCountryDao;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCountry;

@Service
public class CountryService {

    @Autowired
    private TbCountryDao tbCountryDao;
    
    public Page<TbCountry> findByPage(int pageNum, int pageSize) {

        //return null;
        PageHelper.startPage(pageNum, pageSize);
        return tbCountryDao.findByPage();
    }
}
