/**
 * Created by admin on 2020/2/26.
 */
var kw="";//搜索的关键字
var city="";//城市
var publishtime="";//发布时间
var minsalary="";//最低工资
var maxsalary="";//最高工资
var company="";//公司性质
var workyear="";//工作年限
var degree="";//学历
$(".publishtimeUL").click(function (event) {
    var ele=event.target;
    var li=ele.parentElement;
    console.log(li);
    var lis=li.parentNode.querySelectorAll("li");
    console.log(lis);
    var index=[].indexOf.call(lis,li)
    switch(index){
        case 0:publishtime="";break;
        case 1:publishtime = -1;break;
        case 2:publishtime = -3;break;
        case 3:publishtime = -7;break;
        case 4:publishtime = -30;break;
    }
    getAll(1);
})

$(".salaryUL").click(function (event) {
    var ele=event.target;
    var li=ele.parentElement;
    console.log(li);
    var lis=li.parentNode.querySelectorAll("li");
    console.log(lis);
    var index=[].indexOf.call(lis,li)
    switch(index){
        case 0:minsalary = 0;maxsalary = 50000;break;
        case 1:minsalary = 0;maxsalary = 2000;break;
        case 2:minsalary = 2000;maxsalary = 3000;break;
        case 3:minsalary = 3000;maxsalary = 4500;break;
        case 4:minsalary = 4500;maxsalary =6000;break;
        case 5: minsalary = 6000;maxsalary = 8000;break;
        case 6:minsalary = 8000;maxsalary = 10000;break;
        case 7: minsalary = 10000;maxsalary = 30000;break;
    }
    getAll(1);
})

$(".companyUL").click(function (event) {
    var ele=event.target;
    company =ele.innerText;
    getAll(1);
})

$(".workyearUL").click(function (event) {
    var ele=event.target;
    var li=ele.parentElement;
    var lis=li.parentNode.querySelectorAll("li");
    var index=[].indexOf.call(lis,li);
    if(index!=0){
        workyear=ele.innerText;
    }else{
        workyear="";
    }
    getAll(1);
})

$(".degreeUL").click(function (event) {
    var ele=event.target;
    var li=ele.parentElement;
    var lis=li.parentNode.querySelectorAll("li");
    var index=[].indexOf.call(lis,li);
    if(index!=0){
        degree=ele.innerText;
    }else{
        degree="";
    }
    getAll(1);
})


//ajax 分页查询
function getAll(pageNum) {
    // var kw=$(".kw").val();
    // var city=$(".city").val();
     var url="/job/getAll?kw="+kw+"&city="+city+"&publishtime="+publishtime+"&minsalary="+minsalary+"&maxsalary="+maxsalary+"&company="+company+"&workyear="+workyear+"&degree="+degree+"&page="+pageNum;
    console.log(url);
    $.ajax({
        url:url,
        type:"GET",
        datatype:"json",
        success:function (result) {
            console.log(result);
            //渲染页面

            $(".job_list").css("display","none");
            if(result.status==0){//没有查到数据
                $(".job_list_msg").text(result.data);
            }else{
                $(".job_list").css("display","block");
                $(".job_list_msg").text("");
                $("#joblist1").html("");

                var jobCompanyList=result.data.list;
                var pageNum = result.data.pageNum;//当前页码
                var total = result.data.total;//总记录数
                var pages = result.data.pages;//总页码
                var prePage = result.data.prePage;   //上一页
                var nextPage = result.data.nextPage;//下一页

                //页码渲染
                $(".pageNum").text(pageNum);
                $(".total").text(total);
                $(".pages").text (pages);

                if(pageNum == 1){
                    $(".previous_page").css("display","none");
                }else{
                    $(".previous_page").css("display","inline-block");
                    var hrefVal="javascript:getAll("+(prePage)+");";
                    $(".previous_page").attr("href",hrefVal);
                }

                if(pageNum == pages){
                    $(".next_page").css("display","none");
                }else{
                    console.log("hash next");
                    console.log("next page" + $(".next_page") + ", 页码：" + (nextPage));
                    $(".next_page").css("display","inline-block");
                    var hrefVal="javascript:getAll("+(nextPage)+");";
                    $(".next_page").attr("href",hrefVal);
                }
                //职位信息渲染
                $.each(jobCompanyList,function (index,jobCompany) {
                    var jobId=jobCompany.job.jobId;
                    var companyId=jobCompany.company.companyId;
                    var jobName=jobCompany.job.jobName;
                    var companyName=jobCompany.company.companyName;
                    var jobCity = jobCompany.job.jobCity;
                    var minSalary = jobCompany.job.jobMinSalary;
                    var maxSalary = jobCompany.job.jobMaxSalary;
                    var publishTimeMS = jobCompany.job.jobPublishTime;
                    var publishTime =getFullDate(publishTimeMS);

                    var ele = " <div class=\"job_list_title_div \">\n" +
                        "            <div class=\" job_list_title1 \" style='margin-left: -10px'>\n" +
                        "            <input type=\"checkbox\">\n" +
                        "            <a href='/job/detail/"+ jobId +"' class='jobName' style=\"text-decoration: none;display:inline-block;width:160px;margin-left: 20px;font-size: 14px;color: #333\">\n" +
                        "                <span>"+jobName+"</span>\n" +
                        "            </a>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div class=\"job_list_title1\" style='width:220px'>\n" +
                        "            <a href='javascript:getComById("+(companyId)+");' style=\"text-decoration: none;width:220px;font-size: 14px;color: #666\" >\n" +
                        "                <span>"+companyName+"</span>\n" +
                        "            </a>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div class=\"job_list_title1\" style=\"font-size: 14px\">\n" +
                        "            <span>"+jobCity+"</span>\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div class=\"job_list_title1\" style=\"font-size: 16px; color: #ff6000\">\n" +
                        "            <span class=\"min_salary\">"+minSalary+"</span>\n" +
                        "            <span>-</span>\n" +
                        "            <span class=\"max_salary\">"+maxSalary+"</span>\n" +
                        "            <span>/月</span>\n" +
                        "        </div>\n" +
                        "        <div class=\"job_list_title1\" style=\"font-size: 14px; margin-left: -30px\">\n" +
                        "            <span>"+publishTime+"</span>\n" +
                        "        </div>\n" +
                        "        </div>";


                    $("#joblist1").append(ele);
                });
            }
        }
    });
    //
}
function getFullDate(ms) {
   var d=new Date(ms);
   var year=d.getFullYear();
   var month=d.getMonth();
   var day=d.getDate();
    return year+"-" + month + "-" + day;
}
//点击搜索按钮
$(".search_btn").click(function () {
    getAll(1);
});

//首页搜索功能
var url=window.location.href;//获得url;
var num=url.indexOf("?");
url=url.substr(num+1);
console.log("url====:"+url);
// var kw=$(".kw").val();
var kw="";
console.log("kw====:"+kw);
if(url.indexOf("kw") != -1){//url后面有参数kw
    kw = url.split("=")[1];
    kw=decodeURIComponent(kw);//将kw解码成中文
    console.log("=====kw:"+kw);
    $(".kw").val(kw);
}
//进入到职位搜索页面
getAll(1);



