package com.sauzny.sblogbackdemo.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.filter.LevelFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogbackDemo {

    public LogbackDemo() {

        log.info("{} 开始", "LogbackDemo");

        this.allLevel();
        this.appender();
        this.exception();

        log.info("{} 结束", "LogbackDemo");
    }

    private void allLevel() {
        log.info("各级别的排序为：ALL < TRACE < DEBUG < INFO < WARN < ERROR < OFF");

        // 修改 级别
        log.info("当前日志级别：{}", ((ch.qos.logback.classic.Logger) log).getLevel());
        ((ch.qos.logback.classic.Logger) log).setLevel(Level.TRACE);
        log.info("修改后，当前日志级别：{}", ((ch.qos.logback.classic.Logger) log).getLevel());

        log.info("各级别输出");

        log.trace("细节信息");
        log.debug("调试信息");
        log.info("运行信息");
        log.warn("警告信息");
        log.error("错误信息");

        if (log.isDebugEnabled()) {
            log.debug("log.isDebugEnabled()");
            log.debug("如果 logger没有开启 debug 模式，不会有构建参数带来的性能损耗。");
            log.debug("如果 logger 在 debug 级别，将会有两次性能的损耗，一次是判断是否启用了 debug 模式，一次是打印 debug 日志。");
            log.debug("在实际应用当中，这种性能上的损耗是可以忽略不计的，因为它所花费的时间小于打印一条日志的时间的 1%");
        }

        log.info("在本地机器上，将日志输出到文件大概耗费 9-12 微秒的时间。");
    }

    private void appender() {
        log.info("appender 的叠加性规则如下：");
        log.info("logger L 的日志输出语句会遍历 L 和它的子级中所有的 appender。这就是所谓的 appender 叠加性（appender additivity）");
        log.info("如果 L 的子级 logger 为 P，且 P 设置了 additivity = false，那么 L 的日志会在 L 所有 的 appender 包括 P 本身的 appender 中输出，但是不会在 P 的子级 appender 中输出。");
        log.info("logger 默认设置 additivity = true。");
    }

    private void exception() {
        try {
            Integer.parseInt("abc");
        }catch (Exception e){
            log.error("",  e);
        }
    }

}
