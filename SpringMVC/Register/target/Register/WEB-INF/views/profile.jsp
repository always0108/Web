<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
