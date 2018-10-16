package com.sauzny.sbthreaddemo;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TaskWorker {

    public static Random random = new Random();
    
	@Async("taskExecutor")
    public void doTask(String message) throws Exception {
		
		// 测试异常情况
		if("hello4".equals(message)) {
			Integer.parseInt("asdasdasd");
		}
		
        log.info("开始做任务" + message);
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务，耗时：" + (end - start) + "毫秒");
    }
}
