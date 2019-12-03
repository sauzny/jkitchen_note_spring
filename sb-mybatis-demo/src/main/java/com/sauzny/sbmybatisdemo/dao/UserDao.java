package com.sauzny.sbmybatisdemo.dao;

import com.sauzny.sbmybatisdemo.dao.mapper.UserMapper;
import com.sauzny.sbmybatisdemo.entity.bo.FatUser;
import com.sauzny.sbmybatisdemo.entity.po.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
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
    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="FatUserResult", value={
            @Result(column="USER_ID", property="userId", jdbcType= JdbcType.INTEGER),
            @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="COMPANY_ID", property="companyId", jdbcType=JdbcType.INTEGER),
            @Result(column="COMPANY_NAME", property="companyName", jdbcType=JdbcType.VARCHAR)
    })
    List<FatUser> selectFatUserMany(SelectStatementProvider selectStatement);
}
