package com.sauzny.springbootweb.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    
    
    public static void exportExcel(HttpServletResponse response, String fileName, List<List<String>> excelData) throws IOException {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName+".xls", "utf-8"));
        XlsUtils.buildExcel(excelData, response.getOutputStream());
    }

    public static void exportCaptcha(HttpServletRequest request, HttpServletResponse response, Object[] imageAndCode) throws IOException{
        
        BufferedImage image = (BufferedImage) imageAndCode[0];
        String randomString = (String) imageAndCode[1];
        
        HttpSession session = request.getSession();
        // 将生成的随机字符串保存到session中
        session.removeAttribute(SbwConstant.Controller.CAPTCHA);
        session.setAttribute(SbwConstant.Controller.CAPTCHA, randomString);

        // 将内存中的图片通过流动形式输出到客户端
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }
    
    public static boolean checkCaptcha(String captcha, HttpSession session){
        
        boolean isRight = false;
        
        String random = (String) session.getAttribute(SbwConstant.Controller.CAPTCHA);
        
        isRight = captcha.equalsIgnoreCase(random);
        
        return isRight;
    }
}
