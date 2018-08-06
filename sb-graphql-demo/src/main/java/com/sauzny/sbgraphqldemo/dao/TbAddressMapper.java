package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbAddress;
import com.sauzny.sbgraphqldemo.entity.pojo.TbAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbAddressMapper {
    long countByExample(TbAddressExample example);

    int deleteByExample(TbAddressExample example);

    @Delete({
        "delete from address",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short addressId);

    @Insert({
        "insert into address (address_id, address, ",
        "address2, district, ",
        "city_id, postal_code, ",
        "phone, last_update, ",
        "location)",
        "values (#{addressId,jdbcType=SMALLINT}, #{address,jdbcType=VARCHAR}, ",
        "#{address2,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{cityId,jdbcType=SMALLINT}, #{postalCode,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{location,jdbcType=BINARY})"
    })
    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    List<TbAddress> selectByExampleWithBLOBs(TbAddressExample example);

    List<TbAddress> selectByExample(TbAddressExample example);

    @Select({
        "select",
        "address_id, address, address2, district, city_id, postal_code, phone, last_update, ",
        "location",
        "from address",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbAddressMapper.ResultMapWithBLOBs")
    TbAddress selectByPrimaryKey(Short addressId);

    int updateByExampleSelective(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    int updateByExampleWithBLOBs(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    int updateByExample(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    int updateByPrimaryKeySelective(TbAddress record);

    @Update({
        "update address",
        "set address = #{address,jdbcType=VARCHAR},",
          "address2 = #{address2,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "city_id = #{cityId,jdbcType=SMALLINT},",
          "postal_code = #{postalCode,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "location = #{location,jdbcType=BINARY}",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TbAddress record);

    @Update({
        "update address",
        "set address = #{address,jdbcType=VARCHAR},",
          "address2 = #{address2,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "city_id = #{cityId,jdbcType=SMALLINT},",
          "postal_code = #{postalCode,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(TbAddress record);
}