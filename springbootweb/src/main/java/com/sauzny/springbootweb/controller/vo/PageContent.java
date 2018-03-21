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
    private boolean last;
    private boolean first;
    private List<T> content = Lists.newArrayList();
    
}
