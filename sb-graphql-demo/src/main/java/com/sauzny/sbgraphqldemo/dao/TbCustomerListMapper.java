package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbCustomerList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCustomerListExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbCustomerListMapper {
    long countByExample(TbCustomerListExample example);

    int deleteByExample(TbCustomerListExample example);

    @Insert({
        "insert into customer_list (ID, name, ",
        "address, \"zip code\", ",
        "phone, city, country, ",
        "notes, SID)",
        "values (#{id,jdbcType=SMALLINT}, #{name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{zipCode,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, #{country,jdbcType=VARCHAR}, ",
        "#{notes,jdbcType=VARCHAR}, #{sid,jdbcType=TINYINT})"
    })
    int insert(TbCustomerList record);

    int insertSelective(TbCustomerList record);

    List<TbCustomerList> selectByExample(TbCustomerListExample example);

    int updateByExampleSelective(@Param("record") TbCustomerList record, @Param("example") TbCustomerListExample example);

    int updateByExample(@Param("record") TbCustomerList record, @Param("example") TbCustomerListExample example);
}