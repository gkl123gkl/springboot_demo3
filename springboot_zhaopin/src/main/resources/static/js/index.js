document.querySelector(".mome").onclick=function () {
   if(document.querySelector(".mome").id=="mome1"){
       document.querySelector(".hcbox").style.display = "block";
       document.querySelector(".mome").id="mome2";
   }
    else {
        document.querySelector(".hcbox").style.display = "none";
        document.querySelector(".mome").id="mome1";
    }
}

// 加载最新的10条记录
getLatest();
function getLatest() {
    $.ajax({
        type:"GET",
        url:"/job/getSomeLatest",
        datatype:"json",
        success:function (result) {
            console.log(result);
            var jobList =result.data;

            // 渲染
            var ulEle=$(".job_ul");
            ulEle.html("");
            $(".new_jobs").css("display","block");
            
            $.each(jobList,function (index,job) {
                var ele = " <li>\n" +
                    "                 <a href=\"javascript:getById(1001)\">\n" +
                    "                <span class=\"jobName\">"+job.jobName+"</span>\n" +
                    "                <span class=\"jobSalary\">"+job.jobMaxSalary+"</span>\n" +
                    "                 <span class=\"jobSalary\">元</span>\n" +
                    "             </a>\n"+
                    "            </li>";
                ulEle.append(ele);
            })

            }
    })
}
//首页搜索功能
$(".sbtn").click(function () {
    var kw = $(".keyword").val();
    location.href="/joball?kw=" + kw;
});