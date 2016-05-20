<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form>
			<h1>users</h1>
			<table>
				<tr align="center">
					<td>id</td>
					<td>username</td>
					<td>password</td>
					<td>email</td>
				</tr>
				<s:iterator value="#request.userslist">
					<tr>
						<td><s:property value="id" />
						</td>
						<td><s:property value="username" />
						</td>
						<td><s:property value="password" />
						</td>
						<td><s:property value="email" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</form>

		
	</div>
</body>
</html>