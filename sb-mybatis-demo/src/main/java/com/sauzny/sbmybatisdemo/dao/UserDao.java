package com.sauzny.sbmybatisdemo.dao;

import com.sauzny.sbmybatisdemo.dao.mapper.UserMapper;
import com.sauzny.sbmybatisdemo.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.mybatis.dynamic.sql.where.render.WhereClauseProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends UserMapper {

    // 自定义 select sql
    @Select({
            "select a.user_id, a.user_email",
            "from USER a",
            "${whereClause}"
    })
    @ResultMap("UserResult")
    List<User> selectByExample(WhereClauseProvider whereClause);

    // 自定义返回类型
}
