<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta content='text/html;charset=UTF-8' http-equiv='content-type'>
    <title>${requestScope.username}的主页</title>
</head>

<body>
    <c:choose>
        <c:when test="${requestScope.blahs != null}">
            <h1>${requestScope.username}的动态</h1>
            <hr>
            <c:forEach var="blah" items="${requestScope.blahs}">
            <tr>
                <td style='vertical-align: top;'>
                    <span style='color:goldenrod'>${blah.username}</span> <br>
                    <c:out value="${blah.txt}" /><br>
                    <c:out value="${blah.date}" /> <br>
                </td>
            </tr>
            <hr>
            </c:forEach>
        </c:when>

        <c:otherwise>
            <h1 style="color: red">用户${requestScope.username}不存在</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
