package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilm;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmExample;

public interface TbFilmDao extends TbFilmMapper{

    // 获取所有数据
    List<TbFilm> findAll();

    // 分页查询
    Page<TbFilm> findByPage();

    // 分页查询带参数
    Page<TbFilm> findByExamplePage(TbFilmExample example);
}
