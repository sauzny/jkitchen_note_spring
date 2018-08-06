package com.sauzny.sbgraphqldemo.dao;

public interface TbNicerButSlowerFilmListDao extends TbNicerButSlowerFilmListMapper{

}
mo.entity.pojo.TbNicerButSlowerFilmList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbNicerButSlowerFilmListExample;

public interface TbNicerButSlowerFilmListDao extends TbNicerButSlowerFilmListMapper{

    // 获取所有数据
    List<TbNicerButSlowerFilmList> findAll();

    // 分页查询
    Page<TbNicerButSlowerFilmList> findByPage();

    // 分页查询带参数
    Page<TbNicerButSlowerFilmList> findByExamplePage(TbNicerButSlowerFilmListExample example);
}
