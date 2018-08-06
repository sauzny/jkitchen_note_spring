package com.sauzny.sbgraphqldemo.dao;

public interface TbFilmTextDao extends TbFilmTextMapper{

}
mport com.sauzny.sbgraphqldemo.entity.pojo.TbFilmText;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmTextExample;

public interface TbFilmTextDao extends TbFilmTextMapper{

    // 获取所有数据
    List<TbFilmText> findAll();

    // 分页查询
    Page<TbFilmText> findByPage();

    // 分页查询带参数
    Page<TbFilmText> findByExamplePage(TbFilmTextExample example);
}
