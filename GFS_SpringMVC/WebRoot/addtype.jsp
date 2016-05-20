<%@page import="com.gfs.hibernate.pojo.TrySpringmvc"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addtype.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!-- 重点看SpringMVC 30以后的 -->
  <body><br>
  
  	
  		<c:if test="${type.id == null }">
  			<form:form action="addtype" method="POST" modelAttribute="type" enctype="multipart/form-data">
  			name：<form:input path="name" readonly="true" value="${requestScope.myname }"/><br>
  			file:<form:input path="file" readonly="true" value="${requestScope.myfile }"/><br>
  			<input type="submit" value="提交">
  			</form:form>
  		</c:if>
  		<c:if test="${type.id != null }">
  			<form:form action="uptype" method="POST" modelAttribute="type" enctype="multipart/form-data">
  			id：<form:input path="id" readonly="true" value="${type.id }"/><br>
  			name：<form:input path="name" value="${type.name }"/><br>
  			file:<form:input path="file" readonly="true" value="${type.file }"/><br>
	  		<input type="submit" value="提交">
  			</form:form>
  		</c:if>
  		
  	
  </body>
</html>
