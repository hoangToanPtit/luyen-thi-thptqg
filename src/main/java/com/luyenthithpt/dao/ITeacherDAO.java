package com.luyenthithpt.dao;

import com.luyenthithpt.model.TeacherModel;
import com.luyenthithpt.model.UserModel;

public interface ITeacherDAO extends IGenericDAO<TeacherModel>{
	TeacherModel findById(int teacherId);
	int save(UserModel teacherModel);
}
