/**
 * Created by admin on 2020/3/2.
 */


var resumeId=$(".resumeId").val();
var skillName=$(".skill-name").val();
var skillDesc=$(".skill-level").val();
console.log("resumeId:"+resumeId);
console.log("skillName:"+skillName);
console.log("skillDesc:"+skillDesc);
$.ajax({
    type: "post",
    url: "/zhaopin/skill",
    datatype: "json",
    data: {
        "option": "add",
        "resumeId": resumeId,
        "skillName": skillName,
        "skillDesc": skillDesc
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
