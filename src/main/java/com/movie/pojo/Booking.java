package com.movie.pojo;

import java.time.LocalDateTime;

public class Booking {

	private int bookingId;
	private int showId;
	private Show s;
	private String custEmail;
	private LocalDateTime bookingDate;
	private String seat;
	private double totalBill;
	
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Booking(int bookingId, int showId, Show s, String custEmail, LocalDateTime bookingDate, String seat,
			double totalBill) {
		super();
		this.bookingId = bookingId;
		this.showId = showId;
		this.s = s;
		this.custEmail = custEmail;
		this.bookingDate = bookingDate;
		this.seat = seat;
		this.totalBill = totalBill;
	}
	
	
	@Override
	public String toString() {
		return "\nBooking Id= " + bookingId +", \nCustumer Email= " + custEmail+ ", \nBooking Date= " + bookingDate + ", \nSeat= " + seat + ", \nTotal Bill= " + totalBill+"\n\nYour show Details...."+s;
	}
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public Show getS() {
		return s;
	}
	public void setS(Show s) {
		this.s = s;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
}
