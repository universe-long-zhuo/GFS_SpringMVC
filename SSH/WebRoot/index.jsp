<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>

  <body>
  <h1 align="center">登录页面</h1><div align="center"> 
  <form action="login!login" method="post"> 
  <br><div align="center">用户名：<input type="text" name="username"> 
  <br>密 码：<input type="password" name="password"> 
  
  <input type="image" height="100" width="100" src="/upload/">
  <img height="100" width="100" src="./upload/1379307009868.jpg">
  
  <br></div><input type="submit" value=" 登 录 ">&nbsp;&nbsp;&nbsp;&nbsp;
     没有帐号？现在<a href="register.jsp">注册</a> 
     <br> <s:a href="allUsers!allUsers">显示所有用户</s:a>
     <s:a href="list.action?page=1">分页显示所有用户</s:a>
  </form></div>   
 	<br><br><br><br><br>
 	<form action="allUsers!allUsers" method="post"><input type="submit" value=" 查询所有用户 "></form>
  
  <form  action="upload!uploadPhoto" method="post" enctype="multipart/form-data"> 
  <br><div align="center">选择图片：
  <input type="file" name=photo >
  <br><input type="submit" value=" 上传  ">&nbsp;&nbsp;&nbsp;&nbsp;</div>
  </form>  
  
  </body>
</html>
