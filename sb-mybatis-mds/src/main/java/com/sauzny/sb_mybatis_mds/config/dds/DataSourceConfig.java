package com.sauzny.sb_mybatis_mds.config.dds;

import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.pagehelper.PageInterceptor;
import com.google.common.collect.Maps;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DataSourceConfig {

    //指定mapper xml目录  
    @Value("${dds.mapper-locations}")
    private String mapperLocations;
    
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

    
    @Bean
    @Primary
    public DynamicDataSource dataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = Maps.newHashMap();
        targetDataSources.put(DDS.sbw, ds_sbw());
        targetDataSources.put(DDS.mds, ds_mds());
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(ds_sbw());
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() {  
          
        SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();  
        ssf.setDataSource(dataSource());  
          
        //分页插件  
        Properties properties = new Properties();  
        properties.setProperty("reasonable", "true");  
        
        PageInterceptor interceptor = new PageInterceptor();  
        interceptor.setProperties(properties); 
        
        ssf.setPlugins(new Interceptor[]{interceptor});  
          
        try {  
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
            ssf.setMapperLocations(resolver.getResources(this.mapperLocations));  
            return ssf.getObject();  
        } catch (Exception e) {  
            log.error(e.getMessage(), e);  
            throw new RuntimeException(e);  
        }  
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() {
      return new SqlSessionTemplate(sqlSessionFactory());
    }
    
}
