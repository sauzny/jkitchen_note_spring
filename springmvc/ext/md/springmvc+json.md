# spring mvc 4 + json

效果为，在接口方法上配置 `@ResponseBody` 注解之后，返回json串到前端页面

## pom文件+java代码（+配置文件）

### 为解析json，增加依赖jar包

``` xml
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			<version>2.9.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-core</artifactId>
		    <version>2.9.0</version>
		</dependency>
```

### 方法一：

在代码中指定 `"application/json;charset=UTF-8"`

``` java
    @ResponseBody
    @RequestMapping(value = "/test01", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public TbUser test01(){
        TbUser tbUser = userService.selectOneById(1);
        return tbUser;
    }
```

### 方法二：

不在代码中指定 `"application/json;charset=UTF-8"`

``` java
    @ResponseBody
    @RequestMapping(value = "/test01", method = {RequestMethod.POST, RequestMethod.GET}
    public TbUser test01(){
        TbUser tbUser = userService.selectOneById(1);
        return tbUser;
    }
```

在`spring-mvc.xml`文件中增加

``` xml
	<mvc:annotation-driven />
	<bean
		class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"
		id="mappingJacksonHttpMessageConverter">
		<property name="supportedMediaTypes">
			<list>
				<value>text/html;charset=UTF-8</value>
				<value>application/json;charset=UTF-8</value>
				<value>text/json;charset=UTF-8</value>
			</list>
		</property>
	</bean>
	<bean id="annotationMethodHandlerAdapter"
		class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
		<property name="messageConverters">
			<list>
				<ref bean="mappingJacksonHttpMessageConverter" />
			</list>
		</property>
	</bean>
```

## json中关于时间类型

代码如下：
`@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")` 是spring中提供的注解，在页面数据传给服务端时起作用
`@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")` 是jackson中提供的注解，在服务端传给页面时起作用


``` java
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return this.createTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getBirthday() {
        return this.birthday;
    }
```