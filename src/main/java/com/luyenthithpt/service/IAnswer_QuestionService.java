package com.luyenthithpt.service;

import java.util.List;

import com.luyenthithpt.model.Answer_QuestionModel;

public interface IAnswer_QuestionService {
	void save(Answer_QuestionModel ans, int studentID, int examID);
	void delete(int examID, int studentID);
	List<Answer_QuestionModel> getAnswers(int stuId, int exId);
}
