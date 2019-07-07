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
    <script type="text/javascript" src="${ctx}/statics/js/md5.js"></script>

</head>
<body>
    <div class="container demo-1">
        <div class="content">
            <div id="large-header" class="large-header">
                <canvas id="demo-canvas"></canvas>
                <div class="logo_box">
                    <h3>欢迎你</h3>
                    <form action="#" name="f" class="layui-form" method="post">
                        <div class="input_outer layui-form-item">

                            <span class="u_user"></span>

                            <input name="username" class="text" value="sysadmin" style="color: #FFFFFF !important" lay-verify="username" type="text" placeholder="请输入账户">
                        </div>
                        <div class="input_outer">
                            <span class="us_uer"></span>
                            <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="qq123123" lay-verify="password" type="password" placeholder="请输入密码">
                        </div>
                        <div class="input_outer">
                            <div style="float:left; width: 45%">
                                <span class="us_verify"></span>
                                <input name="valifyCode" class="text"  lay-verify="valifyCode" style="width:25%;color: #FFFFFF !important; position:absolute; z-index:100;" " placeholder="请输入验证码">
                            </div>
                            <div style="float:right; width: 55%">
                                <img class="validImg" src="${ctx}/captcha/getCaptcha" onclick="changeValidCode()">
                            </div>

                        </div>
                        <div class="mb2">
                            <a id = "sub" lay-filter="sub" class="act-but submit" href="javascript:;" style="color: #FFFFFF">登录</a>
                        </div>
                        <div class="layui-row">
                            <div class="layui-col-xs8">
                                <div class="" style="line-height: 40px; height: 40px;">
                                    <babel style="font-size: 18px">社交账号登录：</babel>
                                    <i class="layui-icon layui-icon-login-qq"></i>
                                    &nbsp;
                                    <i class="layui-icon layui-icon-login-weibo"></i>
                                    &nbsp;
                                    <i class="layui-icon layui-icon-login-wechat"></i>
                                </div>
                            </div>
                            <div class="layui-col-xs4">
                                <div class="" style="line-height: 40px; height: 40px; float: right ">

                                    <a style="color: white; font-size: 18px; cursor: pointer" onclick="register()">注册账号</a>
                                </div>
                            </div>
                        </div>
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
    <#--$(document).ready(function(){-->
        <#--$(".validImg").click(function () {-->
            <#--$(this).attr('src', '${ctx}/captcha/getCaptcha');-->

        <#--})-->
    <#--});-->

    function changeValidCode() {
        $('.validImg').attr('src', '${ctx}/captcha/getCaptcha');
    }
    // 注册
    function register() {
        var layer = layui.layer;
        var url = "${base}/user/register";
        layer.open({
            id: "register",
            title: "用户注册",
            type: 2,
            area: ["500px", "600px"],
            content: url,
            success: function(layero, index){
                //console.log("add--" + index);
            },
            end: function () {
                //resetForm();
                //刷新表格数据
                search();
            },
            cancel: function (index, layero) {
                layer.close(index);

                //resetForm();
                search();
                return false;
            }
        });
    }


    //加载弹出层组件
    layui.use(['form', 'layer'],function(){

        var layer = layui.layer;
        var form = layui.form;
        
//        form.verify({
//            username: function (value) {
//                if (null == value || '' == value) {
//                    return '请输入用户名';
//                }
//
//                if (value.length < 4) {
//                    return '用户名长度至少为4';
//                }
//
//            },
//            password: function (value) {
//                if (null == value || '' == value) {
//                    return '请输入密码';
//                }
//                // 校验密码复杂度
//                if (value.length < 6) {
//                    return '密码长度最少为6位';
//                }
//
//                if (! (/[A-Za-z]{1}/.test(value))) {
//                    return '密码需要至少包含一个英文字母';
//                }
//            },
//            valifyCode: function(value) {
//                debugger
//                if (null == value || '' == value) {
//                    return '请输入验证码';
//                }
//                // 校验验证码复杂度
//                if (value.length < 5) {
//                    return '验证码不对';
//                }
//
//
//            }
//        });

        //登录的点击事件
        $("#sub").on("click",function(){
            //debugger
            login();
        })

        $("body").keydown(function(){
            if(event.keyCode == "13"){
                login();
            }
        })

        //登录函数
        function login(){

            var username = $("input[ name='username' ] ").val();
            var password = $("input[ name='password' ] ").val();
            var valifyCode = $("input[ name='valifyCode' ] ").val();
            password = md5(password);
            $.ajax({
                url:"${base}/user/doLogin",
                data:JSON.stringify({"username":username,"password":password, 'valifyCode':valifyCode}),
                type:"post",
                contentType: "application/json; charset=utf-8",
                dataType:"json",
                    success:function(data){
                    debugger
                    if(data.success){
                        var token = data.data;
                        window.localStorage.setItem("token", token);
                        window.localStorage.setItem("login_user_name", username);
                        window.location = "index";
                    }else{
                        changeValidCode()

                        layer.msg(data.errMsg);
                    }
                }
            })
        }
    })
</script>
</html>