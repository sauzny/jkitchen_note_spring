package com.sauzny.sbdatasourcedemo.statementcancel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StatementCancelTester {

	public static final String sqlKey = "abc";
	
	// 预计运行10秒+
	public static final String sql = "select YEAR(createTime),MONTH(createTime),sum(costPrice) from orders WHERE createTime < '2017-10' GROUP BY YEAR(createTime),MONTH(createTime), `status`, personId";

	@Autowired
	private DBTemplate dBTemplate;
	
	@Async("taskExecutor")
	public void executeQuery() {
		List<Integer> result = dBTemplate.executeQuery(sqlKey, sql);
		log.info("result = {}", result);
	}
	
	@Async("taskExecutor")
	public void cancelQuery() {
		String result = dBTemplate.cancelQuery(sqlKey);
		log.info("result = {}", result);
	}
}
