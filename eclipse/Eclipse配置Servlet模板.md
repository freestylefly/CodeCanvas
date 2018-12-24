有时候新建servlet时候会生成很多我们不是想要的东西，每一次都去复制黏贴，手动删除我们不想要的东西，那么如何设置专属自己的模板呢？只需要输入短短几个字，然后ALT+/即可：

这里以Eclipse4.5.2版本为例：

1.打开Eclilpse，Window->Preferences

2.Java->Editor->Templates->New

配置如图：



Pattern内容如下：
```java
package ${enclosing_package};
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ${primary_type_name} extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("hello haohao...");
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```
勾选上“Use code formatter”->Apply->OK
3.重启Eclipse

4.使用Alt+/来快速匹配出模板，创建出简单清晰的Servlet

原文：https://blog.csdn.net/czkct/article/details/78750478 

