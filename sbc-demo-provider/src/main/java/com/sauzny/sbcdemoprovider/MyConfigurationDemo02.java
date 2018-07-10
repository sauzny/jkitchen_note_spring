package com.sauzny.sbcdemoprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@RefreshScope
//static这种方式，此注解不能刷新static属性
//原理set函数应该只是在初始化实例的时候执行了一次，之后不再执行
public class MyConfigurationDemo02 {
    
    public static int number;
    
    public static String address;

    @Value("${number}")
    public void setPhone(int number) {
        MyConfigurationDemo02.number = number;
    }
    
    @Value("${address}")
    public void setAddress(String address) {
        MyConfigurationDemo02.address = address;
    }
    
}
