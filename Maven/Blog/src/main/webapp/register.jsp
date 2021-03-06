<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <style type="text/css">
        span{
            float: left;
            width:160px;
            height: 25px;
        }
    </style>

<body>
    <c:if test="${requestScope.errors != null}">
        <h1>新增会员失败</h1> <br>
        <ul style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <li>${error}</li>
            </c:forEach>
        </ul> <br>
    </c:if>

    <h1>会员注册</h1> <br>
    <form method="post" action="register.do">
        <div>
            <span>邮件地址：</span> <input type="text" name="email" size="25" maxlength="100">  <br>
            <span>名称(最大16字符)：</span> <input type="text" name="username" size="25" maxlength="16"> <br>
            <span>密码(6到16字符)：</span> <input type="password" name="password" size="25" maxlength="16"> <br>
            <span>确认密码：</span> <input type="password" name="confirmedPasswd" size="25" maxlength="16">  <br>  <br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="submit" value="注册" name="register">
        &emsp;&emsp;&emsp;&emsp; <a href="index.jsp">返回</a>  <br>
        </div>
    </form>
</body>
</html>
