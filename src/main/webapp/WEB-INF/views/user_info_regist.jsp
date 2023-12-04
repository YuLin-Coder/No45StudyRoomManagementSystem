<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>自习室管理系统-用户-注册</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login/css/reset.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/login/css/common.css" />
		
	</head>

	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box" style="width:500px;">	
					
					<div class="login_form" style="padding:15px;">
						<div class="login_title">
							自习室管理系统-用户-注册
						</div>
						<div>
							 <div class="form_check_ipt" style="width:400px;">
								<p>登录名</p>
								<input id="name" name="name" type="text" placeholder="请输入登录名"  class="" style="width:380px;margin-top:5px;height:30px;display:block">
	</div>
							   
							<div class="form_check_ipt" style="width:400px;">
								<p>密码</p>
								<input id="password" name="password" type="password" placeholder="请输入密码"  class="" style="width:380px;margin-top:5px;height:30px;display:block">
	</div><div class="form_check_ipt" style="width:400px;">
								<p>姓名</p>
								<input id="realName" name="realName" type="text" placeholder="请输入姓名"  class="" style="width:380px;margin-top:5px;height:30px;display:block">
	</div><div class="form_check_ipt" style="width:400px;">
								<p>联系电话</p>
								<input id="celPhone" name="celPhone" type="text" placeholder="请输入联系电话"  class="" style="width:380px;margin-top:5px;height:30px;display:block">
	</div>
							
								<div class="form_check_ipt" style="width:400px;height:50px">
								<p>图片验证码</p>
								<input id="imgCode" name="imgCode" type="text" placeholder="验证码"  style="width:300px;margin-top:5px;height:30px;float:left">
								  <img id="codeImg1"  name="codeImg"  style="width:80px;height:30px;float:left;margin-top:5px;" alt="点击更换" title="点击更换" /> 
								</div>
							
							  
							  
						
						
	
	  
							<div class="form_check_ipt"  style="width:400px;height:20px">
								
								<div class="right check_right">
									
								</div>
							</div>
	  
	  
	  
							<div class="form_btn"  style="width:400px;">
								<button type="button" onclick="submitForm()" id="submitBtn">用户-注册</button>
							</div>
							
							<div class="form_reg_btn"  style="width:400px;margin-top:20px">
								<a  style="" href="${pageContext.request.contextPath}/commonapi/sys_login" onclick="">前往登录</a>

							</div>
	
							
							
							
						</div>
						
					</div>
				</div>
			</div>
		</div>
	
	<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=26573"></script>


<script>

	$(document).ready(function(e) {
		changeCode();
		$("#codeImg1").bind("click",changeCode);
		
	});

	function genTimestamp(){
		var time = new Date();
		return time.getTime();
	}
	function changeCode(){
		$("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/commonapi/code?t="+genTimestamp());
	}
 
 
 function submitForm(){
 
		  $.ajax({
			    type: 'post',
			    url: '${pageContext.request.contextPath}/commonapi/userInfoRegistSubmit',
			    data: {
					'name':$("#name").val(),
'password':$("#password").val(),
'realName':$("#realName").val(),
'celPhone':$("#celPhone").val(),
'imgCode':$('#imgCode').val()
			    },
			    success: function(result) {
			    	 
					 		alert(result.msg);
 		if(result.code==1){
 		window.location.href="${pageContext.request.contextPath}/commonapi/sys_login"; 
 	} 

			    	
			    }
			});
 }
 $(function(){
	
 })
 
 
 
 
 
 
 
 
 
 
</script>
</body>
</html>