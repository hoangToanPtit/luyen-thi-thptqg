package com.luyenthithpt.service;

import java.util.List;

import com.luyenthithpt.model.ExamModel;

public interface IExamService {
	List<ExamModel> getListExam();
	ExamModel getById(int examId);
	Integer save(ExamModel examModel);
	void update(ExamModel examModel);
	void delete(int examId);
	List<ExamModel> getListExamBySubject(String subject);
}
