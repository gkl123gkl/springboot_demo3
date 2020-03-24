<%--
  Created by IntelliJ IDEA.
  User: qianghj
  Date: 2020/2/28
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>简历列表</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png">
    <link href="${pageContext.request.contextPath}/css/ResumeCenter.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

    <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" media="all">

    <link href="${pageContext.request.contextPath}/layui/css/modules/laydate/default/laydate.css" rel="stylesheet" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/layui/lay/modules/rate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css">
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
            <img src="${pageContext.request.contextPath}/images/renwu.svg">
            <span>${loginCustomer.custTelno}</span>
            <input type="hidden" class="custId" value="${loginCustomer.custId}" />
            <div class="uer">
                <ul>
                    <li><a href="my51Job.html"><img src="${pageContext.request.contextPath}/images/fangzi.svg"><span>我的51Job</span></a></li>
                    <li><img src="${pageContext.request.contextPath}/images/wendang.svg"><span>简历中心</span></li>
                    <li><img src="${pageContext.request.contextPath}/images/yanjing.svg"><span>谁看过我</span></li>
                    <li><a href="application.html"><img src="${pageContext.request.contextPath}/images/shizhong.svg"><span>我的申请</span></a></li>
                    <li class="tuichu"><img src="${pageContext.request.contextPath}/images/tuichu.svg"><span>退出账号</span></li>
                </ul>
            </div>
        </div>
        <div class="nag">
            <a href="${pageContext.request.contextPath}/index.html"><img class="tu" src="${pageContext.request.contextPath}/images/logo_blue.png"> </a>
            <img class="slogen" src="${pageContext.request.contextPath}/images/slogen.png">
            <p>
                <a href="${pageContext.request.contextPath}/index.html">首页</a>
                <a href="${pageContext.request.contextPath}/post/jobsearch.html">职位搜索</a>
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
        <a href="" class="job"><span class="my">简历中心<em class="new"></em></span></a>
        <a href=""><span class="my">谁看过我</span></a>
        <a href="collect.html"><span class="my">我的收藏</span></a>
        <a href="application.html"><span class="my">我的申请<em class="hot"></em></span></a>
        <a href=""><span class="my">安全中心</span></a>
        <div role="presentation" class="dropdown">
            <a class="dropdown-toggle mbtn" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false"><span>更多</span><span class="caret"></span>
            </a>
            <ul class="dropdown-menu u1" >
                <li><a href="#">人事服务</a></li>
                <li><a href="#">增值服务</a></li>
                <li><a href="#">屏蔽公司</a></li>
            </ul>
        </div>
    </div>
    <div class="exrt">
        <div class="mt">
            <div class="mt-l">
                <span>简历中心</span>
            </div>
            <div class="mt_r">
                <a href="">查看求职信</a>
                <a href="">创建粘贴简历</a>
                <a href="javascript:;" class="addResumeBtn">创建简历</a>
            </div>
            <span style="font-size: 12px;color: red;display: block; width: 300px" class="errorMsg"></span>
            <div class="rbox">
                <div class="tit">
                    <ul class="clearfix">
                        <li class="l1">简历名称</li>
                        <li class="l2">公开程度</li>
                        <li class="l3">快速投递</li>
                        <li class="l4">操作</li>
                    </ul>
                </div>
                <div class="rli">
                    <ul class="resume_list_ul" style="width: 600px;height: 100px">
                        <c:forEach items="${resumeList}" var="resume">
                            <li class="myl1">
                              <a href="${pageContext.request.contextPath}/resumedetail/${resume.resumeId}">
                                      ${resume.resumeName}
                              </a>
                            <a href="${pageContext.request.contextPath}/resume?op=detail&id=${resume.resumeId}">编辑</a>
                                |&nbsp;
                            <a href="">删除</a>
                            </li>
                    </c:forEach>

                    </ul>
                </div>
            </div>

        </div>
        <div class="tlp">
            <strong>公开程度说明：</strong><br>
            <p>对所有公开：允许51job的招聘人员及所有通过51job审核的公司查看你的简历（注意：只允许有1份简历可以选择对所有公开）。</p>
            <p>对无忧公开：只允许51job的招聘人员及认证猎头人士查看你的简历。</p>
            <p>完全保密：不允许任何人员或公司查看您的简历，个人信息完全保密，除非你主动投递职位。</p>
            <br>
            <br>
            <strong>快速投递说明：</strong><br>
            <p>将简历设置为快速投递，申请职位时，直接发送设置快速投递的简历，不再提示选择简历。知己知彼竞争力分析也会默认使用快速投递简历进行分析。</p>
        </div>
    </div>

</div>

<script src="${pageContext.request.contextPath}/js/resume/all.js"></script>

</body>
</html>