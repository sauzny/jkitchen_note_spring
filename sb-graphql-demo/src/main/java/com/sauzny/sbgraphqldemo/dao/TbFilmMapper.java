package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbFilm;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbFilmMapper {
    long countByExample(TbFilmExample example);

    int deleteByExample(TbFilmExample example);

    @Delete({
        "delete from film",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short filmId);

    @Insert({
        "insert into film (film_id, title, ",
        "release_year, language_id, ",
        "original_language_id, rental_duration, ",
        "rental_rate, length, ",
        "replacement_cost, rating, ",
        "special_features, last_update, ",
        "description)",
        "values (#{filmId,jdbcType=SMALLINT}, #{title,jdbcType=VARCHAR}, ",
        "#{releaseYear,jdbcType=DATE}, #{languageId,jdbcType=TINYINT}, ",
        "#{originalLanguageId,jdbcType=TINYINT}, #{rentalDuration,jdbcType=TINYINT}, ",
        "#{rentalRate,jdbcType=DECIMAL}, #{length,jdbcType=SMALLINT}, ",
        "#{replacementCost,jdbcType=DECIMAL}, #{rating,jdbcType=CHAR}, ",
        "#{specialFeatures,jdbcType=CHAR}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=LONGVARCHAR})"
    })
    int insert(TbFilm record);

    int insertSelective(TbFilm record);

    List<TbFilm> selectByExampleWithBLOBs(TbFilmExample example);

    List<TbFilm> selectByExample(TbFilmExample example);

    @Select({
        "select",
        "film_id, title, release_year, language_id, original_language_id, rental_duration, ",
        "rental_rate, length, replacement_cost, rating, special_features, last_update, ",
        "description",
        "from film",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbFilmMapper.ResultMapWithBLOBs")
    TbFilm selectByPrimaryKey(Short filmId);

    int updateByExampleSelective(@Param("record") TbFilm record, @Param("example") TbFilmExample example);

    int updateByExampleWithBLOBs(@Param("record") TbFilm record, @Param("example") TbFilmExample example);

    int updateByExample(@Param("record") TbFilm record, @Param("example") TbFilmExample example);

    int updateByPrimaryKeySelective(TbFilm record);

    @Update({
        "update film",
        "set title = #{title,jdbcType=VARCHAR},",
          "release_year = #{releaseYear,jdbcType=DATE},",
          "language_id = #{languageId,jdbcType=TINYINT},",
          "original_language_id = #{originalLanguageId,jdbcType=TINYINT},",
          "rental_duration = #{rentalDuration,jdbcType=TINYINT},",
          "rental_rate = #{rentalRate,jdbcType=DECIMAL},",
          "length = #{length,jdbcType=SMALLINT},",
          "replacement_cost = #{replacementCost,jdbcType=DECIMAL},",
          "rating = #{rating,jdbcType=CHAR},",
          "special_features = #{specialFeatures,jdbcType=CHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TbFilm record);

    @Update({
        "update film",
        "set title = #{title,jdbcType=VARCHAR},",
          "release_year = #{releaseYear,jdbcType=DATE},",
          "language_id = #{languageId,jdbcType=TINYINT},",
          "original_language_id = #{originalLanguageId,jdbcType=TINYINT},",
          "rental_duration = #{rentalDuration,jdbcType=TINYINT},",
          "rental_rate = #{rentalRate,jdbcType=DECIMAL},",
          "length = #{length,jdbcType=SMALLINT},",
          "replacement_cost = #{replacementCost,jdbcType=DECIMAL},",
          "rating = #{rating,jdbcType=CHAR},",
          "special_features = #{specialFeatures,jdbcType=CHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbFilm record);
}