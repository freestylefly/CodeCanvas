//为注册按钮添加单击事件
$("[value='注册']").bind("click", function(){
	//跳转到注册页
	location = webroot+"/page/user/registe.jsp";
});
//为取消按钮添加单击事件
$("[value='取消']").bind("click", function(){
	//alert(webroot);
	//跳转到注册页
	location = webroot+"/login.jsp";
});