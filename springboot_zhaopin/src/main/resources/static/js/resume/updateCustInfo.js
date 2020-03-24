/**
 * Created by admin on 2020/3/2.
 */
//日期格式的转换
function getFullDate(ms) {
    var d=new Date(ms);
    var year=d.getFullYear();
    var month=d.getMonth();
    var day=d.getDate();
    return year+"-" + month + "-" + day;
}

/*================      获取简历中个人的基本信息          ======================*/

document.querySelector(".gender-click").onclick = function (event) {
    var ele = event.target;

    var manBtn = document.querySelector(".man-btn");
    var manIcon = document.querySelector(".man-icon");
    var womenBtn = document.querySelector(".women-btn");
    var womenIcon = document.querySelector(".women-icon");

    if (ele.nodeName = "BUTTON" && ele.className == "man-btn" && ele.style.color != "white") {
        manBtn.style = "color:white;background-color:#ff9f20;";
        manIcon.style = "background:url('/zhaopin/images/MM.png');background-size:15px 15px;";
        womenBtn.style = "color:black;background-color:#F0F0F0;";
        womenIcon.style = "background:url('/zhaopin/images/FF.png');background-size:15px 15px;";
        document.querySelector(".user-page").style = "background-image:url('/zhaopin/images/man.png')"
        // $(".user-page").css("background-image","url('../images/man.png')");
    } else if (ele.nodeName = "BUTTON" && ele.className == "women-btn" && ele.style.color != "white") {
        manBtn.style = "color:black;background-color:#F0F0F0;";
        manIcon.style = "background:url('/zhaopin/images/MM.png');background-size:15px 15px;";
        womenBtn.style = "color:white;background-color:#ff9f20;";
        womenIcon.style = "background:url('/zhaopin/images/FF.png');background-size:15px 15px;";
        document.querySelector(".user-page").style = "background-image:url('/zhaopin/images/woman.png'); display: inline-block; width: 85px;height: 105px;"
    }

}


document.querySelector(".user-save-btn").onclick = function () {
    updateCustInfo();
}

//修改简历中的个人信息
function updateCustInfo(){
    //获取简历中的个人信息
    var resumeId=$(".resumeId").val();
    var custName=$(".perName").val();
    var custGender;
    var gender=document.querySelectorAll(".gender-click button");
    for(var i=0;i<gender.length;i++){
        if(gender[i].style.color=="white"){
            custGender=gender[i].innerText.trim();
            custGender=(custGender=='男'?'M':'F');
        }
    }
    var custBirthday=$(".birthday").val();
    var custStartWorkYear=$(".startworkyear").val();
    var custTelno=$(".phone").val();
    var custWorkStatus=$(".select-type option:selected").text();
    var custEmail=$(".email").val();
    var custLocation=$(".loc").val();
    var custPersonId=$(".id").val();
    console.log("resumeId:"+resumeId);
    console.log("custName:"+custName);
    console.log("custGender:"+custGender);
    console.log("custBirthday:"+custBirthday);
    console.log("custStartWorkYear:"+custStartWorkYear);
    console.log("custTelno:"+custTelno);
    console.log("custWorkStatus:"+custWorkStatus);
    console.log("custEmail:"+custEmail);
    console.log("custLocation:"+custLocation);
    console.log("custPersonId:"+custPersonId);
    //ajax请求
    $.ajax({
        type:"post",
        url:"/resume/custInfo",
        datatype:"json",
        data:{
            "_method":"PUT",
            "resumeId":resumeId,
            "custName":custName,
            "custGender":custGender,
            "custBirthday":custBirthday,
            "custStartWorkYear":custStartWorkYear,
            "custTelno":custTelno,
            "custWorkStatus":custWorkStatus,
            "custEmail":custEmail,
            "custLocation":custLocation,
            "custPersonId":custPersonId
        },
        success:function (result) {
            console.log(result);
            $(".user-infor").hide();
            $(".preview-infor").show();

            if(result.status==1){//修改成功
                console.log("修改成功")
                //将修改后的数据渲染到页面中
                //用户名
                $(".p-username").text(result.data.others1);
                //工作年限
                var workyear=new Date().getFullYear()-result.data.others2;
                //性别
                var gender=result.data.resumeGender=='M'?'男':'女';
                //年龄
                var age=new Date().getFullYear()-(new Date(result.data.resumeBirth).getFullYear())+1;
                //出生日期
                var birthday=getFullDate(result.data.resumeBirth);
                var value="现居住于" + result.data.resumeLiveCity + "|" + workyear + "年工作经验 |" + gender + age + "岁("+ birthday +") |" + result.data.resumeLeavingWorking;
                $(".p-user-content p").text(value);
                //邮箱
                $(".p-email").text(result.data.resumeEmail);
                //手机号
                $(".p-phone").text(result.data.resumeTelno);
                //更新时间
                var updateTime =  getFullDate(result.data.resumeUpdateTime);
                $(".update-time").text(updateTime);
            }else{
                console.log("修改失败");
                console.log(result.data);
            }
        }
    });
}



$(".user-title a").click(function () {
    $(".preview-infor").hide();
    $(".user-infor").show();

    $(".user-page").css("background-image", person.personImg);
    $(".perName").text(person.personName);
    $(".birthday").text(person.personBirthday);
    $(".startworkyear").text(person.startWorkYear);
    $(".phone").text(person.personTel);
    $(".email").text(person.personEmail);
    $(".loc").text(person.personLoc);
    $(".card-select").val(person.idCardType);
    $(".id").text(person.personId);
    $(".select-type").val(person.personJObType);
})


$(".user-undo-btn").click(function () {
    $(".user-infor").hide();
    $(".preview-infor").show();

    /*================     向简历展示中填写个人的基本信息          ======================*/

    var nowTime = new Date();

    $(".p-username").text(person.personName);
    $(".p-user-icon").css("background-image", person.personImg)

    var workyear = nowTime.getFullYear() - person.startWorkYear;
    var age = nowTime.getFullYear() - person.personBirthday.substring(0, 4);

    //现居住于苏州工业园区 | 1年工作经验 | 男 | 22岁(1997/08/20) | 目前正在找工作

    var value = "现居住于" + person.personLoc + " | " + workyear + "年工作经验  |" + person.personGender +
        age + "岁(" + person.personBirthday + ")  |  " + person.personJObType;

    $(".p-user-content p").text(value);

    $(".p-email").text(person.personEmail);
    $(".p-phone").text(person.personTel);
})