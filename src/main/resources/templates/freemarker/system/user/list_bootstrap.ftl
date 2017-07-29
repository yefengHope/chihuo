<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>用户列表 - Bootstrap Table</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <#include "../../commom/include.hplus.css.ftl" />
    <#include "../../commom/include.hplus.list.css.ftl" />
    <base target="_blank">
</head>

<body class="gray-bg">
<input type="hidden" id="csrfToken" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">

        <div class="col-sm-12">
            <!-- Example Events -->
            <div class="example-wrap">
                <div class="btn-group hidden-xs" id="bootTableSearch" role="group">
                    <button type="button" class="btn btn-outline btn-default">
                        <i class="glyphicon glyphicon-plus" aria-hidden="true"
                           onclick="BootstrapTableFunc.toAddForm('/admin/user/to_add.htm','user_1','新增用户',null)">新增</i>
                    </button>
                    <button type="button" class="btn btn-outline btn-default">
                        <i class="glyphicon glyphicon-edit" aria-hidden="true"
                           onclick="BootstrapTableFunc.toEditForm('#bootTable','/admin/user/to_update.htm','user_2','编辑用户')">编辑</i>
                    </button>
                    <div class="btn-group">
                        <button data-toggle="dropdown" class="btn btn-outline btn-default dropdown-toggle" aria-expanded="false">
                            <i class="glyphicon glyphicon-list-alt" aria-hidden="true">状态</i>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void">启用</a>
                            </li>
                            <li><a href="javascript:void">禁用</a>
                            </li>
                            <li><a href="javascript:void"
                                   onclick="BootstrapTableFunc.delRowsData('#bootTable','/admin/user/del_rows.htm')">删除</a>
                            <#--<li class="divider"></li>-->
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="example">
                    <table id="bootTable">
                    </table>
                </div>
            </div>
            <!-- End Example Events -->
        </div>
    </div>
</div>
</div>
<!-- End Panel Other -->
</div>
<#include "../../commom/include.hplus.js.ftl" />
<#include "../../commom/include.hplus.list.js.ftl" />


<#--<#include "../../commom/include.js.ftl">-->
<script src="/js/system/user/list.js"></script>
</body>
</html>