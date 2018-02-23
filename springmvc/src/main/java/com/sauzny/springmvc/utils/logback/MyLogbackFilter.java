package com.sauzny.springmvc.utils.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * *************************************************************************
 * @文件名称: MyLogbackFilter.java
 *
 * @包路径  : com.sauzny.jmvc.utils.logback
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   自定义Logback日志拦截器
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年9月8日 - 上午11:17:08 
 *	
 **************************************************************************
 */
public class MyLogbackFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        
        if (event.getMessage().contains("sample")) {
            //允许输入串
            return FilterReply.ACCEPT; 
        } else {
            //不允许输出
            return FilterReply.DENY; 
        }
    }

}
