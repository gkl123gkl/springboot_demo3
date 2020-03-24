/**
 * Created by admin on 2020/3/3.
 */
getById(6);
function getById(jobId) {
    $.ajax({
        type:"GET",
        url:"/job/detail/"+jobId,
        datatype:"json",
        success:function (result) {
            console.log(result);
        }
    });
}

//点击申请职位，查看我的简历
$(".applyForJobBtn").click(function () {
    //获得当前用户的所有简历的名称
    $.ajax({
        type:"GET",
        url:"/resume/list",
        datatype:"json",
        success:function (result) {
            console.log(result);
            var resumeList=result.data;
            $(".resume_list").css("display","block");
            $(".resume_list").html("");
            if(result.status==1){
                for(var i=0;i<resumeList.length;i++){
                var ele="<a class='resume_name' href=\"javascript:sendResume("+resumeList[i].resumeId +")\">"+resumeList[i].resumeName+"</a>"
                    $(".resume_list").append(ele);
                }
            }else{
                $(".resume_list").css("display","none");
                console.log("您现在暂无简历");
            }
        }
    })
});

//投递简历ajax请求
function sendResume(resumeId) {
    var jobId = $(".jobId").val();
    console.log("jobId:"+jobId);
    console.log("resumeId:"+resumeId);
    $(".applyMsg").text("");
    $.ajax({
        type:"POST",
        url:"/resumeDeliveryRecord",
        datatype:"json",
        data:{
            "resumeId":resumeId,
            "jobId":jobId
        },
        success:function(result){
            console.log(result);
            if(result.status == 1){
                console.log("投递成功");
                $(".applyMsg").text("投递成功");
                $(".resume_list").hide();
            }else{
                $(".applyMsg").text("一个月之内 不能投递重复的岗位");
                console.log("一个月之内 不能投递重复的岗位");
                $(".resume_list").hide();
            }
        }
    });
}



