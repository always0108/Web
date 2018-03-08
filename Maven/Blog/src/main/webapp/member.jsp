<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta content='text/html;charset=UTF-8' http-equiv='content-type'>
    <title>会员主页</title>
</head>

<body>
    <h1>会员 ${sessionScope.login}，欢迎登录！ </h1>
    <a href='logout.do?username=${sessionScope.login}'>注销${sessionScope.login} </a> <br> <br>

    <div>
        <form method='post' action='message.do'>
            分享新鲜事...<br>

            <c:if test="${requestScope.blala != null}">
                <span style='color: red'>信息要在140字内</span><br>
            </c:if>

            <textarea cols='60' rows='4' name='blabla'>${requestScope.blabla}</textarea>
            <br> <input type='submit' value='发送' name='send'> <br> <br>
        </form>
    </div>

    <div>
        <form method='post' action='user.do'>
            查看其他用户的主页：<input type="text" name="user" maxlength="20">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type='submit' value='查询' name='send'> <br> <br>
        </form>
    </div>

    <h3>动态</h3>
    <hr>
    <c:forEach var="blah" items="${requestScope.blahs}">
        <tr>
            <td style='vertical-align: top;'>
            <span style='color:goldenrod'>${blah.username}</span> <br>
                <c:out value="${blah.txt}" /><br>
            <fmt:formatDate value="${blah.date}" type="both" dateStyle="full" timeStyle="full" />
            <a href='delete.do?message=${blah.date.time}'>删除</a>
            </td>
        </tr>
        <hr>
    </c:forEach>
</body>
</html>