package com.luyenthithpt.api.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.TeacherModel;
import com.luyenthithpt.model.UserModel;
import com.luyenthithpt.service.impl.StudentService;
import com.luyenthithpt.service.impl.TeacherService;
import com.luyenthithpt.utils.JacksonUtil;
import com.luyenthithpt.utils.SHA512;

/**
 * Servlet implementation class SignUpAPI
 */
@WebServlet("/api-sign-up")
public class SignUpAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {			
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			UserModel user = JacksonUtil.of(req.getReader()).toModel(UserModel.class);
			user.setPassword(SHA512.encryptThisString(user.getPassword()));
//			System.out.println(user);
			ObjectMapper mapper = new ObjectMapper();
			if(user.getRole().equals("student")) {
				StudentModel studentModel = new StudentService().save(user);
				mapper.writeValue(resp.getOutputStream(), studentModel);
			}else if(user.getRole().equals("teacher")){
				TeacherModel teacherModel = new TeacherService().save(user);
				mapper.writeValue(resp.getOutputStream(), teacherModel);
			}
		}

}
