package com.sauzny.sb_mybatis_mds.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.util.StopWatch;

public final class DynamicDataSourceGen {

    private DynamicDataSourceGen(){}
    
    public static void gen(String packageName, String[] mdsNames){
        String[] prefixs = new String[mdsNames.length];
        for(int i=0;i<mdsNames.length;i++){
            prefixs[i] = mdsNames[i]+".datasource";
        }
        gen(packageName, mdsNames, prefixs);
    }
    
    public static void gen(String packageName, String[] mdsNames, String[] prefixs){

        
        StopWatch clock = new StopWatch("DynamicDataSourceGen 动态数据源代码生成器");

        clock.start("确认代码生成目录");
        
        String userDir = System.getProperty("user.dir");
        String fullPath = userDir + "/src/main/java/"+ packageName.replaceAll("\\.", "\\/");
        
        File dir = new File(fullPath);
        if(!dir.exists()) dir.mkdir();
        
        clock.stop();
        clock.start("生成文件：" + dir+"/TargetDataSource.java");
        
        write(dir+"/TargetDataSource.java", c_TargetDataSource(packageName, mdsNames));
        
        clock.stop();
        clock.start("生成文件：" + dir+"/DataSourceConfig.java");
        
        write(dir+"/DataSourceConfig.java", c_DataSourceConfig(packageName, mdsNames, prefixs));
        
        clock.stop();
        clock.start("生成文件：" + dir+"/DynamicDataSourceHolder.java");
        
        write(dir+"/DynamicDataSourceHolder.java", c_DynamicDataSourceHolder(packageName));
        
        clock.stop();
        clock.start("生成文件：" + dir+"/DDS.java");
        
        write(dir+"/DDS.java", c_DDS(packageName, mdsNames));
        
        clock.stop();
        clock.start("生成文件：" + dir+"/DynamicDataSource.java");
        
        write(dir+"/DynamicDataSource.java", c_DynamicDataSource(packageName));
        
        clock.stop();
        clock.start("生成文件：" + dir+"/DynamicDataSourceAspect.java");
        
        write(dir+"/DynamicDataSourceAspect.java", c_DynamicDataSourceAspect(packageName));
        
        clock.stop();
        System.out.println(clock.prettyPrint());
        
        double seconds = clock.getTotalTimeSeconds();
        long millis = clock.getTotalTimeMillis();
        System.out.println("共耗费秒数=" + seconds);
        System.out.println("共耗费毫秒数=" + millis);
    }
    
    public static List<String> c_TargetDataSource(String packageName, String[] mdsNames){
        
        List<String> lines = Lists.newArrayList();

        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import java.lang.annotation.Documented;");
        lines.add("import java.lang.annotation.ElementType;");
        lines.add("import java.lang.annotation.Retention;");
        lines.add("import java.lang.annotation.RetentionPolicy;");
        lines.add("import java.lang.annotation.Target;");
        lines.add("");
        lines.add("@Target({ElementType.METHOD, ElementType.TYPE})");
        lines.add("@Retention(RetentionPolicy.RUNTIME)");
        lines.add("@Documented");
        lines.add("public @interface TargetDataSource {");
        lines.add("    String value() default DDS.DEFAULT_DS;//默认数据源");
        lines.add("}");
        
        return lines;
    }

    public static List<String> c_DataSourceConfig(String packageName, String[] mdsNames, String[] prefixs){
        
        List<String> lines = Lists.newArrayList();
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import java.util.Map;");
        lines.add("import java.util.Properties;");
        lines.add("");
        lines.add("import javax.sql.DataSource;");
        lines.add("");
        lines.add("import org.apache.ibatis.plugin.Interceptor;");
        lines.add("import org.apache.ibatis.session.SqlSessionFactory;");
        lines.add("import org.mybatis.spring.SqlSessionFactoryBean;");
        lines.add("import org.mybatis.spring.SqlSessionTemplate;");
        lines.add("import org.springframework.beans.factory.annotation.Value;");
        lines.add("import org.springframework.boot.context.properties.ConfigurationProperties;");
        lines.add("import org.springframework.boot.jdbc.DataSourceBuilder;");
        lines.add("import org.springframework.context.annotation.Bean;");
        lines.add("import org.springframework.context.annotation.Configuration;");
        lines.add("import org.springframework.context.annotation.Primary;");
        lines.add("import org.springframework.core.io.support.PathMatchingResourcePatternResolver;");
        lines.add("import org.springframework.core.io.support.ResourcePatternResolver;");
        lines.add("");
        lines.add("import com.github.pagehelper.PageInterceptor;");
        lines.add("import com.google.common.collect.Maps;");
        lines.add("import com.zaxxer.hikari.HikariDataSource;");
        lines.add("");
        lines.add("import lombok.extern.slf4j.Slf4j;");
        lines.add("");
        lines.add("@Configuration");
        lines.add("@Slf4j");
        lines.add("public class DataSourceConfig {");
        lines.add("");
        lines.add("    //指定mapper xml目录  ");
        lines.add("    @Value(\"${dds.mapper-locations}\")");
        lines.add("    private String mapperLocations;");
        lines.add("    ");
        
        for(int i=0;i<mdsNames.length;i++){
            lines.add("    @Bean(name = DDS."+mdsNames[i]+")");
            lines.add("    @ConfigurationProperties(prefix = \""+mdsNames[i]+".datasource\") // application.properteis中对应属性的前缀");
            lines.add("    public DataSource ds_"+mdsNames[i]+"() {");
            lines.add("        return DataSourceBuilder.create().type(HikariDataSource.class).build();");
            lines.add("    }");
            lines.add("");
        }
        
        lines.add("    ");
        lines.add("    @Bean");
        lines.add("    @Primary");
        lines.add("    public DynamicDataSource dataSource() {");
        lines.add("        DynamicDataSource dataSource = new DynamicDataSource();");
        lines.add("        Map<Object, Object> targetDataSources = Maps.newHashMap();");
        
        for(int i=0;i<mdsNames.length;i++){
            lines.add("        targetDataSources.put(DDS."+mdsNames[i]+", ds_"+mdsNames[i]+"());");
        }
        
        lines.add("        dataSource.setTargetDataSources(targetDataSources);");
        lines.add("        dataSource.setDefaultTargetDataSource(ds_"+mdsNames[0]+"());");
        lines.add("        return dataSource;");
        lines.add("    }");
        lines.add("    ");
        lines.add("    @Bean");
        lines.add("    public SqlSessionFactory sqlSessionFactory() {  ");
        lines.add("          ");
        lines.add("        SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();  ");
        lines.add("        ssf.setDataSource(dataSource());  ");
        lines.add("          ");
        lines.add("        //分页插件  ");
        lines.add("        Properties properties = new Properties();  ");
        lines.add("        properties.setProperty(\"reasonable\", \"true\");  ");
        lines.add("        ");
        lines.add("        PageInterceptor interceptor = new PageInterceptor();  ");
        lines.add("        interceptor.setProperties(properties); ");
        lines.add("        ");
        lines.add("        ssf.setPlugins(new Interceptor[]{interceptor});  ");
        lines.add("          ");
        lines.add("        try {  ");
        lines.add("            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  ");
        lines.add("            ssf.setMapperLocations(resolver.getResources(this.mapperLocations));  ");
        lines.add("            return ssf.getObject();  ");
        lines.add("        } catch (Exception e) {  ");
        lines.add("            log.error(e.getMessage(), e);  ");
        lines.add("            throw new RuntimeException(e);  ");
        lines.add("        }  ");
        lines.add("    }");
        lines.add("    ");
        lines.add("    @Bean");
        lines.add("    public SqlSessionTemplate sqlSessionTemplate() {");
        lines.add("      return new SqlSessionTemplate(sqlSessionFactory());");
        lines.add("    }");
        lines.add("    ");
        lines.add("}");
        
        return lines;
    }
    
    public static List<String> c_DynamicDataSourceHolder(String packageName){
        List<String> lines = Lists.newArrayList();
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import lombok.extern.slf4j.Slf4j;");
        lines.add("");
        lines.add("@Slf4j");
        lines.add("public class DynamicDataSourceHolder {");
        lines.add("    ");
        lines.add("    //使用ThreadLocal把数据源与当前线程绑定");
        lines.add("    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();");
        lines.add("");
        lines.add("    public static void setDataSource(String dataSourceName) {");
        lines.add("        log.debug(\"----------DynamicDataSourceHolder 修改数据源为: {} ------\", dataSourceName);");
        lines.add("        dataSources.set(dataSourceName);");
        lines.add("    }");
        lines.add("");
        lines.add("    public static String getDataSource() {");
        lines.add("        return (String) dataSources.get();");
        lines.add("    }");
        lines.add("");
        lines.add("    public static void clearDataSource() {");
        lines.add("        dataSources.remove();");
        lines.add("    }");
        lines.add("}");
        return lines;
    }
    
    public static List<String> c_DDS(String packageName, String[] mdsNames){
        List<String> lines = Lists.newArrayList();
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("public interface DDS {");
        lines.add("");
        lines.add("    String DEFAULT_DS = \"dynamic_dataSource_"+mdsNames[0]+"\";");
        lines.add("    ");
        
        for(int i=0;i<mdsNames.length;i++){
            lines.add("    String "+mdsNames[i]+" = \"dynamic_dataSource_"+mdsNames[i]+"\";");
            lines.add("    ");
        }
        
        lines.add("}");
        return lines;
    }
    
    public static List<String> c_DynamicDataSource(String packageName){
        List<String> lines = Lists.newArrayList();
        
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;");
        lines.add("");
        lines.add("public class DynamicDataSource extends AbstractRoutingDataSource {");
        lines.add("    ");
        lines.add("    @Override");
        lines.add("    protected Object determineCurrentLookupKey() {");
        lines.add("");
        lines.add("        //可以做一个简单的负载均衡策略");
        lines.add("        String lookupKey = DynamicDataSourceHolder.getDataSource();");
        lines.add("");
        lines.add("        return lookupKey;");
        lines.add("    }");
        lines.add("}");

        return lines;
    }
    
    public static List<String> c_DynamicDataSourceAspect(String packageName){
        List<String> lines = Lists.newArrayList();
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import java.lang.reflect.Method;");
        lines.add("");
        lines.add("import org.aspectj.lang.ProceedingJoinPoint;");
        lines.add("import org.aspectj.lang.annotation.Around;");
        lines.add("import org.aspectj.lang.annotation.Aspect;");
        lines.add("import org.aspectj.lang.reflect.MethodSignature;");
        lines.add("import org.springframework.core.annotation.Order;");
        lines.add("import org.springframework.stereotype.Component;");
        lines.add("");
        lines.add("@Aspect");
        lines.add("@Order(1)");
        lines.add("@Component");
        lines.add("public class DynamicDataSourceAspect {");
        lines.add("    ");
        lines.add("    @Around(\"@annotation(TargetDataSource)\")");
        lines.add("    public Object around(ProceedingJoinPoint pjp) throws Throwable {");
        lines.add("        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();");
        lines.add("        Method targetMethod = methodSignature.getMethod();");
        lines.add("        if (targetMethod.isAnnotationPresent(TargetDataSource.class)) {");
        lines.add("            String targetDataSource = targetMethod.getAnnotation(TargetDataSource.class).value();");
        lines.add("            DynamicDataSourceHolder.setDataSource(targetDataSource);");
        lines.add("        }");
        lines.add("        Object result = pjp.proceed();//执行方法");
        lines.add("        DynamicDataSourceHolder.clearDataSource();");
        lines.add("        return result;");
        lines.add("    }");
        lines.add("}");
        return lines;
    }
    
    public static void write(String path, List<String> lines) {
        try {
            Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String packageName = "com.sauzny.sb_mybatis_mds.config.dds";
        String[] mdsNames = {"sbw", "mds"};
        DynamicDataSourceGen.gen(packageName, mdsNames);
    }
}
