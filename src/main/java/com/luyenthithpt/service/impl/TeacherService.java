package com.luyenthithpt.service.impl;

import com.luyenthithpt.dao.ITeacherDAO;
import com.luyenthithpt.dao.impl.TeacherDAO;
import com.luyenthithpt.model.TeacherModel;
import com.luyenthithpt.model.UserModel;
import com.luyenthithpt.service.ITeacherService;

public class TeacherService implements ITeacherService{
	private ITeacherDAO teacherDAO = new TeacherDAO();
	
	@Override
	public TeacherModel save(UserModel teacherModel) {
		int id = teacherDAO.save(teacherModel);
		if(id<0) return null;
		return teacherDAO.findById(id);
	}

	@Override
	public TeacherModel getById(int id) {
		return teacherDAO.findById(id);
	}
	
}
