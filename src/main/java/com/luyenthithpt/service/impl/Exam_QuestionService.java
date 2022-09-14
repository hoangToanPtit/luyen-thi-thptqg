package com.luyenthithpt.service.impl;

import com.luyenthithpt.dao.IExam_QuestionDAO;
import com.luyenthithpt.dao.impl.Exam_QuestonDAO;
import com.luyenthithpt.service.IExam_QuestionService;

public class Exam_QuestionService implements IExam_QuestionService{

	private IExam_QuestionDAO examQuestionDAO = new Exam_QuestonDAO();
	
	@Override
	public void addQuestionIntoExam(int examId, int questionId) {
		String sql = "insert into exam_question (Exam_ID, Question_ID)\r\n"
				+ "values(?, ?);";
		examQuestionDAO.insert(sql, examId, questionId);
	}

}
