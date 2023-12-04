<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>桌子</title>
    <meta name="Copyright" content="" />
    <link href="${pageContext.request.contextPath}/static/admin/css/public.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/static/admin/css/modal_css.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
                
                <style type="text/css">
                .btnStyle{
                    margin-left:8px;
                    margin-top:8px
                }
                .loadingModel {
                    position: absolute;
                    top: 0;
                    left: 0;
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
                .action>button{
                    background-color:#5eb95e;
                }
                </style>
                </head>
                
                <body style="background-color:white">
                <div id="loadingDiv"></div>
                <div id="imgModal"></div>
                
                <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
                <h3>桌子</h3>
                <div style="display:block-inline">
                
                        <c:forEach var="item" items="${dl}">
                       <c:if test="${item.deskStatus==1}">
                       <div style="margin-top:20px;margin-left:20px;width:120px;height:120px;background-color:#E1FFFF;color:black;padding:10px;float:left">
                       </c:if>
                       <c:if test="${item.deskStatus==2}">
                       <div style="margin-top:20px;margin-left:20px;width:120px;height:120px;background-color:	#B0C4DE;color:black;padding:10px;float:left">
                       </c:if>
                          
                               <c:if test="${item.deskStatus==1}">
                                <a href="${pageContext.request.contextPath}/user/order_info/order_desk?deskId=${item.id}">
                                  <h3 style="text-align:center">${item.deskNo}</h3> 
                                </a>
                               </c:if>
                                  <c:if test="${item.deskStatus==2}">
                                  <h3 style="text-align:center">${item.deskNo}</h3> 
                               </c:if>
                              
                               <c:if test="${item.deskStatus==1}">
                                 <p style="color:green;text-align:center">当前空闲</p>
                               </c:if>
                                <c:if test="${item.deskStatus==2}">
                                 <p style="color:red;text-align:center">使用中</p>
                               </c:if>
                          </div>
                         
                        </c:forEach>
                        
                        </div>
                        <div style="margin-left:20px;margin-top:10px;">
                        
                        </div>
                        
                        <div style="height:10px"></div>
                        
                        <div class="action">
                        
                        </div>
                        </div>
                        
                        
                        
                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/modal_js.js"></script>
                                    
                                    
                                    
                                    
                                    
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=8306"></script>
                                        
                                        
                                        
                                        <script type="text/javascript">
                                        
                                    
                                                    
                                                    </script>
                                                    
                                                    </body>
                                                    </html>
