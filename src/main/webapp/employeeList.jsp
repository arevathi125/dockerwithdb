<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List Page</title>
</head>
<body>
<table border="1">
<%List<Employee> emp = (List<Employee>)request.getAttribute("list"); %>
 <tr><th>Employee Number</th> 
<th>Employee Name</th>
<th>Employee Phone Number</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%for(Employee list:emp){ %>

 <tr><td><%= list.getEmp_No() %></td> 
<td><%= list.getEmp_Name() %></td>
<td><%= list.getEmp_Phone() %></td>
<%-- <td><form action="edit">
<input type="hidden" name="id" value="<%= list.getEmp_No() %>">
<button type="submit">Edit</button>
</form> --%>
 <td><a href = "edit.jsp?id=<%= list.getEmp_No() %>">Edit</a></td> 
<td><a href = "delete?id=<%= list.getEmp_No() %>">Delete</a></td>
</tr>
<%} %>
</table>
</body>
</html>