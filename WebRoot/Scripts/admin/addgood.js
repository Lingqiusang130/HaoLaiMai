$(function() {
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
	});
	$("#addGoodForm").submit(function() {
		var bool = true;
		if(!validateGoodName()) {
			bool = false;
		}
		if(!validateGoodPrice()) {
			bool = false;
		}
		if(!validateReCategoryIdS()) {
			bool = false;
		}
		return bool;
	});
});

/*
 * 商品名称校验方法
 */
function validateGoodName() {
	
	var id = "goodName";
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
		$("#" + id + "Error").text("商品名称不能为空！");
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
		$("#" + id + "Error").text("商品名称长度必须在3 ~ 15之间！");
		return false;
	}
	return true;	
}

/*
 * 商品价格校验方法
 */
function validateGoodPrice() {
	
	var id = "goodPrice";
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
		$("#" + id + "Error").text("商品价格不能为空！");
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(isNaN(value)) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("商品价格必须为数字！");
		return false;
	}
	return true;	
}
/*
 * 商品小类别选择
 */
function validateReCategoryIdS() {
	var id = "categoryIdS";
	if($("#"+id).val()==0){
		$("#" + id + "Error").text("必选选择商品类别");
		return false;
	}else{
		$("#" + id + "Error").text("");
	}
	return true;
}

