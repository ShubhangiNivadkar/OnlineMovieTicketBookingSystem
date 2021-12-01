 package com.movie.dao;

import java.util.ArrayList;

import com.movie.pojo.Movie;

public interface MovieDAO {

	public boolean addMovie(Movie m);
	public boolean updateMovie(Movie m);
	public boolean deleteMovie(int movieId);
	
	public Movie showMovieById(int movieId);
	public ArrayList<Movie> showMovieByName(String movieName);
	public ArrayList<Movie> showMovieByCast(String cast);
	public ArrayList<Movie> showAllMovies();
}
