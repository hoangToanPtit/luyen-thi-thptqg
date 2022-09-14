package com.luyenthithpt.service;

import com.luyenthithpt.model.UserModel;

public interface IUserService {
	Integer findId(String userName, String password);
	String getRoleById(int id);
	void delete(int userId);
	void update(UserModel userModel);
	UserModel getById(int id);
}
