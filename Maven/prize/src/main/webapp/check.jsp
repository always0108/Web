<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-4-17
  Time: 下午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  int total = 0;
  String finalnum = "";
  String url = "jdbc:mysql://localhost:3306/JWGL?useUnicode=true&characterEncoding=utf-8&useSSL=false";
  String user = "root";
  String password = "LM19980108!@";
  try {
    Class.forName("com.mysql.jdbc.Driver");
  } catch (ClassNotFoundException e) {
    throw new RuntimeException("找不到指定的类");
  }
  Connection conn = DriverManager.getConnection(url, user, password);
  PreparedStatement pstmt = null;
  try {
    String SQL = "select count(*) totalCount from number";
    pstmt = conn.prepareStatement(SQL);
    ResultSet result = pstmt.executeQuery();
    if(result.next()){
      total = result.getInt("totalCount");
    }
    int seed = (int)(Math.random()*total);

    SQL = "select * from number";
    pstmt = conn.prepareStatement(SQL);
    result = pstmt.executeQuery();
    for(int i=0;i<=seed;i++){
        result.next();
        finalnum = result.getString("num");
    }
  }
  catch (SQLException e) {
    e.printStackTrace();
  }
  finally {
    pstmt.close();
  }
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>抽奖</title>
  <link rel="stylesheet" type="text/css" href="css/reset.css" rel="external nofollow" />
</head>

<body>
<div id="onclick" style="text-align: center;margin-top: 10%">
  <img src="img/0.png"/>
  <img src="img/0.png"/>
  <img src="img/0.png"/>
  <img src="img/0.png"/>
  <img src="img/0.png"/>
  <img src="img/0.png"/>
  <img src="img/0.png"/>
  <img src="img/0.png"/>
</div>
<div style="text-align: center">
  <form>
    <a href="check.jsp">抽奖</a>
    <input id="result" type="hidden" value=<%=finalnum%>>
  </form>

</div>

<script type="text/javascript" src="roll.js" ></script>

</body>
</html>
