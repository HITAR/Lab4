<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<h1 align="center">Welcome to GuoGuo</h1>
	<center>
		<br /> <br /> <br />
		<s:form action="aa">
			<s:textfield name="name" label="输入作者姓名"
				align="center" />
			<s:submit value="Search" />
		</s:form>

		<br /> <br />
		<s:form action="bb">
			<s:textfield name="name" label="查询作者"
				align="center" />
			<s:submit value="Search" />
		</s:form>
	</center>
</body>
</html>
