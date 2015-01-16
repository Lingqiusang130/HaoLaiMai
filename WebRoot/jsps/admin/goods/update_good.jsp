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
    <script type="text/javascript" src="<c:url value='/Scripts/admin/addgood.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/ui-lightness/jquery-ui-1.8.22.custom.css'/>" />
	<script type="text/javascript">
		function changeImage(elementId)
		{
			return document.getElementById(elementId);
		}
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
					  var cids="${good.category.cateId}";
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
		//菜单二级联动
		function getKind(){ 
			var i=0;
			var j=0;			
			//获得商品大类别下拉框的对象  
			var categoryIdB=document.addGoodForm.categoryIdB;
			//获得商品小类别下拉框的对象  
			var categoryIdS=document.addGoodForm.categoryIdS;
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
<body onload="load();">
    <div class="alert alert-info">当前位置<b class="tip"></b>商品管理<b class="tip"></b>添加新商品</div>
	<form action="<c:url value='/GoodServlet'/>" method="post" enctype="multipart/form-data" id="addGoodForm" name="addGoodForm">
		<input type="hidden" name="method" value="updateGood" />
		<input type="hidden" name="goodId" id="goodId" value="${good.goodId}"/>
	    <table class="table table-striped table-bordered table-condensed list">
	        <thead>
	            <tr>
	                <td colspan="4"><b>商品信息</b></td>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr>
	            	<td>商品号<font color="FF0000">*</font></td>
	                <td colspan="3">${good.goodId}</td>	                
	            </tr>
	            <tr>
	            	<td>商品名<font color="FF0000">*</font></td>
	                <td colspan="3">
	                	<input name="goodName" id="goodName" class="inputClass" type="text" value="${good.goodName}"/>
	                	<a style='text-decoration:none;' class="error" id="goodNameError" name="goodNameError"></a>
	                </td>
	            </tr>
	            <tr>
	            	<td>商品价格<font color="FF0000">*</font></td>
	                <td colspan="3">
	                	<input name="goodPrice" id="goodPrice" class="input" value="${good.goodPrice}" type="text" />
	                	<a style='text-decoration:none;' class="error" id="goodPriceError" name="goodPriceError"></a>
	                </td>
	            </tr>
	            <tr>
	            	<td>商品图片<font color="FF0000">*</font></td>
	                <td colspan="3">
	                	<img width="240" height="150" id="goodPic" src="<c:url value='/GoodServlet'/>?method=getpic&goodId=${good.goodId}" />
	                	<div><br/><input type="file" name="goodImage" id="goodImage" class="input" size="80" onchange="changeImage('goodPic').src=this.value;"/></div>
	                </td>
	            </tr>
	            <tr>
	            	<td>商品大类别<font color="FF0000">*</font></td>
	                <td colspan="3">
	                    <select name="categoryIdB" id="categoryIdB" class="select" onchange="getKind()" >
	                        <option value="0">==商品大类别== </option>
							<c:forEach items="${parents}" var="parent">
				            <option value="${parent.cateId}" <c:if test="${good.category.parent.cateId==parent.cateId}">selected</c:if> >${parent.cateName}</option>  
				            </c:forEach>
	                    </select>
	                </td>  
	            </tr>
	            <tr>
	            	<td>商品小类别<font color="FF0000">*</font></td>
	                <td colspan="3">
	                    <select name="categoryIdS" id="categoryIdS" class="select">
	                        <option value="0" selected="selected">==商品小类别==</option>
	                    </select>
	                    <a style='text-decoration:none;' class="error" id="categoryIdSError" name="categoryIdSError"></a>
	                </td>  
	            </tr>
	            <tr>
	                <td width="15%">商品描述</td>
	                <td width="500" colspan="3" height="">
	                    <textarea name="description" id="description"style="width: 95%" rows="4" cols="5">${good.description}</textarea>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	    <input class="btn btn-inverse" id="find" type="submit" value="保存" />
	    <input class="btn btn-inverse" type="button" value="取消" />
    </form>
</body>
</html>
