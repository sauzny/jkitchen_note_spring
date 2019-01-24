package com.sauzny.sbshirodemo.utils;


import javax.servlet.http.HttpServletRequest;

import com.sauzny.sbshirodemo.SbwConstant;

public final class ControllerUtils {

    private ControllerUtils(){}

    public static String getToken(HttpServletRequest request){
        return request.getHeader(SbwConstant.Jwt.TOKEN);
    }

    public static String getJti(HttpServletRequest request){
        return String.valueOf(request.getAttribute(SbwConstant.Jwt.JTI));
    }
    
    public static int getLoginUserId(HttpServletRequest request){
        
        if(request.getAttribute(SbwConstant.Jwt.USER_ID) != null){
            return Integer.parseInt(String.valueOf(request.getAttribute(SbwConstant.Jwt.USER_ID)));
        }
        
        return 0;
    }

    public static String getUserName(HttpServletRequest request){

        Object userName = request.getAttribute(SbwConstant.Jwt.USER_NAME);

        if(userName != null){
            return String.valueOf(userName);
        }

        return "";
    }

}
