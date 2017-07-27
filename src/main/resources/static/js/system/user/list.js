/**
 * Created by Administrator on 2017/7/18.
 */
"use strict";

var bootTableSelector = "#bootTable";
var bootTableSearchSelector = "#bootTableSearch";
var bootTable = {};
//table init
bootTable.init = function () {
    $(bootTableSelector).bootstrapTable({
        /*
         请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，
         例如 toolbar 中的参数 如果 queryParamsType = 'limit' ,
         返回参数必须包含 :
         limit, offset, search, sort, order
         否则, 需要包含:
         pageSize, pageNumber, searchText, sortName, sortOrder.
         返回false将会终止请求
         */
        striped : true, /*设置为 true 会有隔行变色效果*/
        // contentType : "application/json",
        contentType:'application/x-www-form-urlencoded',
        dataType : "json",
        method: "post",
        queryParamsType : "limit",
        pagination : true, /*设置为 true 会在表格底部显示分页条*/
        paginationLoop : true, /*设置为 true 启用分页条无限循环的功能*/
        sidePagination : "server",
        pageNumber : 1, /*如果设置了分页，首页页码*/
        pageSize : 10,/*如果设置了分页，页面数据条数*/
        pageList : [10, 25, 50],/*如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。*/
        escape : false, /*默认 ： false， 转义HTML字符串，替换 &, <, >, ", `, 和 ' 字符.*/
        searchTimeOut : 500, /*设置搜索超时时间*/
        singleSelect : true,/*禁止多选*/
        url : basePath + "/user/page_data.json",
        queryParams : function(params) {
            /*重写自定义参数*/
             var retObj = {
                pageSize : params.limit,
                pageNumber :params.offset/10 + 1,

            };
             retObj[$("#csrfToken").attr("name")] =  $("#csrfToken").val();
            return retObj;
        },
        responseHandler : function(res) {
            /*加载服务器数据之前的处理程序，可以用来格式化数据。
             参数：res为从服务器请求到的数据。*/
            return res;
        },
        toolbar : bootTableSearchSelector, /*自定义的toolbar*/
        columns : [
            {
                idField: 'id',
                checkbox: true,
                // clickToSelect : true,/*点击选中行*/
                // formatter : function(value,row,index){},
                // events : function(event,value,row,index){/*the jQuery event. */},
                align: 'center'
            },
            {
                field : "loginNum",
                title : "登录账号",
                align: 'center'
            },
            {
                field : "loginPwd",
                title : "登录密码",
                align: 'center'
            },
            {
                field : "name",
                title : "账号昵称",
                align: 'center'
            },
            {
                field : "phone",
                title : "手机号码",
                align: 'center'
            },
            {
                field : "email",
                title : "email",
                align: 'center'
            },
            {
                field : "status",
                title : "账号状态",
                align: 'center'
            },
            {
                field : "headIcon",
                title : "账号头像",
                align: 'center'
            },
            {
                field : "updateId",
                title : "更新id",
                align: 'center'
            },
            {
                field : "updateName",
                title : "更新人名称",
                align: 'center'
            },
            {
                field : "updateDate",
                title : "更新时间",
                align: 'center'
            }
        ],
    });
};

$(function () {
    bootTable.init();
});