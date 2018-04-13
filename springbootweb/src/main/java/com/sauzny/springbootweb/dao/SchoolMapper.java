package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.School;
import com.sauzny.springbootweb.entity.pojo.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SchoolMapper {
    long countByExample(SchoolExample example);

    int deleteByExample(SchoolExample example);

    @Delete({
        "delete from tb_school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_school (id, name, ",
        "address, create_time, ",
        "last_update_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP})"
    })
    int insert(School record);

    int insertSelective(School record);

    List<School> selectByExample(SchoolExample example);

    @Select({
        "select",
        "id, name, address, create_time, last_update_time",
        "from tb_school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.sauzny.springbootweb.dao.SchoolMapper.BaseResultMap")
    School selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByPrimaryKeySelective(School record);

    @Update({
        "update tb_school",
        "set name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(School record);
}