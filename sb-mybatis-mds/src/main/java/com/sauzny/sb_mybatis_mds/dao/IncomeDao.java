package com.sauzny.sb_mybatis_mds.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.sauzny.sb_mybatis_mds.entity.pojo.Income;
import com.sauzny.sb_mybatis_mds.entity.pojo.IncomeExample;

public interface IncomeDao extends IncomeMapper{

    // 获取所有数据
    List<Income> findAll();

    // 分页查询
    Page<Income> findByPage();

    // 分页查询带参数
    Page<Income> findByExamplePage(IncomeExample example);
}
