package com.sauzny.sbmybatisdemo.dao.mapper;

import static com.sauzny.sbmybatisdemo.dao.mapper.PaymentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.sauzny.sbmybatisdemo.entity.po.Payment;
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
public interface PaymentMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(paymentId, paymentName, paymentAmount, createTime, modifyTime, userId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Payment> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Payment> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaymentResult")
    Optional<Payment> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaymentResult", value = {
        @Result(column="PAYMENT_ID", property="paymentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="PAYMENT_NAME", property="paymentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_AMOUNT", property="paymentAmount", jdbcType=JdbcType.DOUBLE),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="MODIFY_TIME", property="modifyTime", jdbcType=JdbcType.DATE),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<Payment> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer paymentId_) {
        return delete(c -> 
            c.where(paymentId, isEqualTo(paymentId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Payment record) {
        return MyBatis3Utils.insert(this::insert, record, payment, c ->
            c.map(paymentId).toProperty("paymentId")
            .map(paymentName).toProperty("paymentName")
            .map(paymentAmount).toProperty("paymentAmount")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
            .map(userId).toProperty("userId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Payment> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, payment, c ->
            c.map(paymentId).toProperty("paymentId")
            .map(paymentName).toProperty("paymentName")
            .map(paymentAmount).toProperty("paymentAmount")
            .map(createTime).toProperty("createTime")
            .map(modifyTime).toProperty("modifyTime")
            .map(userId).toProperty("userId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Payment record) {
        return MyBatis3Utils.insert(this::insert, record, payment, c ->
            c.map(paymentId).toPropertyWhenPresent("paymentId", record::getPaymentId)
            .map(paymentName).toPropertyWhenPresent("paymentName", record::getPaymentName)
            .map(paymentAmount).toPropertyWhenPresent("paymentAmount", record::getPaymentAmount)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(modifyTime).toPropertyWhenPresent("modifyTime", record::getModifyTime)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Payment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Payment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Payment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Payment> selectByPrimaryKey(Integer paymentId_) {
        return selectOne(c ->
            c.where(paymentId, isEqualTo(paymentId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, payment, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Payment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(paymentId).equalTo(record::getPaymentId)
                .set(paymentName).equalTo(record::getPaymentName)
                .set(paymentAmount).equalTo(record::getPaymentAmount)
                .set(createTime).equalTo(record::getCreateTime)
                .set(modifyTime).equalTo(record::getModifyTime)
                .set(userId).equalTo(record::getUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Payment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(paymentId).equalToWhenPresent(record::getPaymentId)
                .set(paymentName).equalToWhenPresent(record::getPaymentName)
                .set(paymentAmount).equalToWhenPresent(record::getPaymentAmount)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(modifyTime).equalToWhenPresent(record::getModifyTime)
                .set(userId).equalToWhenPresent(record::getUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Payment record) {
        return update(c ->
            c.set(paymentName).equalTo(record::getPaymentName)
            .set(paymentAmount).equalTo(record::getPaymentAmount)
            .set(createTime).equalTo(record::getCreateTime)
            .set(modifyTime).equalTo(record::getModifyTime)
            .set(userId).equalTo(record::getUserId)
            .where(paymentId, isEqualTo(record::getPaymentId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Payment record) {
        return update(c ->
            c.set(paymentName).equalToWhenPresent(record::getPaymentName)
            .set(paymentAmount).equalToWhenPresent(record::getPaymentAmount)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(modifyTime).equalToWhenPresent(record::getModifyTime)
            .set(userId).equalToWhenPresent(record::getUserId)
            .where(paymentId, isEqualTo(record::getPaymentId))
        );
    }
}