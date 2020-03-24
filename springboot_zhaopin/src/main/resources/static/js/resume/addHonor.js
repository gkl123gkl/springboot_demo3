/**
 * Created by admin on 2020/3/2.
 */
var resumeId=$(".resumeId").val();
var honorCreateTime=$(".aword-time").val();
var honorName=$(".aword-name").val();
var honorGrade=$(".aword-level").val();

console.log("resumeId :" + resumeId);
console.log("honorCreateTime :" + honorCreateTime);
console.log("honorName :" + honorName);
console.log("honorGrade:" +  honorGrade);

$.ajax({
    type: "post",
    url: "/zhaopin/honor",
    datatype: "json",
    data: {
        "option": "add",
        "resumeId": resumeId,
        "honorCreateTime": honorCreateTime,
        "honorName": honorName,
        "honorGrade": honorGrade
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


