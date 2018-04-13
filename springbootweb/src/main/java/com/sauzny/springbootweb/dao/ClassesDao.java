package com.sauzny.springbootweb.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.entity.pojo.Classes;

public interface ClassesDao extends ClassesMapper{

    // 获取所有数据
    List<Classes> findAll();

    // 分页查询
    Page<Classes> findByPage();
}
