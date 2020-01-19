# spring data redis

官方文档 `https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis`

redis服务器版本 5.0.7

## 一、Lettuce的使用

主要说明一下连接池

- 正确使用连接池 `https://github.com/lettuce-io/lettuce-core/wiki/Connection-Pooling-5.1`
- 代码中开启连接池 `lettuceConnectionFactory.setShareNativeConnection(false);`

## 二、