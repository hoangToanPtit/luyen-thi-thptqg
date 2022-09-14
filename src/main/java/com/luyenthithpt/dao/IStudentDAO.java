package com.luyenthithpt.dao;

import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.UserModel;

public interface IStudentDAO extends IGenericDAO<StudentModel>{
	StudentModel findById(int studenId);
	int save(UserModel studentModel);
	int update(UserModel studentModel);
}
