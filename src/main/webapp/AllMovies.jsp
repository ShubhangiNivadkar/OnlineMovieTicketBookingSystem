<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.movie.pojo.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String admin = (String) session.getAttribute("admin");
	String customer = (String) session.getAttribute("customer");
	%>
	<%
	List<Movie> mlist = (List<Movie>) session.getAttribute("mlist");
	%>
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- main Content if any -->
	<!-- 	<input type="hidden" name="process" value="allMovies"> -->
	<section class="py-5">
		<div class="container bg-white">
			<div class="moviecontainer">
				<div class="container">
					<div>
						<jsp:include page="Messages.jsp"></jsp:include>
						<%
						if (admin == null && customer == null) {
						%>
						<h3 style="color: maroon;">Please login to see available
							shows</h3>
						<%
						}
						%>
						<table class="table">
							<tr>
								<th>Movie name</th>
								<th>Cast</th>
								<th>Director</th>
								<th>Producer</th>
								<th>Writer</th>
								<th>Release</th>
								<%
								if (admin != null || customer != null) {
								%>
								<th colspan="2" style="text-align: center;">Action</th>
								<%
								}
								%>
							</tr>
							<%
							for (Movie m : mlist) {
							%>
							<tr>
								<td><%=m.getMovieName()%></td>
								<td><%=m.getCast()%></td>
								<td><%=m.getDirector()%></td>
								<td><%=m.getProducer()%></td>
								<td><%=m.getWriter()%></td>
								<td><%=m.getReleaseDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))%></td>

								<%
								if (admin != null && customer == null) {
								%>
								<td><a class="btn btn-warning"
									href="MovieServlet?process=updateMovie&movieId=<%=m.getMovieId()%>">Update</a></td>
								<td><a class="btn btn-danger"
									onclick="return confirm('Are you sure you want to delete')"
									href="MovieServlet?process=deleteMovie&movieId=<%=m.getMovieId()%>">Delete</a></td>
								<%
								}
								%>
								<%
								if (customer != null && admin == null) {
								%>
								<td><a class="btn btn-warning"
									href="ShowServlet?process=allShows&showMovieId=<%=m.getMovieId()%>">Shows</a></td>
								<%
								}
								%>
							</tr>

							<%
							}
							%>

						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>