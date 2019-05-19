<!DOCTYPE html>
<#assign ctx=request.contextPath />

<html>
<head>
    <meta charset="utf-8">
    <title>EShop Admin</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="text/javascript" src="${ctx}/statics/js/jquery-1.9.1.min.js"></script>
    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet"/>
    <link href="${ctx}/statics/css/index.css" rel="stylesheet"/>

    <#--<link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">-->
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<script>
    //iframe高度自适应
    function setIframeHeight(iframe) {
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
    };
</script>
<body>
<#--<blockquote class="layui-elem-quote">-->
    <#--你也可以单独打开后台布局的例子：-->
    <#--<a class="layui-btn layui-btn-normal" href="layuiAdmin.html" target="_blank">单独打开</a>-->
<#--</blockquote>-->

<#--<iframe src="layuiAdmin.html?from=demo" frameborder="0" id="demoAdmin" style="width: 100%; height: 300px;"></iframe>-->
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">EShop Admin</div>
        <!-- 头部区域（可配合layui已有的水平导航）水平导航栏 -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <#--头像信息-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <#--左侧导航栏-->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">系统管理</a>
                    <dl class="layui-nav-child">
                        <#--
                        <dd><a href="javascript:;" lay-href="/user/manageMenus" onclick="goToPage('/user/manageMenus')">菜单管理</a></dd>
                        <dd><a href="javascript:;" onclick="goToPage('/user/manageRoles')">角色管理</a></dd>
                        -->
                        <dd><a href="javascript:;" lay-href="/user/manageMenus">菜单管理</a></dd>
                        <dd><a href="javascript:;" lay-href='/user/manageRoles'>角色管理</a></dd>




                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <#--<iframe id="contentFrame" src="" frameborder="0" >-->
    <#--<div class="layui-body layui-tab-content">-->
        <#--<!-- 内容主体区域，通过goToPage 动态变换地址信息 &ndash;&gt;-->
        <#--<iframe id="contentFrame" src="" frameborder="0" width="100%" height="100%"></iframe>-->

    <#--</div>-->
    <!--正文-->
    <div class="layui-body layui-bg-gray">
        <!--选项卡-->
        <div class="layui-admin-pagetabs">
            <div class="layui-tab layui-tab-brief" lay-allowClose="true" lay-filter="pagetabs">
                <ul class="layui-tab-title layui-bg-white">
                    <li class="layui-this" lay-id=""><i class="layui-icon layui-icon-home"></i></li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src="/user/manageMenus" id="contentFrame" class="layui-admin-iframe" scrolling="no" frameborder="0" onload="setIframeHeight(this);"></iframe>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script src="${ctx}/statics/js/layer/layui.all.js" charset="utf-8"></script>

<script>
    //iframe高度自适应
    function setIframeHeight(iframe) {
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
    };
//    alert(124)
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->


    layui.use(['element','layer'],function(){
        var element = layui.element
                ,layer = layui.layer
                ,$ = layui.jquery;
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
    });


    function goToPage(param){

        $("#contentFrame").attr("src",param);
    }


</script>

</body>
</html>