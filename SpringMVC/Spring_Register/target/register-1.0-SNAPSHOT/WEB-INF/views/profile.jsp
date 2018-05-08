<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-5-7
  Time: 下午9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Your Profile</title>
</head>
<body>
  <h1>Your profile</h1>
  Username: <c:out value="${spitter.username}" /> <br/>
  Firstname:<c:out value="${spitter.firstname}" /> <br/>
  Lastname:<c:out value="${spitter.lastname}" /> <br/>
</body>
</html>
