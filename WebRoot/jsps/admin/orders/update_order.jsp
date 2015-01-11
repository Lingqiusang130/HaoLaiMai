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
    <div class="alert alert-info">当前位置<b class="tip"></b>订单管理<b class="tip"></b>修改订单</div>

    <table class="table table-striped table-bordered table-condensed list">
        <thead>
            <tr>
                <td colspan="4"><b>订单信息</b></td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>订单号</td>
                <td colspan="3">BOSZ-010-0001-TPB（系统自动生成）</td>
            </tr>
            <tr>
            	<td>商品信息<font color="FF0000">*</font></td>
                <td>商品名</td>
                <td>数量</td>
            </tr>
            <tr>
            	<td>&nbsp;</td>
                <td>小米手机</td>
                <td>2部</td>
            </tr>            
            <tr>
            	<td>订单总价<font color="FF0000">*</font></td>
                <td colspan="3"><input name="Name" value="" type="text" /></td>
            </tr>
            <tr>
            	<td>订单状态<font color="FF0000">*</font></td>
                <td colspan="3">
                    <select name="Address">
                        <option value=" ">未付款 </option>
                        <option value=" ">已付款，未发货 </option>
                        <option value=" ">已发货，未确认收货 </option>
                        <option value=" ">订单成功 </option>
                        <option value=" ">退货中 </option>
                        <option selected="selected">-=订单状态=-</option>
                    </select>
                </td>
       
            </tr>
            <tr>
                <td width="15%">送货地址</td>
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
