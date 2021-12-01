<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<%
	String admin = (String) session.getAttribute("admin");
	String customer = (String) session.getAttribute("customer");
	%>
	<!-- main Content if any -->
	<section class="py-5">
		<div class="container bg-white">
			<div class="moviecontainer">
				<div class="container">
					<div>
						<jsp:include page="Messages.jsp"></jsp:include>
					</div>
					<table class="table">
						<tr>
							<th>Movie</th>
							<th>Theatre</th>
							<th>Date</th>
							<th>Timing</th>
							<th>Type</th>
							<th>Price</th>
							<th>Screen</th>
							<th colspan="2" style="text-align: center;">Action</th>
						</tr>
						<c:forEach var="s" items="${slist }">
							<tr>
								<td>${s.showMovie.movieName}</td>
								<td>${s.theatreName_Loc }</td>
								<td><fmt:parseDate var="d" value="${s.showMovieDate } "
										pattern="yyyy-MM-dd"></fmt:parseDate> <fmt:formatDate
										value="${d }" type="date" dateStyle="medium" /></td>

								<td>From: <fmt:parseDate var="st" value="${s.startTime }"
										pattern="HH:mm"></fmt:parseDate> <fmt:formatDate
										value="${st }" type="time" timeStyle="medium" /> To: <fmt:parseDate
										var="st" value="${s.endTime }" pattern="HH:mm"></fmt:parseDate>
									<fmt:formatDate value="${st }" type="time" timeStyle="medium" />
								</td>
								<td>${s.showType }</td>
								<td>${s.price }</td>
								<td>${s.screen }</td>

								<%
								if (admin != null && customer == null) {
								%>
								<td><a class="btn btn-warning"
									href="ShowServlet?process=updateShow&showId=${s.showId }">Update</a></td>
								<td><a class="btn btn-danger"
									onclick="return confirm('Are you sure you want to delete')"
									href="ShowServlet?process=deleteShow&showId=${s.showId }">Delete</a></td>
								<%
								}
								%>

								<%
								if (customer != null && admin == null) {
								%>
								<td><a class="btn btn-warning"
									href="BookingServlet?process=selectSeats&showId=${s.showId }">Book</a></td>
								<%
								}
								%>
							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>