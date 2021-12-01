package com.movie.dao;

public interface LoginDAO {
	public boolean checkAdmin(String username, String password);

	public boolean checkCustomer(String username, String password);

	public boolean changeAdminPassword(String username, String oldPassword, String newPassword);

	public boolean changeCustomerPassword(String username, String oldPassword, String newPassword);

}
