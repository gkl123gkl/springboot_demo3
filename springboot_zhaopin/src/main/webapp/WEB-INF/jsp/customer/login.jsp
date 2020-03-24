<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/2/25
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>欢迎登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
</head>
<body>

<div class="register-head">
    <a href=""><img src="${pageContext.request.contextPath}/images/logo_blue.png"></a>
    <img src="../images/slogen.png">
    <span class="title1">|</span>
    <span class="title">欢迎登录</span>
    <div class="link-home">
        <a class="home" href="${pageContext.request.contextPath}/index.jsp">首页</a>
        <a class="help" href="">帮助中心</a>
    </div>
</div>
<div class="lbox">
    <div class="register-kind">
        <span class="now-kind">密码登录</span>
        <span  class="new-kind">验证码登录</span>
    </div>

    <span class="loginMsg" style="font-size: 10px;color: red"></span>

    <form class="login_form">
    <ul class="register-bypw">
        <li>
            <lable>账&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号：</lable>
            <input class="tel-code custLoginAccount" name="custLoginAccount" type="text"  placeholder="  请输入手机号码/邮箱/用户名">
            <span class="error-msg"></span>
        </li>

        <li>
            <lable>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</lable>
            <input class="pw-code custPassword"  name="custPassword" type="password" placeholder="  请输入密码">
        <span class="error-msg"></span>
        </li>
    </ul>
    <ul class="register-bytel">
        <li>
            <lable>手机号码：</lable>
            <input class="tel-code" type="text" onblur="checkTel()" placeholder="  请输入手机号码">
            <span class="error-msg"></span>
        </li>
        <li>
            <lable>短信验证码：</lable>
            <input class="sms-code" type="text" placeholder="  请输入短信验证码">
            <a href="" class="sms-btn">发送验证码</a>
            <span class="error-msg"></span>
        </li>
    </ul>
    <div class="tiaokuan-check">
        <input type="checkbox" class="tiaokuan-checked">
        <span>自动登录</span>
        <a href="">忘记密码?</a>
    </div>
    <input class="register-btn" type="button" value="登录">
    </form>
    <div class="have-id">
        <span>还没有有账号？</span>
        <a href="regist.jsp">免费注册</a>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/customer/login.js"></script>
<script src="${pageContext.request.contextPath}/js/customer/loginv2.js"></script>
</body>
</html>
