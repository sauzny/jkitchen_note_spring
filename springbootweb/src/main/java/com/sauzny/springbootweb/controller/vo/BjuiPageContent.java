package com.sauzny.springbootweb.controller.vo;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class BjuiPageContent {
    
    // 总数
    private int totalRow;
    
    // 页码，从1开始
    private int pageCurrent;
    
    // 数据内容
    private List<?> list = Lists.newArrayList();

}
