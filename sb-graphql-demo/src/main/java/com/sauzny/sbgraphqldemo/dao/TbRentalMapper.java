package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbRental;
import com.sauzny.sbgraphqldemo.entity.pojo.TbRentalExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbRentalMapper {
    long countByExample(TbRentalExample example);

    int deleteByExample(TbRentalExample example);

    @Delete({
        "delete from rental",
        "where rental_id = #{rentalId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rentalId);

    @Insert({
        "insert into rental (rental_id, rental_date, ",
        "inventory_id, customer_id, ",
        "return_date, staff_id, ",
        "last_update)",
        "values (#{rentalId,jdbcType=INTEGER}, #{rentalDate,jdbcType=TIMESTAMP}, ",
        "#{inventoryId,jdbcType=INTEGER}, #{customerId,jdbcType=SMALLINT}, ",
        "#{returnDate,jdbcType=TIMESTAMP}, #{staffId,jdbcType=TINYINT}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbRental record);

    int insertSelective(TbRental record);

    List<TbRental> selectByExample(TbRentalExample example);

    @Select({
        "select",
        "rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update",
        "from rental",
        "where rental_id = #{rentalId,jdbcType=INTEGER}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbRentalMapper.BaseResultMap")
    TbRental selectByPrimaryKey(Integer rentalId);

    int updateByExampleSelective(@Param("record") TbRental record, @Param("example") TbRentalExample example);

    int updateByExample(@Param("record") TbRental record, @Param("example") TbRentalExample example);

    int updateByPrimaryKeySelective(TbRental record);

    @Update({
        "update rental",
        "set rental_date = #{rentalDate,jdbcType=TIMESTAMP},",
          "inventory_id = #{inventoryId,jdbcType=INTEGER},",
          "customer_id = #{customerId,jdbcType=SMALLINT},",
          "return_date = #{returnDate,jdbcType=TIMESTAMP},",
          "staff_id = #{staffId,jdbcType=TINYINT},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where rental_id = #{rentalId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbRental record);
}