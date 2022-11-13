<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
</head>

<body>
	<center>
		<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
		
		<table width="50%">
			<tr>
				<th colspan="5"><h1><u><i>Data</i></u></h1></th>
			</tr>
			<tr>
				<th colspan="5" height="20px"></th>
			</tr>
			<tr>
				<th style="text-align: left;">No</th>
				<th style="text-align: left;">First Name</th>
				<th style="text-align: left;">Last Name</th>
				<th style="text-align: left;">Delete</th>
				<th style="text-align: left;">Edit</th>
			</tr>
			<tr>
				<th colspan="5" height="20px"></th>
			</tr>
			<c:forEach items="${registerList }" var="i" varStatus="j">
				<tr>
					<td>${j.count }</td>
					<td>${i.firstName }</td>
					<td>${i.lastName }</td>
					<td><a href="delete?id=${i.id }">Delete</a></td>
					<td><a href="edit?id=${i.id }">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>