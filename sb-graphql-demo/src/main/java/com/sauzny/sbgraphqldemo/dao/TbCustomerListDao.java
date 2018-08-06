package com.sauzny.sbgraphqldemo.dao;

public interface TbCustomerListDao extends TbCustomerListMapper{

}
m.sauzny.sbgraphqldemo.entity.pojo.TbCustomerList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCustomerListExample;

public interface TbCustomerListDao extends TbCustomerListMapper{

    // 获取所有数据
    List<TbCustomerList> findAll();

    // 分页查询
    Page<TbCustomerList> findByPage();

    // 分页查询带参数
    Page<TbCustomerList> findByExamplePage(TbCustomerListExample example);
}
