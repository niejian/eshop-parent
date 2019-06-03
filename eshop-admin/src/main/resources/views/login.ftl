<#assign base=request.contextPath/>
<html>
<head>
    <base id="base" href="${base}">
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${base}/statics/login/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${base}/statics/login/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${base}/statics/login/css/component.css" />
    <link rel="stylesheet" type="text/css" href="${base}/statics/js/layer/css/layui.css" />
    <script type="text/javascript" src="${base}/statics/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${base}/statics/js/layer/layui.js"></script>
</head>
<body>
    <div class="container demo-1">
        <div class="content">
            <div id="large-header" class="large-header">
                <canvas id="demo-canvas"></canvas>
                <div class="logo_box">
                    <h3>欢迎你</h3>
                    <form action="#" name="f" method="post">
                        <div class="input_outer">

                            <span class="u_user"></span>
                            <input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                        </div>
                        <div class="input_outer">
                            <span class="us_uer"></span>
                            <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                        </div>
                        <div class="input_outer">
                            <div style="float:left; width: 45%">
                                <span class="us_verify"></span>
                                <input name="valifyCode" class="text" style="width:45%;color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="text" placeholder="请输入验证码">
                            </div>
                            <div style="float:right; width: 45%">

                            </div>

                        </div>
                        <div class="mb2"><a id = "sub" lay-filter="sub" class="act-but submit" href="javascript:;" style="color: #FFFFFF">登录</a></div>
                    </form>
                </div>
            </div>
        </div>
    </div><!-- /container -->
    <script src="${base}/statics/login/js/TweenLite.min.js"></script>
    <script src="${base}/statics/login/js/EasePack.min.js"></script>
    <script src="${base}/statics/login/js/rAF.js"></script>
    <script src="${base}/statics/login/js/demo-1.js"></script>
</body>
<script>
    //加载弹出层组件
    layui.use('layer',function(){

        var layer = layui.layer;

        //登录的点击事件
        $("#sub").on("click",function(){
            login();
        })

        $("body").keydown(function(){
            if(event.keyCode == "13"){
                login();
            }
        })

        //登录函数
        function login(){
            var username = $(" input[ name='username' ] ").val();
            var password = $(" input[ name='password' ] ").val();
            $.ajax({
                url:"${base}/doLogin",
                data:{"username":username,"password":password},
                type:"post",
                dataType:"json",
                    success:function(data){
                    if(data.success){
                        window.location = "index";
                    }else{
                        layer.msg(data.msg);
                    }
                }
            })
        }
    })
</script>
</html>