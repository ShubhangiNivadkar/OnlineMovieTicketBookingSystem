<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.movie.pojo.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<th>Booking Id </th>
<th>Movie Name </th>
<th>Date of show </th>
<th>Timing of show </th>
<th>Action </th>
</tr>

<%
List<Booking> bookingList=(List<Booking>)session.getAttribute("bookingList");

for(Booking b:bookingList){
%>
<tr>
<th><%= b.getBookingId() %></th><th><%= b.getS().getShowMovie().getMovieName() %></th>
<th><%= b.getS().getShowMovieDate() %></th><th><%= b.getS().getStartTime() %>To <%= b.getS().getEndTime() %></th>
<th><a class="btn btn-warning" href="BookingServlet?process=cancelBooking&bookingId=<%= b.getBookingId() %>">Cancel</a></th>
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