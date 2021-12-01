<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, com.movie.pojo.*, com.movie.dao.CustomerDAOImpl"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Book your Seats</title>
<link rel="stylesheet" type="text/css" href="css/seatingcss.css" />
<script src="js/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	
	$(".displayerBoxes").hide();
	
	$(".csbtn").click(function(){
		
		$(".displayerBoxes").show();
		$(".seatStructure").hide();
		
		var selectedSeats=$("input:checked");
		
		var noOfSeats=selectedSeats.length;
		var price=$("#price").val();
		
		var total=noOfSeats*price;
		
		$("#totalBill").val(total);
		
		var seats="";
		
		for(var i=0; i<selectedSeats.length; i++){
			
			if(i==selectedSeats.length-1)
				seats+=selectedSeats[i].value;
		
			else
				seats+=selectedSeats[i].value+", ";
		}
		
		$("#seatsDisplay").val(seats);
	
	});
});
</script>

<body >
<input type="hidden" name="price" id="price" value="${showDetails.price}">

<jsp:include page="Header.jsp"></jsp:include>

	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container">
	<div>
	<jsp:include page="Messages.jsp"></jsp:include>
	
<div class="container"  >
	<div class="seatStructure column" style="margin: 0px auto" >
		<table id="seatsBlock" align="center"style="color:black;">
			<tr>
				<td colspan="14"><div class="screen">SCREEN</div></td>
				<td rowspan="20">
					<div class="smallBox greenBox">Selected Seat</div> <br />
					<div class="smallBox redBox">Reserved Seat</div> <br />
					<div class="smallBox emptyBox">Empty Seat</div> <br />
				</td>
				
			</tr>
<%
int cols=12;
char rows='M';

List<String> bookedSeats=(List<String>)request.getAttribute("bookedSeats");
%>
			<tr>
				<td></td>
				<%for(int i=1; i<=cols; i++) {%>

					<td><%= i %></td>
					
					<% if(i==6) {%>
					
					<td class="seatGap"></td>
					
					<%} %>
					
				<%} %>
			</tr>
		
				<%for(char r='A'; r<=rows; r++) {%>
			
			<tr>
				<td><%= r %></td>
				
				<%for(int i=1; i<cols; i++){ 
				String seat=r+""+i;
				
					if(bookedSeats !=null && bookedSeats.contains(seat)){
						
				%>
				
			<td><div class="smallBox redBox"></div></td>
			
			<%} else {%>	<%--End of if condition --%>		
				
				<td><input type="checkbox" class="seats" value="<%= seat %>"></td>
				
				<%} if(i==6){ %>
				
				<td class="seatGap"></td>
				
				<%} }%> <%--End inner for loop and else statement--%>
			</tr>
			
			<%} %> <%--End of outer for loop --%>
			
			
			
			<tr>
			<td align="center" colspan="14"><button  class="csbtn" onclick="updateTextArea()" style="margin: 5px;">Confirm Selection</button></td>
			</tr>
		</table>
	</div>

<%
String customer=(String)session.getAttribute("customer");
Customer c=new CustomerDAOImpl().showCustomerByEmail(customer);

Show s=(Show)request.getAttribute("showDetails");
%>
	<div class="displayerBoxes column " style="margin-top: 50px;" >
		<form action="BookingServlet" method="post">
		<input type="hidden" name="process" value="bookShow"> 
		<table class="Displaytable" align="center">
		
			<tr>
				<th>Customer Name :</th>
				<td><%= c.getFirstName() %>  <%=c.getLastName() %></td>
			</tr>
			<tr>
				<th>Show Id :</th>
				<td><input type="text" id="showId" name="showId"
					value="<%= s.getShowId() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Movie :</th>
				<td><%= s.getShowMovie().getMovieName() %></td>
			</tr>
			<tr>
				<th>Screen Name:</th>
				<td><%= s.getScreen() %></td>
			</tr>
			<tr>
				<th>Start Time:</th>
				<td><%= s.getStartTime() %></td>
			</tr>
			<tr>
				<th>End Time:</th>
				<td><%= s.getEndTime() %></td>
			</tr>
			<tr>
				<th>Seat:</th>
				<td><input type="text" id="seatsDisplay" name="bookedseats" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Total:</th>
				<td><input type="text" name="totalBill" id="totalBill" readonly></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Buy" class="buybtn"></th>
			</tr>
		</table>
		</form>
		<div id="legend"></div>
		<div style="clear: both"></div>
	</div>
	</div>
    </div>
  </div>
</div>
</div>
</section>
<jsp:include page="Footer.jsp"></jsp:include>
<!-- END PAGE SOURCE -->

</body>
</html>