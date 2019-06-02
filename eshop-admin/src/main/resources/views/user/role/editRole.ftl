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
                            <input type="hidden" name="id" value="${role.id}">
                            <input type="hidden" name="createTime" value="${role.createTime?string('yyyy-MM-dd hh:mm:ss')}">
                            <input type="hidden" name="createBy" value="${role.createBy}">
                            <input type="text" name="roleCode" name="roleCode" value="${role.roleCode}" readonly lay-verify="required" autocomplete="off" placeholder="请输入角色编码" class="layui-input"/>

                     </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">角色名称</label>
                    <div class="layui-input-inline">
                         <#if type == 'edit'>
                             <input type="text" name="roleName" id="roleName" value="${role.roleName}" lay-verify="roleName" placeholder="请输入角色名称" autocomplete="off" class="layui-input">

                         <#elseif type == 'view'  >
                             <input type="text" name="roleName" id="roleName" value="${role.roleName}" readonly lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input">

                         </#if>
                    </div>
                </div>


            <div>

            <br/> <br/> <br/>
            <div class="submitRole layui-form-item">
                <div class="layui-row">
                    <#--<div class="layui-col-xs4">-->
                        <#--<div class="grid-demo grid-demo-bg1">1</div>-->
                    <#--</div>-->

                    <div class="layui-col-md6 layui-col-md-offset5">
                        <#if type == 'edit'>
                            <button class="layui-btn" lay-submit lay-filter="roleForm"><i class="layui-icon">&#xe605 </i> &nbsp;确定</button>
                            <#--<button type="reset" class="layui-btn layui-btn-primary">重置</button>-->
                        <#elseif type == 'view'  >

                        </#if>
                        <button type="button" class="layui-btn layui-btn-warm"  data-type="back"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

                    </div>
                </div>
            </div>

        </form>



    </body>

    <script type="text/javascript">
        layui.use('form', function(){
            var form = layui.form;

            // 表达校验信息
            form.verify({
                roleName: function (value) {
                    if (null == value || '' == value) {
                        return '请输入角色名称';
                    }
                }
            });

            //监听提交
            form.on('submit(roleForm)', function(data){
                // layer.msg(JSON.stringify(data.field));
                //return false;
                var postJSON = JSON.stringify(data.field);

                // 验证成功，提交数据
                $.ajax({
                    url: '${cx}/user/role/updateRole',
                    type: 'POST',
                    contentType: "application/json; charset=utf-8",
                    data: postJSON,
                    async: false,
                    dataType: "json",
                    success: function(data){
                        debugger
                        var isSuccess = data.success;
                        if (!isSuccess) {
                            layer.alert(data.errMsg);
                        } else {
                            var msg ='更新成功';
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

                return false;

            });

            var $ = layui.$, active = {
                // 点击返回，关闭本页面
                back: function() {
                    var layIndex = parent.layer.getFrameIndex(window.name);
                    layer.confirm('关闭后将无法保存已填写的数据，是否确认关闭', function () {
                        parent.layer.close(layIndex);
                        //parent.layer.close(index2);
                    });
                }
            };
            $('.submitRole .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

        });
    </script>
</html>