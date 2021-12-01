package com.movie.dao;

import java.util.List;
import com.movie.pojo.Show;

public interface ShowDAO {

	public boolean addshow(Show s);
	public boolean updateShow(Show s);
	public boolean deleteShow(int showId);
	
	public Show getShowById(int showId);
	public List<Show> getShowsByMovieId(int showMovieId);
	public List<Show> getShowsByTheater(String theatreName_Loc);
	public List<Show> getAllShow();
	
	
}
