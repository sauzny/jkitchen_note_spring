package com.sauzny.sbmybatisdemo.dao.mapper;

import static com.sauzny.sbmybatisdemo.dao.mapper.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sauzny.sbmybatisdemo.entity.po.User;
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
public interface UserMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(userId, userName, userSex, userAge, userIdNo, userPhoneNum, userEmail, createTime, modifyTime, userState, companyId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_SEX", property="userSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_AGE", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="USER_ID_NO", property="userIdNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_PHONE_NUM", property="userPhoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_EMAIL", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="MODIFY_TIME", property="modifyTime", jdbcType=JdbcType.DATE),
        @Result(column="USER_STATE", property="userState", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMPANY_ID", property="companyId", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(userSex).toProperty("userSex")
            .map(userAge).toProperty("userAge")
            .map(userIdNo).toProperty("userIdNo")
            .map(userPhoneNum).toProperty("userPhoneNum")
            .map(userEmail).toProperty("userEmail")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
            .map(userState).toProperty("userState")
            .map(companyId).toProperty("companyId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(userSex).toProperty("userSex")
            .map(userAge).toProperty("userAge")
            .map(userIdNo).toProperty("userIdNo")
            .map(userPhoneNum).toProperty("userPhoneNum")
            .map(userEmail).toProperty("userEmail")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
            .map(userState).toProperty("userState")
            .map(companyId).toProperty("companyId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(userSex).toPropertyWhenPresent("userSex", record::getUserSex)
            .map(userAge).toPropertyWhenPresent("userAge", record::getUserAge)
            .map(userIdNo).toPropertyWhenPresent("userIdNo", record::getUserIdNo)
            .map(userPhoneNum).toPropertyWhenPresent("userPhoneNum", record::getUserPhoneNum)
            .map(userEmail).toPropertyWhenPresent("userEmail", record::getUserEmail)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(modifyTime).toPropertyWhenPresent("modifyTime", record::getModifyTime)
            .map(userState).toPropertyWhenPresent("userState", record::getUserState)
            .map(companyId).toPropertyWhenPresent("companyId", record::getCompanyId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectByPrimaryKey(Integer userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(userName).equalTo(record::getUserName)
                .set(userSex).equalTo(record::getUserSex)
                .set(userAge).equalTo(record::getUserAge)
                .set(userIdNo).equalTo(record::getUserIdNo)
                .set(userPhoneNum).equalTo(record::getUserPhoneNum)
                .set(userEmail).equalTo(record::getUserEmail)
                .set(createTime).equalTo(record::getCreateTime)
                .set(modifyTime).equalTo(record::getModifyTime)
                .set(userState).equalTo(record::getUserState)
                .set(companyId).equalTo(record::getCompanyId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(userSex).equalToWhenPresent(record::getUserSex)
                .set(userAge).equalToWhenPresent(record::getUserAge)
                .set(userIdNo).equalToWhenPresent(record::getUserIdNo)
                .set(userPhoneNum).equalToWhenPresent(record::getUserPhoneNum)
                .set(userEmail).equalToWhenPresent(record::getUserEmail)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(modifyTime).equalToWhenPresent(record::getModifyTime)
                .set(userState).equalToWhenPresent(record::getUserState)
                .set(companyId).equalToWhenPresent(record::getCompanyId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(userSex).equalTo(record::getUserSex)
            .set(userAge).equalTo(record::getUserAge)
            .set(userIdNo).equalTo(record::getUserIdNo)
            .set(userPhoneNum).equalTo(record::getUserPhoneNum)
            .set(userEmail).equalTo(record::getUserEmail)
            .set(createTime).equalTo(record::getCreateTime)
            .set(modifyTime).equalTo(record::getModifyTime)
            .set(userState).equalTo(record::getUserState)
            .set(companyId).equalTo(record::getCompanyId)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(userSex).equalToWhenPresent(record::getUserSex)
            .set(userAge).equalToWhenPresent(record::getUserAge)
            .set(userIdNo).equalToWhenPresent(record::getUserIdNo)
            .set(userPhoneNum).equalToWhenPresent(record::getUserPhoneNum)
            .set(userEmail).equalToWhenPresent(record::getUserEmail)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(modifyTime).equalToWhenPresent(record::getModifyTime)
            .set(userState).equalToWhenPresent(record::getUserState)
            .set(companyId).equalToWhenPresent(record::getCompanyId)
            .where(userId, isEqualTo(record::getUserId))
        );
    }
}