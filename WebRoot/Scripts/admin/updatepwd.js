$(function() {
	
	$(".inputClass").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
		showError($("#" + labelId));//隐藏没有信息的label
	});
	
	$("#pwdform").submit(function() {
		var bool = true;
		if(!validateAdminNPwd()) {
			bool = false;
		}
		if(!validateReAdminNCPwd()) {
			bool = false;
		}
		return bool;
	});
});

/*
 * 登录密码校验方法
 */
function validateAdminNPwd() {
	
	var id = "adminNPwd";
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
		$("#" + id + "Error").text("新密码不能为空！");
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 20) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("密码长度必须在3 ~ 20之间！");
		return false;
	}
	return true;	
}

/*
 * 确认密码校验方法
 */
function validateReAdminNCPwd() {
	var id = "adminNCPwd";
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
		$("#" + id + "Error").text("确认密码不能为空！");
		return false;
	}
	/*
	 * 2. 两次输入是否一致校验
	 */
	if(value != $("#adminNPwd").val()) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("两次输入不一致！");
		return false;
	}
	return true;	
}

