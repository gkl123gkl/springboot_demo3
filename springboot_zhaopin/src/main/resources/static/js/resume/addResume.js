/**
 * Created by admin on 2020/3/2.
 */
$(".update-resume-name").click(function(){
    updateOpen();
});
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

// 点击保存 简历名称按钮
function saveUpdateName() {
    console.log("点击保存 简历名称按钮");
    var inputEle = document.querySelector(".save-btn1").previousElementSibling.value;
    var titleEle = document.querySelector(".save-btn1").parentElement;
    titleEle.innerHTML = "<span class=\"title-h3\" style=\"line-height: 90px\">" + inputEle + "</span>\n" +
        "                    <a href=\"JavaScript:void(0)\" onclick=\"updateOpen()\"><img src=\"/zhaopin/images/update.png\" class=\"update-resume-name\" style=\"margin:33px 30px\"></a>";
    console.log("简历名称:" + inputEle);

    /*
     1. 添加简历
     （1）添加成功，在页面加上一个隐藏域，存放刚添加的简历的id <input type='hidden' class='resumeId'>
     (2)添加失败，提示原因

     2. 添加简历前：
     先判断页面中是否有 resumeId这个隐藏域，若没有，则是添加功能
     若是由resumeId这个隐藏域，则是修改功能
     */
    if($(".resumeId").val()=="" || $(".resumeId").val()==undefined ){ // 页面没有resumeId 添加
        // 添加新简历
        console.log("添加新简历");
        saveResumeName(inputEle);
    }else{  //页面有resumeId，修改功能
        console.log("修改简历名称");
        updateResumeName($(".resumeId").val(),inputEle);
    }
}

//将日期 转换成 yyyy-MM-dd 格式
function getFormatDate(d){
    var year = d.getFullYear();
    var month = d.getMonth()+1;
    var day = d.getDate();
    return year+"-" + month + "-" + day;

}

$(".resumeNameMsg").text("");
// ajax 添加新简历
function saveResumeName(resumeName) {

    if(resumeName !=""){
        console.log("save............"+resumeName);
        $.ajax({
            type:"post",
            url:"/resume/name",
            data:{
                "resumeName":resumeName,
            },
            datatype:"json",
            success:function (result) {
                console.log(result);

                if(result.status ==1){
                    //1. 添加简历成功后，在页面添加 隐藏域 resumeId

                    console.log("result.data.resumeId:" + result.data.resumeId);
                    $(".resumeId").attr("value",result.data.resumeId);
                    console.log("新增的简历的id:" +  $(".resumeId").val());
                    var updateDate = getFormatDate(new Date())
                    $(".update-time").text(updateDate);
                    $(".resumeNameMsg").text("");
                }else{
                    $(".resumeNameMsg").text(result.data);
                }
            }

        });
    }
}

// ajax 修改简历名称
function updateResumeName(resumeId,resumeName) {
    console.log("正在修改简历：" + resumeId + ", " + resumeName);
    $.ajax({
        type: "post",
        data: {
            "resumeId": resumeId,
            "resumeName": resumeName,

        },
        datatype: "json",
        url: "/resume/name",
        success: function (result) {
            console.log("修改操作完成，服务器的响应是：" + result);

            //简历名称，更新时间 需要重新渲染
            $(".title-h3").text(result.data.resumeName);
            $(".update-time").text(getFormatDate(new Date(result.data.resumeUpdateTime)));
        }
    })
}


function undo() {
    var titleEle = document.querySelector(".save-btn1").parentElement;
    titleEle.innerHTML = "<span class=\"title-h3\" style=\"line-height: 90px\">我的简历</span>\n" +
        "                    <a href=\"JavaScript:void(0)\" onclick=\"updateOpen()\"><img src=\"/zhaopin/images/update.png\" class=\"update-resume-name\" style=\"margin:33px 30px\"></a>";

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