package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.User;
import com.sauzny.springbootweb.entity.pojo.UserExample;
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
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_user (id, username, ",
        "password, salt, ",
        "status, nickname, ",
        "phone, creater_id, ",
        "cst_create, cst_modified)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{nickname,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{createrId,jdbcType=INTEGER}, ",
        "#{cstCreate,jdbcType=TIMESTAMP}, #{cstModified,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, username, password, salt, status, nickname, phone, creater_id, cst_create, ",
        "cst_modified",
        "from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.sauzny.springbootweb.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update tb_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "creater_id = #{createrId,jdbcType=INTEGER},",
          "cst_create = #{cstCreate,jdbcType=TIMESTAMP},",
          "cst_modified = #{cstModified,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}