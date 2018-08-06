package com.sauzny.sb_mybatis_mds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sauzny.sb_mybatis_mds.config.dds.DDS;
import com.sauzny.sb_mybatis_mds.config.dds.DynamicDataSourceHolder;
import com.sauzny.sb_mybatis_mds.config.dds.TargetDataSource;
import com.sauzny.sb_mybatis_mds.dao.IncomeDao;
import com.sauzny.sb_mybatis_mds.dao.UserDao;
import com.sauzny.sb_mybatis_mds.entity.pojo.Income;
import com.sauzny.sb_mybatis_mds.entity.pojo.IncomeExample;
import com.sauzny.sb_mybatis_mds.entity.pojo.User;
import com.sauzny.sb_mybatis_mds.entity.pojo.UserExample;
import com.sauzny.sb_mybatis_mds.utils.TestDataUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MdsService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private IncomeDao incomeDao;
    
    // 不写注解使用默认数据源
    //@TargetDataSource(DDS.sbw)
    public String ds1() {
        return userDao.selectByPrimaryKey(1L).getUserName();
    }
    
    @TargetDataSource(DDS.mds)
    public Long ds2() {

        IncomeExample example = new IncomeExample();
        IncomeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(116L);
        
        Page<Income> income1 = PageHelper.startPage(1, 10).doSelectPage(() -> incomeDao.selectByExample(example));

        log.info("income1 {}", income1);
        log.info("income1 {}", income1.getResult().get(0).getUserId());
        
        return incomeDao.selectByPrimaryKey(1L).getUserId();
    }

    @TargetDataSource(DDS.sbw)
    public void ds1a2(){

        UserExample example1 = new UserExample();
        UserExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andIdEqualTo(1L);
        
        Page<User> user1 = PageHelper.startPage(1, 10).doSelectPage(() -> userDao.selectByExample(example1));

        log.info("user1 {}", user1);
        log.info("user1 {}", user1.getResult().get(0).getId());
        
        
        IncomeExample example = new IncomeExample();
        IncomeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(116L);
        
        // 切换数据源，自行理解
        DynamicDataSourceHolder.setDataSource(DDS.mds);
        Page<Income> income1 = PageHelper.startPage(1, 10).doSelectPage(() -> incomeDao.selectByExample(example));

        log.info("income1 {}", income1);
        log.info("income1 {}", income1.getResult().get(0).getUserId());
        
    }
    
    @Transactional
    public boolean insertUser(){
        
        User record = TestDataUtils.user();
        record.setId(999999L);
        
        try{
            userDao.insertSelective(record);
            userDao.insertSelective(record);
        }catch(Exception e){
            log.warn("insertUser 插入出错", e);
        }
        
        return true;
    }
    
    @Transactional
    @TargetDataSource(DDS.mds)
    public boolean insertIncome(){
        
        Income record = TestDataUtils.income();
        record.setId(999999L);
        
        try{
            incomeDao.insertSelective(record);
            incomeDao.insertSelective(record);
        }catch(Exception e){
            log.warn("insertIncome 插入出错", e);
        }
        
        return true;
    }
}
