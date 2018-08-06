package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbCountry;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCountryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbCountryMapper {
    long countByExample(TbCountryExample example);

    int deleteByExample(TbCountryExample example);

    @Delete({
        "delete from country",
        "where country_id = #{countryId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short countryId);

    @Insert({
        "insert into country (country_id, country, ",
        "last_update)",
        "values (#{countryId,jdbcType=SMALLINT}, #{country,jdbcType=VARCHAR}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbCountry record);

    int insertSelective(TbCountry record);

    List<TbCountry> selectByExample(TbCountryExample example);

    @Select({
        "select",
        "country_id, country, last_update",
        "from country",
        "where country_id = #{countryId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbCountryMapper.BaseResultMap")
    TbCountry selectByPrimaryKey(Short countryId);

    int updateByExampleSelective(@Param("record") TbCountry record, @Param("example") TbCountryExample example);

    int updateByExample(@Param("record") TbCountry record, @Param("example") TbCountryExample example);

    int updateByPrimaryKeySelective(TbCountry record);

    @Update({
        "update country",
        "set country = #{country,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where country_id = #{countryId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbCountry record);
}