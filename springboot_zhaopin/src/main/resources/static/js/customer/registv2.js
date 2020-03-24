/**
 * Created by admin on 2020/2/24.
 */
 $(".tel-code").blur(function () {
     checkTelnoValide();
 })

 //1.验证手机号是否已经注册过
 function checkTelnoValide() {
     var telno=$(".tel-code").val();//获得手机号
     //发送ajax请求到后端，验证该手机号是否存在
     $.ajax({
         type:"GET",
         url:"/customer/getByTelno/" + telno,
         datatype:"json",
         success:function (result) {
             console.log(result);
             if(result.status==1){
                 //用户已经注册过
                 $(".registMsg").text(result.data);
             }else{
                 $(".registMsg").text("");
                 console.log("用户尚未注册："+result.data)
             }
         }
     });
 }

var interValObj;//计时器变量，控制时间
var count=120;//间隔函数
var curCount;//当前剩余秒数

//获得按钮点击，点击后，按钮内部显示倒计时
$(".sms-btn").click(function () {
    curCount=count;
    $(".sms-btn").attr("disabled","true");
    $(".sms-btn").val(curCount,"秒后重新发送");
    interValObj=window.setInterval(setRemainTime,1000);
});
function setRemainTime(){
    if(curCount==0){
        window.clearInterval(interValObj);
        $(".sms-btn").removeAttr("disabled");
        $(".sms-btn").val("重新发送验证码");
    }else{
        curCount--;
        $(".sms-btn").val(curCount + "秒后重新发送");
    }
}
var serverCode;//服务器中的短信验证码
//  获得页面手机号，ajax请求到后端先检查手机号，若没被注册过，获得验证码，服务器返回验证码
$(".sms-btn").click(function () {
    var telno=$(".tel-code").val();//获得手机号
    $.ajax({
        type:"POST",
        url:"/customer/getCode",
        data:"telno="+ telno,
        datatype:"json",
        success:function (result) {
            console.log(result);
            if(result.status==2) {
                //用户输入验证码
                serverCode=result.data;
            }else{
                $(".registMsg").text(result.data);
                window.clearInterval(interValObj);
                $(".sms-btn").removeAttr("disabled");
                $(".sms-btn").val("重新发送验证码");
            }
            }
    })
});
//带着验证码与表单中其他数据进行注册
$(".login-btn").click(function () {
    var inputCode=$(".sms-code").val();
    if(inputCode==serverCode){
        //ajax 请求注册用户 （添加数据到数据库中）
        console.log("ajax 请求注册用户 （添加数据到数据库中）");
        regist();
    }else{
        //用户输入的验证码错误
        $(".registMsg").text("验证码错误,请重新输入");
    }
});

// 注册业务（就是添加功能）
function regist() {
    var formdata=$(".regist_form").serialize();
    $.ajax({
        url:"/customer/regist",
        datatype:"json",
        type:"POST",
        data:formdata,
        success:function (result) {
            if(result.status==0){
                console.log("注册失败");
                $(".registMsg").text(result.data);
            }else{
                console.log("注册成功");
                window.location.href="/login";
            }
        }
    });

}




