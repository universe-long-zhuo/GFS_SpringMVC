<%@page import="com.gfs.hibernate.pojo.TrySpringmvc"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'typelist01.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="scripts/jquery-1.9.1.js"></script>
	<script type="text/javascript">
		$(function() {
		alert("hello");
			$(".delete").click(function() {
				var href = $(this).attr("href");
				$("form").attr("action",href).submit();
			});
		})
	</script>
	
  </head>
  
  <body><!-- 
  ${requestScope.time}<br>
  ${requestScope.name}
  <br>
  ${requestScope.TYPElist}<br>
   -->
   
   <!-- _method是必须的  -->
   <form action="" method="POST">
   		<input type="hidden" name="_method" value="DELETE"> 
   </form>
   
   <c:if test="${empty requestScope.TYPElist }">没有风格信息</c:if>
   <c:if test="${!empty requestScope.TYPElist }">
   		<c:forEach items="${requestScope.TYPElist}" var="list">
   			<c:if test="${!empty list.file }">
   				${list.name } &nbsp;&nbsp;&nbsp;&nbsp;    <a href="download?url=${list.file }">下载</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="update?mid=${list.id }">修改</a>   &nbsp;&nbsp;&nbsp;&nbsp;<!-- <a class="delete" href="delTry/${list.id }">移除</a> --><a href="delTry/${list.id }">移除</a> <br>
   			</c:if>
   			<c:if test="${empty list.file }">
   				${list.name } &nbsp;&nbsp;&nbsp;&nbsp;    没有资源 &nbsp;&nbsp;&nbsp;&nbsp;<a href="update?mid=${list.id }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;            <!-- <a class="delete" href="delTry/${list.id }">移除</a>--><a href="delTry/${list.id }">移除</a><br>
   			</c:if>
   		</c:forEach>
   		
   </c:if>
  <a href="zuanzai">add</a>
    This is my JSP page. <br>
  </body>
</html>
