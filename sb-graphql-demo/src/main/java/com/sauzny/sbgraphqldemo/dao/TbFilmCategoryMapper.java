package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmCategory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmCategoryExample;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmCategoryKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbFilmCategoryMapper {
    long countByExample(TbFilmCategoryExample example);

    int deleteByExample(TbFilmCategoryExample example);

    @Delete({
        "delete from film_category",
        "where film_id = #{filmId,jdbcType=SMALLINT}",
          "and category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(TbFilmCategoryKey key);

    @Insert({
        "insert into film_category (film_id, category_id, ",
        "last_update)",
        "values (#{filmId,jdbcType=SMALLINT}, #{categoryId,jdbcType=TINYINT}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbFilmCategory record);

    int insertSelective(TbFilmCategory record);

    List<TbFilmCategory> selectByExample(TbFilmCategoryExample example);

    @Select({
        "select",
        "film_id, category_id, last_update",
        "from film_category",
        "where film_id = #{filmId,jdbcType=SMALLINT}",
          "and category_id = #{categoryId,jdbcType=TINYINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbFilmCategoryMapper.BaseResultMap")
    TbFilmCategory selectByPrimaryKey(TbFilmCategoryKey key);

    int updateByExampleSelective(@Param("record") TbFilmCategory record, @Param("example") TbFilmCategoryExample example);

    int updateByExample(@Param("record") TbFilmCategory record, @Param("example") TbFilmCategoryExample example);

    int updateByPrimaryKeySelective(TbFilmCategory record);

    @Update({
        "update film_category",
        "set last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where film_id = #{filmId,jdbcType=SMALLINT}",
          "and category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(TbFilmCategory record);
}