package com.luyenthithpt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.luyenthithpt.model.Answer_QuestionModel;

public class Answer_QuestionMapper implements IMapper<Answer_QuestionModel>{

	@Override
	public Answer_QuestionModel map(ResultSet resultSet) {
		try {
			int choice = resultSet.getInt("Choice");
			int isCorrect = resultSet.getInt("Is_Correct");
			int questionId = resultSet.getInt("Question_ID");
			Answer_QuestionModel ans_qes = new Answer_QuestionModel();
			ans_qes.setChoice(choice);
			ans_qes.setIsCorrect(isCorrect);
			ans_qes.getQuestion().setQuestionID(questionId);
			return ans_qes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
