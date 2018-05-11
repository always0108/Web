<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	<title>登录</title>
	<link rel="stylesheet" href="../../css/admin.css">
	<link rel="stylesheet" href="../../css/pintuer.css">

	<script src="../../js/jquery.js"></script>
	<script src="../../js/pintuer.js"></script>
</head>

<body>
<div class="bg"></div>
<div class="container">
	<div class="line bouncein">
		<div class="xs6 xm4 xs3-move xm4-move">
			<div style="height: 60px;"></div>
			<div class="media media-y margin-big-bottom"></div>

				<form:form action="/login.do" method="post" modelAttribute="user">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>学生信息管理系统</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">

              <div class="form-group">
								<div class="field field-icon-right">
									<form:input path="username" class="input input-big"
															placeholder="登录账号" data-validate="required:请填写账号"/>
									<span class="icon icon-user margin-small"></span>
								</div>
							</div>

							<div class="form-group">
								<div class="field field-icon-right">
									<form:password path="password" class="input input-big"
																 placeholder="登录密码" data-validate="required:请填写密码"/>
									<span class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="input-help  padding-small" style="text-align: center">
								<span id="tishi" style="text-align: center;color: red">${error}</span> <br>
							</div>
							<div class="form-group">
								<div class="field" align="right">
									<a href="/adduser">注册</a>
									&ensp;&ensp;
									<a href="/adduser">忘记密码</a>
								</div>
							</div>
						</div>
						<div style="padding: 30px;">
							<input type="submit" class="button button-block bg-main text-big input-big"
										 value="登录">
						</div>
					</div>
				</form:form>

			</div>
		</div>
	</div>

</body>
</html>