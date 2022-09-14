package com.luyenthithpt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.luyenthithpt.model.ExamModel;

public class ExamMapper implements IMapper<ExamModel>{

	@Override
	public ExamModel map(ResultSet resultSet) {
		try {
			int examId = resultSet.getInt("Exam_ID");
			String name = resultSet.getString("Name");
			String subject = resultSet.getString("Subject");
			String source = resultSet.getString("Source");
			int year = resultSet.getInt("Year");
			int time = resultSet.getInt("Time");
			int amount = resultSet.getInt("Amount");
			//getClass and getTeacher
			return new ExamModel(examId, name, subject, source, year, time, amount);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
