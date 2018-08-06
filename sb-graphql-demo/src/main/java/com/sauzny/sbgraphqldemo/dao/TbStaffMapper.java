package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbStaff;
import com.sauzny.sbgraphqldemo.entity.pojo.TbStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbStaffMapper {
    long countByExample(TbStaffExample example);

    int deleteByExample(TbStaffExample example);

    @Delete({
        "delete from staff",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte staffId);

    @Insert({
        "insert into staff (staff_id, first_name, ",
        "last_name, address_id, ",
        "email, store_id, ",
        "active, username, password, ",
        "last_update, picture)",
        "values (#{staffId,jdbcType=TINYINT}, #{firstName,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{addressId,jdbcType=SMALLINT}, ",
        "#{email,jdbcType=VARCHAR}, #{storeId,jdbcType=TINYINT}, ",
        "#{active,jdbcType=BIT}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{picture,jdbcType=LONGVARBINARY})"
    })
    int insert(TbStaff record);

    int insertSelective(TbStaff record);

    List<TbStaff> selectByExampleWithBLOBs(TbStaffExample example);

    List<TbStaff> selectByExample(TbStaffExample example);

    @Select({
        "select",
        "staff_id, first_name, last_name, address_id, email, store_id, active, username, ",
        "password, last_update, picture",
        "from staff",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbStaffMapper.ResultMapWithBLOBs")
    TbStaff selectByPrimaryKey(Byte staffId);

    int updateByExampleSelective(@Param("record") TbStaff record, @Param("example") TbStaffExample example);

    int updateByExampleWithBLOBs(@Param("record") TbStaff record, @Param("example") TbStaffExample example);

    int updateByExample(@Param("record") TbStaff record, @Param("example") TbStaffExample example);

    int updateByPrimaryKeySelective(TbStaff record);

    @Update({
        "update staff",
        "set first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "email = #{email,jdbcType=VARCHAR},",
          "store_id = #{storeId,jdbcType=TINYINT},",
          "active = #{active,jdbcType=BIT},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "picture = #{picture,jdbcType=LONGVARBINARY}",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TbStaff record);

    @Update({
        "update staff",
        "set first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "email = #{email,jdbcType=VARCHAR},",
          "store_id = #{storeId,jdbcType=TINYINT},",
          "active = #{active,jdbcType=BIT},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(TbStaff record);
}