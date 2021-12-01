package com.movie.test;

import java.time.LocalDateTime;
import java.util.Scanner;
import com.movie.dao.BookingDAOImpl;
import com.movie.pojo.Booking;
import com.movie.pojo.Movie;
import com.movie.pojo.Show;

public class BookingTest {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 Booking b=null, b2=null;
		 BookingDAOImpl bimpl=new BookingDAOImpl();
		
		 boolean exit=false, flag;
		 int bookingId;
		 int showId;
		 Show s;
		 String custEmail;
		 LocalDateTime bookingDate;
		 String seat;
		 double totalBill;

		 do {
			System.out.println("\n\nEnter one of below given options..................");
			System.out.println("1-------------------->Book Show");
			System.out.println("2-------------------->Cancel Booking");
			System.out.println("3-------------------->Get booking by Id");
			System.out.println("4-------------------->Get My booking");
			System.out.println("5-------------------->Get All booking");
			
			int option=sc.nextInt();
			
			switch(option) {
			
			case 1:
					System.out.println("Enter show ID:-");
					showId=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter your Email ID:-");
					custEmail=sc.nextLine();
					
					System.out.println("Enter the seats to be booked");
					seat=sc.nextLine();
					
					b=new Booking();
					b.setShowId(showId);
					b.setCustEmail(custEmail);
					b.setSeat(seat);
					
					b2=bimpl.bookMyShow(b);
					
					if(b2==null)
						System.out.println("Error While Booking the Show");
					else
						System.out.println("Your show has been booked...");
					    System.out.println(b2);
				break;
				
			case 2:
				
				System.out.println("Enter Booking ID:-");
				bookingId=sc.nextInt();
				sc.nextLine();
				
				flag=bimpl.cancelBooking(bookingId);
				
				if(flag)
					System.out.println("Your booking has been cancelled");
				else
					System.out.println("Error while cancelling");
				break;
				
			case 3:
				 System.out.println("Enter Booking Id");
				 bookingId=sc.nextInt();
				 sc.nextLine();
				 
				 b=bimpl.getBookingById(bookingId);
				 
				 if(b==null)
					 System.out.println("No bookings of this id found");
				 else {
					 System.out.println("Your Booking Details");
					 System.out.println(b);
				 }
				 break;
			 
			case 4:
				break;
				
			case 5:
				
				break;
			}
		 
		} while (exit==false);
	}

}
