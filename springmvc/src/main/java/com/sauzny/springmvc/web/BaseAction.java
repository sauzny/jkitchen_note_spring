package com.sauzny.springmvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * *************************************************************************
 * @文件名称: BaseAction.java
 *
 * @包路径  : com.sauzny.jmvc.controller 
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   TODO
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年9月1日 - 下午4:38:14 
 *	
 **************************************************************************
 */
public class BaseAction {

    //日志
    
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected final String STATUS_CODE_SUCCESS = "200";
	
	protected final String STATUS_CODE_FAIL = "300";
	
	protected final String STATUS_CODE_TIMEOUT = "301";
	
	protected final String MESSAGE_SAVE_SUCCESS = "信息添加成功！";
	
	protected final String MESSAGE_SAVE_FAIL = "信息添加失败！";
	
	protected final String MESSAGE_UPDATE_SUCCESS = "信息修改成功！";
	
	protected final String MESSAGE_UPDATE_FAIL = "信息修改失败！";
	
	protected final String MESSAGE_DELETE_SUCCESS = "信息删除成功！";
	
	protected final String MESSAGE_DELETE_FAIL = "信息删除失败";
	
	protected final String CALLBACK_TYPE_CLOSE = "closeCurrent";
	
	
}