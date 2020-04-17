# concurrency

并发性，开多线程，加速获取数据。

官方文档：

https://docs.spring.io/spring-kafka/reference/html/#message-listener-container

在页面 `ctrl+F` 搜索 `org.apache.kafka.clients.consumer.RoundRobinAssignor`

## 一、官方列子说明

- 有3个topic，每个topic有5个Partition
- 设置 `concurrency=15`，也就是15个consumer
- 希望每个consumer对上1个Partition

### 1.1 结果

```txt
you see only five active consumers, each assigned one partition from each topic, with the other 10 consumers being idle
您只看到五个活动的消费者，每个用户从每个主题分配一个分区，而其他10个消费者处于空闲状态。
```

5个consumer工作，10个consumer不工作，类似下表

|   | topic1 | topic2 | topic3 |
|---|---|---|---|
| Partition1 | consumer1 | consumer1 | consumer1 |
| Partition2 | consumer2 | consumer2 | consumer2 |
| Partition3 | consumer3 | consumer3 | consumer3 |
| Partition4 | consumer4 | consumer4 | consumer4 |
| Partition5 | consumer5 | consumer5 | consumer5 |

### 1.2 增加配置后结果

```yml
spring.kafka.consumer.properties.partition.assignment.strategy：org.apache.kafka.clients.consumer.RoundRobinAssignor
```

15个consumer工作，类似下表

|   | topic1 | topic2 | topic3 |
|---|---|---|---|
| Partition1 | consumer1 | consumer6 | consumer11 |
| Partition2 | consumer2 | consumer7 | consumer12 |
| Partition3 | consumer3 | consumer8 | consumer13 |
| Partition4 | consumer4 | consumer9 | consumer14 |
| Partition5 | consumer5 | consumer10 | consumer15 |

## 二、我的情况

- 2个KafkaListenerContainerFactory，3个topic，每个topic有1个Partition

两种情况可以正常启动，否则启动失败

## 2.1 增加配置 `RoundRobinAssignor`

两个 `KafkaListenerContainerFactory` 中都增加

```yml
spring.kafka.consumer.properties.partition.assignment.strategy：org.apache.kafka.clients.consumer.RoundRobinAssignor
```

## 2.2 使用不同的 `groupId`

其中一个 `KafkaListenerContainerFactory` 不设置 `RoundRobinAssignor`
另一个 `KafkaListenerContainerFactory` 设置 `RoundRobinAssignor`

此时需要设置不同的 `groupId`

## 2.3 总结

我觉得应该使用设置不同的 `groupId`，来解决上面的问题

因为原文中：

https://docs.spring.io/spring-kafka/reference/html/#listener-group-id

`You can call KafkaUtils.getConsumerGroupId() on the listener thread`

所以我觉得设计者的意图是偏向：尽量不同的 `Container` 使用不同的 `groupId`
