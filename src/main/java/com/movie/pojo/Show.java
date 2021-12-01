package com.movie.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show implements Comparable<Show>{

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
	

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "\nShow Id= " + showId + ", \nShow Movie Id= " + showMovieId + ", \nShow Movie= " + showMovie+ ", \nTheatre Name and Location= " + theatreName_Loc + ", \nStart Time= " + startTime + ", \nEnd Time= " + endTime+ ", \nShowMovie Date= " + showMovieDate + ", \nShow Type= " + showType + ", \nPrice= " + price + ", \nScreen= "+ screen;
	}


	public Show(int showId, int showMovieId, Movie showMovie, String theatreName_Loc, LocalTime startTime,
			LocalTime endTime, LocalDate showMovieDate, String showType, double price, String screen) {
		super();
		this.showId = showId;
		this.showMovieId = showMovieId;
		this.showMovie = showMovie;
		this.theatreName_Loc = theatreName_Loc;
		this.startTime = startTime;
		this.endTime = endTime;
		this.showMovieDate = showMovieDate;
		this.showType = showType;
		this.price = price;
		this.screen = screen;
	}


	public int getShowId() {
		return showId;
	}


	public void setShowId(int showId) {
		this.showId = showId;
	}


	public int getShowMovieId() {
		return showMovieId;
	}


	public void setShowMovieId(int showMovieId) {
		this.showMovieId = showMovieId;
	}


	public Movie getShowMovie() {
		return showMovie;
	}


	public void setShowMovie(Movie showMovie) {
		this.showMovie = showMovie;
	}


	public String getTheatreName_Loc() {
		return theatreName_Loc;
	}


	public void setTheatreName_Loc(String theatreName_Loc) {
		this.theatreName_Loc = theatreName_Loc;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	public LocalDate getShowMovieDate() {
		return showMovieDate;
	}


	public void setShowMovieDate(LocalDate showMovieDate) {
		this.showMovieDate = showMovieDate;
	}


	public String getShowType() {
		return showType;
	}


	public void setShowType(String showType) {
		this.showType = showType;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public String getScreen() {
		return screen;
	}


	public void setScreen(String screen) {
		this.screen = screen;
	}

	@Override
	public int compareTo(Show o) {
	
		return this.showMovieDate.compareTo(o.showMovieDate);
	}
	
	
	
}
