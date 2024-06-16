package com.company.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.company.dao.UserDaoImpl;
import com.company.dao.User;
import com.company.dao.UserDao;
/**
 * Servlet implementation class signupservlet
 */
public class signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");

	        User user = new User();
	        user.setUsername(username);
	        user.setEmail(email);
	        user.setPassword(password);

	        //UserDao userDao = new UserDaoImpl();
	        if (userDao.addUser(user)) {
	            response.sendRedirect("login.jsp?signup=success");
	        } else {
	            response.sendRedirect("signup.jsp?error=1");
	        }
	}

}
