package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmCategory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmCategoryExample;

public interface TbFilmCategoryDao extends TbFilmCategoryMapper{

    // 获取所有数据
    List<TbFilmCategory> findAll();

    // 分页查询
    Page<TbFilmCategory> findByPage();

    // 分页查询带参数
    Page<TbFilmCategory> findByExamplePage(TbFilmCategoryExample example);
}
