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
<title>订单统计</title>
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
     <h3>订单统计</h3>
       <div style="width:100%;margin-top:20px">
            
<div style="display:inline">
          <p style="display:inline-block;margin-top:30px"> 
              <span style="margin-left:20px;">预订时间</span>
              <input type="text" class="inpMain Wdate"  readonly="readonly"  style="color:black;width:150px;"   onFocus="WdatePicker({startDate: '%y-%M-%d' })"  placeholder="请输入预订时间最小值进行查询" id="orCreateTime1">~<input type="text" class="inpMain Wdate"  readonly="readonly"  style="color:black;width:150px;"   onFocus="WdatePicker({startDate: '%y-%M-%d' })"  placeholder="请输入预订时间最大值进行查询" id="orCreateTime2">
           </p>
      </div>

<div style="display:inline">
                       <p style="display:inline-block;margin-top:30px">
                                <a href="javascript:;"  class="btnGreen" onclick="orderGather();" style="margin-left:30px;">查询</a>
                        </p>
   </div>
<div id="orderGather" style="width: 1100px;height:400px;margin-top:30px;"></div>

       </div>
 </div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/admin/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/My97DatePicker/4.8/WdatePicker.js"></script> 



<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=4461"></script>

<script type="text/javascript">

 $(function(){
 orderGather();

	 
 });
 

 
 function orderGather() {
	showLoading('${pageContext.request.contextPath}/static/common/loading.gif');	
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/commonapi/orderGather/orderGatherSubmit",
		data : {
					'orcreateTime1':$("#orCreateTime1").val(),
					'orcreateTime2':$("#orCreateTime2").val()	},
	success : function(result) {
		 hideLoading();
  var myChart = echarts.init(document.getElementById('orderGather'));
var option = {
    title : {
        text: '订单统计',
        subtext: '订单统计'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['订单统计']
    },
     toolbox: {
        show : false,
        feature : {
            mark : {show: true},
            magicType : {
            	show: true, 
            	type: ['line', 'bar'],
            	title:['转为折线图','转为柱状图']
            },
            saveAsImage : {
            	show: true,
            	title :'保存为图片'
            }
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLabel : {
                formatter: '{value} '
            }
        }
    ],
    series : [
         {
            name:'订单统计',
            type:'line',
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
  }

    ]
};
 var rsList1X=[];
 var rsList1Y=[];
 for(var i=0;i<result.createTimeXList.length;i++){
   rsList1X.push(result.createTimeXList[i]);
 }
rsList1X.sort((a, b) => a - b);
 for(var i=0;i<rsList1X.length;i++){
 	var isFound=0;
 	for(var j=0;j<result.rsList1.length;j++){
			if(result.rsList1[j].col2==rsList1X[i]){
   			rsList1Y.push(result.rsList1[j].col1);
   			isFound=1;
			}
	 	}
 	if(isFound==0){
 		rsList1Y.push(0);
 	}
 }
   option.xAxis[0].data=rsList1X;
   option.series[0].data=rsList1Y;
myChart.setOption(option);
			}
		});
 }


function gotoPage(e){
	var url = $(e).attr("data-url");
	window.location.href=url;
}



</script>
</body>
</html>