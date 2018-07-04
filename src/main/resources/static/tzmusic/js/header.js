//JavaScript代码区域
layui.use(['element','carousel','layer','jquery'], function(){
    var element = layui.element;
    var $ = layui.jquery;
    var layer = layui.layer;
    //layer.msg("header is ready")
    //图片轮播
    $('#login').click(function () {
        layer.open({
                title:'登录'
                ,type:2
                ,content:'/login'
                ,area:['500px','320px']
                ,end:function () {
                    window.location.href = "index";
                    loginFlag = 1;
                }
            }

        )
    });
    $('#register').click(function () {
        layer.open({
                title:'注册'
                ,type:2
                ,content:'/register'
                ,area:['500px','320px']
            }

        )
    });
    $('#myMusic').click(function (){
        if ($('#loginForm').css("display") !== "none"){
            window.location.href = "myMusic";
        }else{
            layer.msg("loginFlag:" + 0);
            layer.open({
                    title:'登录'
                    ,type:2
                    ,content:'/login'
                    ,area:['500px','320px']
                    ,end:function () {
                        window.location.href = "index";
                    }
                }
            );
        }
    });
});