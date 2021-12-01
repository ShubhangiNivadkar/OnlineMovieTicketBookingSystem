<%@page import="java.time.format.FormatStyle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, com.movie.pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Customer> clist=(List<Customer>)session.getAttribute("clist");
%>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Messages.jsp"></jsp:include>
<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container">
	<div>
	
	
	<table class="table">
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Contact</th>
	<th>Email</th>
	<th>Address</th>
	<th>Password</th>
	<th colspan="4" style="text-align: center">Action</th>
	</tr>
	
	<%for(Customer c:clist){ %>
	<tr>
	<td><%= c.getFirstName() %></td>
	<td><%= c.getLastName() %></td>
	<td><%= c.getContact() %></td>
	<td><%= c.getEmail() %></td>
	<td><%= c.getPassword() %></td>
	
	<td><%= c.getAddress() %></td>
	
	<td><a class="btn btn-danger" onclick="return confirm('Are you sure you want to delete')" href="CustomerServlet?process=deleteCustomer&customerId=<%= c.getCustomerId() %>">Delete</a></td>
	</tr>
	<%} %>
	</table>
	</div>
</div>
</div>
</div>
</section>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>