package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmText;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmTextExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbFilmTextMapper {
    long countByExample(TbFilmTextExample example);

    int deleteByExample(TbFilmTextExample example);

    @Delete({
        "delete from film_text",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short filmId);

    @Insert({
        "insert into film_text (film_id, title, ",
        "description)",
        "values (#{filmId,jdbcType=SMALLINT}, #{title,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=LONGVARCHAR})"
    })
    int insert(TbFilmText record);

    int insertSelective(TbFilmText record);

    List<TbFilmText> selectByExampleWithBLOBs(TbFilmTextExample example);

    List<TbFilmText> selectByExample(TbFilmTextExample example);

    @Select({
        "select",
        "film_id, title, description",
        "from film_text",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbFilmTextMapper.ResultMapWithBLOBs")
    TbFilmText selectByPrimaryKey(Short filmId);

    int updateByExampleSelective(@Param("record") TbFilmText record, @Param("example") TbFilmTextExample example);

    int updateByExampleWithBLOBs(@Param("record") TbFilmText record, @Param("example") TbFilmTextExample example);

    int updateByExample(@Param("record") TbFilmText record, @Param("example") TbFilmTextExample example);

    int updateByPrimaryKeySelective(TbFilmText record);

    @Update({
        "update film_text",
        "set title = #{title,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TbFilmText record);

    @Update({
        "update film_text",
        "set title = #{title,jdbcType=VARCHAR}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbFilmText record);
}