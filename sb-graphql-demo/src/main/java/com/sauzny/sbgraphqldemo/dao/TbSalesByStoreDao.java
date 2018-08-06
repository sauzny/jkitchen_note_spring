package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByStore;
import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByStoreExample;

public interface TbSalesByStoreDao extends TbSalesByStoreMapper{

    // 获取所有数据
    List<TbSalesByStore> findAll();

    // 分页查询
    Page<TbSalesByStore> findByPage();

    // 分页查询带参数
    Page<TbSalesByStore> findByExamplePage(TbSalesByStoreExample example);
}
