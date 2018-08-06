package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbInventory;
import com.sauzny.sbgraphqldemo.entity.pojo.TbInventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbInventoryMapper {
    long countByExample(TbInventoryExample example);

    int deleteByExample(TbInventoryExample example);

    @Delete({
        "delete from inventory",
        "where inventory_id = #{inventoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer inventoryId);

    @Insert({
        "insert into inventory (inventory_id, film_id, ",
        "store_id, last_update)",
        "values (#{inventoryId,jdbcType=INTEGER}, #{filmId,jdbcType=SMALLINT}, ",
        "#{storeId,jdbcType=TINYINT}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbInventory record);

    int insertSelective(TbInventory record);

    List<TbInventory> selectByExample(TbInventoryExample example);

    @Select({
        "select",
        "inventory_id, film_id, store_id, last_update",
        "from inventory",
        "where inventory_id = #{inventoryId,jdbcType=INTEGER}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbInventoryMapper.BaseResultMap")
    TbInventory selectByPrimaryKey(Integer inventoryId);

    int updateByExampleSelective(@Param("record") TbInventory record, @Param("example") TbInventoryExample example);

    int updateByExample(@Param("record") TbInventory record, @Param("example") TbInventoryExample example);

    int updateByPrimaryKeySelective(TbInventory record);

    @Update({
        "update inventory",
        "set film_id = #{filmId,jdbcType=SMALLINT},",
          "store_id = #{storeId,jdbcType=TINYINT},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where inventory_id = #{inventoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbInventory record);
}