<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet JSP Login</title>
</head>
<body>
	<h2 align="center">Login functionality implemented using Servlet,
		JSP and MySQL</h2>
	<form action="login" method="post">
		<table align="center">
			<tr>
				<td >username :</td>
				<td ><input type="text" name="usernameTB"></td>
			</tr>
			<tr>
				<td >password :</td>
				<td ><input type="password" name="passwordTB"><br></td>
			</tr>
			<tr>
				<td ><input type="submit" value="login"></td>
				<td style="color: red">
					<%
						String errorMessage = (String) request.getAttribute("errMsg");
						if (errorMessage != null) {
					%> <%=errorMessage%> <%
 	}
 %>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>