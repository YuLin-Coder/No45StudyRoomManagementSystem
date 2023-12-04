function setNullToEmpty(val){//将所有空数据都转为'-'
		if(val===null||val==='null'||val===''||val==undefined||val=='undefined'){
		return '-';
		}
		return val;
	}




function isIntNum(s){//是否为正整数
	var re = /^[0-9]*[1-9][0-9]*$/ ;
	if(s=='0'){
		return true;
	}
	return re.test(s)
}
function isNum(val){
	if(isNaN(val)==true){
		return false;
	}else{
		return true;
	}
}

function maxImg(e){
                                                                                        					var imgUrl = $(e).attr("src");
                                                                                        					var html='';
                                                                                        					html+='<div class="modal-box">';
                                                                                        					html+='<div class="modal-box-top">';
                                                                                        					html+='<div class="modal-box-title">查看图片</div>';
                                                                                        					html+='<button onclick="modalClose()" class="modal-close">×';
                                                                                        					html+='</button>';
                                                                                        					html+='</div>';
                                                                                        					html+='<div class="modal-box-content">';
                                                                                        					html+='<img src="'+imgUrl+'" style="width:95%;height:95%">';
                                                                                        					html+='</div>';
                                                                                        					html+='<div class="modal-box-bottom">';
                                                                                        					html+='</div>';
                                                                                        					html+='</div>';
                                                                                        					$("#imgModal").html(html);
                                                                                        					
                                                                                        					modalOpen();
                                                                                        				}
                                                                                        				
                                                                                        				
                                                                                        				function maxQrcode(e){
                                                                                        					var content =$(e).attr("data-content");
                                                                                        					var html='';
                                                                                        					html+='<div class="modal-box">';
                                                                                        					html+='<div class="modal-box-top">';
                                                                                        					html+='<div class="modal-box-title">查看二维码</div>';
                                                                                        					html+='<button onclick="modalClose()" class="modal-close">×';
                                                                                        					html+='</button>';
                                                                                        					html+='</div>';
                                                                                        					html+='<div class="modal-box-content">';
                                                                                        					html+='<div style="margin-left:25px" ><div style="width:100%"id="maxQrcodeDiv"></div></div>';
                                                                                        					html+='</div>';
                                                                                        					html+='<div class="modal-box-bottom">';
                                                                                        					html+='</div>';
                                                                                        					html+='</div>';
                                                                                        					$("#imgModal").html(html);
                                                                                        					  new QRCode('maxQrcodeDiv', {
                                                                                        					   	  text: content,
                                                                                        					   	  width: 400,
                                                                                        					   	  height: 400,
                                                                                        					   	  colorDark : '#000000',
                                                                                        					   	  colorLight : '#ffffff',
                                                                                        					   	  correctLevel : QRCode.CorrectLevel.H
                                                                                        					   	});
                                                                                        					modalOpen();
                                                                                        				}

	function getCheckBoxVal(boxName){
		var valTmp = $("input[name='"+boxName+"']");
		var val ='';
		for(var i=0;i<valTmp.length;i++){
			if($(valTmp[i]).prop("checked")==true){
				val+=$(valTmp[i]).val()+",";
			}
		}
		if(val!=''){
			val = val.substring(0,val.length-1);
		}
		return val;
	}
	function showLoading(imgPath){
		var html=' <p class="loadingModel">'
				+'   <p class="loading-content">'
				+'	<p style="text-align:center;z-index:10003;position:fixed;top:50%;left:50%"><img src="'+imgPath+'"></p>   '
				+'   </p>'
				+' </p>';
		$("#loadingDiv").html(html);
	}
	function hideLoading(){
		$("#loadingDiv").html('');
	}
	 function getTimeList(startTime,endTime,df,type){
		var list=[];
		var tmp = startTime;
		 while(true){
			 if(tmp<endTime){
				 var flag=false;
				 for(var i=0;i<list.length;i++){ 
					 if(list[i]==tmp){
						 flag=true;
					 }
				 }
				 if(flag==false){
					 list.push(tmp);	 
				 }
				 tmp = getDiffTime(tmp,1,df,type);
			 }else{
				 break;
			 }
		 }
		 var flag2=false;
		 for(var i=0;i<list.length;i++){ 
			 if(list[i]==endTime){
				 flag2=true;
			 }
		 }
		 if(flag2==false){
			 list.push(endTime);	 
		 }
		 return list;
	 }
	 function getDiffTime(date,diff,df,type){
		 var time = transferToTime(date);
		if(type==1){//年份
			time.setFullYear(time.getFullYear()+diff);
		}else if(type==2){//月份
			time.setMonth(time.getMonth()+diff); 
		}else if(type==3){//日期
			time.setDate(time.getDate()+diff); 
		}else if(type==4){//小时
			time.setHours(time.getHours()+diff); 
		}else if(type==5){//分钟
			time.setMinutes(time.getMinutes()+diff); 
		}else if(type==6){//秒
			time.setSeconds(time.getSeconds()+diff); 
		}	
		 return getTime(time,df);
	 }
	 function transferToTime(date){
		 date = date.replace(/-/g,'/'); //必须把日期'-'转为'/'
		 date = date.replace(/年/g,'/'); //必须把日期'-'转为'/'
		 date = date.replace(/月/g,'/'); //必须把日期'-'转为'/'
		 date = date.replace(/日/g,'/'); //必须把日期'-'转为'/'
		 date = date.replace(/时/g,':'); //必须把日期'-'转为'/'
		 date = date.replace(/分/g,':'); //必须把日期'-'转为'/'
		 date = date.replace(/秒/g,''); //必须把日期'-'转为'/'
		 var timestamp = new Date(date).getTime();
		return new Date(timestamp);
	 }
	 function getTime(date,fmt){
		 var o = {
			        "M+": date.getMonth() + 1, //月份 
			        "d+": date.getDate(), //日 
			        "H+": date.getHours(), //小时 
			        "m+": date.getMinutes(), //分 
			        "s+": date.getSeconds(), //秒 
			        "q+": Math.floor((date.getMonth() + 3) / 3), //季度 
			        "S": date.getMilliseconds() //毫秒 
			    };
			    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
			    for (var k in o)
			    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
			    return fmt;
	 }
