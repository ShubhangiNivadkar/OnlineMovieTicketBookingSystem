package com.movie.test;

import java.util.ArrayList;
import java.util.Scanner;
import com.movie.dao.CustomerDAOImpl;
import com.movie.pojo.Customer;
import com.movie.pojo.Movie;

public class CustomerTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Customer c=new Customer();
		CustomerDAOImpl cimpl=new CustomerDAOImpl();
		ArrayList<Customer> clist=null;
		boolean exit=false, flag;
		
		 int customerId;
		 String firstName;
		 String lastName;
		 String contact;
		 String email;
		 String address;
		 String password;
		 String choise;
		 
		 do {
			 System.out.println("\nPLEASE ENTER ONE OF THE OPTIONS GIVEN BELOW");
				System.out.println("1-------------------->Add Customer Details");
				System.out.println("2-------------------->Show by Customer Name");
				System.out.println("3-------------------->Update Customer Details");
				System.out.println("4-------------------->Delete Customer Details");
				System.out.println("5-------------------->Show all Customer");
				System.out.println("6-------------------->Show Customer By email");
		 
				int option=sc.nextInt();
				sc.nextLine();
				
				switch(option) {
				
				case 1:
					System.out.println("Enter Customer First Name:-");
					firstName=sc.nextLine();
				
					System.out.println("Enter Customer Last Name:-");
					lastName=sc.nextLine();
					
					System.out.println("Enter Customer Contact Name:-");
					contact=sc.nextLine();
					
					System.out.println("Enter Customer Email ID:-");
					email=sc.nextLine();
					
					System.out.println("Enter Customer Address:-");
					address=sc.nextLine();
					
					System.out.println("Create Customer Password:-");
					password=sc.nextLine();
					
					c=new Customer();
					c.setFirstName(firstName);
					c.setLastName(lastName);
					c.setContact(contact);
					c.setEmail(email);
					c.setAddress(address);
					c.setPassword(password);
					
					flag=cimpl.addCustomer(c);
					
					if(flag)
						System.out.println("Customer Added Successfully");
					else
						System.out.println("Error will added Customer");
					break;
					
					
				case 2:
					System.out.println("Enter Customer Name");
					firstName=sc.next();
					sc.nextLine();
					
					clist=cimpl.showCustomerByFirstName(firstName);
					
					if(clist.isEmpty() || clist==null)
						System.out.println("No Such Customer found in database");
					else {
							for(Customer c1:clist) {
								System.out.println(c1);
								System.out.println("_____________________________");
							}
					}
					break;
					
					
				case 3:
					System.out.println("Enter Customer ID:-");
					customerId=sc.nextInt();
					sc.nextLine();
					
					c=cimpl.showCustomerById(customerId);
					
					if(c==null)
						System.out.println("No Customer by the given ID found in database");
					else {
						System.out.println("---------------Your Customer Details---------------");
						System.out.println(c);
						
						System.out.println("\nAre you sure you want to Update? Enter yes or not");
						choise=sc.next();
						sc.nextLine();
						
						if(choise.equals("yes")) {
							System.out.println("Enter Customer First Name:-");
							firstName=sc.nextLine();
						
							System.out.println("Enter Customer Last Name:-");
							lastName=sc.nextLine();
							
							System.out.println("Enter Customer Contact Name:-");
							contact=sc.nextLine();
							
							System.out.println("Enter Customer Email ID:-");
							email=sc.nextLine();
							
							System.out.println("Enter Customer Address:-");
							address=sc.nextLine();
							
							System.out.println("Create Customer Password:-");
							password=sc.nextLine();
							
							c.setFirstName(firstName);
							c.setLastName(lastName);
							c.setContact(contact);
							c.setEmail(email);
							c.setAddress(address);
							c.setPassword(password);
							
							flag=cimpl.updateCustomer(c);
							
							if(flag)
								System.out.println("Customer Details Updated Successfully");
							else
								System.out.println("Error while Updating");
						}
						else if(choise.equals("no"))
							System.out.println("No problem!!!");
						else
							System.out.println("Please enter your answer in yes or not");
					}
					break;
					
					
				case 4:
					System.out.println("Enter Customer ID:-");
					customerId=sc.nextInt();
					sc.nextLine();
					
					c=cimpl.showCustomerById(customerId);
					
					if(c==null)
						System.out.println("No Customer by the given ID found in database");
					else {
						System.out.println("---------------Your Customer Details---------------");
						System.out.println(c);
						
						System.out.println("\nAre you sure you want to Delete? Enter yes or no");
						choise=sc.next();
						sc.nextLine();
						
						if(choise.equals("yes")) {
							
							flag=cimpl.deleteCustomer(customerId);
							
							if(flag)
								System.out.println("Customer Deleted Successfully");
							else
								System.out.println("Erro while Deleting");
						}
						else if(choise.equals("no"))
							System.out.println("No problem!!!");
						else
							System.out.println("Please enter your answer in yes or no");
					}
					break;
					
					
				case 5:
					clist=cimpl.showAllCustomer();
					
					if(clist.isEmpty())
						System.out.println("Our database is Empty!! Please add customer first");
					else {
						System.out.println("**********************Your Customer List**********************");
						
						for(Customer c1:clist) {
							System.out.println(c1);
							System.out.println("______________________________________________________");
						}
					}
					break;
					
					
				case 6:
					System.out.println("Enter Customer Email ID:-");
					email=sc.nextLine();
					
					c=cimpl.showCustomerByEmail(email);
					
					if(c==null)
						System.out.println("No such Customer found in database");
					else {
						System.out.println("---------------------Your Profile---------------------");
						System.out.println(c);
					}
					break;
				}
		 }while(exit==false);
	}
}
