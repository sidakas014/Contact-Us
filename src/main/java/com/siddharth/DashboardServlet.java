package com.siddharth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.siddharth.dao.RequestDao;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
		List<Request> activeRequestDataList = RequestDao.fetchAllRequests(true);
		List<Request> archiveRequestDataList = RequestDao.fetchAllRequests(false);
		HttpSession session = servletRequest.getSession();
		session.setAttribute("activeRequestDataList", activeRequestDataList);
		session.setAttribute("archiveRequestDataList", archiveRequestDataList);
		servletResponse.sendRedirect("dashboard.jsp");
	}
	protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
		int requestId = Integer.parseInt(servletRequest.getParameter("dataId"));
		int requestStatus = Integer.parseInt(servletRequest.getParameter("dataStatus"));
		boolean status;
		if(requestStatus == 1) {
			status = true;
		}
		else {
			status = false;
		}
		RequestDao.changeStatus(requestId, status);
		servletResponse.sendRedirect("dashboard");
	}
}
