/**
 * Created by admin on 2020/2/28.
 */
//点击创建简历
/* 1.需要先检查当前登录用户已有的简历的个数
*  if count《3 直接跳转到 添加简历的页面 resume/add.jsp
*  if count》=3 给出提示信息，最多只能创建3个简历
* */

$(".addResumeBtn").click(function () {
    $.ajax({
        type:"GET",
        url:"/resume/count",
        datatype:"json",
        success:function (result) {
            console.log(result);
            if(result.status==0){
                $(".errorMsg").text(result.data);
            }else{
                location.href="/resumeadd"
            }
        }
    })
})
