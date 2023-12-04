/**
 * Created by Administrator on 2017/6/12.
 */
var ID;
function tableLoad(){
    $('#table').bootstrapTable({
        method: "get",
        url: "json/car.json",
        striped: true,
        singleSelect: false,
        dataType: "json",
        pagination: true, //分页
        pageSize: 10,
        pageNumber: 1,
        search: false, //显示搜索框
        contentType: "application/x-www-form-urlencoded",
        queryParams: queryParams,
        columns: [

            {
                checkbox: "true",
                field: 'check',
                align: 'center',
                valign: 'middle'
            }
            ,
            {
                title: '序号',
                field: 'id',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '车牌号',
                field: 'name',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '车辆类型',
                field: 'type',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '车辆状态',
                field: 'sta',
                align: 'center',
                valign: 'middle',
                formatter:function (value,row) {
                    if(value=='可使用'){
                        return '<font color="green">'+value+'</font>';
                    }
                    else{
                        return '<font color="red">'+value+'</font>';
                    }

                }
            },
            {
                title: '工作状态',
                field: 'work',
                align: 'center',
                valign: 'middle',
                formatter:function (value,row) {
                    if(value=='未工作'){
                        return '<font color="#999">'+value+'</font>';
                    }
                    else{
                        return value;
                    }

                }
            },
            {
                title: '公里数',
                field: 'rode',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '违规次数',
                field: 'num',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '购买时间',
                field: 'time',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '油量变化情况',
                field: 'change',
                align: 'center',
                valign: 'middle',
                formatter:function (val,row) {
                    if(val=='不正常'){
                        return '<div style="color: #ff7f2c;font-weight: bold">'+val+'</div>';
                    }
                    else{
                        return val;
                    }

                }
            },

            {
                title: '所属区域',
                field: 'loca',
                align: 'center'
            },
            {
                title: '操作',
                field: '',
                align: 'center',
                formatter: function (value, row) {
                    var  e = '<a  id="add" data-id="98"  onclick="carLine(\'' + row.id + '\')">轨迹</a> ';
                    var  c = '<a  id="add" data-id="98" onclick="testdel(\'' + row.id + '\')">定位</a> ';
                    var  d = '<a  id="add" data-id="98" onclick="carRecode(\'' + row.id + '\')">任务列表</a> ';
                    var  f = '<a  id="add" data-id="98" onclick="carSta(\'' + row.id + '\')">油耗监控</a> ';
                    return e+c+d+f;
                }
            }
        ]
    });
}

function queryParams(params) {
    return {
        page: params.pageNumber,
        rows: params.limit,//页码大小
        order: params.order,
        sort: params.sort,
        SendPeople: $("#person").val(),
        Title: $("#tit").val(),
        BeginSendTime: $("#beginSendTime").val(),
        EndSendTime: $("#endSendTime").val()
    };
}

//数据的查询
function checkPersonData() {
    $("#table").bootstrapTable('refresh');
}

//数据的删除
function del(id){
    if(confirm("你确定要删除吗？")){
        var personId = id;
        $.ajax({
            url: '/OAMessagePush/Delete?Ids=' + personId,
            type: 'post',
            dataType: 'json',
            success: function (result) {
                var result = handleError(result);
                if (result.IsError) {
                    return;
                }
                else {
                    checkPersonData();
                }
            }
        })
    }

}


//批量数据的删除
function delAll(){
    var idArray = $('#table').bootstrapTable('getSelections');
    if(idArray == null || idArray.length ==0){
        alert("请选择你要删除的类容!");
        return false;
    }else {
        var personID = [];
        for(var i=0;i<idArray.length;i++){
            personID.push(idArray[i].id);
        }
        //$.each(idArray, function (index, row) {
        //    personID.push(row.Id);
        //});
        if(confirm("删除将无法恢复，你确定删除吗？")){
            $.ajax({
                url: '/OAMessagePush/Delete?Ids=' + personID.join(","),
                type: 'post',
                dataType: 'json',
                success: function (result) {
                    var result = handleError(result);
                    if (result.IsError) {
                        return;
                    }
                    else {
                        checkPersonData();
                    }
                }
            })
        }
    }


}


function add() {
    openlayer();
    ID = "";
}
//编辑操作
function edit(id) {
    ID = id;
    openlayer()
}

function openlayer() {
    layer.open({
        type: 2,
        title: '车辆信息',
        shade: 0.5,
        skin: 'layui-layer-rim',
        area: ['98%', '98%'],
        shadeClose: true,
        closeBtn: 1,
        content: 'carTail.html'
    });
}
function carLine() {
    layer.open({
        type: 2,
        title: '车辆轨迹',
        shade: 0.5,
        skin: 'layui-layer-rim',
        area: ['760px', '550px'],
        shadeClose: true,
        closeBtn: 1,
        content: 'carLine.html'
    });
}
function carRecode() {
    layer.open({
        type: 2,
        title: '任务列表',
        shade: 0.5,
        skin: 'layui-layer-rim',
        area: ['96%', '550px'],
        shadeClose: true,
        closeBtn: 1,
        content: 'carRecode.html'
    });
}
function carSta() {
    layer.open({
        type: 2,
        title: '耗油监控',
        shade: 0.5,
        skin: 'layui-layer-rim',
        area: ['96%', '96%'],
        shadeClose: true,
        closeBtn: 1,
        content: 'carYouSta.html'
    });
}
// function openlayer() {
//     var Name = "车辆";
//     var Href = "carTail.html";
//     var data_id = $("#add").attr('data-id');
//     window.parent.$.learuntab.myAddTab(Name, Href, data_id);
// }
//取消操作
function cancel() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}


// 测试删除全部
function testdelAll(){
    var idArray = $('#table').bootstrapTable('getSelections');
    if(idArray == null || idArray.length ==0){
        alert("请选择你要删除的类容!");
        return false;
    }else {
        var personID = [];
        for(var i=0;i<idArray.length;i++){
            personID.push(idArray[i].id);
        }
        //$.each(idArray, function (index, row) {
        //    personID.push(row.Id);
        //});
        if(confirm("删除将无法恢复，你确定删除吗？")){
            alert("删除成功");
        }
    }


}
//测试数据的删除
function testdel(id){
    if(confirm("你确定要删除吗？")){
        alert("删除成功");
    }

}