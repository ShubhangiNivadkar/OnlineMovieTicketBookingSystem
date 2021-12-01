package com.movie.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.dao.ShowDAOImpl;
import com.movie.pojo.Movie;
import com.movie.pojo.Show;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int showId;
	private int showMovieId;
	private Movie showMovie;
	private String theatreName_Loc;
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDate showMovieDate;
	private String showType;
	private double price;
	private String screen;
	boolean flag;
	Show s=null;
	ShowDAOImpl simpl=new ShowDAOImpl();
	RequestDispatcher rd=null;
	List<Show> slist=null;
	
	HttpSession session=null;
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("allShows")) {
			
			slist=simpl.getAllShow();
			session.setAttribute("slist", slist);
			
			response.sendRedirect("AllShows.jsp");	
		}
		
		else if(process!=null && process.equals("updateShow")) {
			
			showId=Integer.parseInt(request.getParameter("showId"));
			
			s=simpl.getShowById(showId);
			
			if(s!=null) {
				
				session.setAttribute("showObj", s);
				
				response.sendRedirect("UpdateShow.jsp");
			}
		}
		else if(process!=null && process.equals("deleteShow")) {
			
			flag=simpl.deleteShow(Integer.parseInt(request.getParameter("showId")));
		
			if(flag) {
				
				slist=simpl.getAllShow();//showAllMovies();
				
				if(slist!=null && !slist.isEmpty()) {
					
				session.setAttribute("slist", slist);
			
				request.setAttribute("msg", "Show deleted Successfully");
				
				rd=request.getRequestDispatcher("AllShows.jsp");
				rd.forward(request, response);
			}
		}
			else {
				request.setAttribute("emgs", "Could not delete now");
				
				rd=request.getRequestDispatcher("AllShows.jsp");
				rd.forward(request, response);
		  }
		}
		
		else if(process!=null && process.equals("showByMovie")) {
			
			showMovieId=Integer.parseInt(request.getParameter("showMovieId"));
			
			slist=simpl.getShowsByMovieId(showMovieId);
			
			if(slist!=null && slist.isEmpty()!=true) {
			
			session.setAttribute("slist", slist);
			
			response.sendRedirect("AllShows.jsp");	
			
			}
			else {
				
				request.setAttribute("emsg", "Sorry there are no shows for this movie yet!!");
				
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.forward(request, response);
				
				
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		
		if(process!=null && process.equals("addShow")) {
			
			showMovieId=Integer.parseInt(request.getParameter("showMovieId"));
			theatreName_Loc=request.getParameter("theatreName_Loc");
			startTime=LocalTime.parse(request.getParameter("startTime"));
			endTime=LocalTime.parse(request.getParameter("endTime"));
			showMovieDate=LocalDate.parse(request.getParameter("showMovieDate"));
			showType=request.getParameter("showType");
			price=Double.parseDouble(request.getParameter("price"));
			screen=request.getParameter("screen");
			
			s=new Show();
			s.setEndTime(endTime);
			s.setPrice(price);
			s.setScreen(screen);
			s.setShowMovieDate(showMovieDate);
			s.setShowMovieId(showMovieId);
			s.setTheatreName_Loc(theatreName_Loc);
			s.setStartTime(startTime);
			s.setShowType(showType);
		
			flag=simpl.addshow(s);
			
			if(flag) {
				
				request.setAttribute("msg", "Show added Successfully");
				
				rd=request.getRequestDispatcher("AddShow.jsp");
				rd.forward(request, response);	
			}
			else {
				
                request.setAttribute("msg", "Error while adding show details");
				
				rd=request.getRequestDispatcher("AddShow.jsp");
				rd.forward(request, response);
				
			}
		}
		else if(process!=null && process.equals("updateShow")) {
			
			showMovieId=Integer.parseInt(request.getParameter("showMovieId"));
			theatreName_Loc=request.getParameter("theatreName_Loc");
			startTime=LocalTime.parse(request.getParameter("startTime"));
			endTime=LocalTime.parse(request.getParameter("endTime"));
			showMovieDate=LocalDate.parse(request.getParameter("showMovieDate"));
			showType=request.getParameter("showType");
			price=Double.parseDouble(request.getParameter("price"));
			screen=request.getParameter("screen");
			showId=Integer.parseInt(request.getParameter("showId"));
			
			s=new Show();
			s.setEndTime(endTime);
			s.setPrice(price);
			s.setScreen(screen);
			s.setShowMovieDate(showMovieDate);
			s.setShowMovieId(showMovieId);
			s.setTheatreName_Loc(theatreName_Loc);
			s.setStartTime(startTime);
			s.setShowType(showType);
			s.setShowId(showId);
			
			flag=simpl.updateShow(s);
			
			if(flag) {
				
				request.setAttribute("msg", "Show details updated successfully");
				
				slist=simpl.getAllShow();
				session.setAttribute("slist", slist);
				
				rd=request.getRequestDispatcher("AllShows.jsp");
				rd.forward(request, response);
			}
			else {
				
				request.setAttribute("emsg", "Error while updating show details");
				
				rd=request.getRequestDispatcher("AllShows.jsp");
				rd.forward(request, response);
			}
			
		}
	}

}
