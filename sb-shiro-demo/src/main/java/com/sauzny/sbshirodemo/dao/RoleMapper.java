package com.sauzny.sbshirodemo.dao;

import com.sauzny.sbshirodemo.entity.pojo.Role;
import com.sauzny.sbshirodemo.entity.pojo.RoleExample;
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
        "delete from sys_role",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleId);

    @Insert({
        "insert into sys_role (role_id, role_name)",
        "values (#{roleId,jdbcType=BIGINT}, #{roleName,jdbcType=VARCHAR})"
    })
    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    @Select({
        "select",
        "role_id, role_name",
        "from sys_role",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    @ResultMap("com.sauzny.sbshirodemo.dao.RoleMapper.BaseResultMap")
    Role selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    @Update({
        "update sys_role",
        "set role_name = #{roleName,jdbcType=VARCHAR}",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Role record);
}