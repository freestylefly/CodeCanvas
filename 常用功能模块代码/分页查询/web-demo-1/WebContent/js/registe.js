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
//$("[value='提交']").bind("click", function(){
//	//确认提交吗
//	var question=confirm("确认日胶吗？");
//	//跳转到注册页
//	if(question){
//		location = webroot+"/changePassword";
//	}
//	
//});