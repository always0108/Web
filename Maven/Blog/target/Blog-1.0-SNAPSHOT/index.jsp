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
  <title>上古微博</title>
  <style type="text/css">
  </style>
</head>

<body background="smallbackgroud.jpg" style="background-size: cover;background-repeat: no-repeat;background-attachment: fixed">
  <h1 style="color: white;text-align: center;margin-top: 10%;font-size: 4rem">上古微博</h1>
  <form method="post" action="login.do">
      <div style="color: red;text-align: center">${requestScope.error}</div>
      <div style="margin: auto">
        <table align="center" style="text-align: left;height: 30%">
        <tr>
          <td style="color: white;font-size: 1.5rem">用户名：</td>          <td><input type="text" name="username" value="${param.username}"></td>
        </tr>
        <tr>
          <td style="color: white;font-size: 1.5rem">密码：</td>
          <td><input type="password" name="password"></td>
        </tr>

        <tr></tr>

        <tr>
          <td></td>
          <td ><input type="submit" value="登录" name="login" style="width: 45%;height: 50%"></td>
          <td><a href="register.jsp" style="width: 45%;height: 50%">注册</a></td>
        </tr>

        </table>
      </div>
  </form>

</body>
</html>
