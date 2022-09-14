package com.luyenthithpt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.luyenthithpt.model.QuestionModel;

public class QuestionMapper implements IMapper<QuestionModel>{

	@Override
	public QuestionModel map(ResultSet resultSet) {
		try {
			int questionID = resultSet.getInt("Question_ID");
			int answer = resultSet.getInt("answer");
			String description = resultSet.getString("Description");
			String selection1 = resultSet.getString("selection1");
			String selection2 = resultSet.getString("selection2");
			String selection3 = resultSet.getString("selection3");
			String selection4 = resultSet.getString("selection4");
			return new QuestionModel(questionID, description, selection1, selection2, selection3, selection4, answer);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
