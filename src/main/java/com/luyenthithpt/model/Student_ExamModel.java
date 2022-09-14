package com.luyenthithpt.model;

import java.util.ArrayList;
import java.util.List;

public class Student_ExamModel {
	private StudentModel student;
	private ExamModel exam;
	private List<Answer_QuestionModel> answerQuestions;
	private int submitTime;
	private float score;
	
	public Student_ExamModel() {
		student = new StudentModel();
		exam = new ExamModel();
		answerQuestions = new ArrayList<Answer_QuestionModel>();
	}
	
	public Student_ExamModel(ExamModel exam, int submitTime) {
		super();
		this.exam = exam;
		this.submitTime = submitTime;
	}


	public Student_ExamModel(ExamModel examModel, List<Answer_QuestionModel> answer_QuestionModels, int submitTime) {
		super();
		this.exam = examModel;
		this.answerQuestions = answer_QuestionModels;
		this.submitTime = submitTime;
	}


	
	
	public StudentModel getStudent() {
		return student;
	}


	public void setStudent(StudentModel studentModel) {
		this.student = studentModel;
	}


	public ExamModel getExam() {
		return exam;
	}


	public List<Answer_QuestionModel> getAnswerQuestions() {
		return answerQuestions;
	}


	public float getScore() {
		return score;
	}


	public int getSubmitTime() {
		return submitTime;
	}


	public void setExam(ExamModel exam) {
		this.exam = exam;
	}


	public void setAnswerQuestions(List<Answer_QuestionModel> answer_QuestionModels) {
		this.answerQuestions = answer_QuestionModels;
	}


	public void setScore(float score) {
		this.score = score;
	}


	public void setSubmitTime(int submitTime) {
		this.submitTime = submitTime;
	}


	@Override
	public String toString() {
		return "Student_ExamModel [examModel=" + exam + ", answer_QuestionModels=" + answerQuestions
				+ ", score=" + score + ", submitTime=" + submitTime + "]";
	}
	
	
	

}
