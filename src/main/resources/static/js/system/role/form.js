/**
 * Created by Administrator on 2017/7/18.
 */
"use strict";
var buttonWatch = null;

$(document).ready(function() {
    /*加载时间插件*/
    $(".plug_datetime").datetimepicker({language:"zh-CN",format : "yyyy-mm-dd hh:ii:ss"})
    // 选择时间被改变   changeDate
    // 时间选择器被隐藏 hide
        .on('hide', function(ev){
            /*校验字段 ，因为通过js写入的字段不能更新*/
            $(formSelect).bootstrapValidator('updateStatus', ev.target.name, 'NOT_VALIDATED')
                .bootstrapValidator('validateField', ev.target.name);
        });
    // 表单校验
    $(formSelect).bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh',

        },
        message: 'This value is not valid',
        submitButtons: 'button[name="submitTo"]',
        fields: {
            name: {
                message: '角色名称无效',
                validators: {
                    notEmpty: {
                        message: '请填写角色名称'
                    },
                    stringLength: {
                        min: 2,
                        max: 10,
                        message: '角色名称在2-10字'
                    },

                }
            },
            nameKey: {
                validators: {
                    notEmpty: {
                        message: '请填写角色键名'
                    },
                    stringLength: {
                        min: 2,
                        max: 10,
                        message: '角色键名在2-10字'
                    },
                }
            },
            validity: {
                validators: {
                    notEmpty: {
                        message: '请填写角色有效期'
                    }
                }
            },
            sort : {
                validators : {
                    notEmpty: {
                        message: '请填写序号'
                    },
                    between : {
                        min : 1,
                        max : 200,
                        message: '序号范围 1- 200'
                    }
                }
            },
            status : {
                validators : {
                    notEmpty: {
                        message: '请选择状态'
                    },
                }
            }
        }
    });
}).on('success.form.bv', function(e) {
//        alert("success.form.bv");
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
    } else {
        url = $form.attr('data-add-action');
        data = $form.serialize();
    }

    var ajaxOpt = {
        url : url,
        data : data,
        success: function (result) {
            if (result.status) {
                Toast.showSuccess(result.info,"成功");
                parentRefreshBST();
                setTimeout(function() {
                    // 如果是 *并关闭 按钮 ，当前js有一个事件点击监控事件
                    var isClose = BV.isCloseFrame($form);
                    if (isClose) {
                        closeCurIframe();
                    }
                },200);
            } else{
                Toast.showError(result.info,"失败");
            }
        }
    };
    ajaxWarp(ajaxOpt);
});