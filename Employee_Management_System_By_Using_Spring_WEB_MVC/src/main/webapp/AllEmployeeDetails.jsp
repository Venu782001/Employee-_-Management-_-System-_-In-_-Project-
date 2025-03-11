<%@page import="com.employee.entity.EmployeeDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th,td,tr,table {
	border-collapse: collapse;
	border: 1px solid black; 
}
</style>
</head>
<body>
<center>
<form>
<h1>All Employee Details</h1>
<%
List<EmployeeDetails> list = (List<EmployeeDetails>) request.getAttribute("listOfAllEmployeeDetails");
%>
<%= list %>

<table>
	<tr><th>Name</th><th>Emailid</th><th>Salary</th><th>DeptNo</th></tr>
	<% for(EmployeeDetails details : list){ %>
	<tr><td><%=details.getName() %></td><td><%=details.getEmailid() %></td><td><%=details.getSalary() %></td><td><%= details.getDeptno()%></td>
	<td>
	<form action=detailsbyid>
	<input value=<%=details.getId() %> hidden="true" name="id">
	<input type="submit" value="Delete">
	</form></td>
	<td>
	<form action=update>
	<input value=<%=details.getId() %> hidden="true" name="id">
	<input type="submit" value="update">
	</form></td>
	
	</tr><%} %>
	
</table>
</form>
</center>
</body>
</html>