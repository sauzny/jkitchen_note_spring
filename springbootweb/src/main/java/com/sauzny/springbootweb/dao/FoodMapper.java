package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.Food;
import com.sauzny.springbootweb.entity.pojo.FoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FoodMapper {
    long countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    @Delete({
        "delete from tb_food",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_food (id, name, ",
        "price, seller_id, ",
        "create_time, last_update_time, ",
        "creater_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=INTEGER}, #{sellerId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{createrId,jdbcType=INTEGER})"
    })
    int insert(Food record);

    int insertSelective(Food record);

    List<Food> selectByExample(FoodExample example);

    @Select({
        "select",
        "id, name, price, seller_id, create_time, last_update_time, creater_id",
        "from tb_food",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.sauzny.springbootweb.dao.FoodMapper.BaseResultMap")
    Food selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food record);

    @Update({
        "update tb_food",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "seller_id = #{sellerId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "creater_id = #{createrId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Food record);
}