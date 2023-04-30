![文章首图.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682322115329-65118c90-f78c-446f-a98e-81888030beba.png)
# 1、前言
最近使用 ChatGPT 总是出现「Something went wrong. If this issue persists please contact us through our help center at help.openai.com.」，在生成时经常断掉，甚至一开始就生成不了，还得需要我们手动刷新页面…
频繁操作，很是烦扰，今天手把手解决 ChatGPT 挂掉的简单方法。
# 2、问题详细描述
当和 ChatGPT 聊着聊着，突然出现类似于断线的提示，并且需要刷新页面，才可以继续访问，最近出现的频次越来越高，估计是为了防止恶意使用，但对我们每天正常使用用户来说，太麻烦。

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682318192031-19807209-f852-41d2-83a8-4cdc363ac39e.png)

# 3、问题解决方案
## 3.1、安装油猴插件
[https://chrome.google.com/webstore/detail/tampermonkey/dhdgffkkebhmkfjojejmpbldmpobfkfo](https://chrome.google.com/webstore/detail/tampermonkey/dhdgffkkebhmkfjojejmpbldmpobfkfo)
![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682318316025-191e8439-418c-43d6-9134-d965fdae48fd.png)

篡改猴 (Tampermonkey) 使管理您的用户脚本变得非常简单。位于右上方的 篡改猴 图标显示正在运行的脚本的数量,单击图标就可以看到正在运行的脚本和可能在这个网页上运行的脚本。

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682318421762-9ec167e3-c27e-4fa9-b4d8-5759e3c3bd16.png)

## 3.2、安装 ChatGPT HeartBeat 
[https://greasyfork.org/zh-CN/scripts/462967-chatgpt-heartbeat](https://greasyfork.org/zh-CN/scripts/462967-chatgpt-heartbeat)
ChatGPT HeartBeat 是一个 控制 ChatGPT 刷新频率的脚本

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682318535249-08076831-a122-4342-bab9-a2dd923c3c70.png)

我们注意看这段脚本描述：

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682318640073-91370762-1def-45e6-bbfd-22c793cd25ad.png)

从原理上来说，这个刷新针对的是静态资源，由 Cloudflare 负责处理，是不会回源到 OpenAI 的。所以比起请求 https://chat.openai.com/api/auth/session ，我认为这个方案更不容易被封号。

我们把脚本源码复制下来，仔细研究，防止有恶意脚本威胁到安全：
```javascript
// ==UserScript==
// @name         ChatGPT HeartBeat
// @namespace    http://tampermonkey.net/
// @version      0.2.6
// @license      GPLv3
// @description  USE AT YOUR OWN RISK!
// @author       https://v2ex.com/t/926890
// @homepage     https://v2ex.com/t/926890
// @homepageURL  https://v2ex.com/t/926890
// @match        https://chat.openai.com
// @match        https://chat.openai.com/*
// @icon         https://chat.openai.com/favicon.ico
// @require      https://greasyfork.org/scripts/395037-monkeyconfig-modern/code/MonkeyConfig%20Modern.js?version=764968
// @run-at       document-start
// @noframes
// @grant        GM_setValue
// @grant        GM_getValue
// @grant        GM_registerMenuCommand
// @grant        GM_unregisterMenuCommand
// @grant        GM_addStyle
// ==/UserScript==

/*
  需要保持非常久的，可以额外尝试在 chrome://discards 里禁用 `Auto Discardable`，
  或者用 https://github.com/WorldLanguages/DoNotDiscard
  否则就算保持了 Cookies 有效，Chrome 也有可能自动休眠标签页。
*/

/*
  从原理上来说，这个刷新针对的是静态资源，由 Cloudflare 负责处理，是不会回源到 OpenAI 的。
  所以比起请求 https://chat.openai.com/api/auth/session ，我认为这个方案更不容易被封号。
*/
(function () {
    function isWindow(obj) {
        return obj instanceof Window;
    }

    // 防止页面通过监听事件强制刷新
    // https://gist.github.com/fuzmish/bd444b1aadc2d22aada7c9b1a6de56ba
    const rawAddEventListener = EventTarget.prototype.addEventListener;
    EventTarget.prototype.addEventListener = function (...args) {
        const [eventName] = args;
        if (
            isWindow(this) &&
            ["focus", "focusin", "visibilitychange"].includes(eventName)
        ) {
            return;
        }
        return rawAddEventListener.apply(this, args);
    };

    const cfg = new MonkeyConfig({
        title: "Configuration",
        menuCommand: true,
        params: {
            refreshInterval: {
                type: "number",
                default: 30,
            },
            refreshURL: {
                type: "text",
                default:
                "https://chat.openai.com/_next/static/k9OKjvwgjWES7JT3k-6g9/_ssgManifest.js",
            },
        },
    });

    function getRefreshURL () {
        var refreshURL = cfg.get("refreshURL");
        // 如果手动配置了 _ssgManifest.js 以外的 URL，就不尝试获取最新的
        if (!refreshURL.endsWith("_ssgManifest.js")) {
            return refreshURL;
        }
        // 获取最新的 _ssgManifest.js 链接
        // https://v2ex.com/t/926890#r_12897849
        const manifestScript = document.querySelector(
            'script[src*="_ssgManifest.js"]'
        );
        if (manifestScript) {
            cfg.set("refreshURL", manifestScript.src);
            return manifestScript.src;
        }
        return refreshURL;
    };

    const heartbeat = document.createElement("iframe");
    heartbeat.style.display = "none";
    document.head.prepend(heartbeat);

    let count = 0;
    function refresh() {
        count = 0;
        heartbeat.src = `${getRefreshURL()}?${Date.now()}`;
    }
    setInterval(function () {
        try {
            let current = new URL(heartbeat.contentWindow.location.href);
            let expect = new URL(getRefreshURL());
            if ( heartbeat.contentWindow.location.href === '' ||
                heartbeat.contentWindow.location.href === 'about:blank' ||
                current.pathname === expect.pathname ||
                count++ * cfg.get("refreshInterval") >= 2 * 60) {
                refresh();
            }
        } catch (error) {
            // https://v2ex.com/t/926890#r_12935587
            console.error(error);
            refresh();
        }
    }, cfg.get("refreshInterval") * 1000);
})();

```

## 3.3、油猴插件配置
点击油猴插件，在「管理面板」中查看是否开启的状态

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682318818210-7f6196bf-7c91-4e3e-b1fb-0bcf943c6616.png)
## 3.4、设置刷新的时间
浏览器打开 ChatGPT，右击打开 Tampermonkey - ChatGPT HeartBeat - Configuration

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682319164844-c35a8935-a58b-4b42-b47c-d6f4ed7c48a6.png)

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682319582664-1107f415-7337-4ff2-bf37-0748cf134a63.png)

设置刷新的时间为 3 秒，修改刷新 url 的链接。

# 4、查看结果

![image.png](https://canghe666.oss-cn-chengdu.aliyuncs.com/canghe/1682320065090-de54f190-b91e-4780-96c3-f3a30966b07b.png)

再也不会出现断线的问题了，给力！！！
