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
    
    public static Long getLoginUserId(HttpServletRequest request){

        Object object = request.getAttribute(SbwConstant.Jwt.USER_ID);

        if(object != null){
            return Long.parseLong(String.valueOf(object));
        }
        
        return 0L;
    }

    public static String getUserName(HttpServletRequest request){

        Object userName = request.getAttribute(SbwConstant.Jwt.USER_NAME);

        if(userName != null){
            return String.valueOf(userName);
        }

        return "";
    }

}
