package com.sauzny.sb_mybatis_mds.config.dds;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.google.common.collect.Maps;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = DDS.sbw)
    @ConfigurationProperties(prefix = "sbw.datasource") // application.properteis中对应属性的前缀
    public DataSource ds_sbw() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = DDS.mds)
    @ConfigurationProperties(prefix = "mds.datasource") // application.properteis中对应属性的前缀
    public DataSource ds_mds() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    // 动态数据源: 通过AOP在不同数据源之间动态切换
    @Bean(name = "dynamicDataSource")
    @Primary 
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(ds_sbw());

        // 配置多数据源
        Map<Object, Object> dsMap = Maps.newHashMap();
        dsMap.put(DDS.sbw, ds_sbw());
        dsMap.put(DDS.mds, ds_mds());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }
}
