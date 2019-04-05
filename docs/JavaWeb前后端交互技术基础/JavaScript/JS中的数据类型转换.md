## 1、普通转换
parseInt()    parseFloat()
## 2、强制转换Boolean()
可以将所有的数据类型转换为布尔值
1、字符砖
空字符串——false
其他——true
2、数值
0——false
其他——true
3、变量值
null或者未定义——false
其他——true
## 3、开发中常用到
if(!num)直接写变量代表的意思是，如果如果num存在值，那么执行下一步操作，首先num未定义会变成false，然后加上感叹号就变成了true
