package com.sauzny.springbootweb.utils.vo;

import com.sauzny.springbootweb.controller.vo.PageContent;

import com.github.pagehelper.Page;

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
        
        //pageContent.setContent(page.getContent());
        
        return pageContent;
    }
}
