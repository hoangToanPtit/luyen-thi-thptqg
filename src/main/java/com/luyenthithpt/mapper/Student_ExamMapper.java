package com.luyenthithpt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.luyenthithpt.model.Student_ExamModel;

public class Student_ExamMapper implements IMapper<Student_ExamModel>{

	@Override
	public Student_ExamModel map(ResultSet resultSet) {
		try {
			int stuId = resultSet.getInt("Student_ID");
			int examId = resultSet.getInt("Exam_ID");
			Float score = resultSet.getFloat("Score");
			int submitTime = resultSet.getInt("Submit_Time");
			Student_ExamModel student_exam = new Student_ExamModel();
			student_exam.getStudent().setUserID(stuId);
			student_exam.getExam().setExamID(examId);
			student_exam.setScore(score);
			student_exam.setSubmitTime(submitTime);
			return student_exam;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
