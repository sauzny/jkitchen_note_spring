package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.Distribution;
import com.sauzny.springbootweb.entity.pojo.DistributionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DistributionMapper {
    long countByExample(DistributionExample example);

    int deleteByExample(DistributionExample example);

    @Delete({
        "delete from tb_distribution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tb_distribution (id, create_time, ",
        "distribution_price, last_update_time, ",
        "merchant_id, product_id)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{distributionPrice,jdbcType=INTEGER}, #{lastUpdateTime,jdbcType=TIMESTAMP}, ",
        "#{merchantId,jdbcType=BIGINT}, #{productId,jdbcType=BIGINT})"
    })
    int insert(Distribution record);

    int insertSelective(Distribution record);

    List<Distribution> selectByExample(DistributionExample example);

    @Select({
        "select",
        "id, create_time, distribution_price, last_update_time, merchant_id, product_id",
        "from tb_distribution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.sauzny.springbootweb.dao.mapper.DistributionMapper.BaseResultMap")
    Distribution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Distribution record, @Param("example") DistributionExample example);

    int updateByExample(@Param("record") Distribution record, @Param("example") DistributionExample example);

    int updateByPrimaryKeySelective(Distribution record);

    @Update({
        "update tb_distribution",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "distribution_price = #{distributionPrice,jdbcType=INTEGER},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "product_id = #{productId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Distribution record);
}