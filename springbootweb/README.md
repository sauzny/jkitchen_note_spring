# spring boot web

## 一、Filter + JWT
`com.sauzny.springbootweb.config.JwtFilter`

`com.sauzny.springbootweb.config.Audience`

`com.sauzny.springbootweb.config.WebConfig`

`pom.xml` 中增加 `java-jwt`

`application.properties` 中增加

```
audience.base64Secret=srC2KC4M
audience.expiresSecond=864000
```

## 二、日志AOP

在 `controller` 整增加统一日志，`com.sauzny.springbootweb.config.LogAspect` `com.sauzny.springbootweb.config.LogAspect`

`pom.xml` 中增加 `spring-boot-starter-aop` `cglib`

## 三、数据库操作

`pom.xml` 中增加 `mybatis-spring-boot-starter` `mybatis-generator-maven-plugin` `pagehelper-spring-boot-starter`

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

