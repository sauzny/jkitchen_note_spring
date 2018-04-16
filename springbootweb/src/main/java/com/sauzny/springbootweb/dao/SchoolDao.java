package com.sauzny.springbootweb.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.entity.pojo.School;

public interface SchoolDao extends SchoolMapper{

    // 获取所有数据
    List<School> findAll();

    // 分页查询
    Page<School> findByPage();
}
