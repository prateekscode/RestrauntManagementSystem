package com.prateeks.servlet;

import com.prateeks.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prateeks.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = userDao.getUserType(username, password);

		if ("admin".equalsIgnoreCase(type)) {
			response.sendRedirect("WelcomeA.jsp");
		} else if ("customer".equalsIgnoreCase(type)) {
			response.sendRedirect("WelcomeC.jsp");
		} else {
			response.sendRedirect("Login.jsp?error=1");
			System.out.println("Some Error Occurred");
		}
	}
}
