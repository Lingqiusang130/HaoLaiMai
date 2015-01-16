<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8" />
    <title>后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/admin-all.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/base.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/bootstrap.min.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/Styles/ui-lightness/jquery-ui-1.8.22.custom.css'/>" />
    <script type="text/javascript" src="<c:url value='/Scripts/jquery-1.7.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/Scripts/jquery-ui-1.8.22.custom.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/Scripts/index.js'/>"></script>
</head>
<body>
    <div class="warp">
        <!--头部开始-->
        <div class="top_c">
            <div class="top-nav">欢迎您，${sessionAdmin.adminNickName}！&nbsp;&nbsp;<a target="Conframe" href="<c:url value='/jsps/admin/update_adminpwd.jsp'/>">修改密码</a> | <a href="#">安全退出</a></div>
        </div>
        <!--头部结束-->
        <!--左边菜单开始-->
        <div class="left_c left">
            <h1>好来买系统操作菜单</h1>
            <div class="acc">
                <div>
                    <a class="one">商品管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="<c:url value='/GoodServlet?method=loadPagedGoods'/>">所有商品</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="<c:url value='/GoodServlet?method=toAddGood'/>">添加新商品</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">类别管理</a>
                    <ul class="kid">
						<li><b class="tip"></b><a target="Conframe" href="<c:url value='/CategoryServlet?method=loadAllCategory'/>">所有类别</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="<c:url value='/CategoryServlet?method=toInputCategory'/>">添加新类别</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">订单管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="<c:url value='/jsps/admin/orders/list_all_orders.jsp'/>">所有订单</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="<c:url value='/jsps/admin/orders/list_back_orders.jsp'/>">退货申请处理</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Template/form-tabs.html">订单统计</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">用户管理</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="<c:url value='/jsps/admin/users/list_all_users.jsp'/>">所有用户</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="<c:url value='/jsps/admin/users/list_frozen_users.jsp'/>">冻结用户</a></li>
                    </ul>
                </div>
                <div id="datepicker"></div>
            </div>

        </div>
        <!--左边菜单结束-->
        <!--右边框架开始-->
        <div class="right_c">
            <div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>

        </div>
        <div class="Conframe">
            <iframe name="Conframe" id="Conframe" src="<c:url value="/jsps/admin/welcome.jsp"/>"></iframe>
        </div>
        <!--右边框架结束-->

        <!--底部开始-->
        <div class="bottom_c">Copyright &copy;2014-2015 好来买科技有限公司 版权所有</div>
        <!--底部结束-->
    </div>
</body>
</html>
