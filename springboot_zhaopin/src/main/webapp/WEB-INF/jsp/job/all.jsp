<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/2/26
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<title>职位搜索页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jobsearch.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui/css/layui.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/layui/layui.js"></script>
</head>
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
            <img src="../images/phone.png" alt="">
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
                <a href="../user/register.html" class="header_login_and_regist_a">登录</a>
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
                <img src="../images/logo_blue.png" alt="" width="90" height="40">
            </a>
        </div>

        <div class="slogen">
            <img src="../images/slogen.png" alt=""  width="162" height="17" style="float: left">
        </div>

        <div class="nlink">
            <a href="../index.html" class="nag_index_a">首页</a>
            <a href="jobsearch.html" class="nag_label_a"> 职位搜索</a>
            <a href="" class="nag_label_a">地区频道</a>
            <a href="" class="nag_label_a">职场资讯</a>
            <a href="" class="nag_label_a">校园招聘</a>
            <a href="" class="nag_label_a">无忧精英</a>
        </div>

    </div>
</div>
<!--分割div，无实际意义-->
<div style="height: 10px"></div>
<!--搜索条件部分-->
<!--关键字，城市搜索等div-->
<div class="search_main_div">
    <!--搜索主体-->
    <div class="search_body_div">
        <!--搜公司/职位-->
        <div class="search_com_job_div">
            <!--搜全文-->
            <div class="search_allFile_div">全文</div>
            <!--搜公司-->
            <div class="search_comName_div">搜公司</div>
            <!--输入框-->
            <input class="search_ipt" placeholder="搜索全文/职位名" value="${kw}">
        </div>
        <!--地点-->
        <div class="search_com_place_div">
            <div class="search_com_place">地点</div>
            <div class="choose_com_place">选择地点</div>
        </div>
        <!--行业-->
        <div class="search_industry_div">
            <div class="search_industry">行业</div>
            <div class="choose_industry">选择行业</div>
        </div>
        <!--职能-->
        <div class="search_functions_div">
            <div class="search_industry">职能</div>
            <div class="choose_industry">选择职能</div>
        </div>
        <!--搜索按钮-->
        <div class="search_btn_div">
            <button class="search_btn">搜索</button>
        </div>
    </div>
    <!--热门推荐-->
    <div class="hot_jobs">
        <div style="margin-left:20px;cursor:auto;color: rgb(255, 255, 255)">热门推荐：</div>
        <div style="margin-left:135px">前程无忧招聘</div>
        <div style="margin-left:255px">销售</div>
        <div style="margin-left:320px">人事</div>
        <div style="margin-left:380px">Java</div>
        <div style="margin-left:440px">会计</div>
        <div style="margin-left:500px">UI</div>
        <div style="margin-left:560px">平面设计</div>
        <div style="margin-left:680px">行政</div>
        <div style="margin-left:740px">web前端</div>
        <div style="margin-left:830px">房地产</div>
    </div>
</div>
<!--分割div，无实际意义-->
<div style="height: 10px"></div>
<!--筛选页面-->
<div class="main">
    <div class="el">
        <span>发布日期：</span>
        <ul class="publishtimeUL">
            <li><a href="javascript:void(0)" class="all">所有</a></li>
            <li><a href="javascript:void(0)">24小时内</a></li>
            <li><a href="javascript:void(0)">近三天</a></li>
            <li><a href="javascript:void(0)">近一周</a></li>
            <li><a href="javascript:void(0)">近一月</a></li>
        </ul>
    </div>
    <div class="el">
        <span>月薪范围：</span>
        <ul class="salaryUL">
            <li><a href="javascript:;" class="all">所有</a></li>
            <li><a href="javascript:;">0-2000</a></li>
            <li><a href="javascript:;">2000-3000</a></li>
            <li><a href="javascript:;">3000-4500</a></li>
            <li><a href="javascript:;">4500-6000</a></li>
            <li><a href="javascript:;">6000-8000</a></li>
            <li><a href="javascript:;">8000-10000</a></li>
        </ul>
    </div>
    <div class="el">
        <span>公司性质：</span>
        <ul class="companyUL">
            <li><a href="javascript:void(0)" class="all">所有</a></li>
            <li><a href="javascript:void(0)">国企</a></li>
            <li><a href="javascript:void(0)">外资（欧美）</a></li>
            <li><a href="javascript:void(0)">上市公司</a></li>
            <li><a href="javascript:void(0)">合资</a></li>
        </ul>
    </div>
    <div class="el">
        <span>工作年限：</span>
        <ul class="workyearUL">
            <li><a href="javascript:void(0)" class="all">所有</a></li>
            <li><a href="javascript:void(0)">无经验</a></li>
            <li><a href="javascript:void(0)">1-3年</a></li>
            <li><a href="javascript:void(0)">3-5年</a></li>
            <li><a href="javascript:void(0)">5-7年</a></li>
            <li><a href="javascript:void(0)">7-9年</a></li>
        </ul>
    </div>
    <div class="el">
        <span>学历要求：</span>
        <ul class="degreeUL">
            <li><a href="javascript:void(0)" class="all">所有</a></li>
            <li><a href="javascript:void(0)">初中及以下</a></li>
            <li><a href="javascript:void(0)">高中</a></li>
            <li><a href="javascript:void(0)">大专</a></li>
            <li><a href="javascript:void(0)">本科</a></li>
        </ul>
    </div>
    <!-- <div class="el">
         <span>公司规模：</span>
         <ul>
             <li><a href="javascript:void(0)" class="all">所有</a></li>
             <li><a href="javascript:void(0)">少于50人</a></li>
             <li><a href="javascript:void(0)">50-150人</a></li>
             <li><a href="javascript:void(0)">150-500人</a></li>
             <li><a href="javascript:void(0)">500-1000人</a></li>
         </ul>
     </div>-->

    <div class="in">
        <span>已选条件：</span>
        <p></p>
    </div>
</div>
<!--分割div，无实际意义-->
<div style="height: 10px"></div>


<span style="font-size: 16px;margin-left: 500px;display: inline-block;margin-top: 60px" class="job_list_msg"></span>
<!--========列表表格=======-->
<div id="List" class="job_list">
    <!--列表表头-->

    <div id="job_list_title_div">
        <div >职位名</div>
        <div >公司名</div>
        <div >工作地点</div>
        <div >薪资</div>
        <div >发布时间</div>
    </div>
    <!--表格数据-->

    <!--================================-->
    <!--此部分后期由js添加-->
    <!--================================-->
    <div id="joblist1">

    </div>

    <div class="pagenation">
        <a class="previous_page" href="javascript:;">>上一页</a>

        当前是第<span class="pageNum"></span> 页，
        共有<span class="pages"></span> 页，共有<span class="total"></span> 条记录，

        <a class="next_page" href="javascript:;">下一页></a>
    </div>


    <!--<div id="pageLimit"></div>-->
</div>

<!--购物车结算-->
<div class="cart_clear">
    <!--结算按钮-->
    <div class="clear_button_div">
        <div style="margin-top: 14px;">
            <a  class="clear_button_a">投 递</a>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/job/all.js"></script>
<script src="${pageContext.request.contextPath}/js/job/allv2.js"></script>
</body>

</html>

