## 一、问题描述
在eclipse中新建jsp文件，默认的字符编码是ISO-8859-1，我们需要转换成utf-8，但是不是每次都是在jsp文件中改charset的值，而是在新建jsp的时候就进行更改
![默认字符编码](https://img-blog.csdnimg.cn/20181217234152503.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
## 二、设置UTF-8编码
windouw——proferences——搜索jsp——jsp files
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181217234508682.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
将Encoding改成UTF-8即可
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181217234547464.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这样再新建jsp的时候就更改成功了！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181217234739772.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)