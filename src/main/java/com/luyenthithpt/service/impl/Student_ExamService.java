package com.luyenthithpt.service.impl;

import java.util.List;

import com.luyenthithpt.dao.IStudent_ExamDAO;
import com.luyenthithpt.dao.impl.Student_ExamDAO;
import com.luyenthithpt.mapper.Student_ExamMapper;
import com.luyenthithpt.model.Answer_QuestionModel;
import com.luyenthithpt.model.Student_ExamModel;
import com.luyenthithpt.service.IAnswer_QuestionService;
import com.luyenthithpt.service.IExamService;
import com.luyenthithpt.service.IStudent_ExamService;

public class Student_ExamService implements IStudent_ExamService{

	private IStudent_ExamDAO student_examDAO = new Student_ExamDAO();
	private IAnswer_QuestionService answer_QuestionService = new Answer_QuestionService();
	private IExamService examService = new ExamService();
	
	@Override
	public Student_ExamModel save(Student_ExamModel student_exam) {
		// kiem tra, xoa bai da lam cu		
		String sql1 = "select Student_ID from student_exam \r\n"
				+ "where Student_ID = ? and Exam_ID = ?;";
		Integer existedId = (Integer) student_examDAO.getAttribute(sql1, student_exam.getStudent().getUserID(),
				student_exam.getExam().getExamID());
		
		if(existedId!=null) {
			String delSql = "DELETE FROM `luyenthithptqg`.`student_exam` \r\n"
					+ "WHERE (`Exam_ID` = ?) and (`Student_ID` = ?);";
			student_examDAO.update(delSql, student_exam.getExam().getExamID(), 
				student_exam.getStudent().getUserID());
			
			answer_QuestionService.delete(student_exam.getExam().getExamID(), 
				student_exam.getStudent().getUserID());
			
		}
		
		// luu bai lam moi nhat		
		String sql2 = "INSERT INTO `luyenthithptqg`.`student_exam` \r\n"
				+ "(`Exam_ID`, `Student_ID`, `Submit_Time`) VALUES (?, ?, ?);";
		student_examDAO.update(sql2, student_exam.getExam().getExamID(), 
				student_exam.getStudent().getUserID(), student_exam.getSubmitTime());
		
		
		int countCor = 0; // so cau tra loi dung
		// luu cac cau tra loi
		for (Answer_QuestionModel ans : student_exam.getAnswerQuestions()) {
			int isCorrect = 0;
			if(ans.getQuestion().getAnswer()==ans.getChoice()) {
				isCorrect=1;
				countCor++;
			}
			ans.setIsCorrect(isCorrect);
			answer_QuestionService.save(ans, student_exam.getStudent().getUserID(),
					student_exam.getExam().getExamID());
		}
		float score = 10.0f/student_exam.getExam().getAmount()*countCor;
		student_exam.setScore(score);
		
		// luu diem vao db
		String sql3 = "UPDATE `luyenthithptqg`.`student_exam` SET `Score` = ? \r\n"
				+ "WHERE (`Exam_ID` = ?) and (`Student_ID` = ?);";
		student_examDAO.update(sql3, score, student_exam.getExam().getExamID(), 
				student_exam.getStudent().getUserID());	
		
		student_exam.setAnswerQuestions(null);
		student_exam.getExam().setQuestions(null);
		
		return student_exam;
	}

	@Override
	public Student_ExamModel getByStudentIdAndExamId(int stuId, int examId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM luyenthithptqg.student_exam \r\n"
				+ "where Student_ID= ? and Exam_ID= ?;";
		Student_ExamModel student_examModel = student_examDAO.findOne(sql, new Student_ExamMapper(), stuId, examId);
		student_examModel.setAnswerQuestions(answer_QuestionService.getAnswers(stuId, examId));
		student_examModel.setExam(examService.getById(examId));
		
		return student_examModel;
	}

	@Override
	public List<Student_ExamModel> getStudentExamByStudentID(int stuId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM luyenthithptqg.student_exam \r\n"
				+ "where Student_ID=?;";
		List<Student_ExamModel> res = student_examDAO.query(sql, new Student_ExamMapper(), stuId);
		for (Student_ExamModel s : res) {
			s.setExam(examService.getById(s.getExam().getExamID()));
		}
		return res;
	}


}
