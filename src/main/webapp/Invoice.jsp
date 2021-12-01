<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.movie.pojo.*, com.movie.dao.*, java.time.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineMovieTicketBooking</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container">
	<div>
	<jsp:include page="Messages.jsp"></jsp:include>
<table class="table">

<tr>
<th>Booking Id</th><td>${bookingObj.bookingId }</td>
</tr>

<tr>
<th>Movie Name</th><td>${bookingObj.s.showMovie.movieName }</td>
</tr>

<tr>
<th>Date of Booking</th>
<%
Booking b=(Booking)session.getAttribute("bookingObj");
LocalDateTime bookingDate=b.getBookingDate();
int year=bookingDate.getYear();
Month m=bookingDate.getMonth();
int day=bookingDate.getDayOfMonth();
int hour=bookingDate.getHour();
int min=bookingDate.getMinute();

String date=day+"-"+m+"-"+year+" Time "+hour+":"+min;

%>

<td>
<%= date %>
</td>
</tr>

<tr>
<th>Date of show</th>
<td>
<fmt:parseDate var="d" value="${bookingObj.s.showMovieDate }" pattern="yyyy-MM-dd"></fmt:parseDate>
<fmt:formatDate value="${d }" type="date" dateStyle="Long"/>
</td>
</tr>

<tr>
<th>Timing of show</th><td>From: ${bookingObj.s.startTime } To: ${bookingObj.s.endTime }</td>
</tr>

<tr>
<th>Total Bill</th><td>${bookingObj.totalBill }</td>
</tr>
</table>


</div>
</div>
</div>
</div>
</section>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>