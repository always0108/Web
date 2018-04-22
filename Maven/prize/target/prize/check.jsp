<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-4-17
  Time: 下午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page import="Util.DBConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  int total = 0;
  String finalnum = "00000000";
  String finalname = "";

  DBConnection dbConnection = DBConnection.getInstance();
  dbConnection.startConnect();
  Connection conn = dbConnection.getConn();


  PreparedStatement pstmt = null;
  try {
    String SQL = "select count(*) totalCount from prizelist";
    pstmt = conn.prepareStatement(SQL);
    ResultSet result = pstmt.executeQuery();
    if(result.next()){
      total = result.getInt("totalCount");
    }
    if(total > 0){
      int seed = (int)(Math.random()*total);

      SQL = "select * from prizelist";
      pstmt = conn.prepareStatement(SQL);
      result = pstmt.executeQuery();
      for(int i=0;i<=seed;i++){
        result.next();
        finalnum = result.getString("num");
        finalname = result.getString("name");
      }
      dbConnection.SQLexecte("DELETE from prizelist where num = " + finalnum);
    }else {
        finalnum = "00000000";
    }
  }
  catch (SQLException e) {
    e.printStackTrace();
  }
  finally {
    pstmt.close();
    dbConnection.stopConnect();
  }
%>
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
<div style="text-align: center;margin-top: 3%" >
  <form>
    <input id="note" type="text" style= "background:transparent;border-style:none;text-align: center;font-size: 2em"> <br> <br>
    <input id="but" class="but" type="submit" value="继续抽奖">
    <input id="result" type="hidden" value=<%=finalnum%>>
    <input id="name" type="hidden" value=<%=finalname%>>
  </form>
  <img src="logo.png" width="15%" style="float: right">
</div>

<script type="text/javascript" src="roll.js"></script>

<script type="text/javascript">
  setTimeout("f()",12000);
  function f() {
      var name = document.getElementById("name").value;
      document.getElementById("note").setAttribute("value",name);
  }

</script>

</body>
</html>
