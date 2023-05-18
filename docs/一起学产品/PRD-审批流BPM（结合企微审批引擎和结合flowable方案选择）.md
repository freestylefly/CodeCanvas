# 前言
 流程设计历来都是比较繁琐之事，由于公司急需上线流程化的平台，内部系统迫切需要升级，在无产品经理的情况下，我迎难而上，正如《人人都是产品经理》所言“**不是每个人都能以产品经理为业，但在我看来，产品经理是一类人，他们做事的思路与方法可以解决很多实际的生活问题。
只要你能够发现问题并描述清楚，转化为一个需求，进而转化为一个任务，争取到支持，发动起一批人，将这个任务完成，并持续不断以主人翁的心态去跟踪、维护这个产物那么，你就是产品经理。
至少，你已经是自己的产品经理了。这才是“人人都是产品经理”的真谛。**”

第一次做需求分析、设计、走了很多的弯路，一开始以为用企微审批引擎能节约资源，实际发现会更加浪费资源，且扩展性不强。也调研了像diboot这些成熟的workflow，但阻塞在了收费上，就没再去寻找其他开源替代方案，一心扎到企微流程引擎中无法自拔，浪费了一些资源和时间，以后在这方面要保持警惕，一定要想好，调研好才能开始做。


# 1、认识审批流
## 1.1、认识审批流
审批流，是一种工作流，常见于中后台系统，其本质是待审信息的流动方式及决策过程。
即申请者（人或系统）提供待审信息，交由相关审批人进行传递及处理，期间，每个审批者会基于自己的岗位职责与权限分工对待审信息进行核对（检查/确认…）、判断（通过/驳回/转交/挂起…）及协商（反馈意见…），直至抵达最高决策层进行取舍。
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/ddfe35e91a43e24d691007b4cfed3d36.png)

## 1.2、为什么要创建审批流
合规化：帮助管理者规范团队的运转流程、防范决策失误；引导申请者遵循正确的流程规范，避免违规操作。
## 1.3、审批流的构成要素
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/819ddfbcb8a55cb2865e0aedd790caeb.png)

- 谁发起审批（申请者）：不仅仅指某个用户，也可能是系统或是第三方服务商。
- 谁来审批（审批者）：可能是某个审批群组或是特定的审批人，受限于权限与分工。
- 按什么规则审批（审批规则）：不同权限与分工的审批者按一个或多个审批条件进行审批。
- 审批什么（待审信息）：申请者基于不同的申请事项，按要求提供的信息。
- 各角色可以干嘛（操作动作）：可以是审批操作（通过、驳回…），也可以是流程操作（转交、撤回…）。
- 怎么告诉各角色（通知方式）：即通知申请者、审批者的渠道（短信、电话、邮件、平台消息提醒…）。
## 1.4、好的审批流要满足什么条件
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/d843bcf0d670cce7f5726758dcd3c9cc.png)

- 信息传达准确：能有效并准确传达审批流的相关信息。
- 流程操作高效：能提升组织内部的运转效率。
- 节点可预知：能帮助各角色提前了解审批流程。
- 历史可回溯：对已结束的审批单据能随时回溯。


# 2、盘点审批流程
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/797f512c06495a3510bca69679035801.png)
## 2.1、归纳角色类型
| 用户角色 |  | 角色描述 |
| --- | --- | --- |
| 申请者 |  | 公司员工（包括中干基层、项目经理、采购、研发等） |
| 审批者 | 专业组长审批 | 专业组组长岗位员工及其审批链条 |
|  | 项目经理审批 | 项目经理岗位员工及其审批链条 |
|  | 部门长审批 | 部门长岗位员工及其审批链条 |
|  | 供应链审批 | 供应链岗位员工及其审批链条 |
|  | 库管审批 | 库房管理岗位员工及其审批链条 |

## 2.2、理清任务流程
![角色场景任务泳道图.jpg](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/08e2a1c609f4f64df002a7b2ef3b1b33.jpeg)
## 2.3、挖掘产品功能点
### 2.3.1、用户旅程地图
![用户旅程地图.jpg](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/be739cbcd8a118818a2b8407f8ba27ee.jpeg)
### 2.3.2、产品功能列表
| 主功能 | 子功能 | 子功能 |
| --- | --- | --- |
| 审批管理 | 发起申请 | 发起审评 |
|  | 我的申请 | 审批列表 |
|  | 我审批的 | 待处理审批列表 |
|  |  | 已处理审批列表 |
|  | 审批设置 | 提醒设置 |
|  |  | 模板设置 |
| 项目列表 | 发布审批 | 发布审批 |
| 任务列表 | 发起审批 | 发起审批 |
| 任务详情 | 发起审批 | 发起审批 |
|  | 审批记录 | 审批记录 |
| 采购入库 | 发起审批 | 发起审批 |
| 采购退库出库 | 发起审批 | 发起审批 |
| 其他入库 | 发起审批 | 发起审批 |
| 其他出库 | 发起审批 | 发起审批 |

# 3、审批流页面设计
## 3.1、搭建信息架构
信息架构推导脑图
![](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/187d41eb2c99fce32cd002233202b990.jpeg)

角色权限列表
![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/94deeaa7f5d3411eb2e40629ee5f28e5.png)


# 4、链接消息通知
发起审批到相应的节点均有企微通知

# 5、原型设计
## 5.1、为什么要和企微结合
1、基于目前场景，如若重新设计BPM，是个很大的工程，企微有现成的产品解决方案，我们系统做对接融合即可
2、企微生态相对成熟，可无缝打通联系人和审批，无缝打通网页和APP端，能做到轻松在企微中审批相关任务
3、会涉及到跨部门的审批和企微结合亦方便进行
和企微审批打通，具体流程如下：
![0.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/ed1200e5002d95e855e3515e3b76a11c.png)
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/bd890a106246eafebcdc5c80c269b0ee.png)

企微相关开发接口：[审批流程引擎](https://developer.work.weixin.qq.com/document/path/90269)



# 6、企微自建应用开发步骤
## 6.1、创建企业
一个手机号可以创建多个测试企业用做测试使用
## 6.2、新建自建应用
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/91db63a246f6a5c7d2cbb3e88bc01f49.png)

## 6.3、应用设置
配置可信域名等：
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/ae21496e3f132c647dd8feb09562d4f6.png)

## 6.4、获取应用accessToken
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/b7c868f34d1988e3be1664f0c94d2ce8.png)

## 6.5、企微审批引擎相关接口
[https://developer.work.weixin.qq.com/document/path/97437](https://developer.work.weixin.qq.com/document/path/97437)
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/e137b3617f7d2ddc953d45a1efbe496c.png)

## 6.6、整体思路
整体流程

![在这里插入图片描述](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/516ec69c329e4104a64f626f7595e8e5.png)

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/901eb86c1dd3bbd4e8c8037548ca9c13.png)
创建一个模板均是相同的表单控件，唯一不同的是模板名称、模板id，在管理后台创建完模板后，需要去企微修改流程配置，进行跳转

```json
{
    "template_name": [
        {
            "text": "我的api测试模版2",
            "lang": "zh_CN"
        }
    ],
    "template_content": {
        "controls": [
            {
                "property": {
                    "control": "Text",
                    "id": "Text-01",
                    "title": [
                        {
                            "text": "单据类型",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入单据类型",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 1,
                    "un_print": 0
                },
                "config": {}
            },
            {
                "property": {
                    "control": "Text",
                    "id": "Text-02",
                    "title": [
                        {
                            "text": "单据名称",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入单据名称",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 1,
                    "un_print": 0
                },
                "config": {}
            },
            {
                "property": {
                    "control": "Text",
                    "id": "Text-03",
                    "title": [
                        {
                            "text": "单据详情",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入单据详情",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 1,
                    "un_print": 0
                },
                "config": {}
            },
            {
                "property": {
                    "control": "Text",
                    "id": "Text-04",
                    "title": [
                        {
                            "text": "备注",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入备注",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 0,
                    "un_print": 0
                },
                "config": {}
            }
        ]
    }
}
```
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/9029e57c6052dda84759f7bdfbd4d6c6.png)
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/0716146f0237cb8e3314fe2c531b4be8.png)

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/03d56e84445202730294fbc3ab3f1990.png)

如有对模板的修改，需调用修改模板接口，但控件不做修改，接口只修改名称，其余参数和新建保持一致，流程修改还是需要到企微，修改后需要更新对应预览截图
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/c556bb9a073a82cfd2aa0e24a5117fe9.png)

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/62253069211d0990545d43c0ec887319.png)
传参可如下：
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/19f30d284834d22c54527c203c17c175.png)
```json
{
    "template_id": "C4RdAwFWww7vv3oFEPoX1o4B3Mr9VHjzwbjw1Atwh",
    "template_name": [
        {
            "text": "我的api测试模版3",
            "lang": "zh_CN"
        }
    ],
    "template_content": {
        "controls": [
            {
                "property": {
                    "control": "Text",
                    "id": "Text-01",
                    "title": [
                        {
                            "text": "单据类型",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入单据类型",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 1,
                    "un_print": 0
                },
                "config": {}
            },
            {
                "property": {
                    "control": "Text",
                    "id": "Text-02",
                    "title": [
                        {
                            "text": "单据名称",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入单据名称",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 1,
                    "un_print": 0
                },
                "config": {}
            },
            {
                "property": {
                    "control": "Text",
                    "id": "Text-03",
                    "title": [
                        {
                            "text": "单据详情",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入单据详情",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 1,
                    "un_print": 0
                },
                "config": {}
            },
            {
                "property": {
                    "control": "Text",
                    "id": "Text-04",
                    "title": [
                        {
                            "text": "备注",
                            "lang": "zh_CN"
                        }
                    ],
                    "placeholder": [
                        {
                            "text": "请输入备注",
                            "lang": "zh_CN"
                        }
                    ],
                    "require": 0,
                    "un_print": 0
                },
                "config": {}
            }
        ]
    }
}
```



2、为单据绑定模板
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/caa49dc5af1ee69f781196295a3a83c9.png)
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/9c346f28551ecff38b10fe77c420d6ce.png)

3、发起审批
3.1、根据模板id获取模板详情
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/023e1004d90cb9385588e39c9effa1ce.png)

3.2、发起审批
```json
{
    "creator_userid": "CangHe",
    "template_id": "C4RdAwDkjzZaWDQn9fAoKogTZEAvaMoX42Lo9qgy6",
    "use_template_approver": 1,
    "apply_data": {
        "contents": [
            {
                "control": "Text",
                "id": "Text-1675996804140",
                "value": {
                    "text": "这是自动抓取的单据类型"
                }
            },
            {
                "control": "Text",
                "id": "Text-1675997969505",
                "value": {
                    "text": "这是自动抓取的单据编码"
                }
            },
            {
                "control": "Text",
                "id": "Text-1675998042838",
                "value": {
                    "text": "这是自动抓取的单据详情"
                }
            }
        ]
    },
    "summary_list": [
        {
            "summary_info": [
                {
                    "text": "单据名称：xxxx",
                    "lang": "zh_CN"
                }
            ]
        },
        {
            "summary_info": [
                {
                    "text": "单据类型：xxxx",
                    "lang": "zh_CN"
                }
            ]
        }
    ]
}
```
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1461772b848cc3df9c74f33fc00504bd.png)
接口调用成功后，保存单据编号

3.3、更新审批进度
可根据回调单据编号对应更新，点击手动刷新调用获取单据详情接口

# 7、结合开源flowable自研引擎
经研究发现企微审批接口和审批引擎均有一定的弊端，未能实际满足我们的需求，下面就两种情况的弊端先说明
企**微审批接口弊端：**
1、必须为自建应用
2、表单模板添加超链接，无法用正常浏览器打开，需求中需要能打开内部系统链接
3、建立模板需现在企微上进行操作
4、无法在自己内部系统进行审批
5、审批状态实时要企微回调接口才可获取，内部获取审批详情接口事实性不高
6、开发成本也高，且无法复用内部其他系统，扩展性不强

**企微审批引擎：**
1、相对审批接口，引擎主要是给第三方应用提供，但只能在企微内部自建应用通过JS-SDK打开，扩展性不强
2、开发成本较高
3、复用性不强
4、内部系统无法直接审批，当审批流过多时，对审批人需要找很久，无法像内部接口一样可以有处理状态的
5、用户体验不好

综合以上调研，自研一套审批引擎对公司来说迫在眉睫
我们调研了很多开源的引擎，发现大部分都是基于flowable引擎开发的，包括：
1、[https://www.diboot.com/](https://www.diboot.com/)
workflow整体将表单和流程进行了完美融合，可惜这部分并不开源
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/8d03ece117ed51ff8ef8ad418e1c77fd.png)
2、[http://106.52.168.121:1024/work/create](http://106.52.168.121:1024/work/create)
基于ruoyi和flowable，且开源，对我们来说比较友好
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/640e78286019a6f988fa65924698a707.png)

## 7.1、我的事务和流程管理
第一期，将plus集成到我们系统，我的事务和流程管理暂不做改动，调整相应交互即可
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/320d2614377d55067483c552d1f3f1fc.png)

## 7.2、任务审批
添加任务设置-审批设置
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/85b511b68b061165925d243246173911.png)
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/5cc56e47522f011be5fa118b69f1b145.png)
为任务选择审批流程

新建任务-配置审批
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/304a140eb5506f14c4d304242ea8ad7a.png)

