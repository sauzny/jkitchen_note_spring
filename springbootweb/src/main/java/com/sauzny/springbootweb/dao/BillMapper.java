package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.Bill;
import com.sauzny.springbootweb.entity.pojo.BillExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BillMapper {
    long countByExample(BillExample example);

    int deleteByExample(BillExample example);

    @Delete({
        "delete from tb_bill",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_bill (id, buyer_id, ",
        "seller_id, foods, total_price, ",
        "create_time, last_update_time, ",
        "creater_id)",
        "values (#{id,jdbcType=INTEGER}, #{buyerId,jdbcType=INTEGER}, ",
        "#{sellerId,jdbcType=INTEGER}, #{foods,jdbcType=OTHER}, #{totalPrice,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{createrId,jdbcType=INTEGER})"
    })
    int insert(Bill record);

    int insertSelective(Bill record);

    List<Bill> selectByExample(BillExample example);

    @Select({
        "select",
        "id, buyer_id, seller_id, foods, total_price, create_time, last_update_time, ",
        "creater_id",
        "from tb_bill",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.sauzny.springbootweb.dao.BillMapper.BaseResultMap")
    Bill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bill record, @Param("example") BillExample example);

    int updateByExample(@Param("record") Bill record, @Param("example") BillExample example);

    int updateByPrimaryKeySelective(Bill record);

    @Update({
        "update tb_bill",
        "set buyer_id = #{buyerId,jdbcType=INTEGER},",
          "seller_id = #{sellerId,jdbcType=INTEGER},",
          "foods = #{foods,jdbcType=OTHER},",
          "total_price = #{totalPrice,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "creater_id = #{createrId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Bill record);
}