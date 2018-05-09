package com.sauzny.sb_mybatis_mds.config.dds;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicDataSourceHolder {
    
    //使用ThreadLocal把数据源与当前线程绑定
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    public static void setDataSource(String dataSourceName) {
        log.debug("----------DynamicDataSourceHolder 修改数据源为: {} ------", dataSourceName);
        dataSources.set(dataSourceName);
    }

    public static String getDataSource() {
        return (String) dataSources.get();
    }

    public static void clearDataSource() {
        dataSources.remove();
    }
}
