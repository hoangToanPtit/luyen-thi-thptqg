package com.luyenthithpt.api.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luyenthithpt.model.ExamModel;
import com.luyenthithpt.service.IExamService;
import com.luyenthithpt.service.impl.ExamService;

@WebServlet("/api/exams")
public class ExamAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IExamService examService = new ExamService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		String id = req.getParameter("id");
		
		if(id!=null) { //tra ve chi tiet 1 exam
			Integer examId = Integer.parseInt(id);
			ExamModel examModel = examService.getById(examId);
			mapper.writeValue(resp.getOutputStream(), examModel);	
			
		} else { // tra ve list exam vơi các thong tin chung
			String subject = req.getParameter("sub");
//			List<ExamModel> exams = examService.getListExam();
			List<ExamModel> exams = examService.getListExamBySubject(subject);
			mapper.writeValue(resp.getOutputStream(), exams);
		}
	}	
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		ExamModel examModel = JacksonUtil.of(req.getReader()).toModel(ExamModel.class);
//		examService.save(examModel);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(resp.getOutputStream(), examModel);
//
//	}	
//	
//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		ExamModel examModel = JacksonUtil.of(req.getReader()).toModel(ExamModel.class);
//		examService.update(examModel);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(resp.getOutputStream(), examModel);
//
//	}		
//	
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int examId = Integer.parseInt(req.getParameter("id"));
//		examService.delete(examId);
//	}	
}
