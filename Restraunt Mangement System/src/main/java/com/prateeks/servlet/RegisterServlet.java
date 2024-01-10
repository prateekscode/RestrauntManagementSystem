package com.prateeks.servlet;
import com.prateeks.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao=new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String mobile=request.getParameter("mobile");
		String type=request.getParameter("type");
		
		User user=new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setDob(dob);
		user.setMobile(mobile);
		user.setType(type);
		
		if(userDao.addUser(user)) {
			response.sendRedirect("Login.jsp?registration=success");
		}
		else {
			response.sendRedirect("register.jsp?error=1");
		}
		
	}

}
