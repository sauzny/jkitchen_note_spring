package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmActor;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmActorExample;

public interface TbFilmActorDao extends TbFilmActorMapper{

    // 获取所有数据
    List<TbFilmActor> findAll();

    // 分页查询
    Page<TbFilmActor> findByPage();

    // 分页查询带参数
    Page<TbFilmActor> findByExamplePage(TbFilmActorExample example);
}
