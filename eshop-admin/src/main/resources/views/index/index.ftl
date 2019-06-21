<!DOCTYPE html>
<#assign ctx=request.contextPath />

<html>
<head>
    <meta charset="utf-8" />
    <meta charset="utf-8">
    <title>EShop Admin</title>
    <meta name="renderer" content="webkit">
    <link rel="icon" href="${ctx}/statics/images/favicon.ico" type="image/x-icon" />

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="text/javascript" src="${ctx}/statics/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/statics/js/layer/layui.all.js" charset="utf-8"></script>

    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet"/>
    <link href="${ctx}/statics/css/index.css" rel="stylesheet"/>
    <link href="${ctx}/statics/css/signup.css" rel="stylesheet"/>
    <script type="text/javascript" src="${ctx}/statics/js/md5.js"></script>


    <script>
        //iframe高度自适应
        function setIframeHeight(iframe) {
            if (iframe) {

                var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
                if (iframeWin.document.body) {
                    iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
                }

                // console.log(iframe.height);
//
                if(iframe.height < 640) {
                    iframe.height = 640;
                }
            }
        };
    </script>

    <style type="text/css">
        a {
            cursor: pointer;
        }
    </style>


</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <!--头部-->
    <div class="layui-header">
        <!--头部左侧导航-->
        <ul class="layui-nav layui-layout-left" lay-filter="leftmenu">
            <li class="layui-nav-item">
                <a href="javascript:;" class="hidetab" title="隐藏左侧菜单"><i class="layui-icon layui-icon-shrink-right"></i></a>
            </li>
            <li class="layui-nav-item">
                <a href="./index.html" title="主页"><i class="layui-icon layui-icon-home"></i></a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:window.location.reload();" title="刷新"><i class="layui-icon layui-icon-refresh-3"></i></a>
            </li>
            <li class="layui-nav-item layui-hide-xs">
                <input class="layui-input layui-input-search" type="text" placeholder="搜索" autocomplete="off"/>
            </li>
        </ul>
        <!--头部右侧导航-->
        <ul class="layui-nav layui-layout-right" lay-filter="rightmenu">
            <li class="layui-nav-item">
                <a href=""><i class="layui-icon layui-icon-speaker"></i>消息中心<span class="layui-badge">9</span></a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-user"></i>
                    <span id="login_user_name"></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" lay-href="./userinfo.html"><i class="layui-icon layui-icon-form"></i>基本资料</a></dd>
                    <dd><a onclick="changepassword()"><i class="layui-icon layui-icon-password"></i>修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">锁屏<i class="layui-icon layui-icon-password"></i></a>
            </li>
            <li class="layui-nav-item"><a onclick="logout()">退出</a></li>
        </ul>
    </div>
    <!--左侧-->
    <div class="layui-side layui-side-menu">
        <!--带滚动条垂直导航-->
        <div class="layui-side-scroll layui-bg-black">
            <div class="layui-logo">Eshop后台管理系统</div>
            <ul class="layui-nav layui-nav-tree" lay-filter="navtree">
                <#--动态生成数据，需要使用element.render()重新渲染一边-->


            </ul>
        </div>
    </div>
    <!--正文-->
    <div class="layui-body layui-bg-gray">
        <!--选项卡-->
        <div class="layui-admin-pagetabs">
            <div class="layui-tab layui-tab-brief" lay-allowClose="true" lay-filter="pagetabs">
                <ul class="layui-tab-title layui-bg-white">
                    <li class="layui-this" lay-id="${ctx}/user/index"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <#--<iframe src="" class="layui-admin-iframe" scrolling="no" frameborder="0" onload="setIframeHeight(this);"></iframe>-->
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!--底部-->
    <div class="layui-footer">© 2018 layui.com </div>
</div>
<#--<script src="./js/layui/layui.js"></script>-->
<script type="text/javascript">

    var menus = new Array();

    var login_user_name = window.localStorage.getItem('login_user_name');
    if (null !== login_user_name
            || '' !== login_user_name
            || typeof (login_user_name) !== 'undefined') {
        $("#login_user_name").text(login_user_name);
    }


    function initMenus() {

        var response = '${menus}';

        if (null != response) {
            var menuDatas = JSON.parse(response);
            if (null == menuDatas || menuDatas.length <= 0) {
                layer.alert("您还没有任何菜单，请联系管理员！")
                return;
            }
            menuDatas = menuDatas[0].children;
            var menuHtml = '';
            if (null == menuDatas || typeof (menuDatas) == 'undefined' ||
                menuDatas.length <= 0) {
                return false;
            }

            // 一级菜单
            for (var i = 0; i < menuDatas.length; i++) {

                var menuData = menuDatas[i];

                if(menuData.menuCode == "root_menu") {
                    continue;
                }
                var icon = menuData.icon;
                var name = menuData.name;

                menuHtml += '<li class="layui-nav-item">';
                menuHtml += '<a href="javascript:;" title="' + name + '"><i class="layui-icon ' + icon + '"></i>&nbsp;&nbsp;<cite>' + name + '</cite><span class="layui-nav-more"></span></a>';
                // 解析一级菜单信息
                menuHtml += parseChildrenMenuHtml(menuData);
                menuHtml += '</li>';

            }
            // menuHtml += '</ul>'
            // console.log(menuHtml)
            $(".layui-nav-tree").append(menuHtml)

            window.localStorage.setItem("menus", JSON.stringify(menuDatas));
        }
    }

    function parseChildrenMenuHtml( menu) {

        var children = menu.children;

        var html = '';
        //html += '<dl class="layui-nav-child">';

        if (null != children && children.length > 0) {
            html += '<dl class="layui-nav-child">';
            for (var i = 0; i < children.length; i++) {
                html += '<dd>';
                var subMenu = children[i];
                var subLeaf = subMenu.leaf;

                // 如果是叶子节点,显示菜单名称
                if (subLeaf) {
                    html += '<a href="javascript:;" lay-href="' + subMenu.url + '">' + subMenu.name + '</a>';
                } else {
                    // 不是叶子节点，像像是一级菜单那样显示菜单信息
                    var name = subMenu.name;
                    var icon = subMenu.icon;
                    html += '<li class="layui-nav-item ">';
                    html += '<a href="javascript:;" title="' + name + '"><i class="layui-icon ' + icon + '"></i>&nbsp;&nbsp;<cite>' + name + '</cite><span class="layui-nav-more"></span></a>';
                    html += parseChildrenMenuHtml(subMenu, html);

                }
                html += '</dd>';
            }
            html += '</dl>';
        }
        return html;
    }


    layui.use(['element','layer', 'form'],function(){
        var element = layui.element
                ,layer = layui.layer
                ,$ = layui.jquery
            ,form = layui.form;



        //隐藏tab主页关闭标签
        $(".layui-tab-title li:first-child i:last-child").css("display","none");
        //tab点击监控
        element.on('tab(pagetabs)',function(data){
            //tab切换时，左侧菜单对应选中
            var url = $(this).attr("lay-id");
            $(".layui-nav-tree li dd").each(function(i,e){
                if($(this).find("a").attr("lay-href")==url){
                    $(this).attr("class","layui-this");
                }else{
                    $(this).attr("class","");
                }
            })
        });

        // 生成菜单信息
        initMenus();
        // 需要重新渲染一遍，不然不生效。！！！！！
        element.render('nav');
        //顶部左侧菜单监控
        element.on('nav(leftmenu)',function(elem){

            //隐藏显示侧边菜单
            if(elem[0].className=="hidetab"){//隐藏
                //侧边菜单伸缩
                $(".layui-side-menu").animate({width:$(".layui-side-menu").width()-144+"px"});
                //正文伸缩
                $(".layui-body").animate({left:$(".layui-body").position().left-144+"px"});
                //底部伸缩
                $(".layui-footer").animate({left:$(".layui-footer").position().left-144+"px"});
                $(this).attr("class","showtab");
                $(this).find("i").attr("class","layui-icon layui-icon-spread-left");
                //侧边菜单只显示图标
                $(".layui-nav-tree").find("li").each(function(em,ind){
                    $(this).find("cite").css("display","none");
                    $(this).find("dl").css("display","none");
                });
            }else if(elem[0].className=="showtab"){//显示
                $(".layui-side-menu").animate({width:$(".layui-side-menu").width()+144+"px"});
                $(".layui-body").animate({left:$(".layui-body").position().left+144+"px"});
                $(".layui-footer").animate({left:$(".layui-footer").position().left+144+"px"});
                $(this).attr("class","hidetab");
                $(this).find("i").attr("class","layui-icon layui-icon-shrink-right");
                $(".layui-nav-tree").find("li").each(function(em,ind){
                    $(this).find("cite").css("display","");
                    $(this).find("dl").css("display","");
                });
            }else{

            }
        });
        //顶部右侧菜单监控
        element.on('nav(rightmenu)',function(elem){
            var url = $(this).attr("lay-href");
            if(url!=undefined){
                layer.open({
                    title:elem[0].innerText,
                    type: 2,
                    content:url,
                    area: ['600px', '500px']
                });
            }
            if(elem[0].innerText=="锁屏"){
                layer.open({
                    title:"已锁屏"
                    ,content: '<input name="pass" class="layui-input" type="text" placeholder="请输入密码,默认123123" autocomplete="off"/>'
                    ,btnAlign: 'c'
                    ,anim: 1
                    ,btn: ['解锁']
                    ,yes: function(index, layero){
                        var pass = layero.find('.layui-layer-content input').val();
                        if(pass=="123123"){
                            layer.close(index);
                        }else{
                            layer.title("密码不正确！", index);
                        }
                    }
                    ,cancel: function(){
                        return false //开启该代码可禁止点击该按钮关闭
                    }
                });
            }
        })
        //左侧垂直菜单监控
        element.on('nav(navtree)',function(elem){

            if($(".layui-side-menu").width()<200){
                $(".layui-side-menu").animate({width:$(".layui-side-menu").width()+144+"px"});
                $(".layui-body").animate({left:$(".layui-body").position().left+144+"px"});
                $(".layui-footer").animate({left:$(".layui-footer").position().left+144+"px"});
                $(".layui-layout-left li:first-child").find("a").attr("class","hidetab");
                $(".layui-layout-left li:first-child").find("i").attr("class","layui-icon layui-icon-shrink-right");
                $(".layui-nav-tree").find("li").each(function(em,ind){
                    $(this).find("cite").css("display","");
                    $(this).find("dl").css("display","");
                });
            }else{
                if($(this).attr("lay-href")!=undefined){
                    var  flag = true;
                    //url
                    var url = $(this).attr("lay-href");
                    //判断选项卡中是否存在已打开的页面，如果有直接切换到打开页面
                    $(".layui-tab-title li").each(function(i,e){
                        if($(this).attr("lay-id")==url){
                            //切换选项卡
                            element.tabChange('pagetabs', url);
                            flag = false;
                        }
                    })
                    if(flag){
                        //新增选项卡
                        element.tabAdd('pagetabs', {
                            title: elem[0].innerText
                            ,content: '<iframe src="'+url+'" class="layui-admin-iframe" scrolling="no" frameborder="0" onload="setIframeHeight(this)"></iframe>'
                            ,id: url
                        });
                        //切换选项卡
                        element.tabChange('pagetabs', url);
                    }
                }
            }
        });
        
        window.logout = function () {

            layer.confirm('是否真的退出登录?', {icon: 3, title:'提示'}, function(index){

                var token = window.localStorage.getItem('token');
                if (null == token || '' == token || typeof (token) === 'undefined') {
                    layer.msg('登录信息已过期，请重新登录！');
                    window.location = "login";

                    return;
                }

                $.ajax({
                    url:"${base}/user/logout",
                    data:JSON.stringify({"token":token}),
                    type:"post",
                    contentType: "application/json; charset=utf-8",
                    dataType:"json",
                    async: false,
                    success:function(data){
                        if(data.success){
                            var token2 = data.data;
//                        alert(token2 == token)
//                        window.localStorage.setItem("token2", token2);
//                        window.localStorage.setItem("login_user_name", username);
                            window.localStorage.clear();
                            window.location = "index";
                        }else{
                            layer.msg(data.errMsg);
                        }
                    }
                });
                layer.close(index);
            });



        }

        window.changepassword = function() {
            var token = window.localStorage.getItem('token');
            if (null == token || '' == token || typeof (token) === 'undefined') {
                layer.msg('登录信息已过期，请重新登录！');
                window.location = "login";

                return;
            }

            layer.open({
                type: 1,
                area: "500px",
                content: $('#changepassword') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });
        }

        // 校验密码
        window.validPassword = function(value) {
            var msg = '';
            if (null == value || '' == value) {
                return '请输入原密码';
            }

            value = md5(value);
            var userName = window.localStorage.getItem('login_user_name');
            var postJSON = JSON.stringify({userName:userName, password: value})
            $.ajax({
                url: '${ctx}/user/validPassword',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                data: postJSON,
                async: false,
                dataType: "json",
                success: function(data){

                    var isSuccess = data.success;
                    var responseData = data.data;

                    if (!isSuccess) {
                        layer.alert(data.errMsg);
                    } else if (isSuccess && null != responseData){
                        msg =  "密码不对，请重试";
                    }

                }
            });

            return msg;
        }

        // 密码更新校验
        // 表达校验信息
        form.verify({


            olduserPassword: function (value) {
                if (null == value || '' == value) {
                    return '请输入原密码';
                }
                // 校验密码复杂度
                if (value.length < 6) {
                    return '密码长度最少为6位';
                }

                if (! (/[A-Za-z]{1}/.test(value))) {
                    return '密码需要至少包含一个英文字母';
                }


                var msg = validPassword(value);

                if (null != msg && '' != msg && typeof (msg) != 'undefined') {
                    return msg
                }
            },
            newuserPassword: function (value) {
                if (null == value || '' == value) {
                    return '请输入新密码';
                }
                // 校验密码复杂度
                if (value.length < 6) {
                    return '密码长度最少为6位';
                }

                if (! (/[A-Za-z]{1}/.test(value))) {
                    return '密码需要至少包含一个英文字母';
                }
            },
            // 确认密码
            confirmPassword: function(value) {
                // 获取用户密码
                var newuserPassword = $("input[name=newuserPassword]").val();

                if (newuserPassword !== value) {
                    return '两次密码输入不一致，请重新输入！';
                }

            }
        });

        //监听提交
        form.on('submit(updatePassword)', function(data){
            // layer.msg(JSON.stringify(data.field));
            //return false;

            // md5 密码
            var newpwd = data.field.newuserPassword;
            var pwd = data.field.olduserPassword;
            if (null == pwd || '' == pwd || typeof (pwd) == 'undefined') {
                layer.msg("请输入注册密码");
                return false;
            }

            data.field.newuserPassword = md5(newpwd);
            data.field.olduserPassword = md5(pwd);

            var userName = window.localStorage.getItem('login_user_name');
            data.field.userName = userName;
            var postJSON = JSON.stringify(data.field);
/*
confirmPassword: "niejian123"
newuserPassword: "niejian123"
olduserPassword: "qq123123"
 */
            // 验证成功，提交数据
            $.ajax({
                url: '${cx}/user/doUpdatePassword',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                data: postJSON,
                async: false,
                dataType: "json",
                success: function(data){

                    var isSuccess = data.success;
                    if (!isSuccess) {
                        layer.alert(data.errMsg);
                    } else {
                        var msg ='密码更新成功';
                        layer.alert(msg, function(index) {
                            // 关闭当前提示的这个弹出层
                            layer.close(index);
                            // 关闭当前的弹出页面
                            var layIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(layIndex);
                        });

                    }

                }
            });

            // 必须加上这个
            return false;

        });
    });
</script>

</body>
</html>
<form class="layui-form" action="" id="changepassword" >


    <div class="layui-form-item">

        <div class="registDiv layui-inline">
            <label class="layui-form-label">旧密码：</label>
            <div class="layui-input-inline">
                <label class="iconLabel layui-icon layui-icon-password" ></label>
                <input type="password" name="olduserPassword" lay-verify="olduserPassword" autocomplete="off" placeholder="旧密码" class="registInput layui-input">
            </div>
        </div>

        <div class="registDiv layui-inline">
            <label class="layui-form-label">新密码：</label>
            <div class="layui-input-inline">
                <label class="iconLabel layui-icon layui-icon-password" ></label>
                <input type="password" name="newuserPassword" lay-verify="newuserPassword" autocomplete="off" placeholder="新密码" class="registInput layui-input">
            </div>
        </div>

        <div class="registDiv layui-inline">
            <label class="layui-form-label">确认密码：</label>
            <div class="layui-input-inline">
                <label class="iconLabel layui-icon layui-icon-vercode" ></label>
                <input type="password" name="confirmPassword" lay-verify="confirmPassword" autocomplete="off" placeholder="确认密码" class="registInput layui-input">
            </div>
        </div>


    </div>


    <div class="layui-form-item submitForm layui-row">
        <#--<div class="layui-col-xs4">-->
        <#--<div class="grid-demo grid-demo-bg1">1</div>-->
        <#--</div>-->

        <div class="layui-col-md12" style="padding-left: 100px">
            <button class="layui-btn layui-btn-radius" lay-submit lay-filter="updatePassword"><i class="layui-icon layui-icon-ok"> </i> &nbsp;确定</button>
            <button type="reset" class="layui-btn layui-btn-radius layui-btn-primary"><i class="layui-icon layui-icon-refresh-1"> </i> 重置</button>
            <button type="button" class="layui-btn layui-btn-radius layui-btn-warm"  data-type="back"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

        </div>
    </div>

</form >