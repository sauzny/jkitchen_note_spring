package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbActor;
import com.sauzny.sbgraphqldemo.entity.pojo.TbActorExample;

public interface TbActorDao extends TbActorMapper{

    // 获取所有数据
    List<TbActor> findAll();

    // 分页查询
    Page<TbActor> findByPage();

    // 分页查询带参数
    Page<TbActor> findByExamplePage(TbActorExample example);
}