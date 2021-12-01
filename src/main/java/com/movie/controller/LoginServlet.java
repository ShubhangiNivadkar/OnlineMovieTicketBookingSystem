package com.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.movie.dao.CustomerDAOImpl;
import com.movie.dao.LoginDaoImpl;
import com.movie.pojo.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String loginType;
	String username;
	String password;
	boolean flag;
	LoginDaoImpl limpl = new LoginDaoImpl();
	HttpSession session = null;
	RequestDispatcher rd = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String process = request.getParameter("process");
		
		if(process != null && process.equals("Logout")) {
			session.invalidate();
			request.setAttribute("emsg", "You have logged out of this site.");
			rd= request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String process = request.getParameter("process");
		session = request.getSession();
		if (process != null && process.equals("Login")) {

			loginType = request.getParameter("loginType");
			username = request.getParameter("userName");
			password = request.getParameter("pass");
			if (loginType != null && loginType.equals("Admin")) {
				flag = limpl.checkAdmin(username, password);

				if (flag) {
					request.setAttribute("msg", "You have successfully logged in as Admin");
					session.setAttribute("admin", username);

					rd = request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("emsg", "Error while logging in. Please chcek the usename and password given");

					rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}

			else if (loginType != null && loginType.equals("Customer")) {
				flag = limpl.checkCustomer(username, password);

				if (flag) {
					Customer c = new CustomerDAOImpl().showCustomerByEmail(username);
					request.setAttribute("msg",
							"You have successfully logged in as " + c.getFirstName() + " " + c.getLastName());
					session.setAttribute("customer", username);

					rd = request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("emsg", "Error while logging in. Please chcek the usename and password given");

					rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}

		}

	}
}
