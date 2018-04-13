package com.sauzny.springbootweb.controller.vo;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class PageContent<T> {
    
    // 总页数
    private int pages;
    // 总数
    private long total;
    // 页码，从1开始
    private int pageNum;
    // 页面大小
    private int pageSize;
    
    // 是否最后一页
    private boolean last;
    
    // 是否第一页
    private boolean first;
    
    // 数据内容
    private List<T> content = Lists.newArrayList();
    
}
