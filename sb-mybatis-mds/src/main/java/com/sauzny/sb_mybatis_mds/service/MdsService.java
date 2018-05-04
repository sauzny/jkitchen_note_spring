package com.sauzny.sb_mybatis_mds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.sb_mybatis_mds.config.dds.ChooseDDS;
import com.sauzny.sb_mybatis_mds.config.dds.DDS;
import com.sauzny.sb_mybatis_mds.dao.IncomeDao;
import com.sauzny.sb_mybatis_mds.dao.UserDao;

@Service
public class MdsService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private IncomeDao incomeDao;
    
    // 不写注解使用默认数据源
    //@ChooseDDS(DDS.sbw)
    public String ds1() {
        return userDao.selectByPrimaryKey(1L).getUserName();
    }

    @ChooseDDS(DDS.mds)
    public Long ds2() {
        return incomeDao.selectByPrimaryKey(1L).getUserId();
    }
}
