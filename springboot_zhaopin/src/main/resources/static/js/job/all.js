var main = document.querySelector(".main");
main.onclick = function (event) {
    var ele = event.target;
    if (ele.nodeName == 'A') {
        var lis = ele.parentElement.parentElement.children;
        for (var i = 0; i < lis.length; i++) {
            lis[i].firstElementChild.style.color = "#5c5c5c";
            lis[i].firstElementChild.className = "";
            ele.parentElement.parentElement.parentElement.parentElement.lastElementChild.lastElementChild.innerText = "";
        }
        ele.style.color = "#FF6000";
        ele.className = "pitch";
        var as = document.querySelectorAll(".pitch");
        for (var j = 0; j < as.length; j++) {
            console.log(as[j].innerText);
            if (as[j].innerText != "所有") {
                if (ele.parentElement.parentElement.parentElement
                        .parentElement.lastElementChild.lastElementChild.innerText == "") {
                    ele.parentElement.parentElement.parentElement.parentElement.lastElementChild.lastElementChild.innerText = as[j].innerText;
                } else {
                    ele.parentElement.parentElement.parentElement.parentElement.lastElementChild.lastElementChild.innerText += "+" + as[j].innerText;
                }
            }
        }
    }
};
/***
 * 使用ajax
 * 加载json文件中的job数据
 */
// let jobsearch;
//
//
//
// if(window.XMLHttpRequest){
//     xhr = new XMLHttpRequest();
// }else{
//     xhr = new ActiveXObject("Microsoft.XMLHTTP");
// }
//
// //打开连接对象
// xhr.open("GET","../data/jobSearch.json",true);
// // 准备连接
// let data;

var data2 = [
    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    },

    {
        "jobName":"药学相关专业实习生",
        "jobCom":"龙灯瑞迪制药有限公司",
        "empType":"异地招聘",
        "minSalary":4000,
        "maxSalary":6000,
        "uploadTime":"01-14"
    }
]

layui.use('laypage', function(){

    var laypage = layui.laypage;


});




