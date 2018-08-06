package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCustomer;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCustomerExample;

public interface TbCustomerDao extends TbCustomerMapper{

    // 获取所有数据
    List<TbCustomer> findAll();

    // 分页查询
    Page<TbCustomer> findByPage();

    // 分页查询带参数
    Page<TbCustomer> findByExamplePage(TbCustomerExample example);
}
