<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加角色</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet" media="all">
    <#--<link href="${ctx}/statics/js/layer/css/modules/layer/default/layer.css" rel="stylesheet" media="all">-->
    <script type="text/javascript" src="${ctx}/statics/js/jquery-1.9.1.min.js"></script>

    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>


</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加菜单信息</legend>
</fieldset>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜单编码</label>
            <div class="layui-input-inline">

                <input type="text" name="roleCode" name="menuCode"  lay-verify="menuCode" autocomplete="off" placeholder="请输入菜单编码" class="layui-input"/>

            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">菜单名称</label>
            <div class="layui-input-inline">
                <input type="text" name="menuName" id="menuName" lay-verify="menuName" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">

            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">上级菜单</label>
            <div class="layui-input-inline">
                <input type="hidden" name="parnetId" value="${(parnetMenu.id)!''}"/>
                <input type="hidden" name="parnetIds" value="${(parnetMenu.parentIds)!''}"/>
                <input type="text" name="parentMenuName" name="parentMenuName" value="${(parnetMenu.menuName)!''}"  readonly class="layui-input"/>

            </div>

        </div>
    </div>
    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">是否叶子节点</label>

            <div class="layui-input-inline">
                <input type="checkbox" name="left" lay-skin="switch" lay-text="是|否">
            </div>
        </div>


        <div class="layui-inline">
            <label class="layui-form-label">访问地址</label>
            <div class="layui-input-inline">
                <input type="text" name="menuUrl" name="menuUrl"  lay-verify="menuUrl" class="layui-input"/>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">页面排序</label>
            <div class="layui-input-inline">
                <input type="text" name="num" name="num"  lay-verify="num" value="0" class="layui-input"/>
            </div>
        </div>
    </div>

    <div class="submitRole layui-form-item">
        <div class="layui-row">
        <#--<div class="layui-col-xs4">-->
        <#--<div class="grid-demo grid-demo-bg1">1</div>-->
        <#--</div>-->

            <div class="layui-col-md6 layui-col-md-offset4">
                <button class="layui-btn" lay-submit lay-filter="menuForm"><i class="layui-icon">&#xe605 </i> &nbsp;确定</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>

                <button type="button" class="layui-btn layui-btn-warm"  data-type="back"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

            </div>
        </div>
    </div>



</form>



</body>
<style type="text/css">
    .layui-inline .layui-form-label{
        width: 150px;
    }
</style>
<script type="text/javascript">

    layui.use('form', function(){
        var form = layui.form;
        form.render();


        // 表达校验信息
        form.verify({
            // 校验编码不为空且唯一
            menuCode: function(value) {
                if (null == value || '' == value) {
                    return '请输入菜单编码';
                }

                // 校验菜单编码唯一
                var msg = validMenuCode(value);

                if (null != msg && '' != msg && typeof (msg) != 'undefined') {
                    return msg
                }

            },
            menuName: function (value) {
                if (null == value || '' == value) {
                    return '请输入菜单名称';
                }
            },
            menuUrl: function (value) {
                if (null == value || '' == value) {
                    return '请输入菜单地址';
                }

            }
        });

        //监听提交
        form.on('submit(menuForm)', function(data){
            // layer.msg(JSON.stringify(data.field));
            //return false;
            var postJSON = JSON.stringify(data.field);

            // 验证成功，提交数据
            $.ajax({
                url: '${cx}/user/menu/addMenuHandler',
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
                        var msg ='新增成功';
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

        //定义js方法
        window.validMenuCode =  function(menuCode) {
            var msg = '';
            $.ajax({
                url: '${cx}/user/menu/getMenuByMenuCode',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({menuCode: menuCode}),
                async: false,
                dataType: "json",
                success: function(data){

                    var isSuccess = data.success;
                    var responseData = data.data;

                    if (!isSuccess) {
                        layer.alert(data.errMsg);
                    } else if (isSuccess && null != responseData){
                        msg =  menuCode + "已存在";

                    }

                }
            });

            return msg;
        };

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