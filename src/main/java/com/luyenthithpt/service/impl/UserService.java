package com.luyenthithpt.service.impl;

import com.luyenthithpt.dao.IUserDAO;
import com.luyenthithpt.dao.impl.UserDAO;
import com.luyenthithpt.model.UserModel;
import com.luyenthithpt.service.IUserService;

public class UserService implements IUserService{
	private IUserDAO userDAO = new UserDAO();
	
	@Override
	public Integer findId(String userName, String password) {
		String sql = " select User_ID from user \r\n"
				+ " where UserName= ? and Password= ? ;";
		return (Integer) userDAO.getAttribute(sql, userName, password);
	}

	@Override
	public String getRoleById(int id) {
		String sql = " select Role from user \r\n"
				+ " where User_ID=?;";
		return (String) userDAO.getAttribute(sql,  id);
	}

	@Override
	public void delete(int userId) {
		String sql = "delete from user where User_ID = ?;\r\n";
		userDAO.update(sql, userId);
	}

	@Override
	public void update(UserModel userModel) {
		String sql = "UPDATE user SET Email = ?, UserName = ?,\r\n"
				+ " Password = ?, Role = ? WHERE (User_ID = ?);";
		
		userDAO.update(sql, userModel.getEmail(), userModel.getUserName(), userModel.getPassword(),
				userModel.getRole(), userModel.getUserID());
	}

	@Override
	public UserModel getById(int id) {
		return userDAO.findById(id);
	}

}
