> **作者：**苍何，前大厂高级 Java 工程师，阿里云专家博主，CSDN 2023 年 实力新星，土木转码，现任部门技术 leader，专注于互联网技术分享，职场经验分享。
> 🔥**热门文章推荐：**
> - （1）[对程序员来说，技术能力和业务逻辑哪个更重要？](https://canghe.blog.csdn.net/article/details/133632205?spm=1001.2014.3001.5502)
> - （2）[搭建GitHub免费个人网站（详细教程）](https://canghe.blog.csdn.net/article/details/95392429?spm=1001.2014.3001.5502)
> - （3）[itchat实现微信聊天机器人](https://canghe.blog.csdn.net/article/details/92232985?spm=1001.2014.3001.5502)
> - （4）[嗖嗖移动业务大厅（源码下载+注释全 值得收藏）](https://canghe.blog.csdn.net/article/details/83204418?spm=1001.2014.3001.5502)


![image.png](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704521740629-09595b0d-fc2f-466f-80ba-61e8ec3c6ebf.png#averageHue=%23161616&clientId=u1ad65207-1f2b-4&from=paste&height=451&id=u2c6a3d72&originHeight=902&originWidth=1600&originalType=binary&ratio=2&rotation=0&showTitle=false&size=490270&status=done&style=none&taskId=u97a63111-5192-42a5-9aa7-290bd2aee4a&title=&width=800)

大家好，我是苍何。早在一周前 OpenAI 宣布本周推出 GPTs 商店，这对早期采用者来说是一个巨大的机会。

![官方邮件](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704784211493-4a862b5b-ab73-48c8-bcbb-db4f463c3eb4.png#averageHue=%23e6e6e6&clientId=ubc238620-fe61-4&from=paste&height=646&id=u5dbddef2&originHeight=1292&originWidth=1578&originalType=binary&ratio=2&rotation=0&showTitle=true&size=457501&status=done&style=none&taskId=uc00654ae-b960-4309-8ac9-70d917b6180&title=%E5%AE%98%E6%96%B9%E9%82%AE%E4%BB%B6&width=789 "官方邮件")

而在昨天，就**正式的推出 GPTs stor**e，一起看看。

![GPTs store](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704962034988-dd9d89e0-bd06-424a-ae3d-00e59c15d77d.png#averageHue=%2389cbaf&clientId=u1b1b8033-a72a-4&from=paste&height=608&id=u2011f441&originHeight=1216&originWidth=2330&originalType=binary&ratio=2&rotation=0&showTitle=true&size=352899&status=done&style=none&taskId=ufb305833-99a6-454c-8b2d-88555f4ac9f&title=GPTs%20store&width=1165 "GPTs store")
这是官方提供的应用商店，优质的 GPTs 都会被官方收录，可以查找分类或直接搜索。

甚至我们可以看到 GPTs 受欢迎趋势。

![GPTs Trending](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704962175515-dc67e914-f861-4b59-89df-1eba60f3df57.png#averageHue=%232a2c35&clientId=u1b1b8033-a72a-4&from=paste&height=543&id=u6fc8bb2f&originHeight=1086&originWidth=1800&originalType=binary&ratio=2&rotation=0&showTitle=true&size=354953&status=done&style=none&taskId=u89b9ab53-8611-48be-a6c4-932830bd273&title=GPTs%20Trending&width=900 "GPTs Trending")

早在去年开放 GPTs 以来，就受到了很多人的关注，那么什么是 GPTs 以及 GPTs 商店呢？

:::info
GPTs 是 OpenAI 推出的 ChatGPT 的定制版，无需开发代码，应用自定义提示词和自定义知识库可以达到比通用 ChatGPT 更垂直的 GPT。相当于是一个预制了任务和指令的一个对话窗口。不需要再提供背景信息，就可以直接执行我们的任务。

有了 GPTs，现在OpenAI 即将推出的 GPTs 应用商店其实就是一个官方的承载各种 GPTs 的应用市场， 和 APPStore 类似，在上面发布的应用照样可以收获分成，能为开发者和创作者带来收益。
:::

下面将是制作教程，教你如何现在就制作一个 GPT，以便能在下一波浪潮中获利。

# 一、前置条件

在创建 GPT 之前，需要有 ChatGPT 账号及**开通了 plus**，如下图代表已经升级完成

![ChatGPT-plus升级成功](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704784559739-85d32961-2292-42ae-92fe-b8d59dd3c8e5.png#averageHue=%2332333d&clientId=ubc238620-fe61-4&from=paste&height=557&id=u5a0d7b23&originHeight=1114&originWidth=2096&originalType=binary&ratio=2&rotation=0&showTitle=true&size=238569&status=done&style=none&taskId=u9a693014-0a0d-4815-b115-feac1a80ee5&title=ChatGPT-plus%E5%8D%87%E7%BA%A7%E6%88%90%E5%8A%9F&width=1048 "ChatGPT-plus升级成功")

之后需要构思好创建的 GPT 的任务描述，也就是需要他完成什么特定的工作。
# 二、创建 GPTs
打开 Explore 进入 GPTs 页面：

![打开 Explore：](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704522243687-7b569b5e-8cb3-404a-b430-d03e87f42291.png#averageHue=%2341697c&clientId=u1ad65207-1f2b-4&from=paste&height=573&id=uc3668735&originHeight=1146&originWidth=2280&originalType=binary&ratio=2&rotation=0&showTitle=true&size=242063&status=done&style=none&taskId=u4dfa3308-4e0d-4cf9-a9bd-4f65262aac0&title=%E6%89%93%E5%BC%80%20Explore%EF%BC%9A&width=1140 "打开 Explore：")
或者也可以点击左下角个人头像-My GPTs

![个人头像-My GPTs](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704784683417-5c4d159b-1a13-4ea4-bf32-6e2398fbae01.png#averageHue=%23191b1d&clientId=ubc238620-fe61-4&from=paste&height=621&id=u88edf6b9&originHeight=1242&originWidth=2210&originalType=binary&ratio=2&rotation=0&showTitle=true&size=265794&status=done&style=none&taskId=u0a405d5c-bb75-400b-b20c-a64f32d3059&title=%E4%B8%AA%E4%BA%BA%E5%A4%B4%E5%83%8F-My%20GPTs&width=1105 "个人头像-My GPTs")

点击创建：

![点击创建](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704522308364-3633f290-0581-40c3-bcc1-c4167ea0a9ea.png#averageHue=%23427083&clientId=u1ad65207-1f2b-4&from=paste&height=407&id=ucbd0e44e&originHeight=814&originWidth=2304&originalType=binary&ratio=2&rotation=0&showTitle=true&size=231117&status=done&style=none&taskId=ub840cce4-3411-4215-b2d4-f833382d049&title=%E7%82%B9%E5%87%BB%E5%88%9B%E5%BB%BA&width=1152 "点击创建")

进入新建界面，接下来就可以通过聊天的方式来构建 GPTs。在右侧将会实时预览构建的效果。

![新建界面](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704522536441-7987a8fd-6e9a-4fbf-ae00-c8928044536d.png#averageHue=%23292a34&clientId=u1ad65207-1f2b-4&from=paste&height=600&id=u2b90f4b2&originHeight=1200&originWidth=2346&originalType=binary&ratio=2&rotation=0&showTitle=true&size=192265&status=done&style=none&taskId=u3e5fa22a-b248-42db-ab5e-61c6ef9a54a&title=%E6%96%B0%E5%BB%BA%E7%95%8C%E9%9D%A2&width=1173 "新建界面")

# 三、聊天构建
想要做什么直接通过对话的方式在聊天界面进行调整，**但需要不断的对话微调可能才能达到你想要的效果**。不用用很复杂的指令，现在仅需要聊天告诉 ChatGPT 你想要什么功能，它就能帮你定制。

并且能自动完成所有的设置，包括这个 GPTs 的名字，任务说明、开场白，甚至是头像都自动帮你打包好。

这里我以短视频文案模仿专家为需求，给他发送这样一段对话：
:::info
创建一个短视频文案模仿专家，执行短视频文案分析和模仿任务。当我上传参考文案时，请从以下方面分析文字特点，然后根据分析的结果，模仿这些风格，进行文案的重新优化。
1、语言风格：
每个人在写作时都有自己的语言风格，包括用词习惯、句式结构和语法特点，分析是否使用正式语言，以及如何使用修辞手法如比喻、排比等
2、语调和声音：
是诙谐幽默、严肃正式、轻松随性还是激昂激励
3、内容结构：
观察其文案的组织方式。他们如何引入话题、发展论点以及结尾。是否喜欢使用列表、小标题或段落来分隔内容。
4、主题和观点：
理解他们倾向于探讨的主题和他们在这些主题上的立场。
5、目标受众：
了解他们的文案是为哪一类读者而写，这影响了文案的许多方面，包括用词和表达的复杂程度
6、个人习惯：
一些作者可能有特别的个人标志，比如特定的开头和结尾，或者一些他们经常回归的引用和主题。
:::

![聊天构建GPTs](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704548438913-27ad777b-2f65-4261-bf28-55ab3b5a41f3.png#averageHue=%232c2d37&clientId=u1ad65207-1f2b-4&from=paste&height=577&id=ue3bd4bf5&originHeight=1154&originWidth=2266&originalType=binary&ratio=2&rotation=0&showTitle=true&size=301056&status=done&style=none&taskId=udfa02501-3596-4232-9611-79ddd9d8265&title=%E8%81%8A%E5%A4%A9%E6%9E%84%E5%BB%BAGPTs&width=1133 "聊天构建GPTs")

可以看到 ChatGPT 为我们这个 GPTs 起了一个名字叫「Script Mimic Expert」，确定使用该名字后，它自动帮我们用 DALLE-3 生成了头像和一些基础 配置。

![自动生成名字和头像](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704787010860-6c49b0f8-f846-4dd4-a547-0d768981ad36.png#averageHue=%232a2b35&clientId=ubc238620-fe61-4&from=paste&height=546&id=ue49ee040&originHeight=1092&originWidth=2284&originalType=binary&ratio=2&rotation=0&showTitle=true&size=494474&status=done&style=none&taskId=ub775fc5b-4a6c-499e-a102-d55a9e5e031&title=%E8%87%AA%E5%8A%A8%E7%94%9F%E6%88%90%E5%90%8D%E5%AD%97%E5%92%8C%E5%A4%B4%E5%83%8F&width=1142 "自动生成名字和头像")

还自动生成了初始对话和描述。这一步比较简单，就是用大白话一步步生成。接下来需要对 GPTs 进行配置。

# 四、配置 GPTs
点击 Configue，按照配置一步步进行修改。
## 4.1、修改名字、简介和指令

![基础配置](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704788518590-f1612be1-3f01-4fb6-a304-fb833bd91ad0.png#averageHue=%232a2b35&clientId=ubc238620-fe61-4&from=paste&height=596&id=u209dcd75&originHeight=1192&originWidth=2150&originalType=binary&ratio=2&rotation=0&showTitle=true&size=418226&status=done&style=none&taskId=u518a01ec-c3b2-44fa-85f2-13bab1bd3d0&title=%E5%9F%BA%E7%A1%80%E9%85%8D%E7%BD%AE&width=1075 "基础配置")

**其中 Instructions 指令是非常重要的**，后续假如有一些其他想法或者一些补充说明，都可以在这里进行补充，比如说我希望他后续的过程中都用中文对话，那我就在这个说明里面加上这个补充「Finally, please talk to me in Chinese.」：

![指令补充说明](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704788758748-ff3b1976-58af-413e-9f9e-c459bd17f5d4.png#averageHue=%232b2c37&clientId=ubc238620-fe61-4&from=paste&height=389&id=u06901c1d&originHeight=778&originWidth=1996&originalType=binary&ratio=2&rotation=0&showTitle=true&size=210235&status=done&style=none&taskId=u2058464c-5126-4052-9dae-b1458e688f5&title=%E6%8C%87%E4%BB%A4%E8%A1%A5%E5%85%85%E8%AF%B4%E6%98%8E&width=998 "指令补充说明")

## 4.2、初始对话
接下来是初始对话 Conversation starters，这里我把初始对话改成中文的，方便后续使用。

![初始对话](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704788840477-e60f65a6-5301-4e35-a5dc-1da297e9675b.png#averageHue=%232a2b35&clientId=ubc238620-fe61-4&from=paste&height=442&id=u1c80faeb&originHeight=884&originWidth=1888&originalType=binary&ratio=2&rotation=0&showTitle=true&size=226695&status=done&style=none&taskId=u02f007a3-2560-4078-823e-a3b4b39cec7&title=%E5%88%9D%E5%A7%8B%E5%AF%B9%E8%AF%9D&width=944 "初始对话")

修改为中文：

![初始对话修改成中文](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704788938112-c55996e2-c904-485d-8e91-23758bd44656.png#averageHue=%232a2b36&clientId=ubc238620-fe61-4&from=paste&height=496&id=u2f8146cb&originHeight=992&originWidth=2264&originalType=binary&ratio=2&rotation=0&showTitle=true&size=285028&status=done&style=none&taskId=u82f7e069-e59c-4188-99ff-b79822a7a27&title=%E5%88%9D%E5%A7%8B%E5%AF%B9%E8%AF%9D%E4%BF%AE%E6%94%B9%E6%88%90%E4%B8%AD%E6%96%87&width=1132 "初始对话修改成中文")

## 4.3、知识库
知识库 Knowledge 允许我们添加外部的知识库，在你对话的时候，ChatGPT 会自动调用你引入的知识库的内容，来回答你的问题。

:::warning
tips：
这里上传的文档和在对话框中上传的文件并不冲突，这里只是为 ChatGPT 提供背景知识，在对话过程中上传的文件可以用作其他用途，如分析文案风格，所以值得注意的是，如果是用来分析的文件，就不要在 Knowledge 这里上传了，而是去对话入口上传
:::

![知识库上传背景信息](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704789517370-d425cd34-fd5e-484a-af41-8cacb96e25dc.png#averageHue=%232a2c36&clientId=ubc238620-fe61-4&from=paste&height=467&id=u31bc3cf7&originHeight=934&originWidth=2314&originalType=binary&ratio=2&rotation=0&showTitle=true&size=266945&status=done&style=none&taskId=u8a0ef596-bd6c-49cf-90c8-eea8f615339&title=%E7%9F%A5%E8%AF%86%E5%BA%93%E4%B8%8A%E4%BC%A0%E8%83%8C%E6%99%AF%E4%BF%A1%E6%81%AF&width=1157 "知识库上传背景信息")

这里的文件上传有一些限制：

- 一次可以上传多个文件，但最多上传文件不能超过 20 个，但可能会随时间变化而更改
- 上传 zip 等压缩包，或者 Excel 等格式文件，只能用 Code Interpreter 来处理它。无法使用 Retrieval （文件检索）功能

![只能用 Code Interprete](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704940012398-f506b6ee-0bb0-463b-a0e0-ca94929ba566.png#averageHue=%231d976f&clientId=u1b1b8033-a72a-4&from=paste&height=150&id=ufa3caa04&originHeight=300&originWidth=1092&originalType=binary&ratio=2&rotation=0&showTitle=true&size=47618&status=done&style=none&taskId=u3c83b330-2db7-47f2-be49-d748f5b14f0&title=%E5%8F%AA%E8%83%BD%E7%94%A8%20Code%20Interprete&width=546 "只能用 Code Interprete")

- 关于文件类型目前试了，支持 txt、json、pdf、xlsx、doc、zip、md

## 4.4、内部能力
内部能力 Capabilities 这部分可以勾选 ChatGPT 默认支持的能力，只要自己选择是否勾选，一般默认是全部勾选。

![Capabilities内部能力](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704940754097-eff4caa3-52f0-448b-a3cd-910c383aabc6.png#averageHue=%230e0f11&clientId=u1b1b8033-a72a-4&from=paste&height=193&id=ubb7d1b14&originHeight=386&originWidth=1828&originalType=binary&ratio=2&rotation=0&showTitle=true&size=105007&status=done&style=none&taskId=u2598d43a-fe04-4205-a8a5-407436f835d&title=Capabilities%E5%86%85%E9%83%A8%E8%83%BD%E5%8A%9B&width=914 "Capabilities内部能力")
> 与 GPT-4 通用大模型相比，GPT Builder 允许我们根据应用的特定需求来选择需要的能力。这样可以更精确地控制应用的功能，而不是使用一个具有所有这些功能的通用模型（以前是GPT4通用大模型，后面的更新把All Tools集成到GPT4里了。

## 4.5、Actions 能力扩展
Action 功能的存在允许我们自定义扩展更加强大的功能，**比如可以检索信息和特定的 URL 请求，甚至可以调用第三方 API 接口**，这个功能还是很牛 x 的，想想，我们甚至可以利用 GOTs 做更多的事情，比如控制第三方应用， 给人发邮件，发短信，进行应用之间的 workflow 工作流流转。

这里先简单介绍下如何使用，关于更详细的应用场景，之后我会再单独出文章详细介绍。可以说用好了 Actions 才是真正建好了 GPTs。

> 关于如何使用 Action，官方也给了详细文档，英文好的可以看看：[https://platform.openai.com/docs/actions](https://platform.openai.com/docs/actions)


![官方对GPTs的Action教程](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704941583993-2f4b05bf-3e32-44ce-abb4-fbc6a8e7406d.png#averageHue=%23fefbfa&clientId=u1b1b8033-a72a-4&from=paste&height=494&id=u21a5d26e&originHeight=988&originWidth=2308&originalType=binary&ratio=2&rotation=0&showTitle=true&size=270355&status=done&style=none&taskId=u8561b562-3bec-43b2-b613-136c286f650&title=%E5%AE%98%E6%96%B9%E5%AF%B9GPTs%E7%9A%84Action%E6%95%99%E7%A8%8B&width=1154 "官方对GPTs的Action教程")

也可以在创建页面点击 Get help from ActionsGPT 会跳转到官方的 GPTs-Actions 小助手 ActionGPT，发现这其实也是个 GPTs，可以理解为官方的智能问答助手了。（[https://chat.openai.com/g/g-TYEliDU6A-actionsgpt](https://chat.openai.com/g/g-TYEliDU6A-actionsgpt)）

当然他最强大的作用是可以把 API 文档转换为 openai 规范文档，方便后续使用。

![ActionsGPT](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704954385419-a5c02247-eede-46ac-9ede-56e2a00d4f86.png#averageHue=%232a2b35&clientId=u1b1b8033-a72a-4&from=paste&height=577&id=ud0b2d2bb&originHeight=1154&originWidth=1766&originalType=binary&ratio=2&rotation=0&showTitle=true&size=215868&status=done&style=none&taskId=ue053d556-c072-4e30-a7a8-d68872d2867&title=ActionsGPT&width=883 "ActionsGPT")

点击新建 Action：

![新建 Action](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704942870908-c49d7e0d-f357-4f47-9d41-4b1a11dfd228.png#averageHue=%23282933&clientId=u1b1b8033-a72a-4&from=paste&height=438&id=ucc701091&originHeight=876&originWidth=1638&originalType=binary&ratio=2&rotation=0&showTitle=true&size=139277&status=done&style=none&taskId=ua7591e31-cb37-4bf6-983f-e5e41a7bda3&title=%E6%96%B0%E5%BB%BA%20Action&width=819 "新建 Action")

### 4.5.1、Authentication 鉴权
这是调用外部 API 接口需要设置的鉴权 一共有 3 种鉴权方式;
![3 种鉴权方式](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704942969707-a4e47733-735a-46e4-a20b-61f8fd75f94a.png#averageHue=%232f303a&clientId=u1b1b8033-a72a-4&from=paste&height=387&id=u121f5e66&originHeight=774&originWidth=1642&originalType=binary&ratio=2&rotation=0&showTitle=true&size=160648&status=done&style=none&taskId=u4240a3ee-d1f3-46ed-89d3-5dfe2c50e98&title=3%20%E7%A7%8D%E9%89%B4%E6%9D%83%E6%96%B9%E5%BC%8F&width=821 "3 种鉴权方式")

![APIkey](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704943264459-445932ae-59d8-4471-9b12-deffc0d9ac90.png#averageHue=%23282930&clientId=u1b1b8033-a72a-4&from=paste&height=394&id=u66d92946&originHeight=788&originWidth=1546&originalType=binary&ratio=2&rotation=0&showTitle=true&size=163267&status=done&style=none&taskId=u3c4e334a-6821-4b78-b483-cc5baaaa6bd&title=APIkey&width=773 "APIkey")

![OAuth](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704943293230-dabbc06d-d014-45c8-9587-2fa21d65b952.png#averageHue=%232a2b33&clientId=u1b1b8033-a72a-4&from=paste&height=592&id=uffcf9319&originHeight=1184&originWidth=1546&originalType=binary&ratio=2&rotation=0&showTitle=true&size=220637&status=done&style=none&taskId=u16306747-6d1e-4182-b85b-144134affc7&title=OAuth&width=773 "OAuth")
具体的使用，我在下篇文章会讲解。
### 4.5.2、Schema
这里设置外部的 API， 可以通过导入或者直接复制的方式。格式支持 JSON 和 YAML。

![Schema](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704943462947-88b05717-6d26-43aa-9144-29a833a89bba.png#averageHue=%232b2c36&clientId=u1b1b8033-a72a-4&from=paste&height=380&id=u647fe3cb&originHeight=760&originWidth=1534&originalType=binary&ratio=2&rotation=0&showTitle=true&size=165358&status=done&style=none&taskId=ub00b792b-3d3d-44af-b12b-5369d5cb100&title=Schema&width=767 "Schema")
这里的 Schema 仅支持 openai 格式的接口规范， 有几种方式可以将普通的接口文档转换成 openai 格式的接口规范。

- **方式一：直接在 **[**ActionGPT**](https://chat.openai.com/g/g-TYEliDU6A-actionsgpt)** 提问的方式转换**

无论是普通的 HTML 描述还是 cURL，**直接让他就可以帮我们转换**，这里我以高德「IP 定位」接口文档转换为例：

这是 [原始接口文档：](https://lbs.amap.com/api/webservice/guide/api/ipconfig)

![高德ip定位原始接口文档](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704959488760-b0eb00d0-c6f4-48e7-a9ac-fa0afa67b7d7.png#averageHue=%23f6f6f6&clientId=u1b1b8033-a72a-4&from=paste&height=589&id=u376aced7&originHeight=1178&originWidth=1942&originalType=binary&ratio=2&rotation=0&showTitle=true&size=271630&status=done&style=none&taskId=u3bc9eb01-c34e-4e31-a834-e9827c1b358&title=%E9%AB%98%E5%BE%B7ip%E5%AE%9A%E4%BD%8D%E5%8E%9F%E5%A7%8B%E6%8E%A5%E5%8F%A3%E6%96%87%E6%A1%A3&width=971 "高德ip定位原始接口文档")

直接丢给 [**ActionGPT**](https://chat.openai.com/g/g-TYEliDU6A-actionsgpt)：

![gpt转换接口文档](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704959570832-ca146a9f-9c33-4348-aeae-f39a21542937.png#averageHue=%23116447&clientId=u1b1b8033-a72a-4&from=paste&height=563&id=u2d4249cb&originHeight=1126&originWidth=1700&originalType=binary&ratio=2&rotation=0&showTitle=true&size=240735&status=done&style=none&taskId=ubd3b9848-8e89-46f6-b820-91af1e4a121&title=gpt%E8%BD%AC%E6%8D%A2%E6%8E%A5%E5%8F%A3%E6%96%87%E6%A1%A3&width=850 "gpt转换接口文档")

转换效果：
```yaml
openapi: 3.0.0
info:
  title: AMap IP Location API
  description: AMap Web Service for locating IP addresses.
  version: 1.0.0
servers:
  - url: https://restapi.amap.com/v3
    description: AMap IP Location Service API Server
paths:
  /ip:
    get:
      operationId: locateIP
      summary: Locate IP Address
      description: Returns the geographical location information of the given IP address.
      parameters:
        - name: key
          in: query
          description: User's unique key for accessing the service.
          required: true
          schema:
            type: string
        - name: ip
          in: query
          description: The IP address to locate. Optional, if not provided, the service will use the requester's IP.
          required: false
          schema:
            type: string
        - name: sig
          in: query
          description: Digital signature for paid users who opt for signature authentication.
          required: false
          schema:
            type: string
        - name: output
          in: query
          description: Response format, either JSON or XML.
          required: false
          schema:
            type: string
            enum:
              - json
              - xml
      responses:
        '200':
          description: Successful response
          content:
            application/json:
              schema:
                type: object
                properties:
                  status:
                    type: string
                  info:
                    type: string
                  infocode:
                    type: string
                  province:
                    type: string
                  city:
                    type: string
                  adcode:
                    type: string
                  rectangle:
                    type: string
            application/xml:
              schema:
                type: string  # XML schema definition needed here

```

- **方式二：在 apifox 中直接导出**

如果是用的 apifox 管理接口文档也可直接导出：

![apifox导出](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704959718890-48ac7bce-b9f7-4050-82eb-ff4900743ce7.png#averageHue=%236ab769&clientId=u1b1b8033-a72a-4&from=paste&height=642&id=u29ffebea&originHeight=1284&originWidth=1754&originalType=binary&ratio=2&rotation=0&showTitle=true&size=315527&status=done&style=none&taskId=u48e3be9f-88cf-4da6-8966-7267fc9547f&title=apifox%E5%AF%BC%E5%87%BA&width=877 "apifox导出")


![选择版本](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704959745669-d247c2e8-d71d-4ade-86b0-b0dd358a7808.png#averageHue=%23f4f4f4&clientId=u1b1b8033-a72a-4&from=paste&height=508&id=udf22628a&originHeight=1016&originWidth=1778&originalType=binary&ratio=2&rotation=0&showTitle=true&size=156798&status=done&style=none&taskId=u23ee0bb7-870e-4ae3-922e-5cf8def9747&title=%E9%80%89%E6%8B%A9%E7%89%88%E6%9C%AC&width=889 "选择版本")

选择最新格式导出，还可预览后直接复制文本到 Schema。

![页面打开直接复制](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704959814537-85253b13-7ca4-41b3-82dd-00392b2ecb00.png#averageHue=%23f1f1f1&clientId=u1b1b8033-a72a-4&from=paste&height=545&id=u2463f38f&originHeight=1090&originWidth=1800&originalType=binary&ratio=2&rotation=0&showTitle=true&size=179995&status=done&style=none&taskId=ua7edd4d6-28d8-49af-86b0-d6c2a2e1fad&title=%E9%A1%B5%E9%9D%A2%E6%89%93%E5%BC%80%E7%9B%B4%E6%8E%A5%E5%A4%8D%E5%88%B6&width=900 "页面打开直接复制")

不过目前我试了下，apifox 的导出，有些接口会存在失败的情况。综合对比两种方式各自有用途，如果是公共的如像高德这种提供的页面的接口描述文档，建议直接丢给 ActionGPT 帮忙做转换，如果是已存在的在 apifox 中的历史接口，可以采用方式二更方便。

将复制好的 Schema 直接放在框中，还可以测试接口是否能用：

点 test：

![点 tes](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704960253005-11ec513c-1fda-4b16-876a-22a9ea4a2251.png#averageHue=%235d738a&clientId=u1b1b8033-a72a-4&from=paste&height=625&id=u5359dacc&originHeight=1250&originWidth=2254&originalType=binary&ratio=2&rotation=0&showTitle=true&size=349945&status=done&style=none&taskId=u879d5493-1b77-47a3-bf3f-0298e50cded&title=%E7%82%B9%20tes&width=1127 "点 tes")

说没有 key，我接着给他输入一个注册好的 key：

![输入key后](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704960531835-5846b960-9f44-494f-80b5-e78d690b3cda.png#averageHue=%232c2d37&clientId=u1b1b8033-a72a-4&from=paste&height=533&id=udb775acf&originHeight=1066&originWidth=2148&originalType=binary&ratio=2&rotation=0&showTitle=true&size=289311&status=done&style=none&taskId=ue4618b96-4483-4e9f-8c56-f077a775ce6&title=%E8%BE%93%E5%85%A5key%E5%90%8E&width=1074 "输入key后")

可以看到输入 key 后，他给我们正确的返回了数据;

![正确返回数字](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704960568474-eab61413-f61f-417e-a5aa-033adbf0645f.png#averageHue=%232c2d37&clientId=u1b1b8033-a72a-4&from=paste&height=461&id=u69cd54fe&originHeight=922&originWidth=2110&originalType=binary&ratio=2&rotation=0&showTitle=true&size=274101&status=done&style=none&taskId=u466d3d7e-0d78-4ce1-9ff5-47cc8eec1f5&title=%E6%AD%A3%E7%A1%AE%E8%BF%94%E5%9B%9E%E6%95%B0%E5%AD%97&width=1055 "正确返回数字")

### 4.5.3、Privacy policy

输入隐私政策

![输入隐私政策](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704960894074-adb89236-63e8-4355-ae55-04023a2e042d.png#averageHue=%232b2c36&clientId=u1b1b8033-a72a-4&from=paste&height=345&id=u4b66ba56&originHeight=690&originWidth=1858&originalType=binary&ratio=2&rotation=0&showTitle=true&size=155111&status=done&style=none&taskId=u91ccfc3e-05e0-436f-8b5b-da270db9d02&title=%E8%BE%93%E5%85%A5%E9%9A%90%E7%A7%81%E6%94%BF%E7%AD%96&width=929 "输入隐私政策")

# 五、发布 GPT

经过上面一番操作，GPTs 总算是建立好了，三种发布方式：

![image.png](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704960971276-c8d8cd83-10b6-4b34-a4cb-b3cb3d801c53.png#averageHue=%23252931&clientId=u1b1b8033-a72a-4&from=paste&height=320&id=ua8f10c50&originHeight=640&originWidth=2292&originalType=binary&ratio=2&rotation=0&showTitle=false&size=209639&status=done&style=none&taskId=u4b4e3494-1af4-4a80-b334-9c7793663f0&title=&width=1146)

如果选择的是 Everyone，则需要 Privacy policy。

来吧，直接上，看效果：

![我的第一个GPTs](https://cdn.nlark.com/yuque/0/2024/png/29495295/1704961755005-58eb69e5-9046-4708-9565-2327984fbdf3.png#averageHue=%232e2f39&clientId=u1b1b8033-a72a-4&from=paste&height=547&id=u08266d11&originHeight=1094&originWidth=1716&originalType=binary&ratio=2&rotation=0&showTitle=true&size=314990&status=done&style=none&taskId=u6e77fb1b-a8c5-4151-9d07-a7081ce7038&title=%E6%88%91%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AAGPTs&width=858 "我的第一个GPTs")

全文完，如果对编程或 AI 感兴趣，欢迎关注苍何，一起交流。


![苍何个人介绍.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1696255868903-dd1f63ce-d8a4-40d3-bb7a-2879c1d331a1.png#averageHue=%23a6bbbd&clientId=ub7322f39-98cc-4&from=ui&id=u9a4a5bf7&originHeight=500&originWidth=900&originalType=binary&ratio=2&rotation=0&showTitle=false&size=445580&status=done&style=none&taskId=uf832e99f-fd09-436e-b42e-f632bd37bb7&title=)

> 创作不易，如果本文对你有帮助，欢迎点赞、收藏加关注，你的支持和鼓励，是我创作的最大动力。
> ![文章最下方关注图片.gif](https://cdn.nlark.com/yuque/0/2023/gif/29495295/1695892885868-ec6c1fdb-e043-40e0-8b57-079a6050abd6.gif#averageHue=%23e6e1e0&clientId=u5e901b1f-45e4-4&from=ui&id=u8ab09020&originHeight=200&originWidth=640&originalType=binary&ratio=2&rotation=0&showTitle=false&size=137992&status=done&style=none&taskId=uc7faaa53-86b7-474a-974a-d55411ced53&title=)


