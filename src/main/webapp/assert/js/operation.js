$("#email").blur(function () {
    var email = $("#email").val();
    var pattern = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    var errorInfo = "";
    if(email==""||email==null){
        errorInfo = "邮箱不能为空！"
    }else if(!pattern.test(email)){
        errorInfo = "邮箱格式不正确！"
    }
    $("#error-info-email").text(errorInfo);
});

$("#password").blur(function () {
    var password =$("#password").val();
    var errorInfo = "";
    if(password==""||password==null){
        errorInfo = "密码不能为空！"
    }
    $("#error-info-password").text(errorInfo);
});

$("#login").click(function(){
    var email = $("#email").val();
    var password =$("#password").val();
    var errorInfo_email="";
    var errorInfo_password="";
    var result = false;
    if(email==""||email==null){
        errorInfo_email = "邮箱不能为空！"
    }
    if(password==""||password==null){
        errorInfo_password = "密码不能为空！"
    }
    $("#error-info-email").text(errorInfo_email);
    $("#error-info-password").text(errorInfo_password);
    if(errorInfo_email!=""||errorInfo_password!=""){
        return false;
    }else{
        $.ajax({
            url:"/loginServlet",
            type:"post",
            data:{"email":email,"password":password},
            success:function (data) {
                if(data=="true"){
                    $("#error-info").text("");
                    window.location.href="/welcome.jsp";
                }else{
                    $("#error-info").text("邮箱或密码错误！");
                }
            }
        });
    }
});

$("#username").blur(function () {
    var username =$("#username").val();
    var errorInfo = "";
    if(username==""||username==null){
        errorInfo = "用户名不能为空！"
        $("#user-info").text(errorInfo);
    }else{
        $("#user-info").text("");
        $("#user-info").html("<img src='/assert/img/true-ico.ico'>");
    }

});

$("#new-email").blur(function () {
    var email = $("#new-email").val();
    var pattern = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    var errorInfo = "";
    if(email==""||email==null){
        errorInfo = "邮箱不能为空！"
    }else if(!pattern.test(email)){
        errorInfo = "邮箱格式不正确！"
    }else{
        $.ajax({
            url:"/verifyEmailIsRepeat",
            type:"post",
            data:{"newEmail":email},
            success:function (data) {
                if(data!="true"){
                    errorInfo = "邮箱已经被使用。"
                    $("#email-info").text(errorInfo);
                }else{
                    $("#email-info").html("<img src='/assert/img/true-ico.ico'>");
                }
            }
        });
    }
    $("#email-info").text(errorInfo);
});

$("#new-password-1").blur(function () {
    var password =$("#new-password-1").val();
    var errorInfo = "";
    if(password==""||password==null){
        errorInfo = "密码不能为空！"
        $("#password-info").text(errorInfo);
    }else{
        $("#password-info").text("");
        $("#password-info").html("<img src='/assert/img/true-ico.ico'>");
    }

});
$("#new-password-2").blur(function () {
    var password1 =$("#new-password-1").val();
    var password2 =$("#new-password-2").val();
    var errorInfo = "";
    if(password1==""||password1==null){
        errorInfo = "密码不能为空！"
        $("#confirm-info").text(errorInfo);
    }else if(password1!=password2){
        $("#confirm-info").text("两次密码输入不一样！");
    }else{
        $("#confirm-info").text("");
        $("#confirm-info").html("<img src='/assert/img/true-ico.ico'>");
    }

});

$("#sub").click(function () {
    var username = $("#username").val();
    var email = $("#new-email").val();
    var password = $("#new-password-1").val();

    $.ajax({
        url:"/addUser",
        type:"post",
        data:{"username":username,"email":email,"password":password},
        success:function (data) {
            if(data=="success"){
                clearInfo();
                $('.modal').map(function () {
                    if(!$(this).is(":hidden")){
                        $(this).modal('hide');
                    }
                });
                $("#registration-success").fadeToggle(1500);
                $("#registration-success").fadeToggle(1500);



            }
        }
    });
})

$("*[data-dismiss='modal']").click(function () {
    clearInfo();
});

function clearInfo() {
   $(".form-control").val("");
    $(".error-Info").html("");
}