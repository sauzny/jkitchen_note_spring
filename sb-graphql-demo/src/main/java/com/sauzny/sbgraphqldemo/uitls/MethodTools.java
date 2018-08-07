package com.sauzny.sbgraphqldemo.uitls;

import java.lang.reflect.Method;

import com.sauzny.sbgraphqldemo.controller.vo.*;
import com.sauzny.sbgraphqldemo.entity.pojo.*;

public class MethodTools {

    public static void setget(Class<?> targetClazz, String fromName){
        String simpleName = targetClazz.getSimpleName();
        String className = simpleName.substring(0, 1).toLowerCase() + targetClazz.getSimpleName().substring(1);
        Method[] methods = targetClazz.getMethods();
        for(Method method : methods){
            if(method.getName().startsWith("set")){
                System.out.println(className+"."+method.getName()+"("+fromName+".g"+method.getName().substring(1)+"());");
            }
        }
    }
    
    public static void main(String[] args) {
        MethodTools.setget(TbCity.class, "input");
    }
}
