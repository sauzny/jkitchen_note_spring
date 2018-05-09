package com.sauzny.sb_mybatis_mds.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.util.StopWatch;

import com.google.common.collect.Lists;

public class PageHelpGen {

    public static void gen(List<String> list, int flag) throws IOException {
        
        StopWatch clock = new StopWatch("PageHelpGen 分页插件代码生成器");
        
        clock.start("读取代码自动生成配置文件：mybatis/generatorConfig.xml");
        
        String userDir = System.getProperty("user.dir");

        String daoBasePath = "/src/main/java/";
        String xmlBasePath = "/src/main/resources/";
        
        List<String> lines = Files.readAllLines(Paths.get(userDir + xmlBasePath + "mybatis/generatorConfig.xml"));
        
        clock.stop();
        clock.start("解析配置文件，获取必要的信息");

        StringBuilder daoPathSb = new StringBuilder();
        StringBuilder xmlPathSb = new StringBuilder();

        List<String> tableNames = Lists.newArrayList();
        List<String> objectNames = Lists.newArrayList();

        StringBuilder javaDaoPackageSb = new StringBuilder();
        StringBuilder javaModelPackageSb = new StringBuilder();
        
        lines.forEach(line -> {
            
            String temp = line.replace("<", "").replace(">", "").replace("        ", "");
            
            if(temp.startsWith("javaModelGenerator")){
                String daoPath = temp.split(" ")[1].split("=")[1].replaceAll("\"", "");
                javaModelPackageSb.append(daoPath);
            }
            
            if(temp.startsWith("javaClientGenerator")){
                String daoPath = temp.split(" ")[2].split("=")[1].replaceAll("\"", "");
                javaDaoPackageSb.append(daoPath);
                daoPath = userDir + daoBasePath + daoPath.replaceAll("\\.", "\\/");
                daoPathSb.append(daoPath);
            }
            
            if(temp.startsWith("sqlMapGenerator")){
                String xmlPath = temp.split(" ")[1].split("=")[1].replaceAll("\"", "");
                xmlPath = userDir + xmlBasePath + xmlPath.replaceAll("\\.", "\\/");
                xmlPathSb.append(xmlPath);
            }
            
            if(temp.startsWith("table")){
                tableNames.add(temp.split(" ")[1].split("=")[1].replaceAll("\"", ""));
                objectNames.add(temp.split(" ")[2].split("=")[1].replaceAll("\"", ""));
            }
            
        });
        
        for(int i=0; i<objectNames.size(); i++){
            String objectName = objectNames.get(i);
            if(list.contains(objectName)){
                String tableName = tableNames.get(i);
                if(flag == 1){

                    clock.stop();
                    clock.start("生成文件：" + daoPathSb.toString()+"/"+objectName+"Dao.java");
                    
                    PageHelpGen.daoWrite(daoPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName);
                }else if(flag == 2){

                    clock.stop();
                    clock.start("生成文件：" + xmlPathSb.toString()+"/"+objectName+"Dao.xml");
                    
                    PageHelpGen.xmlWrite(xmlPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName, tableName);
                }else if(flag == 3){

                    clock.stop();
                    clock.start("生成文件：" + daoPathSb.toString()+"/"+objectName+"Dao.java");
                    
                    PageHelpGen.daoWrite(daoPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName);

                    clock.stop();
                    clock.start("生成文件：" + xmlPathSb.toString()+"/"+objectName+"Dao.xml");
                    
                    PageHelpGen.xmlWrite(xmlPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName, tableName);
                }
            }
        }

        clock.stop();
        System.out.println(clock.prettyPrint());
        
        double seconds = clock.getTotalTimeSeconds();
        long millis = clock.getTotalTimeMillis();
        System.out.println("共耗费秒数=" + seconds);
        System.out.println("共耗费毫秒数=" + millis);
    }
    
    public static void daoWrite(String path, String javaDaoPackage, String javaModelPackage, String objectName){
        List<String> lines = Lists.newArrayList();
        lines.add("package "+javaDaoPackage+";");
        lines.add("");
        lines.add("import java.util.List;");
        lines.add("");
        lines.add("import com.github.pagehelper.Page;");
        lines.add("import "+javaModelPackage+"."+objectName+";");
        lines.add("import "+javaModelPackage+"."+objectName+"Example;");
        //lines.add("import org.springframework.stereotype.Repository;");
        lines.add("");
        //lines.add("@Repository");
        lines.add("public interface "+objectName+"Dao extends "+objectName+"Mapper{");
        lines.add("");
        lines.add("    // 获取所有数据");
        lines.add("    List<"+objectName+"> findAll();");
        lines.add("");
        lines.add("    // 分页查询");
        lines.add("    Page<"+objectName+"> findByPage();");
        lines.add("");
        lines.add("    // 分页查询带参数");
        lines.add("    Page<"+objectName+"> findByExamplePage("+objectName+"Example example);");
        
        lines.add("}");
        PageHelpGen.write(path+"/"+objectName+"Dao.java", lines);
    }
    
    public static void xmlWrite(String path, String javaDaoPackage, String javaModelPackage, String objectName, String tableName){
        List<String> lines = Lists.newArrayList();
        lines.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        lines.add("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        lines.add("<mapper namespace=\""+javaDaoPackage+"."+objectName+"Dao\">");
        lines.add("");
        lines.add(" <select id=\"findAll\" resultMap=\""+javaDaoPackage+"."+objectName+"Mapper.BaseResultMap\">");
        lines.add("     select");
        lines.add("     <include refid=\""+javaDaoPackage+"."+objectName+"Mapper.Base_Column_List\" />");
        lines.add("     from "+tableName);
        lines.add(" </select>");
        lines.add("");
        lines.add(" <select id=\"findByPage\" resultMap=\""+javaDaoPackage+"."+objectName+"Mapper.BaseResultMap\">");
        lines.add("     select");
        lines.add("     <include refid=\""+javaDaoPackage+"."+objectName+"Mapper.Base_Column_List\" />");
        lines.add("     from "+tableName);
        lines.add(" </select>");
        lines.add("");
        lines.add(" <select id=\"findByExamplePage\" parameterType=\""+javaModelPackage+"."+objectName+"Example\"");
        lines.add("     resultMap=\""+javaDaoPackage+"."+objectName+"Mapper.BaseResultMap\">");
        lines.add("     select");
        lines.add("     <if test=\"distinct\">");
        lines.add("         distinct");
        lines.add("     </if>");
        lines.add("     <include refid=\""+javaDaoPackage+"."+objectName+"Mapper.Base_Column_List\" />");
        lines.add("     from "+tableName);
        lines.add("     <if test=\"_parameter != null\">");
        lines.add("         <include refid=\""+javaDaoPackage+"."+objectName+"Mapper.Example_Where_Clause\" />");
        lines.add("     </if>");
        lines.add("     <if test=\"orderByClause != null\">");
        lines.add("         order by ${orderByClause}");
        lines.add("     </if>");
        lines.add(" </select>");
        lines.add("");
        lines.add("</mapper>");
        PageHelpGen.write(path+"/"+objectName+"Dao.xml", lines);
    }
    
    public static void write(String path, List<String> lines) {
        try {
            Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 需要更新的 objectName
        List<String> list = Lists.newArrayList("User","Classes","Income");
        // 自动补全分页相关的代码
        /*
         * dao重写 1
         * xml重写 2
         * dao和xml都重新 3 
         */
        PageHelpGen.gen(list, 3);
    }

}
