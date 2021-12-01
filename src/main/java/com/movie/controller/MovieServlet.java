package com.movie.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.dao.MovieDAOImpl;
import com.movie.pojo.Movie;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int movieId;
	private String movieName;
	private String cast;
	private String director;
	private String producer;
	private String writer;
	private LocalDate releaseDate;
	boolean flag;
	
	Movie m=null;
	MovieDAOImpl mimpl=new MovieDAOImpl();
	RequestDispatcher rd=null;
	List<Movie> mlist=null;
	HttpSession session=null;
	
    public MovieServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("allMovies")) {
			
			mlist=mimpl.showAllMovies();
			
			if(mlist!=null && !mlist.isEmpty()) {
				
			session.setAttribute("mlist", mlist);

			response.sendRedirect("AllMovies.jsp");
			}
			else {
				
				request.setAttribute("emsg", "No movies in the database yet");
				response.sendRedirect("Index.jsp");
			}
		}
		else if(process!=null && process.equals("updateMovie")) {
			
			movieId=Integer.parseInt(request.getParameter("movieId"));
			
			m=mimpl.showMovieById(movieId);
			
			session.setAttribute("movieObj", m);
			
			response.sendRedirect("UpdateMovie.jsp");
		}
		
		else if(process!=null && process.equals("deleteMovie")) {
			
			flag=mimpl.deleteMovie(Integer.parseInt(request.getParameter("movieId")));
		
			if(flag) {
				
				mlist=mimpl.showAllMovies();
				
				if(mlist!=null && !mlist.isEmpty()) {
					
				session.setAttribute("mlist", mlist);
			
				request.setAttribute("msg", "Movie deleted Successfully");
				
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.forward(request, response);
			}
		}
			else {
				request.setAttribute("emgs", "Could not delete now");
				
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
		session=request.getSession();
		
		if(process!=null && process.equals("addMovie")) {
			
			movieName=request.getParameter("movieName");
			cast=request.getParameter("cast");
			director=request.getParameter("director");
			producer=request.getParameter("producer");
			writer=request.getParameter("writer");
			releaseDate=LocalDate.parse(request.getParameter("releaseDate"));
		
			m=new Movie();
			m.setCast(cast);
			m.setDirector(director);
			m.setMovieName(movieName);
			m.setProducer(producer);
			m.setReleaseDate(releaseDate);
			m.setWriter(writer);
			
			flag=mimpl.addMovie(m);
			
			if(flag) {
				
				request.setAttribute("msg", "Movie added successfully");
			
				rd=request.getRequestDispatcher("AddMovie.jsp");
				rd.forward(request, response);
			}else {
				
				request.setAttribute("emsg", "Error while adding movie details");
				
				rd=request.getRequestDispatcher("AddMovie.jsp");
				rd.forward(request, response);
			}
		}
		else if(process!=null && process.equals("editMovie")) {
			
			movieName=request.getParameter("movieName");
			cast=request.getParameter("cast");
			director=request.getParameter("director");
			producer=request.getParameter("producer");
			writer=request.getParameter("writer");
			releaseDate=LocalDate.parse(request.getParameter("releaseDate"));
			movieId=Integer.parseInt(request.getParameter("movieId"));
			
			m=new Movie();
			m.setCast(cast);
			m.setDirector(director);
			m.setMovieName(movieName);
			m.setProducer(producer);
			m.setReleaseDate(releaseDate);
			m.setWriter(writer);
			m.setMovieId(movieId);
			
			flag=mimpl.updateMovie(m);
			
			if(flag) {
				
				mlist=mimpl.showAllMovies();
				
				if(mlist!=null && !mlist.isEmpty()) {
					
				session.setAttribute("mlist", mlist);
			
				request.setAttribute("msg", "Movie details have been updated");
				
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.forward(request, response);
			}
		}
	   else {
				request.setAttribute("emgs", "Could not update movie details");
				
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.forward(request, response);
		}
	  }
		
		
   }
}
