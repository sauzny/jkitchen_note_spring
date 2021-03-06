package com.sauzny.springbootweb.utils.vo;

import com.github.pagehelper.Page;
import com.sauzny.springbootweb.controller.vo.PageContent;

public final class PageContentUtils {

    private PageContentUtils(){}
    
    public static <E, T> PageContent<T> pageContent(Page<E> page){
        
        PageContent<T> pageContent = new PageContent<T>();
        
        pageContent.setPageSize(page.getPageSize());
        pageContent.setPages(page.getPages());
        pageContent.setTotal(page.getTotal());
        pageContent.setPageNum(page.getPageNum());
        pageContent.setLast(page.getPageNum() == page.getPages());
        pageContent.setFirst(page.getPageNum() == 1);
        
        //需要类型转换，单独在voUtils中写代码
        //pageContent.setContent(page.getResult());
        
        return pageContent;
    }
}
