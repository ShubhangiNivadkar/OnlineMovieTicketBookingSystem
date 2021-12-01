<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<form action="LoginServlet" method="post">
						<input type="hidden" name="process" value="Login">
							<table class="table">
								<tr>
									<th>Type</th>
									<td><select name="loginType" class="form-control form-control-sm">
											<option value="Admin">Admin</option>
											<option value="Customer">Customer</option>
									</select></td>
								</tr>

								<tr>
									<th>Email:</th>
									<td><input type="email" name="userName" class="validateMe form-control form-control-sm"></td>
								</tr>

								<tr>
									<th>Password:</th>
									<td><input type="password" name="pass" class="validateMe form-control form-control-sm"></td>
								</tr>

								<tr>
									<td><input type="reset" class="btn btn-warning" value="Reset"></td>
									<td><input type="submit" class="btn btn-info" value="Login"></td>
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