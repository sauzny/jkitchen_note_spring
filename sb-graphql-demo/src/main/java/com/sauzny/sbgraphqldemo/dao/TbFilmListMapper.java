package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmList;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmListExample;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmListWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbFilmListMapper {
    long countByExample(TbFilmListExample example);

    int deleteByExample(TbFilmListExample example);

    @Insert({
        "insert into film_list (FID, title, ",
        "category, price, ",
        "length, rating, description, ",
        "actors)",
        "values (#{fid,jdbcType=SMALLINT}, #{title,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{length,jdbcType=SMALLINT}, #{rating,jdbcType=CHAR}, #{description,jdbcType=LONGVARCHAR}, ",
        "#{actors,jdbcType=LONGVARCHAR})"
    })
    int insert(TbFilmListWithBLOBs record);

    int insertSelective(TbFilmListWithBLOBs record);

    List<TbFilmListWithBLOBs> selectByExampleWithBLOBs(TbFilmListExample example);

    List<TbFilmList> selectByExample(TbFilmListExample example);

    int updateByExampleSelective(@Param("record") TbFilmListWithBLOBs record, @Param("example") TbFilmListExample example);

    int updateByExampleWithBLOBs(@Param("record") TbFilmListWithBLOBs record, @Param("example") TbFilmListExample example);

    int updateByExample(@Param("record") TbFilmList record, @Param("example") TbFilmListExample example);
}