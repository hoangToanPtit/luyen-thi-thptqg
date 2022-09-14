package com.luyenthithpt.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserModel {
	private int userID;
	private String email, userName, password, role, firstName, lastName, dateOfBirth;
//	private Date dateOfBirth;

	public UserModel() {
	}
	
	public UserModel(int userID) {
		this.userID = userID;
	}	
	
	public UserModel(int userID, String email, String userName, String password, String role) {
		super();
		this.userID = userID;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public UserModel(int userID, String email, String userName, String password, String role, String firstName,
			String lastName, String dateOfBirth) {
		super();
		this.userID = userID;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public UserModel( String email, String userName, String password, String role, String firstName,
			String lastName, String dateOfBirth) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public int getUserID() {
		return userID;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public Date _getDOB() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserModel [userID=" + userID + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", role=" + role + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
	

}
