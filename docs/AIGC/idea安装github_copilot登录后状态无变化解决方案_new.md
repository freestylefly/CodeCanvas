# 目录
- [目录](#目录)
- [1、问题描述](#1问题描述)
- [2、版本说明](#2版本说明)
- [3、解决方案](#3解决方案)
- [4、总结](#4总结)

# 1、问题描述
开启代理在idea中下载GitHub Copilot插件，点击登录，始终无法正常使用github copilot，一直停留在登录状态。
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/833792f8018545ce8c4c5d7de9f6f076.png)
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/a415e588614043ef9b299c326c346003.png)

![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/6e9f9c6789344b51a88479dc928a2a19.png)
浏览器显示已激活，但一直是需要登录。
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/3cea8680ac754ce0a273b815473be88a.png)

# 2、版本说明

我的idea版本是2022.2
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/a155403397ea42109e4e299142f21971.png)
github copilot版本是1.2.4.2459
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/3578f04bbe2b40829b8942b6f2828bf5.png)

# 3、解决方案
首先确认idea开启代理
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/7fc21cfa29784380bd165af09743605a.png)
其次访问
https://github.com/settings/copilot
确认已经绑定银行卡信息，并设置为allow「因为这是要收费的，虽然有60天的试用，需要你先绑定银行卡，方便后面扣费，一个月10美刀，60天后可修改续费方案」
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/ac8b6438d5404cd59ddd10b377b11feb.png)
绑定完银行卡信息保存后，有这个提示，重启下idea，就可成功
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/ee77241ddd4f4fd8a9d967e6b4961ef7.png)
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/d64f8ffaf04a4e97b7f7d19a609149bb.png)
# 4、总结
确认https://github.com/settings/copilot已经处于绑定状态即可。
