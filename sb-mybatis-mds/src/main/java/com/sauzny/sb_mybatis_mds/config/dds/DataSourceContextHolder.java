package com.sauzny.sb_mybatis_mds.config.dds;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceContextHolder {
    
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDB(String dbType) {
        log.debug("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    
    public static void clearDB() {
        log.debug("移除{}数据源", getDB());
        contextHolder.remove();
    }
    
}
