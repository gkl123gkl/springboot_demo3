<%--
  Created by IntelliJ IDEA.
  User: qianghj
  Date: 2020/3/3
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的申请</title>
    <link rel="shortcut icon" href="../images/logo.png">
    <link href="${pageContext.request.contextPath}/css/application.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/layui/css/modules/laydate/default/laydate.css" rel="stylesheet" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/layui/lay/modules/rate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootrap/dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
    <div class="bar">
        <div class="language">
            <span>简</span>
            <div class="languagelist">
                <span>繁</span>
                <span>EN</span>
            </div>
        </div>
        <div class="rlk">
            <a href="">职场百科</a>
            <a href="">职场文库</a>
            <a href="">招聘信息</a>
            <a href="">企业服务</a>
        </div>
        <div class="tle">
            <img src="../images/renwu.svg">
            <span>陈志峰</span>
            <div class="uer">
                <ul>
                    <li><a href="my51Job.html"><img src="${pageContext.request.contextPath}/images/fangzi.svg"><span>我的51Job</span></a></li>
                    <li><a href="ResumeCenter.html"><img src="../images/wendang.svg"><span>简历中心</span></a></li>
                    <li><img src="${pageContext.request.contextPath}/images/yanjing.svg"><span>谁看过我</span></li>
                    <li><img src="${pageContext.request.contextPath}/images/shizhong.svg"><span>我的申请</span></li>
                    <li class="tuichu"><img src="${pageContext.request.contextPath}/images/tuichu.svg"><span>退出账号</span></li>
                </ul>
            </div>
        </div>
        <div class="nag">
            <a href="${pageContext.request.contextPath}/index.jsp"><img class="tu" src="${pageContext.request.contextPath}/images/logo_blue.png"> </a>
            <img class="slogen" src="${pageContext.request.contextPath}/images/slogen.png">
            <p>
                <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
                <a href="../post/jobsearch.html">职位搜索</a>
                <a href="">地区频道</a>
                <a href="">职场咨询</a>
                <a href="">校园招聘</a>
                <a href="">无忧精英</a>
            </p>
        </div>
    </div>
</div>
<div class="main">
    <div class="exlt">
        <a href="my51Job.html"><span class="my">我的51Job</span></a>
        <a href="ResumeCenter.html" ><span class="my">简历中心<em class="new"></em></span></a>
        <a href=""><span class="my">谁看过我</span></a>
        <a href="collect.html"><span class="my">我的收藏</span></a>
        <a href="" class="job"><span class="my">我的申请<em class="hot"></em></span></a>
        <a href=""><span class="my">安全中心</span></a>
        <div role="presentation" class="dropdown">
            <a class="dropdown-toggle mbtn" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false"><span>更多</span><span class="caret"></span>
            </a>
            <ul class="dropdown-menu u1">
                <li><a href="#">人事服务</a></li>
                <li><a href="#">增值服务</a></li>
                <li><a href="#">屏蔽公司</a></li>
            </ul>
        </div>
    </div>
    <div class="exrt">
        <div class="mt">
            <div class="mt-l">
                <span>社会申请 <i>3</i></span>
            </div>
            <div class="mt_r">
                <label>仅保留近60天的社会申请记录</label>
            </div>
            <ul class="nav myStates">
                <li class="myindex active"><a href="">全部</a></li>
                <li><a href="consult.html">已查阅</a></li>
                <li><a href="interested.html">感兴趣</a></li>
                <li><a href="interview.html">邀面试</a></li>
            </ul>
            <div class="tab-content mytab">
                <div class="tab-pane active" id="d4">
                  <%--  <div class="pagination-nick">
                        <div id="list"></div>
                        <div id="page" class="mypage"></div>
                    </div>--%>
                </div>
                <div class="tab-pane record_list" id="d5" >





                </div>


            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/resume/dateFormat.js"></script>

<script src="${pageContext.request.contextPath}/js/application.js"></script>
</body>
</html>