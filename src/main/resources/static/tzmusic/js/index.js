//JavaScript代码区域
layui.use(['element','carousel','layer','jquery'], function(){
    var element = layui.element;
    var $ = layui.jquery;
    var carousel = layui.carousel;
    //图片轮播
    carousel.render({
        elem: '#test10'
        ,width: '100%'
        ,interval: 5000
    });
    //$('#header').load("common/header.html");
    //layer.msg(11111);
});