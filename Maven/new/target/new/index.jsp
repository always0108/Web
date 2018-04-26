<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>报名系统</title>
  <meta content='text/html;charset=UTF-8' http-equiv='content-type'>
  <meta name="viewport" content="user-scalable=no,width=device-width,height=device-height,initial-scale=1.0">
  <style type="text/css">
    td{
      font-size: larger;
      font-weight: bolder;
      color: orange;
    }
    input{
      opacity: 0.75;
    }
  </style>
</head>
<body style="background: url('background.jpg');background-size: 100% 100%">
    <form method="post" action="join.do">
      <div style="height: 60%;width: 90%;margin: 5%;">
        <p align="center" style="margin-top: 35%;color: royalblue;font-size: 3rem;font-weight: bolder">踏&ensp;青&ensp;活&ensp;动</p>
        <table align="center" style="text-align: left;height: 5%">
          <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"></td>
          </tr>

          <tr>
            <td>家乡：</td>
            <td><input type="text" name="home"></td>
          </tr>

          <tr>
            <td>专业：</td>
            <td><input type="text" name="type"></td>
          </tr>

          <tr>
            <td></td>
            <td style="font-size: medium">(如：软件工程1701)</td>
          </tr>

          <tr>
            <td>手机：</td>
            <td><input type="text" name="phone"></td>
          </tr>

          <tr>
            <td>&emsp;</td>
          </tr>

          <tr>
            <td></td>
            <td style="text-align: center"><input type="submit" value="报名" name="login" style="width: 35%"></td>
          </tr>
        </table>
      </div>
    </form>
</body>
</html>
