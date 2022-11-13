<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<style type="text/css">
.btn {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

.input {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
</style>
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<body>

	<center>
		<f:form action="insert" method="post" modelAttribute="RegisterVo">
			<table>
				<tbody>
					<tr>
						<td>
							<h1 style="text-align: center;">
								<u><i>REGISTER</i></u>
							</h1>
						</td>
					</tr>
					<tr>
						<td><f:input path="firstName" class="input"
								placeholder="First Name" /></td>
					</tr>

					<tr>
						<td><f:input path="lastName" class="input"
								placeholder="Last Name" /> <f:hidden path="id" /></td>
					</tr>
					<tr style="height: 20px;">
						<td></td>
					</tr>

					<tr>
						<td><input type="submit" class="btn" value="Submit"></td>
					</tr>
				</tbody>
			</table>
			<br>
			<a href="search">SEARCH</a>
		</f:form>
	</center>
</body>

</html>



