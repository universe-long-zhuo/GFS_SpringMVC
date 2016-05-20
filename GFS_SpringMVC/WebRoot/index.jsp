<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  
  <a href = "text/text01">try01</a><br>
  
  <a href = "text/text02?uname=gfs&age=10">try02-1</a><br>
  
  <a href = "text/text02?uname=gfs&age=11">try02-2</a><br>
  
  <a href = "text/text03?uname=gfs&password=123456&age=11">try03</a><br>
  
  <a href = "text/text04/gfs225">try04</a><br>
  
  <form action="text/text05" method="post">
  	<input type="text" name="name">
  	<input type="submit" value="text05">
  </form><br>
  
  <a href = "text/text06">try06</a><br>
  
  <a href = "text/text07">try07</a><br>
  
  <form action="text/text08" method="post">
  	<input type="text" name="name">
  	<input type="submit" value="text08">
  </form><br>
  
    This is my JSP page. <br>
    <br/><a href="text/text09">上传文件</a>
  </body>
</html>
