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
		//选中数据回填
		function load(){
			//获得商品大类别下拉框的对象  
			var categoryIdB=document.getElementById("categoryIdB");
			//获得商品小类别下拉框的对象  
			var categoryIdS=document.getElementById("categoryIdS");	
			var i=0;
			var j=0;
			index = categoryIdB.value - 1;
			if(index!=-1){				
				//将商品小类中值填充到商品小类下拉框中  
				<c:forEach items="${parents}" var="parent">			
					if(i==index){
					  <c:forEach items="${parent.children}" var="child">
					  var cids="${param.categoryIdS}";
					  var childId = "${child.cateId}";
					  if(cids == childId){					  
						  categoryIdS[j+1]=new Option("${child.cateName}","${child.cateId}");
						  document.getElementById("categoryIdS").options[j+1].selected = true; //保持选中状态
						  j++;
					  }else{
						  categoryIdS[j+1]=new Option("${child.cateName}","${child.cateId}");
						  j++;
					  }
					  </c:forEach>
					}
				 	 i++;
				</c:forEach>

			}
		}
		function getKind(){ 
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
		function removeRoom(goodId,goodName){
	          if(confirm("您确认要删除["+goodName+"商品]的信息资料吗?")){         
	             location.href='<c:url value="/GoodServlet?method=removeGood"/>&goodId='+goodId;
	          }
	    }
		function updateGood(goodId){
	         location.href='<c:url value="/GoodServlet?method=toPreUpdate"/>&goodId='+goodId;
	    }
		function doQuery(pageno){
			if (pageno<1 || pageno>${page.totalPageNum}) {
					alert("页号超出范围，有效范围：[1-${page.totalPageNum}]!");
					$('pageNo').select();
					return;
				}
			var f = document.forms[0];
			f.action = f.action + "?method=loadPagedGoods&pageno=" + pageno;
			f.submit();
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
	</script>  
</head>

<body onload="load();">
    <div class="alert alert-info">当前位置<b class="tip"></b>商品管理<b class="tip"></b>所有商品</div>
    <div>
    <form action="<c:url value='/GoodServlet'/>" method="post">
    <input type="hidden" name="method" value="loadPagedGoods" />
     <span>商品大类：</span>
		<select name="categoryIdB" id="categoryIdB" class="select" onchange="getKind()" >
			<option value="0">==商品大类别==</option>
			<c:forEach items="${parents}" var="parent">
				<option value="${parent.cateId}" <c:if test="${param.categoryIdB==parent.cateId}">selected</c:if> >${parent.cateName}</option>
			</c:forEach>
		</select>
     <span>商品小类：</span>
       <select name="categoryIdS" id="categoryIdS" class="select">
	     	<option value="0">==商品小类别==</option>
	   </select>
     <span>关键字：</span>
     <input type="text" name="keyValue" id="keyValue" value="${param.keyValue}"/>
     <input class="btn btn-inverse" id="find" type="submit" value="查询" />
     </form>
    </div>
    <br>
    <c:if test="${ not empty page.pageContent}">
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
        <c:forEach items="${page.pageContent}" var="good">
         	<tr>
                <td><a>${good.goodId}</a></td>
                <td>${good.goodName}</td>
                <td>${good.goodPrice}</td>
                <td><img width="200" height="150" src="<c:url value='/GoodServlet'/>?method=getpic&goodId=${good.goodId}"/> </td>
                <td>${good.category.cateId}</td>
                <td>${good.description}</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="javascript:updateGood(${good.goodId});" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button"  title="点击删除[${good.goodName}商品]信息资料"
		                         onclick="removeRoom(${good.goodId},'${good.goodName}');" value="删除" /></span>
                </td>
            </tr>
		</c:forEach>
        </tbody>
    </table>
    <div class="page_div">
    	当前第${page.pageNo}页/共${page.totalPageNum}页&nbsp;&nbsp;共${page.totalRecNum}条记录&nbsp;&nbsp;
    	<c:if test="${page.pageNo>1}">
    		<a class="badge badge-inverse" href="javascript:doQuery(1)">首页</a>&nbsp;
    	</c:if>
    	<c:if test="${page.prePage}">
    	<a class="badge badge-inverse" href="javascript:doQuery(${page.pageNo-1})">上一页</a>&nbsp;
    	</c:if>
    	<c:if test="${page.nextPage}">
    	<a class="badge badge-inverse" href="javascript:doQuery(${page.pageNo+1})">下一页</a>&nbsp;
    	</c:if>
    	<c:if test="${page.pageNo!=page.totalPageNum}">
    	<a class="badge badge-inverse" href="javascript:doQuery(${page.totalPageNum})">末页</a>
    	</c:if>
    	到&nbsp;<input type="text" id="pageNo" size=4 class="pageNo_input" onkeypress="onlynumber();"/>&nbsp;页
    	<a class="badge badge-inverse" href="javascript:doQuery($('pageNo').value);">跳 转</a>
	</div>
   </c:if>
   <c:if test="${empty page.pageContent}">
   	<script type="text/javascript">
   		alert("没有任何符合条件的商品信息被找到");
   	</script>
   </c:if>
</body>
</html>
