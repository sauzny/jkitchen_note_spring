package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbNicerButSlowerFilmList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbNicerButSlowerFilmListExample;
import com.sauzny.sbgraphqldemo.entity.pojo.TbNicerButSlowerFilmListWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbNicerButSlowerFilmListMapper {
    long countByExample(TbNicerButSlowerFilmListExample example);

    int deleteByExample(TbNicerButSlowerFilmListExample example);

    @Insert({
        "insert into nicer_but_slower_film_list (FID, title, ",
        "category, price, ",
        "length, rating, description, ",
        "actors)",
        "values (#{fid,jdbcType=SMALLINT}, #{title,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{length,jdbcType=SMALLINT}, #{rating,jdbcType=CHAR}, #{description,jdbcType=LONGVARCHAR}, ",
        "#{actors,jdbcType=LONGVARCHAR})"
    })
    int insert(TbNicerButSlowerFilmListWithBLOBs record);

    int insertSelective(TbNicerButSlowerFilmListWithBLOBs record);

    List<TbNicerButSlowerFilmListWithBLOBs> selectByExampleWithBLOBs(TbNicerButSlowerFilmListExample example);

    List<TbNicerButSlowerFilmList> selectByExample(TbNicerButSlowerFilmListExample example);

    int updateByExampleSelective(@Param("record") TbNicerButSlowerFilmListWithBLOBs record, @Param("example") TbNicerButSlowerFilmListExample example);

    int updateByExampleWithBLOBs(@Param("record") TbNicerButSlowerFilmListWithBLOBs record, @Param("example") TbNicerButSlowerFilmListExample example);

    int updateByExample(@Param("record") TbNicerButSlowerFilmList record, @Param("example") TbNicerButSlowerFilmListExample example);
}