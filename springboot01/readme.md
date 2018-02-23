# 一个demo

## 演示说明

启动 `com.sauzny.springboot01.App` 中的 `main` 函数，


浏览器访问地址 `https://localhost:8443/ws.html`

==注意：==

需要在联网的状态下访问页面`http://localhost:8000/ws.html`，因为页面引用了一些js

``` js
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
```

## 数据流程

- 1 页面
	- 1.1 确认用户
		- 1.1.1 wss发送确认用户信息，使服务器端将当前用户和ws的session互相绑定，放入池中
		- 1.1.2 https获取因上次session断开处理过但未被push的消息
	- 1.2 发送消息，wss发送消息，服务器端接收消息之后，放入队列中
	- 1.3 获取所有消息，https获取已经被处理过并且被push过的所有消息
	- 1.4 断开ws连接，关闭页面，wss发出断开请求，服务器端会对应删除其session

- 2 服务器中的 `Consumer` ，从队列中获取数据，并处理数据（使用sleep模拟处理时间），将处理之后的结果使用 `websocket` 推送到页面。
	- 2.1 推送时发现当前session已经断开，则将此消息保存到unpushed
	- 2.2 推送时发现当前session正常，成功push到html后，将此消息保存到pushed

```

     ┌─── 确认用户，https请求，获取因上次session断开而存在unpushed中的数据
     │
     │              ┌─── 确认用户，将此session放入池中
     │              │
     │              │                               ┌─── redis 队列
html───MyWebSocket─── send message MessageService───│
     │                                              └─── rabbitmq 队列
     └─── https请求，从pushed中获取历史消息


                                                     ┌─── session已经断开，则将此消息保存到unpushed
redis──────RedisConsumer───┐                         │
                           │───MessagePushService──────── html页面展示数据
rabbitmq───RabbitConsumer──┘                         │
                                                     └─── session正常，成功push到html后，将此消息保存到pushed

```


## 其他

使用到的技术如下

- springboot + https
- websocket + ssl
- rabbitmq
- redis blpop Transaction
- bootstrap jquery websocket-js

问题如下：

- 1.redis blpop 是一个阻塞线程，在spring初始化的时候，初始化 RedisConsumer 会造成 spring （初始化，加载类）阻塞住。
- 2.使用多线程blpop一个队列，目的是控制从队列获取数据的速度。
- 3.tomcat 容器下 websocket 丢失数据，报错[TEXT_PARTIAL_WRITING]。
- 4.undertow 容器 websocket 丢失数据，且不报错。
- 5.在测试时，服务端返回600k数据，出现异常，服务端`EOFException`，客户端`MessageTooLargeException`

解决办法：

`com.sauzny.springboot01.service.RedisConsumer`

`com.sauzny.springboot01.service.RedisConsumerWorker`

`com.sauzny.springboot01.service.MessagePushService`

test目录中`com.sauzny.springboot01testing.SecureClientSocket`

这四个类中的注释，解决了上面提到的问题

其他：

- tomcat容器下 websocket 中的 session id 是 0 1 2 这样的数字
- undertow容器websocket 中的 session id 是随机字符串（`8qagQdUOx0v1_2QsFpfcSH-pGpaiY_AufjwvZZiE`）。
- jetty容器websocket 中的 session id 是随机字符串（`5687a8d3`）。
- websocket + ssl，客户端测试代码编写过程，最开始使用了org.java-websocket，发现版本问题
	- 1.3.0，需要自己额外增加代码支持ssl，网上文章大部分用的是这种方案
	- 1.3.4，暂时没有找到办法支持ssl
- websocket + ssl，使用jetty ws client


