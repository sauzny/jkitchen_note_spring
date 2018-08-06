package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbInventory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbInventoryExample;

public interface TbInventoryDao extends TbInventoryMapper{

    // 获取所有数据
    List<TbInventory> findAll();

    // 分页查询
    Page<TbInventory> findByPage();

    // 分页查询带参数
    Page<TbInventory> findByExamplePage(TbInventoryExample example);
}