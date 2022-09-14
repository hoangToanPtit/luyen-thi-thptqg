package com.luyenthithpt.model;

import java.util.ArrayList;
import java.util.List;

public class TeacherModel extends UserModel{
    private List<ClassModel> classes;
    
	public TeacherModel() {
		classes = new ArrayList<ClassModel>();
	}

	public TeacherModel(int userID, String email, String userName, String password, String role, String firstName,
			String lastName, String dateOfBirth) {
		super(userID, email, userName, password, role, firstName, lastName, dateOfBirth);
	}
}
