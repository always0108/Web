<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content='text/html;charset=UTF-8' http-equiv='content-type'>
    <title>上古微博</title>
</head>

<body>
    <c:forEach var = "book" items = "Java,C++,C,Linux">
        ${book} <br>
    </c:forEach>
</body>
</html>
