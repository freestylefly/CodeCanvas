大家好，我是苍何。

在微服务架构下，一个业务将会被拆成多个微服务，各个服务间相互通信形成完整功能，那么大家清楚系统间都是如何通信协作的吗？

不卖关子啦，系统间的通信协作通常有 2 种：

- HTTP/RPC 通信
- 消息通信

HTTP/RPC 通信是微服务系统的标配，不是今天的主角，今天的主角是消息通信，而主角中的主角是消息通信中叱咤风云的 **RocketMQ**。

## 什么是消息队列

为了大家更好理解消息队列以及 RocketMQ，我将会通过好朋友鸡毛开餐馆的故事来展开。

“老板，我的酸菜鱼好了没，都等 20 分钟了！”坐在角落那桌的长腿女生极为不满的吼道。

“就快了，稍等！”鸡毛一边用挂在脖子上的毛巾擦汗，一边看着满桌子的订单，活了大半辈子也没见像今天生意这么好的样子。

鸡毛是个大厂退役的 Java 开发，拿着被裁的几个月赔偿费和多年来做牛马的一点积蓄，回老家开了个破烂的餐馆。餐馆是个收垃圾的铺子改造而来，一开始顾客总觉得餐馆有股难闻的气味，所以来的人基本保持在个位数左右。

这几天鸡毛搞了个促销，有些好转，但也不愠不火，今天像发了神经私的，不知道哪儿来的这么多人。

顾客点单，写在纸条上，然后直接丢给鸡毛，鸡毛放在一个桌子上，就开始炒菜。这个流程在人少的时候当然没问题，鸡毛甚至还有时间刷一会美女视频，但人一多，就手足无措了。

鸡毛看着桌子上堆积的订单，想起这不正是消息队列的场景吗？订单是消息，顾客是生产消息的生产者，而鸡毛是订单的消费者。

![什么是消息队列](https://cdn.nlark.com/yuque/0/2024/png/29495295/1720591454288-e498b142-f6cf-4a99-b7d0-60bb5ef6988f.png#averageHue=%23403e3d&clientId=u0df9f2c2-02e9-4&from=ui&id=u18492958&originHeight=808&originWidth=1476&originalType=binary&ratio=2&rotation=0&showTitle=true&size=107379&status=done&style=none&taskId=udf5fd1c3-61c9-4c76-a682-032f8db7308&title=%E4%BB%80%E4%B9%88%E6%98%AF%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97 "什么是消息队列")
整个消息队列组件其实就三部分：

- **生产者**：生产消息的一方，比如顾客就是生产者
- **消息队列**：就是消息的「篮子」，用来存放消息，比如鸡毛餐馆的桌子
- **消费者**：专门负责消息的一方，比如鸡毛

在分布式微服务系统中，消息队列在系统中扮演者很重要的角色，如果说整个系统是皇帝，消息队列至少是三品以上的大臣了。主要有**解耦**、**异步处理**、**削峰**等作用。

## 常用的消息队列有哪些？

下面一个表格整理了常用的消息队列以及性能对比：

| 特性 | Kafka | ActiveMQ | RabbitMQ | RocketMQ |
| --- | --- | --- | --- | --- |
| **功能支持** | 分布式、分区、高吞吐量、流处理、持久化 | JMS 支持、持久化、事务、消息过滤 | 消息路由、插件机制、持久化、多种协议支持 | 分布式、高吞吐量、事务、定时和延时消息、持久化 |
| **可用性** | 高（多副本机制、自动恢复） | 高（支持主从架构和多种持久化机制） | 高（镜像队列、集群模式） | 高（多副本机制、集群模式） |
| **消息可靠性** | 高（数据复制、多副本） | 高（持久化存储、事务支持） | 高（确认机制、持久化存储） | 高（数据复制、多副本、持久化存储） |
| **时效性** | 毫秒级（取决于配置和网络条件） | 毫秒级（取决于配置和网络条件） | 微秒级到毫秒级（取决于配置和网络条件） | 毫秒级（取决于配置和网络条件） |
| **topic 数量对吞吐量的影响** | 影响较大（分区机制带来管理和资源消耗） | 影响中等（队列管理开销） | 影响较小（高效的路由机制） | 影响中等（分区机制和管理开销） |
| **单机吞吐量** | 高（百万级消息每秒） | 中等（十万级消息每秒） | 中等（十万级消息每秒） | 高（百万级消息每秒） |
| **Client SDK** | 多语言（Java、Scala、Python等） | 多语言（Java、C、C++等） | 多语言（Java、Erlang、.NET等） | 多语言（Java、C++、Go等） |

我们不难得出结论：

- 如果是大数据领域的**实时计算**、**日志采集**等场景，就用 kafka
- 对时效性有要求，且不关心底层情况，用 RabbitMQ 就可以
- 国内的大部分项目，特别是微服务项目，就用阿里的 RocketMQ 就好了，有丰富的教程且是阿里出品，经历过双十一这种大促，肯定是没问题的。

## RocketMQ 是什么？

终于到我们的主角出场啦🎉， RocketMQ 是阿里开源的消息中间件，具有**高性能、高可靠、高实时、分布式 **的特点，底层是用 Java 语言开发的分布式组件。2016 年成为 Apache 的顶级项目，在阿里内部经历了多年的双十一的拷打，主打一个能抗能打。

- 官网地址：[https://rocketmq.apache.org/](https://rocketmq.apache.org/)
- 开源地址：[https://github.com/apache/rocketmq](https://github.com/apache/rocketmq)

![官网截图](https://cdn.nlark.com/yuque/0/2024/png/29495295/1719800067792-10ee3b6a-e7fb-4f98-a1fc-e84c10941fa2.png#averageHue=%23152a67&clientId=ud78c5ee7-482f-4&from=paste&height=594&id=ub17064b7&originHeight=1188&originWidth=2280&originalType=binary&ratio=2&rotation=0&showTitle=true&size=2157513&status=done&style=none&taskId=u4b95be14-0d6f-4cfd-a3ed-198f74b4bc3&title=%E5%AE%98%E7%BD%91%E6%88%AA%E5%9B%BE&width=1140 "官网截图")

不得不说，官网做的还是很炫酷的！下面是一张底层架构图：

![架构（来自管网）](https://cdn.nlark.com/yuque/0/2024/png/29495295/1719800144582-dafe080d-0a94-457f-9199-efa47397e76c.png#averageHue=%23666666&clientId=ud78c5ee7-482f-4&from=drop&id=u9bdd2438&originHeight=541&originWidth=1342&originalType=binary&ratio=2&rotation=0&showTitle=true&size=62810&status=done&style=none&taskId=u4ce03599-9220-4810-a35f-43e19fdb6d9&title=%E6%9E%B6%E6%9E%84%EF%BC%88%E6%9D%A5%E8%87%AA%E7%AE%A1%E7%BD%91%EF%BC%89 "架构（来自管网）")

图中不难看出， RocketMQ 主要有以下 4 个部分：
### 生产者 Producer
这哥们是个发布消息的角色。Producer 通过 MQ 的负载均衡模块选择相应的 Broker 集群队列进行消息投递，投递的过程支持快速失败和重试。

![](https://cdn.nlark.com/yuque/0/2024/jpeg/29495295/1720593920805-97326e74-0175-49ac-9262-c76ddf0cfdae.jpeg)
### 消费者 Consumer
这哥们是消息消费的角色：

- 支持推（push）和拉（pull）两种模式对消息进行消费。
- 支持集群方式和广播方式的消费。
- 提供实时消息订阅机制，可以满足大多数用户的需求。

![](https://cdn.nlark.com/yuque/0/2024/jpeg/29495295/1720594340316-6e0e29e7-4f91-4668-aaed-4c79a39761df.jpeg)
### 名字服务器 NameServer
NameServer 是 RocketMQ 中的注册中心，支持 Topic、Broker 的动态注册与发现。

主要包括两个功能：

- Broker管理： NameServer接受Broker集群的注册信息并且保存下来作为路由信息的基本数据，并提供心跳检测机制，检查Broker是否存活。
- 路由信息管理： 每个NameServer将保存关于 Broker 集群的整个路由信息和用于客户端查询的队列信息。Producer和Consumer通过NameServer可以知道整个Broker集群的路由信息，从而进行消息的投递和消费。


NameServer通常会有多个实例部署，各实例间相互不进行信息通讯。Broker向每一台NameServer注册自己的路由信息，每个NameServer实例上都保存一份完整的路由信息。当某个NameServer因某种原因下线了，客户端仍然可以向其它NameServer获取路由信息。

![aHR0cHM6Ly9hdGEyLWltZy5jbi1oYW5nemhvdS5vc3MtcHViLmFsaXl1bi1pbmMuY29tL2FmZThlMWI3OTVkZGI5NTVhOTAwZDY5ZmJmYmJlNDY4LnBuZw.png](https://cdn.nlark.com/yuque/0/2024/png/29495295/1720594605156-ffe95913-1f1f-4aed-906a-94b5014f8a86.png#averageHue=%23f3dbc8&clientId=u0df9f2c2-02e9-4&from=drop&id=u9401d317&originHeight=838&originWidth=1672&originalType=binary&ratio=2&rotation=0&showTitle=false&size=455311&status=done&style=none&taskId=ua56e5275-690c-4482-8000-4d6882b8e63&title=)

### 代理服务器 Broker
Broker 主要负责消息的存储、投递和查询以及服务高可用保证。

- NameServer几乎无状态节点，因此可集群部署，节点之间无任何信息同步。
- Broker部署相对复杂。在 Master-Slave 架构中，Broker 分为 Master 与 Slave。一个Master可以对应多个Slave，但是一个Slave只能对应一个Master。Master 与 Slave 的对应关系通过指定相同的BrokerName，不同的BrokerId 来定义，BrokerId为0表示Master，非0表示Slave。Master也可以部署多个。

做个总结吧：

- 每个 Broker 与 NameServer 集群中的所有节点建立长连接，定时注册 Topic 信息到所有 NameServer。
- Producer 与 NameServer 集群中的其中一个节点建立长连接，定期从 NameServer 获取 Topic 路由信息，并向提供 Topic 服务的 Master 建立长连接，且定时向 Master 发送心跳。Producer 完全无状态。
- Consumer 与 NameServer 集群中的其中一个节点建立长连接，定期从 NameServer 获取 Topic 路由信息，并向提供 Topic 服务的 Master、Slave 建立长连接，且定时向 Master、Slave发送心跳。Consumer 既可以从 Master 订阅消息，也可以从Slave订阅消息。



