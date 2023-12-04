/**
 * Created by Administrator on 2017/6/12.
 */
var ID;
function tableLoad(){
    $('#table').bootstrapTable({
        method: "get",
        url: "json/rube.json",
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
                title: '编号',
                field: 'num',
                align: 'center',
                valign: 'middle'
            },

            {
                title: '类型',
                field: 'name',
                align: 'center'
            },
            {
                title: '状态',
                field: 'type',
                align: 'center',
                formatter:function (val,row) {
                    if(val=='不可用'){
                        return '<font color="red">'+val+'</font>'
                    }
                    else{
                        return val;
                    }


                }
            },
            {
                title: '所属机构',
                field: 'org',
                align: 'center'
            },
            {
                title: '所在位置',
                field: 'loca',
                align: 'center'
            },
            {
                title: '材质',
                field: 'con',
                align: 'center'
            },
            {
                title: '颜色',
                field: 'color',
                align: 'center'
            },
            {
                title: '安装时间',
                field: 'time',
                align: 'center'
            },
            {
                title: '操作',
                field: '',
                align: 'center',
                formatter: function (value, row) {
                    var  e = '<a  id="add" data-id="98"  onclick="edit(\'' + row.id + '\')">编辑</a> ';
                    var  c = '<a  id="add" data-id="98" onclick="testdel(\'' + row.id + '\')">定位</a> ';
                    var  d = '<a  id="add" data-id="98" onclick="testdel(\'' + row.id + '\')">删除</a> ';
                    return e+c+d;
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
        title: '垃圾桶信息',
        shade: 0.5,
        skin: 'layui-layer-rim',
        area: ['700px', '500px'],
        shadeClose: true,
        closeBtn: 1,
        content: 'rubeTail.html'
    });
}

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