package com.luyenthithpt.service.impl;

import java.util.List;

import com.luyenthithpt.dao.IExamDAO;
import com.luyenthithpt.dao.impl.ExamDAO;
import com.luyenthithpt.mapper.ExamMapper;
import com.luyenthithpt.model.ExamModel;
import com.luyenthithpt.service.IExamService;
import com.luyenthithpt.service.IQuestionService;

public class ExamService implements IExamService{

	private IExamDAO examDAO = new ExamDAO();
	private IQuestionService questionService = new QuestionService();
	
	@Override
	public ExamModel getById(int examId) {
		String sql = "select * from exam where Exam_ID=?;";
		ExamModel examModel = examDAO.findOne(sql, new ExamMapper(), examId);
		examModel.setQuestions(questionService.getAllQuestionsByExamId(examId));
		return examModel;
	}

	@Override
	public Integer save(ExamModel examModel) {
		String sql = "INSERT INTO exam (Name, Subject, Source, Year, Time, Amount, Class_ID, Teacher_ID)\r\n"
				+ " VALUES (?, ?, ?, ?, ?, ?, null, null);";
		Integer id = examDAO.insert(sql, examModel.getName(), examModel.getSubject(), examModel.getSource(), 
				examModel.getYear(), examModel.getTime(), examModel.getAmount());
		if(id==null) return null;
		examModel.setExamID(id);
		return id;
	}

	@Override
	public void update(ExamModel examModel) {
		String sql = "UPDATE exam\r\n"
				+ "SET Name = ?, Subject = ?, Source = ?, Year = ?, Time = ?, Amount = ?, Class_ID = null, Teacher_ID=null\r\n"
				+ "WHERE (Exam_ID = ?);";
		examDAO.update(sql, examModel.getName(), examModel.getSubject(), examModel.getSource(), 
				examModel.getYear(), examModel.getTime(), examModel.getAmount(), examModel.getExamID());
	}

	@Override
	public void delete(int examId) {
		String sql = "delete from exam where Exam_ID=?;";
		examDAO.update(sql, examId); 
	}

	@Override
	public List<ExamModel> getListExam() {
		String sql = "SELECT * FROM luyenthithptqg.exam;";
		return examDAO.query(sql, new ExamMapper());
	}
	
	@Override
	public List<ExamModel> getListExamBySubject(String subject) {
		String sql = "SELECT * FROM luyenthithptqg.exam where Subject=?;";
		return examDAO.query(sql, new ExamMapper(), subject);
	}

}
