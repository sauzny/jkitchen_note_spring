package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByStore;
import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbSalesByStoreMapper {
    long countByExample(TbSalesByStoreExample example);

    int deleteByExample(TbSalesByStoreExample example);

    @Insert({
        "insert into sales_by_store (store, manager, ",
        "total_sales)",
        "values (#{store,jdbcType=VARCHAR}, #{manager,jdbcType=VARCHAR}, ",
        "#{totalSales,jdbcType=DECIMAL})"
    })
    int insert(TbSalesByStore record);

    int insertSelective(TbSalesByStore record);

    List<TbSalesByStore> selectByExample(TbSalesByStoreExample example);

    int updateByExampleSelective(@Param("record") TbSalesByStore record, @Param("example") TbSalesByStoreExample example);

    int updateByExample(@Param("record") TbSalesByStore record, @Param("example") TbSalesByStoreExample example);
}