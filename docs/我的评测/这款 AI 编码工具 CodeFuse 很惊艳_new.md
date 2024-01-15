> **作者：**苍何，前大厂高级 Java 工程师，阿里云专家博主，CSDN 2023 年 实力新星，土木转码，现任部门技术 leader，专注于互联网技术分享，职场经验分享。
> 🔥**热门文章推荐：**
> - （1）[对程序员来说，技术能力和业务逻辑哪个更重要？](https://canghe.blog.csdn.net/article/details/133632205?spm=1001.2014.3001.5502)
> - （2）[搭建GitHub免费个人网站（详细教程）](https://canghe.blog.csdn.net/article/details/95392429?spm=1001.2014.3001.5502)
> - （3）[itchat实现微信聊天机器人](https://canghe.blog.csdn.net/article/details/92232985?spm=1001.2014.3001.5502)
> - （4）[嗖嗖移动业务大厅（源码下载+注释全 值得收藏）](https://canghe.blog.csdn.net/article/details/83204418?spm=1001.2014.3001.5502)


![image.png](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702974923306-1c65d594-70c3-4b5b-b523-245357a3ac1c.png)

大家好，我是苍何。在 AI 时代，总是会迅速出现很多惊艳的产品工具，这些效率工具，在很大程度上推动了科技的进步。特别是在编程领域，各类工具更是层出不穷，从 GitHub Copilot 到 CodeGeeX，再到通义灵码，有很多工具在不断涌现。今天，我想和大家分享一款我最近发现的、非常出色的编程辅助工具 —— CodeFuse。

# 一、什么是 CodeFuse
CodeFuse 是和 GitHub Copilot 类似的编码助手，是蚂蚁集团基于自研的基础大模型进行微调的代码大模型。

CodeFuse 具备代码补全、添加注释、解释代码、生成单测，以及代码优化功能，以帮助开发者更快、更轻松地编写代码。

我们知道在 IntelliJ IDEA 中安装 GitHub Copilot 并不能召唤出 chat 功能，目前这个功能还处于测试阶段，但 CodeFuse 直接就可以召唤出 chat 功能，并能很好的解释代码。

# 二、CodeFuse 下载与安装
目前 CodeFuse 还处于内测阶段，苍何也拿到了内测资格，还没申请的可以申请一波：在[CodeFuse官网](https://codefuse.alipay.com/welcome/product)直接申请，填相关资料等待审核就好了，一般审核周期 1-3 天。

![申请内测](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702970122434-2169110b-8ad5-4d1e-be16-cc4dd8fff8dc.jpeg "申请内测")

申请好后，拿到内测资格就可以直接下载插件。
> 因为目前还处于内测阶段，所以还没上线插件市场，目前无法直接在插件应用市场直接搜索到。


![下载插件](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702970237526-24d4b67a-981d-41bc-bf2b-35c4b78cca9b.png "下载插件")

我们以 IntelliJ IDEA 为例，点击下载插件进行下载

![下载idea插件](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702970298865-84df17cc-688d-4032-9fd3-be3250fa69a6.png "下载idea插件")

![本地存放](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702970357171-a2ce58e9-a6f9-4d25-8fd4-0fc54f5143a4.png "本地存放")
然后打开 idea，选择刚才下载的插件进行安装：

![idea插件安装](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702970483642-aea20a68-a290-461f-83fc-cecfc3bfb942.png "idea插件安装")
安装完成重启 idea 即可：

![安装完成](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702970548148-5dce2c2c-79c2-484f-ad35-da08018be405.png "安装完成")

可以看到我的 idea 已经安装了 GitHub Copilot、CodeGeeX、通义灵码，为了接下来和其他插件进行对比，在代码补全部分，单词仅开启一个插件，尽量保证实验客观真实。

安装好后，可以对默认是否进行代码补全进行设置：
![设置代码补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702971014142-39844e48-66b8-437a-aa75-aa4bd67f0e5b.png "设置代码补全")

之后需要进行登录，点击侧边栏登录完成后可以设置快捷键等。

![登录完成](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702971227561-624dbd21-a300-4942-b935-fef920558b6b.png "登录完成")

# 三、CodeFuse 功能及对比性评测
## 1、代码补全
和其他所有编码助手一样，代码补全是最基本的核心能力。为了保证实验的客观真实，我们采用单一补全法，我们先将其他插件的代码补全关闭。

关闭 GitHub Copilot 代码补全:
![关闭GitHub copilot代码补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702971557681-79040984-1bb9-4139-a7e7-50456c5e6ef5.png "关闭GitHub copilot代码补全")

关闭通义灵码代码补全;
![关闭通义灵码代码补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702971589262-d6ec3693-d913-4e10-93cf-f0d1969c1286.png "关闭通义灵码代码补全")

关闭 CodeGeeX 代码补全：
![关闭CodeGeeX代码补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702971665730-53b97787-86b6-4432-ac77-4ed73f3b63bf.png "关闭CodeGeeX代码补全")

这个时候代码补全只有CodeFuse 启用，我们先建一个空类，什么都不写，直接按换行看看：

![空白类默认补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702971822898-374cdfd4-5854-445d-87e5-3ec27d379c0c.png "空白类默认补全")

我们可以看到在提示代码后有中文的快捷键友好提示：

![快捷键友好提示](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702971874458-4886a5ef-e18a-4f36-98ba-6cc59d405a51.png "快捷键友好提示")

按 Tab 键采用提示编码，CodeFuse 并没有直接把 main 方法补全完，而是只补全最核心的一行，缺少方法另外一个括号。相对 GitHub copilot 来说，我觉得这这更加符合程序员编码习惯以及符合 idea 的默认换行补全方式。在 idea 中，写完一个方法的左括号，按换行，直接就可以补全右括号，而我们确实只需要他生成单行即可。

![CodeFuse 单行补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702972094586-3d4c5737-cafb-46c0-9e2a-555c64cd2377.png "CodeFuse 单行补全")

![CodeFuse 单行补全提示](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702972512583-7cce2f4e-7142-4c07-acc8-2ad013560bed.png "CodeFuse 单行补全提示")

这个时候，我们把 GitHub Copilot 代码补全打开，其他插件代码补全全部关闭。可以看到 GitHub Copilot 直接就提示一个完整的 main 方法，并输出了一段默认语句，个人觉得在有些场景下是一种累赘。CodeFuse 是在进行换行的时候提示下一句话，我觉得更友好一些。

![GitHub Copilot起始补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702972387958-a8c36fca-ecaa-4280-91fb-3597d7cabdb7.png "GitHub Copilot起始补全")

对于**单行的代码补全**模型速度上更快于GitHub Copilot，可能是GitHub Copilot 的远端模型依赖的大模型是 openai 的原因吧。

![单行代码补全](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702973125419-1715190a-462e-4acd-8e45-a189033861a4.png "单行代码补全")

对于**多行代码**，同样可进行补全，直接写一个注释，直接可以生成方法，在CodeFuse 中是完全区分单行代码补全和多行代码补全的。

![生成0-10 的随机数，要求不能是质数](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702973351907-4e1ccb38-35ed-4dc7-a387-a7501ebb3d4d.png "生成0-10 的随机数，要求不能是质数")

## 2、解释代码
![解释代码](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702973515085-9f2d54c0-7e0b-4f18-aaf6-16a93d5959ed.png "解释代码")
选中代码右键或者直接在侧边栏点击/explain 即可。因为目前GitHub Copilot 无法使用 chat 功能，所以这个侧边栏显示解释代码还是非常有用的。

![点击/explain解释代码](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702973581540-6ac15e7d-46d0-4267-b60f-58d0e5f3fbd5.png "点击/explain解释代码")

## 3、生成注释
生成注释同样是对需要注释的代码右键生成。但有时候不大灵敏，看了下官方说明看来是对方法函数的生成更完善。
> **说明**：目前模型的生成注释功能对整个函数级别的支持较为完善，因此推荐您优先针对函数级别生成注释。


![生成代码注释](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702973921849-1aff376b-3566-4cfa-a201-d52cd085a64a.png "生成代码注释")

这里我建议产品可以学习一下通义灵码的交互，直接在方法上可以进行操作，右键成本还是高了一些。

![通义灵码生成注释方式](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702973987268-bb06c75e-f635-4c89-9fc0-1ee1ad685dfa.png "通义灵码生成注释方式")

## 4、生成单侧
同样对需要生成单侧的代码，右键「生成单侧」即可在右侧栏中看到CodeFuse 生成的单侧，直接在测试类中插入单侧代码即可，还是很方便的。

![CodeFuse生成单侧](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702974153559-087c9c75-4f84-43af-853a-5fb99022aa3d.png "CodeFuse生成单侧")

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
![CodeFuse生成优化建议](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702974302989-994b4ec3-de66-4c40-b380-bc657ab782e3.png "CodeFuse生成优化建议")

可以选择按照优化建议直接生成代码：

![优化建议直接生成代码](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702975556073-42d1222f-ff1e-4112-8c6f-ca598535d85b.png "优化建议直接生成代码")
可以直接采用替换原先代码，或者复制代码，最好用的是可以进行前后代码比较，看看 CodeFuse 究竟帮我们改了哪些，很直观。

![看看 CodeFuse 究竟帮我们改了哪些](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702975626391-b55bf854-ea7b-47b9-ae5a-a94b620c3da8.png "看看 CodeFuse 究竟帮我们改了哪些")

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
![GitHub Copilot 无法使用的功能](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1702974480828-66f6e527-a581-488b-8d5e-a9e794d03dd4.png "GitHub Copilot 无法使用的功能")
> 基于大模型的代码理解能力和静态源码分析能力，CodeFuse 支持对选定的代码片段进行分析理解，提出优化和改进建议，还能直接基于改进建议形成代码补丁，能帮助我们写出更好的代码。


# 四、总结
目前虽 说CodeFuse 还处于内测阶段，但从测试效果来看，还是很惊艳的，特别是其侧边栏的代码 UI 风格和交互以及支持自定的配置比较友好。

在这个由创新驱动的时代，CodeFuse 等工具的出现，不仅加速了编程项目的开发进程，更为编程世界带来了新的可能性。对于那些渴望在技术领域保持领先的开发者们来说，CodeFuse 无疑是一个值得尝试和深入探索的宝贵资源。

![苍何个人介绍.png](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1696255868903-dd1f63ce-d8a4-40d3-bb7a-2879c1d331a1.png)

> 创作不易，如果本文对你有帮助，欢迎点赞、收藏加关注，你的支持和鼓励，是我创作的最大动力。
> ![文章最下方关注图片.gif](https://yupi-picture-1256524210.cos.ap-shanghai.myqcloud.com/22922/1695892885868-ec6c1fdb-e043-40e0-8b57-079a6050abd6.gif)


