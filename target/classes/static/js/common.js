//展示loading
function g_showLoading() {
    var idx = layer.msg('处理中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollb: false,offset: '0px',time:10000});
    return idx;
}


//设置加密关键字
var g_password_salt="1a2b3c4d"