// JavaScript Document
var zTree;
	var demoIframe;

	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false,

		},
		check: {  
                enable: true,  
                nocheckInherit: false

            },
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: "rid"
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src",treeNode.file + ".html");
					return true;
				}
			}
		}
	};

	var zNodes =[
	     {	rid:101	,	id:	101	,pId:101,name:"	独山警务系统	",open:true,nocheck:true,icon:"../../../css/zTreeStyle/img/diy/ztop.png"}	,
{	id:	1001	,	pId:	101	,name:"	花园街中路	",open:true}	,
{	id:	1001003	,	pId:	1001	,name:"	摄像头CVS020523	",nocheck:true}	,
{	id:	1001008	,	pId:	1001	,name:"	摄像头CVS020523	",nocheck:true}	,
{	id:	1001019	,	pId:	1001	,name:"	摄像头CVS020523	"}	,
{	id:	1001020	,	pId:	1001	,name:"白虎坡	"}	,

{	id:	1002	,	pId:	101	,name:"飞凤井",open:true}	,

{	id:	1003	,	pId:	101	,name:"	独山县人民医院	",open:true}	,

{	id:	1004	,	pId:	101	,name:"	纳金阁酒店	",open:true}	,

{	id:	1005	,	pId:	101	,name:"	独山县汽车总站	",open:true}	,
		{	id:	1006	,	pId:	101	,name:"	龙源温泉酒店	",open:true}	,
		{	id:	1007	,	pId:	101	,name:"	巴银寨	",open:true}	,
		{	id:	1008	,	pId:	101	,name:"	翠泉森林公园	",open:true}	,
		{	id:	1009	,	pId:	101	,name:"	望诚坡	",open:true}	,
		{	id:	1010	,	pId:	101	,name:"	五星大世界	",open:true}

	];

	$(document).ready(function(){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, zNodes);
		
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.selectNode(zTree.getNodeByParam("id", 101));

	});
