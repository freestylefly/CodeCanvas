# 前言
现在有一个需求场景是，每一个请求我都需要在请求头里面加上token这个请求头，作为一种校验机制，传统的接口可以通过设置一个全局的变量，然后通过页面携带过来（大概就是先将我们的token放在session中，写一个服务用来获取session中的token，然后主页面用ajax调用接口，将token放在隐藏域中，然后将请求头放进来，用ajax方法，这里不想洗说了），但是有一种情况是通过页面传递的并不一定都会适用所有接口，比如上传和下载的接口有时候头里面就没有token参数，可能是上传和下载是用表单提交的
这个时候如何将请求头通过后台的方法加进来？
想到用过滤器，用后台方法强制加入请求头。

# HTTP请求头
关于http请求头的相关信息可以参考这票博客，这里就不画蛇添足了 
https://blog.csdn.net/alexshi5/article/details/80379086
下面直接上如何通过filter为请求添加请求头参数：

# 新建请求控制类
```java
	package com.bitplan.smartCRM.web;
	
	import java.io.IOException;
	import java.util.Collections;
	import java.util.Enumeration;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	
	import javax.servlet.Filter;
	import javax.servlet.FilterChain;
	import javax.servlet.FilterConfig;
	import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletRequestWrapper;
	
    public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {
        /**
         * construct a wrapper for this request
         * 
         * @param request
         */
        public HeaderMapRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        private Map<String, String> headerMap = new HashMap<String, String>();

        /**
         * add a header with given name and value
         * 
         * @param name
         * @param value
         */
        public void addHeader(String name, String value) {
            headerMap.put(name, value);
        }

        @Override
        public String getHeader(String name) {
            String headerValue = super.getHeader(name);
            if (headerMap.containsKey(name)) {
                headerValue = headerMap.get(name);
            }
            return headerValue;
        }

        /**
         * get the Header names
         */
        @Override
        public Enumeration<String> getHeaderNames() {
            List<String> names = Collections.list(super.getHeaderNames());
            for (String name : headerMap.keySet()) {
                names.add(name);
            }
            return Collections.enumeration(names);
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            List<String> values = Collections.list(super.getHeaders(name));
            if (headerMap.containsKey(name)) {
                values.add(headerMap.get(name));
            }
            return Collections.enumeration(values);
        }

    }
```
# 新建过滤器
注意：需要将请求头里面没有token的接口后面带上token参数，参数名是“”token“”
```java
public class RemoteAddrFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
        //获得请求参数中的token值
        String token = request.getParamter("token");
        if（!StringUtils.isEntry(token)）{
			//如果请求中带有这个参数，则进行过滤加一个header头
			 requestWrapper.addHeader("tokenr", token);
			 chain.doFilter(requestWrapper, response); // Goes to default servlet.
		}
        chain.doFilter(request, response); // Goes to default servlet.
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
```
这个时候请求头中是会带有这个token，但是你可能用右键F12看不到这个头，相当于是一层伪代理，我们的接口是已经加上token校验。

# 总结
查找了很多资料，百度找到的和其他博客上说的感觉都是大同小异，并没有达到想要的效果。我觉得写博客就得一针见血，什么问题必须标书清楚，不要为了写而写，你可能不知道当人看了半天你的博客但是却没有得到问题的解决是一件多么痛苦的过程。最后是在https://stackoverflow.com上面找到的答案，当百度找不到答案时尝试谷歌，谷歌找不到时尝试下stackoverflow。
查找问题的搜索词也很重要，这些都需要有相关的经验才可以快速的定位问题，快速的找到解决办法，这才是一个资深程序眼必须会的一项技能。
