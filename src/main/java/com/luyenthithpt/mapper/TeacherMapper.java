package com.luyenthithpt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.luyenthithpt.model.TeacherModel;

public class TeacherMapper implements IMapper<TeacherModel>{

	@Override
	public TeacherModel map(ResultSet resultSet) {
		try {
			int userID = resultSet.getInt("id");
			String email = resultSet.getString("Email");
			String userName = resultSet.getString("UserName");
			String password = resultSet.getString("Password");
			String role = resultSet.getString("Role");
			String firstName = resultSet.getString("FirstName");
			String lastName = resultSet.getString("LastName");
			Date dob = new Date(resultSet.getDate("DOB").getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dateOfBirth = sdf.format(dob);
			return new TeacherModel(userID, email, userName, password, role, firstName, lastName, dateOfBirth);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
