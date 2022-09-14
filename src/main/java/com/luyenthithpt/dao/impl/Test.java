package com.luyenthithpt.dao.impl;

import com.luyenthithpt.model.StudentModel;
import com.luyenthithpt.model.UserModel;

public class Test {
	public static void main(String[] args) {
//		UserDAO userDao = new UserDAO();
//		List<UserModel> userModels = userDao.findALL();
//		
//		for (UserModel userModel : userModels) {
//			System.out.println(userModel.getUserName());
//		}
		UserModel userModel = new UserModel();
		StudentModel stu = ((StudentModel)userModel);
		System.out.println(stu==userModel);
		
	}
}
