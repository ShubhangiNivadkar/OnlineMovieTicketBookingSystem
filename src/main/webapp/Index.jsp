<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineMovieTicketBooking</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<header>
		<section class="py-5">
			<div class="container bg-white">
				<div class="moviecontainer">
					<div class="container">
						<div>
							<jsp:include page="Messages.jsp"></jsp:include>
						</div>
						<div id="carouselExampleIndicators" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carouselExampleIndicators" data-slide-to="0"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="1"
									class="active"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner" role="listbox">
								<!-- Slide Three - Set the background image for this slide in the line below -->
								<div class="carousel-item"
									style="background-image: url('images/The-Priest-Movie.jpeg')">
									<div class="carousel-caption d-none d-md-block">
										<!--   <h2 class="display-4">Third Slide</h2>
	          <p class="lead">This is a description for the third slide.</p> -->
									</div>
								</div>
								<!-- Slide One - Set the background image for this slide in the line below -->
								<div class="carousel-item active"
									style="background-image: url('images/Untitled-2021-02-22T191451.523-1.jpeg')">
									<div class="carousel-caption d-none d-md-block">
										<!-- <h2 class="display-4">First Slide</h2>
	          <p class="lead">This is a description for the first slide.</p> -->
									</div>
								</div>
								<!-- Slide Two - Set the background image for this slide in the line below -->
								<div class="carousel-item"
									style="background-image: url('images/maxresdefault.jpg')">
									<div class="carousel-caption d-none d-md-block">
										<!-- <h2 class="display-4">Second Slide</h2>
	          <p class="lead">This is a description for the second slide.</p> -->
									</div>
								</div>
							</div>
							<a class="carousel-control-prev"
								href="#carouselExampleIndicators" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next"
								href="#carouselExampleIndicators" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</section>
	</header>
	<!-- main Content if any -->
	<section class="py-5">
		<div class="container bg-white">
			<div class="moviecontainer">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-sm-12">
							<div class="section-heading">
								<div class="line-dec"></div>
								<h1 class="page-title">Up Coming Movies</h1>
							</div>
						</div>
					</div>
				</div>
				
				<div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('images/laal-singh-chaddha-001.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Laal Singh Chaddha</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				
				<div class="info-section">
					<label>Producer</label>
					<span> Aamir Khan; </span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span> Advait Chandan</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>Radhika Chaudhari</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span> Aamir Khan;  </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label><span>14 April 2022 </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Coming
									Soon...</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div>
				<div class="movie-card">
					<div class="movie-header movieimage"style="background-image: url('images/Bhuj_2021_.jpg');">
						<div class="header-icon-container">
							<a href="#"> 
							<i class="material-icons header-icon"> </i>
							</a>
						</div>
					</div>
					<!--movie-header-->
					<div class="movie-content">
						<div class="movie-content-header">
							<a href="#">
								<h3 class="movie-title">Bhuj</h3>
							</a>
							<div class="imax-logo"></div>
						</div>
						<div class="movie-info">

							<div class="info-section">
								<label>Producer</label> <span>Bhushan Kumar</span>
							</div>
							<!--Producer-->
							<div class="info-section">
								<label>Director</label> <span>Abhishek Dudhaiya</span>
							</div>
							<!--Director-->
							<div class="info-section">
								<label>Writer</label> <span> Raman Kumar;</span>
							</div>
							<!--Director-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Cast </label> <span> Ajay Devgn  </span>
							</div>
							<!--cast-->
							<div class="info-section">
								<label>Release Date </label> <span>13 August 2021 </span>
							</div>
							<!--date-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<a class="btn btn-primary ml-auto" href="#" role="button">Show's</a>
							</div>
						</div>
					</div>
					<!--movie-content-->
				</div>
				<!--movie-card-->



				<div class="movie-card">
					<div class="movie-header movieimage"
						style="background-image: url('images/Golmaal-5-Hindi-Movie-2021.jpg');">
						<div class="header-icon-container">
							<a href="#"> <i class="material-icons header-icon"> </i>
							</a>
						</div>
					</div>
					<!--movie-header-->
					<div class="movie-content">
						<div class="movie-content-header">
							<a href="#">
								<h3 class="movie-title">Golmaal-5</h3>
							</a>
							<div class="imax-logo"></div>
						</div>
						<div class="movie-info">

							<div class="info-section">
								<label>Producer</label> 
								<span>Rohit     Shetty</span>
							</div>
							<!--Producer-->
							<div class="info-section">
								<label>Director</label> 
								<span>Rohit Shetty</span>
							</div>
							<!--Director-->
							<div class="info-section">
								<label>Writer</label> 
								<span>Rohit Shetty</span>
							</div>
							<!--Director-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Cast </label> <span>Aajay Devgan,KK,TK,AW,ST </span>
							</div>
							<!--cast-->
							<div class="info-section">
								<label>Release Date </label> <span>6Nov 2021 </span>
							</div>
							<!--date-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<a class="btn btn-primary ml-auto" href="#" role="button">Show's</a>
							</div>
						</div>
					</div>
					<!--movie-content-->
				</div>
				<!--movie-card-->
	
				<!--movie-card-->
				<div class="movie-card">
					<div class="movie-header movieimage"
						style="background-image: url('images/Shang-chi-2021.jpg');">
						<div class="header-icon-container">
							<a href="#"> <i class="material-icons header-icon"> </i>
							</a>
						</div>
					</div>
					<!--movie-header-->
					<div class="movie-content">
						<div class="movie-content-header">
							<a href="#">
								<h3 class="movie-title">Shang-Chi </h3>
							</a>
							<div class="imax-logo"></div>
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Producer</label> <span> Kevin Feige; Jonathan Schwartz</span>
							</div>
							<!--Producer-->
							<div class="info-section">
								<label>Director</label> <span> Destin Daniel Cretton</span>
							</div>
							<!--Director-->
							<div class="info-section">
								<label>Writer</label> <span> Destin Daniel Cretton</span>
							</div>
							<!--Director-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Cast </label> <span> Simu Liu </span>
							</div>
							<!--cast-->
							<div class="info-section">
								<label>Release Date </label> <span>2 September 2021 (India)</span>
							</div>
							<!--date-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<a class="btn btn-primary ml-auto" href="#" role="button">Show's</a>
							</div>
						</div>
					</div>
					<!--movie-content-->
				</div>
				<!--movie-card-->
				
				<!--movie-card-->
				<div class="movie-card">
					<div class="movie-header movieimage"
						style="background-image: url('images/Salaar-306x393.jpg');">
						<div class="header-icon-container">
							<a href="#"> <i class="material-icons header-icon"> </i>
							</a>
						</div>
					</div>
					<!--movie-header-->
					<div class="movie-content">
						<div class="movie-content-header">
							<a href="#">
								<h3 class="movie-title">Salaar</h3>
							</a>
							<div class="imax-logo"></div>
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Producer</label> <span> Vijay Kiragandur</span>
							</div>
							<!--Producer-->
							<div class="info-section">
								<label>Director</label> <span>Prashanth Neel</span>
							</div>
							<!--Director-->
							<div class="info-section">
								<label>Writer</label> <span>Aijay Kiragandur Hombale Films
								</span>
							</div>
							<!--Director-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Cast </label> 
								<span>Prashanth Neel;  Shruti Haasan </span>
							</div>
							<!--cast-->
							<div class="info-section">
								<label>Release Date </label> <span>14 April 2022 </span>
							</div>
							<!--date-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<a class="btn btn-primary ml-auto" href="#" role="button">Comming Soon...</a>
							</div>
						</div>
					</div>
					<!--movie-content-->
				</div>
				<!--movie-card-->
				
				<!--movie-card-->
				<div class="movie-card">
					<div class="movie-header movieimage"
						style="background-image: url('images/No-Time-To-Die.jpg');">
						<div class="header-icon-container">
							<a href="#"> <i class="material-icons header-icon"> </i>
							</a>
						</div>
					</div>
					<!--movie-header-->
					<div class="movie-content">
						<div class="movie-content-header">
							<a href="#">
								<h3 class="movie-title">No-Time-To-Die</h3>
							</a>
							<div class="imax-logo"></div>
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Producer</label> <span>Robert Wade</span>
							</div>
							<!--Producer-->
							<div class="info-section">
								<label>Director</label> <span>Cary Joji Fukunaga</span>
							</div>
							<!--Director-->
							<div class="info-section">
								<label>Writer</label> <span>Neal Purvis</span>
							</div>
							<!--Director-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<label>Cast </label> <span>Robert Wade </span>
							</div>
							<!--cast-->
							<div class="info-section">
								<label>Release Date </label> <span>30 September 2021 </span>
							</div>
							<!--date-->
						</div>
						<div class="movie-info">
							<div class="info-section">
								<a class="btn btn-primary ml-auto" href="#" role="button">Show's</a>
							</div>
						</div>
					</div>
					<!--movie-content-->
				</div>
				<!--movie-card-->

			</div>
		</div>

	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>