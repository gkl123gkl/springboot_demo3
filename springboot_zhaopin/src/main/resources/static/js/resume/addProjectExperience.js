/**
 * Created by admin on 2020/3/2.
 */
var resumeId=$(".resumeId").val();
var projectCompanyName=$(".pro-company-name").val();
var projectTime=$(".pro-time-ipt").val();
var projectStartTime=projectTime.substring(0,7);
var projectEndTime=projectTime.substring(10);
var projectName=$(".expr-pro-name").val();
var projectContentDesc=$(".pro-description").val();
var projectDutyDesc=$(".pro-duty-description").val();

console.log("resumeId  :" + resumeId);
console.log("projectCompanyName :" + projectCompanyName);
console.log("projectStartTime :" + projectStartTime);
console.log("projectEndTime:" +  projectEndTime);
console.log("projectName:" +  projectName);
console.log("projectContentDesc:" +  projectContentDesc);
console.log("projectDutyDesc:" +  projectDutyDesc);

$.ajax({
    type:"post",
    url:"/zhaopin/projectExperience",
    datatype:"json",
    data:{
        "option":add,
        "resumeId":resumeId,
        "projectCompanyName":projectCompanyName,
        "projectStartTime":projectStartTime,
        "projectEndTime":projectEndTime,
        "projectName":projectName,
        "projectContentDesc":projectContentDesc,
        "projectDutyDesc":projectDutyDesc
    },
    success:function (jsonResult) {
        console.log(jsonResult);
        var jsResult=JSON.parse(jsonResult);
        if(jsResult.status ==1){
            console.log("添加成功");
        }else{
            console.log("添加失败");
        }
    }
});
