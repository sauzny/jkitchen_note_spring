package com.sauzny.sbgraphqldemo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStaffList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStaffListExample;

public interface TbStaffListDao extends TbStaffListMapper{

    // 获取所有数据
    List<TbStaffList> findAll();

    // 分页查询
    Page<TbStaffList> findByPage();

    // 分页查询带参数
    Page<TbStaffList> findByExamplePage(TbStaffListExample example);
}
