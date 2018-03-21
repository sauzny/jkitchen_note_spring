package com.sauzny.springbootweb.utils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sauzny.springbootweb.SbwConstant;

public final class ControllerUtils {

    private ControllerUtils(){}
    
    public static String getJti(HttpServletRequest request){
        return String.valueOf(request.getAttribute(SbwConstant.Jwt.JTI));
    }
    
    public static long getLoginUserId(HttpServletRequest request){
        
        if(request.getAttribute(SbwConstant.Jwt.USER_ID) != null){
            return Long.parseLong(String.valueOf(request.getAttribute(SbwConstant.Jwt.USER_ID)));
        }
        
        return 0L;
    }
    
    public static int getLoginRoleId(HttpServletRequest request){
        
        if(request.getAttribute(SbwConstant.Jwt.ROLE_ID) != null){
            return Integer.parseInt(String.valueOf(request.getAttribute(SbwConstant.Jwt.ROLE_ID)));
        }
        
        return 0;
    }
    
    
    public static void exportExcel(HttpServletResponse response, String fileName, List<List<String>> excelData) throws IOException {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName+".xls", "utf-8"));
        XlsUtils.buildExcel(excelData, response.getOutputStream());
    }

}
