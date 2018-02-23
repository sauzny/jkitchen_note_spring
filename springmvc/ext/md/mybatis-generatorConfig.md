
## pom配置

``` xml
			<!-- mybatis-generator -->
			<plugin>
				<groupId>org.mybatis.generator</groupId>
				<artifactId>mybatis-generator-maven-plugin</artifactId>
				<version>${mybatis.generator}</version>
				<configuration>
					<configurationFile>src/main/resources/mybatis/generatorConfig.xml</configurationFile>
					<overwrite>true</overwrite>
				</configuration>
			</plugin>
```

## 配置文件

generatorConfig.xml

## 问题记录

1.connectionURL中的写法，需要使用 `&amp`

2.使用  mysql-connector-java 的版本需要注意， 可能会因版本问题出现 生成的mapper 中缺少与主键相关的方法