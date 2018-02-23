package com.sauzny.springboot01.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryUtils {

    
    private static final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    
    public static String memory(){
        
        return memoryMXBean.getHeapMemoryUsage().getUsed()/1024/1024 + "MB";
    }
}
