package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.Role;
import com.sauzny.springbootweb.entity.pojo.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    @Delete({
        "delete from tb_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_role (id, name, ",
        "user_id, status, ",
        "cst_create, cst_modified)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{cstCreate,jdbcType=TIMESTAMP}, #{cstModified,jdbcType=TIMESTAMP})"
    })
    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    @Select({
        "select",
        "id, name, user_id, status, cst_create, cst_modified",
        "from tb_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.sauzny.springbootweb.dao.RoleMapper.BaseResultMap")
    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    @Update({
        "update tb_role",
        "set name = #{name,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "cst_create = #{cstCreate,jdbcType=TIMESTAMP},",
          "cst_modified = #{cstModified,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Role record);
}