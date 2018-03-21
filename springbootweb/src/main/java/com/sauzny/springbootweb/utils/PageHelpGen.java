package com.sauzny.springbootweb.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.google.common.collect.Lists;

public class PageHelpGen {

    public static void main(String[] args) {
        
        String userDir = System.getProperty("user.dir");
        
        String daoBasePath = "/src/main/java/";
        String xmlBasePath = "/src/main/resources/";
        
        String daoPath = "com.sauzny.springbootweb.dao";
        String xmlPath = "mybatis.sqlmap";
        
        daoPath = userDir + daoBasePath + daoPath.replaceAll("\\.", "\\/");
        xmlPath = userDir + xmlBasePath + xmlPath.replaceAll("\\.", "\\/");
        
        System.out.println(daoPath);
        System.out.println(xmlPath);
        
        
        
        /*
        List<String> lines = Lists.newArrayList();
        String path = "E:/code/github/sauzny/jkitchen_note/consumers/thrift/"+thriftName+"_index/index.js";
        Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
        */
    }

}
