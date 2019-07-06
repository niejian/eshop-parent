<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<#include "common/base.ftl">
<html>
<head>
    <meta charset="utf-8">
    <title>编辑用户角色管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <script type="text/javascript" src="${ctx}/statics/js/common/table-checkbox-select.js"></script>
</head>
<body>




<form class="layui-form" action="">
    <table class="layui-hide" id="roles" lay-filter='roles' ></table>

    <div>

        <br/> <br/> <br/>
        <div class="submitRole layui-form-item">
            <div class="layui-row">
            <#--<div class="layui-col-xs4">-->
            <#--<div class="grid-demo grid-demo-bg1">1</div>-->
            <#--</div>-->

                <div class="layui-col-md6 layui-col-md-offset4">
                    <button class="layui-btn"  lay-submit lay-filter="roleForm"><i class="layui-icon">&#xe605 </i> &nbsp;确定</button>

                    <button type="button" class="layui-btn layui-btn-warm"  onclick="back()"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

                </div>
            </div>
        </div>

</form>

</body>
<script type="text/javascript">

</script>

<#--为了让表格显示行号-->
<script type="text/html" id="tableIndex">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/javascript">

    var roles = new Array();
    <#list list as data>
    var obj = {};

    obj.id = ${data.id};
    obj.roleCode = '${data.roleCode}';
    obj.roleName = '${data.roleName}';
    console.log('${data.createTime.time}'.replace(/,/g, ''))

    obj.createTime = convertMillionSecondStr('${data.createTime.time}'.replace(/,/g, ''));
    obj.createBy = '${data.createBy}';
    obj.modifyTime = convertMillionSecondStr('${data.modifyTime.time}'.replace(/,/g, ''));
    obj.modifyBy = '${data.modifyBy}';
    obj.checked = '${data.checked}';
    debugger
    // 添加 LAY_CHECKED 属性，回显checkbox数据
    if (obj.checked === 'true') {
        obj.LAY_CHECKED = true;
    }else {
        obj.LAY_CHECKED = false;
    }
    roles.push(obj)
    </#list>





layui.use(['element', 'table', 'form'], function() {
    var table = layui.table;
    var jquery = layui.jquery;
    var element = layui.element;

    var form = layui.form;
    var index = layer.load(1); //添加laoding,0-2两种方式

        //第一个实例
    table.render({
            elem: '#roles',
            // height: 500,

            data: roles,
            limit: 10, // 每页条数
            limits: [10,20,50],  //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]

            // 请求参数

           where: {},
//             data: roles,
            page: false, //开启分页
            cols: [[ //表头, 这里要加两个中括号不然显示不出数据

                {title:'#',width:80, type: 'checkbox'},
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

            },
        });


        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        window.back =  function() {
            var layIndex = parent.layer.getFrameIndex(window.name);
            layer.confirm('关闭后将无法保存已填写的数据，是否确认关闭', function () {
                parent.layer.close(layIndex);
                //parent.layer.close(index2);
            });
        };

    form.on('submit(roleForm)', function(data){

        var checkStatus = table.checkStatus('roles'); // table标签的id属性
        var datas = checkStatus.data;
//        if (null == datas || datas.length == 0) {
//            layer.msg('请选择角色');
//
//            return;
//        }

        var roleInfo = new Array();
        // 获取所选角色信息
        datas.forEach(function(value, key) {

            var role = {};
            role.id = value.id;
            role.roleCode = value.roleCode;
            roleInfo.push(role);
        });

        var postJSON = JSON.stringify({data: roleInfo, userId: '${userId}'})

        // 验证成功，提交数据
        $.ajax({
            url: '${ctx}/user/role/updateUserRole',
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
                    var msg ='角色信息更新成功';
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



});







</script>


</html>