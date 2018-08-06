package com.sauzny.sbgraphqldemo.dao;

import com.sauzny.sbgraphqldemo.entity.pojo.TbLanguage;
import com.sauzny.sbgraphqldemo.entity.pojo.TbLanguageExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbLanguageMapper {
    long countByExample(TbLanguageExample example);

    int deleteByExample(TbLanguageExample example);

    @Delete({
        "delete from language",
        "where language_id = #{languageId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte languageId);

    @Insert({
        "insert into language (language_id, name, ",
        "last_update)",
        "values (#{languageId,jdbcType=TINYINT}, #{name,jdbcType=CHAR}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TbLanguage record);

    int insertSelective(TbLanguage record);

    List<TbLanguage> selectByExample(TbLanguageExample example);

    @Select({
        "select",
        "language_id, name, last_update",
        "from language",
        "where language_id = #{languageId,jdbcType=TINYINT}"
    })
    @ResultMap("com.sauzny.sbgraphqldemo.dao.TbLanguageMapper.BaseResultMap")
    TbLanguage selectByPrimaryKey(Byte languageId);

    int updateByExampleSelective(@Param("record") TbLanguage record, @Param("example") TbLanguageExample example);

    int updateByExample(@Param("record") TbLanguage record, @Param("example") TbLanguageExample example);

    int updateByPrimaryKeySelective(TbLanguage record);

    @Update({
        "update language",
        "set name = #{name,jdbcType=CHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where language_id = #{languageId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(TbLanguage record);
}