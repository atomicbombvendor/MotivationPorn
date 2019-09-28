/**
 * 登录
 */
$(function () {
    layui.use(['form', 'layer'], function () {
        var form = layui.form;
        var layer = layui.layer;
        form.on("submit(login)", function () {
            login();
            return false;
        });

        let token = localStorage.getItem("motivation_porn_token");
        if (token === null){
            layer.alert("获取token失败, 登录失败。");
        }else{
            layer.alert("获取token成功。" + token);
            window.location.href = "/home";
        }
        // var path = window.location.href;
        // if (path.indexOf("kickout") > 0) {
        //     layer.alert("您的账号已在别处登录；若不是您本人操作，请立即修改密码！", function () {
        //         window.location.href = "/login";
        //     });
        // }
    })
})

function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var rememberMe = $("#rememberMe").val();
    $.post("/user/login",
        $("#useLogin").serialize(),
        function (result) {
            if (result.code === 200) {
                localStorage.setItem("motivation_porn_token", result.data);
            } else {
                layer.alert(result.message, function () {
                    layer.closeAll(); //关闭所有弹框
                });
            }
        });
}
