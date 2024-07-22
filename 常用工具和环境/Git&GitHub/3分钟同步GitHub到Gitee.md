大家好，我是苍何呀。

最近两个月，受二哥（沉默王二）指点，我对自己创作的方向以及风格做了彻底的反省，发现自己最大的一个毛病是**不够专注**。

![](https://cdn.tobebetterjavaer.com/stutymore/20240410162403.png#id=RaQnD&originHeight=592&originWidth=1034&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

尝试过很多方向，也想做很多事情，但恰恰每件事都没做好。我现在要做的是保持**足够垂直聚焦**。践行「**少就是多**」的原则，努力将之前的尝试做减法。

最近呢，还有个事情要给大家剧透下，我和二哥合伙一起搞了个项目，结合我两的优势，助力大家更好的**拿到满意的 offer**。过多细节就先不描述了，大家可以期待下哈＼（＾ ＾）／

![项目架构图](https://cdn.nlark.com/yuque/0/2024/png/29495295/1712738098355-8ecd06bc-31e2-4207-8679-3a99f196494f.png#averageHue=%23e6a459&clientId=u3db80d60-c7ef-4&from=paste&height=558&id=u50cfc3d6&originHeight=1115&originWidth=914&originalType=binary&ratio=2&rotation=0&showTitle=true&size=150313&status=done&style=none&taskId=u0e0f0b74-41f0-406f-9b7f-e050f9a9c38&title=%E9%A1%B9%E7%9B%AE%E6%9E%B6%E6%9E%84%E5%9B%BE&width=457 "项目架构图")

在做项目的过程中，我想将 GitHub 库自动同步到 Gitee，亲自实践了一种很方便的方法， 给大家分享下。

不知道大家有没有想过哪天 GitHub 挂了（虽然大概率不大可能😂），或者 GitHub 限制我们访问了，我们的数据是否有做多端备份呢？

而且 GitHub 毕竟服务和数据在国外，对国内访问多少有些限制，所以将 GitHub 的数据同步一份到国内的 Gitee 就显得**很重要**了。

![](https://cdn.tobebetterjavaer.com/stutymore/20240410164453.png#id=I1d6U&originHeight=237&originWidth=817&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

其实单纯同步还是有很多办法的，比如直接在本地代码绑定两个源，push 的时候，分别 push 两次就可以了。

但 AI 时代，我们讲究的是 workflow，能敲一下键盘就最好不要敲两下，哈哈，所以我们需要更简单的方式，那就是**自动同步**，当推送到 GitHub 时，能自动同步到 Gitee，无需其他任何操作👍。

下面只需要用** 3 分钟做 3 步配置 **，就可以做到这个自动的 workflow 了。

# 第一步，导入 GitHub 仓库到 Gitee

打开 Gitee，选择从 GitHub/Gitlab 导入仓库，

![](https://cdn.tobebetterjavaer.com/stutymore/image.webp#id=q2EBd&originHeight=357&originWidth=1517&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

选择需要导入的 GitHub 仓库以及需要导入到 Gitee 的哪个路径下面。

![](https://cdn.tobebetterjavaer.com/stutymore/20240410170226.png#id=Z6R0G&originHeight=847&originWidth=1578&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

可以直接导入 GitHub 仓库，但需要**是你自己的组织和仓库**，如果找不到需要同步的仓库，直接从 URL 导入也可以。我这里是组织到组织的导入方式。

这是导入完成后：

![](https://cdn.tobebetterjavaer.com/stutymore/20240410170545.png#id=iV7tn&originHeight=842&originWidth=1805&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

> 现在导入已经完成，不进行后续操作的话，也可以点击手动同步按钮进行同步，但每次都手动同步太麻烦啦，所以我们需要的是能自动同步！


# 第二步，在 Github 需要同步的仓库上添加 3 个 secrets

这一步主要是对同步进行配置，配置 GitHub 仓库的 secrets，路径：打开 GitHub 需要同步的仓库，(**Setting -> Secrets -> New repository secret**)。

![](https://cdn.tobebetterjavaer.com/stutymore/20240410170937.png#id=dCHNz&originHeight=846&originWidth=1542&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

接下来是配置关键的三个 secrets。

## 1、GITEE_USER

这是配置个人的 Gitee user id:，就是打开 Gitee 个人主页。复制这个就可以啦。

![](https://cdn.tobebetterjavaer.com/stutymore/20240410171323.png#id=PkN9Y&originHeight=859&originWidth=1548&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

当然如果是组织的话复制对应的组织 id 即可。

复制好 id 后，点击 New respository secret 创建：

![](https://cdn.tobebetterjavaer.com/stutymore/20240410171820.png#id=EYwaj&originHeight=810&originWidth=1680&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

## 2、GITEE_PRIVATE_KEY

这里需要添加 ssh 密钥对，如果之前没有生成的，可以先在本地生成 SSH 公钥和私钥：

```bash
ssh-keygen -t ed25519 -C "Gitee SSH Key"
```

在本地的~/.ssh 下会生成两个文件：输出：id_ed25519  id_ed25519.pub，分别是公钥和私钥。

先打开gitee_id_rsa.pub，复制公钥到：https://gitee.com/profile/sshkeys

![](https://cdn.tobebetterjavaer.com/stutymore/20240410172257.png#id=cFyjG&originHeight=691&originWidth=1452&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

同时将私钥添加到 Github 项目的 secrets 中：

![](https://cdn.tobebetterjavaer.com/stutymore/20240410172341.png#id=oEcon&originHeight=762&originWidth=1514&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

## 3、GITEE_TOKEN

这一步需要生成 Gitee 私人令牌，地址：[https://gitee.com/profile/personal_access_tokens](https://gitee.com/profile/personal_access_tokens)

![](https://cdn.tobebetterjavaer.com/stutymore/20240410172446.png#id=kxDaw&originHeight=842&originWidth=1440&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

并把口令复制到 secrets 中，同样创建 GITEE_TOKEN 这个 secret。
# 第三步，添加 sync2gitee.yml

复制 sync2gitee.yml 到到 Github 仓库下的 .github 文件夹的 workflows 文件夹下，即 [project-folder]/.github/workflows/sync2gitee.yml，并提交到 Github 仓库。（**这次操作就会触发同步的 Action**）

![](https://cdn.tobebetterjavaer.com/stutymore/20240410172846.png#id=ZP4ik&originHeight=777&originWidth=1514&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

完整代码如下：

```xml
# 通过 Github actions， 在 Github 仓库的每一次 commit 后自动同步到 Gitee 上.
name: sync2gitee
on:
  push:
    branches:
      - master
      - dev
jobs:
  repo-sync:
    env:
      dst_key: ${{ secrets.GITEE_PRIVATE_KEY }}
      dst_token: ${{ secrets.GITEE_TOKEN }}
      gitee_user: ${{ secrets.GITEE_USER }}
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
        with:
          persist-credentials: false

      - name: sync github -> gitee
        uses: Yikun/hub-mirror-action@master
        if: env.dst_key && env.dst_token && env.gitee_user
        with:
          # 必选，需要同步的 Github 用户（源）
          src: 'github/${{ github.repository_owner }}'
          # 必选，需要同步到的 Gitee 用户（目的）
          dst: 'gitee/${{ secrets.GITEE_USER }}'
          # 必选，Gitee公钥对应的私钥，https://gitee.com/profile/sshkeys
          dst_key: ${{ secrets.GITEE_PRIVATE_KEY }}
          # 必选，Gitee对应的用于创建仓库的token，https://gitee.com/profile/personal_access_tokens
          dst_token:  ${{ secrets.GITEE_TOKEN }}
          # 如果是组织，指定组织即可，默认为用户 user
          account_type: org
          # 直接取当前项目的仓库名
          static_list: ${{ github.event.repository.name }}
          # 还有黑、白名单，静态名单机制，可以用于更新某些指定库
          # static_list: 'repo_name,repo_name2'
          # black_list: 'repo_name,repo_name2'
          # white_list: 'repo_name,repo_name2'
```


**需要特别注意：如果是个人仓库而不是组织，account_type: 这个参数要改为 user。**

OK，之后就直接将改动提交到 GitHub，我们来看看效果。

![](https://cdn.tobebetterjavaer.com/stutymore/20240410173248.png#id=kyww3&originHeight=497&originWidth=1873&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

提交到 GitHub 触发 action 后，我们去 Gitee 看看是否自动同步：

![](https://cdn.tobebetterjavaer.com/stutymore/20240410173439.png#id=vGKp8&originHeight=642&originWidth=1499&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

可以看到，已经自动同步啦！

简单 3 步就已经配置好了自动同步，以后我们在 GitHub 上 dev 和 master 分支的改动就会自动同步到 gitee 了。当然你直接在 GitHub 上进行 PR，也是可以触发自动同步的。

当然 gitee 还提供了一种更简单的办法。

![](https://cdn.tobebetterjavaer.com/stutymore/20240410173608.png#id=bl8sG&originHeight=632&originWidth=1612&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

![](https://cdn.tobebetterjavaer.com/stutymore/20240410173633.png#id=EtzLL&originHeight=603&originWidth=1485&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

但目前这个功能体验不了，但盲猜，后面肯定会限制或者收费，大家也可以先用起来，这种方法当然更方便了，但后面还能不能用就不知道了。

以上就是今天的分享，有帮助可以点个赞。
