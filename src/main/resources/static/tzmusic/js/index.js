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
    $('#login').click(function () {
        layer.open({
            title:'登陆'
            ,type:2
            ,content:'/login'
            ,area:['500px','320px']
            }

        )
    })
});