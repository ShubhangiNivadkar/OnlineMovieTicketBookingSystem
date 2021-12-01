package com.movie.dao;

import java.util.List;

import com.movie.pojo.Booking;

public interface BookingDAO {

	public Booking bookMyShow(Booking b);
	public boolean cancelBooking(int bookingId);
	
	public Booking getBookingById(int bookingId);
	public List<Booking> getMyBookings(String custEmail);
	public List<Booking> getAllBookings();
		
}
