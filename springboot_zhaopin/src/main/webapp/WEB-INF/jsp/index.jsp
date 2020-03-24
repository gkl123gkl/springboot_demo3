<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/2/24
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

</head>

<body>
<div class="body-head">
    <div class="topindex">
        <a href=""><img src="${pageContext.request.contextPath}/images/logo_blue.png"></a>
        <img src="${pageContext.request.contextPath}/images/slogen.png">
        <div class="nlink">
            <a class="on" href="${pageContext.request.contextPath}/index.jsp">首页</a>
            <a class="" href="${pageContext.request.contextPath}/job/all.jsp">职位搜索</a>
            <a class="" href="javascript:void(0)">地区频道</a>
            <a class="" href="javascript:void(0)">职场资讯</a>
            <a class="" href="/resumedeliveryrecordall">我的投递</a>
            <a class="" href="/resume">简历中心</a>




            <div class="login_status" >
                <c:if test="${empty loginCustomer}">
                    <span class="login_btns">
                        <a href="/login" >登录</a>
                        <a href="/regist" >注册</a>
                    </span>
                </c:if>
                <c:if test="${!empty loginCustomer}">
                    <span class="user_btns">
                        <a href="">${loginCustomer.custTelno}</a>
                        <a href="/index">退出</a>
                    </span>
                </c:if>

            </div>

<%--${loginCustomer.custTelno}--%>

        </div>
    </div>
    <div class="search">
        <div class="btn-search">
            <div class="sbtn1">
                <span>全文</span>
                <img src="${pageContext.request.contextPath}/images/chevron-down.svg">
            </div>
            <input type="text" class="keyword" placeholder="请输入关键字">
            <div class="area">
                <input type="button" value="苏州">

            </div>
            <button class="sbtn">搜索</button>
            <a class="gj-search" href="">高级<br>搜索</a>
        </div>
        <div class="sbtn2">
            <span>公司</span>
        </div>
        <div class="ht">
            <span>热门推荐：</span>
            <a href="">销售</a>
            <a href="">java</a>
            <a href="">人事</a>
            <a href="">会计</a>
            <a href="">UI</a>
            <a href="">平面设计</a>
            <a href="">行政</a>
            <a href="">web前端</a>
        </div>

    </div>

</div>
<div class="cresume">
    <a href="">立即创建简历，发现好工作</a>
</div>
<div class="cn">
    <div class="hcity">
        <span>城市求职</span>
        <div class="li">
            <a href="">北京</a>
            <a href="">上海</a>
            <a href="">广州</a>
            <a href="">深圳</a>
            <a href="">武汉</a>
            <a href="">西安</a>
            <a href="">杭州</a>
            <a href="">南京</a>
            <a href="">成都</a>
            <a href="">重庆</a>
            <a href="">东莞</a>
            <a href="">大连</a>
            <a href="">沈阳</a>
            <a href="">苏州</a>
            <a href="">昆明</a>
            <a href="">长沙</a>
            <a href="">合肥</a>
            <a href="">宁波</a>
            <a href="">郑州</a>
            <a href="">天津</a>
            <a href="">青岛</a>
        </div>
        <a  class="mome" id="mome1" href="javascript:void(0)">更多</a>
    </div>
    <div class="hcbox">
        <span>拼音检索</span>
        <ul>
            <li class="li1 22 on2" >A B C</li>
            <li class="22" >D E F</li>
            <li class="22" >G H</li>
            <li class="22" >J K L</li>
            <li class="22" >M N P</li>
            <li class="22" >Q R S</li>
            <li class="22" >T W X</li>
            <li class="22" >Y Z</li>
        </ul>
        <div class="clst">
            <div class="e on3">
                <a href="">鞍山</a>
                <a href="">安庆</a>
                <a href="">安阳</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
            <div class="e" >
                <a href="">大连</a>
                <a href="">东莞</a>
                <a href="">丹东</a>
                <a href="">大庆</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
            <div class="e" >
                <a href="">广州</a>
                <a href="">安庆</a>
                <a href="">安阳</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
            <div class="e" >
                <a href="">济南</a>
                <a href="">安庆</a>
                <a href="">安阳</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
            <div class="e" >
                <a href="">绵阳</a>
                <a href="">安庆</a>
                <a href="">安阳</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
            <div class="e">
                <a href="">青岛</a>
                <a href="">安庆</a>
                <a href="">安阳</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
            <div class="e" >
                <a href="">天津</a>
                <a href="">安庆</a>
                <a href="">安阳</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
            <div class="e" >
                <a href="">烟台</a>
                <a href="">安庆</a>
                <a href="">安阳</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>
                <a href="">鞍山</a>

            </div>
        </div>
    </div>
</div>
<div class="hlist">
    <div class="hlist-e">
        <a class="atitle" href="post/positiondetails.html">互联网/电子商务</a><br>
        <a href="">前端开发</a><br>
        <a href="">PHP</a><br>
        <a href="">数据分析</a><br>
    </div>
    <div class="hlist-e">
        <a class="atitle" href="post/positiondetails.html">互联网/电子商务</a><br>
        <a href="">前端开发</a><br>
        <a href="">PHP</a><br>
        <a href="">数据分析</a><br>
    </div>
    <div class="hlist-e">
        <a class="atitle" href="post/positiondetails.html">互联网/电子商务</a><br>
        <a href="">前端开发</a><br>
        <a href="">PHP</a><br>
        <a href="">数据分析</a><br>
    </div>
    <div class="hlist-e">
        <a class="atitle" href="post/positiondetails.html">互联网/电子商务</a><br>
        <a href="">前端开发</a><br>
        <a href="">PHP</a><br>
        <a href="">数据分析</a><br>
    </div>
</div>
<div class="hserver">
    <a class="tie" href="">企业服务</a>
    <div class="hlst">
        <span><a href="">人事外包</a></span>
        <span><a href="">调研中心</a></span>
        <span><a href="">企业培训</a></span>
        <span><a href="">典范雇主</a></span>
        <span><a href="">在线测评</a></span>
        <span><a href="">薪酬调查</a></span>
    </div>
    <a class="cln" href="">企业入口</a>
</div>


<div>

</div>


<div class="new_jobs">
    <ul class="job_ul">

    </ul>
</div>

<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/job/allv2.js"></script>
<%--加载最新的10条招聘记录--%>

</body>
</html>

