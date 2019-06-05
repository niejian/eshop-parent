<!DOCTYPE html>
<#include "common/base.ftl">
<html>
<head>
    <meta charset="utf-8">
    <title>角色菜单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
<#--    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet">-->
<#--    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>-->

<#--    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>-->
    <script type="text/javascript" src="${ctx}/statics/js/layer/lay/modules/layui-xtree.js"></script>



</head>
<style type="text/css">

</style>
<body>
<div style="width: 100%;height: 100%">

    <#--<legend>菜单树</legend>-->
    <#--<div style="display: inline-block; width: 30%; height: 500px; padding: 10px; border: 1px solid #ddd; overflow: auto; float: left">-->
        <#--<ul id="menuTree"></ul>-->


    <#--</div>-->

    <#--<div style="display: inline-block; width: 65%; height: 500px; padding: 10px; border: 1px solid #ddd; overflow: auto; float: right">-->
        <#--&lt;#&ndash;<fieldset class="layui-elem-field site-demo-button">&ndash;&gt;-->
            <#--&lt;#&ndash;<legend>菜单详情</legend>&ndash;&gt;-->
            <#--&lt;#&ndash;<div class="demoTable" style="display: inline-block; margin-bottom: 10px; margin-top: 10px">&ndash;&gt;-->
                <#--&lt;#&ndash;<button class="layui-btn  layui-btn-radius" onclick="add('add')"> <i class="layui-icon">&#xe654;</i>添加菜单</button>&ndash;&gt;-->
                <#--&lt;#&ndash;<button class="layui-btn layui-btn-normal  layui-btn-radius" onclick="add('edit')"> <i class="layui-icon">&#xe642;</i>编辑菜单</button>&ndash;&gt;-->
                <#--&lt;#&ndash;<button class="layui-btn layui-btn-warm layui-btn-radius" onclick="add('view')"> <i class="layui-icon">&#xe621;</i>查看菜单</button>&ndash;&gt;-->
                <#--&lt;#&ndash;<button class="layui-btn  layui-btn-danger layui-btn-radius" onclick="del()"> <i class="layui-icon">&#xe640;</i>删除菜单</button>&ndash;&gt;-->
            <#--&lt;#&ndash;</div>&ndash;&gt;-->
        <#--&lt;#&ndash;</fieldset>&ndash;&gt;-->

        <#--<table class="layui-hide" id="menuTable" lay-filter='menuTable' ></table>-->

    <#--</div>-->
    <fieldset class="layui-elem-field">
        <legend>选择菜单</legend>
    </fieldset>
        <input type="hidden" name="roleId"/>
    <form class="layui-form" action="" onsubmit="return false;">


        <div id="xtree1" style="width:100%;height: 100%;"></div>

        <div class="layui-row" style="padding-top: 20px">
        <#--<div class="layui-col-xs4">-->
        <#--<div class="grid-demo grid-demo-bg1">1</div>-->
        <#--</div>-->

            <div class="layui-col-md3 layui-col-md-offset3" style="padding-left: 150px">
                <button class="layui-btn" lay-submit lay-filter="form"><i class="layui-icon">&#xe605 </i> &nbsp;确定</button>

                <button type="button" class="layui-btn layui-btn-warm"  onclick="back()"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

            </div>
        </div>

    </form>


        <br/>
</div>
<#--角色管理页面-->




</body>

<#--为了让表格显示行号-->
<script type="text/html" id="tableIndex">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/javascript">
    function getRoleId(roleId) {

        if(null != roleId && '' != roleId) {
            $("input[name=roleId]").val(roleId);

        }
    }
    var menus = new Array();

    // 左侧选中的菜单信息
    var checkedMenu = {};

    function loadMenu() {

        var roleId = '${roleId! ""}';
        if (null == roleId || '' == roleId) {
            return;
        }

        //var res = [];
        var postJSON = JSON.stringify({"roleId":roleId});
        $.ajax({
            url: '${cx}/user/menu/getMenuXTree',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: postJSON,
            async: false,
            dataType: "json",
            success: function(data){

                if (null != data) {
                    menus = data;
                    console.log(data)
                }

            }

        });
    };




    layui.use(['table', 'layer', 'form'], function() {
        var layer = layui.layer

                , form = layui.form
                , table = layui.table
                , $ = layui.jquery;
        loadMenu();

        var xtree1 = new layuiXtree({
            elem: 'xtree1'   //(必填) 放置xtree的容器id，不要带#号
            , form: form     //(必填) layui 的 from
            , data: menus     //(必填) json数组（数据格式在下面）
        });


        //监听提交
        form.on('submit(form)', function(data){
            // layer.msg(JSON.stringify(data.field));
            //return false;
            var menuIdArr = new Array();

            var data = xtree1.GetChecked();
            for (var i = 0; i < data.length; i++) {
                console.log(data[i].value);
                menuIdArr.push(data[i].value);
            }

            if (menuIdArr.length <= 0) {

                layer.msg("请选择菜单信息");
                return false;
            }


            // 获取选中的菜单信息
            var postJSON = JSON.stringify({"roleId": '${roleId}', "menuIds": menuIdArr});
            // 验证成功，提交数据
            $.ajax({
                url: '${ctx}/user/roleMenu/addRoleMenuHandler',
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


        window.back = function() {
            var layIndex = parent.layer.getFrameIndex(window.name);
            layer.confirm('关闭后将无法保存已填写的数据，是否确认关闭', function () {
                parent.layer.close(layIndex);
                //parent.layer.close(index2);
            });
        };




    });


</script>


</html>