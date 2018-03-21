package com.sauzny.springbootweb.dao;

import com.sauzny.springbootweb.entity.pojo.Product;
import com.sauzny.springbootweb.entity.pojo.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    @Delete({
        "delete from tb_product",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tb_product (id, create_time, ",
        "last_update_time, name, ",
        "purchase_price, state, ",
        "supplier_id, supplier_name, ",
        "supplier_product_no, max_distribution, ",
        "min_distribution)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdateTime,jdbcType=TIMESTAMP}, #{name,jdbcType=VARCHAR}, ",
        "#{purchasePrice,jdbcType=INTEGER}, #{state,jdbcType=INTEGER}, ",
        "#{supplierId,jdbcType=INTEGER}, #{supplierName,jdbcType=VARCHAR}, ",
        "#{supplierProductNo,jdbcType=VARCHAR}, #{maxDistribution,jdbcType=INTEGER}, ",
        "#{minDistribution,jdbcType=INTEGER})"
    })
    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    @Select({
        "select",
        "id, create_time, last_update_time, name, purchase_price, state, supplier_id, ",
        "supplier_name, supplier_product_no, max_distribution, min_distribution",
        "from tb_product",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.sauzny.springbootweb.dao.mapper.ProductMapper.BaseResultMap")
    Product selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update tb_product",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP},",
          "name = #{name,jdbcType=VARCHAR},",
          "purchase_price = #{purchasePrice,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "supplier_id = #{supplierId,jdbcType=INTEGER},",
          "supplier_name = #{supplierName,jdbcType=VARCHAR},",
          "supplier_product_no = #{supplierProductNo,jdbcType=VARCHAR},",
          "max_distribution = #{maxDistribution,jdbcType=INTEGER},",
          "min_distribution = #{minDistribution,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Product record);
}