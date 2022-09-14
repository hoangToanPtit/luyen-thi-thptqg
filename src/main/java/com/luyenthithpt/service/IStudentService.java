package com.luyenthithpt.service;

import java.util.List;

import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.UserModel;

public interface IStudentService {
	StudentModel save(UserModel studentModel);
	StudentModel getById(int id);
	List<StudentModel> getAllStudent();
	void update(UserModel studentModel);
	void delete(int studentId);
}
