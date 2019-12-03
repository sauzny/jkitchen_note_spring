package com.sauzny.sbmybatisdemo.dao.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CompanyDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Company company = new Company();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> companyId = company.companyId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> companyName = company.companyName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> companyEmail = company.companyEmail;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = company.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> modifyTime = company.modifyTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Company extends SqlTable {
        public final SqlColumn<Integer> companyId = column("COMPANY_ID", JDBCType.INTEGER);

        public final SqlColumn<String> companyName = column("COMPANY_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> companyEmail = column("COMPANY_EMAIL", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("CREATE_TIME", JDBCType.DATE);

        public final SqlColumn<Date> modifyTime = column("MODIFY_TIME", JDBCType.DATE);

        public Company() {
            super("COMPANY");
        }
    }
}