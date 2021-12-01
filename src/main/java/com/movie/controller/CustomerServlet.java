package com.movie.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.dao.CustomerDAOImpl;
import com.movie.pojo.Customer;



/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int customerId;
	private String firstName;
	private String lastName;
	private String contact;
	private String email;
	private String address;
	private String password;
	boolean flag;
	
	Customer c=null;
	CustomerDAOImpl cimpl=new CustomerDAOImpl();
	RequestDispatcher rd=null;
	List<Customer> clist=null;
	HttpSession session=null;
	
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("AllCustomer")) {
			
			clist=cimpl.showAllCustomer();
			
			if(clist!=null && !clist.isEmpty()) {
				
			session.setAttribute("clist", clist);

			response.sendRedirect("AllCustomer.jsp");
			}
			else {
				
				request.setAttribute("emsg", "No Customer in the database yet");
				response.sendRedirect("Index.jsp");
			}
		}
		else if(process!=null && process.equals("myProfile")) {
			
			email=(String)session.getAttribute("customer");
			c=cimpl.showCustomerByEmail(email);
			
			session.setAttribute("custoObj", c);
			
			response.sendRedirect("UpdateCustomer.jsp");
		}
		
		else if(process!=null && process.equals("deleteCustomer")) {
			
			flag=cimpl.deleteCustomer(Integer.parseInt(request.getParameter("customerId")));
		
			if(flag) {
				
				clist=cimpl.showAllCustomer();
				
				if(clist!=null && !clist.isEmpty()) {
					
				session.setAttribute("clist", clist);
			
				request.setAttribute("msg", "Customer deleted Successfully");
				
				rd=request.getRequestDispatcher("AllCustomer.jsp");
				rd.forward(request, response);
			}
		}
			else {
				request.setAttribute("emgs", "Could not delete now");
				
				rd=request.getRequestDispatcher("AllCustomer.jsp");
				rd.forward(request, response);
		 }
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("addCustomer")) {
			
			firstName=request.getParameter("firstName");
			lastName=request.getParameter("lastName");
			contact=request.getParameter("contact");
			email=request.getParameter("email");
			address=request.getParameter("address");
			password=request.getParameter("password");
			
		
			c=new Customer();
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setContact(contact);
			c.setEmail(email);
			c.setAddress(address);
			c.setPassword(password);
			
			flag=cimpl.addCustomer(c);
			
			if(flag) {
				
				request.setAttribute("msg", "Customer added successfully");
			
				rd=request.getRequestDispatcher("AddCustomer.jsp");
				rd.forward(request, response);
			}else {
				
				request.setAttribute("emsg", "Error while adding customer details");
				
				rd=request.getRequestDispatcher("AddCustomer.jsp");
				rd.forward(request, response);
			}
		}
		else if(process!=null && process.equals("editCustomer")) {
			
			firstName=request.getParameter("firstName");
			lastName=request.getParameter("lastName");
			contact=request.getParameter("contact");
			email=request.getParameter("email");
			address=request.getParameter("address");
			password=request.getParameter("password");
			customerId=Integer.parseInt(request.getParameter("customerId"));
			
			c=new Customer();
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setContact(contact);
			c.setEmail(email);
			c.setAddress(address);
			c.setPassword(password);
			c.setCustomerId(customerId);
			
			flag=cimpl.updateCustomer(c);
			
			if(flag) {
				
				clist=cimpl.showAllCustomer();
				
				if(clist!=null && !clist.isEmpty()) {
					
				session.setAttribute("clist", clist);
			
				request.setAttribute("msg", "Customer details have been updated");
				
				rd=request.getRequestDispatcher("AllCustomer.jsp");
				rd.forward(request, response);
			}
		}
	   else {
				request.setAttribute("emgs", "Could not update customer details");
				
				rd=request.getRequestDispatcher("AllCustomer.jsp");
				rd.forward(request, response);
		 }
	  }
		
	}
}
