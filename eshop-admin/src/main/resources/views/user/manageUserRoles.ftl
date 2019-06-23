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
    $(document).on("click",".layui-table-body table.layui-table tbody tr", function () {
        var index = $(this).attr('data-index');
        var tableBox = $(this).parents('.layui-table-box');
        //存在固定列
        if (tableBox.find(".layui-table-fixed.layui-table-fixed-l").length>0) {
            tableDiv = tableBox.find(".layui-table-fixed.layui-table-fixed-l");
        } else {
            tableDiv = tableBox.find(".layui-table-body.layui-table-main");
        }
        //获取已选中列并取消选中
        var trs = tableDiv.find(".layui-unselect.layui-form-checkbox.layui-form-checked").parent().parent().parent();
        for(var i = 0;i<trs.length;i++){
            var ind = $(trs[i]).attr("data-index");
            if(ind!=index){
                var checkCell = tableDiv.find("tr[data-index=" + ind + "]").find("td div.laytable-cell-checkbox div.layui-form-checkbox I");
                if (checkCell.length>0) {
                    checkCell.click();
                }
            }
        }
        //选中单击行
        var checkCell = tableDiv.find("tr[data-index=" + index + "]").find("td div.laytable-cell-checkbox div.layui-form-checkbox I");
        if (checkCell.length>0 & trs.length===1) {
            checkCell.click();
        }
        checkCell.click();

    });

    $(document).on("click", "td div.laytable-cell-checkbox div.layui-form-checkbox", function (e) {
        e.stopPropagation();
    });
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
    obj.createTime = '${data.createTime.time}';
    obj.createBy = '${data.createBy}';
    obj.modifyTime = '${data.modifyTime.time}';
    obj.modifyBy = '${data.modifyBy}';
    obj.checked = '${data.checked}';
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
                var data = res.data;
                var existRoles = new Array();
                data.forEach(function(value, key) {
                    debugger
                    if(value.checked === 'true' ){
                        value["LAY_CHECKED"]='true';
                        var index = value['LAY_TABLE_INDEX'];
                        $('tr[data-index=' + index + '] input[type="checkbox"]').prop('checked', true);
                        $('tr[data-index=' + index + '] input[type="checkbox"]').next().addClass('layui-form-checked');
                        existRoles.push(value)

                    }
//                    debugger
                    //这里必须选择点击方法，不知为何添加layui-form-checked class属性会造成二次点击（即下次点击必须点击两下才能生效）bug，
                    //所有类似的手动修改class貌似都会造成二次效果
//                    if(value.checked === 'true' ){
//                        jquery("div[lay-id='roles'] td .layui-form-checkbox").eq(key).click();
//                    }

                })

                table.checkStatus().data = existRoles;
                console.log(existRoles)
                console.log(table.checkStatus())

            },



        });

        // 选中行时，当前行被选中
        table.on('row(roles)', function(obj){

            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');//选中行样式
            obj.tr.find('input[lay-type="layTableCheckbox"]').prop("checked",true);
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

            form.render('checkbox');
            // console.log(obj.data);
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
        debugger
        var checkStatus = table.checkStatus('roles'); // table标签的id属性
        var datas = checkStatus.data;
        if (null == datas || datas.length == 0) {
            layer.msg('请选择角色');

            return;
        }

        var roleInfo = new Array();
        // 获取所选角色信息
        datas.forEach(function(value, key) {

            var role = {};
            role.id = value.id;
            role.roleCode = value.roleCode;
            roleInfo.push(role);
        });

        var postJSON = JSON.stringify({data: roleInfo, userId: '${userId}'})

return
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