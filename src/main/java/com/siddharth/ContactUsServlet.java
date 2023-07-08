package com.siddharth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.siddharth.dao.RequestDao;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse servletResponse) throws ServletException, IOException {
		servletResponse.sendRedirect("contactus.jsp");
	}
	protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
		String name = servletRequest.getParameter("name");
	    String email = servletRequest.getParameter("email");
	    String message = servletRequest.getParameter("message");
	    
	    Request request = new Request();
	    request.setName(name);
	    request.setEmail(email);
	    request.setMessage(message);

	    RequestDao.saveRequest(request);
	    servletResponse.sendRedirect("contactus");
	}
}
