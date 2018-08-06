package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbCategory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbCategoryMapper {
    long countByExample(TbCategoryExample example);

    int deleteByExample(TbCategoryExample example);

    @Delete({
        "delete from category",
        "where category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte categoryId);

    @Insert({
        "insert into category (category_id, name, ",
        "last_update)",
        "values (#{categoryId,jdbcType=TINYINT}, #{name,jdbcType=VARCHAR}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbCategory record);

    int insertSelective(TbCategory record);

    List<TbCategory> selectByExample(TbCategoryExample example);

    @Select({
        "select",
        "category_id, name, last_update",
        "from category",
        "where category_id = #{categoryId,jdbcType=TINYINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbCategoryMapper.BaseResultMap")
    TbCategory selectByPrimaryKey(Byte categoryId);

    int updateByExampleSelective(@Param("record") TbCategory record, @Param("example") TbCategoryExample example);

    int updateByExample(@Param("record") TbCategory record, @Param("example") TbCategoryExample example);

    int updateByPrimaryKeySelective(TbCategory record);

    @Update({
        "update category",
        "set name = #{name,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(TbCategory record);
}