# logback

## pom配置

使用最新版即可

``` xml
		<!-- Logging -->
		<dependency>
		    <groupId>org.slf4j</groupId>
		    <artifactId>slf4j-api</artifactId>
			<version>${slf4j}</version>
		</dependency>

		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>${logback}</version>
		</dependency>
```

## 配置文件

### Logback

Logback默认配置的步骤：

- (1). 尝试在 classpath下查找文件logback-test.xml；
- (2). 如果文件不存在，则查找文件logback.xml；
- (3). 如果两个文件都不存在，logback用BasicConfigurator自动对自己进行配置，这会导致记录输出到控制台。

如果配置文件 logback-test.xml 和 logback.xml 都不存在，那么 logback 默认地会调用BasicConfigurator ，创建一个最小化配置。最小化配置由一个关联到根 logger 的ConsoleAppender 组成。输出用模式为 `%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n` 的 PatternLayoutEncoder 进行格式化。root logger 默认级别是 DEBUG。

### Logback文件中节点

三类节点：

```
                    ┌───── appender
                    │
configuration ──────┼───── logger
                    │
                    └───── root
```

#### appender

主要用于指定日志输出的目的地，目的地可以是控制台、文件、远程套接字服务器、 MySQL、PostreSQL、 Oracle和其他数据库、 JMS和远程UNIX Syslog守护进程等。

#### logger

作为日志的记录器，把它关联到应用的对应的context上后，主要用于存放日志对象，也可以定义日志类型、级别。

#### root

也是loger元素，但是它是根loger,是所有loger的上级。只有一个level属性，因为name已经被命名为"root",且已经是最上级了。

#### 小结

`appender + logger` 或者 `appender + root` 即可实现日志打印输出

### logback.xml

查看项目中demo，文件logback.xml中含有很多注释

- 自定义拦截器 `com.sauzny.jmvc.utils.logback.MyLogbackFilter`
- 自定义转换符 `com.sauzny.jmvc.utils.logback.MyPatternLayout`
- 多JVM同时操作同一个日志文件
- 归档策略
- 异步输出
- 日志输出级别

## java demo 代码

``` java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.trace("======trace");
        logger.debug("======debug");
        logger.info("======info");
        logger.warn("======warn");
        logger.error("======error");
        logger.info("如果配置了拦截器，那么只有我能通过，因为我带有关键词：sample");  
    }
}
```

## 其他

在`logback.xml`置出现错误的时，会在`Console`中出现日志信息

`logback.xml`中的配置片段，如下：

此时`FileNamePattern`中少配置了一个`%i`

``` xml
		<rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
			<!--日志文件输出的文件名 每天一归档 -->
			<FileNamePattern>${LOG_HOME}/TestWeb.log.%d{yyyy-MM-dd}.log</FileNamePattern>
			<!-- 单个日志文件最多 100MB, 60天的日志周期，最大不能超过20GB -->
			<maxFileSize>100MB</maxFileSize>
			<maxHistory>60</maxHistory>
			<totalSizeCap>20GB</totalSizeCap>
		</rollingPolicy>
```

`Console`输出，注意`ERROR`，如下：

``` log
09:51:40,806 |-INFO in ch.qos.logback.classic.LoggerContext[jmvc] - Could NOT find resource [logback-test.xml]
09:51:40,806 |-INFO in ch.qos.logback.classic.LoggerContext[jmvc] - Could NOT find resource [logback.groovy]
09:51:40,806 |-INFO in ch.qos.logback.classic.LoggerContext[jmvc] - Found resource [logback.xml] at [file:/E:/code/github/sauzny/jkitchen_mvc/target/classes/logback.xml]
09:51:40,856 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - debug attribute not set
09:51:40,856 |-INFO in ch.qos.logback.classic.joran.action.ContextNameAction - Setting logger context name as [jmvc]
09:51:40,856 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.core.ConsoleAppender]
09:51:40,866 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [STDOUT]
09:51:40,896 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.core.rolling.RollingFileAppender]
09:51:40,906 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [FILE]
09:51:40,906 |-INFO in c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@1792393294 - setting totalSizeCap to 20 GB
09:51:40,906 |-INFO in c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@1792393294 - Archive files will be limited to [100 MB] each.
09:51:40,906 |-INFO in c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@1792393294 - No compression will be used
09:51:40,916 |-INFO in c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@1792393294 - Will use the pattern /data/log/TestWeb.log.%d{yyyy-MM-dd}.log for the active file
09:51:40,916 |-INFO in ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP@6833ce2c - The date pattern is 'yyyy-MM-dd' from file name pattern '/data/log/TestWeb.log.%d{yyyy-MM-dd}.log'.
09:51:40,916 |-INFO in ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP@6833ce2c - Roll-over at midnight.
09:51:40,916 |-INFO in ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP@6833ce2c - Setting initial period to Mon Sep 11 09:51:40 CST 2017
09:51:40,916 |-ERROR in ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP@6833ce2c - Missing integer token, that is %i, in FileNamePattern [/data/log/TestWeb.log.%d{yyyy-MM-dd}.log]
09:51:40,916 |-ERROR in ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP@6833ce2c - See also http://logback.qos.ch/codes.html#sat_missing_integer_token
09:51:40,916 |-WARN in c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@1792393294 - Subcomponent did not start. TimeBasedRollingPolicy will not start.
09:51:40,916 |-WARN in ch.qos.logback.core.rolling.RollingFileAppender[FILE] - TriggeringPolicy has not started. RollingFileAppender will not start
09:51:40,916 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [com.apache.ibatis] to TRACE
09:51:40,916 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [java.sql.Connection] to DEBUG
09:51:40,916 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [java.sql.Statement] to DEBUG
09:51:40,916 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [java.sql.PreparedStatement] to DEBUG
09:51:40,916 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to TRACE
09:51:40,916 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [STDOUT] to Logger[ROOT]
09:51:40,916 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
09:51:40,916 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@725bef66 - Registering current configuration as safe fallback point
```