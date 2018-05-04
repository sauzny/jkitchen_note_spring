package com.sauzny.sb_mybatis_mds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//spring boot自带的DataSourceAutoConfiguration禁掉，因为它会读取application.properties文件的spring.datasource.*属性并自动配置单数据源
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@SpringBootApplication
@EnableTransactionManagement(order = 2) //设置事务执行顺序(需要在切换数据源之后，否则只走默认库)  
@MapperScan(basePackages = "com.sauzny.sb_mybatis_mds.dao")
public class Sbmmds {
    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(Sbmmds.class);
        sa.run(args);
    }
}
