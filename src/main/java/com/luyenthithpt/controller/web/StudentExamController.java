package com.luyenthithpt.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/student_exam"})
public class StudentExamController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String exid = req.getParameter("exid");
		req.setAttribute("url", "student_exam?id="+id);
		

		HttpSession session = req.getSession();
		if(session.getAttribute("userId")==null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/dang_nhap.jsp");
			rd.forward(req, resp);		
			return;
		}
		
		if(id!=null) {
			req.setAttribute("examId", Integer.parseInt(id));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/lam_de_thi.jsp");
			rd.forward(req, resp);
		}else if(exid!=null) {
			req.setAttribute("examId", Integer.parseInt(exid));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/lich_su.jsp");
			rd.forward(req, resp);	
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/de_thi.jsp");
			rd.forward(req, resp);				
		}
		
	}
	
}
