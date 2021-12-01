package com.movie.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import com.movie.dao.ShowDAOImpl;
import com.movie.pojo.Movie;
import com.movie.pojo.Show;

public class ShowTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Show s=null;
		ShowDAOImpl simpl=new ShowDAOImpl();
		List<Show> slist=null;
		
		 boolean exit=false, flag;
		 int showId;
		 int showMovieId;
		 Movie showMovie;
		 String theatreName_Loc;
		 LocalTime startTime;
		 LocalTime endTime;
		 LocalDate showMovieDate;
		 String showType, choice;
		 double price;
		 int hour, min;
		 int year, month, dayOfMonth;
		 
		do {
			
			System.out.println("\nEnter one of the below given options...");
			System.out.println("1------------------>Add show");
			System.out.println("2------------------>Get show By ID");
			System.out.println("3------------------>Update show Details");
			System.out.println("4------------------>Delete show");
			System.out.println("5------------------>Get show by movie ID");
			System.out.println("6------------------> Get show by Theatre Name");
			System.out.println("7-------------------->Show all Shows");
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
		case 1:
			 System.out.println("Enter Movie ID:-");
			 showMovieId=sc.nextInt();
			 sc.nextLine();
			 
			 System.out.println("Enter Theatre name and Location:-");
			 theatreName_Loc=sc.nextLine();
			 
			 System.out.println("Enter Hour of Start Time: Number between 0 to 23:-");
			 hour=sc.nextInt();
			 sc.nextLine();
			 
			 System.out.println("Enter Minute of Strat Time: Number between 0 to 59:-");
			 min=sc.nextInt();
			 sc.nextLine();
				
			 startTime=LocalTime.of(hour, min);
				
			 System.out.println("Enter Hour of End Time: Number between 0 to 23:-");
			 hour=sc.nextInt();
			 sc.nextLine();
			 
			 System.out.println("Enter Minute of End Time: Number between 0 to 59:-");
			 min=sc.nextInt();
			 sc.nextLine();
				
			 endTime=LocalTime.of(hour, min);
				
			 
			 System.out.println("Enter Year of Show:-");
				year=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enetr Month of Show; number between 1 to 12:-");
				month=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Day of Show; number 1 to 31:-");
				dayOfMonth=sc.nextInt();
				sc.nextLine();
				
				showMovieDate=LocalDate.of(year, month, dayOfMonth);
				
				System.out.println("Enter Show Type:-");
				showType=sc.nextLine();
				
				System.out.println("Enter Price of Ticket:-");
				price=sc.nextDouble();
				sc.nextLine();
				
				s=new Show();
				s.setEndTime(endTime);
				s.setPrice(price);
				s.setShowMovieId(showMovieId);
				s.setShowMovieDate(showMovieDate);
				s.setShowType(showType);
				s.setStartTime(startTime);
				s.setTheatreName_Loc(theatreName_Loc);
				
				flag=simpl.addshow(s);
				
				if(flag)
					System.out.println("Show Added Successfully");
				else
					System.out.println("Error while adding show Details");
				break;
				
				
		case 2:
			System.out.println("Enter Show ID");
			showId=sc.nextInt();
			sc.nextLine();
			
			s=simpl.getShowById(showId);
			
			if(s==null)
				System.out.println("No shows of the given ID found");
			else
			{
				System.out.println(s);
			}
			break;
			
			
		case 3:
			System.out.println("Enter show ID:-");
			showId=sc.nextInt();
			sc.nextLine();
			
			s=simpl.getShowById(showId);
			
			if(s==null)
				System.out.println("No shows of the given id found");
			else
			{
				System.out.println(s);
				
				System.out.println("Do you want to update this show? Enter yes or no");
				choice=sc.nextLine();
				
				if(choice.equals("yes")) {
					 System.out.println("Enter show ID:-");
					 showMovieId=sc.nextInt();
					 sc.nextLine();
					 
					 System.out.println("Enter Theatre name and Location:-");
					 theatreName_Loc=sc.nextLine();
					 
					 System.out.println("Enter Hour of Start Time: Number between 0 to 23:-");
					 hour=sc.nextInt();
					 sc.nextLine();
					 
					 System.out.println("Enter Minute of Strat Time: Number between 0 to 59:-");
					 min=sc.nextInt();
					 sc.nextLine();
						
					 startTime=LocalTime.of(hour, min);
						
					 System.out.println("Enter Hour of End Time: Number between 0 to 23:-");
					 hour=sc.nextInt();
					 sc.nextLine();
					 
					 System.out.println("Enter Minute of End Time: Number between 0 to 59:-");
					 min=sc.nextInt();
					 sc.nextLine();
						
					 endTime=LocalTime.of(hour, min);
						
					 
					 System.out.println("Enter Year of Show:-");
						year=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enetr Month of Show; number between 1 to 12:-");
						month=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter Day of Show; number 1 to 31:-");
						dayOfMonth=sc.nextInt();
						sc.nextLine();
						
						showMovieDate=LocalDate.of(year, month, dayOfMonth);
						
						System.out.println("Enter Show Type:-");
						showType=sc.nextLine();
						
						System.out.println("Enter Price of Ticket:-");
						price=sc.nextDouble();
						sc.nextLine();
						
						s.setEndTime(endTime);
						s.setPrice(price);
						s.setShowMovieId(showMovieId);
						s.setShowMovieDate(showMovieDate);
						s.setShowType(showType);
						s.setStartTime(startTime);
						s.setTheatreName_Loc(theatreName_Loc);
				
						flag=simpl.updateShow(s);
						
						if(flag)
							System.out.println("Show Update Successfully");
						else
							System.out.println("Error while Updating Details");
				}
				else if(choice.equals("no"))
					System.out.println("No problem");
				else
					System.out.println("Please give input in yes or no only");
			}
			break;
			
			
		case 4:
			System.out.println("Enter show ID:-");
			showId=sc.nextInt();
			sc.nextLine();
			
			s=simpl.getShowById(showId);
			
			if(s==null)
				System.out.println("No shows of the given id found");
			else
			{
				System.out.println(s);
				
				System.out.println("Do you want to delete this show? Enter yes or no");
				choice=sc.nextLine();
				
				if(choice.equals("yes")) {
					 
				
						flag=simpl.deleteShow(showId);
						
						if(flag)
							System.out.println("Show Delete Successfuly");
						else
							System.out.println("Error shilw Deleting Show");
				}
				else if(choice.equals("no"))
					System.out.println("No problem");
				else
					System.out.println("Please give input in yes or no only");
			}
			break;
			
			
		case 5:
			System.out.println("Enter Movie ID:-");
			showMovieId=sc.nextInt();
			sc.nextLine();
			
			slist=simpl.getShowsByMovieId(showMovieId);
			
			if(slist.isEmpty())
				System.out.println("Shows of this movie yet");
			else {
				slist.forEach(x-> System.out.println(x));
			}
			break;
		
			
		case 6:
			System.out.println("Enter Theatre Name");
			theatreName_Loc=sc.nextLine();
			
			slist=simpl.getShowsByTheater(theatreName_Loc);
			
			if(slist.isEmpty())
				System.out.println("No such Theatre found in database");
			else
			{
				System.out.println("<------------Your Show details with given Theatre------------>");
				for(Show s1:slist) {
					System.out.println(s1);
					System.out.println("______________________________________________________________________________");
				}
			}
			break;
			
			
		case 7:
			slist=simpl.getAllShow();
			
			if(slist.isEmpty())
				System.out.println("Our database is Empty!! Please add Show first");
			else {
				System.out.println("**********************Your Show List**********************");
			
			for(Show s1:slist) {
				System.out.println(s1);
				System.out.println("______________________________________________________");
			  }
			}
			break;
			}
			
		} while (exit==false);

	}

}
