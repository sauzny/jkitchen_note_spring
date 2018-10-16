package com.sauzny.sbthreaddemo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TaskTester {

	@Autowired
	private TaskWorker taskWorker;

	// 获取线程池
	@Resource
	private ThreadPoolTaskExecutor taskExecutor;
	
	public String accept(String message) {
		
		log.info("TaskTester accept");
		
		log.info("taskExecutor.getActiveCount() = " + taskExecutor.getActiveCount());
		
		log.info("taskExecutor.getCorePoolSize() = " + taskExecutor.getCorePoolSize());
		log.info("taskExecutor.getPoolSize() = " + taskExecutor.getPoolSize());
		log.info("taskExecutor.getMaxPoolSize() = " + taskExecutor.getMaxPoolSize());
		
		try {
			taskWorker.doTask(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "接受任务成功";
	} 
}
