package com.sauzny.sbgraphqldemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sauzny.sbgraphqldemo.dao.TbAddressDao;
import com.sauzny.sbgraphqldemo.entity.pojo.TbAddress;
import com.sauzny.sbgraphqldemo.entity.pojo.TbAddressExample;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCountry;

@Service
public class AddressService {

    @Autowired
    private TbAddressDao tbAddressDao;
    
    public List<TbAddress> findByCountryId(int cityId){
        
        TbAddressExample example = new TbAddressExample();
        TbAddressExample.Criteria criteria = example.createCriteria();
        criteria.andCityIdEqualTo((short) cityId);
        
        return tbAddressDao.selectByExample(example);
    }
    
    public Page<TbAddress> findByPage(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> tbAddressDao.selectByExample(null));
    }
}
