package com.luyenthithpt.model;

import java.util.ArrayList;
import java.util.List;

public class ExamModel {
	private int examID;
	private String name, subject, source;
	private int year, time, amount;
	private List<QuestionModel> questions;
	
	public ExamModel() {
		questions = new ArrayList<QuestionModel>();
	}
	
	public ExamModel(int examID) {
		this.examID = examID;
	}
	
	public ExamModel(int examID, String name, String subject, String source, int year, int time, int amount) {
		this.examID = examID;
		this.name = name;
		this.subject = subject;
		this.source = source;
		this.year = year;
		this.time = time;
		this.amount = amount;
	}
	
	public ExamModel(String name, String subject, String source, int year, int time, int amount) {
		this.name = name;
		this.subject = subject;
		this.source = source;
		this.year = year;
		this.time = time;
		this.amount = amount;
	}

	public int getExamID() {
		return examID;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public String getSource() {
		return source;
	}

	public int getYear() {
		return year;
	}

	public int getTime() {
		return time;
	}

	public int getAmount() {
		return amount;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}
	
	public void setQuestions(List<QuestionModel> questions) {
		this.questions = questions;
	}
	
	public List<QuestionModel> getQuestions() {
		return questions;
	}
}
