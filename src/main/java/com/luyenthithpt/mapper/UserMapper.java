package com.luyenthithpt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.luyenthithpt.model.UserModel;

public class UserMapper implements IMapper<UserModel>{

	@Override
	public UserModel map(ResultSet resultSet) {
		
		try {
			int userID = resultSet.getInt("User_ID");
			String email = resultSet.getString("Email");
			String userName = resultSet.getString("UserName");
			String password = resultSet.getString("Password");
			String role = resultSet.getString("Role");
			return new UserModel(userID, email, userName, password, role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
