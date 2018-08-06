# spring boot graphql

## 一、 graphql

以 `github api v4` 为例子，理解 `graphql`

文字文档 ： https://developer.github.com/v4/

graphql web工具 ： https://developer.github.com/v4/explorer/

### 1.1 核心思想：

只有一个http接口：https://api.github.com/graphql 使用get或post方式访问，参数分为两类
- query，查询，可以get或者post，考虑到缓存问题，应该使用get方式吧
- mutation，更新，post

还有一种是websocket接口，如：ws://localhost:9090/subscriptions
- subscription， websocket使用

### 1.2 常用语法

- fragments，片段。将多次用到的字段，组织为片段（可复用单元）。在需要的地方引入即可。
- variables，自定义变量。
- directives，指令
	- @include(if: Boolean) 仅在参数为 true 时，包含此字段。
	- @skip(if: Boolean) 如果参数为 true，跳过此字段。
- inline Fragments，内联片段


## 二、 spring boot 实际编码

### 2.1 graphqls文件编写

在 `src/main/resources/graphql` 下编写

- root.graphqls，编写Query和Mutation接口
- scheme.graphqls，编写struct结构体

https://github.com/jerry-jx/incubator-skywalking/blob/master/apm-protocol/apm-ui-protocol/src/main/resources/ui-graphql/trace.graphqls

### 2.2 代码编写

源码地址： https://github.com/graphql-java/graphql-java-servlet

HTTP接口类：
- `com.oembedler.moon.graphql.boot.GraphQLWebAutoConfiguration`
- `graphql.servlet.AbstractGraphQLHttpServlet`

代码实现接口