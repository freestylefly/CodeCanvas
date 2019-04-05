当在云服务器中安装oracle时，按照一般的安装步骤安装后，需要修改两个文件的iIP地址才可以在本机进行访问，修改注意点：
监听器部分不要改成服务器的公网IP，要改成服务器的计算机名字才可以，两个配置文件夹均要修改
tnsnames.ora文件修改：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190106113038465.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
listener.ora：
其中host=那里也是改成计算机名而不是公网ip，然后分别重启监听器和orclservice服务就好，然后将tnsnames.ora文件拷贝到本机的E:\Java\Oracle\InstantClient\InstantClient目录下满。


如果监听器设置的是IP地址而不是计算机名字的话监听器会不起作用，甚至会启动不了服务。
