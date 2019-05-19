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
<fieldset class="layui-elem-field site-demo-button" style="margin-top: 30px;">

</fieldset>
<#--数据展示-->
<#--<table lay-even class="layui-table">-->
    <#--<thead>-->
        <#--<tr>-->
            <#--<th>角色名称</th>-->
            <#--<th>角色编号</th>-->
            <#--<th>创建时间</th>-->
            <#--<th>创建人</th>-->
        <#--</tr>-->
    <#--</thead>-->
    <#--<tbody>-->
        <#--<#list roles as role>-->
            <#--<tr>-->
                <#--<td>${role.roleName}</td>-->
                <#--<td>${role.roleCode}</td>-->
                <#--<td>${role.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>-->
                <#--<td>${role.createBy}</td>-->
            <#--</tr>-->
        <#--</#list>-->
    <#--</tbody>-->
<#--</table>-->
<table id="roles" lay-filter='roles' ></table>
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

    console.log(roles)

    layui.use('table', function() {
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#roles',
            //height: 312,
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
//            table.render('radio');
        });
    });


</script>

</body>
</html>