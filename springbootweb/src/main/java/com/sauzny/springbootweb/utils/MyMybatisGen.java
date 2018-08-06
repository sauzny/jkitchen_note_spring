package com.sauzny.springbootweb.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.google.common.collect.Lists;

// 废弃
// 分页不需要增加额外的xml

public class MyMybatisGen {

    public static void gen(List<String> list, int flag) throws IOException {

        String userDir = System.getProperty("user.dir");

        String daoBasePath = "/src/main/java/";
        String xmlBasePath = "/src/main/resources/";

        StringBuilder daoPathSb = new StringBuilder();
        StringBuilder xmlPathSb = new StringBuilder();

        List<String> tableNames = Lists.newArrayList();
        List<String> objectNames = Lists.newArrayList();

        StringBuilder javaDaoPackageSb = new StringBuilder();
        StringBuilder javaModelPackageSb = new StringBuilder();
        
        List<String> lines = Files.readAllLines(Paths.get(userDir + xmlBasePath + "mybatis/generatorConfig.xml"));
        
        lines.forEach(line -> {

            String temp = line.replace("<", "").replace(">", "").replace("        ", "").replace("\t\t", "");
            
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
                System.out.println("处理对象：" + objectName);
                String tableName = tableNames.get(i);
                if(flag == 1){
                    MyMybatisGen.daoWrite(daoPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName);
                }else if(flag == 2){
                    MyMybatisGen.xmlWrite(xmlPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName, tableName);
                }else if(flag == 3){
                    MyMybatisGen.daoWrite(daoPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName);
                    MyMybatisGen.xmlWrite(xmlPathSb.toString(), javaDaoPackageSb.toString(), javaModelPackageSb.toString(), objectName, tableName);
                }
                System.out.println("");
            }
        }
    }
    
    public static void daoWrite(String path, String javaDaoPackage, String javaModelPackage, String objectName){
        List<String> lines = Lists.newArrayList();
        lines.add("package "+javaDaoPackage+";");
        lines.add("");
        lines.add("public interface "+objectName+"Dao extends "+objectName+"Mapper{");
        lines.add("");
        lines.add("}");
        MyMybatisGen.write(path+"/"+objectName+"Dao.java", lines);
    }
    
    public static void xmlWrite(String path, String javaDaoPackage, String javaModelPackage, String objectName, String tableName){
        List<String> lines = Lists.newArrayList();
        lines.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        lines.add("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        lines.add("<mapper namespace=\""+javaDaoPackage+"."+objectName+"Dao\">");
        lines.add("");
        lines.add("</mapper>");
        MyMybatisGen.write(path+"/"+objectName+"Dao.xml", lines);
    }
    
    public static void write(String path, List<String> lines) {
        try {
            File file = new File(path);
            if(file.isFile()) file.delete();
            Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            System.out.println("生成文件：" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 需要更新的 objectName
        List<String> list = Lists.newArrayList("TbActor", "TbActorInfo", "TbAddress", "TbCategory", "TbCity", "TbCountry", "TbCustomer", "TbCustomerList", "TbFilm", "TbFilmActor", "TbFilmCategory", "TbFilmList", "TbFilmText", "TbInventory", "TbLanguage", "TbNicerButSlowerFilmList", "TbPayment", "TbRental", "TbSalesByFilmCategory", "TbSalesByStore", "TbStaff", "TbStaffList", "TbStore");
        // 自动补全分页相关的代码
        /*
         * dao重写 1
         * xml重写 2
         * dao和xml都重新 3 
         */
        MyMybatisGen.gen(list, 3);
    }

}
