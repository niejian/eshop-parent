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


</head>
<body>
<fieldset class="layui-elem-field">
    <legend>刷选条件</legend>
    <form class="layui-form" action="" onsubmit="return false;">

        <div class="layui-inline">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">

                <input type="text" name="userName" name="userName" autocomplete="off" placeholder="用户名" class="layui-input"/>

            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">

                <input type="text" name="userNickName" name="userNickName" autocomplete="off" placeholder="昵称" class="layui-input"/>

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



<table class="layui-hide" id="users" lay-filter='users' ></table>

</body>

<#--为了让表格显示行号-->
<script type="text/html" id="tableIndex">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<#--显示操作按钮-->
<script type="text/html" id="opBar">
    <#--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>-->
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑权限</a>
    <#--<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>-->
</script>

<script type="text/html" id="statusTpl">
    <input type="checkbox" lay-skin="switch" lay-filter="switchChange" value="true" lay-text="有效|无效" {{!d.deleteFlag ?"checked":"" }}>
</script>

<script type="text/javascript">

    layui.use(['element', 'table', 'form'], function() {
        var table = layui.table;

        var form = layui.form;
        var index = layer.load(1); //添加laoding,0-2两种方式

        //第一个实例
        table.render({
            elem: '#users',
            // height: 500,
            url: '${ctx}/user/manageUserList', //数据接口,
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
            loading: true,
            // totalRow: true, //开启合计行
            // toolbsar: 'default',
//             data: roles,
            page: true, //开启分页
            cols: [[ //表头, 这里要加两个中括号不然显示不出数据

                {title:'#',width:80, type: 'radio', fixed: 'left'},
                {title: '序号', width:80, align:"center", templet:'#tableIndex'}, //显示序号
                {field: 'id', title: 'id', width:80, sort: true, align: 'center',  hide:true},
                {field: 'userCode', title: '用户编码',  sort: true, align: 'center'},
                {field: 'userName', title: '用户名',  sort: true, align: 'center'},
                {field: 'userNickName', title: '昵称',  sort: true, align: 'center'},
                {field: 'avatar', title: '头像',  sort: true, align: 'center'},
                {field: 'deleteFlag', title: '是否有效',  sort: true, align: 'center', templet: statusTpl},
                {field: 'createTime', title: '创建时间',  sort: true, align: 'center'},
                {field: 'createBy', title: '创建人',  sort: true, align: 'center'},
                {field: 'modifyTime', title: '修改时间',  sort: true, align: 'center'},
                {field: 'modifyBy', title: '修改人',  sort: true, align: 'center'},


                {fixed: 'right', title:'操作', align:'center', toolbar: '#opBar',  width: 165}

            ]],
            done:function (res) {   //返回数据执行回调函数
                layer.close(index);    //返回数据关闭loading

            }

        });

        //监听行工具事件
        table.on('tool(users)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){

                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){

                var userId = data.id;
                changeUserRole(userId);
            }
        });

        // 编辑用户权限
        window.changeUserRole = function(userId) {


            var url = "${cx}/user/role/updateUserRole?userId=" + userId;
            layer.open({
                id: "updateUserRole",
                title: "添加用户角色信息",
                type: 2,
                area: ["92%", "50%"],
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
           // searchRole()
            table.render({
                elem: '#changeUserRole',
                // height: 500,
                url: '${ctx}/user/role/getRoles', //数据接口,
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
        };

        // switch转换，获取到当前行的id
        form.on('switch(switchChange)', function(obj){
            var data = $(obj.elem);
            var id = data.parents('tr').first().find('td').eq(2).text();
            // 是否删除
            var deleteFlag = obj.elem.checked ? false : true

            if (null != id && '' != id) {
                var url = '${cx}/user/updateUser'
                var postJSON = JSON.stringify({id: id, deleteFlag: deleteFlag})
                $.ajax({
                    url: url,
                    type: 'POST',
                    contentType: "application/json; charset=utf-8",
                    data: postJSON,
                    async: false,
                    dataType: "json",
                    success: function(data){

                        var isSuccess = data.success;
                        if (!isSuccess) {
                            layer.alert(data.errMsg);
                            search();
                        } else {
                            var msg ='更新成功';
                            layer.msg(msg);
                            search();


                        }

                    }
                });
            }
        })

        // 选中行时，当前行被选中
        table.on('row(users)', function(obj){

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

        // 重新加载表格信息
        window.search = function() {
            var userName = $("input[name=userName]").val();
            var userNickName = $("input[name=userNickName]").val();
            table.reload('users', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    userName: userName,
                    userNickName: userNickName
                }
            });

        }


    });


</script>
</html>
