> **作者：**苍何，前大厂高级 Java 工程师，阿里云专家博主，CSDN 2023 年 实力新星，土木转码，现任部门技术 leader，专注于互联网技术分享，职场经验分享。
> 🔥**热门文章推荐：**
> - （1）[对程序员来说，技术能力和业务逻辑哪个更重要？](https://canghe.blog.csdn.net/article/details/133632205?spm=1001.2014.3001.5502)
> - （2）[搭建GitHub免费个人网站（详细教程）](https://canghe.blog.csdn.net/article/details/95392429?spm=1001.2014.3001.5502)
> - （3）[itchat实现微信聊天机器人](https://canghe.blog.csdn.net/article/details/92232985?spm=1001.2014.3001.5502)
> - （4）[嗖嗖移动业务大厅（源码下载+注释全 值得收藏）](https://canghe.blog.csdn.net/article/details/83204418?spm=1001.2014.3001.5502)


![2023年12月01日-idea效率插件.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701437740873-60aa0f66-05e3-44de-b8d3-9738b7cd1732.png#averageHue=%23383c37&clientId=u023eae7e-ab0d-4&from=ui&id=u4fe169b3&originHeight=1024&originWidth=1792&originalType=binary&ratio=2&rotation=0&showTitle=false&size=2930498&status=done&style=none&taskId=u86e2149d-b905-4999-9240-08d595c6971&title=)

大家好，我是苍何。工欲善其事必先利其器，在实际开发中，谁能很好的使用工具，谁将会更加高效。今天分享苍何在实际开发中觉得很不错的 idea 插件，用的好直接让效率起飞。

废话不多说，直接上干货。
# 一、JRebel

JRebel 是由一爱沙尼亚公司 ZeroTurnaround 开发的 Java 应用热部署插件。也是目前市场面最好的热部署插件之一。
> 热部署即是在开发中修改代码无需重启应用，能实时应用代码变更。


![JRebel](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701427400694-1ecee253-2e85-4a2d-996c-bcbe66528723.png#averageHue=%23404445&clientId=uf48c1b27-c01d-4&from=paste&height=824&id=VawrA&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=579998&status=done&style=none&taskId=u24310416-fb61-4412-9910-49215d65804&title=JRebel&width=1094 "JRebel")

JRebel 是付费产品，网上有不少 pojie 的教程，也可以直接某宝上花几块钱购买正版授权。我就是采用的第二种方式（主要省的麻烦，哈哈）。

安装激活后，需要对其进行配置。

1、配置离线模式和自动加载时间

![配置离线模式和自动加载时间](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701432754200-dbb1d476-28e0-439c-94b7-8a5269ceff12.png#averageHue=%23484c4c&clientId=u5cf1873e-207a-4&from=paste&height=824&id=u782cd9ce&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=568554&status=done&style=none&taskId=u212e819b-a4d7-437e-a9d3-7313b93830f&title=%E9%85%8D%E7%BD%AE%E7%A6%BB%E7%BA%BF%E6%A8%A1%E5%BC%8F%E5%92%8C%E8%87%AA%E5%8A%A8%E5%8A%A0%E8%BD%BD%E6%97%B6%E9%97%B4&width=1094 "配置离线模式和自动加载时间")

2、设置项目自动构建

![设置项目自动构建](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701432878088-d7bdb34a-275c-4cbc-b787-f9900bbf9262.png#averageHue=%23313335&clientId=u5cf1873e-207a-4&from=drop&id=u688348e2&originHeight=1120&originWidth=1500&originalType=binary&ratio=2&rotation=0&showTitle=true&size=526429&status=done&style=none&taskId=u709a99fa-e244-40b8-aee0-ca151d44403&title=%E8%AE%BE%E7%BD%AE%E9%A1%B9%E7%9B%AE%E8%87%AA%E5%8A%A8%E6%9E%84%E5%BB%BA "设置项目自动构建")

3、设置自动编译

![设置自动编译](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701432989562-e9d9b539-93fe-48aa-ad7a-47a08d7cafb2.png#averageHue=%232a2c2e&clientId=ue5f51057-d5eb-4&from=drop&id=ua305093e&originHeight=1136&originWidth=1336&originalType=binary&ratio=2&rotation=0&showTitle=true&size=111688&status=done&style=none&taskId=ub1a4aa6d-d3e4-46bd-8adb-d9abfff2106&title=%E8%AE%BE%E7%BD%AE%E8%87%AA%E5%8A%A8%E7%BC%96%E8%AF%91 "设置自动编译")

4、启动项目的时候 run 或 dubug 就可以开启热部署了。
![开启热部署](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701433115488-e594ab19-ba44-417c-aa2f-4e940d1f35c6.png#averageHue=%23497236&clientId=ue5f51057-d5eb-4&from=drop&id=u5ec93960&originHeight=368&originWidth=1312&originalType=binary&ratio=2&rotation=0&showTitle=true&size=93985&status=done&style=none&taskId=u166803e5-673e-49c7-b5be-f42042844a1&title=%E5%BC%80%E5%90%AF%E7%83%AD%E9%83%A8%E7%BD%B2 "开启热部署")
当在 service 层写业务代码时，无需再次重启应用，直接就可以加载最新的配置，效率杠杠的。

# 二、GitHub Copilot

可以说是目前最好用的的编程助手之一了，同时 openai 大模型的支持使得该 AI 助手更能理解我们实际 code 的诉求。

![GitHub Copilot](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701433424306-62992709-b0dd-4f87-9e7d-f37ec918f367.png#averageHue=%233f4547&clientId=ud308e3c3-c007-4&from=paste&height=824&id=ue3f96446&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=706650&status=done&style=none&taskId=u4a772bd3-2c5a-4f4d-bfb0-6b4cf6c1451&title=GitHub%20Copilot&width=1094 "GitHub Copilot")

插件市场搜索后安装，需要登录自己的 GitHub 账号，可以免费试用一个月，之后是 10 刀一个月。如果你有学生身份认证或者 GitHub 有开源项目，可以申请免费使用。也可以某宝直接买个破解版的使用。

一些使用小技巧：
1、通过注释自动生成代码

![通过注释自动生成代码](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701434028082-197131f6-2d21-42e7-9761-d0e610fd14de.png#averageHue=%232c2c2c&clientId=u5223e79d-0c6e-4&from=drop&id=u1c98f18f&originHeight=1038&originWidth=1500&originalType=binary&ratio=2&rotation=0&showTitle=true&size=252904&status=done&style=none&taskId=uf53f4c1d-c37e-4f99-81d8-d48ede1c5ce&title=%E9%80%9A%E8%BF%87%E6%B3%A8%E9%87%8A%E8%87%AA%E5%8A%A8%E7%94%9F%E6%88%90%E4%BB%A3%E7%A0%81 "通过注释自动生成代码")

![通过注释自动生成代码](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701434070612-dc2c06e4-217a-40a6-b9c6-632afd9b5866.png#averageHue=%232c2c2c&clientId=u5223e79d-0c6e-4&from=drop&id=u3d2fc3e4&originHeight=934&originWidth=1294&originalType=binary&ratio=2&rotation=0&showTitle=true&size=133440&status=done&style=none&taskId=u26522a90-68bb-4371-bd29-ea3b2855048&title=%E9%80%9A%E8%BF%87%E6%B3%A8%E9%87%8A%E8%87%AA%E5%8A%A8%E7%94%9F%E6%88%90%E4%BB%A3%E7%A0%81 "通过注释自动生成代码")

2、自动生成测试代码

![自动生成测试代码](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701433855239-9c4b08d2-a091-40ba-a9fa-43ef83331549.png#averageHue=%23395c31&clientId=ud308e3c3-c007-4&from=paste&height=488&id=u2b30aea8&originHeight=976&originWidth=1176&originalType=binary&ratio=2&rotation=0&showTitle=true&size=322176&status=done&style=none&taskId=ua8450bda-35bf-4f94-8574-ba9afe7a23d&title=%E8%87%AA%E5%8A%A8%E7%94%9F%E6%88%90%E6%B5%8B%E8%AF%95%E4%BB%A3%E7%A0%81&width=588 "自动生成测试代码")

3、直接生成 SQL

![直接生成 SQL](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701434256938-ba2fd495-3a85-44eb-a0ea-ec6a838c50b7.png#averageHue=%2340613b&clientId=u75e94733-5e48-4&from=paste&height=470&id=ufcf415d7&originHeight=940&originWidth=1374&originalType=binary&ratio=2&rotation=0&showTitle=true&size=331940&status=done&style=none&taskId=uf73b5597-671a-49fe-83ac-245832cccb3&title=%E7%9B%B4%E6%8E%A5%E7%94%9F%E6%88%90%20SQL&width=687 "直接生成 SQL")

4、和 AI 对话（内侧中）
这个功能目前在 idea 中还属于内侧阶段，在 vscode 中使用体验，还是很爽的，直接通过快捷键唤起助手，随时随地提问，并能很好的帮助你 code。

5、编写必要的注释
不写注释的程序猿不是好程序猿，但写注释通常是很花费时间的，大部分情况我们都想偷懒，以前偷懒不写，经常在 CR 的时候被说，现在有了 Copilot，直接让他帮我们写注释吧。

6、可以询问业务逻辑
对于历史项目想快速的了解直接丢给他好了，绝对比我们一行一行的看代码快上数倍。

# 三、Free MyBatis Tool 

如果你的项目是 MyBatis 项目，强烈建议安装这个插件，他能让你迅速的直接跳转到 xml 中的具体 sql，而不需要到 mapper。且在 service 中直接可以跳转到 xml 中的 sql 实现。

点击绿色箭头就可以无缝跳转，别提多方便。

![Free MyBatis Tool](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701434796492-2c50f3dc-e419-47cf-bc07-7889c994ab23.png#averageHue=%233e4244&clientId=u0343e0fd-99fa-4&from=paste&height=824&id=ua3dc0680&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=600709&status=done&style=none&taskId=uea6e7d35-9a57-4ca7-b782-e63d92dae3a&title=Free%20MyBatis%20Tool&width=1094 "Free MyBatis Tool")

![MyBatis便捷跳转](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701434874312-34e13fbc-9412-4102-bdb3-d467c1ccf2e0.png#averageHue=%23201f1f&clientId=u0343e0fd-99fa-4&from=paste&height=412&id=u0b93340c&originHeight=824&originWidth=1656&originalType=binary&ratio=2&rotation=0&showTitle=true&size=112310&status=done&style=none&taskId=ud7876456-e430-4279-bcf2-69c551c6bd9&title=MyBatis%E4%BE%BF%E6%8D%B7%E8%B7%B3%E8%BD%AC&width=828 "MyBatis便捷跳转")

# 四、Apifox Helper

我不允许还有人不知道 Apifox 这款良心国产软件，完全平替 postman 。我们团队所有项目的接口都在上面进行方便的管理，同时他也支持集成测试和 mock 数据，在前后端、测试、产品间把 AIP 接口玩的 6 的飞起。

![Apifox](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701435150783-230b3c18-e0d3-4973-beca-8f84fa6107ac.png#averageHue=%23ededec&clientId=u6c0821da-2992-4&from=paste&height=414&id=ud60fbf9f&originHeight=828&originWidth=2122&originalType=binary&ratio=2&rotation=0&showTitle=true&size=198637&status=done&style=none&taskId=u66d05090-68bf-43b3-a215-3aa471f0569&title=Apifox&width=1061 "Apifox")


管理接口有了他，更方便。那么对开发来说，写好接口后，就想一键同步接口到 Apifox 就好了，官方给我们提供了 idea 插件，支持一键同步。

![Apifox Helper](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701435299516-7328d61c-a940-4e9b-9877-ae38397491d8.png#averageHue=%23434a4b&clientId=u6c0821da-2992-4&from=paste&height=824&id=u7d81a928&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=779904&status=done&style=none&taskId=u26910320-7c1c-4a5f-87a0-6dd613189bf&title=Apifox%20Helper&width=1094 "Apifox Helper")

按照官方文档进行简单配置后，在项目中，直接右键就可以将接口同步到Apifox，省去了很多导入导出的工作。

# 五、Apipost-Helper-2.0

这是可以直接在 idea 中调用请求的插件，虽然有不少插件也能做到，比如 restful，但我比较喜欢他的界面以及丝滑的操作。

![Apipost-Helper-2.0](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701435506581-710e59fb-489c-4a2a-8ab0-d85a8dd4aa7d.png#averageHue=%23454b4d&clientId=u703ee04f-3ebf-4&from=paste&height=824&id=u3258d6b2&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=811896&status=done&style=none&taskId=uc5e94429-408c-41b2-98e4-f47e7be90d9&title=Apipost-Helper-2.0&width=1094 "Apipost-Helper-2.0")

![Apipost发送请求](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701435581651-5994162c-0c73-41aa-8f94-43d1ce7098a3.png#averageHue=%233b5235&clientId=u41c9022a-2e4e-4&from=drop&id=ud05dd36c&originHeight=988&originWidth=1500&originalType=binary&ratio=2&rotation=0&showTitle=true&size=383688&status=done&style=none&taskId=u133b32a8-4666-4966-b367-e609dfc8008&title=Apipost%E5%8F%91%E9%80%81%E8%AF%B7%E6%B1%82 "Apipost发送请求")

可以配置默认请求头和前缀。

![配置默认请求头和前缀](https://cdn.nlark.com/yuque/0/2023/png/29495295/1701436588514-a943cdb9-dbaa-4a4f-a16f-a903c1bdffb7.png#averageHue=%2340623a&clientId=u41c9022a-2e4e-4&from=drop&id=u7d103342&originHeight=1025&originWidth=1500&originalType=binary&ratio=2&rotation=0&showTitle=true&size=282967&status=done&style=none&taskId=u9d2abdca-9586-4362-aee7-92b2b6ed534&title=%E9%85%8D%E7%BD%AE%E9%BB%98%E8%AE%A4%E8%AF%B7%E6%B1%82%E5%A4%B4%E5%92%8C%E5%89%8D%E7%BC%80 "配置默认请求头和前缀")

不用在 idea 和 apifox 中来回切换，大大提高了效率，也能我们更专心 code。

以上是 5 个插件的内容，朋友们，你们都用哪些提效的插件啊？

![苍何个人介绍.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1696255868903-dd1f63ce-d8a4-40d3-bb7a-2879c1d331a1.png#averageHue=%23a6bbbd&clientId=ub7322f39-98cc-4&from=ui&id=u9a4a5bf7&originHeight=500&originWidth=900&originalType=binary&ratio=2&rotation=0&showTitle=false&size=445580&status=done&style=none&taskId=uf832e99f-fd09-436e-b42e-f632bd37bb7&title=)

> 创作不易，如果本文对你有帮助，欢迎点赞、收藏加关注，你的支持和鼓励，是我创作的最大动力。
> ![文章最下方关注图片.gif](https://cdn.nlark.com/yuque/0/2023/gif/29495295/1695892885868-ec6c1fdb-e043-40e0-8b57-079a6050abd6.gif#averageHue=%23e6e1e0&clientId=u5e901b1f-45e4-4&from=ui&id=u8ab09020&originHeight=200&originWidth=640&originalType=binary&ratio=2&rotation=0&showTitle=false&size=137992&status=done&style=none&taskId=uc7faaa53-86b7-474a-974a-d55411ced53&title=)


