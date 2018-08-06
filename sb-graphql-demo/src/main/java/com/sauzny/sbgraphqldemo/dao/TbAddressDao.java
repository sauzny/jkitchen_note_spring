package com.sauzny.sbgraphqldemo.dao;

public interface TbAddressDao extends TbAddressMapper{

}

import com.sauzny.sbgraphqldemo.entity.pojo.TbAddress;
import com.sauzny.sbgraphqldemo.entity.pojo.TbAddressExample;

public interface TbAddressDao extends TbAddressMapper{

    // 获取所有数据
    List<TbAddress> findAll();

    // 分页查询
    Page<TbAddress> findByPage();

    // 分页查询带参数
    Page<TbAddress> findByExamplePage(TbAddressExample example);
}
