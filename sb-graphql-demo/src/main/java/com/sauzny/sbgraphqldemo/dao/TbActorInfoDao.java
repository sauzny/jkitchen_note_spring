package com.sauzny.sbgraphqldemo.dao;

public interface TbActorInfoDao extends TbActorInfoMapper{

}
ort com.sauzny.sbgraphqldemo.entity.pojo.TbActorInfo;
import com.sauzny.sbgraphqldemo.entity.pojo.TbActorInfoExample;

public interface TbActorInfoDao extends TbActorInfoMapper{

    // 获取所有数据
    List<TbActorInfo> findAll();

    // 分页查询
    Page<TbActorInfo> findByPage();

    // 分页查询带参数
    Page<TbActorInfo> findByExamplePage(TbActorInfoExample example);
}
