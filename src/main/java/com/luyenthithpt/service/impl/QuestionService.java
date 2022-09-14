package com.luyenthithpt.service.impl;

import java.util.List;

import com.luyenthithpt.dao.IQuestionDAO;
import com.luyenthithpt.dao.impl.QuestionDAO;
import com.luyenthithpt.mapper.QuestionMapper;
import com.luyenthithpt.model.QuestionModel;
import com.luyenthithpt.service.IQuestionService;

public class QuestionService implements IQuestionService{
	private IQuestionDAO questionDAO = new QuestionDAO();
	
	@Override
	public Integer save(QuestionModel questionModel) {
		String sql = "INSERT INTO question (Description, selection1, selection2, selection3, selection4, answer) \r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		Integer id = questionDAO.insert(sql, questionModel.getDescription(), questionModel.getSelection1(), questionModel.getSelection2(),
				questionModel.getSelection3(), questionModel.getSelection4(), questionModel.getAnswer());
		if(id==null) return null;
		questionModel.setQuestionID(id);
		return id;
	}

	@Override
	public void update(QuestionModel questionModel) {
		String sql = "UPDATE question \r\n"
				+ "SET Description = ?, selection1 = ?, selection2 = ?, selection3 = ?, selection4 = ?, answer = ? \r\n"
				+ "WHERE (`Question_ID` = ?);";
		questionDAO.update(sql, questionModel.getDescription(), questionModel.getSelection1(), questionModel.getSelection2(),
				questionModel.getSelection3(), questionModel.getSelection4(),questionModel.getAnswer(), questionModel.getQuestionID());
	}

	@Override
	public void delete(int questionID) {
		String sql= "DELETE FROM question WHERE (Question_ID = ?);";
		questionDAO.update(sql, questionID);
	}

	@Override
	public QuestionModel getById(int questionId) {
		String sql = "Select * from question where Question_ID = ?";
		return questionDAO.findOne(sql, new QuestionMapper(), questionId);
	}

	@Override
	public List<QuestionModel> getAllQuestionsByExamId(int examID) {
		String sql = "select question.Question_ID, question.Description, question.selection1, \r\n"
				+ "question.selection2, question.selection3, question.selection4, question.answer\r\n"
				+ "from question, exam_question\r\n"
				+ "where question.Question_ID =  exam_question.Question_ID\r\n"
				+ "	and exam_question.Exam_ID = ?;";
		return questionDAO.query(sql, new QuestionMapper(), examID);
	}

}
