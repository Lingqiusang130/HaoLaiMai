<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>好来买后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/base.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/admin-all.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/login.css'/>" />
    <script type="text/javascript" src="<c:url value='/Scripts/jquery-1.7.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/Scripts/jquery.spritely-0.6.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/Scripts/admin/login.js'/>"></script>        
	<script type="text/javascript">
		$(function() {/*Map<String(Cookie名称),Cookie(Cookie本身)>*/
			// 获取cookie中的用户名
			var adminName = window.decodeURI("${cookie.cookieAdminName.value}");
			if("${requestScope.form.adminName}") {
				adminName = "${requestScope.form.adminName}";
			}
			$("#adminName").val(adminName);
		});
	</script>
</head>
<body>
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>

    <div class="row-fluid">
        <h1>好来买后台管理系统</h1>
        <form action="<c:url value='/AdminServlet'/>" method="post" id="loginForm">
        <input type="hidden" name="method" value="login" />
        <label class="errorClass">${msg}</label>
        <p>
            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" class="input" id="adminName" name="adminName" value="${form.adminName} "/></label>
            <label id="adminNameError" class="errorClass">${error.adminName }</label>
        </p>
        <p>
            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" class="input" id="adminPwd" name="adminPwd" value="${form.adminPwd}"/></label>
            <label id="adminPwdError" class="errorClass">${error.adminPwd}</label>
        </p>
        <p class="pcode">
            <label>验证码：<input type="text" class="input" id="verifyCode" name="verifyCode" maxlength="5"/>
	            <img src="<c:url value='/VerifyCodeServlet'/>"id="imgVerifyCode" alt="" class="imgcode" />
	            <a href="javascript:_hyz()">换一张</a>
            </label>
        	<label id="verifyCodeError" class="errorClass">${error.verifyCode }</label>
        </p>
        <input type="submit" id="submit" value=" 登 录 " class="btn btn-primary btn-large login" />       
    	</form>
    </div>
</body>
</html>
