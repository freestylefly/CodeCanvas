## 一、什么是Maven
maven是一个管理依赖的工具，我们项目中常用maven来管理jar包，并且可以管理jar包的依赖，有了maven，无论是引用别人的jar包还是自己项目需要打 包都变得极其简单。
maven仓库就是存放jar包的仓库，分为本地库、远程库和私有库。
本地库是本地计算机存放jar包的地方，本地仓库需要到私有库去拉取jar包，私有库一般是公司自己存放jar的仓库，会有专门的人员进行维护，远程库就是公有库，里面涵盖了很多的jar包，可以直接下载，但是需要外网权限。
## 二、Maven安装
超级简单，直接百度，或者访问这个博客：
https://blog.csdn.net/m1234ilu/article/details/84261888
## 三、坐标
pom.xml里，使用下面三个向量，在仓库中唯一定位一个Maven工程，每一个坐标代表这个工程所在的位置。
groupId	公司或者组织的域名倒序+项目名	<groupId>com.dfr.TestMaven</groupId>
artifactId	模块名	<artifactId>Hello</artifactId>
version	版本	<version>0.0.1-SNAPSHOT</version>
## 四、仓库管理

本地仓库：当前电脑上部署的 仓库目录
私服：架设在局域网环境中，为局域网范围内 的所有Maven工程服务
中央仓库：架设在Internet上，为全世界的Maven工程服务
中央仓库镜像：架设在各大洲，为了分担中央仓库的流量，更快响应用户
## 五、生命周期
生命周期定义：一套生命周期，就是把许多的构建过程，有序的排列。形成一套有序的构建过程集合。
生命周期特性：无论执行该生命周期的哪个阶段，它前面的所有阶段都会被按顺序执行。
Maven有三套独立的生命周期：
Clean LifeCycle	真正构建前，先清理
Default LifeCycle	核心的构建部分：编译，测试，打包，安装，部署等
Site LifeCycle	生成项目报告，站点，发布站点
以Default 生命周期为例，并列举部分常用的的阶段：compile -> test-compile -> test -> package -> install -> deploy

若执行 test-compile阶段，则真正被执行的有 compile -> test-compi
## 六、插件和目标
Maven核心程序只是定义了生命周期的各个阶段，以及每个阶段需要去执行哪个插件的哪个模块。

所以真正去执行时，会依赖本地仓库中的插件。Maven核心程序中并没有这些插件。

生命周期阶段	调用插件	调用插件的目标（模块）
compile	maven-compiler-plugin	compile
test-compile	maven-compiler-plugin	testCompile
## 七、依赖的排除
定义：工程A依赖工程B，工程B依赖b.jar。若工程A中不想要b.jar，则需要配置依赖的排除信息。
配置信息
```
<exclusions>
	<exclusion>
	    <groupId></groupId>
	    <artifactId></artifactId>
    </exclusion>
</exclusions> 
```

