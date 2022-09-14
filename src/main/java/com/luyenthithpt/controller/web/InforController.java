package com.luyenthithpt.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/infor"})
public class InforController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		if(session.getAttribute("userId")==null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/dang_nhap.jsp");
			rd.forward(req, resp);		
			return;
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/web/cai_dat.jsp");
		rd.forward(req, resp);
		
	}
	
}
