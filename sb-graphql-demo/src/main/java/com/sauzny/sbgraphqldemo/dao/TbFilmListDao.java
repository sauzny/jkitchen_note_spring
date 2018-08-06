package com.sauzny.sbgraphqldemo.dao;

public interface TbFilmListDao extends TbFilmListMapper{

}
mport com.sauzny.sbgraphqldemo.entity.pojo.TbFilmList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmListExample;

public interface TbFilmListDao extends TbFilmListMapper{

    // 获取所有数据
    List<TbFilmList> findAll();

    // 分页查询
    Page<TbFilmList> findByPage();

    // 分页查询带参数
    Page<TbFilmList> findByExamplePage(TbFilmListExample example);
}
