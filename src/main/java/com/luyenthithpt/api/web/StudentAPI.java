package com.luyenthithpt.api.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.service.IStudentService;
import com.luyenthithpt.service.impl.StudentService;
import com.luyenthithpt.utils.JacksonUtil;

@WebServlet("/api-student")
public class StudentAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IStudentService studentService = new StudentService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();	
		
		String id = req.getParameter("id");
		if(id!=null) {
			int studentId = Integer.parseInt(id);
			StudentModel studentModel = studentService.getById(studentId);
//			System.out.println(studentModel.getDateOfBirth().getTime());
			mapper.writeValue(resp.getOutputStream(), studentModel);
		}else {
			List<StudentModel> students = studentService.getAllStudent();
			mapper.writeValue(resp.getOutputStream(), students);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		StudentModel studentModel = JacksonUtil.of(req.getReader()).toModel(StudentModel.class);
		studentModel = studentService.save(studentModel);		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), studentModel);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		StudentModel studentModel = JacksonUtil.of(req.getReader()).toModel(StudentModel.class);
		studentService.update(studentModel);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), studentModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId = Integer.parseInt(req.getParameter("id"));
		studentService.delete(studentId);
	}
}
