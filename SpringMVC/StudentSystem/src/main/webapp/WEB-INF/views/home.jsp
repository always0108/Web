<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-5-10
  Time: 下午10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title>后台管理中心</title>
  <link rel="stylesheet" href="../../css/admin.css">
  <link rel="stylesheet" href="../../css/pintuer.css">

  <script src="../../js/jquery.js"></script>
  <script src="../../js/pintuer.js"></script>
</head>

<body style="background-color: #f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>
      <img src="../../images/y.jpg" class="radius-circle rotate-hover"
           height="50" alt="" /> 后台管理中心
    </h1>
  </div>
  <div class="head-l">
    <a class="button button-little bg-blue" href="./login.do"><span
        class="icon-power-off"></span> 退出登录</a>
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title">
    <strong><span class="icon-list"></span>菜单列表</strong>
  </div>
  <h2>
    <span class="icon-user"></span>基本设置
  </h2>
  <ul style="display: block">
    <li><a href="./user_showUser.do"
           target="right"><span class="icon-caret-right"></span>操作员管理</a></li>
    <li><a href="adduser.jsp" target="right"><span
        class="icon-caret-right"></span>添加操作员</a></li>
    <li><a href="./user_upUser.do" target="right"><span
        class="icon-caret-right"></span>修改密码</a></li>
  </ul>
  <h2>
    <span class="icon-pencil-square-o"></span>学生管理
  </h2>
  <ul>
    <li><a href="./student_showallStudent.do" target="right"><span
        class="icon-caret-right"></span>学生列表</a></li>
    <li><a href="addstudent.jsp" target="right"><span
        class="icon-caret-right"></span>添加学生</a></li>
    <li><a href="selectshowstudent.jsp" target="right"><span
        class="icon-caret-right"></span>查找学生</a></li>
  </ul>
</div>

<ul class="bread">
  <li><a href="info.html" target="right" class="icon-home"> 首页</a>
  </li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
</ul>

<div class="admin">

</div>

</body>
</html>
