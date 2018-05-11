<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <title>注册用户</title>
  <link rel="stylesheet" href="../../css/admin.css">
  <link rel="stylesheet" href="../../css/pintuer.css">

  <script src="../../js/jquery.js"></script>
  <script src="../../js/pintuer.js"></script>
  <script>
      function validate() {
          var pwd1 = document.getElementById("pwd1").value;
          var pwd2 = document.getElementById("pwd2").value;

          <!-- 对比两次输入的密码 -->
          if(pwd1 == "" || pwd2 == ""){
              document.getElementById("tishi").innerHTML="";
          }
          else if(pwd1 == pwd2) {
              document.getElementById("tishi").innerHTML="";
              document.getElementById("submit").disabled = false;
          }
          else {
              document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
              document.getElementById("submit").disabled = true;
          }
      }
  </script>
</head>

<body>
<div class="bg"></div>
<div class="container">
  <div class="line bouncein">
    <div class="xs6 xm4 xs3-move xm4-move">
      <div style="height: 60px;"></div>
      <div class="media media-y margin-big-bottom"></div>

      <form:form action="/adduser.do" method="post" modelAttribute="user">
        <div class="panel loginbox">
          <div class="text-center margin-big padding-big-top">
            <h1>注册用户</h1>
          </div>
          <div class="panel-body"
               style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">

            <div class="form-group">
              <div class="field field-icon-right">
                <form:input path="username" class="input input-big" id="username" placeholder="账号"
                            onchange="function vaild() { document.getElementById('tishi').innerHTML='';}"
                            data-validate="required:请填写账号"/>
                <span class="icon icon-user margin-small"></span>
              </div>
            </div>

            <div class="form-group">
              <div class="field field-icon-right">
                <form:password path="password" class="input input-big" id="pwd1"
                               placeholder="密码" onkeyup="validate()" data-validate="required:请填写密码"/>
                <span class="icon icon-key margin-small"></span>
              </div>
            </div>

            <div class="form-group">
              <div class="field field-icon-right">
                <form:password path="passwordvalid" class="input input-big" id="pwd2"
                               placeholder="确认密码" onkeyup="validate()" data-validate="required:请确认密码"/>
                <span class="icon icon-key margin-small"></span>
              </div>
            </div>

          </div>
          <div class="input-help  padding-small " style="text-align: center">
            <span id="tishi" style="text-align: center;color: red">${error}</span> <br>
          </div>

          <div style="padding: 20px;">
            <input type="submit" class="button button-block bg-main text-big input-big"
                   value="提交">
          </div>

          <div style="padding: 20px;text-align: center">
            <a href="/login" class="button button-block bg-main text-big input-big">返回</a>
          </div>
        </div>
      </form:form>
    </div>
  </div>
</div>

</body>
</html>
