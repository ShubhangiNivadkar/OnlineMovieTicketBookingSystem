package com.movie.dao;

import java.util.ArrayList;
import com.movie.pojo.Customer;
import com.movie.pojo.Movie;

public interface CustomerDAO {

	public boolean addCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(int customerId);

	public Customer showCustomerById(int customerId);
	public ArrayList<Customer> showCustomerByFirstName(String firstName);
	public Customer showCustomerByEmail(String email);
	public ArrayList<Customer> showAllCustomer();
	
	
}
