<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>用户管理列表</title>
<#include "../../commom/include.css.ftl">
<#include "../../../../static/js/common/admin.common.js">
</head>
<body>
<input type="hidden" id="csrfToken" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="container">
    <div id="bootTableSearch">
    <#--BootStrap Table 搜索栏 start-->
          <#--BootStrap Table 搜索栏  end -->
        <input type="text" />
    </div>
    <table id="bootTable">
    <#--BootStrap Table-->
    </table>
</div>
</body>

<#include "../../commom/include.js.ftl">
<script src="/js/system/user/list.js"></script>
</html>
