/* 声明变量 */
var curr, //当前页
	total, //总页数
	size; //页面大小

/* 分页js */
$("[value='首页']").bind("click", function() {
//	 location = webroot + "/query?currPage=1";
	queryByPage(1);
});
$("[value='上一页']").bind("click", function() {
//	location = webroot + "/query?currPage="+(curr-1);
	queryByPage(curr-1);
});
$("[value='下一页']").bind("click", function() {
//	location = webroot + "/query?currPage="+(curr+1);
	queryByPage(curr+1);
});
$("[value='尾页']").bind("click", function() {
//	location = webroot + "/query?currPage="+total;
	queryByPage(total);
});
$(".list table tr:last select:last").bind("change", function() {
	//读取当前页
	curr = $(".list table tr:last select:last option:selected").val();
	//跳转
//	location = webroot + "/query?currPage="+curr;
	queryByPage(curr);
});
$(".list table tr:last select:first").bind("change", function() {
	//读取当前页
//	curr = $(".list table tr:last select:last option:selected").val();
	//读取页面大小
	size = $(".list table tr:last select:first option:selected").val();
	//跳转
//	location = webroot + "/query?currPage="+curr + "&pageSize=" + size;
	queryByPage(curr, size);
});

/* 分页函数 */
function queryByPage(target, pageSize) {
	
	//判断, target 和 size 是否为null
	if(!target){
		target = curr;
	}
	if(!pageSize){
		pageSize = size;
	}
	//跳转
	location = webroot + "/query?currPage="+target + "&pageSize=" + pageSize;
}

