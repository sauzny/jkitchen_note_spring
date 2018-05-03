package com.sauzny.springbootweb.utils.vo;

import com.sauzny.springbootweb.controller.vo.BjuiPageContent;
import com.sauzny.springbootweb.controller.vo.PageContent;

public final class BjuiPageContentUtils {

    private BjuiPageContentUtils(){}
    
    public static BjuiPageContent user4ManagerPageContent(PageContent<?> pageContent){
        BjuiPageContent bjuiPageContent = new BjuiPageContent();
        bjuiPageContent.setTotalRow(new Long(pageContent.getTotal()).intValue());
        bjuiPageContent.setPageCurrent(pageContent.getPageNum());
        bjuiPageContent.setList(pageContent.getContent());
        return bjuiPageContent;
    }
}
