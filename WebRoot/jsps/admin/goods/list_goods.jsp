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
		function getCity(){ 
			var i=0;
			var j=0;			
			//获得商品大类别下拉框的对象  
			var categoryIdB=document.getElementById("categoryIdB");
			//获得商品小类别下拉框的对象  
			var categoryIdS=document.getElementById("categoryIdS");
			//获得选中下拉框的索引
			var index = categoryIdB.selectedIndex - 1;
			//清空商品小类别下拉框，仅留提示选项  
			categoryIdS.length=1;  
			//将商品小类中值填充到商品小类下拉框中  
			<c:forEach items="${parents}" var="parent">
				if(i==index){
				  <c:forEach items="${parent.children}" var="child">	
				  categoryIdS[j+1]=new Option("${child.cateName}","${child.cateId}");
				  	j++;			  	
				  </c:forEach>
				}
			 	 i++;
			</c:forEach>
		}  
	</script>  
</head>

<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>商品管理<b class="tip"></b>所有商品</div>
    <div>
     <span>商品大类：</span>
		<select name="categoryIdB" id="categoryIdB" class="select" onchange="getCity()" >
			<option value="0">==商品大类别==</option>
			<c:forEach items="${parents}" var="parent">
				<option value="${parent.cateId}">${parent.cateName}</option>
			</c:forEach>
		</select>
     <span>商品小类：</span>
       <select name="categoryIdS" id="categoryIdS" class="select">
	     	<option value="0" selected="selected">==商品小类别==</option>
	   </select>
     <span>关键字：</span>
     <input type="text" />
     <input class="btn btn-inverse" id="find" type="button" value="查询" />
    </div>
    <br>
    <table class="table table-striped table-bordered table-condensed" id="list">
        <thead>
            <tr class="tr_detail">
                <td>商品号 </td>
                <td>商品名</td>
                <td>商品价格</td>
                <td>商品图片</td>
                <td>商品类别 </td>
                <td>商品描述 </td>
                <td>操作 </td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${goodList}" var="good">
         	<tr>
                <td><a>${good.goodId}</a></td>
                <td>${good.goodName}</td>
                <td>${good.goodPrice}</td>
                <td><img width="200" height="150" src="<c:url value='/GoodServlet'/>?method=getpic&goodId=${good.goodId}"/> </td>
                <td>${good.category.cateId}</td>
                <td>${good.description}</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="" value="删除" /></span>
                </td>
            </tr>
		</c:forEach>
        </tbody>
    </table>
    <span style="margin-left: 420px">当前第5页/共55页&nbsp;&nbsp;共650条记录&nbsp;&nbsp;<a class="badge badge-inverse">首页</a>&nbsp;<a class="badge badge-inverse">下一页</a>&nbsp;
    	<a class="badge badge-inverse">1</a>&nbsp;<a class="badge badge-inverse">2</a>&nbsp;<a class="badge badge-inverse">3</a>&nbsp;<a class="badge badge-inverse">4</a>&nbsp;
    	<a class="badge badge-warning">5</a>&nbsp;<a class="badge badge-inverse">...</a>&nbsp;<a class="badge badge-inverse">55</a>&nbsp;<a class="badge badge-inverse">上一页</a>&nbsp;<a class="badge badge-inverse">尾页</a>
    </span>
</body>
</html>
