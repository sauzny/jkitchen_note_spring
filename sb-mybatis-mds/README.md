# spring boot + mybatis

## 一、代码生成插件

`pom.xml`中位置插件`mybatis-generator-maven-plugin`

在`generatorConfig.xml`中设置代码、配置文件生成路径等

运行：右键点项目，`Run As`下边`Maven build...` 然后`goals`输入`mybatis-generator:generate -X`

## 二、分页工具类

`pom.xml`中引入`pagehelper-spring-boot-starter`

在使用代码生成插件之后，打开`com.sauzny.sb_mybatis_mds.utils.PageHelpGen`

在`main`函数中设置好需要继续生成分页代码的实体类，运行即可

生成 `XxxDao.java` 和 `XxxDao.xml`，包含三个方法

- 获取所有数据
- 分页查询
- 分页查询带参数

需要增加自定义函数时，在`XxxDao.java` 和 `XxxDao.xml`中增加代码即可

在`service`层使用时，使用 `XxxDao` 即可

## 三、多数据源情况

打开`com.sauzny.sb_mybatis_mds.utils.DynamicDataSourceGen`

在`main`函数中设置好代码生成的位置和多数据源的名字数组，运行生成代码

默认情况下使用多数据源中的第一个数据源

在`service`层调用`dao`的方法上增加注解可指定使用的数据源

使用方式，参考 `com.sauzny.sb_mybatis_mds.service.MdsService`

## 四、运行

在完成前三个步骤之后，测试运行

测试代码在`com.sauzny.sb_mybatis_mds.junit.JunitMds`中

运行`com.sauzny.sb_mybatis_mds.Sbmmds`，即可查看测试效果

注意：

- `com.sauzny.sb_mybatis_mds.Sbmmds`中的类注解
- `application.properties`配置文件