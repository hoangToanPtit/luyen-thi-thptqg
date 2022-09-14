package com.luyenthithpt.service;

import java.util.List;

import com.luyenthithpt.model.QuestionModel;

public interface IQuestionService {
	QuestionModel getById(int questionId);
	Integer save(QuestionModel questionModel);
	void update(QuestionModel questionModel);
	void delete(int questionID);
	List<QuestionModel> getAllQuestionsByExamId(int examID);
}
