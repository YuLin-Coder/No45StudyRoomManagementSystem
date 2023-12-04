/**
 * Created by Administrator on 2017/6/12.
 */
var ID;
function tableLoad(){
    $('#table').bootstrapTable({
        method: "get",
        url: "json/proRecod.json",
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
                title: '问题名称',
                field: 'name',
                align: 'center'
            },
            {
                title: '状态',
                field: 'type',
                align: 'center',
                formatter:function (val,row) {
                    if(val=='关闭'){
                        return '<font color="#ccc">'+val+'</font>';
                    }
                    else if(val=='已处理'){
                        return '<font color="green">'+val+'</font>';


                    }
                    else{
                        return val;
                    }

                }
            },
            {
                title: '紧急程度',
                field: 'class',
                align: 'center'
            },
            {
                title: '所属机构',
                field: 'org',
                align: 'center'
            },
            {
                title: '上报时间',
                field: 'time',
                align: 'center'
            },
            {
                title: '处理时间',
                field: 'time01',
                align: 'center'
            },
            {
                title: '上报人',
                field: 'person',
                align: 'center'
            },
            {
                title: '处理结果',
                field: 'res',
                align: 'center'
            },
            {
                title: '反馈情况',
                field: 'res01',
                align: 'center'
            },
            {
                title: '操作',
                field: '',
                align: 'center',
                formatter: function (value, row) {
                    var  e = '<a  id="add" data-id="98"  onclick="edit(\'' + row.id + '\')">派遣</a> ';
                    var  c = '<a  id="add" data-id="98"  onclick="edit(\'' + row.id + '\')">回访</a> ';
                    var  d = '<a  id="add" data-id="98" onclick="testdel(\'' + row.id + '\')">关闭</a> ';
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
        title: '信息',
        shade: 0.5,
        skin: 'layui-layer-rim',
        area: ['700px', '500px'],
        shadeClose: true,
        closeBtn: 1,
        content: 'proRecodTail.html'
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