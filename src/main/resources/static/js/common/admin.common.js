var basePath = "";

/* start 提示弹框*/
var Toast = {
    defualtOpt : {
        "closeButton": true,
        "debug": false,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "onclick": null,
        "showDuration": "400",
        "hideDuration": "1000",
        "timeOut": "7000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    },
    i: -1,
    toastCount: 0,
    $toastlast: null,
    getMessage: function () {
        var msg = "Hi, welcome to Inspinia. This is example of Toastr notification box.";
        return msg
    },
    getLast: function () {
        return this.$toastlast;
    },
    clearLast: function () {
        toastr.clear(this.getLast());
    },
    clear: function () {
        toastr.clear()
    }
};
Toast.showSuccess = function (msg,title,opt) {
    opt = $.extend(this.defualtOpt, opt);
    toastr["success"](msg, title);
};
Toast.showInfo = function (msg,title,opt) {
    opt = $.extend(this.defualtOpt, opt);
    toastr["info"](msg, title);
};
Toast.showWarn = function (msg,title,opt) {
    opt = $.extend(this.defualtOpt, opt);
    toastr["warning"](msg, title);
};

Toast.showError = function (msg,title,opt) {
    opt = $.extend(this.defualtOpt, opt);
    toastr["error"](msg, title);
};

/*  end  提示弹框*/


/* start ajax */
function ajaxWarp(option) {
    var loading = null;
    var defualtOtion = {
        dataType: 'json',
        method: 'post',
        beforeSend: function () {
            //loading层
            loading = layer.load(1, {
                shade: [0.3, '#fff'] //0.1透明度的白色背景
            });
            return true;
        },
        success: function () {

        },
        error: function (data) {
            var info = data.info;
            if (info) {
                alert("错误 : " + info);
            } else {
                alert("错误 : " + data.info);
            }

        },
        complete: function () {
            layer.close(loading);
        }
    };
    defualtOtion = $.extend(defualtOtion, option);
    $.ajax(defualtOtion);

}

/*  end  ajax */

/* start layer*/

var Layer = {};
Layer.iframeOpen = function (opt) {
    var o = {
        type: 2,
        title: 'layer页',
        shadeClose: true,
        shade: 0.8,
        area: ['90%', '90%'],
        content: '' //iframe的url
    };
    o = $.extend(o,opt);
    //iframe层
    parent.layer.open(o);
};

/*  end  layer*/

/* start 列表方法*/
var BootstrapTableFunc = {};
/**
 * 跳转到添加表单
 * @param url       表单访问地址
 * @param tapsIndex  选项卡索引
 * @param tapsName   选项卡名字
 * @param data      携带参数
 **/
BootstrapTableFunc.toAddForm = function (url, tapsIndex, tapsName, data) {
    if (!url) {
        throw "url is empty";
    }
    if (!data) {
        data = {};
    }
    Layer.iframeOpen({title:tapsName,content : url})
};
/**
 * 跳转编辑表单,自动获取表单id
 * @param selector   bootstrap table 的选择器
 * @param url        表单访问地址
 * @param tapsIndex  选项卡索引
 * @param tapsName   选项卡名字
 **/
BootstrapTableFunc.toEditForm = function (selector, url, tapsIndex, tapsName, data) {
    if (!selector || !url) {
        throw "selector or url is empty";
    }
    var arr = $(selector).bootstrapTable("getSelections");
    if ( 1 === arr.length) {

        if (!data) {
            data = {};
        }

        var o = arr[0];
        if (o.hasOwnProperty("id")) {
            data.id = o.id;
            url += "?id=" + o.id
        } else {
            console.error("key -> id not exist");
        }
        Layer.iframeOpen({title:tapsName,content : url});
    } else {
        Toast.showInfo("请选中一条数据");
    }


};
/**
 * 删除行数据
 * @param selector  bootstrap table 的选择器
 * @param url       表单访问地址
 * @param data      携带参数
 **/
BootstrapTableFunc.delRowsData = function (selector, url, data) {
    if (selector && url) {
        if (!data) {
            data = {};
        }

        var arr = $(selector).bootstrapTable("getSelections");
        var tArr = [];
        for (var i = 0, l = arr.length; i < l; i++) {
            var o = arr[i];
            if (o.hasOwnProperty("id")) {
                tArr.push(o.id);
            } else {
                console.error("key -> id not exist");
            }
        }
        data.ids = tArr.join(",");
        ajaxWarp({
            url: url,
            data: data,
            success: function (result) {
                if (result.status) {
                    Toast.showSuccess(result.info);
                } else {
                    alert(result.info);
                }
            }

        });
    } else {
        throw "selector or url is empty";
    }
};
/*  end  列表方法*/

