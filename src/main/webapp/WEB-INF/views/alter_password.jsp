<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<meta name="Copyright" content="Douco Design." />
<link href="${pageContext.request.contextPath}/static/admin/css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/global.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/jquery.tab.js"></script>
<style type="text/css">

	    .loadingModel {
            position: absolute;
            top: 0;
            left: 0;
            display: none;
            background-color: rgba(9, 9, 9, 0.63);
            width: 100%;
            height: 100%;
            z-index: 1000;
        }
        .loading-content {
            width: 50%;
            text-align: center;
            background: #ffffff;
            border-radius: 6px;
            line-height: 30px;
            z-index: 10001;
        }
</style>
</head>

<body style="background-color:white">

    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
          <h3>修改密码</h3>
     <div class="system">
      <div>
       <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
       
	     <tr>
         <td align="right">账号名</td>
         <td>
            ${login.name}
        </td>
        </tr>
		
		
		 <tr>
         <td align="right">旧密码</td>
         <td>
            <input class="inpMain"  type="password" placeholder="原密码"  id="password1" />
        </td>
        </tr>
		
		 <tr>
         <td align="right">新密码</td>
         <td>
            <input class="inpMain"  type="password" placeholder="新密码"  id="password2" />
        </td>
        </tr>
		
		 <tr>
         <td align="right">新密码</td>
         <td>
            <input class="inpMain"  type="password" placeholder="再次输入新密码"  id="password3" />
        </td>
        </tr>
		

           <tr>
         <td width="131"></td>
         <td>
          
		   <a class="btnGreen" href="javascript:;" onclick="alterPassword();" style="margin-left:30px">提交</a>
		   <a class="btnGray" href="javascript:;"  onclick="javascript:history.back(-1);" style="margin-left:30px">返回上一页</a>
         </td>
        </tr>
       </table>
      </div>
     </div>
 
 
    </div>
   
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>

<script type="text/javascript">
function alterPassword(){
var password1 = $("#password1").val();
var password2 = $("#password2").val();
var password3 = $("#password3").val();
	$.ajax({
	    type: 'post',
	    dataType : "json",
	    url: '${pageContext.request.contextPath}/commonapi/alterPassword/submit',
	    data:{
	    	"password1":password1,
	    	"password2":password2,
	    	"password3":password3
	    },
	    success: function(result) {
	    	if(result.code == 0){
	    		alert(result.msg);
			}else{
				alert(result.msg);
			}
	    }
	}); 
}
</script>
</body>
</html>