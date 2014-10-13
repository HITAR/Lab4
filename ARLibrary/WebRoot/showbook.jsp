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

<title>My JSP 'show.jsp' starting page</title>

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
	<br/><br/><br/>
	<h2 align="center">Books</h2>
	<center>
	<br/><br/>
	<table border="1">
	<s:iterator value="lista" var="c">
		<tr>
		<td><a href="detail?title=<s:property value="#c.title"/>"> <s:property
				value="#c.title" /></a> </td>
		</tr>
	</s:iterator>
	</table>
	</center>
</body>



</html>

