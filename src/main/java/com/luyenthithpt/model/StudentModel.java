package com.luyenthithpt.model;

import java.util.ArrayList;
import java.util.List;

public class StudentModel extends UserModel {
	List<ClassModel> classes;
	List<ExamModel> exames;
	
	public StudentModel() {
		classes = new ArrayList<ClassModel>();
		exames = new ArrayList<ExamModel>();
	}

	public StudentModel(int userID) {
		super(userID);
		classes = new ArrayList<ClassModel>();
		exames = new ArrayList<ExamModel>();
	}

	
	public StudentModel(int userID, String email, String userName, String password, String role, String firstName,
			String lastName, String dateOfBirth) {
		super(userID, email, userName, password, role, firstName, lastName, dateOfBirth);
	}

	public StudentModel(String email, String userName, String password, String role, String firstName,
			String lastName, String dateOfBirth) {
		super(email, userName, password, role, firstName, lastName, dateOfBirth);
	}
	
	public List<ClassModel> getClasses() {
		return classes;
	}

	public List<ExamModel> getExames() {
		return exames;
	}
}
