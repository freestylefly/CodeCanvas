> **作者：**苍何，前大厂高级 Java 工程师，阿里云专家博主，CSDN 2023 年 实力新星，土木转码，现任部门技术 leader，专注于互联网技术分享，职场经验分享。
> 🔥**热门文章推荐：**
> - （1）[对程序员来说，技术能力和业务逻辑哪个更重要？](https://canghe.blog.csdn.net/article/details/133632205?spm=1001.2014.3001.5502)
> - （2）[搭建GitHub免费个人网站（详细教程）](https://canghe.blog.csdn.net/article/details/95392429?spm=1001.2014.3001.5502)
> - （3）[itchat实现微信聊天机器人](https://canghe.blog.csdn.net/article/details/92232985?spm=1001.2014.3001.5502)
> - （4）[嗖嗖移动业务大厅（源码下载+注释全 值得收藏）](https://canghe.blog.csdn.net/article/details/83204418?spm=1001.2014.3001.5502)


![image.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702974923306-1c65d594-70c3-4b5b-b523-245357a3ac1c.png#averageHue=%23383e42&clientId=u8c64ea91-a253-4&from=paste&height=559&id=u0d6026be&originHeight=1118&originWidth=2112&originalType=binary&ratio=2&rotation=0&showTitle=false&size=492526&status=done&style=none&taskId=u569e0393-2414-4ecb-9fdc-7926e4359f2&title=&width=1056)

大家好，我是苍何。在 AI 时代，总是会迅速出现很多惊艳的产品工具，这些效率工具，在很大程度上推动了科技的进步。特别是在编程领域，各类工具更是层出不穷，从 GitHub Copilot 到 CodeGeeX，再到通义灵码，有很多工具在不断涌现。今天，我想和大家分享一款我最近发现的、非常出色的编程辅助工具 —— CodeFuse。

# 一、什么是 CodeFuse
CodeFuse 是和 GitHub Copilot 类似的编码助手，是蚂蚁集团基于自研的基础大模型进行微调的代码大模型。

CodeFuse 具备代码补全、添加注释、解释代码、生成单测，以及代码优化功能，以帮助开发者更快、更轻松地编写代码。

我们知道在 IntelliJ IDEA 中安装 GitHub Copilot 并不能召唤出 chat 功能，目前这个功能还处于测试阶段，但 CodeFuse 直接就可以召唤出 chat 功能，并能很好的解释代码。

# 二、CodeFuse 下载与安装
目前 CodeFuse 还处于内测阶段，苍何也拿到了内测资格，还没申请的可以申请一波：在[CodeFuse官网](https://codefuse.alipay.com/welcome/product)直接申请，填相关资料等待审核就好了，一般审核周期 1-3 天。

![申请内测](https://cdn.nlark.com/yuque/0/2023/jpeg/29495295/1702970122434-2169110b-8ad5-4d1e-be16-cc4dd8fff8dc.jpeg#averageHue=%23e5e7f3&clientId=u8c64ea91-a253-4&from=drop&id=ubc1fc9d9&originHeight=770&originWidth=1502&originalType=binary&ratio=2&rotation=0&showTitle=true&size=450988&status=done&style=none&taskId=u1ab6da5b-1bd0-4af2-9709-841f8fc5f76&title=%E7%94%B3%E8%AF%B7%E5%86%85%E6%B5%8B "申请内测")

申请好后，拿到内测资格就可以直接下载插件。
> 因为目前还处于内测阶段，所以还没上线插件市场，目前无法直接在插件应用市场直接搜索到。


![下载插件](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702970237526-24d4b67a-981d-41bc-bf2b-35c4b78cca9b.png#averageHue=%23edeef9&clientId=u8c64ea91-a253-4&from=paste&height=449&id=ub4ba134a&originHeight=898&originWidth=2260&originalType=binary&ratio=2&rotation=0&showTitle=true&size=816529&status=done&style=none&taskId=uf467494d-afbd-4c67-a465-6c4a6533536&title=%E4%B8%8B%E8%BD%BD%E6%8F%92%E4%BB%B6&width=1130 "下载插件")

我们以 IntelliJ IDEA 为例，点击下载插件进行下载

![下载idea插件](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702970298865-84df17cc-688d-4032-9fd3-be3250fa69a6.png#averageHue=%23e3f3da&clientId=u8c64ea91-a253-4&from=paste&height=520&id=uc036b9e8&originHeight=1040&originWidth=2298&originalType=binary&ratio=2&rotation=0&showTitle=true&size=475505&status=done&style=none&taskId=u4f18ac87-f610-4d60-807d-8379f924973&title=%E4%B8%8B%E8%BD%BDidea%E6%8F%92%E4%BB%B6&width=1149 "下载idea插件")

![本地存放](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702970357171-a2ce58e9-a6f9-4d25-8fd4-0fc54f5143a4.png#averageHue=%23b5b5b5&clientId=u8c64ea91-a253-4&from=paste&height=762&id=u3948b133&originHeight=1524&originWidth=1696&originalType=binary&ratio=2&rotation=0&showTitle=true&size=415896&status=done&style=none&taskId=ue520481c-6ee0-409b-9ad7-f80270e05b5&title=%E6%9C%AC%E5%9C%B0%E5%AD%98%E6%94%BE&width=848 "本地存放")
然后打开 idea，选择刚才下载的插件进行安装：

![idea插件安装](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702970483642-aea20a68-a290-461f-83fc-cecfc3bfb942.png#averageHue=%233e4245&clientId=u8c64ea91-a253-4&from=paste&height=710&id=uc762385e&originHeight=1420&originWidth=1916&originalType=binary&ratio=2&rotation=0&showTitle=true&size=415150&status=done&style=none&taskId=u5e6b1c8d-a66c-4c35-876f-ee42565251a&title=idea%E6%8F%92%E4%BB%B6%E5%AE%89%E8%A3%85&width=958 "idea插件安装")
安装完成重启 idea 即可：

![安装完成](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702970548148-5dce2c2c-79c2-484f-ad35-da08018be405.png#averageHue=%233d4a48&clientId=u8c64ea91-a253-4&from=paste&height=824&id=u7a4d923e&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=816905&status=done&style=none&taskId=u39040c99-8dae-49e4-9742-55dc585fb75&title=%E5%AE%89%E8%A3%85%E5%AE%8C%E6%88%90&width=1094 "安装完成")

可以看到我的 idea 已经安装了 GitHub Copilot、CodeGeeX、通义灵码，为了接下来和其他插件进行对比，在代码补全部分，单词仅开启一个插件，尽量保证实验客观真实。

安装好后，可以对默认是否进行代码补全进行设置：
![设置代码补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702971014142-39844e48-66b8-437a-aa75-aa4bd67f0e5b.png#averageHue=%23454a49&clientId=u8c64ea91-a253-4&from=paste&height=824&id=u53d22710&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=460100&status=done&style=none&taskId=u961081b8-4a71-4c5c-b565-e4658e3a5ac&title=%E8%AE%BE%E7%BD%AE%E4%BB%A3%E7%A0%81%E8%A1%A5%E5%85%A8&width=1094 "设置代码补全")

之后需要进行登录，点击侧边栏登录完成后可以设置快捷键等。

![登录完成](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702971227561-624dbd21-a300-4942-b935-fef920558b6b.png#averageHue=%23a4a6a5&clientId=u8c64ea91-a253-4&from=paste&height=644&id=uffe7cf2d&originHeight=1288&originWidth=1554&originalType=binary&ratio=2&rotation=0&showTitle=true&size=227638&status=done&style=none&taskId=ucd413a5a-7440-4ced-8ba6-9c91c6a0ed7&title=%E7%99%BB%E5%BD%95%E5%AE%8C%E6%88%90&width=777 "登录完成")

# 三、CodeFuse 功能及对比性评测
## 1、代码补全
和其他所有编码助手一样，代码补全是最基本的核心能力。为了保证实验的客观真实，我们采用单一补全法，我们先将其他插件的代码补全关闭。

关闭 GitHub Copilot 代码补全:
![关闭GitHub copilot代码补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702971557681-79040984-1bb9-4139-a7e7-50456c5e6ef5.png#averageHue=%234a4e4e&clientId=u8c64ea91-a253-4&from=paste&height=824&id=uaa320ca8&originHeight=1648&originWidth=2188&originalType=binary&ratio=2&rotation=0&showTitle=true&size=635002&status=done&style=none&taskId=ucfa88b8b-8a16-42a9-b081-d501a52dd3b&title=%E5%85%B3%E9%97%ADGitHub%20copilot%E4%BB%A3%E7%A0%81%E8%A1%A5%E5%85%A8&width=1094 "关闭GitHub copilot代码补全")

关闭通义灵码代码补全;
![关闭通义灵码代码补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702971589262-d6ec3693-d913-4e10-93cf-f0d1969c1286.png#averageHue=%2330211f&clientId=u8c64ea91-a253-4&from=paste&height=345&id=u1d1cc02b&originHeight=690&originWidth=1260&originalType=binary&ratio=2&rotation=0&showTitle=true&size=121702&status=done&style=none&taskId=u0161a296-6778-4939-8656-7b09910a3d9&title=%E5%85%B3%E9%97%AD%E9%80%9A%E4%B9%89%E7%81%B5%E7%A0%81%E4%BB%A3%E7%A0%81%E8%A1%A5%E5%85%A8&width=630 "关闭通义灵码代码补全")

关闭 CodeGeeX 代码补全：
![关闭CodeGeeX代码补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702971665730-53b97787-86b6-4432-ac77-4ed73f3b63bf.png#averageHue=%236d6c6b&clientId=u8c64ea91-a253-4&from=paste&height=163&id=u63834ed0&originHeight=326&originWidth=1234&originalType=binary&ratio=2&rotation=0&showTitle=true&size=70299&status=done&style=none&taskId=u0ed1c01a-eeec-43a7-9930-e7a4f78b030&title=%E5%85%B3%E9%97%ADCodeGeeX%E4%BB%A3%E7%A0%81%E8%A1%A5%E5%85%A8&width=617 "关闭CodeGeeX代码补全")

这个时候代码补全只有CodeFuse 启用，我们先建一个空类，什么都不写，直接按换行看看：

![空白类默认补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702971822898-374cdfd4-5854-445d-87e5-3ec27d379c0c.png#averageHue=%23925323&clientId=u8c64ea91-a253-4&from=paste&height=374&id=u5e47df9c&originHeight=748&originWidth=2158&originalType=binary&ratio=2&rotation=0&showTitle=true&size=158216&status=done&style=none&taskId=ud6f90a8f-7344-462c-a233-97675688173&title=%E7%A9%BA%E7%99%BD%E7%B1%BB%E9%BB%98%E8%AE%A4%E8%A1%A5%E5%85%A8&width=1079 "空白类默认补全")

我们可以看到在提示代码后有中文的快捷键友好提示：

![快捷键友好提示](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702971874458-4886a5ef-e18a-4f36-98ba-6cc59d405a51.png#averageHue=%23925323&clientId=u8c64ea91-a253-4&from=paste&height=374&id=uce68132f&originHeight=748&originWidth=2158&originalType=binary&ratio=2&rotation=0&showTitle=true&size=158216&status=done&style=none&taskId=ufdab963b-fb30-4a6e-8542-e775edfd8bd&title=%E5%BF%AB%E6%8D%B7%E9%94%AE%E5%8F%8B%E5%A5%BD%E6%8F%90%E7%A4%BA&width=1079 "快捷键友好提示")

按 Tab 键采用提示编码，CodeFuse 并没有直接把 main 方法补全完，而是只补全最核心的一行，缺少方法另外一个括号。相对 GitHub copilot 来说，我觉得这这更加符合程序员编码习惯以及符合 idea 的默认换行补全方式。在 idea 中，写完一个方法的左括号，按换行，直接就可以补全右括号，而我们确实只需要他生成单行即可。

![CodeFuse 单行补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702972094586-3d4c5737-cafb-46c0-9e2a-555c64cd2377.png#averageHue=%231e1e1e&clientId=u8c64ea91-a253-4&from=paste&height=250&id=u2b5d464a&originHeight=500&originWidth=1652&originalType=binary&ratio=2&rotation=0&showTitle=true&size=60226&status=done&style=none&taskId=u1fd0a8e7-9024-4ffa-a8c1-e4ff68da310&title=CodeFuse%20%E5%8D%95%E8%A1%8C%E8%A1%A5%E5%85%A8&width=826 "CodeFuse 单行补全")

![CodeFuse 单行补全提示](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702972512583-7cce2f4e-7142-4c07-acc8-2ad013560bed.png#averageHue=%231f1f1e&clientId=u8c64ea91-a253-4&from=paste&height=286&id=ub7580080&originHeight=572&originWidth=1678&originalType=binary&ratio=2&rotation=0&showTitle=true&size=79144&status=done&style=none&taskId=u4f66a296-dbec-473d-9e9e-8e96de36acb&title=CodeFuse%20%E5%8D%95%E8%A1%8C%E8%A1%A5%E5%85%A8%E6%8F%90%E7%A4%BA&width=839 "CodeFuse 单行补全提示")

这个时候，我们把 GitHub Copilot 代码补全打开，其他插件代码补全全部关闭。可以看到 GitHub Copilot 直接就提示一个完整的 main 方法，并输出了一段默认语句，个人觉得在有些场景下是一种累赘。CodeFuse 是在进行换行的时候提示下一句话，我觉得更友好一些。

![GitHub Copilot起始补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702972387958-a8c36fca-ecaa-4280-91fb-3597d7cabdb7.png#averageHue=%231f1f1e&clientId=u8c64ea91-a253-4&from=paste&height=248&id=u47ecd873&originHeight=496&originWidth=1602&originalType=binary&ratio=2&rotation=0&showTitle=true&size=64281&status=done&style=none&taskId=ua27019ae-96a2-469e-8fd6-faad297ce2c&title=GitHub%20Copilot%E8%B5%B7%E5%A7%8B%E8%A1%A5%E5%85%A8&width=801 "GitHub Copilot起始补全")

对于**单行的代码补全**模型速度上更快于GitHub Copilot，可能是GitHub Copilot 的远端模型依赖的大模型是 openai 的原因吧。

![单行代码补全](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702973125419-1715190a-462e-4acd-8e45-a189033861a4.png#averageHue=%231f1f1f&clientId=u8c64ea91-a253-4&from=paste&height=318&id=u5fe0a7a2&originHeight=636&originWidth=1600&originalType=binary&ratio=2&rotation=0&showTitle=true&size=102095&status=done&style=none&taskId=u0926eec6-ccfd-48ad-805e-08f62879f71&title=%E5%8D%95%E8%A1%8C%E4%BB%A3%E7%A0%81%E8%A1%A5%E5%85%A8&width=800 "单行代码补全")

对于**多行代码**，同样可进行补全，直接写一个注释，直接可以生成方法，在CodeFuse 中是完全区分单行代码补全和多行代码补全的。

![生成0-10 的随机数，要求不能是质数](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702973351907-4e1ccb38-35ed-4dc7-a387-a7501ebb3d4d.png#averageHue=%23212121&clientId=u8c64ea91-a253-4&from=paste&height=444&id=ue60a08ba&originHeight=888&originWidth=1682&originalType=binary&ratio=2&rotation=0&showTitle=true&size=142459&status=done&style=none&taskId=udb7e7fdd-e6fe-4dfc-afdb-b01e4feea4c&title=%E7%94%9F%E6%88%900-10%20%E7%9A%84%E9%9A%8F%E6%9C%BA%E6%95%B0%EF%BC%8C%E8%A6%81%E6%B1%82%E4%B8%8D%E8%83%BD%E6%98%AF%E8%B4%A8%E6%95%B0&width=841 "生成0-10 的随机数，要求不能是质数")

## 2、解释代码
![解释代码](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702973515085-9f2d54c0-7e0b-4f18-aaf6-16a93d5959ed.png#averageHue=%2344594d&clientId=u8c64ea91-a253-4&from=paste&height=672&id=u37293436&originHeight=1344&originWidth=1710&originalType=binary&ratio=2&rotation=0&showTitle=true&size=423089&status=done&style=none&taskId=uc3430cc9-b25d-4845-b628-e74f0460827&title=%E8%A7%A3%E9%87%8A%E4%BB%A3%E7%A0%81&width=855 "解释代码")
选中代码右键或者直接在侧边栏点击/explain 即可。因为目前GitHub Copilot 无法使用 chat 功能，所以这个侧边栏显示解释代码还是非常有用的。

![点击/explain解释代码](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702973581540-6ac15e7d-46d0-4267-b60f-58d0e5f3fbd5.png#averageHue=%23476b3e&clientId=u8c64ea91-a253-4&from=paste&height=581&id=ue23eee51&originHeight=1162&originWidth=1582&originalType=binary&ratio=2&rotation=0&showTitle=true&size=294517&status=done&style=none&taskId=u76f61f22-deb5-44fa-8040-c9efac96369&title=%E7%82%B9%E5%87%BB%2Fexplain%E8%A7%A3%E9%87%8A%E4%BB%A3%E7%A0%81&width=791 "点击/explain解释代码")

## 3、生成注释
生成注释同样是对需要注释的代码右键生成。但有时候不大灵敏，看了下官方说明看来是对方法函数的生成更完善。
> **说明**：目前模型的生成注释功能对整个函数级别的支持较为完善，因此推荐您优先针对函数级别生成注释。


![生成代码注释](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702973921849-1aff376b-3566-4cfa-a201-d52cd085a64a.png#averageHue=%231f1f1e&clientId=u8c64ea91-a253-4&from=paste&height=473&id=ud643f44f&originHeight=946&originWidth=1584&originalType=binary&ratio=2&rotation=0&showTitle=true&size=133337&status=done&style=none&taskId=ubc25d492-979a-460c-8db5-a55c92b8f91&title=%E7%94%9F%E6%88%90%E4%BB%A3%E7%A0%81%E6%B3%A8%E9%87%8A&width=792 "生成代码注释")

这里我建议产品可以学习一下通义灵码的交互，直接在方法上可以进行操作，右键成本还是高了一些。

![通义灵码生成注释方式](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702973987268-bb06c75e-f635-4c89-9fc0-1ee1ad685dfa.png#averageHue=%231f1f1f&clientId=u8c64ea91-a253-4&from=paste&height=425&id=u1f4bde5d&originHeight=850&originWidth=1604&originalType=binary&ratio=2&rotation=0&showTitle=true&size=155810&status=done&style=none&taskId=u4159f745-0f09-4378-bd5e-ded01c09690&title=%E9%80%9A%E4%B9%89%E7%81%B5%E7%A0%81%E7%94%9F%E6%88%90%E6%B3%A8%E9%87%8A%E6%96%B9%E5%BC%8F&width=802 "通义灵码生成注释方式")

## 4、生成单侧
同样对需要生成单侧的代码，右键「生成单侧」即可在右侧栏中看到CodeFuse 生成的单侧，直接在测试类中插入单侧代码即可，还是很方便的。

![CodeFuse生成单侧](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702974153559-087c9c75-4f84-43af-853a-5fb99022aa3d.png#averageHue=%2347653b&clientId=u8c64ea91-a253-4&from=paste&height=598&id=u1c47603d&originHeight=1196&originWidth=1654&originalType=binary&ratio=2&rotation=0&showTitle=true&size=294304&status=done&style=none&taskId=u8082e9a5-0666-4e84-848b-e7d9b9b71d0&title=CodeFuse%E7%94%9F%E6%88%90%E5%8D%95%E4%BE%A7&width=827 "CodeFuse生成单侧")

## 5、代码优化
右键需要优化的代码，可以看到CodeFuse 为我们生成的优化建议。
让他优化下这段代码：
```java
@Before
public void before() {
    //可以为null
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    v2 = OpenAiClient.builder()
    .apiKey("xxxxx")
    .connectTimeout(50)
    .writeTimeout(50)
    .readTimeout(50)
    .interceptor(Arrays.asList(httpLoggingInterceptor))
    .proxy(proxy)
    .apiHost("https://api.openai.com/")
    .build();
}
```
 
![CodeFuse生成优化建议](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702974302989-994b4ec3-de66-4c40-b380-bc657ab782e3.png#averageHue=%236e7375&clientId=u8c64ea91-a253-4&from=paste&height=599&id=ua819350e&originHeight=1198&originWidth=1656&originalType=binary&ratio=2&rotation=0&showTitle=true&size=419494&status=done&style=none&taskId=u4091afae-393f-4c8e-80b3-4559f07b38c&title=CodeFuse%E7%94%9F%E6%88%90%E4%BC%98%E5%8C%96%E5%BB%BA%E8%AE%AE&width=828 "CodeFuse生成优化建议")

可以选择按照优化建议直接生成代码：

![优化建议直接生成代码](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702975556073-42d1222f-ff1e-4112-8c6f-ca598535d85b.png#averageHue=%231d2226&clientId=u8c64ea91-a253-4&from=paste&height=535&id=u6aa4364d&originHeight=1070&originWidth=1678&originalType=binary&ratio=2&rotation=0&showTitle=true&size=368787&status=done&style=none&taskId=ua73263a9-ed44-4e06-b748-e05b34371fc&title=%E4%BC%98%E5%8C%96%E5%BB%BA%E8%AE%AE%E7%9B%B4%E6%8E%A5%E7%94%9F%E6%88%90%E4%BB%A3%E7%A0%81&width=839 "优化建议直接生成代码")
可以直接采用替换原先代码，或者复制代码，最好用的是可以进行前后代码比较，看看 CodeFuse 究竟帮我们改了哪些，很直观。

![看看 CodeFuse 究竟帮我们改了哪些](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702975626391-b55bf854-ea7b-47b9-ae5a-a94b620c3da8.png#averageHue=%235a6b38&clientId=u8c64ea91-a253-4&from=paste&height=717&id=ue0310e9e&originHeight=1434&originWidth=2058&originalType=binary&ratio=2&rotation=0&showTitle=true&size=630664&status=done&style=none&taskId=u75ebf96c-9ef3-4eaa-92a1-b9650230987&title=%E7%9C%8B%E7%9C%8B%20CodeFuse%20%E7%A9%B6%E7%AB%9F%E5%B8%AE%E6%88%91%E4%BB%AC%E6%94%B9%E4%BA%86%E5%93%AA%E4%BA%9B&width=1029 "看看 CodeFuse 究竟帮我们改了哪些")

生成的优化代码：
```java
    @Before
    public void before() {
        // 可以为 null
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        String apiKey = "xxx";
        int connectTimeout = 50;
        int writeTimeout = 50;
        int readTimeout = 50;
        String apiHost = "https://api.openai.com/";
        v2 = OpenAiClient.builder()
                .apiKey(apiKey)
                .connectTimeout(connectTimeout)
                .writeTimeout(writeTimeout)
                .readTimeout(readTimeout)
                .interceptor(Arrays.asList(httpLoggingInterceptor))
                .proxy(proxy)
                .apiHost(apiHost)
                .build();
    }
```
而GitHub Copilot 目前这块功能还无法使用在 idea 中。
![GitHub Copilot 无法使用的功能](https://cdn.nlark.com/yuque/0/2023/png/29495295/1702974480828-66f6e527-a581-488b-8d5e-a9e794d03dd4.png#averageHue=%232f3132&clientId=u8c64ea91-a253-4&from=paste&height=702&id=ufeac217c&originHeight=1404&originWidth=1818&originalType=binary&ratio=2&rotation=0&showTitle=true&size=558304&status=done&style=none&taskId=u815763d0-fdc5-4b21-9049-82dbb43c29e&title=GitHub%20Copilot%20%E6%97%A0%E6%B3%95%E4%BD%BF%E7%94%A8%E7%9A%84%E5%8A%9F%E8%83%BD&width=909 "GitHub Copilot 无法使用的功能")
> 基于大模型的代码理解能力和静态源码分析能力，CodeFuse 支持对选定的代码片段进行分析理解，提出优化和改进建议，还能直接基于改进建议形成代码补丁，能帮助我们写出更好的代码。


# 四、总结
目前虽 说CodeFuse 还处于内测阶段，但从测试效果来看，还是很惊艳的，特别是其侧边栏的代码 UI 风格和交互以及支持自定的配置比较友好。

在这个由创新驱动的时代，CodeFuse 等工具的出现，不仅加速了编程项目的开发进程，更为编程世界带来了新的可能性。对于那些渴望在技术领域保持领先的开发者们来说，CodeFuse 无疑是一个值得尝试和深入探索的宝贵资源。

![苍何个人介绍.png](https://cdn.nlark.com/yuque/0/2023/png/29495295/1696255868903-dd1f63ce-d8a4-40d3-bb7a-2879c1d331a1.png#averageHue=%23a6bbbd&clientId=ub7322f39-98cc-4&from=ui&id=u9a4a5bf7&originHeight=500&originWidth=900&originalType=binary&ratio=2&rotation=0&showTitle=false&size=445580&status=done&style=none&taskId=uf832e99f-fd09-436e-b42e-f632bd37bb7&title=)

> 创作不易，如果本文对你有帮助，欢迎点赞、收藏加关注，你的支持和鼓励，是我创作的最大动力。
> ![文章最下方关注图片.gif](https://cdn.nlark.com/yuque/0/2023/gif/29495295/1695892885868-ec6c1fdb-e043-40e0-8b57-079a6050abd6.gif#averageHue=%23e6e1e0&clientId=u5e901b1f-45e4-4&from=ui&id=u8ab09020&originHeight=200&originWidth=640&originalType=binary&ratio=2&rotation=0&showTitle=false&size=137992&status=done&style=none&taskId=uc7faaa53-86b7-474a-974a-d55411ced53&title=)


