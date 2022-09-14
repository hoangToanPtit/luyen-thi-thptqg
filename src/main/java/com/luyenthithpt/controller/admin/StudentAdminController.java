package com.luyenthithpt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/admin/students"})
public class StudentAdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if(session.getAttribute("userId")==null) {
			resp.sendRedirect("https://localhost/luyenthithptqg/admin");	
			return;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/admin/ql_hoc_sinh.jsp");
		rd.forward(req, resp);	
	}
}
