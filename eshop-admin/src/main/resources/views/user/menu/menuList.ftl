<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>



</head>
<body>
<div style="width: 100%;height: 100%">
        <legend>菜单树</legend>
        <div style="display: inline-block; width: 30%; height: 500px; padding: 10px; border: 1px solid #ddd; overflow: auto;">
            <ul id="menuTree"></ul>
        </div>
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
    loadMenu();

    function loadMenu() {
        //var res = [];
        var postJSON = JSON.stringify({"A":"V"});
        $.ajax({
            url: '${cx}/user/menu/getMenuTree',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: postJSON,
            async: false,
            dataType: "json",
            success: function(data){

                if (null != data) {
                    menus = data;
                }

            }

        });
    };

    layui.use(['tree', 'layer'], function() {
        var layer = layui.layer
                , $ = layui.jquery;


        layui.tree({
            elem: '#menuTree' //指定元素
            , target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
            , click: function (item) { //点击节点回调
                layer.msg('当前节名称：' + item.name + '<br>全部参数：' + JSON.stringify(item));
                console.log(item);
            }
            , nodes: menus
        });


    });


</script>


</html>