package com.movie.pojo;

public class Customer implements Comparable<Customer> {

	private int customerId;
	private String firstName;
	private String lastName;
	private String contact;
	private String email;
	private String address;
	private String password;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Customer(int customerId, String firstName, String lastName, String contact, String email, String address,
			String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "\nCustomerId=" + customerId + ", \nFirstName=" + firstName + ", \nLastName=" + lastName
				+ ", \nContact=" + contact + ", \nEmail=" + email + ", \nAddress=" + address + ", \npassword=" + password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int compareTo(Customer o) {
		
		return this.firstName.compareTo(o.firstName);
	}
}
