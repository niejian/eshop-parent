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
<#--角色管理页面-->
<fieldset class="layui-elem-field site-demo-button">
    <legend></legend>
    <div class="demoTable">
        <button class="layui-btn"> <i class="layui-icon">&#xe654;</i> 添加</button>
        <button class="layui-btn layui-btn-normal" data-type="edit"> <i class="layui-icon">&#xe642;</i>编辑</button>
        <button class="layui-btn layui-btn-warm"> <i class="layui-icon">&#xe615;</i>查看</button>
        <button class="layui-btn  layui-btn-danger"> <i class="layui-icon">&#xe640;</i>删除</button>
    </div>
</fieldset>

<table class="layui-hide" id="roles" lay-filter='roles' ></table>

</body>

<#--为了让表格显示行号-->
<script type="text/html" id="tableIndex">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/javascript">

    var roles = new Array();
    <#list roles as role>
        var obj = {};
        obj.id = '${role.id}';
        obj.roleCode = '${role.roleCode}';
        obj.roleName = '${role.roleName}';
        obj.createTime = "${role.createTime?string('yyyy-MM-dd hh:mm:ss')}";
        obj.createBy = '${role.createBy}';
        roles.push(obj);
    </#list>



    layui.use(['table', 'form'], function() {
        var table = layui.table;
        var form = layui.form;
        //第一个实例
        table.render({
            // id: 'role-table',
            elem: '#roles',
            // height: 500,
            //url: '/demo/table/user/', //数据接口,
            <#--data: '${roles}',-->
            data: roles,
            page: true, //开启分页
            cols: [[ //表头, 这里要加两个中括号不然显示不出数据

                {title:'#',width:80, type: 'radio'},
                {title: '序号', width:80, align:"center", templet:'#tableIndex'}, //显示序号
                {field: 'id', title: 'id', width:80, sort: true, align: 'center', fixed:"left", hide:true},
                {field: 'roleCode', title: '角色编码',  sort: true, align: 'center'},
                {field: 'roleName', title: '角色名称',  sort: true, align: 'center'},
                {field: 'createTime', title: '创建时间',  sort: true, align: 'center'},
                {field: 'createBy', title: '创建人',  sort: true, align: 'center'}

            ]]
        });

        // 选中行时，当前行被选中
        table.on('row(roles)', function(obj){

            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');//选中行样式
            obj.tr.find('input[lay-type="layTableRadio"]').prop("checked",true);
            var index = obj.tr.data('index')
            var thisData = table.cache.roles;//tableName 表名
            //重置数据单选属性
            layui.each(thisData, function(i, item){
                if(index === i){
                    item.LAY_CHECKED = true;
                } else {
                    delete item.LAY_CHECKED;
                }
            });

            form.render('radio');
            // console.log(obj.data);
        });

        // 自定义js方法
        var $ = layui.$, active = {
            edit: function() { //获取选中数据

                var checkStatus = table.checkStatus('roles'); // table标签的id属性
                var data = checkStatus.data;
                if (null == data || data.length == 0) {
                    layer.msg('请选择一条数据进行编辑');

                    return;
                }

                layer.alert(JSON.stringify(data));

                var id = data[0].id;

                var url = "${cx}/user/editRole?type=edit&id=" + id;
                layer.open({
                    id: "editRole",
                    title: "更新角色信息",
                    type: 2,
                    area: ["90%", "50%"],
                    content: url,
                    success: function(layero, index){
                        //console.log("add--" + index);
                    },
                    end: function () {
                        //resetForm();
                        //刷新表格数据
                        //search();
                    },
                    cancel: function (index, layero) {

                        layer.confirm('关闭后将无法保存已填写的数据，是否确认关闭', function (index2) {
                            layer.close(index);
                            layer.close(index2);
                        });
                        //resetForm();
                        //search();
                        return false;
                    }
                });



            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


    });

    // function edit() {
    //     debugger
    //     var checkStatus = table.checkStatus('roleTable'); //idTest 即为基础参数 id 对应的值
    //
    //     console.log(checkStatus.data) //获取选中行的数据
    // }


</script>


</html>