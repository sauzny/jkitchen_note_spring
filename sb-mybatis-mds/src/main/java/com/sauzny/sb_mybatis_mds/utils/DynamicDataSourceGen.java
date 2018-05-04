package com.sauzny.sb_mybatis_mds.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.assertj.core.util.Lists;

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

        String userDir = System.getProperty("user.dir");
        String fullPath = userDir + "/src/main/java/"+ packageName.replaceAll("\\.", "\\/");
        
        File dir = new File(fullPath);
        if(!dir.exists()) dir.mkdir();
        
        write(dir+"/ChooseDDS.java", c_ChooseDDS(packageName, mdsNames));
        write(dir+"/DataSourceConfig.java", c_DataSourceConfig(packageName, mdsNames, prefixs));
        write(dir+"/DataSourceContextHolder.java", c_DataSourceContextHolder(packageName));
        write(dir+"/DDS.java", c_DDS(packageName, mdsNames));
        write(dir+"/DynamicDataSource.java", c_DynamicDataSource(packageName));
        write(dir+"/DynamicDataSourceAspect.java", c_DynamicDataSourceAspect(packageName));
        
    }
    
    public static List<String> c_ChooseDDS(String packageName, String[] mdsNames){
        
        List<String> lines = Lists.newArrayList();

        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import java.lang.annotation.ElementType;");
        lines.add("import java.lang.annotation.Retention;");
        lines.add("import java.lang.annotation.RetentionPolicy;");
        lines.add("import java.lang.annotation.Target;");
        lines.add("");
        lines.add("@Retention(RetentionPolicy.RUNTIME)");
        lines.add("@Target({ ElementType.METHOD })");
        lines.add("");
        lines.add("public @interface ChooseDDS {");
        lines.add("    String value() default DDS."+mdsNames[0]+";");
        lines.add("}");
        
        return lines;
    }

    public static List<String> c_DataSourceConfig(String packageName, String[] mdsNames, String[] prefixs){
        
        List<String> lines = Lists.newArrayList();
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import java.util.Map;");
        lines.add("");
        lines.add("import javax.sql.DataSource;");
        lines.add("");
        lines.add("import org.springframework.boot.context.properties.ConfigurationProperties;");
        lines.add("import org.springframework.boot.jdbc.DataSourceBuilder;");
        lines.add("import org.springframework.context.annotation.Bean;");
        lines.add("import org.springframework.context.annotation.Configuration;");
        lines.add("import org.springframework.context.annotation.Primary;");
        lines.add("");
        lines.add("import com.google.common.collect.Maps;");
        lines.add("import com.zaxxer.hikari.HikariDataSource;");
        lines.add("");
        lines.add("@Configuration");
        lines.add("public class DataSourceConfig {");
        lines.add("");
        
        for(int i=0;i<mdsNames.length;i++){
            lines.add("    @Bean(name = DDS."+mdsNames[i]+")");
            lines.add("    @ConfigurationProperties(prefix = \""+prefixs[i]+"\") // application.properteis中对应属性的前缀");
            lines.add("    public DataSource ds_"+mdsNames[i]+"() {");
            lines.add("        return DataSourceBuilder.create().type(HikariDataSource.class).build();");
            lines.add("    }");
            lines.add("");
        }
        
        lines.add("    // 动态数据源: 通过AOP在不同数据源之间动态切换");
        lines.add("    @Bean(name = \"dynamicDataSource\")");
        lines.add("    @Primary ");
        lines.add("    public DataSource dataSource() {");
        lines.add("        DynamicDataSource dynamicDataSource = new DynamicDataSource();");
        lines.add("        // 默认数据源");
        lines.add("        dynamicDataSource.setDefaultTargetDataSource(ds_"+mdsNames[0]+"());");
        lines.add("");
        lines.add("        // 配置多数据源");
        lines.add("        Map<Object, Object> dsMap = Maps.newHashMap();");
        
        for(int i=0;i<mdsNames.length;i++){
            lines.add("        dsMap.put(DDS."+mdsNames[i]+", ds_"+mdsNames[i]+"());");
        }
        
        lines.add("");
        lines.add("        dynamicDataSource.setTargetDataSources(dsMap);");
        lines.add("");
        lines.add("        return dynamicDataSource;");
        lines.add("    }");
        lines.add("}");
        
        return lines;
    }
    
    public static List<String> c_DataSourceContextHolder(String packageName){
        List<String> lines = Lists.newArrayList();
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("import lombok.extern.slf4j.Slf4j;");
        lines.add("");
        lines.add("@Slf4j");
        lines.add("public class DataSourceContextHolder {");
        lines.add("    ");
        lines.add("    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();");
        lines.add("");
        lines.add("    // 设置数据源名");
        lines.add("    public static void setDB(String dbType) {");
        lines.add("        log.debug(\"切换到{}数据源\", dbType);");
        lines.add("        contextHolder.set(dbType);");
        lines.add("    }");
        lines.add("");
        lines.add("    // 获取数据源名");
        lines.add("    public static String getDB() {");
        lines.add("        return (contextHolder.get());");
        lines.add("    }");
        lines.add("");
        lines.add("    // 清除数据源名");
        lines.add("    ");
        lines.add("    public static void clearDB() {");
        lines.add("        log.debug(\"移除{}数据源\", getDB());");
        lines.add("        contextHolder.remove();");
        lines.add("    }");
        lines.add("    ");
        lines.add("}");
        return lines;
    }
    
    public static List<String> c_DDS(String packageName, String[] mdsNames){
        List<String> lines = Lists.newArrayList();
        lines.add("package "+packageName+";");
        lines.add("");
        lines.add("public interface DDS {");
        lines.add("");
        lines.add("    String first = \"dds_"+mdsNames[0]+"\";");
        for(int i=0;i<mdsNames.length;i++){
            lines.add("    String "+mdsNames[i]+" = \"dds_"+mdsNames[i]+"\";");
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
        lines.add("import lombok.extern.slf4j.Slf4j;");
        lines.add("");
        lines.add("@Slf4j");
        lines.add("public class DynamicDataSource extends AbstractRoutingDataSource{");
        lines.add("    ");
        lines.add("    @Override");
        lines.add("    protected Object determineCurrentLookupKey() {");
        lines.add("        ");
        lines.add("        log.debug(\"数据源为{}\", DataSourceContextHolder.getDB());");
        lines.add("");
        lines.add("        return DataSourceContextHolder.getDB();");
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
        lines.add("import org.aspectj.lang.JoinPoint;");
        lines.add("import org.aspectj.lang.annotation.After;");
        lines.add("import org.aspectj.lang.annotation.Aspect;");
        lines.add("import org.aspectj.lang.annotation.Before;");
        lines.add("import org.aspectj.lang.reflect.MethodSignature;");
        lines.add("import org.springframework.core.annotation.Order;");
        lines.add("import org.springframework.stereotype.Component;");
        lines.add("");
        lines.add("@Aspect");
        lines.add("@Order(1) //设置AOP执行顺序(需要在事务之前，否则事务只发生在默认库中)  ");
        lines.add("@Component");
        lines.add("public class DynamicDataSourceAspect {");
        lines.add("");
        lines.add("    @Before(\"@annotation(ChooseDDS)\")");
        lines.add("    public void beforeSwitchDS(JoinPoint point){");
        lines.add("");
        lines.add("        //获得当前访问的class");
        lines.add("        Class<?> className = point.getTarget().getClass();");
        lines.add("");
        lines.add("        //获得访问的方法名");
        lines.add("        String methodName = point.getSignature().getName();");
        lines.add("        //得到方法的参数的类型");
        lines.add("        Class<?>[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();");
        lines.add("        String dataSource = DDS.first;");
        lines.add("        try {");
        lines.add("            // 得到访问的方法对象");
        lines.add("            Method method = className.getMethod(methodName, argClass);");
        lines.add("");
        lines.add("            // 判断是否存在@ChooseDDS注解");
        lines.add("            if (method.isAnnotationPresent(ChooseDDS.class)) {");
        lines.add("                ChooseDDS annotation = method.getAnnotation(ChooseDDS.class);");
        lines.add("                // 取出注解中的数据源名");
        lines.add("                dataSource = annotation.value();");
        lines.add("            }");
        lines.add("        } catch (Exception e) {");
        lines.add("            e.printStackTrace();");
        lines.add("        }");
        lines.add("");
        lines.add("        // 切换数据源");
        lines.add("        DataSourceContextHolder.setDB(dataSource);");
        lines.add("    }");
        lines.add("");
        lines.add("    @After(\"@annotation(ChooseDDS)\")");
        lines.add("    public void afterSwitchDS(JoinPoint point){");
        lines.add("        DataSourceContextHolder.clearDB();");
        lines.add("    }");
        lines.add("    ");
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
