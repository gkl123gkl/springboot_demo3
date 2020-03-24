<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/17
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

    <title>简历</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/resume_message.css">
</head>
<body>
${resumeVO};
<div class="header">
    <img src="${pageContext.request.contextPath}/images/logo_blue.png" alt="">
    <p id="p1"><a href="">打印</a></p>
    <p id="p2"><a href="">导出</a></p>
</div>
<div class="mes">
    <div class="hbox">
        <img src="${pageContext.request.contextPath}/images/woman.png" alt="">
    </div>
    <div class="message">
        <div class="kl">
            <p id="p3">${resumeVO.resume.other1}</p>
            <p id="p4">${resumeVO.resume.resumeId}</p>
        </div>
        <div class="kl2">
            <ul>
                <li>目前在找工作</li>
                <li>${resumeVO.resume.resumeTelno}</li>
                <li>${resumeVO.resume.resumeEmail}</li>
            </ul>
        </div>
        <div class="kl3">
            <ul>
                <li id="li1">${resumeVO.resume.resumeGender}</li>
                <li id="li2">${resumeVO.resume.resumeBirth}</li>
                <li id="li3">${resumeVO.resume.resumeLiveCity}</li>
                <li id="li4">10年工作经验</li>
            </ul>
        </div>
    </div>
</div>
<div class="res">
    <div class="d1">
        <div class="d2 dd2">
            <p class="p3">最近工作</p>
            <p class="p4">
                <span>职位：</span>
                <span>通信技术工程师</span>
            </p>
            <p class="p4">
                <span>公司：</span>
                <span>弛星</span>
            </p>
            <p class="p4">
                <span>行业：</span>
                <span>计算机</span>
            </p>
        </div>
        <div class="d2 dd3">
            <p class="p3">最高学历/学位</p>
            <p class="p4">
                <span>专业：</span>
                <span>计算机科学与技术</span>
            </p>
            <p class="p4">
                <span>学校：</span>
                <span>巢湖学院</span>
            </p>
            <p class="p4">
                <span>学历/学位：</span>
                <span>本科</span>
            </p>
        </div>
    </div>
</div>
<div class="sal">
    <p>
        目前年收入：${resumeVO.resume.resumeIncome}万元
        <span>
           (包含基本工资、补贴、奖金、股权收益等)
       </span>
    </p>

</div>
<div class="res res2">
    <div class="d1">
        <div class="d2 dd2">
            <p class="p3">求职意向</p>
            <p class="p4">
                <span>期望薪资：</span>
                <span>100万元以上/年</span>
            </p>
            <p class="p4">
                <span>职能/职位：</span>
                <span>程序员/码农</span>
            </p>
            <p class="p4">
                <span>工作类型：</span>
                <span>全职</span>
            </p>
        </div>
        <div class="d2 dd3">
            <p class="p3"></p>
            <p class="p4">
                <span>地点：</span>
                <span>上海</span>
            </p>
            <p class="p4">
                <span>行业：</span>
                <span>电子技术</span>
            </p>
        </div>
    </div>
</div>
<div class="d4">

    <div class="job-experience">
        <p>工作经验</p>
    </div>
    <div class="exper">
        <div class="d5">
            <p class="p5">2016/9-2020/6</p>
            <p class="p55">通信技术工程师</p>
        </div>
        <div class="d6">
            <p class="p6">巢湖学院</p>
            <p class="p66">[四年一个月]</p>
        </div>
        <div class="d7">
            <p class="p7">电子技术/半导体/集成电路</p>
            <p class="p71">|</p>
            <p class="p77">国企</p>
        </div>
        <div class="d8">
            <p class="p8">工作描述：</p>
            <p class="p88">无</p>
        </div>
    </div>
</div>
<div class="school">
    <div class="s1">
        <p>教育经历</p>
    </div>
    <div class="school-detail">
        <div class="s2">
            <p class="s22">2016/9-2020/6</p>
            <p class="s222">巢湖学院</p>
        </div>

        <div class="s3">
            <p class="s33">本科</p>
            <p class="s333">|</p>
            <p class="s3333">信息科学与技术</p>
        </div>
    </div>

</div>
<div class="sch school">
    <div class="s1">
        <p>在校情况</p>
    </div>
    <div class="sch1">
        <p>校内职务</p>
    </div>
    <div class="sch2">
        <p class="sch22">2016/9-2020/6</p>
        <p class="sch222">软件</p>
    </div>
</div>
<div class="skill">
    <div class="spe1">
        <p class="c1">技能特长</p>
        <p class="c2">（包含IT技能、语言能力、证书、成绩、培训经历）</p>
    </div>
    <div class="spe2">
        <p class="c3">技能/语言</p>
        <p class="c4">
            <span class="sp1">Hive</span>
            <span class="sp2"><a>熟练</a></span>
        </p>
    </div>
    <div class="book">
        <p class="bo1">证书</p>
    </div>
    <div class="lang">
        <p class="lang1">2018/12</p>
        <p class="lang2">英语四级证书</p>
    </div>
    <div class="book">
        <p class="bo1">培训经历</p>
    </div>
    <div class="di1">
        <p class="pp1">2019/11</p>
        <p class="pp2">java....</p>
    </div>
    <div class="di2">
        <p class="pp3">
            <span class="spa1" >培训机构:</span>
            <span class="spa2">弛星教育</span>
        </p>
        <p class="pp4">
            <span class="spa1">培训地点:</span>
            <span class="spa2">苏州</span>
        </p>
    </div>
    <div class="di3">
        <p class="pp1">培训描述</p>
        <p class="pp2">略。。。</p>
    </div>
</div>
</body>
</html>
