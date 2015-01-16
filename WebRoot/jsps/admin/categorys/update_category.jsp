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
     <script type="text/javascript" src="<c:url value='/Scripts/admin/category.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/ui-lightness/jquery-ui-1.8.22.custom.css'/>" />
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>类别管理<b class="tip"></b>添加新类别</div>
	<form action="<c:url value='/CategoryServlet'/>" method="post" id="cateForm" name="cateForm">
	<input type="hidden" name="method" value="updateCategory" />
	<input type="hidden" name="cateId" value="${category.cateId }"/>
	<input type="hidden" id="err" value="${err}"/>
	<c:if test="${not empty err}">
		<script type="text/javascript">
   			alert(document.getElementById("err").value);
   		</script>
	</c:if>
    <table class="table table-striped table-bordered table-condensed list">  	
        <thead>
            <tr>
                <td colspan="4"><b>商品信息</b></td>
            </tr>
        </thead>
        <tbody>
        	<tr>
            	<td>类别号<font color="FF0000">*</font></td>
                <td colspan="3">${category.cateId}</td>
            </tr>
            <tr>
            	<td>类别名<font color="FF0000">*</font></td>
                <td colspan="3">
                	<input name="cateName" id="cateName"  class="inputClass" value="${category.cateName}" type="text" />
                	<a style='text-decoration:none;' class="error" id="cateNameError" name="cateNameError"></a>
                </td>
            </tr>
            <tr>
            	<td>父类别<font color="FF0000">*</font></td>
                <td colspan="3">
					<select name="categoryId" id="categoryId">
						<option value="0">==商品大类别==</option>
					    <c:forEach items="${parents}" var="parent">
							<option value="${parent.cateId}" <c:if test="${category.parent.cateId==parent.cateId}">selected</c:if>>${parent.cateName}</option>
						</c:forEach>
					</select>
					<a style='text-decoration:none;' class="error" id="goodPriceError" name="goodPriceError">若为创建商品大类，则无需选择</a>
                </td>       
            </tr>
            <tr>
                <td width="15%">类别描述</td>
                <td width="500" colspan="3" height="">
                    <textarea name="description" id="description" style="width: 95%; height: 100px" rows="4" cols="5" >${category.decription }</textarea>
                </td>
            </tr>
        </tbody>
    </table>
      <input class="btn btn-inverse" id="find" type="submit" value="保存" />
      <input class="btn btn-inverse" type="button" value="取消" />
    </form>
</body>
</html>
