<!DOCTYPE html>
<#--引入公共的css，js-->
<#include "common/base.ftl">
<html>
<head>
    <script type="text/javascript" src="${ctx}/statics/js/md5.js"></script>

</head>
    <body>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>用户注册</legend>

        </fieldset>

        <form class="layui-form" action="">


            <div class="layui-form-item">
                <div class="registDiv layui-inline">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-username" ></label>
                        <input type="tel" name="userName" lay-verify="userName"  autocomplete="off" placeholder="用户名" class="registInput layui-input">
                    </div>
                </div>
                <div class="registDiv layui-inline">
                    <label class="layui-form-label">昵称：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-user" ></label>
                        <input type="text" name="userNickName" lay-verify="userNickName" autocomplete="off" placeholder="昵称" class="registInput layui-input">
                    </div>
                </div>
                <div class="registDiv layui-inline">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-password" ></label>
                        <input type="password" name="userPassword" lay-verify="userPassword" autocomplete="off" placeholder="密码" class="registInput layui-input">
                    </div>
                </div>

                <div class="registDiv layui-inline">
                    <label class="layui-form-label">确认密码：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-vercode" ></label>
                        <input type="password" name="confirmPassword" lay-verify="confirmPassword" autocomplete="off" placeholder="密码" class="registInput layui-input">
                    </div>
                </div>

                <div class="registDiv layui-inline">
                    <label class="layui-form-label">头像：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-picture" ></label>
                        <input type="text" name="avatar" lay-verify="avatar" autocomplete="off" placeholder="头像" class="registInput layui-input">
                    </div>
                </div>
            </div>


            <div class="layui-form-item submitForm layui-row">
                <#--<div class="layui-col-xs4">-->
                <#--<div class="grid-demo grid-demo-bg1">1</div>-->
                <#--</div>-->

                <div class="layui-col-md4" style="padding-left: 100px">
                    <button class="layui-btn layui-btn-radius"   lay-submit lay-filter="registry"><i class="layui-icon layui-icon-ok"> </i> &nbsp;确定</button>
                    <button type="reset" class="layui-btn layui-btn-radius layui-btn-primary"><i class="layui-icon layui-icon-refresh-1"> </i> 重置</button>

                    <button type="button" class="layui-btn layui-btn-radius layui-btn-warm"  data-type="back"><i class="layui-icon">&#xe603;</i>&nbsp;返回</button>

                </div>
            </div>

        </form>
    </body>

<style type="text/css">
    .iconLabel {
        position: absolute;
        line-height: 40px;
        height: 40px;
        padding-left: 10px;
        padding-right: 10px;
    }

    .registInput {
        padding-left: 40px;
        height: 40px;
        line-height: 40px;
        width:300px;

    }

    .registDiv{
        padding-top: 10px;
        padding-bottom: 10px;
    }

    .submitForm {
        margin-top: 10px;
    }
</style>
<script type="text/javascript">
    layui.use('form', function(){
        var form = layui.form;

        // 表达校验信息
        form.verify({
            // 校验编码不为空且唯一
            userName: function(value) {
                if (null == value || '' == value) {
                    return '请输入用户名';
                }

                if (value.length < 4) {
                    return '用户名长度至少为4';
                }

                 // 校验用户名是否唯一
                 var msg = valifyUserName(value);

                 if (null != msg && '' != msg && typeof (msg) != 'undefined') {
                     return msg
                 }

            },
            userNickName: function (value) {
                if (null == value || '' == value) {
                    return '请输入昵称';
                }
            },
            userPassword: function (value) {
                if (null == value || '' == value) {
                    return '请输入密码';
                }
                // 校验密码复杂度
                if (value.length < 6) {
                    return '密码长度最少为6位';
                }

                if (! (/[A-Za-z]{1}/.test(value))) {
                    return '密码需要至少包含一个英文字母';
                }
            },
            // 确认密码
            confirmPassword: function(value) {
                // 获取用户密码
                var userPassword = $("input[name=userPassword]").val();

                if (userPassword !== value) {
                    return '两次密码输入不一致，请重新输入！';
                }

            }
        });

        // 校验登录名是否唯一
        window.valifyUserName =  function(userName) {
            var msg = '';
            $.ajax({
                url: '${cx}/user/getUserByUserName',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({userName: userName}),
                async: false,
                dataType: "json",
                success: function(data){

                    var isSuccess = data.success;
                    var responseData = data.data;

                    if (!isSuccess) {
                        layer.alert(data.errMsg);
                    } else if (isSuccess && null != responseData){
                        msg =  "用户名：" + userName + "已存在";
                    }

                }
            });

            return msg;
        };

        //监听提交
        form.on('submit(registry)', function(data){
            // layer.msg(JSON.stringify(data.field));
            //return false;

            // md5 密码
            var pwd = data.field.userPassword;
            if (null == pwd || '' == pwd || typeof (pwd) == 'undefined') {
                layer.msg("请输入注册密码");
                return false;
            }

            data.field.userPassword = md5(pwd);
            var postJSON = JSON.stringify(data.field);

            // 验证成功，提交数据
            $.ajax({
                url: '${cx}/user/doRegistry',
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
                        var msg ='注册成功';
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

