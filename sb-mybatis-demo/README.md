# mybatis demo

自动生成代码又版本更新，主要是对动态sql记录一下demo

数据库使用 H2

## 一、引入jar包

```xml
<dependencys>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.1</version>
    </dependency>
    
    <dependency>
        <groupId>org.mybatis.dynamic-sql</groupId>
        <artifactId>mybatis-dynamic-sql</artifactId>
        <version>1.1.4</version>
    </dependency>
</dependencys>
```

```xml
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.4.0</version>
    <configuration>
        <configurationFile>${basedir}/src/main/resources/mybatis/generatorConfig.xml</configurationFile>
        <overwrite>true</overwrite>
        <verbose>true</verbose>
    </configuration>
    <!-- 引入数据库驱动依赖包 -->
    <dependencies>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>1.4.200</version>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
</plugin>
```

## 二、 自动生成代码

配置文件查看 `generatorConfig.xml`

## 三、生成代码说明

- 动态sql需要的类，`***DynamicSqlSupport`，记录表名、字段名。
- mapper，`***Mapper`，操作数据库的接口
  - 参数为 `***StatementProvider` 的接口，这类是动态sql提供的功能
  - 参数为 `***SelectDSLCompleter` 的接口，是自动生成代码对动态sql的封装
  - 参数为具体 `POJO` 类的接口，是自动生成代码对动态sql的封装
  
## 四、demo说明

自定义的sql写在 `UserDao` 中

主要代码在 `service` 中，测试了几种调用方法
