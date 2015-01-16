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
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/ui-lightness/jquery-ui-1.8.22.custom.css'/>" />
    
    <script type="text/javascript">
    function removeCate(cateId,cateName){
        if(confirm("您确认要删除["+cateName+"商品]的信息资料吗?")){         
           location.href='<c:url value="/CategoryServlet?method=deleteCategory"/>&cateId='+cateId;
        }
 	 }
    function updateCate(cateId){
        location.href='<c:url value="/CategoryServlet?method=toUpdateCategory"/>&cateId='+cateId;
   	}
	function $(elementId)
	{
		return document.getElementById(elementId);
	}
	//只输入数字
	function onlynumber()
	{
		if(event.keyCode==13)
			return true;
		if(event.keyCode<48||event.keyCode>57)
		{
			event.keyCode=0;
			event.returnValue=false;
		}
		event.returnValue=true;
	}
	function doQuery(pageno){
		if (pageno<1 || pageno>${pageCategory.totalPageNum}) {
				alert("页号超出范围，有效范围：[1-${page.totalPageNum}]!");
				$('pageNo').select();
				return;
			}
		var f = document.forms[0];
		f.action = f.action + "?method=loadAllCategory&pageno=" + pageno;
		f.submit();
	}
    </script>
</head>
<body onload="load">
    <div class="alert alert-info">当前位置<b class="tip"></b>类别管理<b class="tip"></b>所有类别</div>
    <div>
    <form action="<c:url value='/CategoryServlet'/>" method="post">
    <input type="hidden" name="method" value="loadAllCategory" />
    <input type="hidden" id="err" value="${err}"/>
	<c:if test="${not empty err}">
		<script type="text/javascript">
   			alert(document.getElementById("err").value);
   		</script>
	</c:if>  
     <span>商品大类：</span>
		<select name="categoryIdB" id="categoryIdB" class="select">
			<option value="0">==商品大类别==</option>
			<c:forEach items="${parents}" var="parent">
				<option value="${parent.cateId}" <c:if test="${param.categoryIdB==parent.cateId}">selected</c:if> >${parent.cateName}</option>
			</c:forEach>
		</select>
     <span>关键字：</span>
     <input type="text" name="keyValue" id="keyValue" value="${param.keyValue}"/>
     <input class="btn btn-inverse" id="find" type="submit" value="查询" />
     </form>
    </div>
    <br>
    <c:if test="${ not empty pageCategory.pageContent}">
    <table class="table table-striped table-bordered table-condensed" id="list">
        <thead>
            <tr class="tr_detail">
                <td>类别号 </td>
                <td>类别名</td>
                <td>描述</td>
                <td>父类别名</td>
                <td>操作 </td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageCategory.pageContent}" var="category">
            <tr>
            
                <td><a>${category.cateId}</a></td>
                <td>${category.cateName}</td>
                <td>${category.decription} </td>
                <td>
                	<c:if test="${ not empty category.parent.cateName}">${category.parent.cateName}</c:if>
                	<c:if test="${ empty category.parent.cateName}">无</c:if>
                </td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="javascript:updateCate(${category.cateId});" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button"  title="点击删除[${category.cateName}类别]信息资料"
		                         onclick="removeCate(${category.cateId},'${category.cateName}');" value="删除" /></span>
                </td>
            </tr>
         </c:forEach>
        </tbody>
    </table>
	 <div class="page_div">
    	当前第${pageCategory.pageNo}页/共${pageCategory.totalPageNum}页&nbsp;&nbsp;共${pageCategory.totalRecNum}条记录&nbsp;&nbsp;
    	<c:if test="${pageCategory.pageNo>1}">
    		<a class="badge badge-inverse" href="javascript:doQuery(1)">首页</a>&nbsp;
    	</c:if>
    	<c:if test="${pageCategory.prePage}">
    	<a class="badge badge-inverse" href="javascript:doQuery(${pageCategory.pageNo-1})">上一页</a>&nbsp;
    	</c:if>
    	<c:if test="${pageCategory.nextPage}">
    	<a class="badge badge-inverse" href="javascript:doQuery(${pageCategory.pageNo+1})">下一页</a>&nbsp;
    	</c:if>
    	<c:if test="${pageCategory.pageNo!=pageCategory.totalPageNum}">
    	<a class="badge badge-inverse" href="javascript:doQuery(${pageCategory.totalPageNum})">末页</a>
    	</c:if>
    	到&nbsp;<input type="text" id="pageNo" size=4 class="pageNo_input" onkeypress="onlynumber();"/>&nbsp;页
    	<a class="badge badge-inverse" href="javascript:doQuery($('pageNo').value);">跳 转</a>
	</div>
   </c:if>
   <c:if test="${empty pageCategory.pageContent}">
   	<script type="text/javascript">
   		alert("没有任何符合条件的商品信息被找到");
   	</script>
   </c:if>
</body>
</html>
