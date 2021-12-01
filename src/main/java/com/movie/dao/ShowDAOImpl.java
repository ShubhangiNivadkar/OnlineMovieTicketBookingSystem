package com.movie.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.movie.pojo.Movie;
import com.movie.pojo.Show;
import com.movie.util.DBConnectivity;

public class ShowDAOImpl implements ShowDAO{


	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql=null;
	Show s=null;
	Movie showMovie;
	List<Show> slist=null;
	
	@Override
	public boolean addshow(Show s) {
		con=DBConnectivity.getConnection();
		sql="insert into show_m(showMovieId, theatreName_Loc, startTime, endTime, showDate, showType, price, screen) values(?,?,?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, s.getShowMovieId());
			ps.setString(2, s.getTheatreName_Loc());
			ps.setString(3, s.getStartTime().toString());
			ps.setString(4, s.getEndTime().toString());
			ps.setDate(5, Date.valueOf(s.getShowMovieDate()));
			ps.setString(6, s.getShowType());
			ps.setDouble(7, s.getPrice());
			ps.setString(8, s.getScreen());
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	
	@Override
	public boolean updateShow(Show s) {
		con=DBConnectivity.getConnection();
		sql="update show_m set showMovieId=?, theatreName_Loc=?, startTime=?, endTime=?, showDate=?, showType=?, price=?, screen=? where showId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, s.getShowId());
			ps.setString(2, s.getTheatreName_Loc());
			ps.setString(3, s.getStartTime().toString());
			ps.setString(4, s.getEndTime().toString());
			ps.setDate(5, Date.valueOf(s.getShowMovieDate()));
			ps.setString(6, s.getShowType());
			ps.setDouble(7, s.getPrice());
			ps.setString(8, s.getScreen());
			ps.setInt(9, s.getShowId());
			
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
	public boolean deleteShow(int showId) {
		con=DBConnectivity.getConnection();
		sql="delete from show_m where showId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showId);
			
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
	public Show getShowById(int showId) {
		con=DBConnectivity.getConnection();
		sql="select *from show_m where showId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showId);
			
			rs=ps.executeQuery();
					
			if(rs.next()) {
				
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setShowMovieId(rs.getInt(2));
				s.setTheatreName_Loc(rs.getString(3));
				s.setStartTime(LocalTime.parse(rs.getString(4))); //converting string data received from database to LocalTime
				s.setEndTime(LocalTime.parse(rs.getString(5)));
				s.setShowMovieDate(rs.getDate(6).toLocalDate()); //converting Date type data of table to LocalDate;
				s.setShowType(rs.getString(7));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				showMovie=new MovieDAOImpl().showMovieById(rs.getInt(2)); //fetching movie object from movie table
				s.setShowMovie(showMovie); //setting the movie object into show object
			
				return s;
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
	public List<Show> getShowsByMovieId(int showMovieId) {
		con=DBConnectivity.getConnection();
		sql="select * from show_m where showMovieId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showMovieId);
			
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			
			while(rs.next()) {
				
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setShowMovieId(rs.getInt(2));
				s.setTheatreName_Loc(rs.getString(3));
				s.setStartTime(LocalTime.parse(rs.getString(4))); //converting string data received from database to LocalTime
				s.setEndTime(LocalTime.parse(rs.getString(5)));
				s.setShowMovieDate(rs.getDate(6).toLocalDate()); //converting Date type data of table to LocalDate;
				s.setShowType(rs.getString(7));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				showMovie=new MovieDAOImpl().showMovieById(rs.getInt(2)); //fetching movie object from movie table
				s.setShowMovie(showMovie);
				
				slist.add(s);
			}
			return slist;
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
	public List<Show> getShowsByTheater(String theatreName_Loc) {
		con=DBConnectivity.getConnection();
		sql="select * from show_m where theatreName_Loc like ?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, theatreName_Loc+"%");
			
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			
			while(rs.next()) {
				
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setShowMovieId(rs.getInt(2));
				s.setTheatreName_Loc(rs.getString(3));
				s.setStartTime(LocalTime.parse(rs.getString(4))); //converting string data received from database to LocalTime
				s.setEndTime(LocalTime.parse(rs.getString(5)));
				s.setShowMovieDate(rs.getDate(6).toLocalDate()); //converting Date type data of table to LocalDate;
				s.setShowType(rs.getString(7));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				showMovie=new MovieDAOImpl().showMovieById(rs.getInt(2)); //fetching movie object from movie table
				s.setShowMovie(showMovie);
				
				slist.add(s);
			}
			return slist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
	@Override
	public List<Show> getAllShow() {
		con=DBConnectivity.getConnection();
		sql="select * from show_m";
		
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			
			while(rs.next()) {
				
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setShowMovieId(rs.getInt(2));
				s.setTheatreName_Loc(rs.getString(3));
				s.setStartTime(LocalTime.parse(rs.getString(4))); //converting string data received from database to LocalTime
				s.setEndTime(LocalTime.parse(rs.getString(5)));
				s.setShowMovieDate(rs.getDate(6).toLocalDate()); //converting Date type data of table to LocalDate;
				s.setShowType(rs.getString(7));
				s.setPrice(rs.getDouble(8));
				s.setScreen(rs.getString(9));
				
				slist.add(s);
			}
			Collections.sort(slist);
			
			return slist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
