大家好呀，我是苍何。

这几天京东可是真“火”啊，从严抓考勤到京东内部会议传言说的业绩不好的都不是东哥的兄弟，再到这两天传的比较火的，关于京东刚转正 12 天的 00 后应届生因在内网说了一句“什么时候被拼多多收购”，而被光速劝退。

![截图来自朋友沉默王二公众号](https://cdn.nlark.com/yuque/0/2024/jpeg/29495295/1716777413986-46bd743b-40ff-4101-a3ce-bcfbf6a4cc06.jpeg#averageHue=%23e6e6e6&clientId=u3a23e7be-ab4a-4&from=drop&id=u25ebc1d1&originHeight=470&originWidth=588&originalType=binary&ratio=2&rotation=0&showTitle=true&size=52128&status=done&style=none&taskId=u9247194d-b7cd-452e-89f3-ff6bcadc980&title=%E6%88%AA%E5%9B%BE%E6%9D%A5%E8%87%AA%E6%9C%8B%E5%8F%8B%E6%B2%89%E9%BB%98%E7%8E%8B%E4%BA%8C%E5%85%AC%E4%BC%97%E5%8F%B7 "截图来自朋友沉默王二公众号")

因为脑子一热评论的玩笑话结果被 HR 当真了，关键还在评论可能直接被东哥看到了，所以才如此大动静。

我想到了昨晚看的《庆余年2》中的一段场景，赖御史在朝堂上杀疯了，参了范闲和整个范家，甚至参了皇子，这还不算什么，甚至连庆帝照参不误，最后落得个被活活打死的下场。

![图来源于网络](https://cdn.nlark.com/yuque/0/2024/webp/29495295/1716777735367-c8c450c7-a391-4d08-a064-12c5b38bd1d2.webp#averageHue=%23483a33&clientId=u3a23e7be-ab4a-4&from=drop&id=u3aa814f0&originHeight=347&originWidth=750&originalType=binary&ratio=2&rotation=0&showTitle=true&size=16120&status=done&style=none&taskId=u9ba09fad-95f6-4e54-9155-af175e36f87&title=%E5%9B%BE%E6%9D%A5%E6%BA%90%E4%BA%8E%E7%BD%91%E7%BB%9C "图来源于网络")

职场又何尝不是如此，虽说公司鼓励言论自由，鼓励直言进谏，鼓励吐槽，但也得看什么时候，也得看什么场合，比如赖御史在庆帝一次又一次给他机会不要再继续的时候还照参不误，就是在火上浇油。

这位同学的评论我相信也就是脑子一热写的，放在平时，京东都在忙业绩的时候，谁都不会在意这事，即使东哥看了，也就一乐，并可能在脑子里想“哈哈， PDD就等着被我收购吧”。

但今时不同往日，正赶上京东抓考勤裁员、业绩下滑的风口，发出这段评论给东哥看到，可想而知，最后的结局。

职场就是个小社会，虽然像我们做技术的有时候觉得自己只要干好自己的一亩三分地，仿佛就万事大吉了，但那可能是没接触到现实的无奈，我就很有感触，自从做了管理后，一切就不是只有写代码那么简单。

公司的状况，业绩情况，高层下发的任务，指标以及最近公司的政策，甚至是优化人员这些消息，比以往来的更快更多，有时候甚至会比下面小伙伴更加先焦虑，而且还需要处理好关系，跨部门沟通往往比想象的还麻烦。

其实公司做的好不好，很大概率取决于**决策层**，比如有些领导觉得员工不加班就在那里说他们没有奋斗精神，但其实可能是因为业务本来就没多少，事情就那么多，有些人只是不想在那里卷罢了。

但打工人很多时候还是需要**谨言慎行**，特别是互联网是有**记忆**的，数据是可追溯的，你的任何言论特别是内网发布的，都可以直接查到你，有时候发布的东西也要仔细斟酌，并对此负责。

互联网已经过了黄金时代，现在是存量竞争，蛋糕就那么大，谁分的多一些，谁自然就分的少一些，就拿刚过去的一季度来说，京东盈利只有 89 亿元，而拼多多是其的 3 倍多，你说东哥脚步焦虑？

对外业务扩展到底，于是只能先拿内部整治了，所以也就有了严查考勤这事，让员工拼命加班，用有限的时间换取更多的业绩。

如果你是东哥，这个时候看到这个评论，你会不会破防呢？

以前总说 00 后是整顿职场的先锋队，特别是无房无车没结婚的更是厉害，加班？那是不可能的，但今年这些消息少了好多，反观倒是失业统计中的青年失业率却一直稳高不降。

究其原因还是工作不好找了，职场就更难整顿了，现在有人甚至直言，有一份 996 的工作真的是福报了，毕竟好歹是一份工作啊。

你看虽说京东这次这么寒了大家的心，但毕竟还是大厂，依旧阻挡不了前仆后继的应届生进来，而大厂领导们只会更加有恃无恐，反正你不来，有的是人来。

反观打工人，我们更需要**谨言慎行**，做好当下工作的同时，想办法**探寻更多的可能性**。

说到进大厂这事，就不得不提项目，下面继续来说下我们项目中用到的微服务网关 Gateway 的技术点。主要涵盖过滤器，限流处理以及黑白名单配置。

## 过滤器

网关中的过滤器，有点类似 SpringMVC 里面的拦截器 Interceptor 以及 Servlet 的过滤器，其中「pre」 和「post」分别会在请求被执行钱调用和被执行后调用，用来修改请求和响应信息。

过滤器也是面试中最常问的知识点，比如记录接口调用市场统计、限流、黑白名单等。

按照类型分的话，过滤器分为全局默认过滤器、单一内置过滤器和自定义过滤器。

![](https://cdn.nlark.com/yuque/0/2024/jpeg/29495295/1716763117140-1836dde4-502d-493a-8251-60bd89dd5fc6.jpeg)

### 全局过滤器

全局过滤器作用于所有的路由，不需要单独配置，我们可以用它来实现很多统一化处理的业务需求，比如权限认证，IP 访问限制等等。目前网关统一鉴权 AuthFilter.java 就是采用的全局过滤器。
单独定义只需要实现 GlobalFilter, Ordered 这两个接口就可以了。

```java
/**
 * 网关鉴权
 *
 * @author canghe
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    // 排除过滤的 uri 地址，nacos自行添加
    @Autowired
    private IgnoreWhiteProperties ignoreWhite;

    @Autowired
    private RedisService redisService;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();

        String url = request.getURI().getPath();
        // 跳过不需要验证的路径
        if (StringUtils.matches(url, ignoreWhite.getWhites())) {
            return chain.filter(exchange);
        }
        String token = getToken(request);
        if (StringUtils.isEmpty(token)) {
            return unauthorizedResponse(exchange, "令牌不能为空");
        }
        Claims claims = JwtUtils.parseToken(token);
        if (claims == null) {
            return unauthorizedResponse(exchange, "令牌已过期或验证不正确！");
        }
        String userkey = JwtUtils.getUserKey(claims);
        boolean islogin = redisService.hasKey(getTokenKey(userkey));
        if (!islogin) {
            return unauthorizedResponse(exchange, "登录状态已过期");
        }
        String userid = JwtUtils.getUserId(claims);
        String username = JwtUtils.getUserName(claims);
        if (StringUtils.isEmpty(userid) || StringUtils.isEmpty(username)) {
            return unauthorizedResponse(exchange, "令牌验证失败");
        }

        // 设置用户信息到请求
        addHeader(mutate, SecurityConstants.USER_KEY, userkey);
        addHeader(mutate, SecurityConstants.DETAILS_USER_ID, userid);
        addHeader(mutate, SecurityConstants.DETAILS_USERNAME, username);
        // 内部请求来源参数清除（防止网关携带内部请求标识，造成系统安全风险）
        removeHeader(mutate, SecurityConstants.FROM_SOURCE);
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }
}
```

### 单一内置过滤器

单一内置过滤器也可以称为网关过滤器，这种过滤器主要是作用于单一路由或者某个路由。

![单一内置过滤器-官网](https://cdn.tobebetterjavaer.com/stutymore/20240527064612.png#id=o2PfB&originHeight=386&originWidth=2160&originalType=binary&ratio=1&rotation=0&showTitle=true&status=done&style=none&title=%E5%8D%95%E4%B8%80%E5%86%85%E7%BD%AE%E8%BF%87%E6%BB%A4%E5%99%A8-%E5%AE%98%E7%BD%91 "单一内置过滤器-官网")

有以下几种常见的单一过滤器。

- 指定请求头内容

可以过滤掉指定请求头的路径，比如我希望此方法只允许请求头中带有“X-Request-pmhub”或者“X-Request-pmhub2”的请求。

```java

/**
 * @author canghe
 * @description GatewayFilter
 * @create 2024-05-27-06:55
 */
public class GatewayFilter {
    @GetMapping(value = "/pay/gateway/filter")
    public AjaxResult getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName +"\t\t\t"+"请求头值: " + headValue);
            if(headName.equalsIgnoreCase("X-Request-pmhub")
                    || headName.equalsIgnoreCase("X-Request-pmhub2")) {
                result = result+headName + "\t " + headValue +" ";
            }
        }
        return AjaxResult.success("getGatewayFilter 过滤器 test： "+result+" \t "+ DateUtil.now());
    }
}

```

那就可以在配置中做如下配置即可：

```yaml
 predicates:
        - Path=/auth/gateway/info/**              # 断言，路径相匹配的进行路由

        - id: pmhub_routh3 #pay_routh3
          uri: lb://cloud-pmhub-service                #匹配后提供服务的路由地址
          predicates:
            - Path=/pay/gateway/filter/**              # 断言，路径相匹配的进行路由
          filters:
            - AddRequestHeader=X-Request-pmhub,pmhubValue1  # 请求头kv，若一头含有多参则重写一行设置
            - AddRequestHeader=X-Request-pmhub2,pmhubValue2
```

那么方法就能针对特定请求头内容做逻辑处理就好了，这样针对于请求头中的内容可以做过滤，可用于其他鉴权等情况。


- 指定请求参数

对于特定请求参数进行过滤，只有带有该参数的请求才可执行逻辑。
```yaml
  predicates:
            - Path=/auth/gateway/filter/**              # 断言，路径相匹配的进行路由
          filters:
            - AddRequestParameter=customerId,9527001 # 新增请求参数Parameter：k ，v
            - RemoveRequestParameter=customerName   # 删除url请求参数customerName，你传递过来也是null
```

很多朋友在问新项目的进展，这里我统一放一下彩蛋：

> 我们已经完成了所有代码编写，目前正在文档和教程完善中，提供了单体和微服务版本，并且提供了一套由单体应用改造为微服务的可落地方法论，并能帮助同学们快速掌握分布式微服务项目的核心知识，主要技术栈有：SpringCloud、SpringCloud Alibaba、Spring Boot Actuator、Skywalking、Sentinel 熔断降级、Seata 分布式事务等，


- 指定回应头

可以添加响应头信息，这样对于下游系统或者 web 可以做相应的逻辑处理和鉴权。这个过滤器应用场景可以无限发挥你的想象。
```yaml
  predicates:
            - Path=/auth/gateway/filter/**              # 断言，路径相匹配的进行路由
          filters:
            - AddResponseHeader=X-Response-pmhub, BlueResponse # 新增请求参数X-Response-pmhub并设值为BlueResponse
            
```

- 指定前缀和路径

很好理解，就是能对前缀和路径进行过滤，还可以进行路径重定向，配置如下：

```yaml
  predicates:
            - Path=/auth/gateway/filter/**              # 断言，路径相匹配的进行路由
          filters:
            - PrefixPath=/pmhub # http://localhost:6880/pmhub/gateway/filter
            - RedirectTo=302, https://laigeoffer.cn/ # 访问http://localhost:6880/pmhub/gateway/filter跳转到https://laigeoffer.cn/
            
```

### 自定义过滤器
经典面试题：如何统计接口调用耗时情况，说说设计思路？

这里我们就可以利用 gateway 的自定义过滤器功能来实现该功能。需要自定义全局 filter，只需要实现 GlobalFilter, Ordered 这两个接口，并在 filter 方法中进行接口访问耗时情况统计即可，比如这个 demo：

```java
return chain.filter(exchange).then(Mono.fromRunnable(()->{
    Long beginVisitTime = exchange.getAttribute(BEGIN_VISIT_TIME);
    if (beginVisitTime != null){
        log.info("访问接口主机: " + exchange.getRequest().getURI().getHost());
        log.info("访问接口端口: " + exchange.getRequest().getURI().getPort());
        log.info("访问接口URL: " + exchange.getRequest().getURI().getPath());
        log.info("访问接口URL参数: " + exchange.getRequest().getURI().getRawQuery());
        log.info("访问接口时长: " + (System.currentTimeMillis() - beginVisitTime) + "ms");
        log.info("我是美丽分割线: ###################################################");
        System.out.println();
    }
}));
```

实际上在 pmhub 中统计接口调用耗时情况只需要通过以下一行代码即可：

```java
//先记录下访问接口的开始时间
        exchange.getAttributes().put(BEGIN_VISIT_TIME, System.currentTimeMillis());
```

这个点大家完全可以体现在**简历**中，可以大大**加分**哦。

## 限流配置

限流，顾名思义，就是对流量进行限制。通过实施限流措施，我们可以有效地管理系统的每秒请求数（QPS），从而实现对系统的保护。

常见的限流算法包括：**计数器算法**、**漏桶算法**（Leaky Bucket）、以及**令牌桶算法**（Token Bucket）。

在Spring Cloud Gateway 中，官方提供了RequestRateLimiterGatewayFilterFactory 过滤器工厂，通过结合 Redis和 Lua 脚本，实现了基于令牌桶的限流方式。

1. 添加依赖
```xml
<!-- spring data redis reactive 依赖 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
```

2. 限流规则，根据URI限流
```yaml
spring:
  redis:
    host: localhost
    port: 6379
    password: 
  cloud:
    gateway:
      routes:
        # 系统模块
        - id: pmhub-system
          uri: lb://pmhub-system
          predicates:
            - Path=/system/**
          filters:
            - StripPrefix=1
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 1 # 令牌桶每秒填充速率
                redis-rate-limiter.burstCapacity: 2 # 令牌桶总容量
                key-resolver: "#{@pathKeyResolver}" # 使用 SpEL 表达式按名称引用 bean
```

::: tip
StripPrefix=1配置，表示网关转发到业务模块时候会自动截取前缀。这个配置需要视情况而定
:::

3. 编写URI限流规则配置类
```java
/**
 * 限流规则配置类
 */
@Configuration
public class KeyResolverConfiguration
{
    @Bean
    public KeyResolver pathKeyResolver()
    {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }
}
```

4. 测试服务验证限流

启动网关服务 PmHubGatewayApplication.java 和系统服务PmHubSystemApplication.java。

因为网关服务有认证鉴权，可以在 gateway 配置中设置一下白名单/system/**在进行测试，多次请求会发现返回 HTTP ERROR 429，同时在 redis 中会操作两个 key，表示限流成功。

```yaml
request_rate_limiter.{xxx}.timestamp
request_rate_limiter.{xxx}.tokens
```

也可以根据其他限流规则来配置，如参数限流，IP限流，配置如下：

```java
//参数限流
@Bean
public KeyResolver parameterKeyResolver()
{
    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
}

// ip限流

@Bean
public KeyResolver ipKeyResolver()
{
	return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
}

```

## 黑名单配置

顾名思义，黑名单就是那些被禁止访问的URL。为了实现这一功能，可以创建自定义过滤器 BlackListUrlFilter，并配置黑名单地址列表blacklistUrl。当然，如果有其他需求，还可以实现自定义规则的过滤器来满足特定的过滤要求。

pmhub 中黑名单过滤器配置：

```java
/**
 * 黑名单过滤器
 *
 * @author canghe
 */
@Component
public class BlackListUrlFilter extends AbstractGatewayFilterFactory<BlackListUrlFilter.Config>
{
    @Override
    public GatewayFilter apply(Config config)
    {
        return (exchange, chain) -> {

            String url = exchange.getRequest().getURI().getPath();
            if (config.matchBlacklist(url))
            {
                return ServletUtils.webFluxResponseWriter(exchange.getResponse(), "请求地址不允许访问");
            }

            return chain.filter(exchange);
        };
    }

    public BlackListUrlFilter()
    {
        super(Config.class);
    }

    public static class Config
    {
        private List<String> blacklistUrl;

        private List<Pattern> blacklistUrlPattern = new ArrayList<>();

        public boolean matchBlacklist(String url)
        {
            return !blacklistUrlPattern.isEmpty() && blacklistUrlPattern.stream().anyMatch(p -> p.matcher(url).find());
        }

        public List<String> getBlacklistUrl()
        {
            return blacklistUrl;
        }

        public void setBlacklistUrl(List<String> blacklistUrl)
        {
            this.blacklistUrl = blacklistUrl;
            this.blacklistUrlPattern.clear();
            this.blacklistUrl.forEach(url -> {
                this.blacklistUrlPattern.add(Pattern.compile(url.replaceAll("\\*\\*", "(.*?)"), Pattern.CASE_INSENSITIVE));
            });
        }
    }

}
```

以后只要是看哪个 URL 不爽，就直接**拉进很名单**即可。

```yaml
spring:
  cloud:
    gateway:
      routes:
        # 系统模块
        - id: pmhub-system
          uri: lb://pmhub-system
          predicates:
            - Path=/system/**
          filters:
            - StripPrefix=0
            - name: BlackListUrlFilter
              args:
                blacklistUrl:
                - /user/list
```

## 白名单配置

顾名思义，就是允许访问的地址。且无需登录就能访问。比如登录、注册接口，以及其他的不需要网关做鉴权的接口，都可以放在白名单里面。爱他，就把她放进来吧＼（＾ ＾）／，在 ignore 中设置 whites，表示允许匿名访问。

在全局过滤器中添加以下逻辑即可。

```java
// 跳过不需要验证的路径
if (StringUtils.matches(url, ignoreWhite.getWhites())) {
    return chain.filter(exchange);
}
```

```yaml
# 不校验白名单
ignore:
  whites:
    - /auth/logout
    - /auth/login
```

以上是关于网关的过滤器以及常用功能的介绍，**结合实际项目使用**，理解这些概念和使用方法并不是什么难事，而且用会还可以写在简历上去和面试官吹逼，简直不要太爽，来个 offer 指日可待。


