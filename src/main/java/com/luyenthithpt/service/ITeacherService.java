package com.luyenthithpt.service;

import com.luyenthithpt.model.TeacherModel;
import com.luyenthithpt.model.UserModel;

public interface ITeacherService {
	TeacherModel save(UserModel teacherModel);
	TeacherModel getById(int id);
}
