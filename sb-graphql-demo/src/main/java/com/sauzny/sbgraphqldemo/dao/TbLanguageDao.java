package com.sauzny.sbgraphqldemo.dao;

public interface TbLanguageDao extends TbLanguageMapper{

}
mport com.sauzny.sbgraphqldemo.entity.pojo.TbLanguage;
import com.sauzny.sbgraphqldemo.entity.pojo.TbLanguageExample;

public interface TbLanguageDao extends TbLanguageMapper{

    // 获取所有数据
    List<TbLanguage> findAll();

    // 分页查询
    Page<TbLanguage> findByPage();

    // 分页查询带参数
    Page<TbLanguage> findByExamplePage(TbLanguageExample example);
}
