<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(element) {

		if (element.value == "" && element.name == "firstName") {

			document.getElementById("fname").innerHTML = "Please enter First Name"
			return false
		} else if (element.value == "" && element.name == "lastName") {

			document.getElementById("lname").innerHTML = "Please enter Last Name"
			return false
		}

		else if (element.value == "" && element.name == "contact") {

			document.getElementById("contact").innerHTML = "Please enter Contact"
			return false
		}

		else if (element.value == "" && element.name == "email") {

			document.getElementById("email").innerHTML = "Please enter Email ID"
			return false
		}

		else if (element.value == "" && element.name == "address") {

			document.getElementById("address").innerHTML = "Please enter Address"
			return false
		}

		else if (element.value == "" && element.name == "password") {

			document.getElementById("password").innerHTML = "Please enter password "
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
						<form action="CustomerServlet" method="post">
							<input type="hidden" name="process" value="addCustomer">
							<table class="table">
								<tr>
									<th>First Name</th>
									<td><input name="firstName" type="text"
										class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="fname" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Last Name</th>
									<td><input name="lastName" type="text"
										class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="lname" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Contact</th>
									<td><input name="contact" type="number"
										class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="contact" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Email</th>
									<td><input name="email" type="email"
										class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="email" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Address</th>
									<td><input name="address" type="text"
										class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="address" style="color: red">*</span></td>
								</tr>

								<tr>
									<th>Password</th>
									<td><input name="password" type="password"
										class="validateMe form-control form-control-sm"
										onblur="validate(this)"></td>
									<td><span id="password" style="color: red">*</span></td>
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