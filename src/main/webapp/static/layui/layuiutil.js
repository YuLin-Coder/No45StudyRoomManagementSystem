
layui.use(['element', 'layer'], function () {
  var element = layui.element;
  var layer = layui.layer;
  var $ = layui.jquery;
  $('input').iCheck({
    checkboxClass: 'icheckbox_minimal-red',
    radioClass: 'iradio_minimal-red',
    increaseArea: '20%' // optional
  });//checkbox美化
});