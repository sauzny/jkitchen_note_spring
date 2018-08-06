package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbCity;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbCityMapper {
    long countByExample(TbCityExample example);

    int deleteByExample(TbCityExample example);

    @Delete({
        "delete from city",
        "where city_id = #{cityId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short cityId);

    @Insert({
        "insert into city (city_id, city, ",
        "country_id, last_update)",
        "values (#{cityId,jdbcType=SMALLINT}, #{city,jdbcType=VARCHAR}, ",
        "#{countryId,jdbcType=SMALLINT}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbCity record);

    int insertSelective(TbCity record);

    List<TbCity> selectByExample(TbCityExample example);

    @Select({
        "select",
        "city_id, city, country_id, last_update",
        "from city",
        "where city_id = #{cityId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbCityMapper.BaseResultMap")
    TbCity selectByPrimaryKey(Short cityId);

    int updateByExampleSelective(@Param("record") TbCity record, @Param("example") TbCityExample example);

    int updateByExample(@Param("record") TbCity record, @Param("example") TbCityExample example);

    int updateByPrimaryKeySelective(TbCity record);

    @Update({
        "update city",
        "set city = #{city,jdbcType=VARCHAR},",
          "country_id = #{countryId,jdbcType=SMALLINT},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where city_id = #{cityId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbCity record);
}