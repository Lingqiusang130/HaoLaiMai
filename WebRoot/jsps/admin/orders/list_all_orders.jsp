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
		$(function() {
			$(".datepicker").datepicker();
			$("#change").click(function updateRoom(){
		         location.href='<c:url value="/jsps/admin/orders/update_order.jsp"/>';
		    });
		});
		
	</script>
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>订单管理<b class="tip"></b>所有订单</div>
    <div>
     <span>订单状态：</span>
       <select>
			<option>家用电器</option>
			<option>手机、数码</option>
			<option>电脑、办公</option>
			<option>个户化妆</option>
			<option>运动户外</option>
			<option>营养保健</option>
			<option>彩票、旅行、充值、票务</option>
		</select>
		<span>订单日期：</span>
		<span class="input-append">
			<input class="span2 datepicker" size="16" type="text" /> 
			<span
				class="add-on"> <i class="icon-calendar"></i>
			</span>
		</span>
		<span>订单号：</span>
	    <input type="text" />
	    <input class="btn btn-inverse" id="find" type="button" value="查询" />
    </div>
    <br>
	<table class="table table-striped table-bordered table-condensed" id="list">
        <thead>
            <tr class="tr_detail">
                <td>订单号 </td>
                <td>商品明细</td>
                <td>订单总价</td>
                <td>下单时间</td>
                <td>送货地址 </td>
                <td>订单状态 </td>
                <td>操作 </td>
            </tr>
        </thead>
        <tbody>
            <tr>
            	<!-- 按照这个格式走 -->
                <td><a>HS301-2005000020 </a></td>
                <td><a>小米手机</a></td>
                <td>2300.00 </td>
                <td>2015-1-11 </td>
                <td>福建师范大学软件学院</td>
                <td><font color="FF0000">已付款，已发货，未确认收货</font></td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="" disabled="disabled" value="发货" /></span>
                	<span><input class="btn btn-inverse" id="change" type="button"  value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="" disabled="disabled" value="取消" /></span>
                </td>
            </tr>
            <tr class="even">
                <td><a>HS301-2005000020 </a></td>
                <td>现金</td>
                <td>票据 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td><font color="FF0000">已付款，未发货，未确认收货</font></td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="" value="发货" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" onclick="" disabled="disabled" value="取消" /></span>
                </td>
            </tr>
            <tr>
                <td><a>HS301-2005000020 </a></td>
                <td>CDMA-国内市场部 </td>
                <td>现金 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr class="even">
                <td><a>HS301-2005000020 </a></td>
                <td>银行承兑汇票</td>
                <td>谭晓松 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr>
                <td><a>HS301-2005000020 </a></td>
                <td>银行存款</td>
                <td>谭晓松 </td>
                <td>任务成员 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr class="even">
                <td><a>HS301-2005000020 </a></td>
                <td>1209NewPro</td>
                <td>谭晓松 </td>
                <td>任务成员 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr>
                <td><a>HS301-2005000020 </a></td>
                <td>testqzw</td>
                <td>谭晓松 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr class="even">
                <td><a>HS301-2005000020 </a></td>
                <td>银行存款</td>
                <td>执行中 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr>
                <td><a>HS301-2005000020 </a></td>
                <td>testqzw</td>
                <td>指派中 </td>
                <td></td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr class="even">
                <td><a>HS301-2005000020 </a></td>
                <td>银行承兑汇票</td>
                <td>谭晓松 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr>
                <td><a>HS301-2005000020 </a></td>
                <td>银行承兑汇票</td>
                <td>谭晓松 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr class="even">
                <td><a>HS301-2005000020 </a></td>
                <td>银行承兑汇票</td>
                <td>上级取消 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr>
                <td><a>HS301-2005000020 </a></td>
                <td>银行承兑汇票</td>
                <td>谭晓松 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr class="even">
                <td><a>HS301-2005000020 </a></td>
                <td>银行承兑汇票</td>
                <td>执行中 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr>
                <td><a>HS301-2005000020 </a></td>
                <td>测试产品项目p</td>
                <td>上级取消 </td>
                <td>负责人 </td>
                <td>0.00</td>
                <td>&nbsp;</td>
                <td>
                	<span><input class="btn btn-inverse" id="find" type="button" value="修改" /></span>
                	<span><input class="btn btn-inverse" id="find" type="button" value="删除" /></span>
                </td>
            </tr>
            <tr class="tr_pagenumber">
                <td colspan="100">当前第5页/共55页&nbsp;&nbsp;共650条记录&nbsp;&nbsp;<a class="badge badge-inverse">首页</a>&nbsp;<a class="badge badge-inverse">下一页</a>&nbsp;
                    <a class="badge badge-inverse">1</a>&nbsp;<a class="badge badge-inverse">2</a>&nbsp;<a class="badge badge-inverse">3</a>&nbsp;<a class="badge badge-inverse">4</a>&nbsp;
                    <a class="badge badge-warning">5</a>&nbsp;<a class="badge badge-inverse">...</a>&nbsp;<a class="badge badge-inverse">55</a>&nbsp;<a class="badge badge-inverse">上一页</a>&nbsp;<a class="badge badge-inverse">尾页</a>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
