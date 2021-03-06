<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<#include "common/base.ftl">
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
<#--    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet">-->
<#--    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.3.1.min.js"></script>-->

<#--    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>-->



</head>
<body>
<fieldset class="layui-elem-field">
    <legend>刷选条件</legend>
    <form class="layui-form" action="" onsubmit="return false;">

        <div class="layui-inline">
            <label class="layui-form-label">角色编码</label>
            <div class="layui-input-inline">

                <input type="text" name="roleCode" name="roleCode" autocomplete="off" placeholder="角色编码" class="layui-input"/>

            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-inline">
                <input type="text" name="roleName" id="roleName"  placeholder="角色名称"  class="layui-input">

            </div>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <div class="layui-inline demoTable">
            <button class="layui-btn layui-btn-radius" onclick="search()"><i class="layui-icon layui-icon-search"></i>查询</button>
            <button type="reset" class="layui-btn layui-btn-primary layui-btn-radius"><i class="layui-icon layui-icon-refresh-1"></i>&nbsp;重置</button>
        </div>
    </form>
    <br/>
</fieldset>
<#--角色管理页面-->
<fieldset class="layui-elem-field site-demo-button">
    <div class="demoTable" style="margin-bottom: 10px">
        <@security.authorize access="hasRole('sysadmin')">
<#--        <@security.authorize access="isAuthenticated()">-->
            <button class="layui-btn layui-btn-radius" data-type="add"> <i class="layui-icon layui-icon-add-1"></i> 添加</button>
            <button class="layui-btn layui-btn-normal layui-btn-radius" data-type="edit"> <i class="layui-icon layui-icon-edit"></i>编辑</button>


            <button class="layui-btn layui-btn-warm layui-btn-radius" onclick="view()"> <i class="layui-icon layui-icon-file"></i>查看</button>
            <button class="layui-btn layui-btn-radius" onclick="bindMenu()"> <i class="layui-icon layui-icon-add-circle"></i>绑定菜单</button>
            <button class="layui-btn  layui-btn-danger layui-btn-radius"> <i class="layui-icon layui-icon-delete"></i>删除</button>
        </@security.authorize>
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


    layui.use(['element', 'table', 'form'], function() {
        var table = layui.table;

        var form = layui.form;
        var index = layer.load(1); //添加laoding,0-2两种方式

        //第一个实例
        table.render({
            elem: '#roles',
            // height: 500,
            url: '${cx}/user/role/getRoles', //数据接口,
            <#--data: '${roles}',-->
            method: 'post',
            contentType: "application/json",
            limit: 10, // 每页条数
            limits: [10,20,50],  //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]
            parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.data //解析数据列表
                };
            },
            // 请求参数

           where: {},
//             data: roles,
            page: true, //开启分页
            cols: [[ //表头, 这里要加两个中括号不然显示不出数据

                {title:'#',width:80, type: 'radio'},
                {title: '序号', width:80, align:"center", templet:'#tableIndex'}, //显示序号
                {field: 'id', title: 'id', width:80, sort: true, align: 'center', fixed:"left", hide:true},
                {field: 'roleCode', title: '角色编码',  sort: true, align: 'center'},
                {field: 'roleName', title: '角色名称',  sort: true, align: 'center'},
                {field: 'createTime', title: '创建时间',  sort: true, align: 'center'},
                {field: 'createBy', title: '创建人',  sort: true, align: 'center'},
                {field: 'modifyTime', title: '修改时间',  sort: true, align: 'center'},
                {field: 'modifyBy', title: '修改人',  sort: true, align: 'center'}

            ]],
            done:function (res) {   //返回数据执行回调函数
                layer.close(index);    //返回数据关闭loading

            }

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

        // 查看按钮点击事件
        window.view = function () {
            var checkStatus = table.checkStatus('roles'); // table标签的id属性
            var data = checkStatus.data;
            if (null == data || data.length == 0) {
                layer.msg('请选择一条数据进行操作');

                return;
            }

            var id = data[0].id;

            var url = "${cx}/user/role/editRole?type=view&id=" + id;
            layer.open({
                id: "editRole",
                title: "查看角色信息",
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

        };

        // 绑定菜单、按钮信息
        window.bindMenu = function() {
            var checkStatus = table.checkStatus('roles'); // table标签的id属性
            var data = checkStatus.data;
            if (null == data || data.length == 0) {
                layer.msg('请选择一条数据进行操作');

                return;
            }

            // roleId
            var id = data[0].id;
            var url = "${ctx}/user/role/manageRoleMenu?id=" + id;
            layer.open({
                id: "manageRoleMenu",
                title: "角色菜单管理",
                type: 2,
                area: ["500px", "500px"], // 宽200高度自适应
                content: url,
                success: function(layero, index){
                    // 获取子页面的iframe
                    var iframe = window['layui-layer-iframe' + index];
                    // 向子页面的全局函数getRoleId传参
                    iframe.getRoleId(id);
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

        };

        // 重新加载表格信息
        window.search = function() {
            var roleCode = $("input[name=roleCode]").val();
            var roleName = $("input[name=roleName]").val();
            table.reload('roles', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    roleCode: roleCode,
                    roleName: roleName
                }
            });

        }

        // 自定义js方法
        var $ = layui.$, active = {
            edit: function() { //获取选中数据

                var checkStatus = table.checkStatus('roles'); // table标签的id属性
                var data = checkStatus.data;
                if (null == data || data.length == 0) {
                    layer.msg('请选择一条数据进行编辑');

                    return;
                }

                //layer.alert(JSON.stringify(data));

                var id = data[0].id;

                var url = "${cx}/user/role/editRole?type=edit&id=" + id;
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
                        search();
                    },
                    cancel: function (index, layero) {

                        layer.confirm('关闭后将无法保存已填写的数据，是否确认关闭', function (index2) {
                            layer.close(index);
                            layer.close(index2);
                        });
                        //resetForm();
                        search();
                        return false;
                    }
                });
            },
            add: function () {
                var url = "${cx}/user/role/addRole";
                layer.open({
                    id: "addRole",
                    title: "添加角色信息",
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

                        layer.confirm('关闭后将无法保存已填写的数据，是否确认关闭', function (index2) {
                            layer.close(index);
                            layer.close(index2);
                        });
                        //resetForm();
                        search();
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


</script>


</html>