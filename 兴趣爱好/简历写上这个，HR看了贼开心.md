大家好，我是苍何。

最近帮好几个同学修改了简历，发现有个共性问题，就是技术栈和项目看着很丰富，但亮点却很难挖掘。

那么亮点除了项目，其实还可以在简历上增加一些开源地址或者是个人网站，哪怕是把自己的学习笔记整理到网站上，都会给这份简历大大加分。至少 HR 看了，觉得这小伙子还是挺热爱技术的，先捞出来面面看吧。

![7Xkn1.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/29495295/1715320516389-eb14f0bf-6bb6-4ae7-a1e5-0fa443e99c47.jpeg#averageHue=%231b231f&clientId=uc65d314f-a560-4&from=drop&id=ue3c7873f&originHeight=267&originWidth=297&originalType=binary&ratio=2&rotation=0&showTitle=false&size=11824&status=done&style=none&taskId=uf167a0fc-7e0a-4956-8f0a-1e683ad0031&title=)

那么如何快速上线自己的个人网站并写在简历上呢？结合 AI，简单四步即可实现。

在最开始学习编程的时候，你是不是也一样好奇，一个网站究竟怎么搭建起来的？当时小菜鸡的我甚至连域名、服务器、DNS 这些都不知道。😂

后面照葫芦画瓢，按照网上教程，用 GitHub page 和 hexo 搭建了一套博客网站，至今苟活了 **1776** 天。

![苍何的原始博客网站](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715221057000-4f0d63cb-566f-4eb2-ae84-729da34e9031.png#averageHue=%23f5f9f7&clientId=uab44f23d-db70-4&from=paste&height=501&id=uad659ac0&originHeight=1001&originWidth=1886&originalType=binary&ratio=2&rotation=0&showTitle=true&size=1451405&status=done&style=none&taskId=u91fe4e73-e6de-4d87-8477-d8194d664ac&title=%E8%8B%8D%E4%BD%95%E7%9A%84%E5%8E%9F%E5%A7%8B%E5%8D%9A%E5%AE%A2%E7%BD%91%E7%AB%99&width=943 "苍何的原始博客网站")

虽说看着花里胡哨，但前前后后忙活了不少，现在看来，没有达到预期效果，后期文章发布和管理还是不够丝滑，也导致后面难以维护，停更在了 2020 年。

最近做开源项目，刚好也要搭建项目官方网站，想着如何才能**快速搭建**，并能后期**高效维护**呢？

在 AI 的加持下，终于找到比较好的解决方案，那就是用 **Vuepress** 配合相关主题快速搭建。下面分享下搭建的过程，如果你也想快速搭建一个属于自己的网站，不妨往下看看。

# 购买域名

一个成熟网站的第一步是购买域名，那么什么是域名？

## 什么是域名？
我们先看看 GPT 的回答：

> 域名可以理解为互联网上的一个地址，就像现实世界中的家庭住址一样。当你想访问一个网站时，你需要知道它的域名。
> 
> 例如，想象一下你有一个朋友叫小明，他住在北京市朝阳区。如果你想去找他，你需要知道他的具体地址。同理，在互联网上，如果你想访问百度的网站，你需要通过域名 www.baidu.com 来访问。
> 
> 通过域名，我们可以方便地访问各种网站，而不需要记住复杂的数字IP地址。


![GPT解释什么是域名](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715306039405-4ff5f31e-50b8-4819-9c54-8db966729263.png#averageHue=%23f1f1f1&clientId=u2d622565-35f0-4&from=paste&height=379&id=udf675ffe&originHeight=757&originWidth=1323&originalType=binary&ratio=2&rotation=0&showTitle=true&size=151781&status=done&style=none&taskId=uea06a15f-bde6-4bee-9a96-1bd542dca07&title=GPT%E8%A7%A3%E9%87%8A%E4%BB%80%E4%B9%88%E6%98%AF%E5%9F%9F%E5%90%8D&width=661.5 "GPT解释什么是域名")

对于一些概念的通俗解释，我设计了个 GPTs 叫「讲解专家」，感兴趣的也可以直接体验：[https://chatgpt.com/g/g-igO7aQ62d-jiang-jie-zhuan-jia](https://chatgpt.com/g/g-igO7aQ62d-jiang-jie-zhuan-jia)

![讲解专家 GPTs](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715310090900-e5363879-3f8c-4d72-849e-d690c744449f.png#averageHue=%23f9f9f9&clientId=u9e5f9c80-c69a-4&from=paste&height=480&id=u417d581b&originHeight=960&originWidth=1553&originalType=binary&ratio=2&rotation=0&showTitle=true&size=81132&status=done&style=none&taskId=u7ae91d28-1e3b-4ff6-be54-d436509c556&title=%E8%AE%B2%E8%A7%A3%E4%B8%93%E5%AE%B6%20GPTs&width=776.5 "讲解专家 GPTs")

## 如何购买域名？
购买域名可以直接在各大云厂商购买，比如我的域名是在阿里云进行购买的，遇到自己喜欢的**域名被占用**了怎么办？

- 找相关服务联系域名持有者
- 等待域名过期
- 更换域名后缀，如 cn 或者不常用的后缀
- 更换自己的域名，名字加长一些

# 技术选型

AI 时代，做技术选型，我们完全可以结合**大模型**的能力以及自己的经验来做选型。我设计了一个「静态网站技术专家」的 Agent，以下是对应的提示词：

```markdown
# Role:
## 静态网站技术专家

## Profile:
- author: 苍何
- version: 1.0
- language: 中文
- description: 为用户提供建立静态网站的技术选型与建议，特别是以Vue驱动的网站。

## Background:
您需要一个静态网站来展示您的开源项目和技术文档。您希望该网站基于Vue，具有高性能、SEO友好，并支持服务端渲染与自动备份。

## Goals:
1. 选择合适的静态网站生成器。
2. 确保网站具有快速的加载速度。
3. 实现SEO优化以提高搜索引擎的可见性。
4. 提供自动服务端渲染和备份的解决方案。
5. 确保有丰富的主题和插件支持。

## Constraints:
- 必须使用Vue.js作为主要技术栈。
- 网站需要进行优化，以确保加载速度快。
- 需要支持SEO优化措施。

## Skills:
- 熟悉Vue.js及其生态系统。
- 对静态网站生成器如Nuxt.js有深入了解。
- 熟悉Web性能优化技术。
- 了解搜索引擎优化（SEO）的最佳实践。

## Workflows:
1. 用户描述具体需求，包括网站功能和期望的技术特点。
2. 提出使用Vue.js和Nuxt.js创建静态网站的方案，并解释为什么它们适合此项目。
3. 讨论网站可能的架构设计，包括主题选择和插件系统。
4. 提供关于SEO友好实现的建议。
5. 讨论自动备份和服务端渲染的实现方式。
6. 提供一个简要的实施步骤指南。

## Initialization:
您好！我是静态网站技术专家。根据您的需求，我可以帮助您选择和配置最适合沉淀开源项目技术文档的静态网站。请告诉我，您有什么具体的技术偏好或额外需求？

```

我们看看 AI 给的方案：

![静态网站技术专家建议方案1](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715307995653-b048fbdd-b38e-441c-a768-9bb73b5cc2c2.png#averageHue=%23efefef&clientId=u846c5f6f-3ada-4&from=paste&height=409&id=u95412cec&originHeight=817&originWidth=1161&originalType=binary&ratio=2&rotation=0&showTitle=true&size=185838&status=done&style=none&taskId=u2179e51b-14fc-40b4-aeb7-a22d0808f14&title=%E9%9D%99%E6%80%81%E7%BD%91%E7%AB%99%E6%8A%80%E6%9C%AF%E4%B8%93%E5%AE%B6%E5%BB%BA%E8%AE%AE%E6%96%B9%E6%A1%881&width=580.5 "静态网站技术专家建议方案1")

![静态网站技术专家建议方案2](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715308016348-118e2a97-04f9-43d8-9da5-a6086eda6eb9.png#averageHue=%23f0f0f0&clientId=u846c5f6f-3ada-4&from=paste&height=331&id=uba98d7ab&originHeight=661&originWidth=1161&originalType=binary&ratio=2&rotation=0&showTitle=true&size=128433&status=done&style=none&taskId=u55531079-aa3e-4230-a487-fa72c03ec48&title=%E9%9D%99%E6%80%81%E7%BD%91%E7%AB%99%E6%8A%80%E6%9C%AF%E4%B8%93%E5%AE%B6%E5%BB%BA%E8%AE%AE%E6%96%B9%E6%A1%882&width=580.5 "静态网站技术专家建议方案2")

综合考虑，用 VuePress 能更好的满足我目前的需求，且能快速搭建。
# 启动
## VuePress
VuePress 是一个基于 Vue.js 的**静态网站生成器**，由 Vue.js 的创造者尤雨溪大佬开发。它主要被设计来支持编写技术文档，但也可以用来构建任何类型的静态网站。Markdown 简洁性并结合 Vue 的强大功能使得使用者很多。

官方教程：https://vuepress.vuejs.org/zh/guide/getting-started.html

VuePress 有很多精美的主题，这次我使用的是 vuepress-theme-vdoing。

![vuepress-theme-vdoing 官方GitHub](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715308351592-e6c51995-6338-4ce9-a4e8-ad557ea24149.png#averageHue=%23f9f8f8&clientId=u846c5f6f-3ada-4&from=paste&height=489&id=u38a49bbe&originHeight=978&originWidth=1800&originalType=binary&ratio=2&rotation=0&showTitle=true&size=249730&status=done&style=none&taskId=ua528ad02-b12e-4c84-a681-5b3d7d6c386&title=vuepress-theme-vdoing%20%E5%AE%98%E6%96%B9GitHub&width=900 "vuepress-theme-vdoing 官方GitHub")

![博客效果](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715308736554-1fe83507-0bce-48f2-8152-f6ad32cd5d65.png#averageHue=%23f9f9f9&clientId=u846c5f6f-3ada-4&from=paste&height=462&id=u07924039&originHeight=923&originWidth=1912&originalType=binary&ratio=2&rotation=0&showTitle=true&size=192984&status=done&style=none&taskId=u6eefa8ed-14f9-45ee-b96b-8be6803eeea&title=%E5%8D%9A%E5%AE%A2%E6%95%88%E6%9E%9C&width=956 "博客效果")


简单几步就启动好了：

```git
# clone the project
git clone https://github.com/xugaoyi/vuepress-theme-vdoing.git

# enter the project directory
cd vuepress-theme-vdoing

# install dependency（如果下载慢就用第二个）
npm install 
npm install --registry=https://registry.npmmirror.com


# develop，第一次启动有点慢
npm run dev 
```

![本地启动](https://cdn.nlark.com/yuque/0/2024/png/29495295/1709652489942-41e490dd-601b-46d1-9a01-2f69cd47edfa.png#averageHue=%232b3842&clientId=u595383f2-2f5c-4&from=paste&height=672&id=u5aad2a42&originHeight=1344&originWidth=2222&originalType=binary&ratio=2&rotation=0&showTitle=true&size=491535&status=done&style=none&taskId=ue6c4a7a9-2151-4ad5-a1a3-89b1205e493&title=%E6%9C%AC%E5%9C%B0%E5%90%AF%E5%8A%A8&width=1111 "本地启动")

到这里，本地搭建就已经完成了，快的话 5 分钟就可以完成本地启动。👍

# 自动部署

本地启动完后，按照官方的教程进行**简单的修改和元素替换**，就可以快速做好自己的网站了，但光本地启动还不行，得让互联网上的其他人随时都能访问到你的网站，那该如何操作呢？

其实方法比较多，可以通过 GitHub page 、coding、vercel 等平台，,也可以自己搭建服务器自动化部署，我这里采用** GitHub page 配合 GitHub Action **自动持续集成。

项目内置了两种自动部署脚本，用于一键部署到 GitHub Pages 或 国内访问速度更快的 Coding Pages。

## 使用deploy.sh脚本部署

第一步，修改deploy.sh脚本内的仓库地址为你的仓库，如有自定义域名则一并修改，没有则注释

```bash
# 如果是发布到自定义域名
echo 'xugaoyi.com' > CNAME

# 如果发布到 https://<USERNAME>.github.io
# git push -f git@github.com:<USERNAME>/<USERNAME>.github.io.git master

# 如果发布到 https://<USERNAME>.github.io/<REPO>
# git push -f git@github.com:<USERNAME>/<REPO>.git master:gh-pages

```

第二步，一键部署命令

```bash
npm run deploy
```

第三步，设置仓库的 GitHub Pages。

 GitHub Pages 如何设置，可以直接问 GPT 或者网上搜索教程，基本上 5 分钟就搞定了。

# 绑定域名

通过 GitHub Pages 自动部署的方式，默认只能通过 `xxx.github.io` 来访问，需要**绑定域名**才可以通过域名进行访问。

绑定域名分2种情况：带 www 和不带 www 的。

域名配置最常见有 2 种方式，CNAME 和A 记录，CNAME 填写域名，A 记录填写IP，由于不带 www 方式只能采用 A 记录，所以必须先 ping 一下`你的用户名 .github.io`的IP，然后到你的域名 DNS 设置页，将 A记录指向你 ping 出来的 IP，将 CNAME 指向`你的用户名.github.io`，这样可以保证无论是否添加 www 都可以访问，如下：

![域名解析](https://cdn.nlark.com/yuque/0/2024/png/29495295/1715309357188-8ff8a507-3674-4074-a1ef-5437cd59e44f.png#averageHue=%23fcefee&clientId=ufec9bf8f-df67-4&id=QwMVw&originHeight=219&originWidth=504&originalType=binary&ratio=1&rotation=0&showTitle=true&status=done&style=none&taskId=ufbda841e-f7ee-456f-8f86-0393eda6689&title=%E5%9F%9F%E5%90%8D%E8%A7%A3%E6%9E%90 "域名解析") 

然后到你的github项目根目录新建一个名为 CNAME 的文件（无后缀），里面填写你的域名，加不加 www 看你自己喜好，因为经测试：

- 如果你填写的是没有www的，比如 mygit.me，那么无论是访问 [http://www.mygit.me](http://www.mygit.me) 还是 [http://mygit.me](http://mygit.me) ，都会自动跳转到 [http://mygit.me](http://mygit.me)
- 如果你填写的是带www的，比如 www.mygit.me ，那么无论是访问 [http://www.mygit.me](http://www.mygit.me) 还是 [http://mygit.me](http://mygit.me) ，都会自动跳转到 [http://www.mygit.me](http://www.mygit.me)
- 如果你填写的是其它子域名，比如 abc.mygit.me，那么访问 [http://abc.mygit.me](http://abc.mygit.me) 没问题，但是访问 [http://mygit.me](http://mygit.me) ，不会自动跳转到 [http://abc.mygit.me](http://abc.mygit.me)

另外说一句，在你绑定了新域名之后，原来的`你的用户名.github.io`并没有失效，而是会**自动跳转到你的新域名**。

以上几步，一个网站就快速搭建好啦。如果稍微有点基础的话，可能一两个小时就能上线一个网站，配合 AI 的加持，即使不会编程，搭建网站也变得很简单。网站搭建好后，只需要把自己的内容放上去然后放在简历中，能让简历更有亮点。

以上就是今天的分享，如果你也喜欢开源和独立开发，喜欢 AI，不妨关注苍何，一起成长！



