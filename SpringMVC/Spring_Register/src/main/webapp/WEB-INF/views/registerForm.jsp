<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-5-7
  Time: 下午8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="XiyouLinux.data.Spitter" scope="request"></jsp:useBean>
<html>
<head>
  <title>Register</title>
  <style type="text/css">
    span.error {
      color: red;
    }

    label.error {
      color: red;
    }

    input.error {
      background-color: #ffcccc;
    }

    div.errors {
      background-color: #ffcccc;
      border: 1px;
    }
  </style>
</head>
<body>

<h2>Register</h2>
<form:form method="POST" action="/register">
  <form:errors path="firstname"  element="div" cssClass="errors" />
  <form:errors path="lastname"   element="div" cssClass="errors" />
  <form:errors path="username"   element="div" cssClass="errors" />
  <form:errors path="password"   element="div" cssClass="errors" />

  <table>
    <tr>
      <td><form:label path="firstname" cssErrorClass="error">First name</form:label></td>
      <td><form:input path="firstname" cssErrorClass="error"/></td>
    </tr>
    <tr>
      <td><form:label path="lastname" cssErrorClass="error">Last name</form:label></td>
      <td><form:input path="lastname" cssErrorClass="error"/></td>
    </tr>
    <tr>
      <td><form:label path="username" cssErrorClass="error">Username</form:label></td>
      <td><form:input path="username" cssErrorClass="error"/></td>
    </tr>
    <tr>
      <td><form:label path="password" cssErrorClass="error">Password</form:label></td>
      <td><form:password path="password"  cssErrorClass="error"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="register"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
