package com.sauzny.sb_mybatis_mds.dao;

import com.sauzny.sb_mybatis_mds.entity.pojo.Income;
import com.sauzny.sb_mybatis_mds.entity.pojo.IncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IncomeMapper {
    long countByExample(IncomeExample example);

    int deleteByExample(IncomeExample example);

    @Delete({
        "delete from income",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into income (id, user_id, ",
        "income_date, total_income, ",
        "total_commission, total_proxy_income, ",
        "net_income, commission, ",
        "proxy_income, order_count, ",
        "proxy_new_count, create_time, ",
        "last_update_time)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{incomeDate,jdbcType=TIMESTAMP}, #{totalIncome,jdbcType=INTEGER}, ",
        "#{totalCommission,jdbcType=INTEGER}, #{totalProxyIncome,jdbcType=INTEGER}, ",
        "#{netIncome,jdbcType=INTEGER}, #{commission,jdbcType=INTEGER}, ",
        "#{proxyIncome,jdbcType=INTEGER}, #{orderCount,jdbcType=INTEGER}, ",
        "#{proxyNewCount,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Income record);

    int insertSelective(Income record);

    List<Income> selectByExample(IncomeExample example);

    @Select({
        "select",
        "id, user_id, income_date, total_income, total_commission, total_proxy_income, ",
        "net_income, commission, proxy_income, order_count, proxy_new_count, create_time, ",
        "last_update_time",
        "from income",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.sauzny.sb_mybatis_mds.dao.IncomeMapper.BaseResultMap")
    Income selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Income record, @Param("example") IncomeExample example);

    int updateByExample(@Param("record") Income record, @Param("example") IncomeExample example);

    int updateByPrimaryKeySelective(Income record);

    @Update({
        "update income",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "income_date = #{incomeDate,jdbcType=TIMESTAMP},",
          "total_income = #{totalIncome,jdbcType=INTEGER},",
          "total_commission = #{totalCommission,jdbcType=INTEGER},",
          "total_proxy_income = #{totalProxyIncome,jdbcType=INTEGER},",
          "net_income = #{netIncome,jdbcType=INTEGER},",
          "commission = #{commission,jdbcType=INTEGER},",
          "proxy_income = #{proxyIncome,jdbcType=INTEGER},",
          "order_count = #{orderCount,jdbcType=INTEGER},",
          "proxy_new_count = #{proxyNewCount,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Income record);
}