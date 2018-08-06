package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbActor;
import com.sauzny.sbgraphqldemo.entity.pojo.TbActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbActorMapper {
    long countByExample(TbActorExample example);

    int deleteByExample(TbActorExample example);

    @Delete({
        "delete from actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short actorId);

    @Insert({
        "insert into actor (actor_id, first_name, ",
        "last_name, last_update)",
        "values (#{actorId,jdbcType=SMALLINT}, #{firstName,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbActor record);

    int insertSelective(TbActor record);

    List<TbActor> selectByExample(TbActorExample example);

    @Select({
        "select",
        "actor_id, first_name, last_name, last_update",
        "from actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbActorMapper.BaseResultMap")
    TbActor selectByPrimaryKey(Short actorId);

    int updateByExampleSelective(@Param("record") TbActor record, @Param("example") TbActorExample example);

    int updateByExample(@Param("record") TbActor record, @Param("example") TbActorExample example);

    int updateByPrimaryKeySelective(TbActor record);

    @Update({
        "update actor",
        "set first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where actor_id = #{actorId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbActor record);
}