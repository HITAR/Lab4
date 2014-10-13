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

<title>My JSP 'showdetail.jsp' starting page</title>

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
	<br/><br/><br/><br/>
	<h1 align="center">详细信息</h1>
	<table border="1" align="center">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>AuthorID</th>
			<th>Publisher</th>
			<th>PublishDate</th>
			<th>Price</th>
			<th>Name</th>
			<th>Age</th>
			<th>Country</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
	
	<s:iterator value="lista" var="c">

		<tr>
			<td><s:property value="#c.isbn" /></td>
		
			<td><s:property value="#c.title" /></td>
		
			<td><s:property value="#c.authorID" /></td>
		
			<td><s:property value="#c.publisher" /></td>
		
			<td><s:property value="#c.publishdate" /></td>
		
			<td><s:property value="#c.price" /></td>
		
			<td><s:property value="#c.name" /></td>
		
			<td><s:property value="#c.age" /></td>
		
			<td><s:property value="#c.country" /></td>
		
			<td><a href="deleteone?authorID=<s:property value="#c.authorID"/>">delete</a></td>
		
			<td><a href="updateone?">update</a></td>
		</tr>
		
	</s:iterator>
	
	</table>

</body>
</html>
