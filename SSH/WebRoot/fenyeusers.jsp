<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form>
			<table border="1">
				<s:iterator value="pageBean.list">
					<tr>
						<td><s:property value="id" />
						</td>
						<td><s:property value="username" />
						</td>
						<td><s:property value="password" />
						</td>
						<td><s:property value="email" />
						</td>
						<td><img width="160" height="90" src="<%= basePath %>/upload/<s:property value="photo"/>"/>
						</td>
					</tr>
				</s:iterator>
			</table>
			共
			<s:property value="pageBean.allRow" />
			条记录 共
			<s:property value="pageBean.totalPage" />
			页 当前第
			<s:property value="pageBean.currentPage" />
			页<br />
			<s:if test="%{pageBean.currentPage == 1}">
      第一页 上一页
      </s:if>
			<s:else>
				<a href="list.action?page=1">第一页</a>
				<a
					href="list.action?page=<s:property value="%{pageBean.currentPage-1}"/> ">上一页</a>
			</s:else>
			<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a
					href="list.action?page=<s:property value="%{pageBean.currentPage+1}"/> ">下一页</a>
				<a href="list.action?page=<s:property value="pageBean.totalPage"/> ">最后一页</a>
			</s:if>
			<s:else>
   下一页  最后一页
   </s:else>

		</form>
	</div>
</body>
</html>