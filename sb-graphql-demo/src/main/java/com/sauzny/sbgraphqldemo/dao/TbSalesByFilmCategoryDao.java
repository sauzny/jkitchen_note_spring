package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByFilmCategory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByFilmCategoryExample;

public interface TbSalesByFilmCategoryDao extends TbSalesByFilmCategoryMapper{

    // 获取所有数据
    List<TbSalesByFilmCategory> findAll();

    // 分页查询
    Page<TbSalesByFilmCategory> findByPage();

    // 分页查询带参数
    Page<TbSalesByFilmCategory> findByExamplePage(TbSalesByFilmCategoryExample example);
}
