<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<#include "common/base.ftl">
<html>
<head>
    <meta charset="utf-8">
    <title>菜单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
<#--    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet">-->
<#--    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>-->

<#--    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>-->



</head>
<style type="text/css">

</style>
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
                <@security.authorize access="hasRole('sysadmin')">
                    <button class="layui-btn  layui-btn-radius" onclick="add('add')"> <i class="layui-icon">&#xe654;</i>添加菜单</button>
                    <button class="layui-btn layui-btn-normal  layui-btn-radius" onclick="add('edit')"> <i class="layui-icon">&#xe642;</i>编辑菜单</button>
                    <button class="layui-btn layui-btn-warm layui-btn-radius" onclick="add('view')"> <i class="layui-icon">&#xe621;</i>查看菜单</button>
                    <button class="layui-btn  layui-btn-danger layui-btn-radius" onclick="del()"> <i class="layui-icon">&#xe640;</i>删除菜单</button>
                </@security.authorize>
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

        // 树形初始化
        window.initTree = function () {
            // 清空 树形区域
            $("#menuTree").html("");
            loadMenu();
            layui.tree({
                elem: '#menuTree' //指定元素
                , target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
                , click: function (item) { //点击节点回调
                    //layer.msg('当前节名称：' + item.name + '<br>全部参数：' + JSON.stringify(item));
                    checkedMenu = item;
                    var data = new Array();
                    data.push(item);
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
        }
        initTree();

        form.on("treeselect(treeselecttest)", function(data){
            layer.alert(JSON.stringify(data))
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
        window.add = function(type) {
            // 先要选取父及菜单
            var checkStatus = table.checkStatus('menuTable'); // table标签的id属性
            var data = checkStatus.data;


            if (null == data || data.length == 0) {
                layer.msg('请选择菜单');

                return;
            }

            // 点击新增按钮，选择的菜单要是非叶子节点菜单
            if (data[0].leaf && type === 'add') {
                layer.msg('请选择非叶子节点菜单');

                return;
            }
            var url = '';
            var title = '添加菜单';
            if (type === 'add') {
                var parentId = data[0].menuId;
                var url = "${cx}/user/menu/addMenuView?type=" + type + "&parentId=" + parentId;
            } else {
                var menuId = data[0].menuId;
                var url = "${cx}/user/menu/addMenuView?type=" + type + "&menuId=" + menuId;

                title = type === 'edit' ? '编辑菜单' : '查看菜单';
            }

            layer.open({
                id: "addMenuView",
                title: title,
                type: 2,
                area: ["90%", "60%"],
                content: url,
                success: function(layero, index){
                    //console.log("add--" + index);
                },
                end: function () {
                    //resetForm();
                    initTree();
                },
                cancel: function (index, layero) {
                    layer.close(index);

                    initTree();
                    return false;
                }
            });

        };
        
        window.del = function () {
            // 先要选取父及菜单
            var checkStatus = table.checkStatus('menuTable'); // table标签的id属性
            var data = checkStatus.data;

            if (null == data || data.length == 0) {
                layer.msg('请选择菜单');

                return;
            }

            debugger

            var postJSON = JSON.stringify({menuId: data[0].menuId})
            $.ajax({
                url: '${cx}/user/menu/delMenuHandler',
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
                        var msg ='删除成功';

                        layer.alert(msg, function(index) {
                            // 关闭当前提示的这个弹出层
                            layer.close(index);
                            initTree();
                            // var layIndex = parent.layer.getFrameIndex(window.name);
                            // parent.layer.close(layIndex);
                        });

                    }

                }
            });


        }


    });


</script>


</html>