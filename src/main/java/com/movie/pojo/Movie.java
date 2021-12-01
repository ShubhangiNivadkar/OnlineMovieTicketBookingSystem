package com.movie.pojo;

import java.time.LocalDate;

public class Movie implements Comparable<Movie>{
	//All are creating using alt+shift+s
	
	private int movieId;
	private String movieName;
	private String cast;
	private String director;
	private String producer;
	private String writer;
	private LocalDate releaseDate;
	
	public Movie() {
		super();
	}
	
	
	public Movie(int movieId, String movieName, String cast, String director, String producer, String writer,
			LocalDate releaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.cast = cast;
		this.director = director;
		this.producer = producer;
		this.writer = writer;
		this.releaseDate = releaseDate;
	}
	
	
	@Override
	public String toString() {
		return "\nMovieId= " +movieId+ ", \nMovieName= " +movieName+ ", \nCast= " +cast+ ", \nDirector= " +director+ ", \nProducer= " +producer+ ", \nWriter= " +writer+ ", \nReleaseDate= " +releaseDate;
	}
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public int compareTo(Movie o) {
		
		return this.movieName.compareTo(o.movieName);
	}
}
