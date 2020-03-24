/**
 * Created by admin on 2020/3/3.
 */
loadResumeVODetail();
var resume;
var workExperienceList;
var projectExperienceList;
var honorList;
var skillList;
//加载改简历的详细情况
function loadResumeVODetail() {
    //解析url中的resumeId
    var urlStr=location.href;//  /zhaopin/resume/detail.jsp?id=${resume.resumeId}
    var temp=urlStr.split("=");
    // var resumeId=temp[1];
    var resumeId=$(".resumeId").val();
    console.log("resumeId:"+resumeId);
    $.ajax({
        type:"GET",
        url:"/resume/"+resumeId,
        datatype:"json",
        success:function (result) {
            console.log(result);//serverresponse.data(resume , List<WorkExperience> , List<ProjectExperience> ,  List<Skill>,   List<Honor>)
            //渲染resumeId，简历名，简历更新时间
            resume=result.data.resume;
            loadResumeName(resume);
            //渲染用户个人信息
            loadCustInfo(resume);
            //渲染年收入
            loadYearSalary(resume);
            //渲染工作经验
            workExperienceList=result.data.workExperienceList;
            loadWorkExperience(workExperienceList);
            //渲染项目经验
            projectExperienceList=result.data.projectExperienceList;
            loadProjectExperience(projectExperienceList);

            //渲染奖项
            honorList=result.data.honorList;
            loadHonor(honorList);

            //渲染专业技能
            skillList=result.data.skillList;
            loadSkill(skillList);
        }
    })
}

/*function getFormatDate(d){
    var year = d.getFullYear();
    var month = d.getMonth()+1;
    var day = d.getDate();
    return year+"-" + month + "-" + day;

}
function getFullDate(ms) {
    var d=new Date(ms);
    var year=d.getFullYear();
    var month=d.getMonth();
    var day=d.getDate();
    return year+"-" + month + "-" + day;
}*/

//渲染resumeId，简历名，简历更新时间
function loadResumeName(resume) {
    $(".resumeId").val(resume.resumeId);
    $(".title-h3").val(resume.resumeName);
    $(".update-time").text(getFormatDate(new Date(resume.resumeUpdateTime)));
}
//渲染用户个人信息
function loadCustInfo(resume) {
    //用户名
    $(".p-username").text(resume.other1);
    //工作年限
    var workyear=new Date().getFullYear()-resume.other2;
    //性别年龄
    var gender=resume.resumeGender=='M'?'男':'女';
    var age=new Date().getFullYear()-(new Date(resume.resumeBirth).getFullYear())+1;
    //出生日期
    var birthday=getFullDate(resume.resumeBirth);
    var value = "现居住于" + resume.resumeLiveCity + " | " + workyear + "年工作经验  |" + gender +
        age + "岁(" + birthday + ")  |  " + resume.resumeLeavingWorking;

    $(".p-user-content p").text(value);
    $(".p-email").text(resume.resumeEmail);
    $(".p-phone").text(resume.resumeTelno);
}
//渲染年收入
function loadYearSalary(resume) {
    $(".income-value").text(resume.resumeIncome);
}
//渲染工作经验
function loadWorkExperience(workExperienceList){
    $(".job-experience-show").show();  // 显示读取模式
    $(".job-experience").hide(); //隐藏编辑模式
    initExper(workExperienceList);  //数据显示出来
}
function initExper(experList) {
    console.log(experList.length);
    document.querySelector(".jse-con").innerHTML = "";
    for (var i = 0; i < experList.length; i++) {
        var exper = experList[i];
        var time = getFormatDateYM(new Date(exper.workStartTime)) + "-" +getFormatDateYM(new Date(exper.workEndTime));
        var ssstring = "计算机软件 | " + exper.workCompanyScaler + " | " + exper.workCompanyProperty + " | " + exper.workDepartment;
        var experHtml = "<div class=\"jes-content\">\n" +
            "<input type=\"text\" class=\"work_experience_id\"  value=\"" + exper.workExperiId + "\">\n" +

            "                    <div class=\"jesc-row\">\n" +
            "                        <span>" + time + "</span>\n" +
            "                        <em class=\"em1\">" + exper.workCompanyName + "</em>\n" +
            "                        <em class=\"em2\">" + exper.workPosition + "</em>\n" +
            "                        <a href=\"javascript:;\" class=\"jes-update update_workexperience_btn\"><img src=\"/images/update.png\"></a>\n" +
            "                        <a href=\"javascript:;\" class=\"jes-delete\"><img src=\"/images/delete.png\"></a>\n" +
            "                        <input type=\"hidden\" value=\"" + i + "\">\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>" + ssstring + "</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>工作描述 ：</span><span> " + exper.workDesc + "</span>\n" +
            "                    </div>\n" +
            "                </div>"
        document.querySelector(".jse-con").innerHTML += experHtml;
    }
}
//渲染项目经验
function loadProjectExperience(projectExperienceList){
    $(".pro-experience-show").show();
    $(".pro-exp").hide();
    initProject(projectExperienceList);
}

function initProject(proList) {
    document.querySelector(".pro-con").innerHTML = "";
    for (var i = 0; i < proList.length; i++) {
        var pro = proList[i];
        var startTime = getFormatDateYM(new Date(pro.projectStartTime));
        var endTime = getFormatDateYM(new Date(pro.projectEndTime));
        var time = startTime +"~" + endTime;
        var proHtml = "<div class=\"jes-content\">" +
            "<div class=\"jesc-row\">\n" +
            "<input type=\"text\" class=\"project_experience_id\"  value=\"" + pro.projectExperiId + "\">\n" +
            "                        <span>" + time + "</span>\n" +
            "                        <em class=\"em1\">" + pro.projectName + "</em>\n" +
            "                        <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/images/update.png\"></a>\n" +
            "                        <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/images/delete.png\"></a>\n" +
            "                        <input type=\"hidden\" value=\"" + i + "\" class=\"pro-key\">\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>所属公司 ：</span><span>" + pro.projectCompanyName + "</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>项目描述 ：</span><span> " + pro.projectContentDesc + "</span>\n" +
            "                    </div>\n" +
            "                    <div class=\"jesc-row\">\n" +
            "                        <span>工作描述 ：</span><span> " + pro.projectDutyDesc + "</span>\n" +
            "                    </div> </div>"
        document.querySelector(".pro-con").innerHTML += proHtml;
    }
}

//渲染奖项
function loadHonor(honorList){
    $(".aword-experience-show").show();
    $(".aword").hide();
    initHonor(honorList);
}
function initHonor(awordList) {
    console.log(" awordList.length:" + awordList.length)
    document.querySelector(".aword-con").innerHTML = "";
    for (var i = 0; i < awordList.length; i++) {
        var aword = awordList[i];
        var hornorTime = getFormatDateYM(new Date(aword.honorCreateTime));
        var awordHtml = "<div class=\"jes-content\">\n" +
            "<input type=\"text\" class=\"honor_id\"  value=\"" + aword.honorId + "\">\n" +
            "                        <div class=\"jesc-row\">\n" +
            "                            <span>"+hornorTime+"</span>\n" +
            "                            <em class=\"em1\">"+aword.honorName+"</em>\n" +
            "                            <em class=\"em2\">"+aword.honorGrade+"</em>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/images/update.png\"></a>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/images/delete.png\"></a>\n" +
            "                            <input type=\"hidden\" value=\""+i+"\" class=\"aword-key\">\n" +
            "                        </div>\n" +
            "                    </div>";
        document.querySelector(".aword-con").innerHTML += awordHtml;
    }
}

//渲染专业技能
function loadSkill(skillList){
    $(".skill-experience-show").show();
    $(".skill").hide();
    initSkill(skillList);
}

function initSkill(skillList) {
    document.querySelector(".skill-con").innerHTML = "";
    for (var i = 0; i < skillList.length; i++) {
        var skill = skillList[i];

        var skillHtml = "<div class=\"jes-content\">\n" +
            "<input type=\"text\" class=\"skill_id\"  value=\"" + skill.skillId + "\">\n" +
            "                        <div class=\"jesc-row\">\n" +
            "                            <span>"+skill.skillName+"</span>\n" +
            "                            <em class=\"em1\">"+skill.skillDesc+"</em>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-update\"><img src=\"/images/update.png\"></a>\n" +
            "                            <a href=\"javascript:void(0)\" class=\"jes-delete\"><img src=\"/images/delete.png\"></a>\n" +
            "                            <input type=\"hidden\" value=\""+i+"\" class=\"skill-key\">\n" +
            "                        </div>\n" +
            "                    </div>";
        document.querySelector(".skill-con").innerHTML += skillHtml;
    }
}

//点击个编辑按钮
$(".user-title a").click(function () {
    var birthday =   getFullDate(new Date(resume.resumeBirth));
    var workyear = new Date().getFullYear()-resume.other2 ;
    $(".preview-infor").hide();
    $(".user-infor").show();
    $(".user-page").css("background-image", person.personImg);
    $(".perName").val(resume.other1);
    $(".birthday").val(birthday);
    $(".startworkyear").val(resume.other2);
    $(".phone").val(resume.resumeTelno);
    $(".email").val(resume.resumeEmail);
    $(".loc").val(resume.resumeLiveCity);
    $(".card-select").val("身份证");
    $(".id").val(resume.resumePersonid);
    $(".select-type option:checked").val(resume.resumeLeavingWorking);
})
$(".user-save-btn").click(function () {
    //1.获得简历id
    var resumeId=$(".resumeId").val();
    //2.获得表单中的个人信息
    var custName = $(".perName").val();
    var custGender ;
    var gender = document.querySelectorAll(".gender-click button");
    for (var i = 0; i < gender.length; i++) {
        if (gender[i].style.color == "white") {
            custGender  = gender[i].innerText.trim();
            custGender = (custGender =='男'?'M':'F');
        }
    }
    var custBirthday = $(".birthday").val();
    var custStartWorkyear = $(".startworkyear").val();
    var custTelno = $(".phone").val();
    var custWorkStatus = $(".select-type option:selected").text(); //求职状态
    var custEmail = $(".email").val();
    var custLocation = $(".loc").val();
    var custPersonId = $(".id").val();

    console.log("resumeId:"+resumeId);
    console.log("custName:"+custName);
    console.log("custGender:"+custGender);
    console.log("custBirthday:"+custBirthday);
    console.log("custStartWorkyear:"+custStartWorkyear);
    console.log("custTelno:"+custTelno);
    console.log("custWorkStatus:"+custWorkStatus);
    console.log("custEmail:"+custEmail);
    console.log("custLocation:"+custLocation);
    console.log("custPersonId:"+custPersonId);

    //3. ajax 请求
    $.ajax({
        type: "get",
        url: "/resume/custInfo",
        datatype: "json",
        data:{
            "resumeId":resumeId,
            "custName":custName,
            "custGender":custGender,
            "custBirthday":custBirthday,
            "custStartWorkyear":custStartWorkyear,
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

            if(result.status ==1){//修改成功，查询数据成功
                //将返回的呃最新的resume中个人信息 渲染到页面上
                //用户名
                $(".p-username").text(result.data.other1);
                //工作年限
                var workyear = new Date().getFullYear()- result.data.other2 ;
                //性别
                var gender =  result.data.resumeGender=='M'?'男':'女';
                //年龄
                var age = new Date().getFullYear() - (new Date(result.data.resumeBirth ).getFullYear())+1;
                //出生日期
                var birthday =   getFullDate(result.data.resumeBirth);
                var value = "现居住于" + result.data.resumeLiveCity + " | " + workyear + "年工作经验  |" + gender +
                    age + "岁(" + birthday + ")  |  " + result.data.resumeLeavingWorking;
                $(".p-user-content p").text(value);
                //邮箱
                $(".p-email").text( result.data.resumeEmail);
                //手机号
                $(".p-phone").text(result.data.resumeTelno);
                //更新时间
                var updateTime =  getFullDate(result.data.resumeUpdateTime);
                $(".update-time").text(updateTime);
            }else{//修改数据失败
                console.log("修改失败");
                console.log(result.data);
            }
        }


    });


});


















