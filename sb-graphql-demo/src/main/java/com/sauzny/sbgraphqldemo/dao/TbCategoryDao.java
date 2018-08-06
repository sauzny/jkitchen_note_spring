package com.sauzny.sbgraphqldemo.dao;

public interface TbCategoryDao extends TbCategoryMapper{

}
mport com.sauzny.sbgraphqldemo.entity.pojo.TbCategory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCategoryExample;

public interface TbCategoryDao extends TbCategoryMapper{

    // 获取所有数据
    List<TbCategory> findAll();

    // 分页查询
    Page<TbCategory> findByPage();

    // 分页查询带参数
    Page<TbCategory> findByExamplePage(TbCategoryExample example);
}
