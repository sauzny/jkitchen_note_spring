package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbStore;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbStoreMapper {
    long countByExample(TbStoreExample example);

    int deleteByExample(TbStoreExample example);

    @Delete({
        "delete from store",
        "where store_id = #{storeId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte storeId);

    @Insert({
        "insert into store (store_id, manager_staff_id, ",
        "address_id, last_update)",
        "values (#{storeId,jdbcType=TINYINT}, #{managerStaffId,jdbcType=TINYINT}, ",
        "#{addressId,jdbcType=SMALLINT}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbStore record);

    int insertSelective(TbStore record);

    List<TbStore> selectByExample(TbStoreExample example);

    @Select({
        "select",
        "store_id, manager_staff_id, address_id, last_update",
        "from store",
        "where store_id = #{storeId,jdbcType=TINYINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbStoreMapper.BaseResultMap")
    TbStore selectByPrimaryKey(Byte storeId);

    int updateByExampleSelective(@Param("record") TbStore record, @Param("example") TbStoreExample example);

    int updateByExample(@Param("record") TbStore record, @Param("example") TbStoreExample example);

    int updateByPrimaryKeySelective(TbStore record);

    @Update({
        "update store",
        "set manager_staff_id = #{managerStaffId,jdbcType=TINYINT},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where store_id = #{storeId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(TbStore record);
}