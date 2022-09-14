package com.luyenthithpt.api.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.TeacherModel;
import com.luyenthithpt.model.UserModel;
import com.luyenthithpt.service.impl.StudentService;
import com.luyenthithpt.service.impl.TeacherService;
import com.luyenthithpt.service.impl.UserService;
import com.luyenthithpt.utils.JacksonUtil;
import com.luyenthithpt.utils.SHA512;

/**
 * Servlet implementation class LoginAPI
 */
@WebServlet("/api-log-in")
public class LoginAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			ObjectMapper mapper = new ObjectMapper();
			UserModel user = JacksonUtil.of(req.getReader()).toModel(UserModel.class);
			user.setPassword(SHA512.encryptThisString(user.getPassword()));
			UserService userService = new UserService();
			Integer id = userService.findId(user.getUserName(), user.getPassword());
			if(id!=null) {
				String role = userService.getRoleById(id);
//				System.out.println(role);
				if(role.equals("student")) {
					StudentModel studentModel = new StudentService().getById(id);
					HttpSession session = req.getSession();
					session.setAttribute("userId", studentModel.getUserID());
					session.setAttribute("firstName", studentModel.getFirstName());
					session.setAttribute("lastName", studentModel.getLastName());
					mapper.writeValue(resp.getOutputStream(), studentModel);
				}else if(role.equals("teacher")) {
					TeacherModel teacherModel = new TeacherService().getById(id);
					HttpSession session = req.getSession();
					session.setAttribute("userId", teacherModel.getUserID());
					session.setAttribute("firstName", teacherModel.getFirstName());
					session.setAttribute("lastName", teacherModel.getLastName());
					mapper.writeValue(resp.getOutputStream(), teacherModel);
				}else if(role.equals("admin")) {
					UserModel userModel = new UserService().getById(id);
//					System.out.println(userModel);
					HttpSession session = req.getSession();
					session.setAttribute("userId", userModel.getUserID());
					session.setAttribute("firstName", "Admin");
					session.setAttribute("lastName", "");
					mapper.writeValue(resp.getOutputStream(), userModel);
				}
			}else {
				mapper.writeValue(resp.getOutputStream(), null);
			}
		}
}
