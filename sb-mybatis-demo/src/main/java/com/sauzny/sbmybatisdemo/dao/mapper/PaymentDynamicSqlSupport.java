package com.sauzny.sbmybatisdemo.dao.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PaymentDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Payment payment = new Payment();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> paymentId = payment.paymentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> paymentName = payment.paymentName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Double> paymentAmount = payment.paymentAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = payment.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> modifyTime = payment.modifyTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> userId = payment.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Payment extends SqlTable {
        public final SqlColumn<Integer> paymentId = column("PAYMENT_ID", JDBCType.INTEGER);

        public final SqlColumn<String> paymentName = column("PAYMENT_NAME", JDBCType.VARCHAR);

        public final SqlColumn<Double> paymentAmount = column("PAYMENT_AMOUNT", JDBCType.DOUBLE);

        public final SqlColumn<Date> createTime = column("CREATE_TIME", JDBCType.DATE);

        public final SqlColumn<Date> modifyTime = column("MODIFY_TIME", JDBCType.DATE);

        public final SqlColumn<Integer> userId = column("USER_ID", JDBCType.INTEGER);

        public Payment() {
            super("PAYMENT");
        }
    }
}