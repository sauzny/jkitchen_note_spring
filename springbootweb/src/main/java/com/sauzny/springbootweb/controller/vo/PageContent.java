package com.sauzny.springbootweb.controller.vo;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

@Data
public class PageContent {
    
    private int totalPages;
    private long totalElements;
    private int number;
    private int size;
    private boolean last;
    private boolean first;
    private List<?> content = Lists.newArrayList();
    
}
