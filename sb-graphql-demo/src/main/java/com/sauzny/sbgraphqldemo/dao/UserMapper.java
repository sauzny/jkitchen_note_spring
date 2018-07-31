package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.User;
import com.sauzny.sbgraphqldemo.entity.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
        "delete from tb_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tb_user (id, account, ",
        "create_time, creater_id, ",
        "last_update_time, password, ",
        "phone, role_id, salt, ",
        "user_name)",
        "values (#{id,jdbcType=BIGINT}, #{account,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createrId,jdbcType=BIGINT}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP}, #{password,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{roleId,jdbcType=INTEGER}, #{salt,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, account, create_time, creater_id, last_update_time, password, phone, role_id, ",
        "salt, user_name",
        "from tb_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update tb_user",
        "set account = #{account,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater_id = #{createrId,jdbcType=BIGINT},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "role_id = #{roleId,jdbcType=INTEGER},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}