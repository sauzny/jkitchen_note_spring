package com.sauzny.springbootweb.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.entity.pojo.Product;

public interface ProductDao extends ProductMapper{

    // 获取所有数据
    List<Product> findAll();

    // 分页查询
    Page<Product> findByPage();
}
