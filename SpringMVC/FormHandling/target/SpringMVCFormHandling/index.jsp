<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Spring Landing Page</title>
</head>
<body>
<h2>Spring Landing Page</h2>
<p>点击下面的按钮获得一个简单的HTML页面</p>
<form:form method="GET" action="/resources/staticPage">
<%  //<p>点击下面的按钮将结果重定向到新页面</p>
    //<form:form method="GET" action="/redirect">%>
  <table>
    <tr>
      <td>
        <input type="submit" value="开始"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>