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
    
    <title>picture</title>
	
  </head>

  <body>
  <h1 align="center">图片显示页面</h1><div align="center"> 
  	<input type="image" width="160" height="90" src="<%= basePath%>/upload/1379465591390.jpg" />				

  </form>  
  </body>
</html>
