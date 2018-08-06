package com.sauzny.sbgraphqldemo.dao;

public interface TbStoreDao extends TbStoreMapper{

}
ge;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStore;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStoreExample;

public interface TbStoreDao extends TbStoreMapper{

    // 获取所有数据
    List<TbStore> findAll();

    // 分页查询
    Page<TbStore> findByPage();

    // 分页查询带参数
    Page<TbStore> findByExamplePage(TbStoreExample example);
}
