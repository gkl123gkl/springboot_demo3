/*      创建个人信息对象         */
var person = {
    personName: null,
    personImg: null,
    personGender: null,
    personBirthday: null,
    startWorkYear: null,
    personTel: null,
    personJObType: null,
    personEmail: null,
    personLoc: null,
    idCardType: null,
    personId: null,
    personIncome: null
}


/*================      修改简历名称          ======================*/
//点击修改按钮
function updateOpen() {
    var titleEle = document.querySelector(".update-resume-name").parentElement.parentElement;
    console.log(titleEle);
    var oldName = document.querySelector(".update-resume-name").parentElement.previousElementSibling.innerText;
    console.log("oldName:" + oldName);
    titleEle.innerHTML = "<input type=\"text\" class=\"input-name resume_name\" value=" + oldName + " >\n" +
        "                    <button class=\"save-btn1\" onclick=\"saveUpdateName()\">保存</button>\n" +
        "                    <button class=\"undo-btn\" onclick=\"undo()\">取消</button>";


    console.log(document.querySelector(".save-btn1"));
}





function undo() {
    var titleEle = document.querySelector(".save-btn1").parentElement;
    titleEle.innerHTML = "<span class=\"title-h3\" style=\"line-height: 90px\">我的简历</span>\n" +
        "                    <a href=\"JavaScript:void(0)\" onclick=\"updateOpen()\"><img src=\"/images/update.png\" class=\"update-resume-name\" style=\"margin:33px 30px\"></a>";

}


/*+++++++++++++++            左侧浮动固定在页面             +++++++++++++++=*/
window.onscroll = function () {
    var leftNavDiv = document.querySelector(".left-nav")
    var height = document.body.scrollTop || document.documentElement.scrollTop;
    // console.log(height);
    if (height >= 60) {
        leftNavDiv.style = "position:fixed;top:0;"
    } else {
        leftNavDiv.style = ""
    }

}


/*================      修改简历中的照片          ======================*/
$(".do a").click(function () {
    $(".update-user-page").show();           ////   未完善
})


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
        //  $(".user-page").css("background-image","url('./images/women.png')");
    }

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


/*    添加、修改年薪    */

$(".year-income-title img").click(function () {
    $(".show-income").hide();
    $(".year-income").show();

})


/*   保存年薪   */
$(".income-save-btn").click(function () {
    $(".year-income").hide();
    $(".show-income").show();
    person.personIncome = $(".income-money").val();
    console.log(person.personIncome)
    if (person.personIncome == "" || person.personIncome == null || person.personIncome == "0") {
        $(".year-income-title i").remove();
    } else {
        $(".income-value").text(person.personIncome);
    }
})

/*    取消    */
$(".income-undo-btn").click(function () {
    $(".year-income").hide();
    $(".show-income").show();
    if (person.personIncome == "" || person.personIncome == null || person.personIncome == "0") {
        $(".year-income-title i").remove();
    } else {
        $(".income-value").text(person.personIncome);
    }
});


/*      求职意向       */
$(".salary-type").click(function () {
    var salaryType = $(".salary-type").val();
    if (salaryType == "年薪") {
        $(".year-salary").show();
        $(".month-salary").hide();
        $(".day-salary").hide();
        $(".hour-salary").hide();
    } else if (salaryType == "月薪") {
        $(".year-salary").hide();
        $(".month-salary").show();
        $(".day-salary").hide();
        $(".hour-salary").hide();
    } else if (salaryType == "日薪") {
        $(".year-salary").hide();
        $(".month-salary").hide();
        $(".day-salary").show();
        $(".hour-salary").hide();
    } else {
        $(".year-salary").hide();
        $(".month-salary").hide();
        $(".day-salary").hide();
        $(".hour-salary").show();
    }
});


var exceptJob = {
    salaryType: null,
    salaryRange: null,
    workLoc: null,
    jobLevel: null,
    labelSelf: null,
    introduceSelf: null,
    arrivalJobTime: null,
    ejobType: null
}


$(".job-save").click(function () {
    $(".job-intention").hide();
    $(".job-intention-show").show();

    exceptJob.salaryType = $(".salary-type").val();
    switch (exceptJob.salaryType) {
        case "年薪":
            exceptJob.salaryRange = $(".year-salary").val();
            break;
        case "月薪":
            exceptJob.salaryRange = $(".month-salary").val();
            break;
        case "日薪":
            exceptJob.salaryRange = $(".day-salary").val();
            break;
        case "时薪":
            exceptJob.salaryRange = $(".hour-salary").val();
            break;
    }
    exceptJob.workLoc = $(".workLoc").val();
    exceptJob.jobLevel = $(".job-level").val();
    exceptJob.labelSelf = $(".label-self").val();
    exceptJob.introduceSelf = $(".introduce-self").val();
    exceptJob.arrivalJobTime = $(".arrival-job-time").val();
    exceptJob.ejobType = $(".job-type").val();

    $(".salary").text(exceptJob.salaryRange + "/" + exceptJob.salaryType);
    $(".work-loc1").text(exceptJob.workLoc);
    $(".job-level1").text(exceptJob.jobLevel);
    $(".label-self1").text(exceptJob.labelSelf);
    $(".introduce-self1").text(exceptJob.introduceSelf);
    $(".arrival-time1").text(exceptJob.arrivalJobTime);
    $(".job-type1").text(exceptJob.ejobType);


});


$(".job-not-save").click(function () {
    $(".job-intention").hide();
    $(".job-intention-show").show();


    $(".salary").text(exceptJob.salaryRange + "/" + exceptJob.salaryType);
    $(".work-loc1").text(exceptJob.workLoc);
    $(".job-level1").text(exceptJob.jobLevel);
    $(".label-self1").text(exceptJob.labelSelf);
    $(".introduce-self1").text(exceptJob.introduceSelf);
    $(".arrival-time1").text(exceptJob.arrivalJobTime);
    $(".job-type1").text(exceptJob.ejobType);

});


$(".job-show-title a").click(function () {
    $(".job-intention").show();
    $(".job-intention-show").hide();

    $(".salary-type").val(exceptJob.salaryType);
    switch (exceptJob.salaryType) {
        case "年薪":
            $(".year-salary").val(exceptJob.salaryRange);
            break;
        case "月薪":
            $(".month-salary").val(exceptJob.salaryRange);
            break;
        case "日薪":
            $(".day-salary").val(exceptJob.salaryRange);
            break;
        case "时薪":
            $(".hour-salary").val(exceptJob.salaryRange);
            break;
    }
    $(".workLoc").val(exceptJob.workLoc);
    $(".job-level").val(exceptJob.jobLevel);
    $(".label-self").val(exceptJob.labelSelf);
    $(".introduce-self").val(exceptJob.introduceSelf);
    $(".arrival-job-time").val(exceptJob.arrivalJobTime);
    $(".job-type").val(exceptJob.ejobType);
});


/*       工作经验         */

//console.log($(".btn-jian").val())
$(".btn-jian").click(function () {
    $(".btn-quan").css("background-color", "white");
    $(".btn-quan").css("color", "black");
    $(".btn-quan").css("border", "1px solid black");
    $(".btn-jian").css("background-color", "#ff6000");
    $(".btn-jian").css("color", "white");
    $(".btn-jian").css("border", "none");
});

$(".btn-quan").click(function () {
    $(".btn-quan").css("background-color", "#ff6000");
    $(".btn-quan").css("color", "white");
    $(".btn-quan").css("border", "none");
    $(".btn-jian").css("background-color", "white");
    $(".btn-jian").css("color", "black");
    $(".btn-jian").css("border", "1px solid black");
});


/*    工作经验列表    */
var experList = new Array();

function show1() {
    $(".job-experience-show").hide();
    $(".job-experience").show();
    $(".job-exper-key").val("");
}
$(".job-expr-save").click(function () {
    $(".job-experience-show").show();
    $(".job-experience").hide();

    /*    工作经验对象     */
    var jobExper = {
        jobTime: null,
        company: null,
        experJobLevel: null,
        companySize: null,
        depatement: null,
        companyType: null,
        jobDescription: null,
        experJobType: null
    };


    jobExper.jobTime = $(".time-ipt").val()
    jobExper.company = $(".company-name").val()
    jobExper.experJobLevel = $(".expr-job-level").val()
    jobExper.companySize = $(".expr-company-size").val()
    jobExper.depatement = $(".expr-dept").val()
    jobExper.companyType = $(".company-type").val()
    jobExper.jobDescription = $(".job-description").val()
    var experBtnList = $(".last-expr-row button");
    for (var i = 0; i < experBtnList.length; i++) {
        if (experBtnList[i].style.color == "white") {
            jobExper.experJobType = experBtnList[i].innerText;
            console.log("jobExper.experJobType = " + jobExper.experJobType)
        }
    }
    console.log(jobExper);

    var index = $(".job-exper-key").val();

    if (jobExper.jobTime != null && jobExper.company != null && jobExper.experJobLevel != null
        && jobExper.companySize != null && jobExper.depatement != null && jobExper.companyType != null
        && jobExper.jobDescription != null && jobExper.experJobType != null) {

        if (experList.length == 0) {
            experList[0] = jobExper;
        } else if (experList.length != 0 && index == "") {
            experList[experList.length] = jobExper;
        } else {
            experList[index] = jobExper;
        }


    }
    initExper();

});


$(".job-expr-unsave").click(function () {
    $(".job-experience-show").show();
    $(".job-experience").hide();

    initExper();
});


// console.log(document.querySelector(".job-experience-show"))

document.querySelector(".job-experience-show").onclick = function (event) {

    var ele = event.target;


    if (ele.nodeName == "IMG") {
        var nextEle = ele.parentElement.nextElementSibling.lastElementChild;
        var preEle = ele.parentElement.previousElementSibling.lastElementChild;

        // console.log(nextEle);
        // console.log(preEle);

        if (nextEle != null && nextEle.nodeName == "IMG") {
            $(".job-experience-show").hide();
            $(".job-experience").show();

            var index = ele.parentElement.parentElement.lastElementChild.value;
            var jobExper = experList[index];


            $(".job-exper-key").val(index);
            $(".time-ipt").val(jobExper.jobTime);
            $(".company-name").val(jobExper.company);
            $(".expr-job-level").val(jobExper.experJobLevel);
            $(".expr-company-size").val(jobExper.companySize);
            $(".expr-dept").val(jobExper.depatement);
            $(".company-type").val(jobExper.companyType);
            $(".job-description").val(jobExper.jobDescription);


            if (jobExper.experJobType == "全职") {
                $(".btn-quan").css("background-color", "#ff6000");
                $(".btn-quan").css("color", "white");
                $(".btn-quan").css("border", "none");
                $(".btn-jian").css("background-color", "white");
                $(".btn-jian").css("color", "black");
                $(".btn-jian").css("border", "1px solid black");
            } else {
                $(".btn-quan").css("background-color", "white");
                $(".btn-quan").css("color", "black");
                $(".btn-quan").css("border", "1px solid black");
                $(".btn-jian").css("background-color", "#ff6000");
                $(".btn-jian").css("color", "white");
                $(".btn-jian").css("border", "none");
            }

        } else if (preEle.nodeName == "IMG") {
            var index = ele.parentElement.parentElement.lastElementChild.value;
            experList.splice(index, 1);
            console.log(experList.length)
            initExper();
        }
    }


}

function initExper() {
    document.querySelector(".jse-con").innerHTML = "";
    for (var i = 0; i < experList.length; i++) {
        var exper = experList[i];
        var time = exper.jobTime.substring(0, 4) + "/" + exper.jobTime.substring(5, 14) + "/" + exper.jobTime.substring(15, 17);
        console.log("time = " + time)
        var ssstring = "计算机软件 | " + exper.companySize + " | " + exper.companyType + " | " + exper.depatement;

        var experHtml = "<div class=\"jes-content\">\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>" + time + "</span>\n" +
            "                        <em class=\"em1\">" + exper.company + "</em>\n" +
            "                        <em class=\"em2\">" + exper.experJobLevel + "</em>\n" +
            "                        <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/images/update.png\"></a>\n" +
            "                        <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/images/delete.png\"></a>\n" +
            "                        <input type=\"hidden\" value=\"" + i + "\">\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>" + ssstring + "</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>工作描述 ：</span><span> " + exper.jobDescription + "</span>\n" +
            "                    </div>\n" +
            "                </div>"


        document.querySelector(".jse-con").innerHTML += experHtml;

        //  console.log(document.querySelector(".job-experience-show").innerHTML)
    }
}
     /*  项目经验        */

function show2() {
    $(".pro-experience-show").hide();
    $(".pro-exp").show();
    $(".pro-exper-key").val("");
}


var proList = new Array();

$(".pro-expr-save").click(function () {
    $(".pro-experience-show").show();
    $(".pro-exp").hide();


    var project = {
        proTime: null,
        proCompany: null,
        proName: null,
        proDesc: null,
        proDuty: null
    }


    project.proTime = $(".pro-time-ipt").val();
    project.proCompany = $(".pro-company-name").val();
    project.proName = $(".expr-pro-name").val();
    project.proDesc = $(".pro-description").val();
    project.proDuty = $(".pro-duty-description").val();
    var index = $(".pro-exper-key").val();

    console.log(project)


    if (project.proTime != null && project.proCompany != null && project.proName != null && project.proDesc != null && project.proDuty != null) {

        if (proList.length == 0) {
            console.log("第一层");
            proList[0] = project;
        } else if (proList.length != 0 && index == "") {
            console.log("第二层");
            proList[proList.length] = project;
        } else {
            proList[index] = project;
            console.log("第三层");
        }


    }
    initProject();

})

//console.log(document.querySelector(".pro-con").innerHTML)


function initProject() {
    //   console.log(123)
    document.querySelector(".pro-con").innerHTML = "";

    //   console.log("proList.length"+proList.length)
    for (var i = 0; i < proList.length; i++) {
        var pro = proList[i];
        var time = pro.proTime.substring(0, 4) + "/" + pro.proTime.substring(5, 14) + "/" + pro.proTime.substring(15, 17);

        var proHtml = "<div class=\"jes-content\">" +
            "<div class=\"jesc-row\">\n" +
            "                        <span>" + time + "</span>\n" +
            "                        <em class=\"em1\">" + pro.proName + "</em>\n" +
            "                        <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/zhaopin/images/update.png\"></a>\n" +
            "                        <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/zhaopin/images/delete.png\"></a>\n" +
            "                        <input type=\"hidden\" value=\"" + i + "\" class=\"pro-key\">\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>所属公司 ：</span><span>" + pro.proCompany + "</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>工作描述 ：</span><span> " + pro.proDesc + "</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>工作描述 ：</span><span> " + pro.proDuty + "</span>\n" +
            "                    </div> </div>"
        document.querySelector(".pro-con").innerHTML += proHtml;


    }
    //  console.log(document.querySelector(".pro-con").innerHTML)
}

$(".pro-expr-unsave").click(function () {
    $(".pro-experience-show").show();
    $(".pro-exp").hide();
    initProject();
})


document.querySelector(".pro-experience-show").onclick = function (event) {

    var ele = event.target;


    if (ele.nodeName == "IMG") {
        var nextEle = ele.parentElement.nextElementSibling.lastElementChild;
        var preEle = ele.parentElement.previousElementSibling.lastElementChild;

        console.log(nextEle);
        console.log(preEle);

        if (nextEle != null && nextEle.nodeName == "IMG") {
            $(".pro-experience-show").hide();
            $(".pro-exp").show();

            var index = ele.parentElement.parentElement.lastElementChild.value;
            var project = proList[index];

            $(".pro-time").val(project.proTime);
            $(".pro-company-name").val(project.proCompany);
            $(".expr-pro-name").val(project.proName);
            $(".pro-description").val(project.proDesc);
            $(".pro-duty-description").val(project.proDuty);
            $(".pro-exper-key").val(index);


        } else if (preEle.nodeName == "IMG") {
            var index = $(".pro-exper-key").val();
            proList.splice(index, 1);
            console.log(proList.length)
            initProject();
        }
    }


}


/*       教育经历        */
function show3() {
    $(".edu-experience-show").hide();
    $(".edu-exp").show();
    $(".edu-key").val("");
}

$(".btn-no").click(function () {
    $(".btn-yes").css("background-color", "white");
    $(".btn-yes").css("color", "black");
    $(".btn-yes").css("border", "1px solid black");
    $(".btn-no").css("background-color", "#ff6000");
    $(".btn-no").css("color", "white");
    $(".btn-no").css("border", "none");
});

$(".btn-yes").click(function () {
    $(".btn-yes").css("background-color", "#ff6000");
    $(".btn-yes").css("color", "white");
    $(".btn-yes").css("border", "none");
    $(".btn-no").css("background-color", "white");
    $(".btn-no").css("color", "black");
    $(".btn-no").css("border", "1px solid black");
});


var eduList = new Array();
$(".edu-expr-save").click(function () {
    $(".edu-experience-show").show();
    $(".edu-exp").hide();


    var edu = {
        eduTime: null,
        eduSchool: null,
        eduLevel: null,
        isAllDay: null,
        major: null,
        majorDesc: null,
        overSeasExp: null
    }

    edu.eduTime = $(".edu-time-ipt").val();
    edu.eduSchool = $(".school-name").val();
    edu.eduLevel = $(".edu-select").val();
    edu.isAllDay = $(".isAllDay").val();
    edu.major = $(".major").val();
    edu.majorDesc = $(".major-description").val();
    var index = $(".edu-exper-key").val();

    var btnList = $(".edu-btn button");
    for (var i = 0; i < btnList.length; i++) {
        if (btnList[i].style.color == "white") {
            edu.overSeasExp = "是";
            console.log("btnList.experJobType = " + edu.overSeasExp)
        }
    }


    console.log(edu)

    if (edu.eduTime != null && edu.eduSchool != null && edu.eduLevel != null && edu.major != null
        && edu.majorDesc != null && edu.overSeasExp != null && edu.majorDesc != null) {

        if (eduList.length == 0) {
            console.log(1223)
            eduList[0] = edu;
        } else if (eduList.length != 0 && index == "") {
            console.log(12364)
            eduList[eduList.length] = edu;
        } else {
            console.log(3645)
            eduList[index] = edu;
        }

    }

    initEdu();


})

function initEdu() {
    document.querySelector(".edu-con").innerHTML = "";

      console.log("eduList.length"+eduList.length)
    for (var i = 0; i < eduList.length; i++) {
        var edu = eduList[i];
        var time = edu.eduTime.substring(0, 4) + "/" + edu.eduTime.substring(5, 14) + "/" + edu.eduTime.substring(15, 17);

        var eduHtml = "<div class=\"jes-content\">\n" +
            "                        <div class=\"jesc-row\">\n" +
            "                            <span>" + time + "</span>\n" +
            "                            <em class=\"em1\">" + edu.eduSchool + "</em>\n" +
            "                            <em class=\"em2\">" + edu.major + "</em>\n" +
            "                            <span class=\"major-right\">" + edu.eduLevel + "</span>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/zhaopin/images/update.png\"></a>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/zhaopin/images/delete.png\"></a>\n" +
            "                            <input type=\"hidden\" value=\"" + i + "\" class=\"edu-key\">\n" +
            "                        </div>\n" +
            "                    </div>";
        document.querySelector(".edu-con").innerHTML += eduHtml;
    }
}

$(".edu-expr-unsave").click(function () {
    $(".edu-experience-show").show();
    $(".edu-exp").hide();
    initEdu();
})


document.querySelector(".edu-experience-show").onclick = function (event) {

    var ele = event.target;


    if (ele.nodeName == "IMG") {
        var nextEle = ele.parentElement.nextElementSibling.lastElementChild;
        var preEle = ele.parentElement.previousElementSibling.lastElementChild;

        console.log(nextEle);
        console.log(preEle);

        if (nextEle != null && nextEle.nodeName == "IMG") {
            $(".edu-experience-show").hide();
            $(".edu-exp").show();

            var index = ele.parentElement.parentElement.lastElementChild.value;
            var edu = eduList[index];

            $(".edu-time-ipt").val(edu.eduTime);
            $(".school-name").val(edu.eduSchool);
            $(".edu-select").val(edu.eduLevel);
            $(".isAllDay").val(edu.isAllDay);
            $(".major").val(edu.major);
            $(".major-description").val(edu.majorDesc);
            $(".edu-exper-key").val(index);


            if (edu.overSeasExp = "是"){
                $(".btn-yes").css("background-color", "#ff6000");
                $(".btn-yes").css("color", "white");
                $(".btn-yes").css("border", "none");
                $(".btn-no").css("background-color", "white");
                $(".btn-no").css("color", "black");
                $(".btn-no").css("border", "1px solid black");
            } else{
                $(".btn-yes").css("background-color", "white");
                $(".btn-yes").css("color", "black");
                $(".btn-yes").css("border", "1px solid black");
                $(".btn-no").css("background-color", "#ff6000");
                $(".btn-no").css("color", "white");
                $(".btn-no").css("border", "none");
            }


        } else if (preEle.nodeName == "IMG") {
            var index = $(".edu-key").val();
            eduList.splice(index, 1);
            console.log(eduList.length)
            initEdu();
        }
    }


}


/*      在校荣誉         */
function show4() {
    $(".aword-experience-show").hide();
    $(".aword").show();
    $(".aword-key").val("");
}

var awordList = new Array();

$(".aword-expr-save").click(function () {
    $(".aword-experience-show").show();
    $(".aword").hide();
    
    var aword = {
        awordTime:null,
        awordName:null,
        awordLevel:null
    }

    aword.awordTime = $(".aword-time").val();
    aword.awordName = $(".aword-name").val();
    aword.awordLevel = $(".aword-level").val();
    var index = $(".aword-key").val();
    
    if (aword.awordName!=null && aword.awordTime!=null && aword.awordLevel!=null) {

        if (awordList.length == 0) {
            awordList[0] = aword;
        } else if (awordList.length != 0 && index == "") {
            awordList[awordList.length] = aword;
        } else {
            awordList[index] = aword;
        }
        
    }
    
    initAword();
    
})


function initAword() {
    console.log(" awordList.length:" + awordList.length)
    document.querySelector(".aword-con").innerHTML = "";
    for (var i = 0; i < awordList.length; i++) {
        var aword = awordList[i];

        var awordHtml = "<div class=\"jes-content\">\n" +
            "                        <div class=\"jesc-row\">\n" +
            "                            <span>"+aword.awordTime+"</span>\n" +
            "                            <em class=\"em1\">"+aword.awordName+"</em>\n" +
            "                            <em class=\"em2\">"+aword.awordLevel+"</em>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/zhaopin/images/update.png\"></a>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/zhaopin/images/delete.png\"></a>\n" +
            "                            <input type=\"hidden\" value=\""+i+"\" class=\"aword-key\">\n" +
            "                        </div>\n" +
            "                    </div>";



        document.querySelector(".aword-con").innerHTML += awordHtml;
    }
}

$(".aword-expr-unsave").click(function () {
    $(".aword-experience-show").show();
    $(".aword").hide();
    initAword();
})


document.querySelector(".aword-experience-show").onclick = function (event) {

    var ele = event.target;


    if (ele.nodeName == "IMG") {
        var nextEle = ele.parentElement.nextElementSibling.lastElementChild;
        var preEle = ele.parentElement.previousElementSibling.lastElementChild;

        console.log(nextEle);
        console.log(preEle);

        if (nextEle != null && nextEle.nodeName == "IMG") {
            $(".aword-experience-show").hide();
            $(".aword").show();

            var index = ele.parentElement.parentElement.lastElementChild.value;
            var aword = awordList[index];

            $(".aword-time").val(aword.awordTime);
            $(".aword-name").val(aword.awordName);
            $(".aword-level").val(aword.awordLevel);
            $(".aword-key").val(index);



        } else if (preEle.nodeName == "IMG") {
            var index = $(".aword-key").val();
            awordList.splice(index, 1);
            initAword();
        }
    }


}


/*      技能特长         */
function show5() {
    $(".skill-experience-show").hide();
    $(".skill").show();
    $(".skill-key").val("");
}


var skillList = new Array();

$(".skill-expr-save").click(function () {
    $(".skill-experience-show").show();
    $(".skill").hide();

    var skill = {
        skillName:null,
        skillLevel:null
    }

    skill.skillName = $(".skill-name").val();
    skill.skillLevel = $(".skill-level").val();
    var index = $(".skill-key").val();


    if (skill.skillName != null && skill.skillLevel!=null){
        if (skillList.length == 0){
            skillList[0] = skill;
        } else if (skillList.length !=0 && index == ""){
            skillList[skillList.length] = skill;
        } else {
            skillList[index] = skill;
        }
    }

    initSkill();


})


function initSkill() {
    document.querySelector(".skill-con").innerHTML = "";
    for (var i = 0; i < skillList.length; i++) {
        var skill = skillList[i];

        var skillHtml = "<div class=\"jes-content\">\n" +
            "                        <div class=\"jesc-row\">\n" +
            "                            <span>"+skill.skillName+"</span>\n" +
            "                            <em class=\"em1\">"+skill.skillLevel+"</em>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/zhaopin/images/update.png\"></a>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/zhaopin/images/delete.png\"></a>\n" +
            "                            <input type=\"hidden\" value=\""+i+"\" class=\"skill-key\">\n" +
            "                        </div>\n" +
            "                    </div>";

        document.querySelector(".skill-con").innerHTML += skillHtml;
    }

}

$(".skill-expr-unsave").click(function () {
    $(".skill-experience-show").show();
    $(".skill").hide();
    initSkill();
})


document.querySelector(".skill-experience-show").onclick = function (event) {

    var ele = event.target;


    if (ele.nodeName == "IMG") {
        var nextEle = ele.parentElement.nextElementSibling.lastElementChild;
        var preEle = ele.parentElement.previousElementSibling.lastElementChild;

        console.log(nextEle);
        console.log(preEle);

        if (nextEle != null && nextEle.nodeName == "IMG") {
            $(".skill-experience-show").hide();
            $(".skill").show();

            var index = ele.parentElement.parentElement.lastElementChild.value;
            var skill = skillList[index];

            $(".skill-name").val( skill.skillName);
            $(".skill-level").val(skill.skillLevel);
            $(".skill-key").val(index);


        } else if (preEle.nodeName == "IMG") {
            var index = $(".skill-key").val();
            eduList.splice(index, 1);
            initEdu();
        }
    }


}