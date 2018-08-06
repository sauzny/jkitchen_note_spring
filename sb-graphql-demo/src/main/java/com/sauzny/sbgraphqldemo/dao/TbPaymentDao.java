package com.sauzny.sbgraphqldemo.dao;

public interface TbPaymentDao extends TbPaymentMapper{

}

import com.sauzny.sbgraphqldemo.entity.pojo.TbPayment;
import com.sauzny.sbgraphqldemo.entity.pojo.TbPaymentExample;

public interface TbPaymentDao extends TbPaymentMapper{

    // 获取所有数据
    List<TbPayment> findAll();

    // 分页查询
    Page<TbPayment> findByPage();

    // 分页查询带参数
    Page<TbPayment> findByExamplePage(TbPaymentExample example);
}
