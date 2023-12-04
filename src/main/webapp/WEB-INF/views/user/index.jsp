<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
var uri='${uri}';
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自习室管理系统</title>
<meta name="keywords" content="自习室管理系统" /> 
<meta name="description" content="自习室管理系统。" /> 
<meta name="Copyright" content="自习室管理系统." />
<link href="${pageContext.request.contextPath}/static/admin/css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/global.js"></script>
</head>

<body>
<div id="dcWrap">
 <div id="dcHead">
 <div id="head">
  <div class="logo"><a  href="#" style="color:white;position:relative;top:5px;left:30px;font-size:24px;">自习室管理系统</a></div>
  <div class="nav">
 
   <ul class="navRight">
   
    
   
   
   
    <li class="M noLeft"><a href="JavaScript:void(0);">您好，${login.name}</a></li>
  <li class="M noLeft"><a href="JavaScript:void(0);"  onclick="alterPassword()">修改密码</a></li>
	
    <li class="noRight"><a href="${pageContext.request.contextPath}/commonapi/sys_logout">退出</a></li>
    <li class="noRight"><a href="https://armycodes.com/">从戎源码网</a></li>
   </ul>
  </div>
 </div>
</div>
<!-- dcHead 结束 --> <div id="dcLeft"><div id="menu">

 <ul>
  <li style="background-color:#dddddd"><a href="javascript:void(0)"><em>个人信息 </em></a></li>
 </ul>
 <ul>
  
  <li>
  
   <a  data-name="个人信息"    data-href="${pageContext.request.contextPath}/user/user_info/detail" href="javascript:void(0)" onclick="goPage(this)" style="text-align:center"><em>个人信息  </em></a>
   
  </li>
  
    <li>
  
   <a  data-name="充值记录"    data-href="${pageContext.request.contextPath}/user/deposit_log" href="javascript:void(0)" onclick="goPage(this)" style="text-align:center"><em>充值记录  </em></a>
   
  </li>
  
 </ul><ul>
  <li style="background-color:#dddddd"><a href="javascript:void(0)"><em>店铺信息 </em></a></li>
 </ul>
 <ul>
  
  <li>
  
   <a  data-name="店铺信息"    data-href="${pageContext.request.contextPath}/user/sys_setting_info" href="javascript:void(0)" onclick="goPage(this)" style="text-align:center"><em>店铺信息  </em></a>
   
  </li>
  
 </ul><ul>
  <li style="background-color:#dddddd"><a href="javascript:void(0)"><em>桌子预约 </em></a></li>
 </ul>
 <ul>
  
  <li>
  
   <a  data-name="桌子预约"    data-href="${pageContext.request.contextPath}/user/desk_info" href="javascript:void(0)" onclick="goPage(this)" style="text-align:center"><em>桌子预约  </em></a>
   
  </li>
  
 </ul><ul>
  <li style="background-color:#dddddd"><a href="javascript:void(0)"><em>订单 </em></a></li>
 </ul>
 <ul>
  
  <li>
  
   <a  data-name="我的订单"    data-href="${pageContext.request.contextPath}/user/order_info" href="javascript:void(0)" onclick="goPage(this)" style="text-align:center"><em>我的订单  </em></a>
   
  </li>
  
 </ul><ul>
  <li style="background-color:#dddddd"><a href="javascript:void(0)"><em>统计分析 </em></a></li>
 </ul>
 <ul>
  
  <li>
  
   <a  data-name="学习时间统计"    data-href="${pageContext.request.contextPath}/commonapi/studyGather/studyGather" href="javascript:void(0)" onclick="goPage(this)" style="text-align:center"><em>学习时间统计  </em></a>
   
  </li>
  
 </ul>


   
  
</div></div>
 <div id="dcMain"> 
    <iframe src="${pageContext.request.contextPath}/user/user_info/detail" frameborder="0" id="iframDiv" style="padding: 15px;min-height:850px;width:100%"></iframe>
 </div>
 

 </div>

<script type="text/javascript">

	$(function(){
		
	});




	


function goPage(e){
	var url = $(e).attr("data-href");
	$('#iframDiv').attr('src', url);
}

function alterPassword(){
	 $('#iframDiv').attr('src', "${pageContext.request.contextPath}/commonapi/alterPassword");
}




</script>


</body>
</html>