> **作者：**苍何，前大厂高级 Java 工程师，阿里云专家博主，CSDN 2023 年 实力新星，土木转码，现任部门技术 leader，专注于互联网技术分享，职场经验分享。
> 🔥**热门文章推荐：**
> - （1）[对程序员来说，技术能力和业务逻辑哪个更重要？](https://canghe.blog.csdn.net/article/details/133632205?spm=1001.2014.3001.5502)
> - （2）[搭建GitHub免费个人网站（详细教程）](https://canghe.blog.csdn.net/article/details/95392429?spm=1001.2014.3001.5502)
> - （3）[itchat实现微信聊天机器人](https://canghe.blog.csdn.net/article/details/92232985?spm=1001.2014.3001.5502)
> - （4）[嗖嗖移动业务大厅（源码下载+注释全 值得收藏）](https://canghe.blog.csdn.net/article/details/83204418?spm=1001.2014.3001.5502)


![2023年12月01日-idea效率插件.png](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701437740873-60aa0f66-05e3-44de-b8d3-9738b7cd1732.png)

大家好，我是苍何。工欲善其事必先利其器，在实际开发中，谁能很好的使用工具，谁将会更加高效。今天分享苍何在实际开发中觉得很不错的 idea 插件，用的好直接让效率起飞。

废话不多说，直接上干货。
# 一、JRebel

JRebel 是由一爱沙尼亚公司 ZeroTurnaround 开发的 Java 应用热部署插件。也是目前市场面最好的热部署插件之一。
> 热部署即是在开发中修改代码无需重启应用，能实时应用代码变更。


![JRebel](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701427400694-1ecee253-2e85-4a2d-996c-bcbe66528723.png "JRebel")

JRebel 是付费产品，网上有不少 pojie 的教程，也可以直接某宝上花几块钱购买正版授权。我就是采用的第二种方式（主要省的麻烦，哈哈）。

安装激活后，需要对其进行配置。

1、配置离线模式和自动加载时间

![配置离线模式和自动加载时间](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701432754200-dbb1d476-28e0-439c-94b7-8a5269ceff12.png "配置离线模式和自动加载时间")

2、设置项目自动构建

![设置项目自动构建](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701432878088-d7bdb34a-275c-4cbc-b787-f9900bbf9262.png "设置项目自动构建")

3、设置自动编译

![设置自动编译](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701432989562-e9d9b539-93fe-48aa-ad7a-47a08d7cafb2.png "设置自动编译")

4、启动项目的时候 run 或 dubug 就可以开启热部署了。
![开启热部署](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701433115488-e594ab19-ba44-417c-aa2f-4e940d1f35c6.png "开启热部署")
当在 service 层写业务代码时，无需再次重启应用，直接就可以加载最新的配置，效率杠杠的。

# 二、GitHub Copilot

可以说是目前最好用的的编程助手之一了，同时 openai 大模型的支持使得该 AI 助手更能理解我们实际 code 的诉求。

![GitHub Copilot](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701433424306-62992709-b0dd-4f87-9e7d-f37ec918f367.png "GitHub Copilot")

插件市场搜索后安装，需要登录自己的 GitHub 账号，可以免费试用一个月，之后是 10 刀一个月。如果你有学生身份认证或者 GitHub 有开源项目，可以申请免费使用。也可以某宝直接买个破解版的使用。

一些使用小技巧：
1、通过注释自动生成代码

![通过注释自动生成代码](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701434028082-197131f6-2d21-42e7-9761-d0e610fd14de.png "通过注释自动生成代码")

![通过注释自动生成代码](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701434070612-dc2c06e4-217a-40a6-b9c6-632afd9b5866.png "通过注释自动生成代码")

2、自动生成测试代码

![自动生成测试代码](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701433855239-9c4b08d2-a091-40ba-a9fa-43ef83331549.png "自动生成测试代码")

3、直接生成 SQL

![直接生成 SQL](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701434256938-ba2fd495-3a85-44eb-a0ea-ec6a838c50b7.png "直接生成 SQL")

4、和 AI 对话（内侧中）
这个功能目前在 idea 中还属于内侧阶段，在 vscode 中使用体验，还是很爽的，直接通过快捷键唤起助手，随时随地提问，并能很好的帮助你 code。

5、编写必要的注释
不写注释的程序猿不是好程序猿，但写注释通常是很花费时间的，大部分情况我们都想偷懒，以前偷懒不写，经常在 CR 的时候被说，现在有了 Copilot，直接让他帮我们写注释吧。

6、可以询问业务逻辑
对于历史项目想快速的了解直接丢给他好了，绝对比我们一行一行的看代码快上数倍。

# 三、Free MyBatis Tool 

如果你的项目是 MyBatis 项目，强烈建议安装这个插件，他能让你迅速的直接跳转到 xml 中的具体 sql，而不需要到 mapper。且在 service 中直接可以跳转到 xml 中的 sql 实现。

点击绿色箭头就可以无缝跳转，别提多方便。

![Free MyBatis Tool](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701434796492-2c50f3dc-e419-47cf-bc07-7889c994ab23.png "Free MyBatis Tool")

![MyBatis便捷跳转](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701434874312-34e13fbc-9412-4102-bdb3-d467c1ccf2e0.png "MyBatis便捷跳转")

# 四、Apifox Helper

我不允许还有人不知道 Apifox 这款良心国产软件，完全平替 postman 。我们团队所有项目的接口都在上面进行方便的管理，同时他也支持集成测试和 mock 数据，在前后端、测试、产品间把 AIP 接口玩的 6 的飞起。

![Apifox](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701435150783-230b3c18-e0d3-4973-beca-8f84fa6107ac.png "Apifox")


管理接口有了他，更方便。那么对开发来说，写好接口后，就想一键同步接口到 Apifox 就好了，官方给我们提供了 idea 插件，支持一键同步。

![Apifox Helper](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701435299516-7328d61c-a940-4e9b-9877-ae38397491d8.png "Apifox Helper")

按照官方文档进行简单配置后，在项目中，直接右键就可以将接口同步到Apifox，省去了很多导入导出的工作。

# 五、Apipost-Helper-2.0

这是可以直接在 idea 中调用请求的插件，虽然有不少插件也能做到，比如 restful，但我比较喜欢他的界面以及丝滑的操作。

![Apipost-Helper-2.0](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701435506581-710e59fb-489c-4a2a-8ab0-d85a8dd4aa7d.png "Apipost-Helper-2.0")

![Apipost发送请求](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701435581651-5994162c-0c73-41aa-8f94-43d1ce7098a3.png "Apipost发送请求")

可以配置默认请求头和前缀。

![配置默认请求头和前缀](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1701436588514-a943cdb9-dbaa-4a4f-a16f-a903c1bdffb7.png "配置默认请求头和前缀")

不用在 idea 和 apifox 中来回切换，大大提高了效率，也能我们更专心 code。

以上是 5 个插件的内容，朋友们，你们都用哪些提效的插件啊？

![苍何个人介绍.png](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1696255868903-dd1f63ce-d8a4-40d3-bb7a-2879c1d331a1.png)

> 创作不易，如果本文对你有帮助，欢迎点赞、收藏加关注，你的支持和鼓励，是我创作的最大动力。
> ![文章最下方关注图片.gif](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1695892885868-ec6c1fdb-e043-40e0-8b57-079a6050abd6.gif)


