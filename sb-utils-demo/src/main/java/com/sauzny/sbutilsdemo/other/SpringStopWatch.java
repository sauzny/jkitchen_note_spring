package com.sauzny.sbutilsdemo.other;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import com.sauzny.sbutilsdemo.utils.MyUtils;

@Component
public class SpringStopWatch {

	public void demo() {

        System.out.println("SpringStopWatch任务");
        StopWatch clock = new StopWatch("业务1");
        clock.start("任务1");
        MyUtils.sleep(100L);
        clock.stop();
        clock.start("任务2");
        MyUtils.sleep(200L);
        clock.stop();
        clock.start("任务3");
        MyUtils.sleep(300L);
        clock.stop();
        clock.start("任务4");
        MyUtils.sleep(400L);
        clock.stop();
        System.out.println("数据抓取任务全部执行结束");
        System.out.println(clock.prettyPrint());
        double seconds = clock.getTotalTimeSeconds();
        long millis = clock.getTotalTimeMillis();
        System.out.println("共耗费秒数=" + seconds);
        System.out.println("共耗费毫秒数=" + millis);
        
        TaskInfo[] taskInfos = clock.getTaskInfo();
        List<TaskInfo> list = Arrays.asList(taskInfos);
        list.forEach(System.out::println);
	}
}
