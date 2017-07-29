<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
<#include "../../commom/include.hplus.css.ftl" />
<#include "../../commom/include.hplus.form.css.ftl" />
    <title>用户表单</title>
</head>
<body>

<div id="formWrapDiv" class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="page-header">
                <h2>{{id ? "修改":"注册"}}</h2>
            </div>

            <form id="registrationForm" method="post" class="form-horizontal"
                  data-add-action="/admin/user/add.do" data-update-action="/admin/user/update.do">
                <input type="hidden" id="csrfToken" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label class="col-sm-3 control-label">昵 称</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="name" v-model="name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">帐 号</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="loginNum" v-model="loginNum" v-bind:disabled="id"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">密 码</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="loginPwd" v-model="loginPwd" v-bind:disabled="id"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">确认密码</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" name="confirm_loginPwd" v-bind:disabled="id"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" name="email" v-model="email"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">手机号</label>
                    <div class="col-sm-5">
                        <input type="tel" class="form-control" name="phone" v-model="phone"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <!-- Do NOT use name="submit" or id="submit" for the Submit button -->
                        <button name="submitTo" type="submit" class="btn btn-default" v-if="!id">注 册</button>
                        <button name="submitTo" type="submit" class="btn btn-default" v-if="id">修 改</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<#include "../../commom/include.hplus.js.ftl" />
<#include "../../commom/include.hplus.form.js.ftl" />

<script>
    var formSelect = "#registrationForm";
    var dataEntity = ${dataEntity!'{}'};

    $(document).ready(function() {
        $(formSelect).bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh',

            },
//            group : "from-group-body",
            message: 'This value is not valid',
            submitButtons: 'button[name="submitTo"]',
            fields: {
                name: {
                    message: '昵称无效',
                    validators: {
                        notEmpty: {
                            message: '请填写昵称'
                        },
                        stringLength: {
                            min: 2,
                            max: 10,
                            message: '昵称在2-10字'
                        },
//                        regexp: {
//                            regexp: /^[a-zA-Z0-9]+$/,
//                            message: 'The username can only consist of alphabetical and number'
//                        },

                    }
                },
                loginNum: {
                    validators: {
                        notEmpty: {
                            message: '请填写帐号'
                        },
                        stringLength: {
                            min: 2,
                            max: 10,
                            message: '帐号在2-10字'
                        },
                        different: {
                            field: 'loginPwd',
                            message: '帐号和密码不能相同'
                        }
                    }
                },
                loginPwd: {
                    validators: {
                        notEmpty: {
                            message: '请填写密码'
                        },
                        different: {
                            field: 'loginNum',
                            message: '密码和帐号不能相同'
                        },
                        stringLength: {
                            min: 6,
                            message: '密码最少6个字母'
                        },
                        identical: {
                            field: 'confirm_loginPwd',
                            message: '密码和确认密码不一致'
                        }
                    }
                },
                confirm_loginPwd: {
                    validators: {
                        notEmpty: {
                            message: '请填写密码'
                        },
                        different: {
                            field: 'loginNum',
                            message: '密码和帐号不能相同'
                        },
                        stringLength: {
                            min: 6,
                            message: '密码最少6个字母'
                        },
                        identical: {
                            field: 'loginPwd',
                            message: '密码和确认密码不一致'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: '请填写邮箱地址'
                        },
                        emailAddress: {
                            message: '邮箱地址无效'
                        }
                    }
                },
                phone: {
                    validators: {
                        notEmpty: {
                            message: '请输入手机号'
                        },
                        phone : {
                            country : "CN",
                            message : "手机号无效"
                        }
                    }
                }
            }
        });
    }).on('success.form.bv', function(e) {

        alert("success.form.bv");

        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
        var url ;
        var data;
        if (dataEntity.hasOwnProperty("id") && dataEntity.id) {
            url = $form.attr('data-update-action');
            data = dataEntity;
            data[$("#csrfToken").attr("name")]=$("#csrfToken").val();
            data = JSON.stringify(data);
        } else {
            url = $form.attr('data-add-action');
            data = $form.serialize();
        }
        $.post(url, data, function(result) {
            alert(result.status + ":" + result.info);
        }, 'json');
    });

    var formVue = new Vue({
        el: "#formWrapDiv",
        data: dataEntity,
    });
</script>
</body>
</html>