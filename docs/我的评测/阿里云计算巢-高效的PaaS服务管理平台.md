> **作者：**苍何，前大厂高级 Java 工程师，阿里云专家博主，CSDN 2023 年 实力新星，土木转码，现任部门技术 leader，专注于互联网技术分享，职场经验分享。
> 🔥**热门文章推荐：**
> - （1）[对程序员来说，技术能力和业务逻辑哪个更重要？](https://canghe.blog.csdn.net/article/details/133632205?spm=1001.2014.3001.5502)
> - （2）[搭建GitHub免费个人网站（详细教程）](https://canghe.blog.csdn.net/article/details/95392429?spm=1001.2014.3001.5502)
> - （3）[itchat实现微信聊天机器人](https://canghe.blog.csdn.net/article/details/92232985?spm=1001.2014.3001.5502)
> - （4）[嗖嗖移动业务大厅（源码下载+注释全 值得收藏）](https://canghe.blog.csdn.net/article/details/83204418?spm=1001.2014.3001.5502)


![image.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702893347205-c43d1ec4-9757-4afc-834c-ae18ddf00452.png#averageHue=%23e5ded8&clientId=uc5725e9a-d02c-4&from=paste&height=584&id=u10ed84d1&originHeight=1168&originWidth=2202&originalType=binary&ratio=2&rotation=0&showTitle=false&size=1219869&status=done&style=none&taskId=u9aa8ae2f-2b4d-4964-8ebc-d1270b8a205&title=&width=1101)

大家好，我是苍何。我们开发好应用服务后，最麻烦的往往不是开发的过程，而是涉及之后的一系列服务交付、部署、运维，依赖人工进行的交付、部署和运维难免会存在效率问题。通常运维需要管理一堆配置文件，虽说我们可以利用 CI/CD 做到自动构建部署，但服务上线后，服务的交付和部署流程经常是成本很高，

最近体验了下阿里云的计算巢产品，解决了我在服务交付、部署、运维以及服务全生命周期管理等的痛点问题，特此给大家做个分享。

# 一、什么是计算巢
先引用官方一段介绍：
> 计算巢服务是一个开放给服务商（包括：企业应用服务商、IT集成服务商、交付服务商和管理服务提供商等）和用户的服务管理PaaS平台。计算巢服务为服务商和用户提供了高效、便捷、安全的服务使用体验，服务商能更好地在阿里云上部署、交付和管理服务，用户能集中管理在阿里云上订阅的各类服务商提供的服务。


说白了，就是阿里云针对服务商和用户推出的全生命周期服务管理平台，是一站式的部署和交付平台。拿我们来说，我们可以算是SaaS 服务提供商，很多客户都有私有化部署的需求，而不是直接将数据放在我们的平台上，每一次新的产品更新，都需要对不同的私有化部署客户进行新一轮交付和部署，对实施和现场运维人员挑战比较大，往往有些更新迭代光配置部署就需要一天时间，而且还无法让客户满意，也无法直观地体现服务交付及部署状态，比较依赖人工。我们在推产品的时候，经常需要对客户做资源清单输出，经常达不到我们想要的效果。

而有了计算巢，就能解决我们以上的痛点问题。

![计算巢服务](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702889516221-65258dba-ccc6-464f-bbbb-6ee9922b7e1a.png#averageHue=%23e8e2da&clientId=uc5725e9a-d02c-4&from=paste&height=534&id=u2e6f9fa9&originHeight=1068&originWidth=2210&originalType=binary&ratio=2&rotation=0&showTitle=true&size=947686&status=done&style=none&taskId=u5372c083-8b9f-4bd1-bbdc-3fd6f6f2c35&title=%E8%AE%A1%E7%AE%97%E5%B7%A2%E6%9C%8D%E5%8A%A1&width=1105 "计算巢服务")

计算巢主要针对服务商和客户群体，服务商在平台上进行服务的构建、交付、运维、运营等一系列服务管理。而作为用户，就可以直接订阅服务商发布的服务了。

![使用场景](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702890657349-1f71a7c9-b7e3-4795-b53e-46bba6f5bbb0.png#averageHue=%23fcf8f6&clientId=uc5725e9a-d02c-4&from=drop&id=uad84b104&originHeight=291&originWidth=491&originalType=binary&ratio=2&rotation=0&showTitle=true&size=16389&status=done&style=none&taskId=ub7b514e6-2f58-400b-94d0-09fd44adef7&title=%E4%BD%BF%E7%94%A8%E5%9C%BA%E6%99%AF "使用场景")
# 二、服务概述
确定部署架构和配置服务内容后就可以将服务发布到计算巢，用户可以对发布的服务进行订阅，特别是对于私有化部署场景，服务实例是用户的资源，其服务是存在用户的云资源上。

而创建服务的方式也比较简单：

![创建服务](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702891327104-d5d656f2-331e-4a4f-8f43-f64506712d77.png#averageHue=%23f2f2f2&clientId=uc5725e9a-d02c-4&from=paste&height=554&id=uc7263bf5&originHeight=1108&originWidth=2220&originalType=binary&ratio=2&rotation=0&showTitle=true&size=261587&status=done&style=none&taskId=u393b0ec3-0664-4b95-94dc-241667f2c78&title=%E5%88%9B%E5%BB%BA%E6%9C%8D%E5%8A%A1&width=1110 "创建服务")

可以选择需要配置的模板，

![配置模板](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702891413914-ba172ca3-8ae3-4dac-a284-661cc80f639f.png#averageHue=%23f3f1f1&clientId=uc5725e9a-d02c-4&from=paste&height=543&id=u1ccf12c5&originHeight=1086&originWidth=2290&originalType=binary&ratio=2&rotation=0&showTitle=true&size=237888&status=done&style=none&taskId=u60ca9812-1d72-4ff6-a569-94f145868e3&title=%E9%85%8D%E7%BD%AE%E6%A8%A1%E6%9D%BF&width=1145 "配置模板")

这里我以 **SpringBoot单机版-镜像部署**为例，我们可看到其实是把我们常用的配置做成模板化了。

![SpringBoot单机版-镜像部署](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702891484475-bc475b9e-79c0-44ce-b3ba-2b4777769f06.png#averageHue=%23dadad9&clientId=uc5725e9a-d02c-4&from=paste&height=609&id=ub4feac33&originHeight=1218&originWidth=2000&originalType=binary&ratio=2&rotation=0&showTitle=true&size=319092&status=done&style=none&taskId=u91c8e087-694f-4467-8e4a-c6d5f724c81&title=SpringBoot%E5%8D%95%E6%9C%BA%E7%89%88-%E9%95%9C%E5%83%8F%E9%83%A8%E7%BD%B2&width=1000 "SpringBoot单机版-镜像部署")

# 三、用户界面和易用性
在管理后台的欢迎页有产品使用文档及快速上手手册，而且形象的表现出了我能通过这个产品获得什么，就用户体验来说，这点非常友好，想必很多产品，直接在底部 tab 地方甩一个链接友好多了。

![欢迎页](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702891656496-b4b7a068-f216-4ad6-9dca-c0d57c6c6ee1.png#averageHue=%23e9e8e7&clientId=uc5725e9a-d02c-4&from=paste&height=563&id=u295a99d6&originHeight=1126&originWidth=2346&originalType=binary&ratio=2&rotation=0&showTitle=true&size=362414&status=done&style=none&taskId=u3dd19acd-47cf-4e71-bc36-ff9f47eb5f3&title=%E6%AC%A2%E8%BF%8E%E9%A1%B5&width=1173 "欢迎页")

产品的模块划分也不会很杂很多，比如有些产品喜欢多层级嵌套，让人找的眼花撩轮，因为其功能针对的用户很清晰，所以在对于不同的用户都能迅速的找到自己想要的功能，在易用性上还是比较简单的，所见即所得，让功能触手可及。

对开发用户来说，我比较喜欢这个「服务市场」的功能，甚至可以直接在上面订阅 Stable Diffusion ，极大的提高了自己部署的效率，爽！！！

![服务市场](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702892013358-4ea881cc-4d5c-43f9-a928-b8a2e59497e3.png#averageHue=%23f2f1f0&clientId=uc5725e9a-d02c-4&from=paste&height=608&id=u9e719283&originHeight=1216&originWidth=2316&originalType=binary&ratio=2&rotation=0&showTitle=true&size=364032&status=done&style=none&taskId=ua4440e2d-35e1-4fda-a2c2-aa344190c53&title=%E6%9C%8D%E5%8A%A1%E5%B8%82%E5%9C%BA&width=1158 "服务市场")

# 四、性能和可靠性
性能这块，因为使用时间还有限，服务量也一定，等过一段时间再来评价，不过从目前的使用上来看，因为本身依托的是阿里云，基本没什么卡点。可靠性还是有保障的。

# 五、成本效益分析
大家最关心的是这玩意这么好，一定很贵吧？使用过平台的都知道，平台费加各种流量资源加起来可是一笔数量不小的数字，那我们来看看计算巢是怎么收费的吧？

先贴一张官方的图：

![image.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702892367497-c4be8faf-e899-4960-9f99-5e21d07500e1.png#averageHue=%23ecebeb&clientId=uc5725e9a-d02c-4&from=paste&height=579&id=uca445977&originHeight=1158&originWidth=1730&originalType=binary&ratio=2&rotation=0&showTitle=false&size=290927&status=done&style=none&taskId=u21ad321c-0c74-4a59-9919-e63764f88e2&title=&width=865)

我们可以看到主要分 3 大块，其中平台的使用是免费的（这点大赞好吧，之前使用某某平台，光平台使用费一年就收不少钱，太坑了）。

接下来是云资源这部分费用，因为计算巢只是个服务管理平台，实际服务还是运行在阿里云 ECS 上面，所以实际费用还是资源原先的费用。这里需要特别注意;
> 计算资源为基础配置费用，按量付费的ECS实例，即使未运行业务，也会按照计费周期持续计费。除非开启节省停机模式。


其实计算巢这个产品唯一独立收费的地方是服务费。如果服务商没有在云市场发布该服务的话就不用收费，但服务商在云市场，将该计算巢服务发布成云市场商品计费方式就是云市场统一的收费标准。

总之来说，如果不发布到云市场，就可以在上面任意「玩」了。

# 六、客户支持和社区
计算巢官方给做的服务支持这块还是很到位的，把一些常见的客户问题都总结在了一起，FAQ 做的也比较全，我能在上面找到不少刚开始使用时候的一些问题。

![客户支持](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702892970682-697f6e82-9add-4515-9493-16dcfdecdc7e.png#averageHue=%23f5f5f5&clientId=uc5725e9a-d02c-4&from=paste&height=569&id=uda9e23d7&originHeight=1138&originWidth=2312&originalType=binary&ratio=2&rotation=0&showTitle=true&size=301937&status=done&style=none&taskId=u15e6da2b-423e-4fce-a842-06fb141c9a7&title=%E5%AE%A2%E6%88%B7%E6%94%AF%E6%8C%81&width=1156 "客户支持")

社区这块的话，我觉得并没有做的很好，我相信很多人压根都没经过这款产品，即使他如此好用也确实能帮我们解决不少问题。特别是在程序员社区，不愠不火，希望官网能加强这方面的建设，把社区建立起来，打造好的生态。

![社区](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702893091162-10c4fbc2-51c9-4e28-8b16-a410ba353e80.png#averageHue=%23e3e3e3&clientId=uc5725e9a-d02c-4&from=paste&height=517&id=u52b514fe&originHeight=1034&originWidth=2320&originalType=binary&ratio=2&rotation=0&showTitle=true&size=952117&status=done&style=none&taskId=u580246b6-ceed-4f5d-b191-4baa45ca085&title=%E7%A4%BE%E5%8C%BA&width=1160 "社区")

# 七、总结
计算巢服务优点显而易见，在服务交付、服务运维和服务管理上更加智能高效，也更安全可靠，无论是对服务商还是用户都能省去很多边际成本。我觉得最大的缺点目前就是社区还需要再做优化，好的产品应该让更多人知道。



![苍何个人介绍.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1696255868903-dd1f63ce-d8a4-40d3-bb7a-2879c1d331a1.png#averageHue=%23a6bbbd&clientId=ub7322f39-98cc-4&from=ui&id=OdQ7j&originHeight=500&originWidth=900&originalType=binary&ratio=2&rotation=0&showTitle=false&size=445580&status=done&style=none&taskId=uf832e99f-fd09-436e-b42e-f632bd37bb7&title=)

> 创作不易，如果本文对你有帮助，欢迎点赞、收藏加关注，你的支持和鼓励，是我创作的最大动力。
> ![文章最下方关注图片.gif](https://cdn.nlark.com/yuque/0/2023/gif/29495295/1695892885868-ec6c1fdb-e043-40e0-8b57-079a6050abd6.gif#averageHue=%23e6e1e0&clientId=u5e901b1f-45e4-4&from=ui&id=MOI2Q&originHeight=200&originWidth=640&originalType=binary&ratio=2&rotation=0&showTitle=false&size=137992&status=done&style=none&taskId=uc7faaa53-86b7-474a-974a-d55411ced53&title=)


