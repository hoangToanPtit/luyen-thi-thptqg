package com.luyenthithpt.dao.impl;

import com.luyenthithpt.dao.IStudentDAO;
import com.luyenthithpt.mapper.StudentMapper;
import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.UserModel;

public class StudentDAO extends GenericDAO<StudentModel> implements IStudentDAO{

	@Override
	public StudentModel findById(int studenId) {
		String sql = "SELECT user.User_ID as id , user.UserName, user.Password, user.Email, user.Role,\r\n"
				+ "student.FirstName, student.LastName, student.DOB\r\n"
				+ "  FROM user, student where Student_ID = User_ID and User_ID = ?;";
		return findOne(sql, new StudentMapper(), studenId);
	}
	
	@Override
	public int save(UserModel studentModel) {
		int id =  new UserDAO().save(studentModel);
		String sql = "INSERT INTO student (Student_ID, FirstName, LastName, DOB) \r\n"
				+ "VALUES (?, ?, ?, ?);";
		update(sql, id, studentModel.getFirstName(), studentModel.getLastName(), studentModel._getDOB());
		return id;
	}

	@Override
	public int update(UserModel studentModel) {
		String sql = "UPDATE `luyenthithptqg`.`student` \r\n"
				+ "SET `FirstName` = ?, `LastName` = ?, `DOB` = ? \r\n"
				+ "WHERE (`Student_ID` = ?);";
		update(sql, studentModel.getFirstName(), studentModel.getLastName(),
				studentModel._getDOB(), studentModel.getUserID());
		return studentModel.getUserID();
	}

}
