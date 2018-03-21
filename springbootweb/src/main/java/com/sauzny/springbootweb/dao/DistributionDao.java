package com.sauzny.springbootweb.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.entity.pojo.Distribution;

public interface DistributionDao extends DistributionMapper{

    // 获取所有数据
    List<Distribution> findAll();

    // 分页查询
    Page<Distribution> findByPage();
}
