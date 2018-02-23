# jsp的管理系统

![](https://img.shields.io/badge/jdk-1.8-blue.svg)
![](https://img.shields.io/badge/maven-3.5-green.svg)
![](https://img.shields.io/badge/jetty-9.4.6.v20170531-yellow.svg)

## 启动说明

```
mvn install

mvn jetty:run
```

浏览器访问 `http://localhost:8081/mvc`

## 使用技术

- spring
- spring mvc
- mybatis
- mybatis generator
- logback
- jackson
- lombok
- HikariCP

## 文档连接

[jetty插件](ext/md/jetty插件.md)

[logback](ext/md/logback.md)

[mybatis-generatorConfig](ext/md/mybatis-generatorConfig.md)

[springmvc+json](ext/md/springmvc+json.md)

## TODO

- [ ] MockMvc 各种方法（get post put delete）的测试
- [ ] pom文件检测，可以提示出需要更新的jar包
- [ ] 双色球预测，对比
- [ ] 最新电影获取，与Aria2结合使用
- [ ] 登录，菜单模块，ACL权限控制