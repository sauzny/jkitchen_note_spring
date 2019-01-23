package com.sauzny.sbshirodemo.service;

import com.sauzny.sbshirodemo.dao.UserDao;
import com.sauzny.sbshirodemo.entity.pojo.User;
import com.sauzny.sbshirodemo.entity.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/***************************************************************************
 *
 * @时间: 2018/12/28 - 10:05
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByUserName(String userName){

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);

        List<User> userList = userDao.selectByExample(example);
        if(userList ==null || userList.size() ==0){
            return null;
        }else{
            return userList.get(0);
        }
    }
}
