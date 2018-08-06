package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbStaffList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStaffListExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbStaffListMapper {
    long countByExample(TbStaffListExample example);

    int deleteByExample(TbStaffListExample example);

    @Insert({
        "insert into staff_list (ID, name, ",
        "address, \"zip code\", ",
        "phone, city, country, ",
        "SID)",
        "values (#{id,jdbcType=TINYINT}, #{name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{zipCode,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, #{country,jdbcType=VARCHAR}, ",
        "#{sid,jdbcType=TINYINT})"
    })
    int insert(TbStaffList record);

    int insertSelective(TbStaffList record);

    List<TbStaffList> selectByExample(TbStaffListExample example);

    int updateByExampleSelective(@Param("record") TbStaffList record, @Param("example") TbStaffListExample example);

    int updateByExample(@Param("record") TbStaffList record, @Param("example") TbStaffListExample example);
}