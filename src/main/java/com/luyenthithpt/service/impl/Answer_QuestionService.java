package com.luyenthithpt.service.impl;

import java.util.List;

import com.luyenthithpt.dao.IAnswer_QuestionDAO;
import com.luyenthithpt.dao.impl.Answer_QuestionDAO;
import com.luyenthithpt.mapper.Answer_QuestionMapper;
import com.luyenthithpt.model.Answer_QuestionModel;
import com.luyenthithpt.service.IAnswer_QuestionService;

public class Answer_QuestionService implements IAnswer_QuestionService{
	
	private IAnswer_QuestionDAO dao = new Answer_QuestionDAO();
	
	@Override
	public void save(Answer_QuestionModel ans, int studentID, int examID) {
		String sql = "INSERT INTO `luyenthithptqg`.`answer_question` \r\n"
				+ "(`Exam_ID`, `Question_ID`, `Student_ID`, `Choice`, `Is_Correct`) \r\n"
				+ "VALUES (?, ?, ?, ?, ?);";
		dao.insert(sql, examID, ans.getQuestion().getQuestionID(), studentID,ans.getChoice(), ans.getIsCorrect());
	}

	@Override
	public void delete(int examID, int studentID) {
		String delSql2 = "DELETE FROM `luyenthithptqg`.`answer_question`\r\n"
				+ " WHERE (`Exam_ID` = ?) and (`Student_ID` = ?);";
		dao.update(delSql2, examID, studentID);
	}

	@Override
	public List<Answer_QuestionModel> getAnswers(int stuId, int exId) {
		String sql = "SELECT * FROM luyenthithptqg.answer_question\r\n"
				+ "where Student_ID=? and Exam_ID=?;";
		List<Answer_QuestionModel> res = dao.query(sql, new Answer_QuestionMapper(), stuId, exId);
		return res;
	}

}
