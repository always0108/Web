<%@ page import="model.Blah" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-2-28
  Time: 下午9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta content='text/html;charset=UTF-8' http-equiv='content-type'>
    <title>${requestScope.username}的主页</title>
</head>

<body>
<%
    List<Blah> blahs = (List<Blah>)request.getAttribute("blahs");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
%>


<%
    if (blahs != null){
%>
    <h1>${requestScope.username}的动态</h1>
<hr>
<%
        for(Blah blah: blahs){
%>
<table>
    <tr>
        <td style='vertical-align: top;'>
            <span style='color:goldenrod'> <%=blah.getUsername()%></span> <br>
            <%=blah.getTxt()%><br>
            <%=df.format(blah.getDate())%>
            <a href='delete.do?message=<%=blah.getDate().getTime()%>'>删除</a>
        </td>
    </tr>
</table>
<hr>
<%
        }
    }else{
%>
        <h1 style="color: red">$用户{requestScope.username}不存在</h1>
<%
    }
%>
</body>
</html>
