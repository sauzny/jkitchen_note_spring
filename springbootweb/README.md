# spring boot web

## 一、Filter + JWT


`pom.xml` 中增加 `java-jwt`

`application.properties` 中增加

```
audience.base64Secret=sbwjwtSecret
audience.expiresSecond=864000
```

相关java文件

```
com.sauzny.springbootweb.config.JwtFilter
com.sauzny.springbootweb.config.Audience
com.sauzny.springbootweb.config.WebConfig
```

## 二、日志AOP

在 `controller` 整增加统一日志

`pom.xml` 中增加 `spring-boot-starter-aop` `cglib`

相关java文件

```
com.sauzny.springbootweb.config.LogAspect
com.sauzny.springbootweb.config.LogAspect
```

## 三、数据库操作

`pom.xml` 中增加

```
mybatis-spring-boot-starter
mybatis-generator-maven-plugin
pagehelper-spring-boot-starter
```

`application.properties` 中增加

```
# mybatis
# mapper.xml所在的位置
mybatis.mapper-locations=classpath:mybatis/sqlmap/*.xml
# entity扫描的包名
mybatis.type-aliases-package=com.sauzny.springbootweb.entity.pojo

# pagehelper
pagehelper.helperDialect=mysql
pagehelper.reasonable=true
pagehelper.supportMethodsArguments=true
pagehelper.params=count=countSql
```

相关java文件目录 `com.sauzny.springbootweb.dao`

相关配置文件目录`src/main/resources/mybatis/sqlmap`

## 四、代码编写流程：

1. 使用`src/main/resources/mybatis/generatorConfig.xml`生成代码
2. 使用 `com.sauzny.springbootweb.utils.PageHelpGen`，增加分页相关 XxxxDAO.java XxxxDao.xml
3. 增加一些自定义SQL在 XxxxDAO.java XxxxDao.xml 中

## 五、其他工具代码

1. 下载excel
2. 生成加密zip
3. json工具类
4. jwt工具类
5. 生成盐值，sha512哈希
6. 生成setXxx(getXxx());代码
7. http接口返回json类型 `com.sauzny.springbootweb.controller.vo.`

## 六、实现功能说明

- 登录，验证码，jwt校验
- 查询表格，分页
- 表单提交
- 下载excel

## 七、打包和启动

mvn install (-Dmaven.test.skip=true)，pom文件里已经配置了跳过测试

打包生成

http://localhost:9090/sbw/login.html