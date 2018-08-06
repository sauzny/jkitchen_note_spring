package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmActor;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmActorExample;
import com.sauzny.sbgraphqldemo.entity.pojo.TbFilmActorKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbFilmActorMapper {
    long countByExample(TbFilmActorExample example);

    int deleteByExample(TbFilmActorExample example);

    @Delete({
        "delete from film_actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}",
          "and film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(TbFilmActorKey key);

    @Insert({
        "insert into film_actor (actor_id, film_id, ",
        "last_update)",
        "values (#{actorId,jdbcType=SMALLINT}, #{filmId,jdbcType=SMALLINT}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbFilmActor record);

    int insertSelective(TbFilmActor record);

    List<TbFilmActor> selectByExample(TbFilmActorExample example);

    @Select({
        "select",
        "actor_id, film_id, last_update",
        "from film_actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}",
          "and film_id = #{filmId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbFilmActorMapper.BaseResultMap")
    TbFilmActor selectByPrimaryKey(TbFilmActorKey key);

    int updateByExampleSelective(@Param("record") TbFilmActor record, @Param("example") TbFilmActorExample example);

    int updateByExample(@Param("record") TbFilmActor record, @Param("example") TbFilmActorExample example);

    int updateByPrimaryKeySelective(TbFilmActor record);

    @Update({
        "update film_actor",
        "set last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where actor_id = #{actorId,jdbcType=SMALLINT}",
          "and film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbFilmActor record);
}