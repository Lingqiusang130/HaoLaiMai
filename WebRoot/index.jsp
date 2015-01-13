<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<title>全国省市县无刷新多级关联菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<head>
	<script type="text/javascript">
		function Dsy()
		{
		 this.Items = {};
		}
		Dsy.prototype.add = function(id,iArray)
		{
		 this.Items[id] = iArray;
		};
		Dsy.prototype.Exists = function(id)
		{
		 if(typeof(this.Items[id]) == "undefined") return false;
		 return true;
		};
		function change(v){
		 var str="0";
		 for(var i=0;i<v;i++){ str+=("_"+(document.getElementById(s[i]).selectedIndex-1));};
		 var ss=document.getElementById(s[v]);
		 with(ss){
		  length = 0;
		  options[0]=new Option(opt0[v],opt0[v]);
		  if(v && document.getElementById(s[v-1]).selectedIndex>0 || !v)
		  {
		   if(dsy.Exists(str)){
		    ar = dsy.Items[str];
		    for(var i=0;i<ar.length;i++)options[length]=new Option(ar[i],ar[i]);
		    if(v)options[1].selected = true;
		   }
		  }
		  if(++v<s.length){change(v);}
		 }
		}
		var dsy = new Dsy();
		dsy.add("0",["安徽","北京","福建","甘肃","广东","广西","贵州","海南","河北","河南","黑龙江","湖北","湖南","吉林","江苏","江西","辽宁","内蒙古","宁夏","青海","山东","山西","陕西","上海","四川","天津","西藏","新疆","云南","浙江","重庆"]);
		dsy.add("0_0",["安庆","蚌埠","巢湖","池州","滁州","阜阳","合肥","淮北","淮南","黄山","六安","马鞍山","宿州","铜陵","芜湖","宣城","亳州"]);
		dsy.add("0_1",["安庆1","蚌埠","巢湖","池州","滁州","阜阳","合肥","淮北","淮南","黄山","六安","马鞍山","宿州","铜陵","芜湖","宣城","亳州"]);
		dsy.add("0_2",["安庆2","蚌埠","巢湖","池州","滁州","阜阳","合肥","淮北","淮南","黄山","六安","马鞍山","宿州","铜陵","芜湖","宣城","亳州"]);
		dsy.add("0_3",["安庆3","蚌埠","巢湖","池州","滁州","阜阳","合肥","淮北","淮南","黄山","六安","马鞍山","宿州","铜陵","芜湖","宣城","亳州"]);
	</script>
	<script type="text/javascript">
		var s=["s2","s25"];
		var opt0 = ["-省份-","-直辖市-"];
		function setup()
		{
		 for(var i=0;i<s.length-1;i++)
		  document.getElementById(s[i]).onchange=new Function("change("+(i+1)+")");
		 change(0);
		}
	</script>
</head>
<body onload="setup()">
	<div>
		<select id="s2"><option>省份</option></select>
	</div>
	<div>
		<select id="s25"><option>直辖市</option></select>
	</div>
</body>
</html>
