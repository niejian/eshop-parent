<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>角色菜单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>
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
    <form class="layui-form" action="" onsubmit="return false;">


        <div id="xtree1" style="width:100%;height: 100%;"></div>

        <div class="layui-row" style="padding-top: 20px">
        <#--<div class="layui-col-xs4">-->
        <#--<div class="grid-demo grid-demo-bg1">1</div>-->
        <#--</div>-->

            <div class="layui-col-md3 layui-col-md-offset3" style="padding-left: 150px">
                <button class="layui-btn" lay-submit lay-filter="roleForm"><i class="layui-icon">&#xe605 </i> &nbsp;确定</button>

                <button type="button" class="layui-btn layui-btn-warm"  data-type="back"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

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
    var menus = new Array();
debugger

    // 左侧选中的菜单信息
    var checkedMenu = {};

    function loadMenu() {
        //var res = [];
        var postJSON = JSON.stringify({"A":"V"});
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




    layui.use([ 'table', 'layer', 'form'], function() {
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




    });


</script>


</html>