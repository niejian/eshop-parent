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
    <div style="display: inline-block; width: 30%; height: 500px; padding: 10px; border: 1px solid #ddd; overflow: auto; float: left">
        <ul id="menuTree"></ul>
    </div>

    <div style="display: inline-block; width: 65%; height: 500px; padding: 10px; border: 1px solid #ddd; overflow: auto; float: right">
        <fieldset class="layui-elem-field site-demo-button">
            <legend>菜单详情</legend>
            <div class="demoTable" style="display: inline-block; margin-bottom: 10px; margin-top: 10px">
                <button class="layui-btn" onclick="add()"> <i class="layui-icon">&#xe654;</i>添加菜单</button>
                <button class="layui-btn layui-btn-normal" data-type="edit"> <i class="layui-icon">&#xe642;</i>编辑菜单</button>
                <button class="layui-btn layui-btn-warm" onclick="view()"> <i class="layui-icon">&#xe621;</i>查看菜单</button>
                <button class="layui-btn  layui-btn-danger"> <i class="layui-icon">&#xe640;</i>删除菜单</button>
            </div>
        </fieldset>

        <table class="layui-hide" id="menuTable" lay-filter='menuTable' ></table>

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

    // 左侧选中的菜单信息
    var checkedMenu = {};

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

    layui.use(['tree', 'table', 'layer', 'form'], function() {
        var layer = layui.layer
                , form = layui.form
                , table = layui.table
                , $ = layui.jquery;


        layui.tree({
            elem: '#menuTree' //指定元素
            , target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
            , click: function (item) { //点击节点回调
                //layer.msg('当前节名称：' + item.name + '<br>全部参数：' + JSON.stringify(item));
                console.log(item);
                checkedMenu = item;
                var data = new Array();
                data.push(item)
                console.log(data)
                table.init('menuTable', { //转化静态表格
                    data: data,
                    cols: [[ //表头, 这里要加两个中括号不然显示不出数据

                        {title:'#',width:80, type: 'radio'},
                        {title: '序号', width:80, align:"center", templet:'#tableIndex'}, //显示序号
                        {field: 'id', title: 'id', width:80, sort: true, align: 'center', fixed:"left", hide:true},
                        {field: 'menuCode', title: '菜单编码',  sort: true, align: 'center'},
                        {field: 'name', title: '菜单名称',  sort: true, align: 'center'},
                        {field: 'num', title: '排序',  sort: true, align: 'center'},
                        {field: 'url', title: '菜单路径',  sort: true, align: 'center'},
                        {field: 'leaf', title: '是否叶子节点',  sort: true, align: 'center',
                            templet: function(d) {
                                return d.leaf ? '是' : '否'
                            }}

                    ]]
                });
            }
            , nodes: menus
        });


        // table模块初始化
        table.render({
            elem: '#menuTable',
            data: [],
            cols: [[ //表头, 这里要加两个中括号不然显示不出数据

                {title:'#',width:80, type: 'radio'},
                {title: '序号', width:80, align:"center", templet:'#tableIndex'}, //显示序号
                {field: 'id', title: 'id', width:80, sort: true, align: 'center', fixed:"left", hide:true},
                {field: 'menuCode', title: '菜单编码',  sort: true, align: 'center'},
                {field: 'name', title: '菜单名称',  sort: true, align: 'center'},
                {field: 'num', title: '排序',  sort: true, align: 'center'},
                {field: 'url', title: '菜单路径',  sort: true, align: 'center'},
                {field: 'leaf', title: '是否叶子节点',  sort: true, align: 'center',
                    templet: function(d) {
                        return d.leaf ? '是' : '否'
                    }}
                ]]
        });

        // 选中行时，当前行被选中
        table.on('row(menuTable)', function(obj){

            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');//选中行样式
            obj.tr.find('input[lay-type="layTableRadio"]').prop("checked",true);
            var index = obj.tr.data('index')
            var thisData = table.cache.menuTable;//tableName 表名
            //重置数据单选属性
            layui.each(thisData, function(i, item){
                if(index === i){
                    item.LAY_CHECKED = true;
                } else {
                    delete item.LAY_CHECKED;
                }
            });

            form.render('radio');
        });

        // 添加菜单
        window.add = function() {
            // 先要选取父及菜单
            var checkStatus = table.checkStatus('menuTable'); // table标签的id属性
            var data = checkStatus.data;
            if (null == data || data.length == 0) {
                layer.msg('请选择菜单');

                return;
            }

            if (data[0].leaf) {
                layer.msg('请选择非叶子节点菜单');

                return;
            }
            debugger
            var parentId = data[0].menuId;
            var url = "${cx}/user/menu/addMenuView?parentId="+parentId;
            layer.open({
                id: "addMenuView",
                title: "添加菜单",
                type: 2,
                area: ["90%", "50%"],
                content: url,
                success: function(layero, index){
                    //console.log("add--" + index);
                },
                end: function () {
                    //resetForm();
                    //刷新表格数据
                    search();
                },
                cancel: function (index, layero) {
                    layer.close(index);

                    //resetForm();
                    search();
                    return false;
                }
            });



//            var id = data[0].id;
//            var url = data[0].url

        };


    });


</script>


</html>