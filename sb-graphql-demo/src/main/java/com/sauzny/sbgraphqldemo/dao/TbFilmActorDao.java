package com.sauzny.sbgraphqldemo.dao;

public interface TbFilmActorDao extends TbFilmActorMapper{

}
ort com.sauzny.sbgraphqldemo.entity.pojo.TbFilmActor;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmActorExample;

public interface TbFilmActorDao extends TbFilmActorMapper{

    // 获取所有数据
    List<TbFilmActor> findAll();

    // 分页查询
    Page<TbFilmActor> findByPage();

    // 分页查询带参数
    Page<TbFilmActor> findByExamplePage(TbFilmActorExample example);
}
