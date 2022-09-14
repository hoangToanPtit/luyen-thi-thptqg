package com.luyenthithpt.service;

import java.util.List;

import com.luyenthithpt.model.Student_ExamModel;

public interface IStudent_ExamService {
	Student_ExamModel save(Student_ExamModel student_exam);
	Student_ExamModel getByStudentIdAndExamId(int stuId, int examId);
	List<Student_ExamModel> getStudentExamByStudentID(int stuId);
}
