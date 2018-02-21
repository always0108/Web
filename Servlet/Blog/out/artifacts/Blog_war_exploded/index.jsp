<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-2-20
  Time: 上午11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta content='text/html;charset=UTF-8' http-equiv='content-type'>
  <title>Blog-test</title>
  <style type="text/css">
    span{
      float: left;
      width:80px;
      height: 25px;
    }
  </style>
</head>

<body>
<h1>欢迎来到上古微博</h1>
<form method="post" action="login.do">
  <div>
    <span>用户名：</span><input type="text" name="username" size="25" maxlength="16"> <br>
    <span>密码&emsp;：</span> <input type="password" name="password" size="25" maxlength="16">  <br> <br>
    &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="submit" value="登录" name="login">
    &emsp;&emsp;&emsp;&emsp; <a href="register.jsp">注册</a>  <br>
    <br>
  </div>
</form>
</body>
</html>
