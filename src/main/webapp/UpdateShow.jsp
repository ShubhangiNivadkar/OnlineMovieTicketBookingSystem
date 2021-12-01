<%@page import="com.movie.dao.MovieDAOImpl"%>
<%@page import="com.movie.pojo.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function changeType(element){
	var s = element.value;
	
	document.getElementById("in1").value= s;
}
</script>
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
							<input type="hidden" name="process" value="updateShow">
							<input type="hidden" name="showId" value="${showObj.showId}">

							<table class="table">
								<tr>
									<th>Movie Id</th>
									<td><select name="showMovieId">
											<c:forEach var="m" items="${movies }">
											
											<c:if test="${showObj.showMovieId == m.movieId }">
												<option selected value="${m.movieId }">${m.movieName }: ${m.movieId }</option>
											</c:if>
											
											<c:if test="${showObj.showMovieId != m.movieId }">
												<option value="${m.movieId }">${m.movieName }: ${m.movieId }</option>
											</c:if>
											</c:forEach>
									</select></td>
								</tr>

								<tr>
									<th>Theater name and location</th>
									<td><input type="text" name="theatreName_Loc" value="${showObj.theatreName_Loc }"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<th>Show time</th>
									<td>From: <input type="time" value="${showObj.startTime }" name="startTime"> To:
										<input type="time" value="${showObj.endTime }" name="endTime"></td>
								</tr>

								<tr>
									<th>Show Date</th>
									<td><input type="date" name="showMovieDate" value="${showObj.showMovieDate }"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<th>Show Type</th>
									<td>
									<input type="text" name="showType" id="in1" value="${showObj.showType }" readonly>
									<select onchange="changeType(this)">
											<option value="Morning">Morning</option>
											<option value="Afternoon">Afternoon</option>
											<option value="Evening">Evening</option>
											<option value="Night">Night</option>
											<option value="Late Night">Late Night</option>
									</select></td>
								</tr>

								<tr>
									<th>Price</th>
									<td><input type="number" value="${showObj.price }" name="price"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<th>Screen</th>
									<td><input type="text" value="${showObj.screen }" name="screen"
										class="form-control form-control-sm"></td>
								</tr>

								<tr>
									<td><input type="reset" value="Reset"
										class="btn btn-warning"></td>
									<td><input type="submit" value="UpdateShow"
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