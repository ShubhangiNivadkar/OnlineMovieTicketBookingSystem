<%@page import="com.movie.pojo.Movie"%>
<%@page import="com.movie.dao.MovieDAOImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
						<%
						List<Movie> mlist = new MovieDAOImpl().showAllMovies();
						pageContext.setAttribute("movies", mlist);
						%>
						<form action="ShowServlet" method="post">
							<input type="hidden" name="process" value="addShow">

							<table class="table">
								<tr>
									<th>Movie Id</th>
									<td><select name="showMovieId">
											<c:forEach var="m" items="${movies }">
												<option value="${m.movieId }">${m.movieName }:
													${m.movieId }</option>
											</c:forEach>
									</select></td>
								</tr>

								<tr>
									<th>Theatre name and location</th>
									<td><input type="text" name="theatreName_Loc"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<th>Show time</th>
									<td>From: <input type="time" name="startTime"> To:
										<input type="time" name="endTime"></td>
								</tr>

								<tr>
									<th>Show Date</th>
									<td><input type="date" name="showDate"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<th>Show Type</th>
									<td><select name="showType">
											<option value="Morning">Morning</option>
											<option value="Afternoon">Afternoon</option>
											<option value="Evening">Evening</option>
											<option value="Night">Night</option>
											<option value="Late Night">Late Night</option>
									</select></td>
								</tr>

								<tr>
									<th>Price</th>
									<td><input type="number" name="price"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<th>Screen</th>
									<td><input type="text" name="screen"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<td><input type="reset" value="Reset"
										class="btn btn-warning"></td>
									<td><input type="submit" value="Add Show"
										class="btn btn-info"></td>
								</tr>

							</table>

						</form>

					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>