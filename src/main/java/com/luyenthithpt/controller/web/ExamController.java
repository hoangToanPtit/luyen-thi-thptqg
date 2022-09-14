package com.luyenthithpt.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/exams"})
public class ExamController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		if(id!=null) {
			req.setAttribute("examId", Integer.parseInt(id));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/xem_de_thi.jsp");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/de_thi.jsp");
			rd.forward(req, resp);				
		}
		
	}
	
}
