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
        $(function () {
            $('.modal').show();
        })
    </script>
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>维护界面<b class="tip"></b>修改</div>

    <table class="table table-striped table-bordered table-condensed list">
        <thead>
            <tr>
                <td colspan="4"><b>图书基本信息</b></td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>商品号</td>
                <td colspan="3">BOSZ-010-0001-TPB（系统自动生成）</td>
            </tr>
            <tr>
            	  <td>商品名<font color="FF0000">*</font></td>
                <td colspan="3"><input name="Name" value="" type="text" /></td>
                <!--<td width="15%">图书名称<font color="FF0000">*</font></td>
                <td width="500">
                    <input name="Name" value="" type="text" />
                </td>
                <td width="500">图书数量<font color="FF0000">*</font></td>
                <td width="500">
                    <input name="Name" value="" type="text" /></td>-->
            </tr>
            <tr>
            	  <td>商品价格<font color="FF0000">*</font></td>
                <td colspan="3"><input name="Name" value="" type="text" /></td>
                <!--<td>图书类型<font color="FF0000">*</font></td>
                <td>
                    <input name="Name" value="" type="text" /></td>
                <td>本书编号<font color="FF0000">*</font></td>
                <td>
                    <input name="Name" value="" type="text" /></td>-->
            </tr>
            <tr>
            	  <td>商品图片<font color="FF0000">*</font></td>
                <td colspan="3"><img src="<c:url value='/img/1.jpg'/>"/></td>
                <!--<td>所属图书室<font color="FF0000">*</font></td>
                <td>
                    <input name="Name" value="" type="text" />
                </td>
                <td>所属书架<font color="FF0000">*</font></td>
                <td>
                    <input name="Name" value="" type="text" /></td>-->
            </tr>
            <tr>
            	  <td>商品类别<font color="FF0000">*</font></td>
                <td colspan="3">
                    <select name="Address">
                        <option value=" ">A座2楼 </option>
                        <option value=" ">AB座连廊2楼 </option>
                        <option value=" ">A座1楼 </option>
                        <option value=" ">A座4楼 </option>
                        <option value=" ">A座5楼 </option>
                        <option value=" ">A座6楼 </option>
                        <option value=" ">数字园B2座2楼 </option>
                        <option value=" ">数字园B2座3楼 </option>
                        <option value=" ">数字园B2座4楼 </option>
                        <option selected="selected">-=所在地点=-</option>
                    </select>
                </td>
       
            </tr>
            <tr>
                <td width="15%">商品描述</td>
                <td width="500" colspan="3" height="">
                    <textarea name="bak" style="width: 95%" rows="4" cols="5"></textarea>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4">
                    <input class="btn btn-inverse" id="find" type="button" value="保存" />
                    <input class="btn btn-inverse" type="button" value="取消" /></td>
            </tr>
        </tfoot>
    </table>
</body>
</html>
