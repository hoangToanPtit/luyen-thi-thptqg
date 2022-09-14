package com.luyenthithpt.api.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luyenthithpt.model.QuestionModel;
import com.luyenthithpt.service.IExam_QuestionService;
import com.luyenthithpt.service.IQuestionService;
import com.luyenthithpt.service.impl.Exam_QuestionService;
import com.luyenthithpt.service.impl.QuestionService;
import com.luyenthithpt.utils.JacksonUtil;


@WebServlet("/admin/api/questions")
public class QuestionAPI extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private IQuestionService questionService = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int questionId = Integer.parseInt(req.getParameter("id"));
		QuestionModel questionModel = questionService.getById(questionId);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), questionModel);		
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		QuestionModel questionModel = JacksonUtil.of(req.getReader()).toModel(QuestionModel.class);
		questionService.save(questionModel);
		
		String id = req.getParameter("exid");
		if(id!=null) { //add question vao mot exam cu the
			int examId = Integer.parseInt(id);
			int questionId = questionModel.getQuestionID();
			IExam_QuestionService examQuestion = new Exam_QuestionService();
			examQuestion.addQuestionIntoExam(examId, questionId);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), questionModel);
		

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		QuestionModel questionModel = JacksonUtil.of(req.getReader()).toModel(QuestionModel.class);
		questionService.update(questionModel);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), questionModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int questionId = Integer.parseInt(req.getParameter("id"));
		questionService.delete(questionId);
	}	
}
