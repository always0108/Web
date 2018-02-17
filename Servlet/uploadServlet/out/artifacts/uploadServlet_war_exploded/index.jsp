<%--
  Created by IntelliJ IDEA.
  User: limeng
  Date: 18-2-16
  Time: 下午9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Upload</title>
  <meta http-equiv="Content-Type"
        content="text/html;charset=UTF-8">
</head>
<body>
  <form action="upload.do" method="post" enctype="multipart/form-data">
    上传照片：<input type="file" name="photo" /> <br> <br>
    <input type="submit" value="上传" name="upload" />
  </form>
</body>
</html>
