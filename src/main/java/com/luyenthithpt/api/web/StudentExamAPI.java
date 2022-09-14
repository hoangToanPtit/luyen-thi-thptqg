package com.luyenthithpt.api.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.Student_ExamModel;
import com.luyenthithpt.service.IStudent_ExamService;
import com.luyenthithpt.service.impl.Student_ExamService;
import com.luyenthithpt.utils.JacksonUtil;

@WebServlet("/api/student_exam")
public class StudentExamAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IStudent_ExamService student_ExamService = new Student_ExamService();
//	private IStudentService studentService = new StudentService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		int stuid = (int) session.getAttribute("userId");
//		int stuid = 61;
		String examid = req.getParameter("exid");
		if(examid!=null) {
			int exid = Integer.parseInt(examid);
			
			Student_ExamModel student_examModel = student_ExamService.getByStudentIdAndExamId(stuid, exid);
			System.out.println(student_examModel);
			
			mapper.writeValue(resp.getOutputStream(), student_examModel);
		}else {
			List<Student_ExamModel> list = student_ExamService.getStudentExamByStudentID(stuid);
			mapper.writeValue(resp.getOutputStream(), list);
		}
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Student_ExamModel student_examModel = JacksonUtil.of(req.getReader()).toModel(Student_ExamModel.class);

		HttpSession session = req.getSession();
		StudentModel student = new StudentModel();
		student.setUserID((int) session.getAttribute("userId"));
//		student_examModel.setStudent(studentService.getById(61));
		student_examModel.setStudent(student);
		student_ExamService.save(student_examModel);
		
		System.out.println(student_examModel);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), student_examModel);

	}	

}
