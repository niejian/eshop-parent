<!DOCTYPE html>
<#include "common/base.ftl">
<html>
<head>
    <meta charset="utf-8">
    <title>添加角色</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
<#--    <link href="${ctx}/statics/js/layer/css/layui.css" rel="stylesheet" media="all">-->
    <#--<link href="${ctx}/statics/js/layer/css/modules/layer/default/layer.css" rel="stylesheet" media="all">-->
<#--    <script type="text/javascript" src="${ctx}/statics/js/jquery-1.9.1.min.js"></script>-->

<#--    <script type="text/javascript" src="${ctx}/statics/js/layer/layui.all.js"></script>-->
    <#--引入图标选择器-->
    <#--<script type="text/javascript" src="${ctx}/statics/js/layer/lay/modules/iconPicker-extend.js"></script>-->
    <#--<script type="text/javascript" src="${ctx}/statics/js/layer/lay/modules/iconPicker.js"></script>-->



</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加菜单信息</legend>
</fieldset>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜单编码</label>
            <div class="layui-input-inline">

                <#if type == 'add'>
                    <input type="text" name="menuCode" lay-verify="menuCode" autocomplete="off" placeholder="请输入菜单编码" class="layui-input"/>
                    <#else >
                     <input type="text" name="menuCode" value="${menu.menuCode}" readonly autocomplete="off" placeholder="请输入菜单编码" class="layui-input"/>
                     <input type="hidden" name="id" value="${menu.id}"/>

                </#if>

            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">菜单名称</label>
            <div class="layui-input-inline">
                <#if type == 'add'>
                    <input type="text" name="menuName" id="menuName" lay-verify="menuName" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
                <#elseif type == 'view'>
                     <input type="text" name="menuName" id="menuName" readonly value="${menu.menuName}" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
                <#elseif type == 'edit'>
                     <input type="text" name="menuName" id="menuName" value="${menu.menuName}" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">

                </#if>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">上级菜单</label>
            <div class="layui-input-inline">
                <#if type == 'add'>
                    <input type="hidden" name="parentId" value="${(parnetMenu.id)!''}"/>
                    <input type="hidden" name="parentIds" value="${(parnetMenu.parentIds)!''}"/>
                    <input type="text" name="parentMenuName" name="parentMenuName" value="${(parnetMenu.menuName)!''}"  readonly class="layui-input"/>
                <#elseif type == 'view'>
                    <input type="text" name="parentMenuName" readonly  name="parentMenuName" value="${(menu.parentMenuName)!''}"  readonly class="layui-input"/>
                <#elseif type == 'edit'>
                    <input type="text" id="parentMenuTree" name="parentId" lay-filter="parentMenuTree" placeholder="父菜单" value="${menu.parentId}" class="layui-input">
                </#if>
            </div>

        </div>
    </div>
    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">是否叶子节点</label>

            <div class="layui-input-inline">
                <#if type == 'add'>
                    <input type="checkbox" name="leaf" lay-filter="leafSwitch" value="false" lay-skin="switch" lay-text="是|否">
                <#elseif type == 'edit'>
                    <#--switch是否选中-->
                    <#if menu.leaf>
                        <input type="checkbox" name="leaf" lay-filter="leafSwitch" checked="" value="${menu.leaf}" lay-skin="switch" lay-text="是|否">
                    <#else >
                        <input type="checkbox" name="leaf" lay-filter="leafSwitch" lay-skin="switch" value="${menu.leaf}" lay-text="是|否">

                    </#if>

                <#else >
                    <#if menu.leaf>
                        <input type="checkbox" name="leaf" lay-filter="leafSwitch" checked="" disabled lay-skin="switch" lay-text="是|否">
                    <#else >
                        <input type="checkbox" name="leaf" lay-filter="leafSwitch" lay-skin="switch" disabled lay-text="是|否">

                    </#if>
                </#if>
            </div>



        </div>


        <div class="layui-inline">
            <label class="layui-form-label">访问地址</label>
            <div class="layui-input-inline">
                <#if type == 'add'>
                    <input type="text" name="menuUrl"  lay-verify="menuUrl" placeholder="菜单访问地址" disabled value="#" class="layui-input"/>
                    <#elseif type == 'edit'>
                    <input type="text" name="menuUrl"  lay-verify="menuUrl" value="${menu.menuUrl}"  class="layui-input"/>
                    <#else>
                    <input type="text" name="menuUrl"  lay-verify="menuUrl" disabled value="${menu.menuUrl}"  class="layui-input"/>

                </#if>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">页面排序</label>
            <div class="layui-input-inline">
                <#if type == 'add'>
                    <input type="text" name="num" lay-verify="required|number" value="0" class="layui-input"/>
                    <#elseif type == 'edit'>
                    <input type="text" name="num" value="${menu.num}" lay-verify="required|number" class="layui-input"/>

                    <#else >
                     <input type="text" value="${menu.num}" disabled lay-verify="required|number" class="layui-input"/>


                </#if>
            </div>
        </div>
        <#if type == 'add'>
            <div class="layui-inline" id="menuIcon" style="display: block">
                <label class="layui-form-label">菜单图标</label>
                <div class="layui-input-inline">
                    <input type="text" name="icon" id="icon" value="" placeholder="请输入菜单显示图标" autocomplete="off" width="80%" class="layui-input">

                </div>
                <#--<label class="layui-form-label">-->
                    <#--<a href="https://www.layui.com/doc/element/icon.html" style="color: green" target="_blank">图标参考链接</a>-->
                <#--</label>-->
            </div>
            <#elseif type != 'add' && !menu.leaf>
            <div class="layui-inline" id="menuIcon" style="display: block">
                <label class="layui-form-label">菜单图标</label>
                <div class="layui-input-inline">
                    <input type="text" name= 'icon' id="icon" value="${menu.icon}" lay-filter="icon" class="hide">

                <#--<input type="text" name="icon" id="icon" value="${menu.icon}" placeholder="请输入菜单显示图标" autocomplete="off" width="80%" class="layui-input">-->
                </div>

            </div>
        </#if>

    <div class="submitRole layui-form-item" style="padding-top: 20px">
        <div class="layui-row">
        <#--<div class="layui-col-xs4">-->
        <#--<div class="grid-demo grid-demo-bg1">1</div>-->
        <#--</div>-->
            <#if type == 'add'>
                <div class="layui-col-md6 layui-col-md-offset4">
            </#if>
            <#if type == 'edit'>
                <div class="layui-col-md6 layui-col-md-offset5">
            </#if>
            <#if type == 'view'>
                <div class="layui-col-md6 layui-col-md-offset5">
            </#if>
                <#if type != 'view'>
                    <button class="layui-btn" lay-submit lay-filter="menuForm"><i class="layui-icon">&#xe605 </i> &nbsp;确定</button>
                </#if>
                <#if type == 'add'>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </#if>
                <button type="button" class="layui-btn layui-btn-warm"  data-type="back"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

            </div>
        </div>
    </div>



</form>



</body>
<style type="text/css">
    .layui-inline .layui-form-label{
        width: 100px;
    }
</style>
<script type="text/javascript">

    var menus = new Array();

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

    loadMenu()
    layui.config({
        base: '${ctx}/statics/js/layer/lay/modules/' //假设这是你存放拓展模块的根目录
    }).extend({ //设定模块别名
        treeselect: 'treeselect', //如果 mymod.js 是在根目录，也可以不用设定别名
        iconPicker: 'iconPicker'

    });
    <#if type == 'edit'>
        // 声明扩展模块

        layui.use(['form', 'treeselect', 'iconPicker'], function(){

        <#else >
        layui.use(['form', 'iconPicker'], function(){
    </#if>

        var iconPicker = layui.iconPicker

        var form = layui.form;
        form.render();
        $ = layui.jquery;
        <#if type == 'edit'>
            var treeselect = layui.treeselect;
        </#if>

        // 表达校验信息
        form.verify({
            // 校验编码不为空且唯一
            menuCode: function(value) {
                if (null == value || '' == value) {
                    return '请输入菜单编码';
                }

                // 校验菜单编码唯一
                var msg = validMenuCode(value);

                if (null != msg && '' != msg && typeof (msg) != 'undefined') {
                    return msg
                }

            },
            menuName: function (value) {
                if (null == value || '' == value) {
                    return '请输入菜单名称';
                }
            },
            menuUrl: function (value) {
                if (null == value || '' == value) {
                    return '请输入菜单地址';
                }

            }
        });

        <#if type == 'edit'>
            treeselect.render({
                elem: "#parentMenuTree",
                data: menus,
                selected: function (data) {
                    layer.alert(JSON.stringify(data))
                },
                search: true,
                valueKey: "menuId",
                textKey: "name"

            });
        </#if>

        // 图标选择器渲染
        iconPicker.render({
            // 选择器，推荐使用input
            elem: '#icon',
            // 数据类型：fontClass/unicode，推荐使用fontClass
            type: 'fontClass',
            // 是否开启搜索：true/false，默认true
            search: true,
            // 是否开启分页：true/false，默认true
            page: true,
            // 每页显示数量，默认12
            limit: 18,
            // 点击回调
            click: function (data) {
                $("input[name=icon]").val(data.icon);
            },
            // 渲染成功后的回调
            success: function(d) {
                console.log(d);
            }
        });

        //监听指定开关
        form.on('switch(leafSwitch)', function(data){

            var checkStatus = data.elem.checked ? true : false
            // layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
            //     offset: '6px'
            // });
            debugger
            $("input[name=leaf]").val(checkStatus) ;
            // 如果是叶子节点
            if (checkStatus) {
                $("input[name=menuUrl]").val("");
                $("input[name=menuUrl]").removeAttr("disabled");
                $("#menuIcon").css("display", "none");
                //$("input[name=icon]").val("");
            } else {
                $("input[name=menuUrl]").val("#");
                $("input[name=menuUrl]").attr({"disabled":"disabled"});
                $("#menuIcon").css("display", "block");
            }
             //console.log(data);
            // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(menuForm)', function(data){
            // layer.msg(JSON.stringify(data.field));
            //return false;
            debugger
            var requestData = data.field;
            var isLeaf = $("input[name=leaf]").val();
            requestData.leaf = isLeaf;
            var postJSON = JSON.stringify(requestData);

            //console.log(postJSON);
            var url = '${cx}/user/menu/addMenuHandler';

            <#if  type == 'edit'>
                url = '${cx}/user/menu/editMenuHandler'
            </#if>

            // 验证成功，提交数据
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
                    } else {
                        var msg ='新增成功';
                        <#if  type == 'edit'>msg = "更新成功" </#if>
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

        //定义js方法
        window.validMenuCode =  function(menuCode) {
            var msg = '';
            $.ajax({
                url: '${cx}/user/menu/getMenuByMenuCode',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({menuCode: menuCode}),
                async: false,
                dataType: "json",
                success: function(data){

                    var isSuccess = data.success;
                    var responseData = data.data;

                    if (!isSuccess) {
                        layer.alert(data.errMsg);
                    } else if (isSuccess && null != responseData){
                        msg =  menuCode + "已存在";

                    }

                }
            });

            return msg;
        };

        var $ = layui.$, active = {
            // 点击返回，关闭本页面
            back: function() {
                var layIndex = parent.layer.getFrameIndex(window.name);
                layer.confirm('关闭后将无法保存已填写的数据，是否确认关闭', function () {
                    parent.layer.close(layIndex);
                    //parent.layer.close(index2);
                });
            }
        };
        $('.submitRole .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
</script>
</html>