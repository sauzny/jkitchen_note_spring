package com.sauzny.sbgraphqldemo.dao;

public interface TbCityDao extends TbCityMapper{

}
Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCity;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCityExample;

public interface TbCityDao extends TbCityMapper{

    // 获取所有数据
    List<TbCity> findAll();

    // 分页查询
    Page<TbCity> findByPage();

    // 分页查询带参数
    Page<TbCity> findByExamplePage(TbCityExample example);
}
