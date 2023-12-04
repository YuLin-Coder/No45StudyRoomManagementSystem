/**
 * Created by Administrator on 2017/9/12.
 */
/**
 * Created by Administrator on 2017/4/25.
 */
$(function(){
    var myChart = echarts.init($("#container")[0]);
    var option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['经济开发区','市中区','东兴区','资中县','隆昌县','威远县']
        },

        series : [
            {
                name:'人员占比',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {
                        value:124,
                        name:'经济开发区',
                        itemStyle:{
                            normal:{
                                color:""
                            }
                        }
                    },
                    {
                        value:86,
                        name:'市中区'
                    },
                    {
                        value:9,
                        name:'东兴区'
                    },
                    {
                        value:9,
                        name:'资中县'
                    },{
                        value:86,
                        name:'隆昌县'
                    },
                    {
                        value:9,
                        name:'威远县'
                    }


                ]
            }
        ]
    };
    myChart.setOption(option);
});


$(function(){
    var myChart = echarts.init($("#container3")[0]);
    var option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['青年','中年','老年',"其他"]
        },

        calculable : false,
        series : [
            {
                name:'人员年龄段分析',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {
                        value:14,
                        name:'老年',
                        itemStyle:{
                            normal:{
                                color:""
                            }
                        }
                    },
                    {
                        value:9,
                        name:'青年'
                    },
                    {
                        value:9,
                        name:'中年'
                    },
                    {
                        value:39,
                        name:'其他'
                    }

                ]
            }
        ]
    };
    myChart.setOption(option);
});
$(function(){
    var myChart = echarts.init($("#container4")[0]);
    var option = {

        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['经济开发区','市中区','东兴区','资中县','隆昌县','威远县']
        },

        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value'

            }
        ],
        series : [
            {
                name:'经济开发区',
                type:'line',
                data:[3, 2, 1, 4, 0, 0, 2,1, 2, 2, 4, 1]
            },
            {
                name:'市中区',
                type:'line',
                data:[3, 3, 3, 4, 0, 3, 3,1, 2, 1, 3, 1]
            },
            {
                name:'东兴区',
                type:'line',
                data:[4, 4, 3, 1, 2, 3, 0,1, 2, 1, 3, 0]
            },
            {
                name:'资中县',
                type:'line',
                data:[2, 5, 3, 4, 2, 5, 1,2, 0, 2, 3, 5]
            },
            {
                name:'隆昌县',
                type:'line',
                data:[1, 2, 1, 3, 3, 0, 2,1, 3, 1, 4, 0]
            },
            {
                name:'威远县',
                type:'line',
                data:[2, 5, 1, 4, 4, 3, 1,4, 3, 5, 2, 5]
            }


        ]
    };
    myChart.setOption(option);
});