package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbPayment;
import com.sauzny.sbgraphqldemo.entity.pojo.TbPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbPaymentMapper {
    long countByExample(TbPaymentExample example);

    int deleteByExample(TbPaymentExample example);

    @Delete({
        "delete from payment",
        "where payment_id = #{paymentId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short paymentId);

    @Insert({
        "insert into payment (payment_id, customer_id, ",
        "staff_id, rental_id, ",
        "amount, payment_date, ",
        "last_update)",
        "values (#{paymentId,jdbcType=SMALLINT}, #{customerId,jdbcType=SMALLINT}, ",
        "#{staffId,jdbcType=TINYINT}, #{rentalId,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=DECIMAL}, #{paymentDate,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbPayment record);

    int insertSelective(TbPayment record);

    List<TbPayment> selectByExample(TbPaymentExample example);

    @Select({
        "select",
        "payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update",
        "from payment",
        "where payment_id = #{paymentId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbPaymentMapper.BaseResultMap")
    TbPayment selectByPrimaryKey(Short paymentId);

    int updateByExampleSelective(@Param("record") TbPayment record, @Param("example") TbPaymentExample example);

    int updateByExample(@Param("record") TbPayment record, @Param("example") TbPaymentExample example);

    int updateByPrimaryKeySelective(TbPayment record);

    @Update({
        "update payment",
        "set customer_id = #{customerId,jdbcType=SMALLINT},",
          "staff_id = #{staffId,jdbcType=TINYINT},",
          "rental_id = #{rentalId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "payment_date = #{paymentDate,jdbcType=TIMESTAMP},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where payment_id = #{paymentId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbPayment record);
}