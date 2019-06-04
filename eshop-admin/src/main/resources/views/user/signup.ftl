<!DOCTYPE html>
<#--引入公共的css，js-->
<#include "common/base.ftl">
<html>
<head>


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
                        <input type="tel" name="userName" lay-verify="required"  autocomplete="off" placeholder="用户名" class="registInput layui-input">
                    </div>
                </div>
                <div class="registDiv layui-inline">
                    <label class="layui-form-label">昵称：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-user" ></label>
                        <input type="text" name="userNickName" lay-verify="required" autocomplete="off" placeholder="昵称" class="registInput layui-input">
                    </div>
                </div>
                <div class="registDiv layui-inline">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-password" ></label>
                        <input type="password" name="userPassword" lay-verify="required" autocomplete="off" placeholder="密码" class="registInput layui-input">
                    </div>
                </div>

                <div class="registDiv layui-inline">
                    <label class="layui-form-label">头像：</label>
                    <div class="layui-input-inline">
                        <label class="iconLabel layui-icon layui-icon-picture" ></label>
                        <input type="password" name="userPassword" lay-verify="required" autocomplete="off" placeholder="头像" class="registInput layui-input">
                    </div>
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
</style>
<script>

</script>

</html>

