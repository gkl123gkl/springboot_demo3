/**
 * Created by admin on 2020/2/25.
 */
$(".register-btn").click(function () {
    login();
});
function login(){

    var custLoginAccount =$(".custLoginAccount").val();
    var custPassword=$(".custPassword").val();


    //正则表达式 0:手机 ， 1 邮箱 2 用户名
    var type;
    var account=custLoginAccount;

    if(/^[1][3,4,5,7,8][0-9]{9}$/.test(custLoginAccount)) {
        type = 0;
    } else if(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(custLoginAccount)){
        type=1;
    } else{
        type=2;
    }


    var formdata="account=" + account +"&type="+ type+"&custPassword="+ custPassword;
    $.ajax({
        type:"POST",
        url:"/customer/login",
        datatype:"json",
        data:formdata,
        success:function (result) {
            console.log(result);
            if(result.status==0){//登陆失败
               $(".loginMsg").text(result.data);
            }else{//登录成功,跳转到首页
                $(".loginMsg").text("");
               window.location.href="/index";
            }
        }
    });
}
