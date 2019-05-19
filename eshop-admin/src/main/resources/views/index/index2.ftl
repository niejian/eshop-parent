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

    <#--<link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">-->
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
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
                        <dd><a href="javascript:;" onclick="goToPage('/user/manageMenus')">菜单管理</a></dd>
                        <dd><a href="javascript:;" onclick="goToPage('/user/manageRights')">权限管理</a></dd>


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
    <div class="layui-body layui-tab-content">
        <!-- 内容主体区域，通过goToPage 动态变换地址信息 -->
        <iframe id="contentFrame" src="" frameborder="0" width="100%" height="100%"></iframe>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script src="${ctx}/statics/js/layer/layui.all.js" charset="utf-8"></script>

<script>
//    alert(124)
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->


    layui.use('element', function(){
        var element = layui.element;

    });


    function goToPage(param){

        $("#contentFrame").attr("src",param);
    }


</script>

</body>
</html>