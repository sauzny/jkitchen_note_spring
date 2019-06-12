package com.sauzny.springbootweb.controller.vo;

import java.util.List;

import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "分页列表")
public class PageContent<T> {
    
    // 总页数
    @ApiModelProperty(value = "总页数")
    private int pages;
    // 总数
    @ApiModelProperty(value = "总数")
    private long total;
    // 页码，从1开始
    @ApiModelProperty(value = "页码，从1开始")
    private int pageNum;
    // 页面大小
    @ApiModelProperty(value = "页面大小")
    private int pageSize;
    
    // 是否最后一页
    @ApiModelProperty(value = "是否最后一页")
    private boolean last;
    
    // 是否第一页
    @ApiModelProperty(value = "是否第一页")
    private boolean first;
    
    // 数据内容
    @ApiModelProperty(value = "数据内容")
    private List<T> content = Lists.newArrayList();
    
}
