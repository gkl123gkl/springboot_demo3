<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/2/24
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>欢迎注册|前程全忧</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
</head>
<body>
<div class="login-head">
    <a href=""><img src="${pageContext.request.contextPath}/images/logo_blue.png"></a>
    <img src="${pageContext.request.contextPath}/images/slogen.png">
    <span class="title1">|</span>
    <span class="title">欢迎注册</span>
    <div class="link-home">
        <a class="home" href="${pageContext.request.contextPath}/index.jsp">首页</a>
        <a class="help" href="">帮助中心</a>
    </div>
</div>
<div class="lbox">
    <div class="login-kind">
        <span class="now-kind">手机注册</span>
        <a href="script:void(0)" class="new-kind">邮箱注册></a>
    </div>

    <span class="registMsg" style="font-size:10px;color: red"></span>
    <form class="regist_form">

    <ul class="login-bytel">
        <li>
            <lable>手机号码：</lable>
            <input class="tel-code" name="custTelno" type="text" onblur="checkTel()" placeholder="  请输入手机号码，它将用于登录和找回密码">
            <span class="error-msg"></span>
        </li>

        <li>
            <lable>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</lable>
            <input class="pw-code" name="custPassword" type="password" placeholder="  请输入密码，6-16位字母/数字/符号组合">
            <span class="error-msg"></span>
        </li>

        <li>
            <lable>确认密码：</lable>
            <input class="confirm-pw-code" type="password" placeholder="  请输入和上面相同的密码">
            <span class="error-msg"></span>
        </li>

        <li>
            <lable>短信验证码：</lable>
            <input class="sms-code" type="text" placeholder="  请输入短信验证码">
            <input  type="button" class="sms-btn" value="发送验证码">
            <span class="error-msg"></span>
        </li>
    </ul>
    <ul class="login-byemail">
        <li>
            <lable>邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱：</lable>
            <input class="email-code" type="text" placeholder="  请输入邮箱，它将用于登录和找回密码">
            <span class="error-msg"></span>
        </li>

        <li>
            <lable>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</lable>
            <input class="pw-code" type="password" placeholder="  请输入密码，6-16位字母/数字/符号组合">
            <span class="error-msg"></span>
        </li>

        <li>
            <lable>确认密码：</lable>
            <input class="confirm-pw-code" type="password" placeholder="  请输入和上面相同的密码">
            <span class="error-msg"></span>

        </li>

        <li>
    </ul>
    <div class="tiaokuan-check">
        <input type="checkbox" class="tiaokuan-checked">
        <span>我已阅读并同意</span>
        <a href="">服务声明和隐私条款</a>
    </div>
    <a class="login-btn" href="script:void(0)">注册</a>

    </form>
    <div class="have-id">
        <span>已有账号，</span>
        <a href="login.jsp">直接登录</a>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/customer/regist.js"></script>
<script src="${pageContext.request.contextPath}/js/customer/registv2.js"></script>
</body>
</html>
