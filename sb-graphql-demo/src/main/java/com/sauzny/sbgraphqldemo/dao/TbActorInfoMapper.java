package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbActorInfo;
import com.sauzny.sbgraphqldemo.entity.pojo.TbActorInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbActorInfoMapper {
    long countByExample(TbActorInfoExample example);

    int deleteByExample(TbActorInfoExample example);

    @Insert({
        "insert into actor_info (actor_id, first_name, ",
        "last_name, film_info)",
        "values (#{actorId,jdbcType=SMALLINT}, #{firstName,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{filmInfo,jdbcType=LONGVARCHAR})"
    })
    int insert(TbActorInfo record);

    int insertSelective(TbActorInfo record);

    List<TbActorInfo> selectByExampleWithBLOBs(TbActorInfoExample example);

    List<TbActorInfo> selectByExample(TbActorInfoExample example);

    int updateByExampleSelective(@Param("record") TbActorInfo record, @Param("example") TbActorInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TbActorInfo record, @Param("example") TbActorInfoExample example);

    int updateByExample(@Param("record") TbActorInfo record, @Param("example") TbActorInfoExample example);
}