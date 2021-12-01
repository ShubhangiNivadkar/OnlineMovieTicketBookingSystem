package com.movie.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.sql.*;
import com.movie.pojo.Movie;
import com.movie.util.DBConnectivity;



public class MovieDAOImpl implements MovieDAO{

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql=null;
	Movie m=null;
	ArrayList<Movie> mlist=null;
	
	@Override
	public boolean addMovie(Movie m) {
		
		con=DBConnectivity.getConnection();
		sql="insert into movie(movieName, cast, director, producer, writer, releaseDate) values(?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMovieName());
			ps.setString(2, m.getCast());
			ps.setString(3, m.getDirector());
			ps.setString(4, m.getProducer());
			ps.setString(5, m.getWriter());
			
			/*
			 * We have converted releaseDate which was of type LocalDate to sql Date type.
			 * 
			 */
			Date d=Date.valueOf(m.getReleaseDate());
			ps.setDate(6, d);
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
		    try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

	
	@Override
	public boolean updateMovie(Movie m) {
		con=DBConnectivity.getConnection();
		sql="update movie set movieName=?, cast=?, director=?, producer=?, writer=?, releaseDate=? where movieId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMovieName());
			ps.setString(2, m.getCast());
			ps.setString(3, m.getDirector());
			ps.setString(4, m.getProducer());
			ps.setString(5, m.getWriter());
			
			Date d=Date.valueOf(m.getReleaseDate());
			ps.setDate(6, d);
			ps.setInt(7, m.getMovieId());
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	
	@Override
	public boolean deleteMovie(int movieId) {
		con=DBConnectivity.getConnection();
		sql="delete from movie where movieId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieId);
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public Movie showMovieById(int movieId) {
		
		con=DBConnectivity.getConnection();
		sql="select * from movie where movieId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieId);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				m=new Movie();
				m.setMovieId(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setCast(rs.getString(3));
				m.setDirector(rs.getString(4));
				m.setProducer(rs.getString(5));
				m.setWriter(rs.getString(6));
				m.setReleaseDate(rs.getDate(7).toLocalDate());
			
				return m;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return null;
	}

	
	@Override
	public ArrayList<Movie> showMovieByName(String movieName) {
		
		con=DBConnectivity.getConnection();
		sql="select * from movie where movieName=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, movieName);
			
			rs=ps.executeQuery();
			mlist=new ArrayList<>();
			while(rs.next()) {
				
				
				m=new Movie();
				m.setMovieId(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setCast(rs.getString(3));
				m.setDirector(rs.getString(4));
				m.setProducer(rs.getString(5));
				m.setWriter(rs.getString(6));
				m.setReleaseDate(rs.getDate(7).toLocalDate());
				
				mlist.add(m);
			}
			
			Collections.sort(mlist);
			
			return mlist;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	
	@Override
	public ArrayList<Movie> showMovieByCast(String cast) {
		con=DBConnectivity.getConnection();
		sql="select * from movie where cast like ?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+cast+"%");
			
			rs=ps.executeQuery();
			
			mlist=new ArrayList<>();
			
			while(rs.next()) {
				
				m=new Movie();
				m.setMovieId(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setCast(rs.getString(3));
				m.setDirector(rs.getString(4));
				m.setProducer(rs.getString(5));
				m.setWriter(rs.getString(6));
				m.setReleaseDate(rs.getDate(7).toLocalDate());
				
				mlist.add(m);
			}
			
			Collections.sort(mlist);
			
			return mlist;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		return null;
	}

	
	@Override
	public ArrayList<Movie> showAllMovies() {
		con=DBConnectivity.getConnection();
		sql="select * from movie";
		
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			mlist=new ArrayList<>();
			while(rs.next()) {
				
				m=new Movie();
				m.setMovieId(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setCast(rs.getString(3));
				m.setDirector(rs.getString(4));
				m.setProducer(rs.getString(5));
				m.setWriter(rs.getString(6));
				m.setReleaseDate(rs.getDate(7).toLocalDate());
				
				mlist.add(m);
			}
			
			Collections.sort(mlist);
			
			return mlist;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
