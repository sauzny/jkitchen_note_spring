package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByFilmCategory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbSalesByFilmCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TbSalesByFilmCategoryMapper {
    long countByExample(TbSalesByFilmCategoryExample example);

    int deleteByExample(TbSalesByFilmCategoryExample example);

    @Insert({
        "insert into sales_by_film_category (category, total_sales)",
        "values (#{category,jdbcType=VARCHAR}, #{totalSales,jdbcType=DECIMAL})"
    })
    int insert(TbSalesByFilmCategory record);

    int insertSelective(TbSalesByFilmCategory record);

    List<TbSalesByFilmCategory> selectByExample(TbSalesByFilmCategoryExample example);

    int updateByExampleSelective(@Param("record") TbSalesByFilmCategory record, @Param("example") TbSalesByFilmCategoryExample example);

    int updateByExample(@Param("record") TbSalesByFilmCategory record, @Param("example") TbSalesByFilmCategoryExample example);
}