<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-2-26
  Time: 下午8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Blah" %>>
<%
    String username = (String)request.getSession().getAttribute("login");
%>
<html>
<head>
    <meta content='text/html;charset=UTF-8' http-equiv='content-type'>
    <title>会员主页</title>
</head>

<body>
    <h1>会员 <%=username%>，欢迎登录！ </h1>
    <a href='logout.do?username=${sessionScope.login}'>注销${sessionScope.login} </a> <br> <br>
    <div>
        <form method='post' action='message.do'>
            分享新鲜事...<br>
            <%
            String blabla = request.getParameter("blabla");
            if(blabla==null){
                blabla="";
            }else{
            %>
                <span style='color: red'>信息要在140字内</span><br>
            <%
            }
            %>
            <textarea cols='60' rows='4' name='blabla'>${requestScope.blabla}</textarea>
            <br> <input type='submit' value='发送' name='send'> <br> <br>
        </form>
    </div>

    <%
        List<Blah> blahs = (List<Blah>)request.getAttribute("blahs");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
    %>
    <h3>动态</h3>
    <hr>
    <%
        for(Blah blah:blahs){
    %>
    <tr>
        <td style='vertical-align: top;'>
            <span style='color: red'>
                <%=blah.getUsername()%></span> <br>
                <%=blah.getTxt()%><br>
                <%=df.format(blah.getDate())%>
            <a href='delete.do?message="<%=blah.getDate().getTime()%>'>删除</a>
            <hr>
        </td>
    </tr>
    <%
        }
    %>
</body>
</html>