<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改-系统设置 </title>
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
                    
                    <div id="mMain">
                    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
                    <h3>修改-系统设置</h3>
                    
                    <div class="system">
                    <div>
                    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                    
                    
                    <tr  id="startTimeParentContent">
                    <td align="right">开始时间</td>
                    <td >
                    <div style="width:720px;">  <input type="text" class="inpMain" style="color:black;width:500px;" value="${data.startTime}" placeholder="请输入开始时间（请输入数字）" id="startTime" />	<span style="color:red">*必填</span>
                        </div>
                        </td>
                        </tr>
                        
                        <tr  id="endTimeParentContent">
                        <td align="right">结束时间</td>
                        <td >
                        <div style="width:720px;">  <input type="text" class="inpMain" style="color:black;width:500px;" value="${data.endTime}" placeholder="请输入结束时间（请输入数字）" id="endTime" />	<span style="color:red">*必填</span>
                            </div>
                            </td>
                            </tr>
                            
                            <tr  id="priceParentContent">
                            <td align="right">价格</td>
                            <td >
                            <div style="width:720px;">  <input type="text" class="inpMain" style="color:black;width:500px;" value="${data.price}" placeholder="请输入价格（请输入数字）" id="price" />	<span style="color:red">*必填</span>
                                </div>
                                </td>
                                </tr>
                                
                                <tr  id="shopNameParentContent">
                                <td align="right">店铺名</td>
                                <td >
                                <div style="width:720px;">  <input type="text" class="inpMain" style="color:black;width:500px;" value="${data.shopName}" placeholder="请输入店铺名" id="shopName" />	<span style="color:red">*必填</span>
                                    </div>
                                    </td>
                                    </tr>
                                    
                                    <tr  id="shopIntroParentContent">
                                    <td align="right">简介</td>
                                    <td >
                                    <div style="width:720px;">  <textarea  placeholder="请输入简介"  id="shopIntro"  rows="15" cols="100">${data.shopIntro}</textarea>	<span style="color:red">*必填</span>
                                        </div>
                                        </td>
                                        </tr>
                                        
                                        <tr  id="addressParentContent">
                                        <td align="right">地址</td>
                                        <td >
                                        <div style="width:720px;">  <input type="text" class="inpMain" style="color:black;width:500px;" value="${data.address}" placeholder="请输入地址" id="address" />	<span style="color:red">*必填</span>
                                            </div>
                                            </td>
                                            </tr>
                                            
                                            
                                            <tr>
                                            <td width="131"></td>
                                            <td>
                                            
                                            <a class="btnGreen" href="javascript:;" onclick="submitData();" style="margin-left:30px;">提交</a>
                                            <a class="btnGray" href="javascript:;"  onclick="javascript:history.back(-1);" style="margin-left:30px;">返回上一步</a>
                                            </td>
                                            </tr>
                                            </table>
                                            <div style="height:200px"></div>
                                            </div>
                                            </div>
                                            </div>
                                            </div>
                                            
                                            
                                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                                                
                                                
                                                
                                                
                                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=4909"></script>
                                                    
                                                    
                                                    <script type="text/javascript">
                                                    
                                                    
                                                    
                                                    $(function(){
                                                        
                                                        
                                                        
                                                    })
                                                    
                                                    
                                                    
                                                    function submitData(){
                                                        var startTime= $('#startTime').val();
                                                        var endTime= $('#endTime').val();
                                                        var price= $('#price').val();
                                                        var shopName= $('#shopName').val();
                                                        var shopIntro= $('#shopIntro').val();
                                                        var address= $('#address').val();
                                                        
                                                        if(startTime!=''){
                                                            if(isIntNum(startTime)==false){
                                                                alert("开始时间必须填入整数");
                                                                return;
                                                            }
                                                        }
                                                        if(endTime!=''){
                                                            if(isIntNum(endTime)==false){
                                                                alert("结束时间必须填入整数");
                                                                return;
                                                            }
                                                        }
                                                        if(price!=''){
                                                            if(isNum(price)==false){
                                                                alert("价格必须填入数字");
                                                                return;
                                                            }
                                                        }
                                                        $.ajax({
                                                            type: 'post',
                                                            url: '${pageContext.request.contextPath}/admin/sys_setting_info/update_submit',
                                                                data:{
                                                                    "id":'${data.id}',
                                                                        
                                                                        "startTime":startTime,
                                                                        "endTime":endTime,
                                                                        "price":price,
                                                                        "shopName":shopName,
                                                                        "shopIntro":shopIntro,
                                                                        "address":address
                                                                    },
                                                                    success: function(result) {
                                                                        if(result.code == 0){
                                                                            alert(result.msg);
                                                                            }else{
                                                                                alert(result.msg);
                                                                                self.location=document.referrer;
                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                                
                                                                
                                                                
                                                                </script>
                                                                </body>
                                                                </html>
