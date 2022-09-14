package com.luyenthithpt.service.impl;

import java.util.List;

import com.luyenthithpt.dao.IStudentDAO;
import com.luyenthithpt.dao.impl.StudentDAO;
import com.luyenthithpt.mapper.StudentMapper;
import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.UserModel;
import com.luyenthithpt.service.IStudentService;
import com.luyenthithpt.service.IUserService;

public class StudentService implements IStudentService {
	private IStudentDAO studentDAO = new StudentDAO();
	private IUserService userService = new UserService();
	
	@Override
	public StudentModel save(UserModel studentModel) {
		int id=-1;
		if(studentModel.getUserID()>0) {
			id = studentModel.getUserID();
			studentDAO.update(studentModel);
		}else {
			id = studentDAO.save(studentModel);			
		}
		if(id<0) return null;
		return studentDAO.findById(id);
	}

	@Override
	public StudentModel getById(int id) {
		return studentDAO.findById(id);
	}

	@Override
	public List<StudentModel> getAllStudent() {
		String sql = "select user.User_ID as id, student.FirstName, student.LastName, student.DOB,\r\n"
				+ "user.Email, user.UserName, user.Password, role from user, student\r\n"
				+ "where user.User_ID = student.Student_ID";
		return studentDAO.query(sql, new StudentMapper());
	}

	@Override
	public void update(UserModel studentModel) {
		userService.update(studentModel);
		
		String sql = "UPDATE `luyenthithptqg`.`student` SET `FirstName` = ?, `LastName` = ?,\r\n"
				+ " `DOB` = ? WHERE (`Student_ID` = ?);\r\n";
		studentDAO.update(sql, studentModel.getFirstName(), studentModel.getLastName(), 
				studentModel._getDOB(), studentModel.getUserID());
	}

	@Override
	public void delete(int studentId) {
		userService.delete(studentId);
	}
}
