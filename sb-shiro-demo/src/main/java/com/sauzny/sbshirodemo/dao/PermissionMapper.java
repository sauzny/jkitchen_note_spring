package com.sauzny.sbshirodemo.dao;

import com.sauzny.sbshirodemo.entity.pojo.Permission;
import com.sauzny.sbshirodemo.entity.pojo.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    @Delete({
        "delete from sys_permission",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_permission (id, parent_id, ",
        "res_name, res_type, ",
        "permission, url)",
        "values (#{id,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{resName,jdbcType=VARCHAR}, #{resType,jdbcType=VARCHAR}, ",
        "#{permission,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR})"
    })
    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    @Select({
        "select",
        "id, parent_id, res_name, res_type, permission, url",
        "from sys_permission",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.sauzny.sbshirodemo.dao.PermissionMapper.BaseResultMap")
    Permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    @Update({
        "update sys_permission",
        "set parent_id = #{parentId,jdbcType=BIGINT},",
          "res_name = #{resName,jdbcType=VARCHAR},",
          "res_type = #{resType,jdbcType=VARCHAR},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Permission record);
}