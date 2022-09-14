package com.luyenthithpt.dao.impl;

import java.util.List;

import com.luyenthithpt.dao.IUserDAO;
import com.luyenthithpt.mapper.UserMapper;
import com.luyenthithpt.model.UserModel;

public class UserDAO extends GenericDAO<UserModel> implements IUserDAO{

	@Override
	public List<UserModel> findALL() {
		String sql = "Select * from user";
		return query(sql, new UserMapper());
	}

//	@Override
//	public Integer getIdByUserNameAndPassword(String userName, String password) {
//		String sql = "SELECT User_ID FROM user where UserName= ? and Password= ?;";
//		return (Integer) getAttribute(sql, userName, password);
//	}
//
//	@Override
//	public String getRole(int userID) {
//		String sql = "SELECT Role FROM user where User_ID = ?";
//		return (String) getAttribute(sql, userID);
//	}

	@Override
	public int save(UserModel user) {
		String sql = "INSERT INTO user (Email, UserName, Password, Role)\r\n"
				+ " VALUES (?, ?, ?, ?);";
		return insert(sql, user.getEmail(), user.getUserName(), user.getPassword(), user.getRole());
	}

	@Override
	public UserModel findById(int userId) {
		String sql = "SELECT * FROM luyenthithptqg.user where User_ID=?;";
		return findOne(sql, new UserMapper(), userId);
	}

}
