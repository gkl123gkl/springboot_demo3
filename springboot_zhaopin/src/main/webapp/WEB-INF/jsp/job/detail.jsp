<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/3
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/positiondetails.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<body>
<!--网站头部-->
<div class="header">
    <!--最顶部橙色部分-->
    <div class="bar">
        <!--字体选择-->
        <div class="language">
            <ul id="languageList">
                <li class="nowLanguage_li">
                    <span class="nowLanguage_span">简</span>
                </li>
            </ul>
        </div>
        <!--app下载-->
        <div class="app_download_div">
            <img src="${pageContext.request.contextPath}/images/phone.png" alt="">
            <span class="App_download_span">APP下载</span>
        </div>
        <!--职场百科职场文库。。。-->
        <div class="top_header_other_div">
            <a href="" class="top_header_other_a">职场百科</a>
            <a href="" class="top_header_other_a">职场文库</a>
            <a href="" class="top_header_other_a">招聘信息</a>
            <a href="" class="top_header_other_a">企业服务</a>
        </div>
        <!--登录注册-->
        <div class="header_login_and_regist_div">
            <div class="header_re_lo">
                <input type="hidden" class="jobId" value="${jobCompany.job.jobId}">
                <a href="../user/register.html" class="header_login_and_regist_a">${loginCustomer.custTelno}</a>
                <span href="" class="header_login_and_regist_a"> / </span>
                <a href="../user/login.html" class="header_login_and_regist_a">注册</a>
            </div>
        </div>
    </div>
    <!--分割div，无实际意义-->
    <div style="height: 8px"></div>
    <!--顶部导航栏部分-->
    <div class="nag">
        <div class="nag_logo_a">
            <a href="../index.html" >
                <img src="${pageContext.request.contextPath}/images/logo_blue.png" alt="" width="90" height="40">
            </a>
        </div>

        <div class="slogen">
            <img src="${pageContext.request.contextPath}/images/slogen.png" alt=""  width="162" height="17" style="float: left">
        </div>

        <div class="nlink">
            <a href="${pageContext.request.contextPath}/index.jsp" class="nag_index_a">首页</a>
            <a href="jobsearch.html" class="nag_label_a"> 职位搜索</a>
            <a href="" class="nag_label_a">地区频道</a>
            <a href="" class="nag_label_a">职场资讯</a>
            <a href="" class="nag_label_a">校园招聘</a>
            <a href="" class="nag_label_a">无忧精英</a>
        </div>

    </div>
</div>

<!--大致招聘信息-->
<div id="hire">
    <div id="hire_info">
        <div id="hire_info_1">

            <!--职位-->
            <span class="job_name">${jobCompany.job.jobName}</span>

            <!--薪水-->
            <div id="salary">
                <span class="min_salary">${jobCompany.job.jobMinSalary}</span>
                <span>-</span>
                <span class="max_salary">${jobCompany.job.jobMaxSalary}</span>
                <span>/月</span>
            </div>

            <!--公司信息-->
            <div class="com_info">
                <a href="" class="job_name_a">${jobCompany.company.companyName}</a>
                <a href="">查看所有职位</a>
            </div>

            <!--此div里的元素后期应由js进行添加-->
            <div id="job_require">
                <span>职位需求：&nbsp;&nbsp;</span>
                <span>${jobCompany.job.jobCity}&nbsp;&nbsp;</span>
                <span>${jobCompany.job.jobYear}经验&nbsp;&nbsp;</span>
                <span>${jobCompany.job.jobDegree}&nbsp;&nbsp;</span>
            </div>

            <!--公司福利-->
            <!--此div里的元素也应由js进行添加-->
            <div class="com_welfare">
                <span>五险一金</span>
                <span>餐饮补贴</span>
                <span>专业培训</span>
                <span>绩效奖金</span>
                <span>年终奖金</span>
                <span>定期体检</span>
                <span>做五休二</span>
                <span>节日福利</span>
                <span>带薪年假</span>
                <span>通讯补贴</span>
            </div>
        </div>

        <div id="hire_info_2">
            <!--收藏-->
            <div class="collection">
                <div class="star_div">
                    <img src="${pageContext.request.contextPath}/images/star-empty.png" alt="" class="job_col_star">
                </div>
                <div class="collection_div">
                    <span class="col_stat">收藏</span>
                </div>
                <span class="applyMsg" style="position: relative; top: 110px;left: -120px;display: block;width:300px;color:#ff6000;font-size: 12px"></span>
                <!--申请职位-->
                <div class="application_job">


                    <div class="application_btn"  >
                        <span class="applyForJobBtn" style="display: block;width: 100%;height: 60px;
                        background-color: #ff6000;font-size: 16px;line-height: 60px">申请职位</span>

                        <div class="resume_list" style="font-size: 14px; color: black" >

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!--详细介绍部分-->
<div class="desc_info">
    <!--职位信息-->
    <div class="desc_job_info_div">
        <span class="desc_span">职业信息</span>
        <div class="desc_content">
            <p>${jobCompany.job.jobDuty}</p>

        </div>
        <div style="margin-top: 10px">
            <hr/>
        </div>
    </div>

    <!--联系方式-->
    <div class="desc_job_info_div">
        <span class="desc_span">工作职责</span>
        <div class="desc_content">
            <p><p>${jobCompany.job.jobDemand}</p></p>

        </div>
        <div style="margin-top: 10px">
            <hr/>
        </div>
    </div>

    <!--公司信息-->
    <div class="desc_job_info_div">
        <span class="desc_span">公司信息</span>
        <div class="desc_content">
            <p>${jobCompany.company.companyDesc}</p>

        </div>
        <div style="margin-top: 10px">
            <hr/>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/js/job/detail.js"></script>
</body>
</html>
