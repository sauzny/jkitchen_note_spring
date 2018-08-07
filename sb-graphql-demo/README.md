# spring boot graphql

## 一、 graphql

以 `github api v4` 为例子，理解 `graphql`

文字文档 ： https://developer.github.com/v4/

graphql web工具 ： https://developer.github.com/v4/explorer/

### 1.1 核心思想：

解决restful的问题：某个前端展现，实际需要调用多个独立的RESTful API才能获取到足够的数据

GraphQL的一些优点:

- 所见即所得
- 减少网络请求次数
- 代码即文档
- 参数类型强校验

只有一个http接口：https://api.github.com/graphql （github的此接口直接访问会报错） 使用get或post方式访问，参数分为两类
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

推荐文章：

https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot

https://blog.csdn.net/kikajack/article/category/7404296

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

```
GraphQL Java Tools works with four types of Resolver classes:

GraphQLResolver<T> to resolve complex types.
GraphQLQueryResolver to define the operations of the root Query type.
GraphQLMutationResolver to define the operations of the root Mutation type.
GraphQLSubscriptionResolver to define the operations of the root Subscription type.

Subscriptions allows you to subscribe to a reactive source. They won't be reviewed in this tutorial, but the repositories for the Author and Book entities, and the GraphQLQueryResolver and GraphQLMutationResolver classes will be in the next section.
```

代码实现主要

- `com.sauzny.sbgraphqldemo.controller.CountryController`
- `com.sauzny.sbgraphqldemo.controller.connections.CountryConnections`

### 2.3 graphiql，测试

pom中引入`graphiql-spring-boot-starter`

启动程序，可访问 http://localhost:9090/sbg/graphiql 使用此工具可以进行web测试，测试脚本记录在`src\test\java\test.graphql`

也可以使用postman进行测试，get或者post方式，

get：
```
http://localhost:9090/sbg/graphql?query=%7bcity(paging%3a%7bpageNum%3a1%2cpageSize%3a10%7d)%7bcityId+city%7d%7d
```

post:
```
http://localhost:9090/sbg/graphql

header 设置
Content-Type ： application/json

body
{"query":"{city(paging:{pageNum:1,pageSize:10}){cityId city}}","variables":null}

```

## 三、分页实现遗留问题

graphql的分页与现有的分页想法不同，需要再考虑怎么实现。
