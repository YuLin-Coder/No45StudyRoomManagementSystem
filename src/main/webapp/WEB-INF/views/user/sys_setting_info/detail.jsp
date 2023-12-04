<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>店铺详情</title>
    <meta name="Copyright" content="" />
    <link href="${pageContext.request.contextPath}/static/admin/css/public.css" rel="stylesheet" type="text/css">
        
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
            tbody>tr>th{
                padding:10px;
            }
            </style>
            </head>
            
            <body style="background-color:white">
            
            <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
            <h3>店铺详情</h3>
            
            <div id="list">
            <div>
            
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic" >
            
            <thead>
            
            </thead>
            <tbody >
            <tr>
            <th width="10%">店铺名</th>
            <th width="90%"  >${setting.shopName}</th>
                </tr>
                <tr>
                <th width="10%">店铺简介</th>
                <th width="90%"  >${setting.shopIntro}</th>
                    </tr>
                    <tr>
                    <th width="10%">地址</th>
                    <th width="90%"  >${setting.address}</th>
                        </tr>
                        <tr>
                        <th width="10%">营业时间</th>
                        <th width="90%"  >${setting.startTime}:00~${setting.endTime}:00</th>
                            </tr>
                            <tr>
                            <th width="10%">价格</th>
                            <th width="90%"  >${setting.price}/小时</th>
                                </tr>
                                
                                </tbody>
                                </table>
                                
                                    
                                    </div>
                                    </div>
                                    
                                    </div>
                                    
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                                        
                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>
                                            
                                            <script type="text/javascript">
                                            
                                            </script>
                                            
                                            </html>
