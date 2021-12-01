package com.movie.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.sql.*;
import com.movie.pojo.Customer;
import com.movie.util.DBConnectivity;


public class CustomerDAOImpl implements CustomerDAO{

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql=null;
	Customer c=null;
	ArrayList<Customer> clist=null;
	
	@Override
	public boolean addCustomer(Customer c) {
		con=DBConnectivity.getConnection();
		sql="insert into customer(firstName, lastName, contact, email, address, password) values(?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getContact());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAddress());
			ps.setString(6, c.getPassword());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		con=DBConnectivity.getConnection();
		sql="update customer set firstName=?, lastName=?, contact=?, email=?, address=?, password=? where customerId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getContact());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getAddress());
			ps.setString(6, c.getPassword());
			ps.setInt(7, c.getCustomerId());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public boolean deleteCustomer(int customerId) {
		con=DBConnectivity.getConnection();
		sql="delete from customer where customerId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, customerId);
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Customer showCustomerById(int customerId) {
		
		con=DBConnectivity.getConnection();
		sql="select * from customer where customerId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, customerId);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				c=new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setContact(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				return c;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<Customer> showCustomerByFirstName(String firstName) {
		
		con=DBConnectivity.getConnection();
		sql="select * from customer where firstName like ?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, firstName+"%");
			
			rs=ps.executeQuery();
			clist=new ArrayList<>();
			while(rs.next()) {
				c=new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setContact(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				clist.add(c);
			}
			Collections.sort(clist);
			
			return clist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return null;
	}

	
	@Override
	public Customer showCustomerByEmail(String email) {
		con=DBConnectivity.getConnection();
		sql="select * from customer where email=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				
				c=new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setContact(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				return c;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<Customer> showAllCustomer() {
		
		con=DBConnectivity.getConnection();
		sql="select * from customer";
		
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			clist=new ArrayList<>();
			while(rs.next()) {
				
				c=new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setContact(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setPassword(rs.getString(7));
				
				clist.add(c);
			}
			return clist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
