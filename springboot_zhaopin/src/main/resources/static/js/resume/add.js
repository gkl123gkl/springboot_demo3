/**
 * Created by admin on 2020/2/28.
 */
$(".save_btn1").click(function () {
    var resumeName=$(".resume_name").val;
    if(resumeName!=""){
        $.ajax({
            type:"post",
            data:{
                "resumeName":resumeName
            },
            datatype:"json",
            url:"/resume/name",
            success:function (result) {
                console.log(result);
            }
        });
    }
});