package com.luyenthithpt.dao.impl;

import com.luyenthithpt.dao.ITeacherDAO;
import com.luyenthithpt.mapper.TeacherMapper;
import com.luyenthithpt.model.TeacherModel;
import com.luyenthithpt.model.UserModel;

public class TeacherDAO extends GenericDAO<TeacherModel> implements ITeacherDAO{

	@Override
	public TeacherModel findById(int teacherId) {
		String sql = "SELECT user.User_ID as id, user.UserName, user.Password, user.Email, user.Role,\r\n"
				+ "teacher.FirstName, teacher.LastName, teacher.DOB\r\n"
				+ "  FROM user, teacher where Teacher_ID = User_ID and User_ID = ?;";
		return findOne(sql, new TeacherMapper(), teacherId);
	}

	@Override
	public int save(UserModel teacherModel) {
		int id =  new UserDAO().save((UserModel) teacherModel);
		String sql = "INSERT INTO Teacher (Teacher_ID, FirstName, LastName, DOB) \r\n"
				+ "VALUES (?, ?, ?, ?);";
		update(sql, id, teacherModel.getFirstName(), teacherModel.getLastName(), teacherModel._getDOB());
		return id;
	}
	

}
