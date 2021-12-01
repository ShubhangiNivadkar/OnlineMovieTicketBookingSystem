<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Blogs</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 crossorigin="anonymous">
<style>
body {
  font-family: Arial;
  padding: 20px;
  background: #f1f1f1;
}

/* Header/Blog Title */
.header {
  padding: 30px;
  font-size: 40px;
  text-align: center;
  background: white;
  color:white;
  background-image: url('images/blogT.jpg');
  height:300px;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
  float: right;
  width: 75%;
}

/* Right column */
.rightcolumn {
  float: left;
  width: 25%;
  padding-left: 20px;
}

/* Fake image */
.fakeimg {
  background-color: #aaa;
  width: auto;
  padding: 20px;
  height: 390px;
  
}
.fakeimg1{
  background-color: #aaa;
  width: auto;
  padding: 20px;
  height: 200px;
  
}
.fa {
  padding: 20px;
  font-size: 30px;
  width: 30px;
  text-align: center;
  text-decoration: none;
  border-radius: 50%;
}

/* Add a card effect for articles */
.card {
  background-color: white;
  padding: 20px;
  margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}


/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
  .leftcolumn, .rightcolumn {
    width: 100%;
    padding: 0;
  }
}
</style>
</head>

<body>
<div class="header">
  <h2>Shows</h2>
</div>

<div class="row">
  <div class="leftcolumn">
    <div class="card">
      <h2 style="font-weight: bold;">Bhuj : The Pride Of India</h2>
      <h5>Realese On, Dec 7, 2021</h5>
      <div class="fakeimg" style="background-image: url('images/bi1.jpeg')" style="height:100%;"></div>
      <p style="font-weight: bold;">It is Blockblaster Movie</p>
      <p>Bhuj : Pride of India is a celebration of the 300 women of Madhapur in Gujarat lead by 
      IAF squadron leader Vijay Karnik who played a pivotal part in India's victory in the 1971 Indo-Pak 
     	war. Karnik with his team, with the help of these local women created history by reconstructing 
     	the only IAF airstrip at Bhuj destroyed during war. Karnik was lauded for his valiant efforts 
     	which saved the day for the Indians. The film will be a tribute to unparalleled bravado displayed 
     	by not only Karnik but 300 women from the villages near Bhuj who accomplished this feat</p>
     
    </div>
    <div class="card">
      <h2 style="font-weight: bold;">Sanak</h2>
      <h5 >Release On, Dec 30, 2021</h5>
      <div class="fakeimg" style="background-image: url('images/bi2.jpg')" style="height:100%;"></div>
      <p></p>
      <p>The movie Sanak directed by Kanishk Varma is an Action drama released on Disney Hostar on 15 
      October filled with thrill shows a story of a rescue operation from a hospital. 
      The story shows a situation where the lead characters in the film Vidyut Jammwal staring as
       Vivaan Ahuja and his beloved wife Rukmini Maitra play the role as Anshika seem to be trapped 
       inside a hospital in operation and is a siege.</p>
      <p>Comming Soon...</p>
    </div>
  </div>
  <div class="rightcolumn">
    <div class="card">
      <h4 style="font-weight: bold;">FOLLOW BLOG VIA EMAIL</h4>
      <p>Enter your email address to follow this blog and receive notifications of new posts by email.</p>
      <p>Join 1,410 other subscribers</p>
       <div class="form-group">
  		<label for="usr">Email:</label>
  		<input type="email" class="form-control" id="usr">
		</div>
		<button type="button" class="btn btn-success">Follow</button>
    </div>
    <div class="card">
      <h3 style="font-weight: bold;">Popular Movies</h3>
      <div class="fakeimg1" style="background-image: url('images/bi6.jfif')"></div><br>
      <div class="fakeimg1" style="background-image: url('images/bi11.jfif')"></div><br>
      <div class="fakeimg1" style="background-image: url('images/bi8.jfif')"></div><br>
      <div class="fakeimg1" style="background-image: url('images/bi9.jfif')"></div><br>
      
    </div>
    <div class="card">
      <h3 style="font-weight: bold;">Follow Movie blog page</h3>
      <p><a href="#" class="fa fa-facebook"></a>
<a href="#" class="fa fa-twitter"></a></p>
    </div>
  </div>
</div>




</body>
</html>