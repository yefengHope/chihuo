<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>后台 - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="/html_model/hplus/css/login.min.css" rel="stylesheet">
    <#include "../commom/include.hplus.css.ftl" />
    <script>
        /*if (window.top !== window.self) {
            window.top.location = window.location
        }
        ;*/
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>[ H+ ]</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>H+ 后台主题UI框架</strong></h4>
                <ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                </ul>
                <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" action="/login.htm">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">登录到后台管理</p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input name="userName" type="text" class="form-control uname" placeholder="用户名"/>
                <input name="userPwd" type="password" class="form-control pword m-b" placeholder="密码"/>
                <a href="">忘记密码了？</a>
                <button class="btn btn-success btn-block" type="submit">登录</button>
            <#--<button class="btn btn-success btn-block" type="button" onclick="login()">登录</button>-->
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
        <#include "../commom/include.footer.ftl"/>
        </div>
    </div>
</div>
</body>
<#include "../commom/include.hplus.js.ftl" />
<#--<script>
    function login() {
        ajaxWarp({
            url: basePath + "/login.htm",
            data: $("form").serialize()
        })
    }
</script>-->
</html>