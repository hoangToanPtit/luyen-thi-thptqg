package com.luyenthithpt.dao;

import java.util.List;

import com.luyenthithpt.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	List<UserModel> findALL();
//	Integer getIdByUserNameAndPassword(String userName, String password);
//	String getRole(int userID);
	UserModel findById(int userId);
	int save(UserModel user);
}
