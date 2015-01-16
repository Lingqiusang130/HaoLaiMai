$(function() {
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
	});
	$("#cateForm").submit(function() {
		var bool = true;
		if(!validateCateName()) {
			bool = false;
		}
		return bool;
	});
});

/*
 * 商品名称校验方法
 */
function validateCateName() {
	
	var id = "cateName";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("商品类名不能为空！");
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 15) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("商品类名长度必须在3 ~ 15之间！");
		return false;
	}
	return true;	
}
