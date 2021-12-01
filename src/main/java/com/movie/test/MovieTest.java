package com.movie.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import com.movie.dao.MovieDAOImpl;
import com.movie.pojo.Movie;

public class MovieTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Movie m=new Movie();
		MovieDAOImpl mimpl=new MovieDAOImpl();
		ArrayList<Movie> mlist=null;
		boolean exit=false, flag;
		
		 int movieId;
		 String movieName;
		 String cast;
		 String director;
		 String producer;
		 String writer;
		 LocalDate releaseDate;
		 int year, month, dayOfMonth;
		 String choise;
		
		do {
			System.out.println("\nPLEASE ENTER ONE OF THE OPTIONS GIVEN BELOW");
			System.out.println("1-------------------->Add Movie Details");
			System.out.println("2-------------------->Show Movie By Name");
			System.out.println("3-------------------->Update Movie Details");
			System.out.println("4-------------------->Delete Movie Details");
			System.out.println("5-------------------->Show all Movies");
			System.out.println("6-------------------->Show Movie By Cast");
			
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:
				System.out.println("Enter movie Name:-");
				movieName=sc.nextLine();
				
				System.out.println("Enter movie Cast:-");
				cast=sc.nextLine();
				
				System.out.println("Enter movie Director:-");
				director=sc.nextLine();
				
				System.out.println("Enter Producer Name:-");
				producer=sc.nextLine();
				
				System.out.println("Enter Writer Name:-");
				writer=sc.nextLine();
				
				System.out.println("Year of Release:-");
				year=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enetr month of realese; number between 1 to 12");
				month=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter day of release; number 1 to 31");
				dayOfMonth=sc.nextInt();
				sc.nextLine();
				
				releaseDate=LocalDate.of(year, month, dayOfMonth);
				
				m=new Movie();
				m.setCast(cast);
				m.setDirector(director);
				m.setMovieName(movieName);
				m.setProducer(producer);
				m.setReleaseDate(releaseDate);
				m.setWriter(writer);
				
				flag=mimpl.addMovie(m);
				
				if(flag)
					System.out.println("Movie added Successfully");
				else
					System.out.println("Error will added Movie");
				break;
				
				
			case 2:
				System.out.println("Enter movie name:-");
				movieName=sc.next();
				sc.nextLine();
				
				mlist=mimpl.showMovieByName(movieName);
				
				if(mlist.isEmpty() || mlist==null)
					System.out.println("No such movie found in database");
				else
				{
					for(Movie m1:mlist) {
						System.out.println(m1);
						System.out.println("______________________________________________________________________________");
					}
				}
				break;
				
				
			case 3:
				System.err.println("Enter Movie ID:-");
				movieId=sc.nextInt();
				sc.nextLine();
				
				m=mimpl.showMovieById(movieId);
				
				if(m==null)
					System.out.println("No movie by the given ID found in Database");
				else {
					System.out.println("----------Your Movie Details-----------");
					System.out.println(m);
					
					System.out.println("\nAre you sure you want to Update? Enter yes or not");
					choise=sc.next();
					sc.nextLine();
					
					if(choise.equals("yes")) {
						System.out.println("Enter movie Name:-");
						movieName=sc.nextLine();
						
						System.out.println("Enter movie Cast:-");
						cast=sc.nextLine();
						
						System.out.println("Enter movie Director:-");
						director=sc.nextLine();
						
						System.out.println("Enter Producer Name:-");
						producer=sc.nextLine();
						
						System.out.println("Enter Writer Name:-");
						writer=sc.nextLine();
						
						System.out.println("Year of Release:-");
						year=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enetr month of realese; number between 1 to 12");
						month=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter day of release; number 1 to 31");
						dayOfMonth=sc.nextInt();
						sc.nextLine();
						
						releaseDate=LocalDate.of(year, month, dayOfMonth);
						
						m.setCast(cast);
						m.setDirector(director);
						m.setMovieName(movieName);
						m.setProducer(producer);
						m.setReleaseDate(releaseDate);
						m.setWriter(writer);
						
						flag=mimpl.updateMovie(m);
						
						if(flag)
							System.out.println("Movie Updated Successfully");
						else
							System.out.println("Error while updating");
					}
					else if(choise.equals("no"))
						System.out.println("No problem!!!");
					else
						System.out.println("Please enter your answer in yes or not");
				}
				break;
				
				
			case 4:
				System.out.println("Enter Movie ID:-");
				movieId=sc.nextInt();
				sc.nextLine();
				
				m=mimpl.showMovieById(movieId);
				
				if(m==null)
					System.out.println("No movie by the given ID found in Database");
				else {
					System.out.println("----------Your Movie Details-----------");
					System.out.println(m);
					
					System.out.println("\nAre you sure you want to Delete? Enter yes or no");
					choise=sc.next();
					sc.nextLine();
					
					if(choise.equals("yes")) {
						
						flag=mimpl.deleteMovie(movieId);
						
						if(flag)
							System.out.println("Movie Deleted Successfully");
						else
							System.out.println("Error while Deleting");
					}
					else if(choise.equals("no"))
						System.out.println("No problem!");
					else
						System.out.println("Please enter your answer in yes or no");
				}
				break;
				
			case 5:
				mlist=mimpl.showAllMovies();
				
				if(mlist.isEmpty())
					System.out.println("Our database is Empty!! Please add movie first");
				else {
					System.out.println("**********************Your Movie List**********************");
					
					for(Movie m1:mlist) {
						System.out.println(m1);
						System.out.println("______________________________________________________");
					}
				}
				break;
				
				
			case 6:
				System.out.println("Enter movie Cast:-");
				cast=sc.nextLine();
				
				mlist=mimpl.showMovieByCast(cast);
				
				if(mlist.isEmpty())
					System.out.println("No such movie found in database");
				else
				{
					System.out.println("<------------Your movie details with given cast------------>");
					for(Movie m1:mlist) {
						System.out.println(m1);
						System.out.println("______________________________________________________________________________");
					}
				}
			
			}
			
		} while (exit==false);
	}
}
