<%--
  Created by IntelliJ IDEA.
  User: qianghj
  Date: 2020/2/12
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<meta charset="UTF-8">
<title>创建新简历</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/createResume.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/showResume.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

<style>
    .input-name {
        display: block;
        width: 176px;
        height: 28px;
        overflow: hidden;
        margin-left: 15px;
        margin-top: 10px
    }

    .save-btn1, .undo-btn {
        width: 80px;
        height: 28px;
        margin-top: 10px;
        margin-left: 15px;
        border: none;
    }

    .save-btn1 {
        background: #ff6000;
        color: white;
    }


</style>
</head>
<body>
<!--====================网页头部===============================-->
<div class="header">
    <div class="head">
        <div class="head-left">
            <div class="head-left-first"></div>
            <div class="head-left-second"></div>
        </div>
        <div class="head-right">
            <ul>
                <li><a href="../index.html">首页</a></li>
                <li><a href="">我的51job</a></li>
                <li><a href="../customer/center.html">简历中心</a></li>
            </ul>
        </div>
    </div>

</div>


<!--====================网页主体===============================-->
<div class="main">
    <!--  网页主体内容  -->
    <div class="body-content">
        <!-- 左侧导航 -->
        <div class="left-nav">
            <div class="left-nav-desc">


                <input type='text' readonly class='resumeId'  >


                <div class="title">
                    <span class="title-h3" style="line-height: 90px">我的简历</span>
                    <a href="JavaScript:void(0)" >
                        <img src="${pageContext.request.contextPath}/images/update.png"
                             class="update-resume-name"
                             style="margin:33px 30px"></a>
                    <!--<input type="text"   class="input-name resume_name" value="我的简历" >
                    <button class="save-btn1" onclick="saveUpdateName()">保存</button>
                    <button class="undo-btn" onclick="undo()">取消</button>-->
                </div>

                <sapn class="resumeNameMsg" style="color:red;font-size: 8px">更新:</sapn>
                <ul>
                    <li>
                        <sapn class="sp-update">更新:</sapn>
                        <span class="sp-update update-value update-time">2020-01-09</span>
                    </li>
                    <li>
                        <sapn class="open">公开: 对无忧公开</sapn>
                    </li>
                    <li>
                        <div class="star"></div>
                    </li>
                    <li>
                        <a href="">刷新</a><a href="show.html">预览</a>
                    </li>
                </ul>
            </div>

            <!--  左侧导航栏主体部分  -->
            <div class="left-nav-url">
                <ul>
                    <li>
                        <a href="">
                            <i class="icon1"></i>
                            <span class="nav-content">基本信息</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="icon2"></i>
                            <span class="nav-content">求职意向</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="icon3"></i>
                            <span class="nav-content">工作经验</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="icon4"></i>
                            <span class="nav-content">项目经验</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="icon5"></i>
                            <span class="nav-content">教育经历</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="icon6"></i>
                            <span class="nav-content">在校情况</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="icon7"></i>
                            <span class="nav-content">技能特长</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <!--中间主体内容-->
        <div class="content">

            <!--创建简历 -- 用户个人信息-->
            <div class="user-infor">

                <!--用户头像-->
                <div class="user-icon">
                    <span class="user-page"></span>
                    <div class="do">
                        <a href="JavaScript:void(0)">修改</a>

                    </div>
                </div>

                <div class="update-user-page">
                    <input type="file">
                    <p>(大小不能超过1M，支持格式为:gif、jpg、png等)</p>
                </div>


                <!--用户基本信息-->
                <div class="user-content">
                    <div class="message-row">
                        <div class="user-left">
                            <label class="user-type">姓名</label>
                            <i>*</i>
                            <input type="text" class="perName">
                        </div>
                        <div class="user-right gender-click">
                            <label class="user-type">性别</label>
                            <i>*</i>
                            <button class="man-btn" style="color: white">
                                <em class="man-icon"></em>
                                <span>男</span>
                            </button>
                            <button class="women-btn" style="color: black;">
                                <em class="women-icon"></em>
                                <span>女</span>
                            </button>
                        </div>
                    </div>
                    <div class="message-row">
                        <div class="user-left">
                            <label class="user-type">出生日期</label>
                            <i>*</i>
                            <input type="date" class="birthday">
                        </div>
                        <div class="user-right">
                            <label class="user-type">开始工作年份</label>
                            <i>*</i>
                            <input type="text" class="startworkyear">
                        </div>
                    </div>
                    <div class="message-row">
                        <div class="user-left">
                            <label class="user-type">手机</label>
                            <i>*</i>
                            <input type="text" class="phone">
                        </div>
                        <div class="user-right">
                            <label class="user-type">求职状态</label>
                            <i>*</i>
                            <select class="select-type" style="width: 210px;height: 32px">
                                <option>目前正在找工作</option>
                                <option>观望有好机会会考虑</option>
                                <option>我目前不想换工作</option>
                            </select>
                        </div>
                    </div>
                    <div class="message-row">
                        <div class="user-left">
                            <label class="user-type">邮箱</label>
                            <i>*</i>
                            <input type="email" class="email">
                        </div>
                        <div class="user-right">
                            <label class="user-type">居住地</label>
                            <i>*</i>
                            <input type="text" placeholder="请输入居住地" class="loc">
                        </div>
                    </div>
                    <div class="uer-id">
                        <label class="user-type">证件号</label>
                        <i>*</i>
                        <select class="card-select">
                            <option>身份证</option>
                            <option>护照</option>
                            <option>军人证</option>
                            <option>港澳居民来往内地通行证</option>
                            <option>外国人永久居留身份证</option>
                        </select>
                        <input type="text" class="id" style="width: 400px;float: right;margin-right:8px ">
                    </div>
                </div>


                <!-- 保存、取消按钮 -->
                <div class="user-infor-btn">
                    <div class="btn-container">
                        <span class="user-save-btn">保存</span>
                        <span class="user-undo-btn">取消</span>
                    </div>
                </div>

            </div>


            <!--简历预览：用户个人信息  -->
            <div class="preview-infor">
                <div class="p-user-icon"></div>
                <div class="p-user-content">
                    <div class="user-title">
                        <h2 class="p-username">姓名</h2>
                        <a href="JavaScript:void(0)"><img src="${pageContext.request.contextPath}/images/update.png"></a>
                    </div>
                    <p>现居住于城市工业园区 | N年工作经验 | 性别 | 年龄岁(出身日期) | 工作状态</p>
                    <div class="p-user-connection">
                        <div class="conn-left">
                            <img src="${pageContext.request.contextPath}/images/email.png"><i class="p-email">邮箱</i>
                        </div>
                        <div class="conn-right">
                            <img src="${pageContext.request.contextPath}/images/phone.png"><i class="p-phone">手机号</i>
                        </div>
                    </div>
                </div>

            </div>


            <!--   年收入   -->
            <div class="year-income">
                <div class="year-income-title">
                    <h3>目前年收入</h3>
                    <span>（包含基本工资、补贴、奖金、股权收益等）</span>
                </div>

                <div class="year-income-content">
                    <div class="income">
                        <span>目前年收入</span>
                        <input type="text" class="income-money"/>
                        <span>万元</span>
                    </div>

                    <div class="income-btn">
                        <div class="income-btn-center">
                            <span class="income-save-btn">保存</span>
                            <span class="income-undo-btn">取消</span>
                        </div>
                    </div>
                </div>
            </div>


            <!--   年收入展示   -->
            <div class="show-income">
                <div class="year-income-title">
                    <h3>目前年收入</h3>
                    <i class="income-value"></i><i>万元</i>
                    <span>（包含基本工资、补贴、奖金、股权收益等）</span>
                    <a href="JavaScript:void(0)"><img src="${pageContext.request.contextPath}/images/update.png"></a>
                </div>
            </div>


            <!--   求职意向     -->
            <div class="job-intention">
                <div class="job-title">
                    <h3>求职意向</h3>
                </div>
                <div class="job-intention-content">
                    <div class="job-row-first">
                        <span>期望薪资</span>
                        <i>*</i>
                        <select class="salary-type">
                            <option>年薪</option>
                            <option>月薪</option>
                            <option>日薪</option>
                            <option>时薪</option>
                        </select>
                        <select class="year-salary">
                            <option>3万以下</option>
                            <option>3~5万</option>
                            <option>5~8万</option>
                            <option>8~10万</option>
                            <option>10~20万</option>
                            <option>20~30万</option>
                            <option>30万以上</option>
                        </select>
                        <input type="text" class="month-salary" placeholder="请输入">
                        <input type="text" class="day-salary" placeholder="请输入">
                        <input type="text" class="hour-salary" placeholder="请输入">
                    </div>

                    <div class="job-row">
                        <span>地点</span>
                        <i>*</i>
                        <input type="text" class="workLoc" placeholder="填写/选择">
                    </div>
                    <div class="job-row">
                        <span>职位</span>
                        <i>*</i>
                        <input type="text" class="job-level" placeholder="填写/选择">
                    </div>
                    <div class="job-row">
                        <span>个人标签</span>
                        <i>*</i>
                        <input type="text" class="label-self" placeholder="职业/技能/行业关键词">
                        <p>限10个，每个词不超过12个中文或24个英文</p>
                    </div>

                    <div class="job-row">
                        <span>自我评价</span>
                        <i>*</i>
                        <textarea class="introduce-self" placeholder="介绍自己的闪光点，300字以内"></textarea>
                    </div>

                    <div class="job-row-last">
                        <div class="job-row-last-left">
                            <span>到岗时间</span>
                            <select class="arrival-job-time">
                                <option>随时</option>
                                <option>一周内</option>
                                <option>一月内</option>
                                <option>三月内</option>
                            </select>
                        </div>
                        <div class="job-row-last-right">
                            <span>工作类型</span>
                            <select class="job-type">
                                <option>全职</option>
                                <option>兼职</option>
                                <option>实习</option>
                                <option>全兼职</option>
                            </select>
                        </div>
                    </div>

                    <div class="job-btn">
                        <button class="job-save">保存</button>
                        <button class="job-not-save">取消</button>
                    </div>


                </div>


            </div>

            <!--       求职意向展示         -->
            <div class="job-intention-show">
                <div class="job-show-title">
                    <h3>求职意向</h3>
                    <a href="javascript:void(0)"> <img src="${pageContext.request.contextPath}/images/update.png"></a>
                </div>
                <div class="show-intention-content">
                    <div class="show-job-row">
                        <span>期望工资：</span><i class="salary">6999-8999元/月</i>
                    </div>
                    <div class="show-job-row">
                        <span class="sp1">工作地点：</span><i class="work-loc1">苏州</i>
                    </div>
                    <div class="show-job-row">
                        <span>职位：</span><i class="job-level1">java开发工程师</i>
                    </div>
                    <div class="show-job-row">
                        <span>个人标签：</span><i class="label-self1">java</i>
                    </div>
                    <div class="show-job-row">
                        <span>自我评价：</span><i class="introduce-self1">666666</i>
                    </div>
                    <div class="show-job-row">
                        <span>到岗时间：</span><i class="arrival-time1">随时</i>
                    </div>
                    <div class="show-job-row">
                        <span class="sp2">工作类型：</span><i class="job-type1">全职</i>
                    </div>

                </div>
            </div>


            <!--          工作经验         -->
            <div class="create_experience job-experience">
                <div class="job-expr-title">
                    <h3>工作经验</h3>
                </div>
                <div class="job-expr-content">
                    <input type="hidden" class="work_experience_id">
                    <div class="job-expr-row">
                        <span>时间</span>
                        <i>*</i>
                        <div class="layui-form">
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <input type="text" class="layui-input time-ipt" id="test8" placeholder=" - ">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="job-expr-row">
                        <span>公司</span>
                        <i>*</i>
                        <input type="text" class="company-name">
                        <input type="hidden" value="" class="job-exper-key">
                    </div>
                    <div class="job-expr-row">
                        <span>职位</span>
                        <i>*</i>
                        <input type="text" class="expr-job-level">
                    </div>
                    <div class="job-expr-row">
                        <span>公司规模</span>
                        <i>*</i>
                        <select class="expr-company-size">
                            <option>300人以下</option>
                            <option>300-500人</option>
                            <option>500-1000人</option>
                            <option>1000-5000人</option>
                            <option>5000-10000人</option>
                            <option>10000人以上</option>
                        </select>
                    </div>
                    <div class="job-expr-row">
                        <span>部门</span>
                        <i>*</i>
                        <input type="text" class="expr-dept">
                    </div>
                    <div class="job-expr-row">
                        <span>公司性质</span>
                        <i>*</i>
                        <select class="company-type">
                            <option>国企</option>
                            <option>民营</option>
                            <option>外企</option>
                        </select>
                    </div>
                    <div class="job-expr-row">
                        <span>工作描述</span>
                        <i>*</i>
                        <textarea class="job-description"></textarea>
                    </div>
                    <div class="job-expr-row last-expr-row">
                        <span>工作类型</span>
                        <i>*</i>
                        <button class="btn-quan" style="color: white">全职</button>
                        <button class="btn-jian">兼职</button>
                    </div>
                    <div class="job-expr-btn-container">
                        <button class="job-expr-save">保存</button>
                        <button class="job-expr-unsave">取消</button>
                    </div>
                </div>
            </div>


            <!--      工作经验展示       -->
            <div class="experience job-experience-show">
                <div class="jes-title">
                    <h3>工作经验</h3>
                    <a href="javascript:void(0)" class="add-job-exper" onclick="show1()">添加工作经验</a>
                </div>
                <div class="jse-con">

                </div>
            </div>


            <!--   项目经验    -->
            <div class="create_experience pro-exp">
                <div class="job-expr-title">
                    <h3>项目经验</h3>
                </div>
                <div class="job-expr-content pro-expr-content">
                    <div class="job-expr-row">
                        <span>时间</span>
                        <i>*</i>
                        <div class="layui-form">
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <input type="text" class="layui-input pro-time-ipt" id="test9" placeholder=" - ">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="job-expr-row">
                        <span>公司</span>
                        <i>*</i>
                        <input type="text" class="pro-company-name">
                        <input type="hidden" value="" class="pro-exper-key">
                    </div>
                    <div class="job-expr-row">
                        <span>项目名称</span>
                        <i>*</i>
                        <input type="text" class="expr-pro-name">
                    </div>
                    <div class="job-expr-row">
                        <span>项目描述</span>
                        <i>*</i>
                        <textarea class="pro-description"></textarea>
                    </div>
                    <div class="job-expr-row des">
                        <span>责任描述</span>
                        <i>*</i>
                        <textarea class="pro-duty-description"></textarea>
                    </div>
                    <div class="pro-expr-btn-container">
                        <button class="pro-expr-save">保存</button>
                        <button class="pro-expr-unsave">取消</button>
                    </div>
                </div>
            </div>

            <!--  项目经验展示  -->
            <div class="experience  pro-experience-show">
                <div class="jes-title">
                    <h3>项目经验</h3>
                    <a href="javascript:void(0)" class="add-pro-exper" onclick="show2()">添加项目经验</a>
                </div>
                <div class="pro-con">

                </div>
            </div>


            <!--    教育经历       -->
            <div class="create_experience edu-exp">
                <div class="job-expr-title">
                    <h3>教育经历</h3>
                </div>
                <div class="job-expr-content edu-content">
                    <div class="job-expr-row">
                        <span>时间</span>
                        <i>*</i>
                        <div class="layui-form">
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <input type="text" class="layui-input edu-time-ipt" id="test10" placeholder=" - ">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="job-expr-row">
                        <span>学校</span>
                        <i>*</i>
                        <input type="text" class="school-name">
                        <input type="hidden" value="" class="edu-exper-key">
                    </div>
                    <div class="job-expr-row">
                        <span>学历/学位</span>
                        <i>*</i>
                        <select class="edu-select">
                            <option>中技</option>
                            <option>中专</option>
                            <option>大专</option>
                            <option>本科</option>
                            <option>硕士</option>
                            <option>博士</option>
                            <option>MBA</option>
                        </select>
                        <input type="checkbox" class="isAllDay" name="isALLDay">
                        <span id="allday">全日制</span>
                    </div>
                    <div class="job-expr-row">
                        <span>专业</span>
                        <i>*</i>
                        <input type="text" class="major" placeholder="高中及以下学历选填">
                    </div>
                    <div class="job-expr-row">
                        <span>专业描述</span>
                        <i>*</i>
                        <textarea class="major-description"></textarea>
                    </div>
                    <div class="job-expr-row last-expr-row edu-btn">
                        <span>海外经历</span>
                        <i>*</i>
                        <button class="btn-yes">是</button>
                        <button class="btn-no">否</button>
                    </div>
                    <div class="job-expr-btn-container">
                        <button class="edu-expr-save">保存</button>
                        <button class="edu-expr-unsave">取消</button>
                    </div>
                </div>
            </div>


            <!--  教育经历展示   -->
            <div class="experience  edu-experience-show">
                <div class="jes-title">
                    <h3>教育经历</h3>
                    <a href="javascript:void(0)" class="add-edu-exper" onclick="show3()">添加教育经历</a>
                </div>
                <div class="edu-con">

                </div>
            </div>



            <!--  在校情况  -->

            <div class="create_experience aword">
                <div class="job-expr-title">
                    <h3>在校荣誉</h3>
                </div>
                <div class="job-expr-content aword-content">
                    <div class="job-expr-row">
                        <span>时间</span>
                        <i>*</i>
                        <input type="date" class="aword-time">
                        <input type="hidden" value="" class="aword-key">
                    </div>
                    <div class="job-expr-row">
                        <span>奖项</span>
                        <i>*</i>
                        <input type="text" class="aword-name">
                    </div>
                    <div class="job-expr-row">
                        <span>级别</span>
                        <i>*</i>
                        <input type="text" class="aword-level">
                    </div>
                    <div class="job-expr-btn-container">
                        <button class="aword-expr-save">保存</button>
                        <button class="aword-expr-unsave">取消</button>
                    </div>
                </div>
            </div>


            <!--  在校情况展示  -->
            <div class="experience  aword-experience-show">
                <div class="jes-title">
                    <h3>在校荣誉</h3>
                    <a href="javascript:void(0)" class="add-aword-exper" onclick="show4()">添加在校荣誉</a>
                </div>
                <div class="aword-con">

                </div>
            </div>

            <!--     技能特长        -->
            <div class="create_experience skill">
                <div class="job-expr-title">
                    <h3>技能特长</h3>
                </div>
                <div class="job-expr-content skill-content">
                    <div class="job-expr-row">
                        <span>技能/语言</span>
                        <i>*</i>
                        <input type="text" class="skill-name">
                        <input type="hidden" value="" class="skill-key">
                    </div>
                    <div class="job-expr-row">
                        <span>掌握程度</span>
                        <i>*</i>
                        <select class="skill-level">
                            <option>一般</option>
                            <option>良好</option>
                            <option>熟练</option>
                            <option>精通</option>
                        </select>
                    </div>
                    <div class="job-expr-btn-container">
                        <button class="skill-expr-save">保存</button>
                        <button class="skill-expr-unsave">取消</button>
                    </div>
                </div>
            </div>


            <!--     技能特长展示        -->
            <div class="experience  skill-experience-show">
                <div class="jes-title">
                    <h3>技能特长</h3>
                    <a href="javascript:void(0)" class="add-skill-exper" onclick="show5()">添加技能特长</a>
                </div>
                <div class="skill-con">

                </div>
            </div>

        </div>


    </div>
</div>
</div>
<!--====================网页脚部===============================-->
<div class="footer"></div>


<script src="${pageContext.request.contextPath}/layui/layui.js " charset="UTF-8"></script>
<script src="${pageContext.request.contextPath}/js/resume/add.js"></script>
<script src="${pageContext.request.contextPath}/js/resume/createResume.js"></script>
<script src="${pageContext.request.contextPath}/js/resume/addResume.js"></script>
<script src="${pageContext.request.contextPath}/js/resume/updateCustInfo.js"></script>
<script src="${pageContext.request.contextPath}/js/resume/updateYearSalary.js"></script>
<script src="${pageContext.request.contextPath}/js/resume/addWorkExperience.js"></script>

<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //年月范围
        laydate.render({
            elem: '#test8'
            , type: 'month'
            , range: true
        })

        laydate.render({
            elem: '#test9'
            , type: 'month'
            , range: true
        })

        laydate.render({
            elem: '#test10'
            , type: 'month'
            , range: true
        })
    })
</script>
</body>
</html>
