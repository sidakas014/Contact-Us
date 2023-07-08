package com.siddharth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import com.siddharth.dao.UserDao;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
		servletResponse.sendRedirect("login.jsp");
	}
	protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
		HttpSession session = servletRequest.getSession();
		String id = servletRequest.getParameter("id");
		String pass = servletRequest.getParameter("pass");
		User user = new User(id, pass);
		if(UserDao.isValidUser(user)) {
			session.setAttribute("isWrong", null);
			servletResponse.sendRedirect("dashboard");
		}
		else {
			session.setAttribute("isWrong", "yes");
			servletResponse.sendRedirect("login.jsp");
		}
	}
}
