<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/statics/js/jquery-1.9.1.min.js"></script>

    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>


</head>
<body>

<fieldset class="layui-elem-field site-demo-button" style="margin-top: 30px;">
    <legend>按钮主题</legend>
    <div>
        <button class="layui-btn layui-btn-primary">原始按钮</button>
        <button class="layui-btn">默认按钮</button>
        <button class="layui-btn layui-btn-normal">百搭按钮</button>
        <button class="layui-btn layui-btn-warm">暖色按钮</button>
        <button class="layui-btn layui-btn-danger">警告按钮</button>
        <button class="layui-btn layui-btn-disabled">禁用按钮</button>
    </div>
</fieldset>
<fieldset class="layui-elem-field site-demo-button">
    <legend>按钮尺寸</legend>
    <div>
        <button class="layui-btn layui-btn-primary layui-btn-lg">大型按钮</button>
        <button class="layui-btn layui-btn-primary">默认按钮</button>
        <button class="layui-btn layui-btn-primary layui-btn-sm">小型按钮</button>
        <button class="layui-btn layui-btn-primary layui-btn-xs">迷你按钮</button>

        <br>

        <button class="layui-btn layui-btn-lg">大型按钮</button>
        <button class="layui-btn">默认按钮</button>
        <button class="layui-btn layui-btn-sm">小型按钮</button>
        <button class="layui-btn layui-btn-xs">迷你按钮</button>

        <br>

        <button class="layui-btn layui-btn-lg layui-btn-normal">大型按钮</button>
        <button class="layui-btn layui-btn-normal">默认按钮</button>
        <button class="layui-btn layui-btn-sm layui-btn-normal">小型按钮</button>
        <button class="layui-btn layui-btn-xs layui-btn-normal">迷你按钮</button>

        <br>

        <div style="width: 216px; margin: 0;">
            <!-- layui 2.2.5 新增 -->
            <button class="layui-btn layui-btn-fluid">流体按钮</button>
        </div>
    </div>
</fieldset>
<fieldset class="layui-elem-field site-demo-button">
    <legend>灵活的图标按钮（更多图标请阅览：文档-图标）</legend>
    <div>
        <button class="layui-btn"><i class="layui-icon"></i></button>
        <button class="layui-btn"><i class="layui-icon"></i></button>
        <button class="layui-btn"><i class="layui-icon"></i></button>
        <button class="layui-btn"><i class="layui-icon"></i></button>
        <button class="layui-btn"><i class="layui-icon"></i></button>
        <button class="layui-btn"><i class="layui-icon"></i></button>

        <br>

        <button class="layui-btn layui-btn-danger"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-danger"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-danger"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-danger"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-danger"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-danger"><i class="layui-icon"></i></button>

        <br>

        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>

        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>

        <button class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon"></i></button>
    </div>
</fieldset>
<fieldset class="layui-elem-field site-demo-button">
    <legend>还可以是圆角按钮</legend>
    <div>
        <button class="layui-btn layui-btn-primary layui-btn-radius">原始按钮</button>
        <button class="layui-btn layui-btn-radius">默认按钮</button>
        <button class="layui-btn layui-btn-normal layui-btn-radius">百搭按钮</button>
        <button class="layui-btn layui-btn-warm layui-btn-radius">暖色按钮</button>
        <button class="layui-btn layui-btn-danger layui-btn-radius">警告按钮</button>
        <button class="layui-btn layui-btn-disabled layui-btn-radius">禁用按钮</button>
    </div>
</fieldset>
<fieldset class="layui-elem-field site-demo-button">
    <legend>风格混搭的按钮</legend>
    <div>
        <button class="layui-btn layui-btn-lg layui-btn-primary layui-btn-radius">大型加圆角</button>
        <a href="http://www.layui.com/doc/element/button.html" class="layui-btn" target="_blank">跳转的按钮</a>
        <button class="layui-btn layui-btn-sm layui-btn-normal"><i class="layui-icon"></i> 删除</button>
        <button class="layui-btn layui-btn-xs layui-btn-disabled"><i class="layui-icon"></i> 分享</button>
    </div>
</fieldset>

<fieldset class="layui-elem-field site-demo-button">
    <legend>按钮组</legend>
    <div class="layui-btn-group">
        <button class="layui-btn">增加</button>
        <button class="layui-btn ">编辑</button>
        <button class="layui-btn">删除</button>
    </div>
    <div class="layui-btn-group">
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
    </div>
    <div class="layui-btn-group">
        <button class="layui-btn layui-btn-primary layui-btn-sm">文字</button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon"></i></button>
    </div>
</fieldset>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</body>
</html>