/**
 * Created by admin on 2020/3/2.
 */

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




function show1() {
    $(".job-experience-show").hide();
    $(".job-experience").show();
    $(".job-exper-key").val("");
}


/*    工作经验列表    */
var experList = new Array();
function initExper(experList) {
    document.querySelector(".jse-con").innerHTML = "";
    for (var i = 0; i < experList.length; i++) {
        var exper = experList[i];
        console.log("resume Id **:" + exper.resumeId)
        var time = getFormatDateYM(new Date(exper.workStartTime)) + "-" +getFormatDateYM(new Date(exper.workEndTime));
        console.log("time = " + time)
        var ssstring = "计算机软件 | " + exper.workCompanyScaler + " | " + exper.workCompanyProperty + " | " + exper.workDepartment;

        var experHtml = "<div class=\"jes-content\">\n" +
            "<input type=\"text\" class=\"work_experience_id\"  value=\"" + exper.workExperiId + "\">\n" +

            "                    <div class=\"jesc-row\">\n" +
            "                        <span>" + time + "</span>\n" +
            "                        <em class=\"em1\">" + exper.workCompanyName + "</em>\n" +
            "                        <em class=\"em2\">" + exper.workPosition + "</em>\n" +
            "                        <a href=\"javascript:getById4Update("+ exper.workExperiId +");\" class=\"jes-update update_workexperience_btn\"><img src=\"/zhaopin/images/update.png\"></a>\n" +
            "                        <a href=\"javascript:;\" class=\"jes-delete\"><img src=\"/zhaopin/images/delete.png\"></a>\n" +
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


/********************************************保存添加工作经验 *************************************/
$(".job-expr-save").click(function () {
    addWorkExperience();
});

//添加新的工作经验
function  addWorkExperience() {
    // var workExperienceId=$(".workExperience_id");
    var jobTime=$(".time-ipt").val();
    var startWorkTime=jobTime.substring(0,7);
    var endWorkTime=jobTime.substring(10);
    var company=$(".company-name").val();
    var experJobLeval=$(".expr-job-level").val();
    var companySize=$(".expr-company-size option:selected").text();
    var depatement = $(".expr-dept").val();
    var companyType = $(".company-type").val();
    var jobDescription = $(".job-description").val();
    var  jobType;
    var experBtnList=$(".last-expr-row button");
    console.log("experBtnList:"+experBtnList[0])
    for(var i=0; i<experBtnList.length;i++){
        if(experBtnList[i].style.color=="white"){
            jobType=experBtnList[i].innerText.trim();
        }
    }
    console.log("job time :" + jobTime);
    console.log("job startWorktime :" + startWorkTime);
    console.log("job endWorkTime :" + endWorkTime);
    console.log("company:" +  company);
    console.log("experJobLevel:" +  experJobLeval);
    console.log("companySize:" +  companySize);
    console.log("depatement:" +  depatement);
    console.log("companyType:" +  companyType);
    console.log("jobDescription:" +  jobDescription);
    console.log("jobType:" +  jobType);

    $.ajax({
        type:"post",
        url:"/workExperience",
        datatype:"json",
        data:{

            "resumeId":$(".resumeId").val(),
            "startWorktime":startWorkTime,
            "endWorkTime":endWorkTime,
            "companyName":company,
            "companySize":companySize,
            "depatement":depatement,
            "jobName":experJobLeval,
            "companyType":companyType,
            "jobDescription":jobDescription,
            "jobType":jobType
        },
        success:function (result) {
            console.log(result);

            if(result.status ==1){
                console.log("添加成功");
                $(".job-experience-show").show();  // 显示读取模式
                $(".job-experience").hide(); //隐藏编辑模式
                var experienceArr = new Array(experience);
                initExper(experienceArr);
            }else{
                console.log("添加失败");
            }
        }
    })
}

/*********************************************点击 修改工作经验的按钮update_workexperience_btn ***********************************************/
function getById4Update(workExperienceId){
    //ajax 请求 根据当前工作经验ID 查询该id

    console.log("***************workExperienceId:"+workExperienceId);
    $.ajax({
        type:"get",
        url:"/workExperience/"+workExperienceId,
        datatype:"json",
        success:function(result){
            console.log(result);

            if(result.status ==1){
                //打开编辑模式
                //隐藏只读模式
                $(".job-experience-show").hide();
                $(".job-experience").show();
                //并且 在保存按钮上加上class="update-work-expericen-btn"

                var updateBtn = "<button  class=\"update-work_btn\" onclick=\"updateWE("+workExperienceId+ ")\">修改</button>";
                $(".job-expr-save").hide();
                $(".job-expr-btn-container").append(updateBtn);
            }
        }

    })
}

function updateWE(workExperienceId){
    console.log("updateWE workExperienceId:"+workExperienceId);
    var jobTime = $(".time-ipt").val();
    var startWorktime = jobTime.substring(0, 7);
    var endWorkTime = jobTime.substring(10) ;

    var company = $(".company-name").val();
    var experJobLevel = $(".expr-job-level").val();
    var companySize =$(".expr-company-size option:selected").text();
    var depatement = $(".expr-dept").val();
    var companyType = $(".company-type").val();
    var jobDescription = $(".job-description").val();
    var jobType ;
    var experBtnList = $(".last-expr-row button");
    console.log("experBtnList1 :"+ experBtnList[0] );
    console.log("experBtnList2 :"+ experBtnList[1].style);
    for (var i = 0; i < experBtnList.length; i++) {
        if (experBtnList[i].style.color == "white") {
            jobType = experBtnList[i].innerText.trim();
        }
    }

    console.log("job time :" + jobTime);
    console.log("job startWorktime :" + startWorktime);
    console.log("job endWorkTime :" + endWorkTime);
    console.log("company:" +  company);
    console.log("experJobLevel:" +  experJobLevel);
    console.log("companySize:" +  companySize);
    console.log("depatement:" +  depatement);

    console.log("companyType:" +  companyType);
    console.log("jobDescription:" +  jobDescription);
    console.log("jobType:" +  jobType);


    $.ajax({
        type:"post",
        url:"/workExperience",
        datatype:"json",
        data:{
            "_method":"put",
            "workExperienceId":workExperienceId,
            "startWorktime":startWorktime,
            "endWorkTime":endWorkTime,
            "companyName":company,
            "companySize":companySize,
            "depatement":depatement,
            "jobName":experJobLevel,
            "companyType":companyType,
            "jobDescription":jobDescription,
            "jobType":jobType
        },
        success:function(result){
            console.log(result);


            if(result.status ==1){
                console.log("修改成功");
                $(".job-experience-show").show();  // 显示读取模式
                $(".job-experience").hide(); //隐藏编辑模式
                var experience = result.data;
                var experienceArr = new Array(experience);
                initExper(experienceArr);  //数据显示出来
            }else{
                console.log("修改失败");
            }

        }
    })
}

$(".job-expr-unsave").click(function () {
    $(".job-experience-show").show();
    $(".job-experience").hide();
});



