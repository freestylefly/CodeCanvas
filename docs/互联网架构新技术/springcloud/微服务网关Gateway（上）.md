大家好呀，我是苍何。

这年头，大家都在开始卷简历了，我也看了很多同学的简历，其中有一个同学的简历，我印象最为深刻，他的项目经历中，写了**自定义 Gateway 过滤器实现统计接口调用耗时**，我瞬间就来兴趣了~

要知道利用微服务中的网关过滤器能力来统计接口调用耗时情况，其落地项目和设计思路是很考察对微服务架构整体掌握程度的。

那今天我们就来重点看一看微服务中的网关吧，还是以 PmHub 项目实践深入展开。

# 为什么需要网关
网关我觉得可以理解成是微服务系统的**门卫**，是微服务架构中一个关键的组件，负责管理和调控外部请求进入内部微服务的流量。为了更好理解，拿个生活中的例子来对比下：

一个大型的购物中心（微服务系统），里面有很多不同的商店（不同的微服务），比如服装店、餐馆、电影院等等。每个商店都有自己**独立的入口**，这样的好处是每个商店都可以独立运营。但是，如果每个顾客都直接去商店入口没有**统一入口**，会非常混乱。

而且，购物中心需要对每个商店的顾客流量进行管理，比如防止某些商店人满为患或者统一处理会员优惠等。

![大型购物中心](https://cdn.tobebetterjavaer.com/stutymore/1716514349560-fbd5628f-43a0-42f5-962e-eb29a141c7ef.webp "大型购物中心")

网关在微服务体系中的具体位置在哪儿呢？

![网关的位置](https://cdn.tobebetterjavaer.com/stutymore/1716514447640-d34b7f90-60db-4676-8d1f-58ce97e4d826.png "网关的位置")

可以看到，网关在负载均衡下的第一入口，也就是说，整个微服务系统，外部请求都必须要经过网关，可以说是整个系统的**门卫**了。那网关具体负责哪些呢？

![网关能干嘛](https://cdn.tobebetterjavaer.com/stutymore/1716515684720-db4fe2e3-f2c0-424f-b5c9-a02e12f904e8.png "网关能干嘛")

总结来说，微服务的应用可能部署在不同机房，不同地区，不同域名下。此时客户端（浏览器/手机/软件工具）想要请求对应的服务，都需要知道机器的具体 IP 或者域名 URL，当微服务实例众多时，这是非常难以记忆的，对 于客户端来说也太复杂难以维护。

此时就有了网关，客户端相关的请求直接发送到网关，由网关根据请求标识解析判断出具体的微服务地址，再把请求转发到微服务实例。这其中的**记忆功能**就全部交由网关来操作了。
# 网关选型
Cloud 全家桶中有个很重要的组件就是网关，在 1.x 版本中都是采用的 Zuul 网关；但在 2.x 版本中，Zuul 的升级一直**跳票**，SpringCloud 最后自己研发了一个网关 SpringCloud Gateway 替代 Zuul。所以新项目，我们就别再去用 Zuul 了，简历上也最好以 Gateway 为主。

所以目前用的主流的网关就是 SpringCloud Gateway 替代 Zuul 1.x 版网关。PmHub 中采用的也是自建 SpringCloud Gateway 的方式。

## Spring Cloud Gateway

Spring Cloud Gateway是基于 Spring 生态系统之上构建的 API 网关，包括：Spring 5.x，Spring Boot 2.x 和 Project Reactor。Spring Cloud Gateway 旨在提供一种简单而有效的方法来路由到 API，并为它们提供跨领域的关注点，例如：**安全性，监视/指标，限流**等。

以下是官方原理图：

![gateway How It Works](https://cdn.tobebetterjavaer.com/stutymore/1716516448626-db141bf3-6e47-41cb-ad56-ba122204c2a1.png "gateway How It Works")

# Gateway 三大核心

看官网介绍可知，Spring Cloud Gateway 三大核心组件分别是**路由**（Route）、**断言**（Predicate）、**过滤器**（Filter），构成了网关的必要功能。

![官网关于Spring Cloud Gateway三大组件](https://cdn.tobebetterjavaer.com/stutymore/1716521519061-8b8291cb-1f8c-4e01-ae90-394326edb602.png "官网关于Spring Cloud Gateway三大组件")

web 前端请求，通过一些匹配条件，定位到真正的服务节点。并在这个转发过程的前后，进行一些精细化控制。

predicate就是我们的匹配条件。

filter，就可以理解为一个无所不能的拦截器。有了这两个元素，再加上目标uri，就可以实现一个具体的路由了。

![三大核心组件](https://cdn.tobebetterjavaer.com/stutymore/1716521499393-41d26ced-d279-4106-895a-76b0601a68cf.png "三大核心组件")
## 路由（Route）

路由是构建网关的基本模块，它由 ID，目标 URI，一系列的断言和过滤器组成，如果断言为 true 则匹配该路由。

在 PmHub 中网关的路由配置如下：
```yaml
spring:
  cloud:
    gateway:
      discovery:
        locator:
          lowerCaseServiceId: true
          enabled: true
      routes:
        # 认证中心
        - id: pmhub-auth
          uri: lb://pmhub-auth
          predicates:
            - Path=/auth/**
          filters:
            # 验证码处理
            - CacheRequestFilter
           # - ValidateCodeFilter
            - StripPrefix=1
        # 代码生成
        - id: pmhub-gen
          uri: lb://pmhub-gen
          predicates:
            - Path=/gen/**
          filters:
            - StripPrefix=0
```

拿认证中心服务来说，id 取的就是 auth 在 nacos 注册的服务名，这样，请求网关的 URL 中带有「/auth/**」的请求都会被转发到认证中心这个服务上来。

在spring cloud gateway中配置uri有三种方式，包括

### websocket配置方式
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pmhub-api
          uri: ws://localhost:9090/
          predicates:
            - Path=/api/**
```

### http地址配置方式
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pmhub-api
          uri: http://localhost:9090/
          predicates:
            - Path=/api/**
```

### 注册中心配置方式
其中 PmHub 中采用的是这种通过 Nacos 配置中心的配置方式。
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: pmhub-api
          uri: lb://ruoyi-api
          predicates:
            - Path=/api/**
```


## 断言（Predicate）

断言可以理解为是**匹配规则**，比如在 PmHub 中配置的「 - Path=/auth/**」就代表所有符合这个路径的规则都会被转发到对应的服务上面来。可以看下官网介绍：

![官网关于断言介绍](https://cdn.tobebetterjavaer.com/stutymore/1716525685437-192770a2-7bac-4f45-b5cb-8e4e1d3b1bca.png "官网关于断言介绍")
简而言之，Predicate 就是为了实现一组匹配规则，让请求过来找到对应的Route 进行处理。

Spring Cloud Gateway 创建 Route 对象时， 使用RoutePredicateFactory 创建 Predicate 对象，Predicate 对象可以赋值给Route。

- Spring Cloud Gateway包含许多内置的Route Predicate Factories。
- 所有这些断言都匹配 HTTP 请求的不同属性。
- 多个Route Predicate Factories可以通过逻辑与（and）结合起来一起使用。

路由断言工厂 RoutePredicateFactory 包含的主要实现类如图所示，包括Datetime、请求的远端地址、路由权重、请求头、Host 地址、请求方法、请求路径和请求参数等类型的路由断言。

![RoutePredicateFactory 整体架构](https://cdn.tobebetterjavaer.com/stutymore/1716526492684-86556361-5100-4172-946b-e5f825979b3d.png "RoutePredicateFactory 整体架构")

当然了除了我们定义的规则，也是可以支持一下路由规则的自定义的，以下是一些常用的断言。

### Weight-匹配权重
```yaml
spring: 
  application:
    name: pmhub-gateway
  cloud:
    gateway:
      routes:
        - id: pmhub-system-a
          uri: http://localhost:9201/
          predicates:
            - Weight=group1, 8
        - id: pmhub-system-b
          uri: http://localhost:9201/
          predicates:
            - Weight=group1, 2
```
### Datetime-匹配日期时间之后发生的请求
```yaml
spring: 
  application:
    name: pmhub-gateway
  cloud:
    gateway:
      routes:
        - id: pmhub-system
          uri: http://localhost:9201/
          predicates:
            - After=2021-02-23T14:20:00.000+08:00[Asia/Shanghai]
```
### Query-匹配查询参数
```yaml
spring: 
  application:
    name: pmhub-gateway
  cloud:
    gateway:
      routes:
        - id: pmhub-system
          uri: http://localhost:9201/
          predicates:
            - Query=username, abc.
```
### Path-匹配请求路径
```yaml
spring: 
  application:
    name: pmhub-gateway
  cloud:
    gateway:
      routes:
        - id: pmhub-system
          uri: http://localhost:9201/
          predicates:
            - Path=/system/**
```
### Header-匹配具有指定名称的请求头，
\d+值匹配正则表达式
```yaml
spring: 
  application:
    name: pmhub-gateway
  cloud:
    gateway:
      routes:
        - id: pmhub-system
          uri: http://localhost:9201/
          predicates:
            - Header=X-Request-Id, \d+
```

当然了，内置的模板不满足需求，也是可以**自定义断言规则**的，方法也比较简单，按照以下套路即可：

- 要么继承 AbstractRoutePredicateFactory 抽象类
- 要么实现 lRoutePredicateFactory:接口
- 类开头任意取名，但是必须以 RoutePredicateFactory 后缀结尾

如下代码：
```java
/**
 * @auther canghe
 * @create 2024-05-23 18:30
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config>
{
    public MyRoutePredicateFactory()
    {
        super(MyRoutePredicateFactory.Config.class);
    }

    @Validated
    public static class Config{
        @Setter
        @Getter
        @NotEmpty
        private String userType; //钻、金、银等用户等级
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config)
    {
        return new Predicate<ServerWebExchange>()
        {
            @Override
            public boolean test(ServerWebExchange serverWebExchange)
            {
                //检查request的参数里面，userType是否为指定的值，符合配置就通过
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");

                if (userType == null) return false;

                //如果说参数存在，就和config的数据进行比较
                if(userType.equals(config.getUserType())) {
                    return true;
                }

                return false;
            }
        };
    }
}

```

## 过滤器（Filter）

网关中的过滤器，有点类似 SpringMVC 里面的拦截器 Interceptor 以及 Servlet 的过滤器，其中「pre」 和「post」分别会在请求被执行钱调用和被执行后调用，用来修改请求和响应信息。

过滤器也是面试中最常问的知识点，比如**记录接口调用市场统计、限流、黑白名单等。**

因文章篇幅有限，将在下一章单独细说细说，可见其重要程度了，也是 PmHub 项目框架的核心之一了。感兴趣可以持续关注。












