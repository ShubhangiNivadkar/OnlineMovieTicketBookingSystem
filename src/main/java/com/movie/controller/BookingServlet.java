package com.movie.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.dao.BookingDAOImpl;
import com.movie.dao.ShowDAOImpl;
import com.movie.pojo.Booking;
import com.movie.pojo.Show;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int bookingId;
	private int showId;
	private Show s;
	private String custEmail;
	private LocalDateTime bookingDate;
	private String seat;
	private double totalBill;
	boolean flag;
 
    BookingDAOImpl bimpl=new BookingDAOImpl();
    RequestDispatcher rd=null;
    HttpSession session=null;
    Booking b=null;
   List<Booking> blist=null;
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession();
		
		//process=bookMyShow&showId=11
		 if(process!=null && process.equals("selectSeats")) {
			 
			 showId=Integer.parseInt(request.getParameter("showId"));
			 
			List<String> bookedSeats=bimpl.reservedSeats(showId);
		 
			Show s=new ShowDAOImpl().getShowById(showId);
			
			request.setAttribute("showDetails", s);
			request.setAttribute("bookedSeats", bookedSeats);
			
			rd=request.getRequestDispatcher("BookSeats.jsp");
			rd.forward(request, response);
			
		 }
		 else if(process!=null && process.equals("myBookings")) {
			 
			 custEmail=(String)session.getAttribute("customer");
			 
			 blist=bimpl.getMyBookings(custEmail);
			 
			 if(blist!=null && blist.isEmpty()!=true){
				 
				 session.setAttribute("bookingList", blist);
				 
				 response.sendRedirect("AllBooking.jsp");
			 }
		 }
		 
		 else if(process!=null && process.equals("cancelBooking")) {
			 
			 bookingId=Integer.parseInt(request.getParameter("bookingId"));
			 
			 flag=bimpl.cancelBooking(bookingId);
			 
			 if(flag) {
				 
				 blist=bimpl.getMyBookings(custEmail);
				 
				 if(blist!=null && blist.isEmpty()!=true) {
					 
					 request.setAttribute("msg", "Yo have cancelled the booking");
					 
					  session.setAttribute("bookingList", blist);
					  
					  rd=request.getRequestDispatcher("AllBooking.jsp");
					  rd.forward(request, response);
					  
				 }
			 }
			 else {
				 
				 request.setAttribute("emsg", "Error while cancelling your booking");
				 rd=request.getRequestDispatcher("AllBooking.jsp");
				 rd.forward(request, response);
			 }
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("bookShow")) {
			
			showId=Integer.parseInt(request.getParameter("showId"));
			custEmail=(String)session.getAttribute("customer");
			seat=request.getParameter("bookedseats");
			totalBill=Double.parseDouble(request.getParameter("totalBill"));
			
			b=new Booking();
			b.setShowId(showId);
			b.setCustEmail(custEmail);
			b.setSeat(seat);
			b.setTotalBill(totalBill);
			
			Booking b1=bimpl.bookMyShow(b);
			
			if(b1!=null) {
				
				request.setAttribute("msg", "Your show has been booked!! Have a wonderful time!!");
				session.setAttribute("bookingObj", b1);
				
				rd=request.getRequestDispatcher("Invoice.jsp");
				rd.forward(request, response);
				
				
			}else {
				session.setAttribute("emsg", "Booking could be done");
				
				rd=request.getRequestDispatcher("AllShows.jsp");
				rd.forward(request, response);
				
			}
			
		}
	}
}
