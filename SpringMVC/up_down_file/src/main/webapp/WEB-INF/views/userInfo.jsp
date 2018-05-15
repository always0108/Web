<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>文件下载</title>
</head>
<body>

<h1>文件下载</h1>
<h5>${user.username}上传的文件：</h5>
<a href="download?filename=${user.image.originalFilename}">${user.image.originalFilename}</a>
</body>
</html>