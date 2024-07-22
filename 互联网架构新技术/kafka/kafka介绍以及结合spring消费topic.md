## 一、好久不见

现在是2019年6月12日，距离上一次更新足有一个余月。

这一个多月以来，甚是忙碌。没有时间写作，写博客，写程序。虽然有很多不确定的因素，但最能确定的是，她永远离开我了。为了停止悲痛，我忙到深夜，可每每想起她的一切，还是会想哭。

程序员不需要感性，用理性的头脑才能写好程序。

我端午请假回了趟家，虽说家是避风的港湾，可不是所有的悲痛几天时间就可以忘却。

回到自己家中，一切还是没变。既然回不去，就往前看。

从今天开始，每晚十点，直播程序编写。做以前想做却不敢做的事。

## 二、背景

由于项目中用到了kafka作为消息中间件，要从远程的kafka服务器去消费topic，前前后后搞了好几天。做一下记录。

## 三、什么是kafka

Apache Kafka是一个开源消息系统，由Scala写成，是一个分布式消息队列：生产者、消费者的功能，Kafka对消息保存时根据Topic进行归类，发送消息者称为Producer,消息接受者称为Consumer,此外kafka集群由多个kafka实例组成，每个实例(server)称为broker。

## 四、Kafka核心组件

Topic：消息根据Topic进行归类，可以理解为一个队里。
Producer：消息生产者，就是向kafka broker发消息的客户端。
Consumer：消息消费者，向kafka broker取消息的客户端。
broker：每个kafka实例(server)，一台kafka服务器就是一个broker，一个集群由多个broker组成，一个broker可以容纳多个topic。
Zookeeper：依赖集群保存meta信息。

## 五、Kafka消息有序性

1、生产者是一个独立的集群，和kafka的broker集群，消费者集群没有太直接的干系。比如flume就可以作为生产者，内部调用kafka的客户端代码，确保把收集的数据发到kafka集群中。

2、如何保证kafka全局消息有序？

```
比如，有100条有序数据，生产者发送到kafka集群，kafka的分片有4个，可能的情况就是一个分片保存0-25，一个保存25-50......这样消息在kafka中存储是局部有序了。严格说，kafka是无法保证全局消息有序的，没有这个机制，只能局部有序。
　　但是如果只有一个分片和一个消息的生产者，那么就相当于消息全局有序了。如果有多个消息生产者，就算只有一个分片，如果这些生产者的消息都发给这个分片，那kafka中的消息连局部有序都没有办法了。
```

## 六、消费者组

```
Consumer Group（CG）：这是kafka用来实现一个topic消息的广播（发给所有的consumer）和单播（发给任意一个consumer）的手段。一个topic可以有多个CG。topic的消息会复制（不是真的复制，是概念上的）到所有的CG，但每个partion只会把消息发给该CG中的一个consumer。如果需要实现广播，只要每个consumer有一个独立的CG就可以了。要实现单播只要所有的consumer在同一个CG。用CG还可以将consumer进行自由的分组而不需要多次发送消息到不同的topic。
　　Partition：为了实现扩展性，一个非常大的topic可以分布到多个broker（即服务器）上，一个topic可以分为多个partition，每个partition是一个有序的队列。partition中的每条消息都会被分配一个有序的id（offset）。kafka只保证按一个partition中的顺序将消息发给consumer，不保证一个topic的整体（多个partition间）的顺序。
　　Offset：kafka的存储文件都是按照offset.kafka来命名，用offset做名字的好处是方便查找。例如你想找位于2049的位置，只要找到2048.kafka的文件即可。当然the first offset就是00000000000.kafka。
 
　　每个group中可以有多个consumer，每个consumer属于一个consumer group；通常情况下，一个group中会包含多个consumer，这样不仅可以提高topic中消息的并发消费能力，而且还能提高"故障容错"性，如果group中的某个consumer失效那么其消费的partitions将会有其他consumer自动接管。
　　对于Topic中的一条特定的消息，只会被订阅此Topic的每个group中的其中一个consumer消费，此消息不会发送给一个group的多个consumer；那么一个group中所有的consumer将会交错的消费整个Topic，每个group中consumer消息消费互相独立，我们可以认为一个group是一个"订阅"者。
　　在kafka中,一个partition中的消息只会被group中的一个consumer消费(同一时刻)；一个Topic中的每个partions，只会被一个"订阅者"中的一个consumer消费，不过一个consumer可以同时消费多个partitions中的消息。
　　kafka的设计原理决定,对于一个topic，同一个group中不能有多于partitions个数的consumer同时消费，否则将意味着某些consumer将无法得到消息。kafka只能保证一个partition中的消息被某个consumer消费时是顺序的；事实上，从Topic角度来说,当有多个partitions时,消息仍不是全局有序的。
```

## 七、Producer客户端负责消息的分发

```
　kafka集群中的任何一个broker都可以向producer提供metadata信息,这些metadata中包含"集群中存活的servers列表"/"partitions leader列表"等信息；
　　当producer获取到metadata信息之后, producer将会和Topic下所有partition leader保持socket连接；
　　消息由producer直接通过socket发送到broker，中间不会经过任何"路由层"，事实上，消息被路由到哪个partition上由producer客户端决定；比如可以采用"random""key-hash""轮询"等,如果一个topic中有多个partitions,那么在producer端实现"消息均衡分发"是必要的。
　　在producer端的配置文件中,开发者可以指定partition路由的方式。
　　Producer消息发送的应答机制设置发送数据是否需要服务端的反馈,有三个值0,1,-1
　　　 0:producer不会等待broker发送ack
　　　　1:当leader接收到消息之后发送ack
　　　　-1:当所有的follower都同步消息成功后发送ack
　　request.required.acks=0
```

## 八、kafka的安装和部署

（kafka在window有很多的不兼容，建议在Linux上进行搭建）

参考文章：

<https://www.cnblogs.com/justuntil/p/8033792.html>

## 九、消费者如何消费kafka的topic

采用spring结合kafka的注解式开发是比较高效的做法，但是有很多的小细节需要注意。

参考文章：

<https://blog.csdn.net/u010906369/article/details/74978595>

## 十、具体实例


