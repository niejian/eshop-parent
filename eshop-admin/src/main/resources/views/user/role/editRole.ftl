<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>角色管理</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
        <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet">
        <script type="text/javascript" src="${ctx}/statics/js/jquery-1.9.1.min.js"></script>

        <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>


    </head>
    <body>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <#if type == 'edit'>
                <legend>编辑角色信息</legend>
                <#elseif type == 'view'  >
                <legend>查看角色信息</legend>
            </#if>
        </fieldset>
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">角色编码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="roleCode" name="roleCode" lay-verify="required" autocomplete="off" placeholder="请输入角色编码" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">角色名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="roleName" id="roleName" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
                    </div>
                </div>

            <div>

            <div class="layui-form-item">
                <div class="layui-inline"></div>
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="roleForm">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </form>



    </body>

    <script type="text/javascript">
        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(roleForm)', function(data){
                console.log(data)
                layer.msg(JSON.stringify(data.field));
                return false;


            });
        });
    </script>
</html>