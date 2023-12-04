<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>ERROR</title>
</head>
<body>
<div style="margin-left:45%;margin-top:10%">
<p><img src="${pageContext.request.contextPath}/static/common/警告.png"></p>
</div>
 <p style="text-align:center;"><a  href="javascript:void(0)" onclick="javascript:history.back(-1);">返回上一页</a>
 <c:if test="${msg=='-1'}">
 登录过期
 </c:if>
 <c:if test="${msg=='-2'}">
 非法操作
 </c:if>
 <c:if test="${msg!='-2' and msg!='-1'}">
 ${msg}
 </c:if>
 <a href="javascript:void(0)" onclick="gotoLogin()">前往登录</a></p>
</body>
<script type="text/javascript">
function gotoLogin(){
	window.open("${pageContext.request.contextPath}/commonapi/login");
}
</script>
</html>
