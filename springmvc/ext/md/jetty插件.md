# jetty插件

使用版本 ``

更多有关 jetty 的配置信息可参考 http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html

## 启动和停止

```
mvn jetty:run

mvn -Djetty.port=8081 jetty:run 此命令中的端口指定优先级低于配置文件中的配置

mvn jetty:stop

```

## pom文件配置

``` xml
			<!-- servlet 容器 -->
			<plugin>
				<groupId>org.eclipse.jetty</groupId>
				<artifactId>jetty-maven-plugin</artifactId>
				<version>${jetty}</version>
				<configuration>
					<httpConnector>
						<!-- 访问端口,默认8080 -->
						<port>8081</port>
					</httpConnector>
					<stopKey>shutdown</stopKey>
					<stopPort>9966</stopPort>
					<!-- 自动热部署 -->
					<!-- <scanIntervalSeconds>2</scanIntervalSeconds> -->
					<!-- 手动重加载  可选值 ：[automatic|manual] -->
					<reload>manual</reload>
					<!-- dumpOnStart 默认值为 false，如果设为 true，jetty 在启动时会把当前服务进程的内存信息输出到控制台中，但这并不会保存到文件中。 -->
					<dumpOnStart>false</dumpOnStart>
					<webApp>
						<!--  -->
						<contextPath>/mvc</contextPath>
						<!-- 项目的静态资源文件目录默认是 src/main/webapp，如果静态资源目录有多个，或者不在默认的 src/main/webapp 目录下，可做如下配置： -->
						<!-- <resourceBases> <resourceBase>${project.basedir}/src/main/webapp</resourceBase> 
							<resourceBase>${project.basedir}/commons</resourceBase> </resourceBases> -->
					</webApp>
					<!-- 访问日志 -->
					<!-- 
					<requestLog implementation="org.eclipse.jetty.server.NCSARequestLog">
						<filename>target/access-yyyy_mm_dd.log</filename>
						<filenameDateFormat>yyyy_MM_dd</filenameDateFormat>
						<logDateFormat>yyyy-MM-dd HH:mm:ss</logDateFormat>
						<logTimeZone>GMT+8:00</logTimeZone>
						<append>true</append>
						<logServer>true</logServer>
						<retainDays>120</retainDays>
						<logCookies>true</logCookies>
					</requestLog>
					 -->
				</configuration>
			</plugin>

```

## 日志说明

org.eclipse.jetty.server.NCSARequestLog 是 org.eclipse.jetty.server.RequestLog 的一个实现类。

- org.eclipse.jetty.server.NCSARequestLog 是一种伪标准的 NCSA 日志格式。下面是一些节点参数的解释：
- filename：日志文件的名称
- filenameDateFormat：日志文件的名称的日期格式，它要求日志文件名必须含有 yyyy_mm_dd 串
- logDateFormat：日志内容的时间格式
- logTimeZone：时区
- append：追加到日志
- logServer：记录访问的主机名
- retainDays：日志文件保存的天数, 超过删除
- logCookies：记录 cookies

启动 jetty 服务，在项目的 target 目录下会生成一个 access-2015_06_23.log 文件，该文件中的其中一条记录如下：

```
localhost 0:0:0:0:0:0:0:1 - - [2015-06-23 01:17:05] "GET /css/main.css HTTP/1.1" 304 -
"http://localhost:8081/"  "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)
Chrome/35.0.1916.153 Safari/537.36 SE 2.X MetaSr 1.0" "JSESSIONID=2gyikovul2iz168116l2afo4f"
```