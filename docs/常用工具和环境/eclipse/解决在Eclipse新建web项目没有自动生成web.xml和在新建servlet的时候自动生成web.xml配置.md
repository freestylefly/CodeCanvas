## 一、在Eclipse新建web项目没有自动生成web.xml解决办法
## 方法一：在Eclipse新建web项目的时候重要参数上打勾
1、file--new-Dynamic Web Project 
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160226360.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
2、next下一步
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160315960.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

3、next下一步
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160348211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

4、关键：这里一定要打勾，默认是没有打勾的![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160416976.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

5、建好后可以点开就有web.xml了

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160544786.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## 方法二：在已经建好的项目上加上web.xml
 1.项目名称右键-->Properties:
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160700888.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
 2.点击Project Facets，取消选中Dynamic Web Module,点击Apply
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160730677.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
 3.重新选中Dynamic Web Module后，会出现Further configuration available...
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160754808.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

 4.点击Further configuration available...，选中Generate web.xml deployment descriptor,点击ok,Apply后，在WEB-INF下生成了web.xml。
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214160812893.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

## Eclipse在新建servlet的时候自动生成web.xml配置
在新建web项目的时候：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214161006245.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
我们新建默认用的是Tomact7.0,里面用的是servlet3.0版本默认的是使用注解配置，在新建dynamic web project 时，dynamic web module version选择2.5就ok了。
选择2.6即可
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181214161120451.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
这样就自动生成了servlet的文本.xml的自动配置t