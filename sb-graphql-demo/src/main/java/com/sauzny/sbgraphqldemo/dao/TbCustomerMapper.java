package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbCustomer;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbCustomerMapper {
    long countByExample(TbCustomerExample example);

    int deleteByExample(TbCustomerExample example);

    @Delete({
        "delete from customer",
        "where customer_id = #{customerId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short customerId);

    @Insert({
        "insert into customer (customer_id, store_id, ",
        "first_name, last_name, ",
        "email, address_id, ",
        "active, create_date, ",
        "last_update)",
        "values (#{customerId,jdbcType=SMALLINT}, #{storeId,jdbcType=TINYINT}, ",
        "#{firstName,jdbcType=VARCHAR}, #{lastName,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{addressId,jdbcType=SMALLINT}, ",
        "#{active,jdbcType=BIT}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbCustomer record);

    int insertSelective(TbCustomer record);

    List<TbCustomer> selectByExample(TbCustomerExample example);

    @Select({
        "select",
        "customer_id, store_id, first_name, last_name, email, address_id, active, create_date, ",
        "last_update",
        "from customer",
        "where customer_id = #{customerId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbCustomerMapper.BaseResultMap")
    TbCustomer selectByPrimaryKey(Short customerId);

    int updateByExampleSelective(@Param("record") TbCustomer record, @Param("example") TbCustomerExample example);

    int updateByExample(@Param("record") TbCustomer record, @Param("example") TbCustomerExample example);

    int updateByPrimaryKeySelective(TbCustomer record);

    @Update({
        "update customer",
        "set store_id = #{storeId,jdbcType=TINYINT},",
          "first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "active = #{active,jdbcType=BIT},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where customer_id = #{customerId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbCustomer record);
}