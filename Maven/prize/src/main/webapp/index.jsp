<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>抽奖</title>
  <style type="text/css">
    .but{
      width: 120px;
      height: 50px;
      font-size: 20px;
      font-weight: 600;
      color: white;
      padding:4px;
      background-color: mediumslateblue;
      border: 1px;
      border-radius: 20px;
      text-align: center;
      vertical-align: middle;
    }
  </style>
</head>

<body background="background.jpg" style="background-size: 100% 100%">
<div style="text-align: center;margin-top: 7%">
  <img src="logo.png" width="25%">
</div>

<div style="text-align: center;margin-top: 3%">
  <form action="/check.jsp" method="post">
    <input class="but" type="submit" value="开始抽奖">
  </form>
</div>

</body>
</html>


