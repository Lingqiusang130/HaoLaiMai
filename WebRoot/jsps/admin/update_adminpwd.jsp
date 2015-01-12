<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/admin-all.css'/>" />
    <script type="text/javascript" src="<c:url value='/Scripts/jquery-1.7.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/Scripts/jquery-ui-1.8.22.custom.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/Scripts/admin/updatepwd.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/ui-lightness/jquery-ui-1.8.22.custom.css'/>" />
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>管理员密码修改</div>
	<form action="<c:url value='/AdminServlet'/>" method="post" id="pwdform">
	    <input type="hidden" name="method" value="updateAdminPwd" />
	    <table class="table table-striped table-bordered table-condensed list">
	        <thead>
	            <tr>
	                <td colspan="4"><b>管理员信息</b></td>
	            </tr>
	        </thead>
	        <tbody>
	            <tr>
	            	<td>用户名<font color="FF0000">*</font></td>
	                <td colspan="3">${sessionAdmin.adminName}</td>
	            </tr>
	            <tr>
	            	<td>新密码<font color="FF0000">*</font></td>
	                <td colspan="3">
	                	<input name="adminNPwd" id="adminNPwd" value="" type="password" class="inputClass" />
	                	<a style='text-decoration:none;' class="error" id="adminNPwdError" name="adminNPwdError"></a>
	                </td>
	            </tr>
	            <tr>
	            	<td>确认密码<font color="FF0000">*</font></td>
	                <td colspan="3">
	                	<input name="adminNCPwd" id="adminNCPwd" value="" type="password" class="inputClass" />
	                	<a style='text-decoration:none;' class="error" id="adminNCPwdError" name="adminNCPwdError">${password}</a>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	    <input class="btn btn-inverse" id="find" type="submit" value="保存" />
	    <input class="btn btn-inverse" type="button" value="取消" />
    </form>
</body>
</html>
