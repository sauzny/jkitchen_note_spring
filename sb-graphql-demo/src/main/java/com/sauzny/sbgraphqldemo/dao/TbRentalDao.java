package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbRental;
import com.sauzny.sbgraphqldemo.entity.pojo.TbRentalExample;

public interface TbRentalDao extends TbRentalMapper{

    // 获取所有数据
    List<TbRental> findAll();

    // 分页查询
    Page<TbRental> findByPage();

    // 分页查询带参数
    Page<TbRental> findByExamplePage(TbRentalExample example);
}
