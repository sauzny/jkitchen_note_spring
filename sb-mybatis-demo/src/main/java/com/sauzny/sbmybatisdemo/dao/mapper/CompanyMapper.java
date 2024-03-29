package com.sauzny.sbmybatisdemo.dao.mapper;

import static com.sauzny.sbmybatisdemo.dao.mapper.CompanyDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sauzny.sbmybatisdemo.entity.po.Company;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface CompanyMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(companyId, companyName, companyEmail, createTime, modifyTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Company> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Company> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CompanyResult")
    Optional<Company> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CompanyResult", value = {
        @Result(column="COMPANY_ID", property="companyId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="COMPANY_NAME", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMPANY_EMAIL", property="companyEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="MODIFY_TIME", property="modifyTime", jdbcType=JdbcType.DATE)
    })
    List<Company> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, company, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, company, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer companyId_) {
        return delete(c -> 
            c.where(companyId, isEqualTo(companyId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Company record) {
        return MyBatis3Utils.insert(this::insert, record, company, c ->
            c.map(companyId).toProperty("companyId")
            .map(companyName).toProperty("companyName")
            .map(companyEmail).toProperty("companyEmail")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Company> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, company, c ->
            c.map(companyId).toProperty("companyId")
            .map(companyName).toProperty("companyName")
            .map(companyEmail).toProperty("companyEmail")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Company record) {
        return MyBatis3Utils.insert(this::insert, record, company, c ->
            c.map(companyId).toPropertyWhenPresent("companyId", record::getCompanyId)
            .map(companyName).toPropertyWhenPresent("companyName", record::getCompanyName)
            .map(companyEmail).toPropertyWhenPresent("companyEmail", record::getCompanyEmail)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(modifyTime).toPropertyWhenPresent("modifyTime", record::getModifyTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Company> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, company, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Company> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, company, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Company> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, company, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Company> selectByPrimaryKey(Integer companyId_) {
        return selectOne(c ->
            c.where(companyId, isEqualTo(companyId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, company, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Company record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(companyId).equalTo(record::getCompanyId)
                .set(companyName).equalTo(record::getCompanyName)
                .set(companyEmail).equalTo(record::getCompanyEmail)
                .set(createTime).equalTo(record::getCreateTime)
                .set(modifyTime).equalTo(record::getModifyTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Company record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(companyId).equalToWhenPresent(record::getCompanyId)
                .set(companyName).equalToWhenPresent(record::getCompanyName)
                .set(companyEmail).equalToWhenPresent(record::getCompanyEmail)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(modifyTime).equalToWhenPresent(record::getModifyTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Company record) {
        return update(c ->
            c.set(companyName).equalTo(record::getCompanyName)
            .set(companyEmail).equalTo(record::getCompanyEmail)
            .set(createTime).equalTo(record::getCreateTime)
            .set(modifyTime).equalTo(record::getModifyTime)
            .where(companyId, isEqualTo(record::getCompanyId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Company record) {
        return update(c ->
            c.set(companyName).equalToWhenPresent(record::getCompanyName)
            .set(companyEmail).equalToWhenPresent(record::getCompanyEmail)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(modifyTime).equalToWhenPresent(record::getModifyTime)
            .where(companyId, isEqualTo(record::getCompanyId))
        );
    }
}