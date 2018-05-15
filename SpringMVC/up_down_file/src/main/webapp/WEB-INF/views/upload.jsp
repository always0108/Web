<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>文件上传</title>
</head>
<body>

<h2>文件上传</h2>
<form:form method="POST" action="/upload" modelAttribute="user" enctype="multipart/form-data">

  <table>
    <tr>
      <td><form:label path="username" >Username</form:label></td>
      <td><form:input path="username"/></td>
    </tr>
    <tr>
      <td><label>Profile</label></td>
      <td><input type="file" name="image" accept="image/jpeg,image/png,image/gif"></td>
    </tr>

    <tr>
      <td colspan="2">
        <input type="submit" value="upload"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
