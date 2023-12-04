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
                <div>
                
                <div style="display:inline">
                <p style="display:inline-block;margin-top:30px">
                <span style="margin-left:20px;">桌号</span>
                <input type="text" class="inpMain" style="color:black;width:250px;"  placeholder="请输入桌号进行查询" id="deskNo" />
                </p>
                </div>
                
                <div style="display:inline">
                <p style="display:inline-block;margin-top:30px">
                <span style="margin-left:20px;">当前状态</span>
                <select  id="deskStatus" style="height:30px;color:black;width:250px;" >
                <option value="">全部</option>
                <c:forEach items="${deskStatusList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                        </select>
                        
                        </p>
                        </div>
                        
                        <div style="display:inline">
                        <p style="display:inline-block;margin-top:30px">
                        <a href="javascript:;"  class="btnGreen" onclick="ajaxList(1);" style="margin-left:30px;">查询</a>
                        </p>
                        </div>
                        
                        </div>
                        <div style="margin-left:20px;margin-top:10px;">
                        <a href="${pageContext.request.contextPath}/admin/desk_info/add" class="btnGreen">新增</a>
                            
                            </div>
                            
                            <div style="height:10px"></div>
                            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic"  style="">
                            
                            <thead>
                            <tr>
                            <th>桌号</th>
                            <th>当前状态</th>
                            <th style="width:200px;">操作</th>
                            
                            </tr>
                            </thead>
                            <tbody id="desk_info_body">
                            
                            </tbody>
                            </table>
                            <div id="desk_info_bar" class="pagination" style="margin-top:20px;"></div>
                            
                            <div class="action">
                            
                            </div>
                            </div>
                            
                            
                            
                            <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
                                <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
                                    <script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/js/modal_js.js"></script>
                                        
                                        
                                        
                                        
                                        
                                        <script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=9541"></script>
                                            
                                            
                                            
                                            <script type="text/javascript">
                                            
                                            $(function(){
                                                
                                                ajaxList(1);
                                                
                                                
                                            });
                                            
                                            function ajaxList(page) {
                                                var deskNo = $("#deskNo").val();
                                                var deskStatus = $("#deskStatus").val();
                                                
                                                
                                                showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
                                                    $.ajax({
                                                        type : 'get',
                                                        url : "${pageContext.request.contextPath}/admin/desk_info/queryList",
                                                            data : {
                                                                
                                                                "page":page,
                                                                "deskNo":deskNo,
                                                                "deskStatus":deskStatus
                                                                
                                                            },
                                                            success : function(result) {
                                                                hideLoading();
                                                                var rows = result.list;//得到数据列
                                                                var total = result.count;//得到数据总数
                                                                lastPage=result.totalPage;
                                                                totalCount=total;
                                                                var html = '';
                                                                for (var i = 0; i < rows.length; i++) {
                                                                    html += '<tr>' ;
                                                                    var deskNoVal=setNullToEmpty(rows[i].deskInfo.deskNo);
                                                                    html+='<td>'+ deskNoVal+'</td>';
                                                                    var deskStatusVal=setNullToEmpty(rows[i].deskStatusStr);
                                                                    if(rows[i].deskInfo.deskStatus=='1'){
                                                                        deskStatusVal ='<span style="background-color:green;color:white;padding:3px">'+deskStatusVal+'</span>'
                                                                    }
                                                                    if(rows[i].deskInfo.deskStatus=='2'){
                                                                        deskStatusVal ='<span style="background-color:orange;color:white;padding:3px">'+deskStatusVal+'</span>'
                                                                    }
                                                                    html+='<td>'+deskStatusVal+'</td>';
                                                                    html+='<td>';
                                                                    html+='<a href="${pageContext.request.contextPath}/admin/desk_info/update?id='+rows[i].deskInfo.id+'" class="btn btnStyle">修改</a>';
                                                                        html+='<a href="javascript:void(0)" onclick="del(this)" data-id="'+rows[i].deskInfo.id+'" class="btnPayment btnStyle">删除</a>';
                                                                        html+='</td>';
                                                                        html+='</tr>';
                                                                    }
                                                                    if (rows.length == 0) {
                                                                        html += '<tr><td></td><td>无数据</td><td></td></tr>';
                                                                    }
                                                                    $("#desk_info_body").html(html);
                                                                    
                                                                    
                                                                    new myPagination({
                                                                        id: 'desk_info_bar',
                                                                        curPage:page, //初始页码
                                                                        pageTotal: result.totalPage, //总页数
                                                                        pageAmount: 10,  //每页多少条
                                                                        dataTotal: total, //总共多少条数据
                                                                        pageSize: 5, //可选,分页个数
                                                                        showPageTotalFlag:true, //是否显示数据统计
                                                                        showSkipInputFlag:false, //是否支持跳转
                                                                        getPage: function (page) {
                                                                            ajaxList(page);
                                                                        }
                                                                    })
                                                                    
                                                                }
                                                            });
                                                        }
                                                        
                                                        function del(e){
                                                            if(window.confirm('你确定要删除该桌子吗')){
                                                                var id = $(e).attr("data-id");
                                                                $.ajax({
                                                                    type : 'get',
                                                                    url : "${pageContext.request.contextPath}/admin/desk_info/del",
                                                                        data : {
                                                                            "id":id
                                                                        },
                                                                        success : function(result) {
                                                                            alert(result.msg);
                                                                            if(result.code==1){
                                                                                ajaxList(1);
                                                                            }
                                                                        }
                                                                    });
                                                                    return true;
                                                                    }else{
                                                                        return false;
                                                                    }
                                                                }
                                                                
                                                                
                                                                function gotoPage(e){
                                                                    
                                                                    var url = $(e).attr("data-url");
                                                                    window.location.href=url;
                                                                }
                                                                
                                                                </script>
                                                                
                                                                </body>
                                                                </html>
