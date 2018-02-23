package com.sauzny.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.springmvc.dao.mapper.TbUserMapper;
import com.sauzny.springmvc.entity.pojo.TbUser;
import com.sauzny.springmvc.entity.pojo.TbUserExample;
import com.sauzny.springmvc.entity.pojo.TbUserExample.Criteria;

/**
 * *************************************************************************
 * @文件名称: UserService.java
 *
 * @包路径  : com.sauzny.springmvc.service 
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   TODO
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年9月1日 - 下午4:46:38 
 *	
 **************************************************************************
 */

@Service
public class UserService {

    @Autowired
    private TbUserMapper tbUserMapper;
    
    public TbUser selectOneById(int id){
        return tbUserMapper.selectByPrimaryKey(id);
    }
    
    public List<TbUser> selectByAccount(String account){
        
        TbUserExample example = new TbUserExample();
        Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        return tbUserMapper.selectByExample(example);
    }
}
