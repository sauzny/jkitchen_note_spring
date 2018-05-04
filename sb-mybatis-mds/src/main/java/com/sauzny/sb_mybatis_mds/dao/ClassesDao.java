package com.sauzny.sb_mybatis_mds.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sb_mybatis_mds.entity.pojo.Classes;
import com.sauzny.sb_mybatis_mds.entity.pojo.ClassesExample;

public interface ClassesDao extends ClassesMapper{

    // 获取所有数据
    List<Classes> findAll();

    // 分页查询
    Page<Classes> findByPage();

    // 分页查询带参数
    Page<Classes> findByExamplePage(ClassesExample example);
}
