package com.sauzny.sbgraphqldemo.dao;

public interface TbCountryDao extends TbCountryMapper{

}

import com.sauzny.sbgraphqldemo.entity.pojo.TbCountry;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCountryExample;

public interface TbCountryDao extends TbCountryMapper{

    // 获取所有数据
    List<TbCountry> findAll();

    // 分页查询
    Page<TbCountry> findByPage();

    // 分页查询带参数
    Page<TbCountry> findByExamplePage(TbCountryExample example);
}
