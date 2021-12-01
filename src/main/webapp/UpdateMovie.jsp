<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(element) {

		if (element.value == "" && element.name == "movieName") {

			document.getElementById("mname").innerHTML = "Please enter Movie Name"
			return false
		} else if (element.value == "" && element.name == "cast") {

			document.getElementById("cast").innerHTML = "Please enter Cast Name"
			return false
		}

		else if (element.value == "" && element.name == "director") {

			document.getElementById("director").innerHTML = "Please enter Director Name"
			return false
		}

		else if (element.value == "" && element.name == "producer") {

			document.getElementById("producer").innerHTML = "Please enter Producer Name"
			return false
		}

		else if (element.value == "" && element.name == "writer") {

			document.getElementById("writer").innerHTML = "Please enter Writer Name"
			return false
		}

		else if (element.value == "" && element.name == "releaseDate") {

			document.getElementById("releaseDate").innerHTML = "Please enter Release Date "
			return false
		}

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
						<form action="MovieServlet" method="post">
							<input type="hidden" name="process" value="editMovie"> 
							<input type="hidden" name="movieId" value="${movieObj.movieId }">


							<table class="table">
								<tr>
									<th>Movie Name</th>
									<td><input name="movieName" value="${movieObj.movieName }"
										type="text" class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="mname" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Cast</th>
									<td><input name="cast" value="${movieObj.cast }"
										type="text" class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="cast" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Director</th>
									<td><input name="director" value="${movieObj.director }"
										type="text" class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="director" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Producer</th>
									<td><input name="producer" value="${movieObj.producer }"
										type="text" class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="producer" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Writer</th>
									<td><input name="writer" value="${movieObj.writer }"
										type="text" class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="writer" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Release Date</th>
									<td><input name="releaseDate"
										value="${movieObj.releaseDate }" type="Date"
										class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="releaseDate" style="color: red">*</span></td>
								</tr>

								<tr>
									<td><input type="reset" value="Reset"
										class="btn btn-warning"></td>
									<td><input type="submit" value="Submit"
										class="btn btn-info" onclick="return validateWithClass()"></td>
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