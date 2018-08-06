package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStaff;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStaffExample;

public interface TbStaffDao extends TbStaffMapper{

    // 获取所有数据
    List<TbStaff> findAll();

    // 分页查询
    Page<TbStaff> findByPage();

    // 分页查询带参数
    Page<TbStaff> findByExamplePage(TbStaffExample example);
}
