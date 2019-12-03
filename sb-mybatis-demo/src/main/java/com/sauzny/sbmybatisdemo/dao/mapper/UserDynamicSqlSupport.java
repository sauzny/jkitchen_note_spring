package com.sauzny.sbmybatisdemo.dao.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final User user = new User();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> userId = user.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userName = user.userName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userSex = user.userSex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> userAge = user.userAge;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userIdNo = user.userIdNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userPhoneNum = user.userPhoneNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userEmail = user.userEmail;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = user.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> modifyTime = user.modifyTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userState = user.userState;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> companyId = user.companyId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class User extends SqlTable {
        public final SqlColumn<Integer> userId = column("USER_ID", JDBCType.INTEGER);

        public final SqlColumn<String> userName = column("USER_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> userSex = column("USER_SEX", JDBCType.VARCHAR);

        public final SqlColumn<Integer> userAge = column("USER_AGE", JDBCType.INTEGER);

        public final SqlColumn<String> userIdNo = column("USER_ID_NO", JDBCType.VARCHAR);

        public final SqlColumn<String> userPhoneNum = column("USER_PHONE_NUM", JDBCType.VARCHAR);

        public final SqlColumn<String> userEmail = column("USER_EMAIL", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("CREATE_TIME", JDBCType.DATE);

        public final SqlColumn<Date> modifyTime = column("MODIFY_TIME", JDBCType.DATE);

        public final SqlColumn<String> userState = column("USER_STATE", JDBCType.VARCHAR);

        public final SqlColumn<Integer> companyId = column("COMPANY_ID", JDBCType.INTEGER);

        public User() {
            super("USER");
        }
    }
}