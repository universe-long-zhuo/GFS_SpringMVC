<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'myindex.jsp' starting page</title>

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
  
  <br>
  	<form action="testFileUpload"
  		method="post" enctype="multipart/form-data">
  		文件：<input type="file" name="file"/>
  		desc:<input type="text" name="desc"/>
  		<input type="submit" value="提交"/>
  	</form><br><br>
  
  <br>
  	<form action="testHttpMessageConverter"
  		method="post" enctype="multipart/form-data">
  		文件：<input type="file" name="file"/>
  		desc:<input type="text" name="desc"/>
  		<input type="submit" value="提交"/>
  	</form><br><br>
  	<a href="testResponseEntity">Test ResponseEntity(下载)</a>
  	
  <br>
    This is my JSP page. <br>
  </body>
</html>
